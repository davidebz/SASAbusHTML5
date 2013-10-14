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

package it.bz.tis.sasabus.html5.shared.ui.titlebar;

import it.bz.tis.sasabus.html5.shared.ui.icon.LogoIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.MenuIcon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import bz.davide.dmweb.shared.DMAnchor;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMHashNavigationPanel;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class TitleBar extends DMFlowPanel
{
   public TitleBar(final Menu menu, final SASAbusMap mapWidget, final DMHashNavigationPanel navigationPanel)
   {
      super("title-bar");

      MenuIcon menuIcon = new MenuIcon();
      this.add(menuIcon);

      LogoIcon logoMenuIcon = new LogoIcon();
      
      this.add(logoMenuIcon);
      menuIcon.addClickHandler(new TitleBarMenuClickHandler(menu));

      DMFlowPanel flags = new DMFlowPanel("flags");
      DMAnchor it = new DMAnchor("/it/home", "IT");
      it.setStyleName("it");
      DMAnchor de = new DMAnchor("/de/home", "DE");
      de.setStyleName("de");
      DMAnchor en = new DMAnchor("/en/home", "EN");
      en.setStyleName("en");

      flags.add(it);
      flags.add(de);
      flags.add(en);

      this.add(flags);

   }
}
