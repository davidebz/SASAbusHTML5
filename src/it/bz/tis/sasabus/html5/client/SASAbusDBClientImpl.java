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

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusTripStopList;
import it.bz.tis.sasabus.backend.shared.NewsList;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendUnmarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusDB;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.SASAbusDBLastModified;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import bz.davide.dmweb.shared.DMWidget;
import bz.davide.dmxmljson.unmarshalling.json.gwt.GWTStructure;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.jsonp.client.JsonpRequestBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusDBClientImpl implements SASAbusDB
{

   public static SASAbusDB singleton = null;

   String                  serviceBaseUrl;

   public SASAbusDBClientImpl(String serviceBaseUrl)
   {
      super();
      this.serviceBaseUrl = serviceBaseUrl;
   }

   @Override
   public void loadNews(SASAbusDBDataReady<NewsList> response)
   {
      this.connect("news?nocache=" + System.currentTimeMillis(), "NewsList", response);
   }

   @Override
   public void lastModified(SASAbusDBDataReady<SASAbusDBLastModified> response)
   {
      this.connect("sasabusdb/lastModified?nocache=" + System.currentTimeMillis(),
                   "SASAbusDBLastModified",
                   response);
   }

   @Override
   public void listBusAreasLinesStopsStations(final SASAbusDBDataReady<AreaList> response)
   {

      SASAbusDBClientImpl.this.connect("sasabusdb/listBusAreasLinesStopsStations", "AreaList", response);

   }

   @Override
   public void findBusStationDepartures(String busStationId,
                                        long yyyymmddhhmm,
                                        SASAbusDBDataReady<BusTripStopList> response)
   {
      this.connect("sasabusdb/findBusStationDepartures?busStationId=" +
                   busStationId +
                   "&yyyymmddhhmm=" +
                   yyyymmddhhmm, "BusTripStopList", response);
   }

   @Override
   public void calcRoute(String startBusStationId,
                         String endBusStationId,
                         long yyyymmddhhmm,
                         SASAbusDBDataReady<ConRes> response) throws Exception
   {
      this.connect("sasabusdb/calcRoute?startBusStationId=" +
                   startBusStationId +
                   "&endBusStationId=" +
                   endBusStationId +
                   "&yyyymmddhhmm=" +
                   yyyymmddhhmm, "ConRes", response);
   }

   @Override
   public void nextRoute(String context, SASAbusDBDataReady<ConRes> response) throws Exception
   {
      this.connect("sasabusdb/nextRoute?context=" + DMWidget.escapeText4url(context), "ConRes", response);
   }

   private <T> void connect(String methodUri,
                            final String unmarshallerRootClassSimpleName,
                            final SASAbusDBDataReady<T> callback)
   {
      final int i[] = new int[] { 0 };
      final long[] times = new long[6];
      times[i[0]++] = System.currentTimeMillis();

      JsonpRequestBuilder jsonpRequestBuilder = new JsonpRequestBuilder();
      jsonpRequestBuilder.requestObject(this.serviceBaseUrl + methodUri,
                                        new AsyncCallback<JavaScriptObject>()
                                        {
                                           @Override
                                           public void onSuccess(JavaScriptObject result)
                                           {
                                              times[i[0]++] = System.currentTimeMillis();
                                              SASAbusBackendUnmarshaller unmarshaller = new SASAbusBackendUnmarshaller();
                                              times[i[0]++] = System.currentTimeMillis();
                                              JSONObject jsonObject = new JSONObject(result);
                                              GWTStructure gwtStructure = new GWTStructure(jsonObject);
                                              try
                                              {
                                                 times[i[0]++] = System.currentTimeMillis();
                                                 Object obj = unmarshaller.newInstance(unmarshallerRootClassSimpleName);
                                                 times[i[0]++] = System.currentTimeMillis();
                                                 unmarshaller.unmarschall(gwtStructure, obj);
                                                 times[i[0]++] = System.currentTimeMillis();

                                                 String report = "";

                                                 for (int k = 0; k < times.length - 1; k++)
                                                 {
                                                    report += "Time " +
                                                              k +
                                                              ": " +
                                                              (times[k + 1] - times[k]) +
                                                              "\n";
                                                 }

                                                 callback.ready((T) obj);
                                              }
                                              catch (Exception e)
                                              {
                                                 this.onFailure(e);
                                              }

                                           }

                                           @Override
                                           public void onFailure(Throwable caught)
                                           {
                                              caught.printStackTrace();
                                              Window.alert("ko contacting server: " +
                                                           caught.getClass().getName() +
                                                           " - " +
                                                           caught.getMessage());
                                           }
                                        });
   }

}
