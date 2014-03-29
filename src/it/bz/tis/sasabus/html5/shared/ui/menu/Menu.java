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

package it.bz.tis.sasabus.html5.shared.ui.menu;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.AboutPanel;
import it.bz.tis.sasabus.html5.shared.ui.ParkingsPanel;
import it.bz.tis.sasabus.html5.shared.ui.TrainStationsPanel;
import it.bz.tis.sasabus.html5.shared.ui.icon.AboutIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.FavouritesActiveIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.FeedbackIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.LinesIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.MapIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.MoreIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.NewsIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.ParkingIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.SearchIcon;
import it.bz.tis.sasabus.html5.shared.ui.icon.TrainIcon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import com.google.gwt.user.client.Timer;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class Menu extends DivView
{
   DMHashNavigationPanel navigationPanel;
   SASAbusMap            map;
   boolean               menuOpen = false;
   MenuItem              areasAndLine;
   MenuItem              mapItem;
   MenuItem              search;
   //MenuItem              routing;
   MenuItem              news;
   MenuItem              favourites;
   //MenuItem              green;
   MenuItem              more;
   MenuItem              sendFeedback;
   MenuItem              about;

   MenuItem              parkings;
   MenuItem              train;

   DivView               moreMenuItems;

   MenuMoreClickHandler  moreClickHandler;

   AboutPanel            aboutPanel;

   SASAbusI18N           i18n;

   public Menu(final DMHashNavigationPanel navigationPanel,
               final AreaList areaList,
               final SASAbusMap map,
               AboutPanel aboutPanel,
               SASAbusI18N i18n)
   {
      super(new DivView.InitParameters("menu"));

      this.i18n = i18n;

      this.aboutPanel = aboutPanel;
      this.navigationPanel = navigationPanel;
      this.map = map;

      this.areasAndLine = new MenuItem(new LinesIcon(new LinesIcon.InitParameters()),
                                       i18n.getLocalizedText("Menu_areasLines"));
      this.appendChild(this.areasAndLine);

      this.mapItem = new MenuItem(new MapIcon(new MapIcon.InitParameters()), i18n.getLocalizedText("Menu_map"));
      this.mapItem.addStyleName("map ");
      this.appendChild(this.mapItem);

      this.search = new MenuItem(new SearchIcon(new SearchIcon.InitParameters()),
                                 i18n.getLocalizedText("Menu_search"));
      this.appendChild(this.search);

      this.favourites = new MenuItem(new FavouritesActiveIcon(new FavouritesActiveIcon.InitParameters()),
                                     "Favourite");
      this.appendChild(this.favourites);

      //this.green = new MenuItem(new TreeIcon(new TreeIcon.InitParameters()), "Green");
      //this.add(this.green);
      this.parkings = new MenuItem(new ParkingIcon(new ParkingIcon.InitParameters()), "Park");
      this.appendChild(this.parkings);

      //this.routing = new MenuItem(new RouteIcon(new RouteIcon.InitParameters()), i18n.getLocalizedText("Menu_routing"));
      //this.add(this.routing);

      this.more = new MenuItem(new MoreIcon(new MoreIcon.InitParameters()), i18n.getLocalizedText("Menu_more"));
      this.more.addStyleName("more");
      this.appendChild(this.more);

      this.moreMenuItems = new DivView(new DivView.InitParameters("more-menu-items"));
      this.appendChild(this.moreMenuItems);

      this.train = new MenuItem(new TrainIcon(new TrainIcon.InitParameters()), "Train");
      this.moreMenuItems.appendChild(this.train);

      this.news = new MenuItem(new NewsIcon(new NewsIcon.InitParameters()), i18n.getLocalizedText("Menu_news"));
      this.moreMenuItems.appendChild(this.news);

      this.sendFeedback = new MenuItem(new FeedbackIcon(new FeedbackIcon.InitParameters()),
                                       i18n.getLocalizedText("Menu_feedback"));
      this.moreMenuItems.appendChild(this.sendFeedback);

      this.about = new MenuItem(new AboutIcon(new AboutIcon.InitParameters()), i18n.getLocalizedText("Menu_about"));
      this.moreMenuItems.appendChild(this.about);

   }

   protected Menu()
   {
   }

   public void initClickHandlers(final AreaList areaList)
   {
      this.areasAndLine.addClickHandler(new MenuAreaLinesClickHandler(this.navigationPanel,
                                                                      this,
                                                                      areaList,
                                                                      this.map));
      this.mapItem.addClickHandler(new MenuMapClickHandler(this.navigationPanel, this, areaList, this.map));
      this.news.addClickHandler(new MenuNewsClickHandler(this.navigationPanel, this));
      this.search.addClickHandler(new MenuSearchClickHandler(this.navigationPanel, this, areaList, this.map));
      //this.routing.addClickHandler(new MenuRouteClickHandler(this.navigationPanel, this, areaList, this.map));
      this.moreClickHandler = new MenuMoreClickHandler(this.moreMenuItems);
      this.more.addClickHandler(this.moreClickHandler);
      this.sendFeedback.addClickHandler(new MenuFeedbackClickHandler(this));
      this.about.addClickHandler(new MenuAboutClickHandler(this.aboutPanel, this));
      this.favourites.addClickHandler(new MenuFavouritesClickHandler(this.navigationPanel,
                                                                     this,
                                                                     areaList,
                                                                     this.map));

      /*
      this.green.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            Menu.this.navigationPanel.newPage(new GreenPanel());
            Menu.this.hide();
         }
      });
      */

      this.train.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            Menu.this.navigationPanel.newPage(new TrainStationsPanel(Menu.this.navigationPanel,
                                                                     areaList,
                                                                     Menu.this.map,
                                                                     Menu.this.i18n));
            Menu.this.hide();
         }
      });

      this.parkings.addClickHandler(new DMClickHandler()
      {

         @Override
         public void onClick(DMClickEvent event)
         {
            Menu.this.navigationPanel.newPage(new ParkingsPanel(Menu.this.navigationPanel,
                                                                areaList,
                                                                Menu.this.map,
                                                                Menu.this.i18n));
            Menu.this.hide();
         }
      });

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
