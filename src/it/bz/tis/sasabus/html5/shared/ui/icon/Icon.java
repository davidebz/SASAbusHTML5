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
   public static class InitParameters extends ImgView.InitParameters
   {
      String name;

      public InitParameters(String name)
      {
         super("../images/layout/" + name + ".png");
         this.name = name;
      }
   }

   Icon(InitParameters initParameters)
   {
      super(initParameters);
      this.setStyleName("icon");
      this.addStyleName(initParameters.name);
   }

   protected Icon()
   {
   }

   public static Icon newAboutIcon()
   {
      return new Icon(new Icon.InitParameters("about-icon"));
   }

   public static Icon newBusIcon()
   {
      return new Icon(new Icon.InitParameters("bus-icon"));
   }

   public static Icon newCalendarIcon()
   {
      return new Icon(new Icon.InitParameters("calendar-icon"));
   }

   /*
   public static Icon newDirectionIcon()
   {
      return new Icon(new Icon.InitParameters("direction-icon"));
   }
   */

   public static Icon newDownIcon()
   {
      return new Icon(new Icon.InitParameters("down-icon"));
   }

   public static Icon newFavouritesActiveIcon()
   {
      return new Icon(new Icon.InitParameters("favourites-active"));
   }

   public static Icon newFavouritesIcon()
   {
      return new Icon(new Icon.InitParameters("favourites-icon"));
   }

   public static Icon newFeedbackIcon()
   {
      return new Icon(new Icon.InitParameters("feedback-icon"));
   }

   public static Icon newGoIcon()
   {
      return new Icon(new Icon.InitParameters("go-icon"));
   }

   public static Icon newGpsIcon()
   {
      return new Icon(new Icon.InitParameters("gps-icon"));
   }

   public static Icon newHTML5Icon()
   {
      return new Icon(new Icon.InitParameters("html5logo"));
   }

   public static Icon newLinesIcon()
   {
      return new Icon(new Icon.InitParameters("lines-icon"));
   }

   public static Icon newLogoIcon()
   {
      return new Icon(new Icon.InitParameters("logo-menu"));
   }

   public static Icon newMapIcon()
   {
      return new Icon(new Icon.InitParameters("map-icon"));
   }

   public static Icon newMenuIcon()
   {
      return new Icon(new Icon.InitParameters("menu-icon"));
   }

   public static Icon newMoreIcon()
   {
      return new Icon(new Icon.InitParameters("more-icon"));
   }

   public static Icon newNewsIcon()
   {
      return new Icon(new Icon.InitParameters("news-icon"));
   }

   public static Icon newParkIcon()
   {
      return new Icon(new Icon.InitParameters("park-icon"));
   }

   public static Icon newRouteEndIcon()
   {
      return new Icon(new Icon.InitParameters("route-end"));
   }

   public static Icon newRouteIcon()
   {
      return new Icon(new Icon.InitParameters("route-icon"));
   }

   public static Icon newSearchIcon()
   {
      return new Icon(new Icon.InitParameters("search-icon"));
   }

   public static Icon newTrainIcon()
   {
      return new Icon(new Icon.InitParameters("train-icon"));
   }

   public static Icon newTreeIcon()
   {
      return new Icon(new Icon.InitParameters("tree-icon"));
   }

   public static Icon newWalkIcon()
   {
      return new Icon(new Icon.InitParameters("walk"));
   }

}
