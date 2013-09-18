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

package it.bz.tis.sasabus.html5.shared.ui.menu;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.html5.shared.ui.BusStationPanel;
import it.bz.tis.sasabus.html5.shared.ui.BusStationSearchWidget;
import it.bz.tis.sasabus.html5.shared.ui.BusStationSelectedEventHandler;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;
import bz.davide.dmweb.shared.DMHashNavigationPanel;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class MenuSearchClickHandler implements DMClickHandler
{
   DMHashNavigationPanel navigationPanel;
   Menu                  menu;
   AreaList              areaList;
   SASAbusMap            map;

   public MenuSearchClickHandler(DMHashNavigationPanel navigationPanel,
                                 Menu menu,
                                 AreaList areaList,
                                 SASAbusMap map)
   {
      super();
      this.navigationPanel = navigationPanel;
      this.menu = menu;
      this.areaList = areaList;
      this.map = map;
   }

   MenuSearchClickHandler(Void void1)
   {

   }

   @Override
   public void onClick(DMClickEvent event)
   {
      this.navigationPanel.newPage(new BusStationSearchWidget(this.map,
                                                                this.areaList,
                                                                new BusStationSelectedEventHandler()
                                                                {

                                                                   @Override
                                                                   public void selected(BusStation busStation)
                                                                   {
                                                                      MenuSearchClickHandler.this.navigationPanel.newPage(new BusStationPanel(busStation,
                                                                                                                                               MenuSearchClickHandler.this.areaList,
                                                                                                                                               MenuSearchClickHandler.this.navigationPanel,
                                                                                                                                               MenuSearchClickHandler.this.map));
                                                                   }
                                                                }));
      this.menu.hide();
   };
}
