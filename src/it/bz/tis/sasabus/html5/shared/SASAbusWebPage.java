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

package it.bz.tis.sasabus.html5.shared;

import it.bz.tis.sasabus.html5.shared.ui.AboutPanel;
import it.bz.tis.sasabus.html5.shared.ui.HomePanel;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBar;
import java.util.ArrayList;
import bz.davide.dmweb.shared.view.AbstractHtmlElementView;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusWebPage extends ArrayList<AbstractHtmlElementView>
{

   TitleBar  titleBar;
   Menu      menu;
   HomePanel homePanel;

   public static class InitParameters
   {
      BusStationCustomViewAndI18N custom;
      HomePageCustomFragment      homePageCustomFragment;
   }

   public SASAbusWebPage(InitParameters initParameters) throws Exception
   {
      //super(initParameters);
      DivView wrapper = new DivView(new DivView.InitParameters("cover-wrapper"));

      DivView initialCover = new DivView(new DivView.InitParameters("cover"));

      wrapper.appendChild(initialCover);

      SASAbusMap map = new SASAbusMap(new SASAbusMap.InitParameters(initParameters.custom));
      this.homePanel = new HomePanel(new HomePanel.InitParameters(initParameters.homePageCustomFragment));

      this.homePanel.setMap(map);

      DMHashNavigationPanel navigationPanel = new DMHashNavigationPanel(new DMHashNavigationPanel.InitParameters("main",
                                                                                                                 this.homePanel));
      map.setNavigationPanel(navigationPanel);

      AboutPanel aboutPanel = new AboutPanel(new AboutPanel.InitParameters());

      this.menu = new Menu(navigationPanel, null, map, aboutPanel, initParameters.custom);

      this.menu.addAttachHandler(new SASAbusWebPageAttachHandler(initialCover,
                                                                 wrapper,
                                                                 map,
                                                                 this.menu,
                                                                 this.homePanel,
                                                                 navigationPanel,
                                                                 initParameters.custom));

      this.titleBar = new TitleBar(this.menu, map, null);

      this.add(this.titleBar);
      this.add(navigationPanel);
      this.add(map);
      this.add(this.menu);
      this.add(wrapper);
      this.add(aboutPanel);

   }

}
