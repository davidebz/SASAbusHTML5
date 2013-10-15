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

package it.bz.tis.sasabus.html5.shared.ui.menu;

import bz.davide.dmweb.shared.view.AbstractHtmlElementView;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;

import com.google.gwt.user.client.Window;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class MenuFeedbackClickHandler implements DMClickHandler
{
   Menu menu;

   public MenuFeedbackClickHandler(Menu menu)
   {
      super();
      this.menu = menu;
   }

   MenuFeedbackClickHandler(Void void1)
   {

   }

   @Override
   public void onClick(DMClickEvent event)
   {
      this.menu.hide();
      String subjectEncoded = AbstractHtmlElementView.escapeText4url("SASAbus html5 feedback");
      String bodyEncoded = AbstractHtmlElementView.escapeText4url("Your feedback here...\r\n\r\nMy browser is: " +
                                                   Window.Navigator.getUserAgent() +
                                                   "\r\n");
      String mailto = "mailto:community@sasabus.org?subject=" + subjectEncoded + "&body=" + bodyEncoded;
      Window.Location.assign(mailto);

   }
}
