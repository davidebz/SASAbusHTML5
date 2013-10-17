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

import bz.davide.dmweb.shared.view.AnchorView;
import bz.davide.dmweb.shared.view.ButtonView;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class AboutPanel extends DivView
{

   final static String TARGET = "sasabus_licenses";

   public AboutPanel()
   {
      super("about");
      ButtonView close = new ButtonView("X");
      close.setStyleName("close");

      DivView thirdPartyLicenses = new DivView("third-party-licenses");

      close.addClickHandler(new AboutPanelCloseHandler(this, thirdPartyLicenses));
      this.appendChild(close);
      DivView copyright = new DivView("copyright");
      copyright.appendChild(new SpanView("(C) 2013"));
      copyright.appendChild(new AnchorView("http://www.tis.bz.it/open", "TIS Innovation Park", TARGET));
      this.appendChild(copyright);
      this.appendChild(new SpanView("Via Siemens 29 Strasse - Bolzano/Bozen - Italy"));

      DivView license = new DivView("license");
      this.appendChild(license);
      license.appendChild(new SpanView("License:"));
      license.appendChild(new AnchorView("http://www.gnu.org/licenses/agpl-3.0.html", "Affero GPL", TARGET));

      this.appendChild(new SpanView("Developed by"));
      this.appendChild(new AnchorView("http://www.davide.bz", "Davide Montesin", TARGET));
      this.appendChild(new SpanView("Bolzano/Bozen - Italy"));
      this.appendChild(new SpanView("Design by (alphabetical order)"));
      this.appendChild(new AnchorView("mailto:giuliarosso.rg@gmail.com", "Giulia Rosso", TARGET));
      this.appendChild(new AnchorView("mailto:iryna_dorosh@ukr.net", "Iryna Dorosh", TARGET));
      this.appendChild(new AnchorView("mailto:virginia.mazzocco@gmail.com", "Virginia Mazzocco", TARGET));
      this.appendChild(new SpanView("members of the"));
      this.appendChild(new AnchorView("http://sasabus.org/wiki", "SASAbus community", TARGET));

      AnchorView showLicenses = new AnchorView("#", "Third-party free open source software libraries");
      showLicenses.addClickHandler(new AboutPanelShow3rdPartyLicenses(thirdPartyLicenses));
      this.appendChild(showLicenses);

      thirdPartyLicenses.appendChild(new SpanView("(alphabetical order)"));

      thirdPartyLicenses.appendChild(this.thirdParty("DM XML-JSON",
                                             "http://www.davide.bz/en/dmxj",
                                             "LGPL3",
                                             "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                             "Davide Montesin"));
      thirdPartyLicenses.appendChild(this.thirdParty("DM Web",
                                             "http://www.davide.bz/en/dmweb",
                                             "LGPL3",
                                             "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                             "Davide Montesin"));

      thirdPartyLicenses.appendChild(this.thirdParty("Flag Icons - Europe",
                                             "http://antibakteriell.deviantart.com/art/Flag-Icons-Europe-166536006",
                                             "CC BY 3.0",
                                             "http://creativecommons.org/licenses/by/3.0/",
                                             "antibakteriell"));

      thirdPartyLicenses.appendChild(this.thirdParty("Visualization: Gauge",
                                             "https://developers.google.com/chart/interactive/docs/gallery/gauge",
                                             "API",
                                             "https://developers.google.com/chart/terms",
                                             "Google"));

      thirdPartyLicenses.appendChild(this.thirdParty("GWT",
                                             "http://www.gwtproject.org",
                                             "Apache 2.0",
                                             "http://www.gwtproject.org/terms.html",
                                             "Google"));
      thirdPartyLicenses.appendChild(this.thirdParty("Leaflet",
                                             "http://leafletjs.com",
                                             "BSD",
                                             "http://github.com/Leaflet/Leaflet/blob/master/LICENSE",
                                             "Vladimir Agafonkin, CloudMade"));

      this.appendChild(thirdPartyLicenses);

   }

   AboutPanel(Void void1)
   {
      super(void1);
   }

   private DivView thirdParty(String libName,
                                  String libUrl,
                                  String license,
                                  String licenseUrl,
                                  String owner)
   {
      DivView row = new DivView("row");
      row.appendChild(new AnchorView(libUrl, libName, TARGET));
      row.appendChild(new SpanView("-"));
      row.appendChild(new AnchorView(licenseUrl, license, TARGET));
      row.appendChild(new SpanView("-"));
      row.appendChild(new SpanView(owner));
      return row;
   }
}
