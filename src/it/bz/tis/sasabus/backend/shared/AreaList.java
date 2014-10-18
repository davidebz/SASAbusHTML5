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

package it.bz.tis.sasabus.backend.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class AreaList
{

   long                                lastModified;
   Area[]                              areas;

   transient HashMap<Integer, BusStop> busStopsById = new HashMap<Integer, BusStop>();

   public AreaList(Area[] areas, long lastModified)
   {
      super();
      this.areas = areas;
      this.lastModified = lastModified;
   }

   AreaList()
   {
      super();

   }

   public Area[] getAreas()
   {
      return this.areas;
   }

   public long getLastModified()
   {
      return this.lastModified;
   }

   public BusStop findBusStopById(int id)
   {
      return this.busStopsById.get(id);
   }

   public BusLine findBusLineById(int busid)
   {
      BusLine ret = null;
      for (Area area : this.areas)
      {
         for (BusLine busLine : area.getBusLines())
         {
            if (busLine.getId() == busid)
            {
               if (ret != null)
               {
                  throw new IllegalStateException("Two (or more) BusLine with same id: " + busid);
               }
               ret = busLine;
            }
         }
      }
      if (ret == null)
      {
         throw new IllegalStateException("BusLine by " + busid + " not found!");
      }
      return ret;
   }

   public BusStation[] getBusStations()
   {
      IdentityHashMap<BusStation, Void> uniqueBusStations = new IdentityHashMap<BusStation, Void>();
      for (Area area : this.areas)
      {
         for (BusLine busLine : area.getBusLines())
         {
            for (BusStop busStop : busLine.getBusStops())
            {
               uniqueBusStations.put(busStop.getBusStation(), null);
               this.busStopsById.put(busStop.getId(), busStop);
            }
         }
      }

      BusStation[] busStations = new ArrayList<BusStation>(uniqueBusStations.keySet()).toArray(new BusStation[0]);
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
