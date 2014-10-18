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

package it.bz.tis.sasabus.backend.server.sasabusdb;

import it.bz.tis.sasabus.backend.shared.Area;
import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.BusTrip;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.backend.shared.BusTripStopList;
import it.bz.tis.sasabus.backend.shared.BusTripStopReference;
import it.bz.tis.sasabus.backend.shared.FreeSlots;
import it.bz.tis.sasabus.backend.shared.NewsList;
import it.bz.tis.sasabus.backend.shared.ParkingInfo;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendMarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendUnmarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusDB;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.SASAbusDBLastModified;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConScrReq;
import it.bz.tis.sasabus.backend.shared.travelplanner.ReqC;
import it.bz.tis.sasabus.backend.shared.travelplanner.ResC;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import bz.davide.dmxmljson.marshalling.xml.PrimitiveTypePolicy;
import bz.davide.dmxmljson.marshalling.xml.XMLStructure;
import bz.davide.dmxmljson.marshalling.xml.XMLStructureRules;
import bz.davide.dmxmljson.unmarshalling.xml.W3CXMLStructure;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusDBServerImpl implements SASAbusDB
{

   String                                                     firstDay;
   protected long                                             lastModified;

   protected Area[]                                           areas;
   protected HashMap<String, BusStation>                      busStationsById           = new HashMap<String, BusStation>();

   protected HashMap<String, ArrayList<BusTripStopReference>> busTripStopByBusStationId = new HashMap<String, ArrayList<BusTripStopReference>>();

   protected ArrayList<BusTrip>                               trips                     = new ArrayList<BusTrip>();

   public Area[] getAreas()
   {
      return this.areas;
   }

   public ArrayList<BusTrip> getTrips()
   {
      return this.trips;
   }

   public BusStation[] getBusStations()
   {
      return this.busStationsById.values().toArray(new BusStation[0]);
   }

   @Override
   public void lastModified(SASAbusDBDataReady<SASAbusDBLastModified> response)
   {
      response.ready(new SASAbusDBLastModified(this.lastModified));
   }

   @Override
   public void listBusAreasLinesStopsStations(SASAbusDBDataReady<AreaList> response)
   {
      response.ready(new AreaList(this.areas, this.lastModified));
   }

   @Override
   public void findBusStationDepartures(String busStationId,
                                        long yyyymmddhhmm,
                                        SASAbusDBDataReady<BusTripStopList> response)
   {
      ArrayList<BusTripStopReference> busTripStops = this.busTripStopByBusStationId.get(busStationId);
      Collections.sort(busTripStops, new Comparator<BusTripStopReference>()
      {
         @Override
         public int compare(BusTripStopReference o1, BusTripStopReference o2)
         {
            return o1.getBusTrip().getBusTripStops()[o1.getIndex()].getTimeHHMMSS()
                   - o2.getBusTrip().getBusTripStops()[o2.getIndex()].getTimeHHMMSS();
         }
      });

      ArrayList<BusTripStopReference> responseBusTripStops = new ArrayList<BusTripStopReference>();
      int time = (int) (yyyymmddhhmm % 10000L) * 100;
      String date = String.valueOf(yyyymmddhhmm / 10000L);
      int count = 0;
      for (int i = 0; i < busTripStops.size(); i++)
      {
         BusTripStopReference busTripStopRef = busTripStops.get(i);
         BusTripStop busTripStop = busTripStopRef.getBusTrip().getBusTripStops()[busTripStopRef.getIndex()];
         boolean isRunningDay = busTripStopRef.getBusTrip().getIsRunningAtDay().isRunning(date);
         if (isRunningDay)
         {
            int stopTime = busTripStop.getTimeHHMMSS();
            if (stopTime >= time)
            {
               // is not this the last bus stop of the trip?
               if (busTripStop != busTripStopRef.getBusTrip().getBusTripStops()[busTripStopRef.getBusTrip().getBusTripStops().length - 1])
               {
                  responseBusTripStops.add(busTripStopRef);
                  count++;
                  if (count > 5)
                  {
                     break;
                  }
               }
            }
         }
      }
      response.ready(new BusTripStopList(responseBusTripStops.toArray(new BusTripStopReference[0])));
   }

   @Override
   public void calcRoute(String startBusStationId,
                         String endBusStationId,
                         long yyyymmddhhmm,
                         SASAbusDBDataReady<ConRes> response) throws Exception
   {
      BusStation startBusStation = this.busStationsById.get(startBusStationId);
      BusStation endBusStation = this.busStationsById.get(endBusStationId);

      calcRouting(startBusStation.getName_it() + " - " + startBusStation.getName_de(),
                  endBusStation.getName_it() + " - " + endBusStation.getName_de(),
                  yyyymmddhhmm,
                  response);
   }

   public static void calcRouting(String startBusStationNameItDe,
                                  String endBusStationNameItDe,
                                  long yyyymmddhhmm,
                                  SASAbusDBDataReady<ConRes> response) throws Exception
   {
      ReqC startBusStationRequest = new ReqC(startBusStationNameItDe);
      ResC startBusStationResponse = new ResC();
      queryTravelPlanner(startBusStationRequest, "ReqC", startBusStationResponse);

      ReqC endBusStationRequest = new ReqC(endBusStationNameItDe);
      ResC endBusStationResponse = new ResC();
      queryTravelPlanner(endBusStationRequest, "ReqC", endBusStationResponse);

      ReqC routeRequest = new ReqC(startBusStationResponse.getLocValRes().getStations()[0],
                                   endBusStationResponse.getLocValRes().getStations()[0],
                                   yyyymmddhhmm);
      ResC routeResponse = new ResC();
      queryTravelPlanner(routeRequest, "ReqC", routeResponse);

      response.ready(routeResponse.getConRes()[0]);
   }

   @Override
   public void nextRoute(String context, SASAbusDBDataReady<ConRes> response) throws Exception
   {
      nextRouteImpl(context, response);
   }

   public static void nextRouteImpl(String context, SASAbusDBDataReady<ConRes> response) throws Exception
   {
      ReqC nextRouteRequest = new ReqC(new ConScrReq(context));
      ResC routeResponse = new ResC();
      queryTravelPlanner(nextRouteRequest, "ReqC", routeResponse);
      response.ready(routeResponse.getConRes()[0]);
   }

   static void queryTravelPlanner(Object requestObject, String rootTagName, Object response) throws Exception
   {
      XMLStructureRules rules = new XMLStructureRules();
      rules.setPrimitiveTypePolicy(PrimitiveTypePolicy.ATTRIBUTE);
      XMLStructure xmlStructure = new XMLStructure(rootTagName, rules);
      SASAbusBackendMarshaller marshaller = new SASAbusBackendMarshaller();
      marshaller.marschall(requestObject, xmlStructure);

      URL url = new URL("http://xml.opensasa.info/bin/extxml.bin");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      String requestXmlText = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + xmlStructure.toString();
      OutputStream out = connection.getOutputStream();
      out.write(requestXmlText.getBytes("utf-8"));
      out.close();

      InputStream inputStream = connection.getInputStream();

      ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
      int len;
      byte[] buf = new byte[10000];
      while ((len = inputStream.read(buf)) > 0)
      {
         arrayOutputStream.write(buf, 0, len);
      }
      connection.disconnect();
      String responseXmlText = arrayOutputStream.toString("utf-8");
      inputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());

      W3CXMLStructure w3cxmlStructure = new W3CXMLStructure(inputStream);
      SASAbusBackendUnmarshaller unmarshaller = new SASAbusBackendUnmarshaller();
      unmarshaller.unmarschall(w3cxmlStructure, response);
      inputStream.close();

   }

   @Override
   public void loadNews(SASAbusDBDataReady<NewsList> response)
   {
      throw new IllegalStateException("loadNews is implemented with a separate servlet!");
   }

   @Override
   public void loadParkingInfo(String parkingid, SASAbusDBDataReady<ParkingInfo> response)
   {
      throw new IllegalStateException("loadParkingInfo is implemented with a separate servlet!");
   }

   @Override
   public void loadParkingFreeSlots(String parkingid, SASAbusDBDataReady<FreeSlots> response)
   {
      throw new IllegalStateException("loadParkingFreeSlots is implemented with a separate servlet!");
   }
}
