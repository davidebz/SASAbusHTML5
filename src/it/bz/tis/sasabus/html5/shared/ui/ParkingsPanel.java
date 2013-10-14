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
import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMHashNavigationPanel;
import bz.davide.dmweb.shared.DMLabel;

public class ParkingsPanel extends DMFlowPanel
{
   public ParkingsPanel(final DMHashNavigationPanel navPanel, final AreaList areaList, final SASAbusMap map)
   {
      this.add(new DMLabel("Parkings:"));
      for (final Parking park : Parking.list)
      {
         RowItem rowItem = new RowItem(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               navPanel.newPage(new ParkingPanel(park, navPanel, areaList, map));
            }
         });
         rowItem.add(new ItDeNamePanel(park.getName_it(), park.getName_de(), null));
         this.add(rowItem);
      }
   }
}
