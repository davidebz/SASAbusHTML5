/*
SASAbusBackend - SASA bus JSON services

Copyright (C) 2013 TIS Innovation Park - Bolzano/Bozen - Italy

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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class ParkingServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                                                                         IOException
   {
      try
      {

         String uri = req.getPathInfo();
         String url = "http://ipchannels.integreen-life.bz.it/parkingFrontEnd/rest" +
                      uri +
                      "?" +
                      req.getQueryString();
         URL newsUrl = new URL(url);
         InputStream newsUrlInputStream = newsUrl.openStream();
         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         byte[] buf = new byte[10000];
         int len;
         while ((len = newsUrlInputStream.read(buf)) > 0)
         {
            byteArrayOutputStream.write(buf, 0, len);
         }
         newsUrlInputStream.close();

         String xml = byteArrayOutputStream.toString("utf-8");

         resp.setContentType("application/javascript; charset=utf-8");
         String callback = req.getParameter("callback");
         String responseText = callback + "(" + xml + ");";
         resp.getOutputStream().write(responseText.getBytes("utf-8"));
      }
      catch (Exception exxx)
      {
         throw new ServletException(exxx);
      }
   }
}
