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

package it.bz.tis.sasabus.html5.shared;

import it.bz.tis.sasabus.html5.shared.ui.AboutPanel;
import it.bz.tis.sasabus.html5.shared.ui.HomePanel;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBar;
import bz.davide.dmweb.shared.view.AbstractHtmlElementView;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DMWebPage;
import bz.davide.dmweb.shared.view.DivView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusWebPage extends DMWebPage
{

   TitleBar  titleBar;
   Menu      menu;
   HomePanel homePanel;

   public SASAbusWebPage()
   {
      DivView wrapper = new DivView("cover-wrapper");

      DivView initialCover = new DivView("cover");

      wrapper.appendChild(initialCover);

      SASAbusMap map = new SASAbusMap();
      this.homePanel = new HomePanel();

      this.homePanel.setMap(map);
      DMHashNavigationPanel navigationPanel = new DMHashNavigationPanel("main", this.homePanel);
      map.setNavigationPanel(navigationPanel);

      AboutPanel aboutPanel = new AboutPanel();

      this.menu = new Menu(navigationPanel, null, map, aboutPanel);

      this.addAttachHandler(new SASAbusWebPageAttachHandler(initialCover,
                                                            wrapper,
                                                            map,
                                                            this.menu,
                                                            this.homePanel,
                                                            navigationPanel));

      this.titleBar = new TitleBar(this.menu, map, null);

      this.setBodyContent(new AbstractHtmlElementView[] { this.titleBar,
               navigationPanel,
               map,
               this.menu,
               wrapper,
               aboutPanel });

   }

   public void setIntroText(String text) throws Exception
   {
      this.homePanel.setIntroText(text);
   }

}
