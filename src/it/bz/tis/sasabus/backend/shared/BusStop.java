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
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusStop
{
   int        id;
   double     lat;
   double     lon;

   // Reverse Relation
   BusStation busStation;

   public BusStop(BusStation busStation, int id, double lat, double lon)
   {
      super();
      this.busStation = busStation;
      this.id = id;
      this.lat = lat;
      this.lon = lon;

      busStation.id += id + ":";
      ArrayList<BusStop> stops = new ArrayList<BusStop>(Arrays.asList(busStation.busStops));
      stops.add(this);
      Collections.sort(stops, new Comparator<BusStop>()
      {

         @Override
         public int compare(BusStop o1, BusStop o2)
         {
            double latDiff = o2.getLat() - o1.getLat();
            if (latDiff < 0)
            {
               return -1;
            }
            if (latDiff > 0)
            {
               return 1;
            }
            return o1.getId() - o2.getId();
         }
      });
      busStation.busStops = stops.toArray(new BusStop[0]);
   }

   BusStop()
   {
   }

   public int getId()
   {
      return this.id;
   }

   public double getLat()
   {
      return this.lat;
   }

   public double getLon()
   {
      return this.lon;
   }

   public BusStation getBusStation()
   {
      return this.busStation;
   }

}
