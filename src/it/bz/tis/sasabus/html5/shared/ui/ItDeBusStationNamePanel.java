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

package it.bz.tis.sasabus.html5.shared.ui;

import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.html5.shared.FavouriteBusStationList;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class ItDeBusStationNamePanel extends ItDeNamePanel
{
   public ItDeBusStationNamePanel(final BusStation busStation, final SASAbusI18N i18n)
   {
      super(busStation.getName_it(), busStation.getName_de(), Icon.newFavouritesIcon(), i18n);
      final Icon favouritesIcon = (Icon) this.icon;
      refreshStatus(favouritesIcon, busStation);
      favouritesIcon.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            boolean isFavourite = FavouriteBusStationList.getSingleton().isFavourite(busStation.getId());
            if (isFavourite)
            {
               FavouriteBusStationList.getSingleton().removeFavouriteBusStation(busStation.getId());
            }
            else
            {
               FavouriteBusStationList.getSingleton().addFavouriteBusStation(busStation.getId());
            }
            refreshStatus(favouritesIcon, busStation);
            event.preventDefault();
            event.stopPropagation();
         }
      });
   }

   static void refreshStatus(Icon favouritesIcon, BusStation busStation)
   {
      if (FavouriteBusStationList.getSingleton().isFavourite(busStation.getId()))
      {
         favouritesIcon.setSrc("../images/layout/favourites-active.png");
      }
      else
      {
         favouritesIcon.setSrc("../images/layout/favourites-icon.png");
      }
   }
}
