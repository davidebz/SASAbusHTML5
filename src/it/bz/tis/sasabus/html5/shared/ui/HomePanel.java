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

import it.bz.tis.sasabus.html5.shared.HomePageCustomFragment;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class HomePanel extends DivView implements PageChangeHandler
{
   SASAbusMap                   map;
   DivView                      introText;
   DivView                      favouriteContainer;
   FavouriteBusStationListPanel favouriteBusStationListPanel = null;

   public HomePanel(HomePageCustomFragment custom)
   {
      super("home");
      this.favouriteContainer = new DivView("favourite-container");
      this.appendChild(this.favouriteContainer);
      this.appendChild(this.introText = custom.createView());

   }

   protected HomePanel()
   {
   }

   public void setMap(SASAbusMap map)
   {
      this.map = map;
   }

   @Override
   public void pageShow()
   {

      this.map.hide();
      if (this.favouriteBusStationListPanel != null)
      {
         this.favouriteBusStationListPanel.refresh();
      }
      //this.map.showOverviewMap(true);
   }

   @Override
   public void pageHide()
   {
      //this.map.showOverviewMap(false);
   }
}
