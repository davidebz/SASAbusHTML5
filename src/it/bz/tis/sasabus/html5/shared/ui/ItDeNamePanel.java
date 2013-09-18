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

import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMLabel;
import bz.davide.dmweb.shared.DMWidget;
import bz.davide.dmweb.shared.i18n.I18N;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class ItDeNamePanel extends DMFlowPanel
{
   protected DMWidget icon;

   public ItDeNamePanel(String itText, String deText, DMWidget icon)
   {
      this.icon = icon;
      this.setStyleName("it-de-name");
      DMLabel it = new DMLabel(itText);
      it.setStyleName("it");
      DMLabel de = new DMLabel(deText);
      de.setStyleName("de");
      DMFlowPanel first = new DMFlowPanel("first");
      this.add(first);
      if (icon != null)
      {
         first.add(icon);
      }
      if (I18N.singleton.getLanguage().equals("de"))
      {
         first.add(de);
         this.add(it);
         it.addStyleName("second");
      }
      else
      {
         first.add(it);
         this.add(de);
         de.addStyleName("second");
      }
   }

   public static String asOneLine(String itText, String deText)
   {
      if (I18N.singleton.getLanguage().equals("de"))
      {
         return deText + " / " + itText;
      }
      else
      {
         return itText + " / " + deText;
      }
   }
}
