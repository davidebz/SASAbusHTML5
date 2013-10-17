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

package it.bz.tis.sasabus.html5.shared.ui;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.client.SASAbusHTML5;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;

import java.util.Date;

import bz.davide.dmweb.shared.i18n.I18N;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;

import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class RouteSearchPanel extends DivView implements PageChangeHandler
{
   public static BusStation    start = null;
   public static BusStation    end   = null;

   SASAbusMap                  map;

   SASAbusDateBox              dateBox;

   final ButtonView              search;
   final DMHashNavigationPanel navigationPanel;

   DivView                 results;

   public RouteSearchPanel(AreaList areaList, final DMHashNavigationPanel navigationPanel, SASAbusMap map)
   {
      super("route");
      this.map = map;
      this.navigationPanel = navigationPanel;

      SpanView introText = new SpanView("Route calculation");
      introText.setStyleName("intro-text");
      this.appendChild(introText);

      this.appendChild(new BusStationSearchWidget(I18N.singleton.getLocalizedText("RouteSearchPanel_start_station"),
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
                                          start));
      this.appendChild(new BusStationSearchWidget(I18N.singleton.getLocalizedText("RouteSearchPanel_end_station"),
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
                                          end));

      this.appendChild(new SpanView(I18N.singleton.getLocalizedText("RouteSearchPanel_when") + ":"));
      this.appendChild(this.dateBox = new SASAbusDateBox());

      this.search = new ButtonView(I18N.singleton.getLocalizedText("RouteSearchPanel_search"));
      this.appendChild(this.search);
      this.search.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            RouteSearchPanel.this.search.setLabel(I18N.singleton.getLocalizedText("RouteSearchPanel_calculating_routing"));
            RouteSearchPanel.this.results.clear();

            Date date = RouteSearchPanel.this.dateBox.getValue();
            DateTimeFormat dtf = DateTimeFormat.getFormat("yyyyMMddHHmm");

            final long yyyymmddhhmm = Long.parseLong(dtf.format(date));

            try
            {

               SASAbusDBClientImpl.singleton.calcRoute(RouteSearchPanel.start.getId(),
                                                       RouteSearchPanel.end.getId(),
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
                                                                                                                               RouteSearchPanel.this.navigationPanel));
                                                                RouteSearchPanel.this.search.setLabel("Search");
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

}
