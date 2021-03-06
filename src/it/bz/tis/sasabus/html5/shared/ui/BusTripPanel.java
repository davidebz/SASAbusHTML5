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
import it.bz.tis.sasabus.backend.shared.BusTrip;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusTripPanel extends DivView implements PageChangeHandler
{

   public BusTripPanel(BusLine busLine,
                       final BusTrip busTrip,
                       final int index,
                       final AreaList areaList,
                       final SASAbusMap map,
                       final SASAbusI18N i18n)
   {
      super("bus-trip-detail");

      Icon mapIcon = Icon.newMapIcon();
      mapIcon.addStyleName("only-mobile");
      this.appendChild(mapIcon);

      map.highlightFitBusTrip(busTrip, index);

      mapIcon.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            map.show();
         }
      });

      int startIndex = index - 3;
      if (startIndex < 0)
      {
         startIndex = 0;
      }

      final BusTripStop[] busTripStops = busTrip.getBusTripStops();
      if (startIndex > 0)
      {
         final DivView prevStops = new DivView("prev-stops");
         this.appendChild(prevStops);
         ButtonView prevStopsButton = new ButtonView(i18n.getLocalizedText("BusTripPanel_show_prev_stops"));
         prevStops.appendChild(prevStopsButton);

         final int startIndexFinal = startIndex;
         prevStopsButton.addClickHandler(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               prevStops.clear();
               for (int i = 0; i < startIndexFinal; i++)
               {
                  BusTripStop busTripStop = busTripStops[i];
                  BusTripPanel.this.buildRow(busTripStop, i, index, areaList, prevStops, i18n);
               }
            }
         });

      }
      for (int i = startIndex; i < busTripStops.length; i++)
      {
         BusTripStop busTripStop = busTripStops[i];
         this.buildRow(busTripStop, i, index, areaList, this, i18n);
      }
   }

   void buildRow(BusTripStop busTripStop,
                 int i,
                 int index,
                 AreaList areaList,
                 DivView container,
                 final SASAbusI18N i18n)
   {
      BusStation busStation = areaList.findBusStopById(busTripStop.getBusStopId()).getBusStation();
      DivView row = new DivView("row");
      SpanView time = new SpanView(BusStationPanel.formatTime(busTripStop.getTimeHHMMSS()));
      row.appendChild(time);
      time.setStyleName("time");
      row.appendChild(new ItDeBusStationNamePanel(busStation, i18n));

      if (i < index)
      {
         row.addStyleName("prev");
      }
      else if (i == index)
      {
         row.addStyleName("current");
      }
      else
      {
         row.addStyleName("next");
      }
      container.appendChild(row);
   }

   @Override
   public void pageShow()
   {

   }

   @Override
   public void pageHide()
   {
   }
}
