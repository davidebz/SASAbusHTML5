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

import java.util.IdentityHashMap;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class Area
{
   int       id;
   String    name_it;
   String    name_de;

   BusLine[] busLines;

   LatLng[]  bounds;

   public Area(int id, String name_it, String name_de, LatLng[] bounds)
   {
      super();
      this.id = id;
      this.name_it = name_it;
      this.name_de = name_de;
      this.busLines = new BusLine[0];
      this.bounds = bounds;
   }

   Area()
   {
   }

   public int getId()
   {
      return this.id;
   }

   public String getName_it()
   {
      return this.name_it;
   }

   public String getName_de()
   {
      return this.name_de;
   }

   public BusLine[] getBusLines()
   {
      return this.busLines;
   }

   public LatLng[] getBounds()
   {
      return this.bounds;
   }

   /*
   public Double[] getBoundLats()
   {
      if (this.id == 1)
      {
         return boundLats_bz;
      }
      if (this.id == 2)
      {
         return boundLats_me;
      }
      if (this.id == 3)
      {
         return boundLats_su;
      }
      return null;
   }

   public Double[] getBoundLons()
   {
      if (this.id == 1)
      {
         return boundLons_bz;
      }
      if (this.id == 2)
      {
         return boundLons_me;
      }
      if (this.id == 3)
      {
         return boundLons_su;
      }
      return null;
   }
   */

   public BusStation[] calcAreaBusStations()
   {
      IdentityHashMap<BusStation, Void> uniqueBusStations = new IdentityHashMap<BusStation, Void>();
      for (BusLine busLine : this.busLines)
      {
         for (BusStop busStop : busLine.getBusStops())
         {
            uniqueBusStations.put(busStop.getBusStation(), null);
         }
      }
      return uniqueBusStations.keySet().toArray(new BusStation[0]);
   }

   public static Double[] boundLats_bz = new Double[] { 46.4949475,
         46.49189125,
         46.488835,
         46.48781625,
         46.48292625,
         46.483945,
         46.490872499999995,
         46.4819075,
         46.48088875,
         46.47192375,
         46.4688675,
         46.44299125,
         46.43484125,
         46.4289325,
         46.42383875,
         46.40998375,
         46.4028525,
         46.401833749999994,
         46.4,
         46.40590875,
         46.421801249999994,
         46.433822500000005,
         46.4599025,
         46.4688675,
         46.484963750000006,
         46.4859825,
         46.50982125,
         46.5128775,
         46.519805,
         46.51797125,
         46.5218425,
         46.5348825,
         46.538957499999995,
         46.54181,
         46.563,
         46.543847500000005,
         46.52897375,
         46.513896249999995,
         46.50493125,
         46.502893750000005,
         46.513896249999995,
         46.514915,
         46.495966249999995           };
   public static Double[] boundLons_bz = new Double[] { 11.39085625,
         11.3988,
         11.407,
         11.407,
         11.407,
         11.402899999999999,
         11.36779375,
         11.34883125,
         11.34678125,
         11.3367875,
         11.334993749999999,
         11.34780625,
         11.34575625,
         11.3439625,
         11.341912500000001,
         11.32884375,
         11.321924999999998,
         11.3209,
         11.316799999999999,
         11.298862499999998,
         11.30578125,
         11.323975,
         11.331918750000002,
         11.32295,
         11.2978375,
         11.295787500000001,
         11.27375,
         11.26990625,
         11.237875,
         11.23275,
         11.22685625,
         11.20686875,
         11.20379375,
         11.202,
         11.22378125,
         11.237875,
         11.248893749999999,
         11.26888125,
         11.29194375,
         11.323975,
         11.35190625,
         11.3578,
         11.3839375                   };

   public static Double[] boundLats_me = new Double[] { 46.6709325,
         46.6709325,
         46.66992,
         46.660807500000004,
         46.659997499999996,
         46.6559475,
         46.6539225,
         46.64481,
         46.629825,
         46.6239525,
         46.6219275,
         46.6259775,
         46.64481,
         46.6498725,
         46.652910000000006,
         46.6559475,
         46.658985,
         46.660807500000004,
         46.6648575,
         46.660807500000004,
         46.65696,
         46.644,
         46.637925,
         46.6369125,
         46.633875,
         46.624964999999996,
         46.6138275,
         46.616865,
         46.607955000000004,
         46.603905,
         46.563,
         46.5708975,
         46.57596,
         46.5838575,
         46.5858825,
         46.595805,
         46.598842499999996,
         46.603905,
         46.607955000000004,
         46.607955000000004,
         46.598842499999996,
         46.598842499999996,
         46.58892,
         46.5899325,
         46.59783,
         46.6138275,
         46.6158525,
         46.617877500000006,
         46.6219275,
         46.63185,
         46.6348875,
         46.6498725,
         46.654934999999995,
         46.6668825,
         46.6749825,
         46.676805,
         46.6818675,
         46.677817499999996,
         46.671945,
         46.68288,
         46.6798425,
         46.68288,
         46.684905,
         46.68288,
         46.678830000000005,
         46.6838925,
         46.6968525,
         46.699889999999996,
         46.701915,
         46.7029275,
         46.699889999999996,
         46.7199375,
         46.725,
         46.725,
         46.7239875,
         46.7098125,
         46.701915,
         46.688955,
         46.6838925,
         46.680855                    };
   public static Double[] boundLons_me = new Double[] { 11.20099,
         11.208875,
         11.208875,
         11.2028575,
         11.2028575,
         11.184805,
         11.183975,
         11.178995,
         11.179825000000001,
         11.184805,
         11.185842500000001,
         11.208875,
         11.21095,
         11.2169675,
         11.218834999999999,
         11.22091,
         11.222985000000001,
         11.2319075,
         11.24,
         11.232944999999999,
         11.227965,
         11.2248525,
         11.230870000000001,
         11.230870000000001,
         11.2169675,
         11.208875,
         11.2198725,
         11.22589,
         11.2389625,
         11.2319075,
         11.223815,
         11.2169675,
         11.2128175,
         11.20099,
         11.20099,
         11.1999525,
         11.198915000000001,
         11.1958025,
         11.181899999999999,
         11.174845,
         11.16281,
         11.1559625,
         11.1468325,
         11.144965000000001,
         11.14289,
         11.14289,
         11.1418525,
         11.140815,
         11.140815,
         11.144965000000001,
         11.145795,
         11.1418525,
         11.139985000000001,
         11.134797500000001,
         11.120895,
         11.117989999999999,
         11.105955,
         11.0879025,
         11.080847499999999,
         11.074,
         11.0908075,
         11.095995,
         11.112802499999999,
         11.120895,
         11.1339675,
         11.145795,
         11.1518125,
         11.153887500000002,
         11.157,
         11.1638475,
         11.169865,
         11.1729775,
         11.1738075,
         11.186879999999999,
         11.186879999999999,
         11.186879999999999,
         11.179825000000001,
         11.186879999999999,
         11.188955,
         11.188955                    };

   public static Double[] boundLats_su = new Double[] { 46.493,
         46.50983,
         46.51894625,
         46.528997499999996,
         46.535776250000005,
         46.54278875,
         46.54278875,
         46.553775,
         46.56289125,
         46.5738775,
         46.5869675,
         46.613848749999995,
         46.6178225,
         46.652885000000005,
         46.67883125,
         46.68,
         46.67181875,
         46.6449375,
         46.61899125,
         46.599823750000006,
         46.58089,
         46.566865,
         46.56289125,
         46.5439575,
         46.51380375,
         46.50492125,
         46.5018825,
         46.5009475,
         46.495805,
         46.493935                    };

   public static Double[] boundLons_su = new Double[] { 11.31083,
         11.27384,
         11.259799999999998,
         11.249,
         11.24198,
         11.2058,
         11.20499,
         11.178799999999999,
         11.168809999999999,
         11.16098,
         11.1599,
         11.14289,
         11.141,
         11.14586,
         11.14694,
         11.15099,
         11.15882,
         11.17691,
         11.1869,
         11.198780000000001,
         11.210930000000001,
         11.22092,
         11.223889999999999,
         11.23793,
         11.268979999999999,
         11.29193,
         11.33378,
         11.34188,
         11.357,
         11.32892                     };
}
