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

package it.bz.tis.sasabus.html5.shared.ui;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.html5.shared.FavouriteBusStationList;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;

import java.util.ArrayList;

import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMFocusEvent;
import bz.davide.dmweb.shared.DMFocusHandler;
import bz.davide.dmweb.shared.DMKeyUpEvent;
import bz.davide.dmweb.shared.DMKeyUpHandler;
import bz.davide.dmweb.shared.DMLabel;
import bz.davide.dmweb.shared.DMTextBox;
import bz.davide.dmweb.shared.PageChangeHandler;
import bz.davide.dmweb.shared.i18n.I18N;

import com.google.gwt.user.client.Window;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusStationSearchWidget extends DMFlowPanel implements PageChangeHandler
{

   SASAbusMap map;

   public BusStationSearchWidget(SASAbusMap map,
                                 final AreaList areaList,
                                 final BusStationSelectedEventHandler selected)
   {
      this(map, areaList, selected, null);
   }

   public BusStationSearchWidget(SASAbusMap map,
                                 final AreaList areaList,
                                 final BusStationSelectedEventHandler selected,
                                 BusStation initial)
   {
      super("bus-station-search");
      this.map = map;
      DMFlowPanel filters = new DMFlowPanel("filters");
      String text = "";
      if (initial != null)
      {
         text = ItDeNamePanel.asOneLine(initial.getName_it(), initial.getName_de());
      }
      final DMTextBox searchText = new DMTextBox(text);
      filters.add(searchText);

      final DMFlowPanel results = new DMFlowPanel("results");

      this.add(new DMLabel(I18N.singleton.getLocalizedText("BusStationSearchWidget_introtext")));
      this.add(filters);
      this.add(results);

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
               BusStationSearchWidget.refreshResults(searchText, areaList, results, selected);
            }
         }
      });

      searchText.addKeyUpHandler(new DMKeyUpHandler()
      {
         @Override
         public void onKeyUp(DMKeyUpEvent event)
         {
            BusStationSearchWidget.refreshResults(searchText, areaList, results, selected);
         }
      });


   }

   private static void refreshResults(DMTextBox searchText,
                                      AreaList areaList,
                                      DMFlowPanel results,
                                      BusStationSelectedEventHandler selected)
   {

      results.clear();
      int count = 0;
      String inputText = searchText.getValue().toLowerCase();

      BusStation[] busStations = BusLinePanel.sortByCurrentLanguage(areaList.getBusStations());

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
               if (busStation.getName_it().toLowerCase().indexOf(word) < 0 &&
                   busStation.getName_de().toLowerCase().indexOf(word) < 0)
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
         busStationItem(busStation, results, selected, searchText);
         count++;
         if (count > 6)
         {
            break;
         }
      }
      if (count == 7)
      {
         results.add(new DMLabel("..."));
      }
   }

   private static void busStationItem(final BusStation busStation,
                                      final DMFlowPanel results,
                                      final BusStationSelectedEventHandler selected,
                                      final DMTextBox searchText)
   {
      RowItem rowItem = new RowItem(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            searchText.setText(ItDeNamePanel.asOneLine(busStation.getName_it(), busStation.getName_de()));
            results.clear();
            selected.selected(busStation);
         }
      });
      rowItem.add(new ItDeBusStationNamePanel(busStation));
      results.add(rowItem);

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
