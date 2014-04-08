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

package it.bz.tis.sasabus.html5.shared.ui.titlebar;

import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import bz.davide.dmweb.shared.view.AnchorView;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class TitleBar extends DivView
{
   public TitleBar(final Menu menu, final SASAbusMap mapWidget, final DMHashNavigationPanel navigationPanel)
   {
      super("title-bar");

      Icon menuIcon = Icon.newMenuIcon();
      this.appendChild(menuIcon);

      Icon logoMenuIcon = Icon.newLogoIcon();

      this.appendChild(logoMenuIcon);
      menuIcon.addClickHandler(new TitleBarMenuClickHandler(menu));

      DivView flags = new DivView("flags");
      AnchorView it = new AnchorView("/it", "IT");
      it.setStyleName("it");
      AnchorView de = new AnchorView("/de", "DE");
      de.setStyleName("de");
      AnchorView en = new AnchorView("/en", "EN");
      en.setStyleName("en");

      flags.appendChild(it);
      flags.appendChild(de);
      flags.appendChild(en);

      this.appendChild(flags);

   }
}
