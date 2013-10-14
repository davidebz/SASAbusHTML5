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

import bz.davide.dmweb.shared.DMAnchor;
import bz.davide.dmweb.shared.DMButton;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMLabel;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class AboutPanel extends DMFlowPanel
{

   final static String TARGET = "sasabus_licenses";

   public AboutPanel()
   {
      super("about");
      DMButton close = new DMButton("X");
      close.setStyleName("close");

      DMFlowPanel thirdPartyLicenses = new DMFlowPanel("third-party-licenses");

      close.addClickHandler(new AboutPanelCloseHandler(this, thirdPartyLicenses));
      this.add(close);
      DMFlowPanel copyright = new DMFlowPanel("copyright");
      copyright.add(new DMLabel("(C) 2013"));
      copyright.add(new DMAnchor("http://www.tis.bz.it/open", "TIS Innovation Park", TARGET));
      this.add(copyright);
      this.add(new DMLabel("Via Siemens 29 Strasse - Bolzano/Bozen - Italy"));

      DMFlowPanel license = new DMFlowPanel("license");
      this.add(license);
      license.add(new DMLabel("License:"));
      license.add(new DMAnchor("http://www.gnu.org/licenses/agpl-3.0.html", "Affero GPL", TARGET));

      this.add(new DMLabel("Developed by"));
      this.add(new DMAnchor("http://www.davide.bz", "Davide Montesin", TARGET));
      this.add(new DMLabel("Bolzano/Bozen - Italy"));
      this.add(new DMLabel("Design by (alphabetical order)"));
      this.add(new DMAnchor("mailto:giuliarosso.rg@gmail.com", "Giulia Rosso", TARGET));
      this.add(new DMAnchor("mailto:iryna_dorosh@ukr.net", "Iryna Dorosh", TARGET));
      this.add(new DMAnchor("mailto:virginia.mazzocco@gmail.com", "Virginia Mazzocco", TARGET));
      this.add(new DMLabel("members of the"));
      this.add(new DMAnchor("http://sasabus.org/wiki", "SASAbus community", TARGET));

      DMAnchor showLicenses = new DMAnchor("#", "Third-party free open source software libraries");
      showLicenses.addClickHandler(new AboutPanelShow3rdPartyLicenses(thirdPartyLicenses));
      this.add(showLicenses);

      thirdPartyLicenses.add(new DMLabel("(alphabetical order)"));

      thirdPartyLicenses.add(this.thirdParty("DM XML-JSON",
                                             "http://www.davide.bz/en/dmxj",
                                             "LGPL3",
                                             "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                             "Davide Montesin"));
      thirdPartyLicenses.add(this.thirdParty("DM Web",
                                             "http://www.davide.bz/en/dmweb",
                                             "LGPL3",
                                             "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                             "Davide Montesin"));

      thirdPartyLicenses.add(this.thirdParty("Flag Icons - Europe",
                                             "http://antibakteriell.deviantart.com/art/Flag-Icons-Europe-166536006",
                                             "CC BY 3.0",
                                             "http://creativecommons.org/licenses/by/3.0/",
                                             "antibakteriell"));

      thirdPartyLicenses.add(this.thirdParty("Visualization: Gauge",
                                             "https://developers.google.com/chart/interactive/docs/gallery/gauge",
                                             "API",
                                             "https://developers.google.com/chart/terms",
                                             "Google"));

      thirdPartyLicenses.add(this.thirdParty("GWT",
                                             "http://www.gwtproject.org",
                                             "Apache 2.0",
                                             "http://www.gwtproject.org/terms.html",
                                             "Google"));
      thirdPartyLicenses.add(this.thirdParty("Leaflet",
                                             "http://leafletjs.com",
                                             "BSD",
                                             "http://github.com/Leaflet/Leaflet/blob/master/LICENSE",
                                             "Vladimir Agafonkin, CloudMade"));

      this.add(thirdPartyLicenses);

   }

   AboutPanel(Void void1)
   {
      super(void1);
   }

   private DMFlowPanel thirdParty(String libName,
                                  String libUrl,
                                  String license,
                                  String licenseUrl,
                                  String owner)
   {
      DMFlowPanel row = new DMFlowPanel("row");
      row.add(new DMAnchor(libUrl, libName, TARGET));
      row.add(new DMLabel("-"));
      row.add(new DMAnchor(licenseUrl, license, TARGET));
      row.add(new DMLabel("-"));
      row.add(new DMLabel(owner));
      return row;
   }
}
