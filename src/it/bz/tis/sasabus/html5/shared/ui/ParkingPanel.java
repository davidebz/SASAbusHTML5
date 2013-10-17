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
import it.bz.tis.sasabus.html5.shared.data.Parking;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.client.leaflet.LatLng;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;

public class ParkingPanel extends DivView implements PageChangeHandler
{
   SASAbusMap map;
   Parking    parking;

   public ParkingPanel(final Parking parking,
                       final DMHashNavigationPanel navPanel,
                       final AreaList areaList,
                       final SASAbusMap map)
   {
      super("parking-panel");
      this.map = map;
      this.parking = parking;

      this.appendChild(new ItDeNamePanel(parking.getName_it(), parking.getName_de(), null));

      this.appendChild(new BusStationInRangeWidget(parking.getLat(), parking.getLon(), navPanel, areaList, map));
   }

   @Override
   public void pageShow()
   {
      this.map.getLeafletMap().setView(new LatLng(this.parking.getLat(), this.parking.getLon()), 16);

   }

   @Override
   public void pageHide()
   {
   }

}
