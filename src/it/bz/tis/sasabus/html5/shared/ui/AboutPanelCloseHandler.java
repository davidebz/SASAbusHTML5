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

import bz.davide.dmweb.shared.DMClickEvent;
import bz.davide.dmweb.shared.DMClickHandler;
import bz.davide.dmweb.shared.DMFlowPanel;

import com.google.gwt.dom.client.Style.Display;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class AboutPanelCloseHandler implements DMClickHandler
{
   AboutPanel  aboutPanel;
   DMFlowPanel thirdPartyLicenses;

   public AboutPanelCloseHandler(AboutPanel aboutPanel, DMFlowPanel thirdPartyLicenses)
   {
      super();
      this.aboutPanel = aboutPanel;
      this.thirdPartyLicenses = thirdPartyLicenses;
   }

   protected AboutPanelCloseHandler(Void void1)
   {
   }

   @Override
   public void onClick(DMClickEvent event)
   {
      this.aboutPanel.getElement().getStyle().setDisplay(Display.NONE);
      this.thirdPartyLicenses.getElement().getStyle().setDisplay(Display.NONE);
   }
}
