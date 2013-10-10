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

package it.bz.tis.sasabus.html5.client;

import it.bz.tis.sasabus.html5.shared.SASAbusWidgetUnmarshaller;
import bz.davide.dmweb.client.DMWeb;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusHTML5 implements EntryPoint
{

   /**
    * This is the entry point method.
    */
   @Override
   public void onModuleLoad()
   {
      String hostName = Window.Location.getHostName();
      boolean development = hostName.equals("localhost") ||
                            hostName.equals("127.0.0.1") ||
                            hostName.equals("127.0.1.1") ||
                            hostName.equals("10.0.0.10");

      String serviceBaseUrl = development ? "http://" + hostName + ":8080/SASAbusBackend/" : "/backend/";

      SASAbusDBClientImpl.singleton = new SASAbusDBClientImpl(serviceBaseUrl);

      SASAbusWidgetUnmarshaller widgetUnmarshaller = new SASAbusWidgetUnmarshaller();
      DMWeb.start(widgetUnmarshaller);

   }

   public static void handleException(Exception exxx)
   {
      Window.alert("Err " + exxx.getClass().getName() + ": " + exxx.getMessage());
   }
}
