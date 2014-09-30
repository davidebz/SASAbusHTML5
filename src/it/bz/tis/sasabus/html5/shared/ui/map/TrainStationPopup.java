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

package it.bz.tis.sasabus.html5.shared.ui.map;

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N;
import it.bz.tis.sasabus.html5.shared.data.TrainStation;
import it.bz.tis.sasabus.html5.shared.ui.ItDeNamePanel;
import it.bz.tis.sasabus.html5.shared.ui.TrainStationPanel;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMHashNavigationPanel;
import bz.davide.dmweb.shared.view.DivView;

public class TrainStationPopup extends DivView
{
   TrainStation                      trainStation;
   DMHashNavigationPanel             navigationPanel;
   AreaList                          areaList;
   SASAbusMap                        map;

   final BusStationCustomViewAndI18N custom;

   public TrainStationPopup(TrainStation trainStation,
                            DMHashNavigationPanel navigationPanel,
                            AreaList areaList,
                            SASAbusMap map,
                            final BusStationCustomViewAndI18N custom)
   {
      super("train-popup");
      this.trainStation = trainStation;
      this.appendChild(new ItDeNamePanel(trainStation.getName_it(),
                                         trainStation.getName_de(),
                                         null,
                                         custom.getI18n()));
      this.navigationPanel = navigationPanel;
      this.areaList = areaList;
      this.map = map;
      this.custom = custom;
   }

   void init()
   {
      ButtonView show = new ButtonView(this.custom.getI18n().getLocalizedText("BusTrainPopup_show_details"));
      this.appendChild(show);
      show.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            TrainStationPopup.this.navigationPanel.newPage(new TrainStationPanel(TrainStationPopup.this.trainStation,
                                                                                 TrainStationPopup.this.navigationPanel,
                                                                                 TrainStationPopup.this.areaList,
                                                                                 TrainStationPopup.this.map,
                                                                                 TrainStationPopup.this.custom));
         }
      });
   }

}
