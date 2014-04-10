/*
SASAbusHTML5 - HTML5 App for SASA bus

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
import it.bz.tis.sasabus.html5.shared.BusRoutingViewFactory;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivViewChild;

public class SASABzRoutingViewFactory implements BusRoutingViewFactory
{
   @Override
   public DivViewChild createView(AreaList areaList,
                                  DMHashNavigationPanel navigationPanel,
                                  SASAbusMap map,
                                  SASAbusI18N i18n)
   {
      return new RouteSearchPanel(areaList, navigationPanel, map, i18n);
   }
}
