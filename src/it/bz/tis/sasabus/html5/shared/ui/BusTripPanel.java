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
import it.bz.tis.sasabus.backend.shared.BusTrip;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.html5.shared.ui.icon.MapIcon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.DMButton;
import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMLabel;
import bz.davide.dmweb.shared.PageChangeHandler;
import bz.davide.dmweb.shared.i18n.I18N;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusTripPanel extends DMFlowPanel implements PageChangeHandler
{

   public BusTripPanel(BusLine busLine,
                       final BusTrip busTrip,
                       final int index,
                       final AreaList areaList,
                       final SASAbusMap map)
   {
      super("bus-trip-detail");

      MapIcon mapIcon = new MapIcon();
      mapIcon.addStyleName("only-mobile");
      this.add(mapIcon);

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
         final DMFlowPanel prevStops = new DMFlowPanel("prev-stops");
         this.add(prevStops);
         DMButton prevStopsButton = new DMButton(I18N.singleton.getLocalizedText("BusTripPanel_show_prev_stops"));
         prevStops.add(prevStopsButton);

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
                  BusTripPanel.this.buildRow(busTripStop, i, index, areaList, prevStops);
               }
            }
         });

      }
      for (int i = startIndex; i < busTripStops.length; i++)
      {
         BusTripStop busTripStop = busTripStops[i];
         this.buildRow(busTripStop, i, index, areaList, this);
      }
   }

   void buildRow(BusTripStop busTripStop, int i, int index, AreaList areaList, DMFlowPanel container)
   {
      BusStation busStation = areaList.findBusStopById(busTripStop.getBusStopId()).getBusStation();
      DMFlowPanel row = new DMFlowPanel("row");
      DMLabel time = new DMLabel(BusStationPanel.formatTime(busTripStop.getTimeHHMMSS()));
      row.add(time);
      time.setStyleName("time");
      row.add(new ItDeBusStationNamePanel(busStation));

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
      container.add(row);
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
