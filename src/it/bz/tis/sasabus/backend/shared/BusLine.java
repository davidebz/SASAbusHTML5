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

package it.bz.tis.sasabus.backend.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IdentityHashMap;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusLine
{
   int       id;
   String    number;

   // reverse relation
   Area      area;

   BusStop[] busStops;

   public BusLine(int id, String number, Area area)
   {
      super();
      this.id = id;
      this.number = number;
      this.area = area;

      ArrayList<BusLine> busLines = new ArrayList<BusLine>(Arrays.asList(area.busLines));
      busLines.add(this);
      area.busLines = busLines.toArray(new BusLine[0]);

      BusLine.sortByNumber(area.busLines);

   }

   BusLine()
   {
   }

   public int getId()
   {
      return this.id;
   }

   public String getNumber()
   {
      return this.number;
   }

   public Area getArea()
   {
      return this.area;
   }

   private static String confrontableBusLineNumber(String num)
   {
      char lastChar = num.charAt(num.length() - 1);
      if ('0' <= lastChar && lastChar <= '9')
      {
         num = num + "0";
      }
      while (num.length() < 4)
      {
         num = "0" + num;
      }
      return num;
   }

   public static void sortByNumber(BusLine[] busLines)
   {
      Arrays.sort(busLines, new Comparator<BusLine>()
      {
         @Override
         public int compare(BusLine o1, BusLine o2)
         {
            String num1 = confrontableBusLineNumber(o1.number);
            String num2 = confrontableBusLineNumber(o2.number);
            return num1.compareTo(num2);
         }
      });
   }

   public void setBusStops(BusStop[] busLineStops)
   {
      this.busStops = busLineStops;
   }

   public BusStop[] getBusStops()
   {
      return this.busStops;
   }

   public BusStation[] getBusStations()
   {
      IdentityHashMap<BusStation, Void> uniqueBusStations = new IdentityHashMap<BusStation, Void>();
      for (BusStop busStop : this.busStops)
      {
         uniqueBusStations.put(busStop.getBusStation(), null);
      }
      BusStation[] result = uniqueBusStations.keySet().toArray(new BusStation[0]);
      BusStation.sortByName(result);
      return result;
   }
}
