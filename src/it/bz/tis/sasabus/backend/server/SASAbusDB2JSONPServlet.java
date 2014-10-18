/*
SASAbusBackend - SASA bus JSON services

Copyright (C) 2013 TIS Innovation Park - Bolzano/Bozen - Italy
Copyright (C) 2014 Davide Montesin <d@vide.bz> - Bolzano/Bozen - Italy

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as
published by the Free Software Foundation, either version 3 of the
License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

package it.bz.tis.sasabus.backend.server;

import it.bz.tis.sasabus.backend.server.sasabusdb.SASAbusDBFromSqliteLoader;
import it.bz.tis.sasabus.backend.server.sasabusdb.SASAbusDBServerImpl;
import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusTripStopList;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendMarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusDB;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.SASAbusDBLastModified;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bz.davide.dmxmljson.marshalling.json.JSONStructure;

@SuppressWarnings("serial")
public class SASAbusDB2JSONPServlet extends HttpServlet
{

   protected final JSONPServletData data         = new JSONPServletData();

   SASAbusBackendMarshaller         marshaller   = new SASAbusBackendMarshaller();

   protected boolean                initFinished = false;

   File                             local_md5_file;
   File                             local_db_file;
   URL                              remote_md5_url;
   URL                              remote_db_url;

   Thread                           checkUpdateThread;

   String                           smtpPass;

   @Override
   public void init(ServletConfig config) throws ServletException
   {
      try
      {
         super.init(config);

         File smtpPassFile = new File(this.getServletContext().getRealPath("/WEB-INF/smtp.txt"));
         this.smtpPass = new String(this.readInputStreamBytesAndClose(new FileInputStream(smtpPassFile)),
                                    "us-ascii");

         this.sendMail("SASAbusDB2JSONPServlet: init", "");

         this.remote_md5_url = new URL("ftp://getANdata:jogYgoD9%2E8Zo7@cms.sasabz.it/SASAbus_v2.db.md5");
         this.remote_db_url = new URL("ftp://getANdata:jogYgoD9%2E8Zo7@cms.sasabz.it/SASAbus_v2.db");

         this.local_md5_file = new File(this.getServletContext().getRealPath("/WEB-INF/SASAbus_v2.db.md5"));
         this.local_db_file = new File(this.getServletContext().getRealPath("/WEB-INF/SASAbus_v2.db"));

         long start = System.currentTimeMillis();
         this.data.sasabusdb = SASAbusDBFromSqliteLoader.load(this.local_db_file);
         long stop = System.currentTimeMillis();

         this.checkUpdateThread = new Thread(new Runnable()
         {
            @Override
            public void run()
            {
               try
               {
                  int count = 0;
                  while (true)
                  {
                     for (int i = 0; i < 6; i++)
                     {
                        Thread.sleep(1000L * 60L * 10L);
                        System.gc();
                     }

                     if (count < 3)
                     {
                        count++;
                        SASAbusDB2JSONPServlet.this.sendMail("checkUpdateThread: sleep count", "count: " + count);
                     }
                     try
                     {
                        boolean update = SASAbusDB2JSONPServlet.this.checkDatabaseUpdate();
                        if (update)
                        {
                           SASAbusDBServerImpl sasabusdb = SASAbusDBFromSqliteLoader.load(SASAbusDB2JSONPServlet.this.local_db_file);
                           synchronized (SASAbusDB2JSONPServlet.this.data)
                           {
                              SASAbusDB2JSONPServlet.this.data.sasabusdb = sasabusdb;
                           }
                           SASAbusDB2JSONPServlet.this.sendMail("checkUpdateThread: sasabusdb new version is online",
                                                                "");
                        }
                     }
                     catch (Exception e)
                     {
                        SASAbusDB2JSONPServlet.this.sendMail("checkUpdateThread: while Exception", e);
                        e.printStackTrace();
                     }

                  }
               }
               catch (InterruptedException e)
               {
                  SASAbusDB2JSONPServlet.this.sendMail("checkUpdateThread: Interrupted", "");
               }
            }
         });

         this.checkUpdateThread.start();

         synchronized (this.data)
         {
            this.initFinished = true;
         }

      }
      catch (Exception exxx)
      {
         throw new ServletException(exxx);
      }
   }

   @Override
   public void destroy()
   {
      super.destroy();
      this.sendMail("SASAbusDB2JSONPServlet: destroy", "");
      // Stop the check thread!
      this.checkUpdateThread.interrupt();
      try
      {
         this.checkUpdateThread.join();// wait finish (i.e. interrupted during download ...
      }
      catch (InterruptedException e)
      {
         SASAbusDB2JSONPServlet.this.sendMail("SASAbusDB2JSONPServlet: destroy Exception", e);
         e.printStackTrace();
      }
   }

   void sendMail(String subject, Throwable txxx)
   {
      StringWriter stringWriter = new StringWriter();
      PrintWriter pw = new PrintWriter(stringWriter);
      txxx.printStackTrace(pw);
      pw.close();
      this.sendMail(subject, stringWriter.getBuffer().toString());
   }

   protected void sendMail(String subject, String body)
   {
      // Don't send e-mail if password is empty/missing
      if (this.smtpPass.trim().length() == 0)
      {
         return;
      }

      try
      {
         Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.socketFactory.port", "465");
         props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.port", "465");

         final String accountName = "davidebz.smtp@gmail.com";

         Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
         {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
               return new PasswordAuthentication(accountName, SASAbusDB2JSONPServlet.this.smtpPass);
            }
         });

         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(accountName));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("d@vide.bz"));
         message.setSubject("[SASAbus-Backend] " + subject);
         message.setText(body);

         Transport.send(message);
      }
      catch (Exception exxx)
      {
         exxx.printStackTrace();
         throw new RuntimeException(exxx);
      }
   }

   boolean checkDatabaseUpdate() throws IOException
   {
      byte[] remote_md5_bytes = this.readInputStreamBytesAndClose(this.remote_md5_url.openStream());
      String remotemd5 = new String(remote_md5_bytes, "us-ascii");
      String localmd5 = new String(this.readInputStreamBytesAndClose(new FileInputStream(this.local_md5_file)),
                                   "us-ascii");
      if (!remotemd5.equals(localmd5))
      {
         byte[] data = this.readInputStreamBytesAndClose(this.remote_db_url.openStream());
         FileOutputStream fileOutputStream = new FileOutputStream(this.local_db_file);
         fileOutputStream.write(data);
         fileOutputStream.close();

         fileOutputStream = new FileOutputStream(this.local_md5_file);
         fileOutputStream.write(remote_md5_bytes);
         fileOutputStream.close();

         this.sendMail("CheckDatabaseUpdate: new db version", remotemd5);

         return true;
      }
      return false;
   }

   byte[] readInputStreamBytesAndClose(InputStream is) throws IOException
   {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      int len;
      byte[] buf = new byte[100000];
      while ((len = is.read(buf)) > 0)
      {
         byteArrayOutputStream.write(buf, 0, len);
      }
      is.close();
      return byteArrayOutputStream.toByteArray();
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      boolean localInitFinished;
      SASAbusDB sasabusdb;
      synchronized (this.data)
      {
         localInitFinished = this.initFinished;
         sasabusdb = this.data.sasabusdb;
      }
      if (localInitFinished == false)
      {
         throw new ServletException(new IllegalStateException("Init not finished!"));
      }

      try
      {

         String path = req.getPathInfo();
         // No subdirectory provided
         if (path == null)
         {
            path = "";
         }
         final Object[] result = new Object[] { null };
         /*
         if (path.equals("/gc"))
         {
            System.gc();
            resp.getWriter().write("gc!");
            return;
         }
         if (path.equals("/heap"))
         {
            byte[] memory = new byte[200000000];
            Thread.sleep(15000);
            resp.getWriter().write("heap!");
            return;
         }
         */
         if (path.equals("/listBusAreasLinesStopsStations"))
         {
            sasabusdb.listBusAreasLinesStopsStations(new SASAbusDBDataReady<AreaList>()
            {
               @Override
               public void ready(AreaList data)
               {
                  result[0] = data;
               }
            });
         }
         if (path.equals("/lastModified"))
         {
            sasabusdb.lastModified(new SASAbusDBDataReady<SASAbusDBLastModified>()
            {
               @Override
               public void ready(SASAbusDBLastModified data)
               {
                  result[0] = data;
               }
            });
         }
         if (path.equals("/findBusStationDepartures"))
         {
            String busStationId = req.getParameter("busStationId");
            long yyyymmddhhmm = Long.parseLong(req.getParameter("yyyymmddhhmm"));
            sasabusdb.findBusStationDepartures(busStationId,
                                               yyyymmddhhmm,
                                               new SASAbusDBDataReady<BusTripStopList>()
                                               {
                                                  @Override
                                                  public void ready(BusTripStopList data)
                                                  {
                                                     result[0] = data;
                                                  }
                                               });

         }
         if (path.equals("/calcRoute"))
         {
            String startBusStationId = req.getParameter("startBusStationId");
            String endBusStationId = req.getParameter("endBusStationId");
            long yyyymmddhhmm = Long.parseLong(req.getParameter("yyyymmddhhmm"));
            sasabusdb.calcRoute(startBusStationId, endBusStationId, yyyymmddhhmm, new SASAbusDBDataReady<ConRes>()
            {
               @Override
               public void ready(ConRes data)
               {
                  result[0] = data;
               }
            });

         }
         if (path.equals("/nextRoute"))
         {
            String context = req.getParameter("context");
            sasabusdb.nextRoute(context, new SASAbusDBDataReady<ConRes>()
            {
               @Override
               public void ready(ConRes data)
               {
                  result[0] = data;
               }
            });

         }
         if (result[0] != null)
         {
            long start2 = System.currentTimeMillis();
            JSONStructure jsonStructure = new JSONStructure(0);
            this.marshaller.marschall(result[0], jsonStructure);
            resp.setContentType("application/javascript; charset=utf-8");
            resp.setDateHeader("Last-Modified", System.currentTimeMillis());
            String callback = req.getParameter("callback");
            String responseText = callback + "(" + jsonStructure.toString() + ");";

            long stop2 = System.currentTimeMillis();

            if (req.getParameter("bz.davide.dmweb.noout") != null) // used for stress test only!
            {
               resp.getOutputStream().write(("{ ok: " + responseText.length() + "; }").getBytes("utf-8"));
            }
            else
            {
               resp.getOutputStream().write(responseText.getBytes("utf-8"));
            }

            long stop3 = System.currentTimeMillis();

            return;
         }
         throw new ServletException("No result! " + path);

      }
      catch (Exception exxx)
      {
         this.sendMail("doGet: Exception", exxx);
         throw new ServletException(exxx);
      }
   }
}
