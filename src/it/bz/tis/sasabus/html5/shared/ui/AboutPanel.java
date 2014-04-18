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

   SpanView            copyrightYears;
   AnchorView          copyrightLink;
   SpanView            copyrightCompanyAddress;

   SpanView            licenseLabel;
   AnchorView          licenseLink;

   AnchorView          teamLink;
   DivView             teamMembers;

   DivView             thirdPartyLicenses;

   public AboutPanel()
   {
      super("about");
      ButtonView close = new ButtonView("X");
      close.setStyleName("close");

      this.thirdPartyLicenses = new DivView("third-party-licenses");

      close.addClickHandler(new AboutPanelCloseHandler(this, this.thirdPartyLicenses));
      this.appendChild(close);
      DivView copyright = new DivView("copyright");
      copyright.appendChild(new SpanView("(C)"));
      copyright.appendChild(this.copyrightYears = new SpanView("YYYY"));
      copyright.appendChild(this.copyrightLink = new AnchorView("#", "Company Name", TARGET));
      this.appendChild(copyright);
      this.appendChild(this.copyrightCompanyAddress = new SpanView("Company Address"));

      DivView license = new DivView("license");
      this.appendChild(license);
      license.appendChild(this.licenseLabel = new SpanView("License"));
      license.appendChild(new SpanView(":"));
      license.appendChild(this.licenseLink = new AnchorView("#", "License Name", TARGET));

      DivView teamView = new DivView("team");
      this.appendChild(teamView);
      teamView.appendChild(new SpanView("Team:"));
      teamView.appendChild(this.teamLink = new AnchorView("#", "Team Name", TARGET));
      this.teamMembers = new DivView("members");
      teamView.appendChild(this.teamMembers);

      AnchorView showLicenses = new AnchorView("#", "Third-party free open source software libraries");
      showLicenses.addClickHandler(new AboutPanelShow3rdPartyLicenses(this.thirdPartyLicenses));
      this.appendChild(showLicenses);

      this.appendChild(this.thirdPartyLicenses);

      /*
      this.thirdPartyLicenses.appendChild(new SpanView("(alphabetical order)"));

      this.thirdPartyLicenses.appendChild(this.thirdParty("DM XML-JSON",
                                                          "http://www.davide.bz/en/dmxj",
                                                          "LGPL3",
                                                          "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                                          "Davide Montesin"));
      this.thirdPartyLicenses.appendChild(this.thirdParty("DM Web",
                                                          "http://www.davide.bz/en/dmweb",
                                                          "LGPL3",
                                                          "http://en.wikipedia.org/wiki/GNU_Lesser_General_Public_License",
                                                          "Davide Montesin"));

      this.thirdPartyLicenses.appendChild(this.thirdParty("Flag Icons - Europe",
                                                          "http://antibakteriell.deviantart.com/art/Flag-Icons-Europe-166536006",
                                                          "CC BY 3.0",
                                                          "http://creativecommons.org/licenses/by/3.0/",
                                                          "antibakteriell"));

      this.thirdPartyLicenses.appendChild(this.thirdParty("Visualization: Gauge",
                                                          "https://developers.google.com/chart/interactive/docs/gallery/gauge",
                                                          "API",
                                                          "https://developers.google.com/chart/terms",
                                                          "Google"));

      this.thirdPartyLicenses.appendChild(this.thirdParty("GWT",
                                                          "http://www.gwtproject.org",
                                                          "Apache 2.0",
                                                          "http://www.gwtproject.org/terms.html",
                                                          "Google"));
      this.thirdPartyLicenses.appendChild(this.thirdParty("Leaflet",
                                                          "http://leafletjs.com",
                                                          "BSD",
                                                          "http://github.com/Leaflet/Leaflet/blob/master/LICENSE",
                                                          "Vladimir Agafonkin, CloudMade"));
      */
   }

   public AboutPanel(AboutInfos infos)
   {
      this();
      this.setInfos(infos);
   }

   public void setInfos(AboutInfos infos)
   {
      this.copyrightYears.setText(infos.copyrightYears);
      this.copyrightLink.setText(infos.copyrightCompany);
      this.copyrightLink.setHref(infos.copyrightCompanyUrl);
      this.copyrightCompanyAddress.setText(infos.copyrightCompanyAddress);

      this.licenseLabel.setText(infos.licenseLabel);
      this.licenseLink.setText(infos.licenseName);
      this.licenseLink.setHref(infos.licenseUrl);

      this.teamMembers.clear();

      this.teamLink.setHref(infos.teamUrl);
      this.teamLink.setText(infos.teamName);

      TeamMember[] teamMembers = infos.teamMembers;
      if (teamMembers != null)
      {
         for (TeamMember member : teamMembers)
         {
            DivView memberView = new DivView("member");
            memberView.appendChild(new AnchorView(member.url, member.name, TARGET));
            memberView.appendChild(new SpanView(member.role));
            this.teamMembers.appendChild(memberView);
         }
      }

      this.thirdPartyLicenses.clear();
      ThirdPartyLibrary[] libraries = infos.libraries;
      if (libraries != null)
      {
         for (ThirdPartyLibrary library : libraries)
         {
            this.thirdPartyLicenses.appendChild(this.thirdParty(library.name,
                                                                library.url,
                                                                library.license,
                                                                library.licenseUrl,
                                                                library.owner));

         }
      }

   }

   private DivView thirdParty(String libName, String libUrl, String license, String licenseUrl, String owner)
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
