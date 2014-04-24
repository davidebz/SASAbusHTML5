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

package it.bz.tis.sasabus.html5.shared;

import it.bz.tis.sasabus.html5.client.SASAbusHTML5;
import java.util.HashMap;
import bz.davide.dmxmljson.marshalling.json.JSONStructure;
import bz.davide.dmxmljson.unmarshalling.json.gwt.GWTStructure;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.storage.client.Storage;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class FavouriteBusStationList
{
   public static String                   SASAbusHTML5_FAVOURITES = "SASAbusHTML5_FAVOURITES";

   private static FavouriteBusStationList singleton               = null;

   public static FavouriteBusStationList getSingleton()
   {
      if (singleton == null)
      {
         singleton = loadFromHTML5Localstore();
      }
      return singleton;
   }

   HashMap<String, String> busStationIds = new HashMap<String, String>();

   FavouriteBusStationList()
   {
   }

   public void addFavouriteBusStation(String busStationId)
   {
      this.busStationIds.put(busStationId, "");
      this.writeToHTML5Localstore();
   }

   public void removeFavouriteBusStation(String busStationId)
   {
      this.busStationIds.remove(busStationId);
      this.writeToHTML5Localstore();
   }

   public boolean isFavourite(String BusStationId)
   {
      return this.busStationIds.containsKey(BusStationId);
   }

   public static FavouriteBusStationList loadFromHTML5Localstore()
   {
      FavouriteBusStationList favouriteBusStationList = new FavouriteBusStationList();
      final Storage localStorage = Storage.getLocalStorageIfSupported();
      if (localStorage != null)
      {
         String tmp = localStorage.getItem(SASAbusHTML5_FAVOURITES);
         if (tmp != null && tmp.length() > 0)
         {
            GWTStructure gwtStructure = new GWTStructure((JSONObject) JSONParser.parse(tmp));
            FavouriteBusStationListUnmarshaller unmarshaller = new FavouriteBusStationListUnmarshaller();

            try
            {
               unmarshaller.unmarschall(gwtStructure, favouriteBusStationList);
            }
            catch (Exception e)
            {
               SASAbusHTML5.handleException(e);
            }
         }
      }
      return favouriteBusStationList;
   }

   public void writeToHTML5Localstore()
   {
      final Storage localStorage = Storage.getLocalStorageIfSupported();
      if (localStorage != null)
      {
         JSONStructure jsonStructure = new JSONStructure(0);
         try
         {
            new FavouriteBusStationListMarshaller().marschall(this, jsonStructure);
            String tmp = jsonStructure.toString();
            localStorage.setItem(SASAbusHTML5_FAVOURITES, tmp);
         }
         catch (Exception e)
         {
            SASAbusHTML5.handleException(e);
         }
      }
   }
}
