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

import it.bz.tis.sasabus.backend.shared.Area;
import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.BusStop;
import it.bz.tis.sasabus.backend.shared.BusTrip;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.html5.shared.data.Parking;
import it.bz.tis.sasabus.html5.shared.data.TrainStation;
import it.bz.tis.sasabus.html5.shared.ui.AreaPanel;
import it.bz.tis.sasabus.html5.shared.ui.icon.GpsIcon;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Set;

import bz.davide.dmweb.client.leaflet.Circle;
import bz.davide.dmweb.client.leaflet.EventListener;
import bz.davide.dmweb.client.leaflet.Icon;
import bz.davide.dmweb.client.leaflet.IconOptions;
import bz.davide.dmweb.client.leaflet.LatLng;
import bz.davide.dmweb.client.leaflet.LatLngBounds;
import bz.davide.dmweb.client.leaflet.Layer;
import bz.davide.dmweb.client.leaflet.Map;
import bz.davide.dmweb.client.leaflet.Marker;
import bz.davide.dmweb.client.leaflet.MarkerOptions;
import bz.davide.dmweb.client.leaflet.Path;
import bz.davide.dmweb.client.leaflet.PathOptions;
import bz.davide.dmweb.client.leaflet.Polygon;
import bz.davide.dmweb.client.leaflet.Polyline;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.ImgView;

