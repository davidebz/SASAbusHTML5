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

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusStation
{

   String    name_it;
   String    name_de;

   BusStop[] busStops;
   BusLine[] busLines;

   // Derived
   String    id;

   public BusStation(String name_it, String name_de)
   {
      super();
      this.name_it = name_it;
      this.name_de = name_de;
      busStops = new BusStop[0];
      busLines = new BusLine[0];
      id = ":";
   }

   BusStation()
   {
   }

   public String getName_it()
   {
      return this.name_it;
   }

   public String getName_de()
   {
      return this.name_de;
   }

   public BusStop[] getBusStops()
   {
      return this.busStops;
   }

   public String getId()
   {
      return this.id;
   }

   public BusLine[] getBusLines()
   {
      return this.busLines;
   }

   public void setBusLines(BusLine[] busLines)
   {
      this.busLines = busLines;
   }

   static BusStation[] sortByName(BusStation[] busStations)
   {
      Arrays.sort(busStations, new Comparator<BusStation>()
      {
         @Override
         public int compare(BusStation o1, BusStation o2)
         {
            return o1.getName_it().compareToIgnoreCase(o2.getName_it());
         }
      });
      return busStations;
   }
}
