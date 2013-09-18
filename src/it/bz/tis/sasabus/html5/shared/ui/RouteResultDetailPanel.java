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

import it.bz.tis.sasabus.backend.shared.travelplanner.BasicStop;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConSection;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConSectionList;
import it.bz.tis.sasabus.html5.shared.ui.icon.BusIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.DownIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.RouteEndIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.WalkIcon;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMHashNavigationPanel;
import bz.davide.dmweb.shared.DMLabel;
import bz.davide.dmweb.shared.i18n.I18N;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class RouteResultDetailPanel extends DMFlowPanel
{
   public RouteResultDetailPanel(ConSectionList data, DMHashNavigationPanel navigationPanel)
   {
      super("route-result");
      this.addStyleName("bus-trip-detail");
      for (ConSection conSection : data.getConSections())
      {
         DMFlowPanel busName = new DMFlowPanel("bus-name");
         if (conSection.getWalks().length > 0)
         {
            busName.add(new WalkIcon());
            busName.add(new DMLabel(I18N.singleton.getLocalizedText("RouteResultDetailPanel_walk_for") +
                                    ": " +
                                    RouteResultOverviewPanel.formatTime(conSection.getWalks()[0].getDuration().getTime())));
            this.add(busName);
            continue;
         }
         busName.add(new BusIcon());
         busName.add(new DMLabel(conSection.getJourneys()[0].getBusLineNumber()));
         this.add(busName);
         BasicStop[] basicStop = conSection.getJourneys()[0].getPassList().getBasicStops();
         String time = "";
         if (basicStop[0].getArr() != null)
         {
            time = RouteResultOverviewPanel.formatTime(basicStop[0].getArr().getTime());
         }
         this.add(newRow(time, splitName(basicStop[0].getStation().getName())));

         this.add(new DownIcon());

         time = "";
         if (basicStop[basicStop.length - 1].getArr() != null)
         {
            time = RouteResultOverviewPanel.formatTime(basicStop[basicStop.length - 1].getArr().getTime());
         }
         this.add(newRow(time, splitName(basicStop[basicStop.length - 1].getStation().getName())));
      }
      DMFlowPanel busName = new DMFlowPanel("bus-name");
      busName.add(new RouteEndIcon());
      busName.add(new DMLabel(I18N.singleton.getLocalizedText("RouteResultDetailPanel_you_arrive")));
      this.add(busName);
   }

   static DMFlowPanel newRow(String time, String[] names)
   {
      DMFlowPanel row = new DMFlowPanel("row");
      DMLabel timeLabel = new DMLabel(time);
      timeLabel.setStyleName("time");
      row.add(timeLabel);
      row.add(new ItDeNamePanel(names[0], names[1], null));
      return row;
   }

   static String[] splitName(String itDe)
   {
      int pos = itDe.indexOf(" - ");
      if (pos < 0)
      {
         return new String[] { itDe, itDe };
      }
      return new String[] { itDe.substring(0, pos), itDe.substring(pos + 1) };
   }
}
