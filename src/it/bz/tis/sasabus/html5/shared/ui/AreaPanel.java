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

import it.bz.tis.sasabus.backend.shared.Area;
import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.i18n.I18N;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class AreaPanel extends DivView implements PageChangeHandler
{

   SASAbusMap map;
   Area       area;

   public AreaPanel(Area area,
                    final DMHashNavigationPanel navPanel,
                    final AreaList areaList,
                    final SASAbusMap map)
   {
      super("lines");

      this.area = area;
      this.map = map;

      this.add(new ItDeAreaNamePanel(area));
      for (final BusLine busLine : area.getBusLines())
      {
         RowItem busLineRow = new RowItem(new DMClickHandler()
         {

            @Override
            public void onClick(DMClickEvent event)
            {
               BusLinePanel newPanel = new BusLinePanel(busLine, areaList, navPanel, map, false);
               navPanel.newPage(newPanel);
            }
         });
         busLineRow.add(new SpanView(I18N.singleton.getLocalizedText("BusLine") + " " + busLine.getNumber()));

         this.add(busLineRow);

      }

   }

   @Override
   public void pageShow()
   {
      this.map.fitArea(this.area);
      this.map.hide();
   }

   @Override
   public void pageHide()
   {

   }

}
