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
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.backend.shared.BusTripStopList;
import it.bz.tis.sasabus.backend.shared.BusTripStopReference;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.shared.ui.icon.MapIcon;
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
public class BusStationPanel extends DivView implements PageChangeHandler
{
   BusStation            busStation;
   DivView               departures;
   AreaList              areaList;
   DMHashNavigationPanel content;
   SASAbusMap            map;

   SASAbusDateBox        dateBox;

   public BusStationPanel(final BusStation busStation,
                          final AreaList areaList,
                          final DMHashNavigationPanel navPanel,
                          final SASAbusMap map)
   {
      super(new DivView.InitParameters("bus-station-detail"));
      this.busStation = busStation;
      this.areaList = areaList;
      this.content = navPanel;
      this.map = map;

      this.appendChild(new ItDeBusStationNamePanel(busStation));

      DivView actions = new DivView(new DivView.InitParameters("actions"));

      MapIcon mapIcon = new MapIcon(new MapIcon.InitParameters());
      mapIcon.addStyleName("only-mobile");
      actions.appendChild(mapIcon);
      mapIcon.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            map.show();
         }
      });

      this.appendChild(actions);

      DivView lines = new DivView(new DivView.InitParameters("lines"));

      lines.appendChild(new SpanView(new SpanView.InitParameters(I18N.singleton.getLocalizedText("BusLines") + ":")));

      BusLine[] busLines = busStation.getBusLines();
      BusLine.sortByNumber(busLines);
      for (int i = 0; i < busLines.length; i++)
      {
         final BusLine busLine = busStation.getBusLines()[i];
         ButtonView showLine = new ButtonView(new ButtonView.InitParameters(busLine.getNumber()));
         lines.appendChild(showLine);
         showLine.addClickHandler(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               navPanel.newPage(new BusLinePanel(busLine, areaList, navPanel, map, false));
            }
         });
      }
      this.appendChild(lines);

      //this.add(new DMLabel(I18N.singleton.getLocalizedText("BusStationPanel_directions") + ":"));

      ButtonView nextDepartures = new ButtonView(new ButtonView.InitParameters(I18N.singleton.getLocalizedText("BusStationPanel_refresh_departures")));
      ButtonView asStart = new ButtonView(new ButtonView.InitParameters(I18N.singleton.getLocalizedText("BusStationPanel_use_as_start_routing")));
      ButtonView asEnd = new ButtonView(new ButtonView.InitParameters(I18N.singleton.getLocalizedText("BusStationPanel_use_as_end_routing")));
      this.appendChild(asStart);
      this.appendChild(asEnd);
      DivView departureInputPanel = new DivView(new DivView.InitParameters("departure-input"));
      this.appendChild(departureInputPanel);

      departureInputPanel.appendChild(new SpanView(new SpanView.InitParameters("Next departures")));

      asStart.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            RouteSearchPanel.start = busStation;
            navPanel.newPage(new BusStationSearchRoutePanel(areaList, map, navPanel, null));
         }
      });

      asEnd.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            RouteSearchPanel.end = busStation;
            navPanel.newPage(new BusStationSearchRoutePanel(areaList, map, navPanel, null));
         }
      });

      final DMClickHandler retrieveNextDepartureHandler = new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            BusStationPanel busStationDetail = BusStationPanel.this;
            busStationDetail.findBusStationDepartures();
         }
      };
      nextDepartures.addClickHandler(retrieveNextDepartureHandler);

      this.appendChild(this.departures = new DivView(new DivView.InitParameters("departures")));

      this.dateBox = new SASAbusDateBox(new SASAbusDateBox.InitParameters());
      departureInputPanel.appendChild(this.dateBox);

      departureInputPanel.appendChild(nextDepartures);

      // Immediately show next departures from now!
      retrieveNextDepartureHandler.onClick(null);
   }

   public void findBusStationDepartures()
   {
      this.departures.clear();
      this.departures.appendChild(new SpanView(new SpanView.InitParameters(I18N.singleton.getLocalizedText("BusStationPanel_calculating_departures"))));

      Date date = this.dateBox.getValue();

      DateTimeFormat dtf = DateTimeFormat.getFormat("yyyyMMddHHmm");

      String tmp = dtf.format(date);

      final long yyyymmddhhmm = Long.parseLong(tmp);

      SASAbusDBClientImpl.singleton.findBusStationDepartures(this.busStation.getId(),
                                                             yyyymmddhhmm,
                                                             new SASAbusDBDataReady<BusTripStopList>()
                                                             {

                                                                @Override
                                                                public void ready(BusTripStopList data)
                                                                {
                                                                   showDepartures(BusStationPanel.this.departures,
                                                                                  data,
                                                                                  BusStationPanel.this.areaList,
                                                                                  BusStationPanel.this.content,
                                                                                  BusStationPanel.this.map);
                                                                }
                                                             });
   }

   private static void showDepartures(DivView departures,
                                      BusTripStopList data,
                                      final AreaList areaList,
                                      final DMHashNavigationPanel content,
                                      final SASAbusMap map)
   {
      departures.clear();
      // Dummy, only to cache bus stations!
      areaList.getBusStations();
      for (final BusTripStopReference busTripStopRef : data.getBusTripStops())
      {
         BusTripStop[] busTripStops = busTripStopRef.getBusTrip().getBusTripStops();
         BusTripStop busTripStop = busTripStops[busTripStopRef.getIndex()];
         final BusLine busLine = areaList.findBusLineById(busTripStopRef.getBusTrip().getBusLineId());

         RowItem rowItem = new RowItem(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {

               content.newPage(new BusTripPanel(busLine,
                                                busTripStopRef.getBusTrip(),
                                                busTripStopRef.getIndex(),
                                                areaList,
                                                map));

            }
         });

         rowItem.appendChild(new SpanView(new SpanView.InitParameters(formatBusTripStop(busLine, busTripStop))));
         departures.appendChild(rowItem);

      }
   }

   public static String formatBusTripStop(BusLine busLine, BusTripStop busTripStop)
   {
      return ""
             + formatTime(busTripStop.getTimeHHMMSS())
             + " - "
             + busLine.getNumber()
             + " "
             + ItDeNamePanel.asOneLine(busLine.getArea().getName_it(), busLine.getArea().getName_de());
   }

   public static String formatTime(int hhmmss)
   {
      return "" + lpad(hhmmss / 10000) + ":" + lpad(hhmmss % 10000 / 100);
   }

   private static String lpad(int nn)
   {
      String ret = String.valueOf(nn);
      while (ret.length() < 2)
      {
         ret = "0" + ret;
      }
      return ret;
   }

   @Override
   public void pageShow()
   {
      this.map.highlightFitBusStation(this.busStation);
      this.map.hide();
   }

   @Override
   public void pageHide()
   {

   }
}
