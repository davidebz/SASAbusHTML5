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

import it.bz.tis.sasabus.backend.shared.travelplanner.ConRes;
import it.bz.tis.sasabus.backend.shared.travelplanner.Connection;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class RouteResultOverviewPanel extends DivView
{

   public RouteResultOverviewPanel(ConRes[] routes,
                                   final DMHashNavigationPanel navigationPanel,
                                   final SASAbusI18N i18n)
   {
      super();
      for (final ConRes conRes : routes)
      {
         final Connection connection = conRes.getConnectionList().getConnections()[0];
         RowItem rowItem = new RowItem(new DMClickHandler()
         {
            @Override
            public void onClick(DMClickEvent event)
            {
               navigationPanel.newPage(new RouteResultDetailPanel(connection.getConSectionList(),
                                                                  navigationPanel,
                                                                  i18n));
            }
         });
         String startTime = formatTime(connection.getOverview().getDeparture().getBasicStop().getDep().getTime());
         String transfers = "Transfers: " + connection.getOverview().getTransfers();
         String duration = "Duration: " + formatTime(connection.getOverview().getDuration().getTime());
         String endTime = formatTime(connection.getOverview().getArrival().getBasicStop().getArr().getTime());
         rowItem.appendChild(new SpanView(startTime + " ---> " + endTime));
         rowItem.appendChild(new SpanView(transfers + " - " + duration));
         this.appendChild(rowItem);
      }
   }

   static String formatTime(String time)
   {
      if (time.startsWith("00d"))
      {
         time = time.substring(3);
      }
      String[] timeParts = time.split(":");
      time = timeParts[0] + ":" + timeParts[1];
      return time;
   }
}