import com.google.gwt.user.client.Timer;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusMap extends DivView
{

   final static String[]                              COLORS                             = new String[]{
            "#FF0000",
            "#0000FF",
            "#FFFF00"                                                                    };

   transient Map                                      leafletMap;
   transient ArrayList<Layer>                         baseLayers                         = new ArrayList<Layer>();
   transient IdentityHashMap<BusStation, Void>        highlightedBusStations             = new IdentityHashMap<BusStation, Void>();
   transient boolean                                  mapOpen                            = false;

   DMHashNavigationPanel                              navigationPanel;

   DivView                                            controls;
   DivView                                            mapDiv;
   //DMLabel                                            zoomLevel;
   //DMLabel                                            latLonValues;

   GpsIcon                                            gpsIcon;

   transient IdentityHashMap<Area, Polygon>           polygonOfAreaCache                 = new IdentityHashMap<Area, Polygon>();
   transient IdentityHashMap<Area, ArrayList<LatLng>> boundsOfAreaCache                  = new IdentityHashMap<Area, ArrayList<LatLng>>();
   transient IdentityHashMap<BusStation, Path[]>      shapesOfBusStationCache            = new IdentityHashMap<BusStation, Path[]>();
   transient IdentityHashMap<BusStation, Path[]>      shapesOfHighlightedBusStationCache = new IdentityHashMap<BusStation, Path[]>();

   AreaList                                           areaList;

   ButtonView                                         close;

   DivView                                            overwievMap;

   public static class InitParameters extends DivView.InitParameters
   {
      public InitParameters()
      {
         super("map");
      }
   }

   public SASAbusMap(InitParameters initParameters)
   {
      super(initParameters);

      this.close = new ButtonView(new ButtonView.InitParameters("X"));

      this.overwievMap = new DivView(new DivView.InitParameters("overview-map"));
      ImgView cartina = new ImgView(new ImgView.InitParameters("../images/Cartina.png"));
      this.overwievMap.appendChild(cartina);
      this.appendChild(this.overwievMap);

      this.leafletMap = null;

      this.controls = new DivView(new DivView.InitParameters("controls"));
      this.appendChild(this.controls);

      this.mapDiv = new DivView(new DivView.InitParameters("mapdiv"));
      this.appendChild(this.mapDiv);

      this.controls.appendChild(this.close);
      this.close.setStyleName("close");

      this.gpsIcon = new GpsIcon(new GpsIcon.InitParameters());
      this.controls.appendChild(this.gpsIcon);

      //this.zoomLevel = new DMLabel("");
      //this.controls.add(this.zoomLevel);

      //this.latLonValues = new DMLabel("");
      //this.controls.add(this.latLonValues);

   }

   protected SASAbusMap()
   {
   }

   public void showOverviewMap(boolean show)
   {
      if (show)
      {
         this.overwievMap.addStyleName("show");
      }
      else
      {
         this.overwievMap.removeStyleName("show");
      }
   }

   public Map getLeafletMap()
   {
      return this.leafletMap;
   }

   public void setNavigationPanel(DMHashNavigationPanel navigationPanel)
   {
      this.navigationPanel = navigationPanel;
   }

   public void start(final AreaList areaList)
   {
      this.areaList = areaList;

      this.initAreasPolygon(areaList);
      this.initBusStationsShapes(areaList);
      this.addAttachHandler(new SASAbusMapAttachHandler(this));
      this.close.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            SASAbusMap.this.hide();
         }
      });

      // Add train stations

      for (final TrainStation trainStation : TrainStation.list)
      {
         IconOptions iconOptions = new IconOptions();
         iconOptions.setIconUrl("../images/layout/train-icon-map.png");
         Icon icon = new Icon(iconOptions);
         MarkerOptions markerOptions = new MarkerOptions();
         markerOptions.setIcon(icon);
         final LatLng latLng = new LatLng(trainStation.getLat(), trainStation.getLon());
         Marker trainStationMarker = new Marker(latLng, markerOptions);

         trainStationMarker.addClickEventListener(new EventListener()
         {
            @Override
            public void onEvent()
            {
               TrainStationPopup trainStationPopup = new TrainStationPopup(trainStation,
                                                                           SASAbusMap.this.navigationPanel,
                                                                           areaList,
                                                                           SASAbusMap.this);
               SASAbusMap.this.leafletMap.openPopup(trainStationPopup.getElement(), latLng);
               trainStationPopup.init();
            }
         });
         this.leafletMap.addLayer(trainStationMarker);

      }

      // Add parkings

      for (final Parking parking : Parking.list)
      {
         IconOptions iconOptions = new IconOptions();
         iconOptions.setIconUrl("../images/layout/park-icon-map.png");
         Icon icon = new Icon(iconOptions);
         MarkerOptions markerOptions = new MarkerOptions();
         markerOptions.setIcon(icon);
         final LatLng latLng = new LatLng(parking.getLat(), parking.getLon());
         Marker parkMarker = new Marker(latLng, markerOptions);
         this.leafletMap.addLayer(parkMarker);
         parkMarker.addClickEventListener(new EventListener()
         {
            @Override
            public void onEvent()
            {
               ParkingPopup parkingPopup = new ParkingPopup(parking);
               SASAbusMap.this.leafletMap.openPopup(parkingPopup.getElement(), latLng);
               parkingPopup.init();
            }
         });
      }
   }

   private void initBusStationsShapes(AreaList areaList)
   {

      PathOptions pathOptions = new PathOptions();
      pathOptions.setFillColor("red");
      pathOptions.setColor("#555555");
      pathOptions.setFillOpacity(.8);

      PathOptions pathOptions2 = new PathOptions();
      pathOptions2.setFillColor("yellow");
      pathOptions2.setColor("red");
      pathOptions2.setFillOpacity(.8);

      for (final BusStation busStation : areaList.getBusStations())
      {
         ArrayList<Path> shapes = new ArrayList<Path>();
         ArrayList<Path> hightlightedShapes = new ArrayList<Path>();

         BusStop[] busStops = busStation.getBusStops();
         LatLng lastLatLng = null;
         for (int i = 0; i < busStops.length; i++)
         {
            BusStop busStop = busStops[i];
            LatLng latLng = new LatLng(busStop.getLat(), busStop.getLon());

            Circle circle = new Circle(latLng, 10, pathOptions);
            shapes.add(circle);

            Circle circle2 = new Circle(latLng, 10, pathOptions2);
            hightlightedShapes.add(circle2);

            if (i > 0)
            {
               LatLng[] vertexs = new LatLng[2];
               vertexs[0] = lastLatLng;
               vertexs[1] = latLng;
               Polyline polyline = new Polyline(vertexs, pathOptions);
               shapes.add(polyline);

               polyline.addClickEventListener(new EventListener()
               {
                  @Override
                  public void onEvent()
                  {
                     SASAbusMap.this.showBusStationPopup(busStation);
                  }
               });

            }
            lastLatLng = latLng;

            circle.addClickEventListener(new EventListener()
            {
               @Override
               public void onEvent()
               {
                  SASAbusMap.this.showBusStationPopup(busStation);
               }
            });
            circle2.addClickEventListener(new EventListener()
            {
               @Override
               public void onEvent()
               {
                  SASAbusMap.this.showBusStationPopup(busStation);
               }
            });

         }
         this.shapesOfBusStationCache.put(busStation, shapes.toArray(new Path[0]));
         this.shapesOfHighlightedBusStationCache.put(busStation, hightlightedShapes.toArray(new Path[0]));
      }
   }

   private void showBusStationPopup(final BusStation busStation)
   {
      BusStop busStop = busStation.getBusStops()[0];
      LatLng latLng = new LatLng(busStop.getLat(), busStop.getLon());
      BusStationPopup mapPopup = new BusStationPopup(busStation, this.navigationPanel, this, this.areaList);
      this.leafletMap.openPopup(mapPopup.getElement(), latLng);
      mapPopup.init();
   }

   private void initAreasPolygon(final AreaList areaList)
   {
      for (final Area area : areaList.getAreas())
      {
         String color = COLORS[area.getId() - 1];

         PathOptions polylineOptions = new PathOptions();
         polylineOptions.setFillColor(color);
         polylineOptions.setColor(color);

         ArrayList<LatLng> bounds = new ArrayList<LatLng>();

         LatLng[] latLngs = new LatLng[area.getBoundLats().length];
         for (int i = 0; i < latLngs.length; i++)
         {
            latLngs[i] = new LatLng(area.getBoundLats()[i], area.getBoundLons()[i]);
            bounds.add(latLngs[i]);
         }
         Polygon polygon = new Polygon(latLngs, polylineOptions);

         polygon.addClickEventListener(new EventListener()
         {
            @Override
            public void onEvent()
            {
               SASAbusMap.this.navigationPanel.newPage(new AreaPanel(area,
                                                                     SASAbusMap.this.navigationPanel,
                                                                     areaList,
                                                                     SASAbusMap.this));

            }
         });

         this.polygonOfAreaCache.put(area, polygon);
         this.boundsOfAreaCache.put(area, bounds);
      }
   }

   public void highlightFitBusLine(BusLine busLine)
   {
      this.highlightedBusStations.clear();

      ArrayList<LatLng> bounds = new ArrayList<LatLng>();
      for (BusStation busStation : busLine.getBusStations())
      {
         this.highlightedBusStations.put(busStation, null);
         BusStop busStop = busStation.getBusStops()[0];
         LatLng latLng = new LatLng(busStop.getLat(), busStop.getLon());
         bounds.add(latLng);
      }
      this.leafletMap.fitBounds(new LatLngBounds(bounds.toArray(new LatLng[0])));
      this.refreshBaseLayerAfterZoomLevelAndPosition();
   }

   public void highlightFitBusStation(BusStation busStation)
   {
      this.highlightedBusStations.clear();
      this.highlightedBusStations.put(busStation, null);
      BusStop busStop = busStation.getBusStops()[0];
      LatLng latLng = new LatLng(busStop.getLat(), busStop.getLon());
      this.leafletMap.setView(latLng, 16);
      this.refreshBaseLayerAfterZoomLevelAndPosition();

   }

   public void highlightFitBusTrip(BusTrip busTrip, int index)
   {
      this.highlightedBusStations.clear();
      this.leafletMap.closePopup();

      BusTripStop[] busTripStops = busTrip.getBusTripStops();
      ArrayList<LatLng> bounds = new ArrayList<LatLng>();
      for (int i = index; i < busTripStops.length; i++)
      {
         BusTripStop busTripStop = busTripStops[i];
         BusStop busStop = this.areaList.findBusStopById(busTripStop.getBusStopId());
         BusStation busStation = busStop.getBusStation();
         this.highlightedBusStations.put(busStation, null);
         LatLng latLng = new LatLng(busStop.getLat(), busStop.getLon());
         bounds.add(latLng);

      }
      this.leafletMap.fitBounds(new LatLngBounds(bounds.toArray(new LatLng[0])));
      this.refreshBaseLayerAfterZoomLevelAndPosition();
   }

   public void fitAllAreas()
   {
      this.highlightedBusStations.clear();
      this.leafletMap.closePopup();

      ArrayList<LatLng> bounds = new ArrayList<LatLng>();
      for (Area area : this.polygonOfAreaCache.keySet())
      {
         ArrayList<LatLng> areaBounds = this.boundsOfAreaCache.get(area);
         bounds.addAll(areaBounds);
      }

      this.leafletMap.fitBounds(new LatLngBounds(bounds.toArray(new LatLng[0])));
      this.refreshBaseLayerAfterZoomLevelAndPosition();

   }

   public void fitArea(Area area)
   {
      this.highlightedBusStations.clear();
      this.leafletMap.closePopup();

      this.leafletMap.fitBounds(new LatLngBounds(this.boundsOfAreaCache.get(area).toArray(new LatLng[0])));
      this.refreshBaseLayerAfterZoomLevelAndPosition();

   }

   void refreshBaseLayerAfterZoomLevelAndPosition()
   {

      int zoom = this.leafletMap.getZoom();
      //SASAbusMap.this.zoomLevel.setText("Zoom level: " + zoom);
      LatLng center = this.leafletMap.getCenter();
      //this.latLonValues.setText("lat,lon: " + (float) center.getLat() + "," + (float) center.getLng());

      // Remove base layers
      for (Layer base : this.baseLayers)
      {
         this.leafletMap.removeLayer(base);
      }

      if (zoom >= 15)
      {
         Set<BusStation> busStations = this.shapesOfBusStationCache.keySet();
         for (BusStation busStation : busStations)
         {
            double radius1 = busStation.getBusStops()[0].getLat() - center.getLat();
            double radius2 = busStation.getBusStops()[0].getLon() - center.getLng();
            double radius = radius1 * radius1 + radius2 * radius2;
            // Don't show here a bustation if highlighted
            if (!this.highlightedBusStations.containsKey(busStation))
            {
               if (radius < 0.0005d)
               {
                  for (Path path : this.shapesOfBusStationCache.get(busStation))
                  {
                     this.baseLayers.add(path);
                     this.leafletMap.addLayer(path);
                  }
               }
            }
         }
      }
      else
      {
         if (this.highlightedBusStations.size() == 0)
         {
            for (Polygon polygon : this.polygonOfAreaCache.values())
            {
               this.baseLayers.add(polygon);
               this.leafletMap.addLayer(polygon);
            }
         }
      }
      for (BusStation busStation : this.highlightedBusStations.keySet())
      {
         for (Path path : this.shapesOfBusStationCache.get(busStation))
         {
            this.baseLayers.add(path);
            this.leafletMap.addLayer(path);
         }
         for (Path path : this.shapesOfHighlightedBusStationCache.get(busStation))
         {
            this.baseLayers.add(path);
            this.leafletMap.addLayer(path);
         }
      }
   }

   public void toggle()
   {
      this.addStyleName("anim-left");
      if (this.mapOpen)
      {
         this.removeStyleName("show");
      }
      else
      {
         this.addStyleName("show");
      }
      this.mapOpen = !this.mapOpen;
      Timer removeAnim = new Timer()
      {
         @Override
         public void run()
         {
            SASAbusMap.this.removeStyleName("anim-left");
         }
      };
      removeAnim.schedule(1000);
   }

   public void show()
   {
      if (!this.mapOpen)
      {
         this.toggle();
      }
   }

   public void hide()
   {
      if (this.mapOpen)
      {
         this.toggle();
      }
   }

}
