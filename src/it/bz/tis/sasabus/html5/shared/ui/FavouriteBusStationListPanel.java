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

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.html5.client.SASAbusHTML5;
import it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N;
import it.bz.tis.sasabus.html5.shared.FavouriteBusStationList;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class FavouriteBusStationListPanel extends DivView implements PageChangeHandler
{
   AreaList                    areaList;
   DMHashNavigationPanel       navigationPanel;
   SASAbusMap                  map;
   BusStationCustomViewAndI18N custom;
   String                      parentPanel;

   public FavouriteBusStationListPanel(AreaList areaList,
                                       DMHashNavigationPanel navigationPanel,
                                       SASAbusMap map,
                                       final BusStationCustomViewAndI18N custom,
                                       String parentPanel)
   {
      super();
      this.areaList = areaList;
      this.navigationPanel = navigationPanel;
      this.map = map;
      this.custom = custom;
      this.parentPanel = parentPanel;
      this.refresh();
   }

   protected FavouriteBusStationListPanel()
   {
   }

   public void refresh()
   {
      this.clear();

      FavouriteBusStationList favourites = FavouriteBusStationList.getSingleton();
      BusStation[] busStations = BusLinePanel.sortByCurrentLanguage(this.areaList.getBusStations(),
                                                                    this.custom.getI18n());
      this.appendChild(new SpanView(this.custom.getI18n().getLocalizedText("FavouriteBusStationListPanel_favourite_are")
                                    + ":"));
      int count = 0;
      for (final BusStation busStation : busStations)
      {
         if (favourites.isFavourite(busStation.getId()))
         {
            RowItem rowItem = new RowItem(new DMClickHandler()
            {
               @Override
               public void onClick(DMClickEvent event)
               {
                  SASAbusHTML5.trackUsage(FavouriteBusStationListPanel.this.parentPanel + "-favourite",
                                          busStation.getId());

                  FavouriteBusStationListPanel.this.navigationPanel.newPage(new BusStationPanel(busStation,
                                                                                                FavouriteBusStationListPanel.this.areaList,
                                                                                                FavouriteBusStationListPanel.this.navigationPanel,
                                                                                                FavouriteBusStationListPanel.this.map,
                                                                                                FavouriteBusStationListPanel.this.custom));
               }
            });
            rowItem.appendChild(new ItDeBusStationNamePanel(busStation, this.custom.getI18n()));
            this.appendChild(rowItem);
            count++;
         }
      }
      if (count == 0)
      {
         this.appendChild(new SpanView(this.custom.getI18n().getLocalizedText("FavouriteBusStationListPanel_empty_favourite")));
      }

   }

   @Override
   public void pageShow()
   {
      this.refresh();
   }

   @Override
   public void pageHide()
   {

   }
}
