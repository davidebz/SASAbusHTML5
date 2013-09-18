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

package it.bz.tis.sasabus.html5.shared.ui.map;

import bz.davide.dmweb.client.leaflet.EventListener;
import bz.davide.dmweb.client.leaflet.LatLng;
import bz.davide.dmweb.client.leaflet.Map;
import bz.davide.dmweb.client.leaflet.OSMLayer;
import bz.davide.dmweb.shared.DMAttachEvent;
import bz.davide.dmweb.shared.DMAttachHandler;
import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;

import com.google.gwt.core.client.Callback;
import com.google.gwt.geolocation.client.Geolocation;
import com.google.gwt.geolocation.client.Geolocation.PositionOptions;
import com.google.gwt.geolocation.client.Position;
import com.google.gwt.geolocation.client.PositionError;
import com.google.gwt.user.client.Window;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusMapAttachHandler implements DMAttachHandler
{
   SASAbusMap map;

   public SASAbusMapAttachHandler(SASAbusMap map)
   {
      super();
      this.map = map;
   }

   @Override
   public void onAttachOrDetach(DMAttachEvent event)
   {
      if (event.isAttached())
      {
         this.map.leafletMap = new Map(this.map.mapDiv.getElement());
         this.map.leafletMap.addLayer(new OSMLayer());

         this.map.fitAllAreas();

         this.map.refreshBaseLayerAfterZoomLevelAndPosition();

         this.map.leafletMap.addZoomEndEventListener(new EventListener()
         {
            @Override
            public void onEvent()
            {
               SASAbusMapAttachHandler.this.map.refreshBaseLayerAfterZoomLevelAndPosition();
            }
         });
         this.map.leafletMap.addDragEndEventListener(new EventListener()
         {
            @Override
            public void onEvent()
            {
               SASAbusMapAttachHandler.this.map.refreshBaseLayerAfterZoomLevelAndPosition();
            }
         });

         this.map.gpsIcon.addClickHandler(new DMClickHandler()
         {

            @Override
            public void onClick(DMClickEvent event)
            {
               PositionOptions positionOptions = new PositionOptions();
               positionOptions.setHighAccuracyEnabled(true);
               positionOptions.setTimeout(10000);

               // http://openlayers.org/dev/examples/geolocation.html

               Geolocation geoloc = Geolocation.getIfSupported();
               if (geoloc != null)
               {
                  geoloc.getCurrentPosition(new Callback<Position, PositionError>()
                  {
                     @Override
                     public void onSuccess(Position result)
                     {

                        double lon = result.getCoordinates().getLongitude();
                        double lat = result.getCoordinates().getLatitude();
                        double accuracy = result.getCoordinates().getAccuracy();
                        Window.alert("lat: " + lat + " lon: " + lon + " acc (meter): " + accuracy);

                        LatLng position = new LatLng(lat, lon);
                        SASAbusMapAttachHandler.this.map.leafletMap.setView(position, 16);
                     }

                     @Override
                     public void onFailure(PositionError reason)
                     {
                        Window.alert("Failure: " + reason.getMessage());
                     }
                  }, positionOptions);
               }
               else
               {
                  Window.alert("Your browser does not support localization");
               }
            }
         });

      }
   };
}
