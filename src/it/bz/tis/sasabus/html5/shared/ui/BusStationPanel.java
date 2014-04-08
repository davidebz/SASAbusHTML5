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
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.backend.shared.BusTripStopList;
import it.bz.tis.sasabus.backend.shared.BusTripStopReference;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
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

   final SASAbusI18N     i18n;

   public BusStationPanel(final BusStation busStation,
                          final AreaList areaList,
                          final DMHashNavigationPanel navPanel,
                          final SASAbusMap map,
                          final BusStationCustomViewAndI18N customAndI18n)
   {
      super(new DivView.InitParameters("bus-station-detail"));
      this.busStation = busStation;
      this.areaList = areaList;
      this.content = navPanel;
      this.map = map;
      this.i18n = customAndI18n.getI18n();

      this.appendChild(new ItDeBusStationNamePanel(busStation, this.i18n));

      DivView actions = new DivView(new DivView.InitParameters("actions"));

      Icon mapIcon = Icon.newMapIcon();
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

      lines.appendChild(new SpanView(new SpanView.InitParameters(this.i18n.getLocalizedText("BusLines") + ":")));

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
               navPanel.newPage(new BusLinePanel(busLine, areaList, navPanel, map, false, customAndI18n));
            }
         });
      }
      this.appendChild(lines);

      //this.add(new DMLabel(i18n.getLocalizedText("BusStationPanel_directions") + ":"));

      ButtonView nextDepartures = new ButtonView(new ButtonView.InitParameters(this.i18n.getLocalizedText("BusStationPanel_refresh_departures")));
      ButtonView asStart = new ButtonView(new ButtonView.InitParameters(this.i18n.getLocalizedText("BusStationPanel_use_as_start_routing")));
      ButtonView asEnd = new ButtonView(new ButtonView.InitParameters(this.i18n.getLocalizedText("BusStationPanel_use_as_end_routing")));
      this.appendChild(asStart);
      this.appendChild(asEnd);

      if (customAndI18n.getBusStationCustomView() != null)
      {
         this.appendChild(customAndI18n.getBusStationCustomView().createView());
      }

      DivView departureInputPanel = new DivView(new DivView.InitParameters("departure-input"));
      this.appendChild(departureInputPanel);

      departureInputPanel.appendChild(new SpanView(new SpanView.InitParameters("Next departures")));

      asStart.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            RouteSearchPanel.start = busStation;
            navPanel.newPage(new BusStationSearchRoutePanel(areaList,
                                                            map,
                                                            navPanel,
                                                            null,
                                                            BusStationPanel.this.i18n));
         }
      });

      asEnd.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            RouteSearchPanel.end = busStation;
            navPanel.newPage(new BusStationSearchRoutePanel(areaList,
                                                            map,
                                                            navPanel,
                                                            null,
                                                            BusStationPanel.this.i18n));
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
      this.departures.appendChild(new SpanView(new SpanView.InitParameters(this.i18n.getLocalizedText("BusStationPanel_calculating_departures"))));

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
                                                                                  BusStationPanel.this.map,
                                                                                  BusStationPanel.this.i18n);
                                                                }
                                                             });
   }

   private static void showDepartures(DivView departures,
                                      BusTripStopList data,
                                      final AreaList areaList,
                                      final DMHashNavigationPanel content,
                                      final SASAbusMap map,
                                      final SASAbusI18N i18n)
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
                                                map,
                                                i18n));

            }
         });

         rowItem.appendChild(new SpanView(new SpanView.InitParameters(formatBusTripStop(busLine, busTripStop, i18n))));
         departures.appendChild(rowItem);

      }
   }

   public static String formatBusTripStop(BusLine busLine, BusTripStop busTripStop, final SASAbusI18N i18n)
   {
      return ""
             + formatTime(busTripStop.getTimeHHMMSS())
             + " - "
             + busLine.getNumber()
             + " "
             + ItDeNamePanel.asOneLine(busLine.getArea().getName_it(), busLine.getArea().getName_de(), i18n);
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
