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
import it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import java.util.Arrays;
import java.util.Comparator;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusLinePanel extends DivView implements PageChangeHandler
{
   SASAbusMap map;
   BusLine    busLine;
   boolean    mapOpen;

   public BusLinePanel(BusLine busLine,
                       final AreaList areaList,
                       final DMHashNavigationPanel navPanel,
                       final SASAbusMap map,
                       boolean mapOpen,
                       final BusStationCustomViewAndI18N custom)
   {
      super("bus-stations");
      this.mapOpen = mapOpen;
      this.appendChild(new SpanView(custom.getI18n().getLocalizedText("BusLine")
                                                                + " "
                                                                + busLine.getNumber()
                                                                + " "
                                                                + ItDeNamePanel.asOneLine(busLine.getArea().getName_it(),
                                                                                          busLine.getArea().getName_de(),
                                                                                          custom.getI18n())));
      this.map = map;
      this.busLine = busLine;

      Icon mapIcon = Icon.newMapIcon();
      mapIcon.addStyleName("only-mobile");
      this.appendChild(mapIcon);
      mapIcon.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            map.show();
         }
      });

      this.appendChild(new SpanView(custom.getI18n().getLocalizedText("BusStations")));

      DivView list = new DivView("bus-stations-list");

      this.appendChild(list);

      for (final BusStation busStation : sortByCurrentLanguage(busLine.getBusStations(), custom.getI18n()))
      {
         DMClickHandler busStationClick = new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               BusStationPanel newPanel = new BusStationPanel(busStation, areaList, navPanel, map, custom);
               navPanel.newPage(newPanel);
            }
         };
         RowItem busStationLabel = new RowItem(busStationClick);
         busStationLabel.appendChild(new ItDeBusStationNamePanel(busStation, custom.getI18n()));
         list.appendChild(busStationLabel);
      }
   }

   static BusStation[] sortByCurrentLanguage(BusStation[] busStations, final SASAbusI18N i18n)
   {
      BusStation[] result = new BusStation[busStations.length];
      for (int i = 0; i < result.length; i++)
      {
         result[i] = busStations[i];
      }
      Arrays.sort(result, new Comparator<BusStation>()
      {
         @Override
         public int compare(BusStation o1, BusStation o2)
         {
            int diff;
            if (i18n.getLanguage().equals("de"))
            {
               diff = o1.getName_de().compareToIgnoreCase(o2.getName_de());
            }
            else
            {
               diff = o1.getName_it().compareToIgnoreCase(o2.getName_it());
            }
            if (diff == 0)
            {
               diff = o1.getId().compareTo(o2.getId());
            }
            return diff;
         }
      });
      return result;
   }

   @Override
   public void pageShow()
   {
      this.map.highlightFitBusLine(this.busLine);

      if (this.mapOpen)
      {
         this.map.show();
      }
      else
      {
         this.map.hide();
      }
   }

   @Override
   public void pageHide()
   {

   }

}
