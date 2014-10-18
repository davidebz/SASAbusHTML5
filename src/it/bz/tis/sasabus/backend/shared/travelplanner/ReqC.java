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

package it.bz.tis.sasabus.backend.shared.travelplanner;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class ReqC
{
   String      xmlns__xsi                     = "http://www.w3.org/2001/XMLSchema-instance";
   String      xsi__noNamespaceSchemaLocation = "http://hafassrv.hacon.de/xml/hafasXMLInterface.xsd";
   String      prod                           = "manuell";
   String      ver                            = "1.1";
   String      lang                           = "DE";
   String      accessId                       = "openSASA";
   LocValReq[] LocValReq                      = new LocValReq[0];
   ConReq[]    ConReq                         = new ConReq[0];
   ConScrReq[] ConScrReq                      = new ConScrReq[0];

   public ReqC(ConScrReq conScrReq)
   {
      this.ConScrReq = new ConScrReq[] { conScrReq };
   }

   public ReqC(String fullName)
   {
      this.LocValReq = new LocValReq[] { new LocValReq() };
      this.LocValReq[0].ReqLoc.match = fullName;
   }

   public ReqC(Station start, Station dest, long yyyymmddhhmm)
   {
      this.ConReq = new ConReq[] { new ConReq() };
      this.ConReq[0].Start.Station = start;
      this.ConReq[0].Start.Prod = new Prod[] { new Prod() };
      this.ConReq[0].Dest.Station = dest;
      this.ConReq[0].ReqT.date = String.valueOf(yyyymmddhhmm / 10000l);
      String hh = pad(yyyymmddhhmm % 10000l / 100l); //String.format("%02d", yyyymmddhhmm % 10000l / 100l);
      String mm = pad(yyyymmddhhmm % 100l); //String.format("%02d", yyyymmddhhmm % 100l);
      this.ConReq[0].ReqT.time = hh + ":" + mm;
   }

   ReqC()
   {
   }

   static String pad(long n)
   {
      String ret = String.valueOf(n);
      while (ret.length() < 2)
      {
         ret = "0" + ret;
      }
      return ret;
   }

}
