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

package it.bz.tis.sasabus.html5.shared.ui.icon;

import bz.davide.dmweb.shared.view.ImgView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class Icon extends ImgView
{

   public Icon()
   {
      this("no-name");
   }

   public Icon(String name)
   {
      super();
      this.setIconName(name);
   }

   public void setIconName(String name)
   {
      this.setStyleName("icon " + name);
      this.setSrc("../images/layout/" + name + ".png");
   }

   public static Icon newAboutIcon()
   {
      return new Icon("about-icon");
   }

   public static Icon newBusIcon()
   {
      return new Icon("bus-icon");
   }

   public static Icon newCalendarIcon()
   {
      return new Icon("calendar-icon");
   }

   /*
   public static Icon newDirectionIcon()
   {
      return new Icon("direction-icon");
   }
   */

   public static Icon newDownIcon()
   {
      return new Icon("down-icon");
   }

   public static Icon newFavouritesActiveIcon()
   {
      return new Icon("favourites-active");
   }

   public static Icon newFavouritesIcon()
   {
      return new Icon("favourites-icon");
   }

   public static Icon newFeedbackIcon()
   {
      return new Icon("feedback-icon");
   }

   public static Icon newGoIcon()
   {
      return new Icon("go-icon");
   }

   public static Icon newGpsIcon()
   {
      return new Icon("gps-icon");
   }

   public static Icon newHTML5Icon()
   {
      return new Icon("html5logo");
   }

   public static Icon newLinesIcon()
   {
      return new Icon("lines-icon");
   }

   public static Icon newLogoIcon()
   {
      return new Icon("logo-menu");
   }

   public static Icon newMapIcon()
   {
      return new Icon("map-icon");
   }

   public static Icon newMenuIcon()
   {
      return new Icon("menu-icon");
   }

   public static Icon newMoreIcon()
   {
      return new Icon("more-icon");
   }

   public static Icon newNewsIcon()
   {
      return new Icon("news-icon");
   }

   public static Icon newParkIcon()
   {
      return new Icon("park-icon");
   }

   public static Icon newRouteEndIcon()
   {
      return new Icon("route-end");
   }

   public static Icon newRouteIcon()
   {
      return new Icon("route-icon");
   }

   public static Icon newSearchIcon()
   {
      return new Icon("search-icon");
   }

   public static Icon newTrainIcon()
   {
      return new Icon("train-icon");
   }

   public static Icon newTreeIcon()
   {
      return new Icon("tree-icon");
   }

   public static Icon newWalkIcon()
   {
      return new Icon("walk");
   }

}
