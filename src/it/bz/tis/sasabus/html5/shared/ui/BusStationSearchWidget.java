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
import it.bz.tis.sasabus.html5.shared.FavouriteBusStationList;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import java.util.ArrayList;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMFocusEvent;
import bz.davide.dmweb.shared.view.DMFocusHandler;
import bz.davide.dmweb.shared.view.DMKeyUpEvent;
import bz.davide.dmweb.shared.view.DMKeyUpHandler;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.InputView;
import bz.davide.dmweb.shared.view.PageChangeHandler;
import bz.davide.dmweb.shared.view.SpanView;
import com.google.gwt.user.client.Window;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusStationSearchWidget extends DivView implements PageChangeHandler
{

   SASAbusMap map;

   public BusStationSearchWidget(String title,
                                 SASAbusMap map,
                                 final AreaList areaList,
                                 final BusStationSelectedEventHandler selected,
                                 final SASAbusI18N i18n)
   {
      this(title, map, areaList, selected, null, i18n);
   }

   public BusStationSearchWidget(String title,
                                 SASAbusMap map,
                                 final AreaList areaList,
                                 final BusStationSelectedEventHandler selected,
                                 BusStation initial,
                                 final SASAbusI18N i18n)
   {
      super("bus-station-search");
      this.map = map;
      DivView filters = new DivView("filters");
      String text = "";
      if (initial != null)
      {
         text = ItDeNamePanel.asOneLine(initial.getName_it(), initial.getName_de(), i18n);
      }
      final InputView searchText = new InputView(text);
      filters.appendChild(searchText);

      final DivView results = new DivView("results");

      this.appendChild(new SpanView(title));
      this.appendChild(filters);
      this.appendChild(results);

      searchText.addFocusHandler(new DMFocusHandler()
      {

         @Override
         public void onFocus(DMFocusEvent event)
         {
            String eventName = event.getType().getName();
            if (!eventName.equals("focus"))
            {
               Window.alert(eventName);
            }
            else
            {
               searchText.setText("");
               BusStationSearchWidget.refreshResults(searchText, areaList, results, selected, i18n);
            }
         }
      });

      searchText.addKeyUpHandler(new DMKeyUpHandler()
      {
         @Override
         public void onKeyUp(DMKeyUpEvent event)
         {
            BusStationSearchWidget.refreshResults(searchText, areaList, results, selected, i18n);
         }
      });

   }

   private static void refreshResults(InputView searchText,
                                      AreaList areaList,
                                      DivView results,
                                      BusStationSelectedEventHandler selected,
                                      final SASAbusI18N i18n)
   {

      results.clear();
      int count = 0;
      String inputText = searchText.getValue().toLowerCase();

      BusStation[] busStations = BusLinePanel.sortByCurrentLanguage(areaList.getBusStations(), i18n);

      ArrayList<BusStation> favouritesFirst = new ArrayList<BusStation>();
      for (BusStation busStation : busStations)
      {
         if (FavouriteBusStationList.getSingleton().isFavourite(busStation.getId()))
         {
            favouritesFirst.add(busStation);
         }
      }
      for (BusStation busStation : busStations)
      {
         if (!FavouriteBusStationList.getSingleton().isFavourite(busStation.getId()))
         {
            favouritesFirst.add(busStation);
         }
      }

      String[] words = inputText.split(" +");

      for (BusStation busStation : favouritesFirst)
      {
         if (inputText.length() >= 3)
         {
            boolean allWordsFound = true;
            for (String word : words)
            {
               if (busStation.getName_it().toLowerCase().indexOf(word) < 0
                   && busStation.getName_de().toLowerCase().indexOf(word) < 0)
               {
                  allWordsFound = false;
                  break;
               }
            }
            if (!allWordsFound)
            {
               continue;
            }
         }
         busStationItem(busStation, results, selected, searchText, i18n);
         count++;
         if (count > 6)
         {
            break;
         }
      }
      if (count == 7)
      {
         results.appendChild(new SpanView("..."));
      }
   }

   private static void busStationItem(final BusStation busStation,
                                      final DivView results,
                                      final BusStationSelectedEventHandler selected,
                                      final InputView searchText,
                                      final SASAbusI18N i18n)
   {
      RowItem rowItem = new RowItem(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            searchText.setText(ItDeNamePanel.asOneLine(busStation.getName_it(), busStation.getName_de(), i18n));
            results.clear();
            selected.selected(busStation);
            SASAbusHTML5.trackUsage("search", busStation.getId());
         }
      });
      rowItem.appendChild(new ItDeBusStationNamePanel(busStation, i18n));
      results.appendChild(rowItem);

   }

   @Override
   public void pageShow()
   {
      this.map.hide();
   }

   @Override
   public void pageHide()
   {

   }
}
