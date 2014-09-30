/*
SASAbusHTML5 - HTML5 App for SASA bus

Copyright (C) 2013 TIS Innovation Park - Bolzano/Bozen - Italy
Copyright (C) 2013-2014 Davide Montesin <d@vide.bz> - Bolzano/Bozen - Italy

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

package it.bz.tis.sasabus.html5.shared.ui;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.client.SASAbusHTML5;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import java.util.Date;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class RouteSearchPanel extends DivView implements PageChangeHandler
{
   public static BusStation    start = null;
   public static BusStation    end   = null;

   SASAbusMap                  map;

   SASAbusDateBox              dateBox;

   final ButtonView            search;
   final DMHashNavigationPanel navigationPanel;

   DivView                     results;

   final SASAbusI18N           i18n;

   public RouteSearchPanel(AreaList areaList,
                           final DMHashNavigationPanel navigationPanel,
                           SASAbusMap map,
                           final SASAbusI18N i18n)
   {
      super("route");
      this.map = map;
      this.navigationPanel = navigationPanel;
      this.i18n = i18n;

      SpanView introText = new SpanView(i18n.getLocalizedText("RouteSearchPanel_title"));
      introText.setStyleName("intro-text");
      this.appendChild(introText);

      this.appendChild(new BusStationSearchWidget(i18n.getLocalizedText("RouteSearchPanel_start_station"),
                                                  map,
                                                  areaList,
                                                  new BusStationSelectedEventHandler()
                                                  {
                                                     @Override
                                                     public void selected(BusStation busStation)
                                                     {
                                                        RouteSearchPanel.start = busStation;
                                                     }
                                                  },
                                                  start,
                                                  i18n));
      this.appendChild(new BusStationSearchWidget(i18n.getLocalizedText("RouteSearchPanel_end_station"),
                                                  map,
                                                  areaList,
                                                  new BusStationSelectedEventHandler()
                                                  {
                                                     @Override
                                                     public void selected(BusStation busStation)
                                                     {
                                                        RouteSearchPanel.end = busStation;
                                                     }
                                                  },
                                                  end,
                                                  i18n));

      this.appendChild(new SpanView(i18n.getLocalizedText("RouteSearchPanel_when") + ":"));
      this.appendChild(this.dateBox = new SASAbusDateBox(i18n, null));

      this.search = new ButtonView(i18n.getLocalizedText("RouteSearchPanel_search"));
      this.appendChild(this.search);
      this.search.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            
            Date date = RouteSearchPanel.this.dateBox.getValue();
            DateTimeFormat dtf = DateTimeFormat.getFormat("yyyyMMddHHmm");

            final long yyyymmddhhmm = Long.parseLong(dtf.format(date));

            try
            {

               if (RouteSearchPanel.start == null || RouteSearchPanel.end == null)
               {
                  console_log(i18n);
                  String localizedText = i18n.getLocalizedText("RouteSearchPanel_no_start_or_stop");
                  console_log(localizedText);
                  Window.alert(localizedText);
               }
               else
               {
               
                  RouteSearchPanel.this.search.setLabel(i18n.getLocalizedText("RouteSearchPanel_calculating_routing"));
                  RouteSearchPanel.this.search.getElement().setAttribute("disabled", "disabled");
                  RouteSearchPanel.this.results.clear();

                  String startId = RouteSearchPanel.start.getId();
                  String endId = RouteSearchPanel.end.getId();
                  
                  SASAbusHTML5.trackUsage("route", "");

                  SASAbusDBClientImpl.singleton.calcRoute(startId,
                                                          endId,
                                                          yyyymmddhhmm,
                                                          new SASAbusDBDataReady<ConRes>()
                                                          {
                                                             @Override
                                                             public void ready(ConRes data)
                                                             {
                                                                RouteSearchPanel.this.onFirstRouteReceived(data);
                                                             }
                                                          });
               }
            }
            catch (Exception exxx)
            {
               SASAbusHTML5.handleException(exxx);
            }
         }
      });
      this.appendChild(this.results = new DivView("results"));
   }

   private void onFirstRouteReceived(ConRes data0)
   {

      final ConRes[] routes = new ConRes[3];
      routes[0] = data0;

      try
      {
         SASAbusDBClientImpl.singleton.nextRoute(data0.getConResCtxt()[0], new SASAbusDBDataReady<ConRes>()
         {

            @Override
            public void ready(ConRes data1)
            {
               try
               {
                  routes[1] = data1;
                  SASAbusDBClientImpl.singleton.nextRoute(data1.getConResCtxt()[0],
                                                          new SASAbusDBDataReady<ConRes>()
                                                          {

                                                             @Override
                                                             public void ready(ConRes data2)
                                                             {
                                                                routes[2] = data2;
                                                                RouteSearchPanel.this.results.appendChild(new RouteResultOverviewPanel(routes,
                                                                                                                                       RouteSearchPanel.this.navigationPanel,
                                                                                                                                       RouteSearchPanel.this.i18n));
                                                                RouteSearchPanel.this.search.setLabel(RouteSearchPanel.this.i18n.getLocalizedText("RouteSearchPanel_search"));
                                                                RouteSearchPanel.this.search.getElement().removeAttribute("disabled");
                                                             }
                                                          });
               }
               catch (Exception e)
               {
                  SASAbusHTML5.handleException(e);
                  return;
               }
            }
         });
      }
      catch (Exception e)
      {
         SASAbusHTML5.handleException(e);
         return;
      }

   }

   @Override
   public void pageShow()
   {
      this.map.hide();
   }

   @Override
   public void pageHide()
   {

   }

   static native void console_log(Object obj)/*-{
		console.log(obj)
   }-*/;

}
