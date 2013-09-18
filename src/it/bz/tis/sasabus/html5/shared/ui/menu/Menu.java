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

package it.bz.tis.sasabus.html5.shared.ui.menu;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.html5.shared.ui.AboutPanel;
import it.bz.tis.sasabus.html5.shared.ui.icon.BusIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.FavouritesIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.MapIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.MoreIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.RouteIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.SearchIcon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMHashNavigationPanel;
import bz.davide.dmweb.shared.i18n.I18N;

import com.google.gwt.user.client.Timer;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class Menu extends DMFlowPanel
{
   DMHashNavigationPanel navigationPanel;
   SASAbusMap            map;
   boolean               menuOpen = false;
   MenuItem              areasAndLine;
   MenuItem              mapItem;
   MenuItem              search;
   MenuItem              routing;
   MenuItem              news;
   MenuItem              favourites;
   MenuItem              more;
   MenuItem              sendFeedback;
   MenuItem              about;
   DMFlowPanel           moreMenuItems;

   MenuMoreClickHandler  moreClickHandler;

   AboutPanel            aboutPanel;

   public Menu(final DMHashNavigationPanel navigationPanel,
               final AreaList areaList,
               final SASAbusMap map,
               AboutPanel aboutPanel)
   {
      super("menu");

      this.aboutPanel = aboutPanel;
      this.navigationPanel = navigationPanel;
      this.map = map;

      this.areasAndLine = new MenuItem(new BusIcon(), I18N.singleton.getLocalizedText("Menu_areasLines"));
      this.add(this.areasAndLine);

      this.mapItem = new MenuItem(new MapIcon(), I18N.singleton.getLocalizedText("Menu_map"));
      this.mapItem.addStyleName("map ");
      this.add(this.mapItem);

      this.search = new MenuItem(new SearchIcon(), I18N.singleton.getLocalizedText("Menu_search"));
      this.add(this.search);

      this.routing = new MenuItem(new RouteIcon(), I18N.singleton.getLocalizedText("Menu_routing"));
      this.add(this.routing);

      this.news = new MenuItem(new BusIcon(), I18N.singleton.getLocalizedText("Menu_news"));
      this.add(this.news);

      this.sendFeedback = new MenuItem(new BusIcon(), I18N.singleton.getLocalizedText("Menu_feedback"));
      this.add(this.sendFeedback);

      this.more = new MenuItem(new MoreIcon(), I18N.singleton.getLocalizedText("Menu_more"));
      this.more.addStyleName("more");
      this.add(this.more);

      this.moreMenuItems = new DMFlowPanel("more-menu-items");
      this.add(this.moreMenuItems);


      this.favourites = new MenuItem(new FavouritesIcon(), "Favourit.");
      this.moreMenuItems.add(this.favourites);


      this.about = new MenuItem(new BusIcon(), I18N.singleton.getLocalizedText("Menu_about"));
      this.moreMenuItems.add(this.about);

   }

   public void initClickHandlers(AreaList areaList)
   {
      this.areasAndLine.addClickHandler(new MenuAreaLinesClickHandler(this.navigationPanel,
                                                                      this,
                                                                      areaList,
                                                                      this.map));
      this.mapItem.addClickHandler(new MenuMapClickHandler(this.navigationPanel, this, areaList, this.map));
      this.news.addClickHandler(new MenuNewsClickHandler(this.navigationPanel, this));
      this.search.addClickHandler(new MenuSearchClickHandler(this.navigationPanel, this, areaList, this.map));
      this.routing.addClickHandler(new MenuRouteClickHandler(this.navigationPanel, this, areaList, this.map));
      this.moreClickHandler = new MenuMoreClickHandler(this.moreMenuItems);
      this.more.addClickHandler(this.moreClickHandler);
      this.sendFeedback.addClickHandler(new MenuFeedbackClickHandler(this));
      this.about.addClickHandler(new MenuAboutClickHandler(this.aboutPanel, this));
      this.favourites.addClickHandler(new MenuFavouritesClickHandler(this.navigationPanel,
                                                                     this,
                                                                     areaList,
                                                                     this.map));
   }

   Menu(Void void1)
   {
      super(void1);
   }

   public void show()
   {
      if (!this.menuOpen)
      {
         this.addStyleName("anim-left");
         this.addStyleName("show");
         this.menuOpen = !this.menuOpen;
         Timer removeAnim = new Timer()
         {
            @Override
            public void run()
            {
               Menu.this.removeStyleName("anim-left");
            }
         };
         removeAnim.schedule(1000);
      }
   }

   public void hide()
   {
      this.moreClickHandler.hide();
      if (this.menuOpen)
      {
         this.addStyleName("anim-left");
         this.removeStyleName("show");
         this.menuOpen = !this.menuOpen;
         Timer removeAnim = new Timer()
         {
            @Override
            public void run()
            {
               Menu.this.removeStyleName("anim-left");
            }
         };
         removeAnim.schedule(1000);
      }
   }

   public void toggle()
   {
      if (this.menuOpen)
      {
         this.hide();
      }
      else
      {
         this.show();
      }
   }

}
