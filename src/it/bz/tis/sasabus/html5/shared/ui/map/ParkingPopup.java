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

import it.bz.tis.sasabus.backend.shared.FreeSlots;
import it.bz.tis.sasabus.backend.shared.ParkingInfo;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.data.Parking;
import it.bz.tis.sasabus.html5.shared.ui.ItDeNamePanel;
import bz.davide.dmweb.client.google.visualization.Gauge;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

public class ParkingPopup extends DivView
{
   Parking parking;
   DivView freeParkingsData;

   public ParkingPopup(Parking parking, final SASAbusI18N i18n)
   {
      super("parking-popup");
      this.parking = parking;
      this.appendChild(new ItDeNamePanel(parking.getName_it(), parking.getName_de(), null, i18n));
      this.appendChild(new SpanView(i18n.getLocalizedText("MapParkingPopup_msg") + ":"));
      this.appendChild(this.freeParkingsData = new DivView("free-data"));

   }

   void init(SASAbusI18N i18n)
   {
      ButtonView refresh = new ButtonView(i18n.getLocalizedText("MapParkingPopup_refresh"));
      this.appendChild(refresh);
      DMClickHandler refreshHandler = new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            ParkingPopup.this.freeParkingsData.clear();
            ParkingPopup.this.freeParkingsData.appendChild(new SpanView("reading..."));
            SASAbusDBClientImpl.singleton.loadParkingInfo(ParkingPopup.this.parking.getId(),
                                                          new SASAbusDBDataReady<ParkingInfo>()
                                                          {
                                                             @Override
                                                             public void ready(ParkingInfo data)
                                                             {
                                                                ParkingPopup.this.parkinginfo(data);
                                                             }
                                                          });
         }
      };
      refresh.addClickHandler(refreshHandler);
      refreshHandler.onClick(null);
   }

   void parkinginfo(final ParkingInfo parkingInfo)
   {
      SASAbusDBClientImpl.singleton.loadParkingFreeSlots(this.parking.getId(), new SASAbusDBDataReady<FreeSlots>()
      {
         @Override
         public void ready(FreeSlots data)
         {
            ParkingPopup.this.show(data.getSlots(), parkingInfo.getSlots());
         }
      });
   }

   void show(int free, int tot)
   {
      this.freeParkingsData.clear();
      Gauge gauge = new Gauge(this.freeParkingsData.getElement(), "Parking", 0, tot - free, tot);
   }
}
