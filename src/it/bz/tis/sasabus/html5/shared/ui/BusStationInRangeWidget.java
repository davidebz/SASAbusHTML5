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
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IdentityHashMap;

import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

public class BusStationInRangeWidget extends DivView
{
   public BusStationInRangeWidget(double lat,
                                  double lon,
                                  final DMHashNavigationPanel navigationPanel,
                                  final AreaList areaList,
                                  final SASAbusMap map)
   {
      super(new DivView.InitParameters("nearest-bus-stops"));
      this.appendChild(new SpanView(new SpanView.InitParameters("Nearest bus stops: ")));

      final IdentityHashMap<BusStation, Double> weights = new IdentityHashMap<BusStation, Double>();

      BusStation[] busStations = areaList.getBusStations();
      final BusStation[] copy = new BusStation[busStations.length];
      for (int i = 0; i < copy.length; i++)
      {
         copy[i] = busStations[i];
         double weight = (copy[i].getBusStops()[0].getLat() - lat) *
                         (copy[i].getBusStops()[0].getLat() - lat) +
                         (copy[i].getBusStops()[0].getLon() - lon) *
                         (copy[i].getBusStops()[0].getLon() - lon);
         weights.put(copy[i], weight);
      }
      Arrays.sort(copy, new Comparator<BusStation>()
      {
         @Override
         public int compare(BusStation o1, BusStation o2)
         {
            double diff = weights.get(o1) - weights.get(o2);
            if (diff == 0)
            {
               return 0;
            }
            if (diff > 0)
            {
               return 1;
            }
            return -1;
         }
      });

      for (int i = 0; i < copy.length && i < 5; i++)
      {
         final int ii = i;
         RowItem rowItem = new RowItem(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               navigationPanel.newPage(new BusStationPanel(copy[ii], areaList, navigationPanel, map));
            }
         });
         rowItem.appendChild(new ItDeNamePanel(copy[i].getName_it(), copy[i].getName_de(), null));
         this.appendChild(rowItem);
      }
   }
}
