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

import it.bz.tis.sasabus.backend.shared.travelplanner.BasicStop;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConSection;
import it.bz.tis.sasabus.backend.shared.travelplanner.ConSectionList;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class RouteResultDetailPanel extends DivView
{
   public RouteResultDetailPanel(ConSectionList data, DMHashNavigationPanel navigationPanel, final SASAbusI18N i18n)
   {
      super("route-result");
      this.addStyleName("bus-trip-detail");
      for (ConSection conSection : data.getConSections())
      {
         DivView busName = new DivView("bus-name");
         if (conSection.getWalks().length > 0)
         {
            busName.appendChild(Icon.newWalkIcon());
            busName.appendChild(new SpanView(i18n.getLocalizedText("RouteResultDetailPanel_walk_for")
                                                                         + ": "
                                                                         + RouteResultOverviewPanel.formatTime(conSection.getWalks()[0].getDuration().getTime())));
            this.appendChild(busName);
            continue;
         }
         busName.appendChild(Icon.newBusIcon());
         busName.appendChild(new SpanView(conSection.getJourneys()[0].getBusLineNumber()));
         this.appendChild(busName);
         final BasicStop[] basicStop = conSection.getJourneys()[0].getPassList().getBasicStops();
         String time = "";
         if (basicStop[0].getArr() != null)
         {
            time = RouteResultOverviewPanel.formatTime(basicStop[0].getArr().getTime());
         }
         this.appendChild(newRow(time, splitName(basicStop[0].getStation().getName()), i18n));

         if (basicStop.length > 2)
         {
            final DivView allStopsPanel = new DivView();
            this.appendChild(allStopsPanel);
            Icon downIcon = Icon.newDownIcon();
            allStopsPanel.appendChild(downIcon);
            downIcon.addClickHandler(new DMClickHandler()
            {
               @Override
               public void onClick(DMClickEvent event)
               {
                  allStopsPanel.clear();
                  for (int i = 1; i < basicStop.length - 1; i++)
                  {
                     String time = "";
                     if (basicStop[i].getArr() != null)
                     {
                        time = RouteResultOverviewPanel.formatTime(basicStop[i].getArr().getTime());
                     }
                     allStopsPanel.appendChild(newRow(time, splitName(basicStop[i].getStation().getName()), i18n));
                  }
               }
            });
         }

         time = "";
         if (basicStop[basicStop.length - 1].getArr() != null)
         {
            time = RouteResultOverviewPanel.formatTime(basicStop[basicStop.length - 1].getArr().getTime());
         }
         this.appendChild(newRow(time, splitName(basicStop[basicStop.length - 1].getStation().getName()), i18n));
      }
      DivView busName = new DivView("bus-name");
      busName.appendChild(Icon.newRouteEndIcon());
      busName.appendChild(new SpanView(i18n.getLocalizedText("RouteResultDetailPanel_you_arrive")));
      this.appendChild(busName);
   }

   static DivView newRow(String time, String[] names, final SASAbusI18N i18n)
   {
      DivView row = new DivView("row");
      SpanView timeLabel = new SpanView(time);
      timeLabel.setStyleName("time");
      row.appendChild(timeLabel);
      row.appendChild(new ItDeNamePanel(names[0], names[1], null, i18n));
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
