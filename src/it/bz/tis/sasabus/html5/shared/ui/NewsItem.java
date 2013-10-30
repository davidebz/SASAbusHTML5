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

import bz.davide.dmweb.shared.model.Div;
import bz.davide.dmweb.shared.model.Html5ParserGwt;
import bz.davide.dmweb.shared.view.DMClickEvent;
import bz.davide.dmweb.shared.view.DMClickHandler;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;
import bz.davide.dmweb.shared.view.TextNodeView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class NewsItem extends DivView
{
   DivView descr = null;

   public NewsItem(String title, final String longDescr)
   {
      super("newsitem");
      RowItem newsTitle = new RowItem(new DMClickHandler()
      {
         @Override
         public void onClick(DMClickEvent event)
         {
            if (NewsItem.this.descr == null)
            {
               NewsItem.this.appendChild(NewsItem.this.descr = new DivView("descr"));
               try
               {
                  Div div = new Div();
                  Html5ParserGwt.parseXhtml("<div>" + longDescr + "</div>", div);
                  Html5ParserGwt.richText(NewsItem.this.descr, div.getChildNodes());
               }
               catch (Exception e)
               {
                  NewsItem.this.descr.clear();
                  NewsItem.this.descr.appendChild(new TextNodeView("Error: " +
                                                               e.getClass().getName() +
                                                               " - " +
                                                               e.getMessage()));
               }
            }
            else
            {
               NewsItem.this.remove(NewsItem.this.descr);
               NewsItem.this.descr = null;
            }
         }
      });

      newsTitle.appendChild(new SpanView(title));
      this.appendChild(newsTitle);

   }
}
