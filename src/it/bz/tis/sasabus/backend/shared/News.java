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

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class News
{
   public News()
   {
   }

   String            id;
   String            titel_de;
   String            titel_it;
   String            nachricht_de;
   String            nachricht_it;
   ArrayList<String> linienliste;
   String            lastmod;

   public String getTitel_it()
   {
      return this.titel_it;
   }

   public String getNachricht_it()
   {
      return this.nachricht_it;
   }

   public String getTitel_de()
   {
      return this.titel_de;
   }

   public String getNachricht_de()
   {
      return this.nachricht_de;
   }

}
