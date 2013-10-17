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

import it.bz.tis.sasabus.html5.shared.ui.HomePanel;
import it.bz.tis.sasabus.html5.shared.ui.SplashPanel;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import bz.davide.dmweb.shared.view.AttachEvent;
import bz.davide.dmweb.shared.view.AttachListener;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;

import com.google.gwt.user.client.History;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusWebPageAttachHandler implements AttachListener
{
   DivView           cover;
   DivView           wrapper;
   SASAbusMap            map;
   Menu                  menu;
   HomePanel             homePanel;
   DMHashNavigationPanel navigationPanel;

   public SASAbusWebPageAttachHandler(DivView cover,
                                      DivView wrapper,
                                      SASAbusMap map,
                                      Menu menu,
                                      HomePanel homePanel,
                                      DMHashNavigationPanel navigationPanel)
   {
      this.cover = cover;
      this.wrapper = wrapper;
      this.map = map;
      this.menu = menu;
      this.homePanel = homePanel;
      this.navigationPanel = navigationPanel;
   }

   SASAbusWebPageAttachHandler(Void void1)
   {
   }

   @Override
   public void onAttachOrDetach(AttachEvent event)
   {
      if (event.isAttached())
      {
         History.newItem("0", false);

         SASAbusWebPageAttachHandler.this.cover.appendChild(new SplashPanel(SASAbusWebPageAttachHandler.this.cover,
                                                                    SASAbusWebPageAttachHandler.this.wrapper,
                                                                    SASAbusWebPageAttachHandler.this.map,
                                                                    SASAbusWebPageAttachHandler.this.menu,
                                                                    this.homePanel,
                                                                    this.navigationPanel));
      }
   }
}
