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

public class TrainStation
{
   public static TrainStation[] list = new TrainStation[] { new TrainStation(46.49670,
                                                                             11.35799,
                                                                             "Bolzano",
                                                                             "Bozen"),

         new TrainStation(46.47334, 11.32658, "Bolzano sud", "Bozen Süd"),
         new TrainStation(46.48029, 11.31504, "Bolzano Casanova", "Bozen Kaiserau"),
         new TrainStation(46.48585, 11.29658, "Ponte Adige", "Sigmundskron"),
         new TrainStation(46.52841, 11.24833, "Terlano", "Terlan"),
         new TrainStation(46.60780, 11.18257, "Lana-Postal", "Lana-Burgstall"),
         new TrainStation(46.65570, 11.14886, "Merano-Maia Bassa", "Meran-Untermais"),
         new TrainStation(46.67277, 11.14980, "Merano", "Meran"),

         new TrainStation(46.43450, 11.32354, "Laives", "Leifers"),
         new TrainStation(46.40506, 11.31625, "Bronzolo", "Branzoll"),

                                     };

   double                       lat;
   double                       lon;

   String                       name_it;
   String                       name_de;

   public TrainStation(double lat, double lon, String name_it, String name_de)
   {
      this.lat = lat;
      this.lon = lon;
      this.name_de = name_de;
      this.name_it = name_it;
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
}
