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
import it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N;
import it.bz.tis.sasabus.html5.shared.data.Parking;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

public class ParkingsPanel extends DivView
{
   public ParkingsPanel(final DMHashNavigationPanel navPanel,
                        final AreaList areaList,
                        final SASAbusMap map,
                        final BusStationCustomViewAndI18N custom)
   {
      super();
      this.appendChild(new SpanView(custom.getI18n().getLocalizedText("ParkingsPanel_title") + ":"));
      for (final Parking park : Parking.list)
      {
         RowItem rowItem = new RowItem(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               navPanel.newPage(new ParkingPanel(park, navPanel, areaList, map, custom));
            }
         });
         rowItem.appendChild(new ItDeNamePanel(park.getName_it(), park.getName_de(), null, custom.getI18n()));
         this.appendChild(rowItem);
      }
   }
}
