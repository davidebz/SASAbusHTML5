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
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.i18n.I18N;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;

public class BusStationSearchRoutePanel extends DivView implements PageChangeHandler
{
   BusStationSearchWidget searchWidget;
   RouteSearchPanel       routeSearchPanel;

   public BusStationSearchRoutePanel(AreaList areaList,
                                     SASAbusMap map,
                                     DMHashNavigationPanel navigationPanel,
                                     BusStationSelectedEventHandler selected)
   {
      super(new DivView.InitParameters("bus-stations-search-route"));
      this.appendChild(this.searchWidget = new BusStationSearchWidget(I18N.singleton.getLocalizedText("BusStationSearchWidget_introtext"),
                                                              map,
                                                              areaList,
                                                              selected));
      this.appendChild(this.routeSearchPanel = new RouteSearchPanel(areaList, navigationPanel, map));
   }

   @Override
   public void pageShow()
   {
   };

   @Override
   public void pageHide()
   {
   }
}
