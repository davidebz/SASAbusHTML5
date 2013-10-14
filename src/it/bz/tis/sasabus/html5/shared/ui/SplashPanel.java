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

import it.bz.tis.sasabus.backend.shared.AreaList;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendMarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusBackendUnmarshaller;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.backend.shared.SASAbusDBLastModified;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import it.bz.tis.sasabus.html5.client.SASAbusHTML5;
import it.bz.tis.sasabus.html5.shared.ui.icon.HTML5Icon;
import it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap;
import it.bz.tis.sasabus.html5.shared.ui.menu.Menu;
import bz.davide.dmweb.shared.DMFlowPanel;
import bz.davide.dmweb.shared.DMHashNavigationPanel;
import bz.davide.dmweb.shared.DMImage;
import bz.davide.dmweb.shared.DMLabel;
import bz.davide.dmweb.shared.i18n.I18N;
import bz.davide.dmxmljson.marshalling.json.JSONStructure;
import bz.davide.dmxmljson.unmarshalling.json.gwt.GWTStructure;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Timer;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SplashPanel extends DMFlowPanel
{
   private static final String SASABUS_DB_LAST_MODIFIED = "SASAbusDBLastModified";
   private static final String SASABUS_DB_DATA          = "SASAbusDBData";

   public SplashPanel(final DMFlowPanel cover,
                      final DMFlowPanel wrapper,
                      final SASAbusMap map,
                      final Menu menu,
                      final HomePanel homePage,
                      final DMHashNavigationPanel navigationPanel)
   {
      super("splash-panel");
      this.add(new DMLabel("SASAbus"));
      this.add(new HTML5Icon());
      DMFlowPanel imageContainer = new DMFlowPanel("image-container");
      final DMImage sasaImg = new DMImage("../images/bus.png");
      imageContainer.add(sasaImg);

      this.add(imageContainer);
      final DMLabel currentOperation = new DMLabel(I18N.singleton.getLocalizedText("AboutPanel_checkingUpdates"));
      this.add(currentOperation);

      final long startTime = System.currentTimeMillis();

      final SASAbusDBDataReady<AreaList> response = new SASAbusDBDataReady<AreaList>()
      {
         @Override
         public void ready(final AreaList data)
         {
            currentOperation.setText(I18N.singleton.getLocalizedText("AboutPanel_ready"));
            long stopTime = System.currentTimeMillis();
            long minWait = 2000 - (stopTime - startTime);
            if (minWait < 0)
            {
               minWait = 0;
            }
            Timer t1 = new Timer()
            {
               @Override
               public void run()
               {
                  sasaImg.getElement().getStyle().setLeft(300, Unit.PX);
                  cover.getElement().getStyle().setOpacity(0);
                  Timer t2 = new Timer()
                  {
                     @Override
                     public void run()
                     {
                        wrapper.remove(cover);
                        map.start(data);
                        menu.initClickHandlers(data);

                     }
                  };
                  t2.schedule(700);
               }
            };
            t1.schedule((int) minWait);
            FavouriteBusStationListPanel favouriteBusStationListPanel = new FavouriteBusStationListPanel(data,
                                                                                                         navigationPanel,
                                                                                                         map);
            homePage.favouriteContainer.add(favouriteBusStationListPanel);
            homePage.favouriteBusStationListPanel = favouriteBusStationListPanel;
         }
      };

      SASAbusDBClientImpl.singleton.lastModified(new SASAbusDBDataReady<SASAbusDBLastModified>()
      {
         @Override
         public void ready(SASAbusDBLastModified data)
         {
            final Storage localStorage = Storage.getLocalStorageIfSupported();
            if (localStorage != null)
            {

               String tmp = localStorage.getItem(SASABUS_DB_LAST_MODIFIED);
               if (tmp != null)
               {
                  long localLastModified = Long.parseLong(tmp);
                  if (localLastModified == data.getTimestamp())
                  {

                     currentOperation.setText(I18N.singleton.getLocalizedText("AboutPanel_readingLocalstore"));

                     Timer t1 = new Timer()
                     {
                        @Override
                        public void run()
                        {

                           SASAbusBackendUnmarshaller unmarshaller = new SASAbusBackendUnmarshaller();
                           String txt = localStorage.getItem(SASABUS_DB_DATA);
                           JSONObject jsonObject = (JSONObject) JSONParser.parse(txt);
                           GWTStructure gwtStructure = new GWTStructure(jsonObject);
                           try
                           {
                              AreaList obj = (AreaList) unmarshaller.newInstance("AreaList");
                              unmarshaller.unmarschall(gwtStructure, obj);

                              response.ready(obj);

                           }
                           catch (Exception exxx)
                           {
                              SASAbusHTML5.handleException(exxx);
                           }

                        }
                     };
                     t1.schedule(200);
                     return;
                  }
               }
            }

            currentOperation.setText(I18N.singleton.getLocalizedText("AboutPanel_downloadingUpdates"));

            SASAbusDBClientImpl.singleton.listBusAreasLinesStopsStations(new SASAbusDBDataReady<AreaList>()
            {

               @Override
               public void ready(final AreaList data)
               {
                  // save data to localstore if possible
                  if (localStorage != null) // browser support local storage
                  {
                     currentOperation.setText(I18N.singleton.getLocalizedText("AboutPanel_writingLocalstore"));

                     Timer t1 = new Timer()
                     {

                        @Override
                        public void run()
                        {
                           try
                           {
                              int i = 0;
                              long[] times = new long[7];
                              times[i++] = System.currentTimeMillis();
                              JSONStructure jsonStructure = new JSONStructure();
                              times[i++] = System.currentTimeMillis();
                              SASAbusBackendMarshaller marshaller = new SASAbusBackendMarshaller();
                              times[i++] = System.currentTimeMillis();
                              marshaller.marschall(data, jsonStructure);
                              times[i++] = System.currentTimeMillis();
                              String txt = jsonStructure.toString();
                              times[i++] = System.currentTimeMillis();
                              localStorage.setItem(SASABUS_DB_DATA, txt);
                              times[i++] = System.currentTimeMillis();
                              localStorage.setItem(SASABUS_DB_LAST_MODIFIED,
                                                   String.valueOf(data.getLastModified()));
                              times[i++] = System.currentTimeMillis();

                              long stop = System.currentTimeMillis();

                              String report = "";

                              for (int k = 0; k < times.length - 1; k++)
                              {
                                 report += "Time " + k + ": " + (times[k + 1] - times[k]) + "\n";
                              }

                              response.ready(data);

                           }
                           catch (Exception e)
                           {
                              SASAbusHTML5.handleException(e);
                           }
                        }

                     };

                     t1.schedule(200);
                     return;

                  }
                  response.ready(data);

               }
            });

         }
      });
   }
}
