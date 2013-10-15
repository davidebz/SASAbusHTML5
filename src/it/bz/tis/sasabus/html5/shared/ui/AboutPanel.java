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
      this.add(close);
      DivView copyright = new DivView("copyright");
      copyright.add(new SpanView("(C) 2013"));
      copyright.add(new AnchorView("http://www.tis.bz.it/open", "TIS Innovation Park", TARGET));
      this.add(copyright);
      this.add(new SpanView("Via Siemens 29 Strasse - Bolzano/Bozen - Italy"));

      DivView license = new DivView("license");
      this.add(license);
      license.add(new SpanView("License:"));
      license.add(new AnchorView("http://www.gnu.org/licenses/agpl-3.0.html", "Affero GPL", TARGET));

      this.add(new SpanView("Developed by"));
      this.add(new AnchorView("http://www.davide.bz", "Davide Montesin", TARGET));
      this.add(new SpanView("Bolzano/Bozen - Italy"));
      this.add(new SpanView("Design by (alphabetical order)"));
      this.add(new AnchorView("mailto:giuliarosso.rg@gmail.com", "Giulia Rosso", TARGET));
      this.add(new AnchorView("mailto:iryna_dorosh@ukr.net", "Iryna Dorosh", TARGET));
      this.add(new AnchorView("mailto:virginia.mazzocco@gmail.com", "Virginia Mazzocco", TARGET));
      this.add(new SpanView("members of the"));
      this.add(new AnchorView("http://sasabus.org/wiki", "SASAbus community", TARGET));

      AnchorView showLicenses = new AnchorView("#", "Third-party free open source software libraries");
      showLicenses.addClickHandler(new AboutPanelShow3rdPartyLicenses(thirdPartyLicenses));
      this.add(showLicenses);

      thirdPartyLicenses.add(new SpanView("(alphabetical order)"));

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

   private DivView thirdParty(String libName,
                                  String libUrl,
                                  String license,
                                  String licenseUrl,
                                  String owner)
   {
      DivView row = new DivView("row");
      row.add(new AnchorView(libUrl, libName, TARGET));
      row.add(new SpanView("-"));
      row.add(new AnchorView(licenseUrl, license, TARGET));
      row.add(new SpanView("-"));
      row.add(new SpanView(owner));
      return row;
   }
}
