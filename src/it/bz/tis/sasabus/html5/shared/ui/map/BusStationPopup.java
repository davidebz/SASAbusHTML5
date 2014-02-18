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

package it.bz.tis.sasabus.html5.shared.ui.map;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.html5.shared.ui.BusLinePanel;
import it.bz.tis.sasabus.html5.shared.ui.BusStationPanel;
import it.bz.tis.sasabus.html5.shared.ui.ItDeBusStationNamePanel;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusStationPopup extends DivView
{
   BusStation            busStation;
   DMHashNavigationPanel navigationPanel;
   SASAbusMap            map;
   AreaList              areaList;

   public BusStationPopup(BusStation busStation,
                          DMHashNavigationPanel navigationPanel,
                          SASAbusMap map,
                          AreaList areaList)
   {
      super(new DivView.InitParameters("sasabus-popup"));
      this.busStation = busStation;
      this.navigationPanel = navigationPanel;
      this.map = map;
      this.areaList = areaList;
   }

   void init()
   {
      this.appendChild(new ItDeBusStationNamePanel(this.busStation));
      ButtonView details = new ButtonView(new ButtonView.InitParameters("Show details"));
      this.appendChild(details);
      details.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            BusStationPopup.this.navigationPanel.newPage(new BusStationPanel(BusStationPopup.this.busStation,
                                                                             BusStationPopup.this.areaList,
                                                                             BusStationPopup.this.navigationPanel,
                                                                             BusStationPopup.this.map));
            BusStationPopup.this.map.leafletMap.closePopup();
         }
      });
      for (final BusLine busLine : this.busStation.getBusLines())
      {
         ButtonView button = new ButtonView(new ButtonView.InitParameters(busLine.getNumber()));
         button.addClickHandler(new DMClickHandler()
         {

            @Override
            public void onClick(DMClickEvent event)
            {
               BusStationPopup.this.navigationPanel.newPage(new BusLinePanel(busLine,
                                                                             BusStationPopup.this.areaList,
                                                                             BusStationPopup.this.navigationPanel,
                                                                             BusStationPopup.this.map,
                                                                             true));
            }
         });
         this.appendChild(button);
      }
   }
}
