/*
SASAbusHTML5 - HTML5 App for SASA bus

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

package it.bz.tis.sasabus.html5.shared.data;

public class Parking
{
   public static Parking[] list = new Parking[] { new Parking(46.49420, 11.35678, "Bz Centro", "Bz Mitte", "108"),
         new Parking(46.4964486, 11.35630450, "City parking", "City parking   ", "102"),
         new Parking(46.49780, 11.3551147, "Piazza Walther", "Walther Platz", "103"),
         new Parking(46.498174, 11.3572551, "Laurin", "Laurin", "105"),
         new Parking(46.472249, 11.327065, "Fiera", "Messe", "116"),
         new Parking(46.497134, 11.358906, "Central Parking", "Central Parking", "106"),
         new Parking(46.500550, 11.358216, "Luna", "Mondschein", "104"), };

   double                  lat;
   double                  lon;

   String                  name_it;
   String                  name_de;

   String                  id;

   public Parking(double lat, double lon, String name_it, String name_de, String id)
   {
      super();
      this.lat = lat;
      this.lon = lon;
      this.name_it = name_it;
      this.name_de = name_de;
      this.id = id;
   }

   public double getLat()
   {
      return this.lat;
   }

   public double getLon()
   {
      return this.lon;
   }

   public String getName_it()
   {
      return this.name_it;
   }

   public String getName_de()
   {
      return this.name_de;
   }

   public String getId()
   {
      return this.id;
   }

}
