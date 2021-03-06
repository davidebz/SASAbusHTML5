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

import it.bz.tis.sasabus.html5.shared.SASAbusI18N;
import it.bz.tis.sasabus.html5.shared.ui.icon.Icon;
import java.util.Date;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DMDateBox;
import bz.davide.dmweb.shared.view.DivView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusDateBox extends DivView
{
   DMDateBox dateBox;

   public SASAbusDateBox(final SASAbusI18N i18n, final DMClickHandler retrieveNextDepartureHandler)
   {
      super("sasabus-date-box");

      this.appendChild(this.dateBox = new DMDateBox());
      this.dateBox.setFormat("dd.MM.yyyy HH:mm");
      this.dateBox.setValue(new Date());
      Icon calendarIcon = Icon.newCalendarIcon();
      this.appendChild(calendarIcon);
      calendarIcon.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            SASAbusDateBox.this.dateBox.getGwtDateBox().showDatePicker();
         }
      });
      ButtonView prevHour = new ButtonView(i18n.getLocalizedText("SASAbusDateBox_prevHour"));
      this.appendChild(prevHour);
      prevHour.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            Date current = SASAbusDateBox.this.getValue();
            long millis = current.getTime();
            millis -= 1000L * 60 * 60;
            Date prevHour = new Date(millis);
            SASAbusDateBox.this.dateBox.setValue(prevHour);
            if (retrieveNextDepartureHandler != null)
            {
               retrieveNextDepartureHandler.onClick(null);
            }
         }
      });
      ButtonView nextHour = new ButtonView(i18n.getLocalizedText("SASAbusDateBox_nextHour"));
      this.appendChild(nextHour);
      nextHour.addClickHandler(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            Date current = SASAbusDateBox.this.getValue();
            long millis = current.getTime();
            millis += 1000L * 60 * 60;
            Date nextHour = new Date(millis);
            SASAbusDateBox.this.dateBox.setValue(nextHour);
            if (retrieveNextDepartureHandler != null)
            {
               retrieveNextDepartureHandler.onClick(null);
            }
         }
      });
   }

   public Date getValue()
   {
      return this.dateBox.getValue();
   }

   public DMDateBox getDateBox()
   {
      return this.dateBox;
   }
}
