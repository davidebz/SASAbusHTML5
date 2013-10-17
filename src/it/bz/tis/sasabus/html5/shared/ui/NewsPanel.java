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

import it.bz.tis.sasabus.backend.shared.News;
import it.bz.tis.sasabus.backend.shared.NewsList;
import it.bz.tis.sasabus.backend.shared.SASAbusDBDataReady;
import it.bz.tis.sasabus.html5.client.SASAbusDBClientImpl;
import bz.davide.dmweb.shared.i18n.I18N;
import bz.davide.dmweb.shared.view.DivView;
import bz.davide.dmweb.shared.view.SpanView;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class NewsPanel extends DivView
{

   public NewsPanel()
   {
      super("news");

      this.addStyleName("news");
      final DivView newsListDiv = new DivView("newslist");
      this.appendChild(newsListDiv);

      newsListDiv.appendChild(new SpanView(I18N.singleton.getLocalizedText("NewsPanel_loading")));

      SASAbusDBClientImpl.singleton.loadNews(new SASAbusDBDataReady<NewsList>()
      {

         @Override
         public void ready(NewsList newsList)
         {
            NewsPanel.this.newsListRead(newsListDiv, newsList);
         }
      });

   }

   void newsListRead(final DivView newsListDiv, NewsList newsList)
   {
      newsListDiv.clear();
      for (int i = 0; i < newsList.getNews().size(); i++)
      {
         News news = newsList.getNews().get(i);
         if (I18N.singleton.getLanguage().equals("de"))
         {
            newsListDiv.appendChild(new NewsItem(news.getTitel_de(), news.getNachricht_de()));
         }
         else
         {
            newsListDiv.appendChild(new NewsItem(news.getTitel_it(), news.getNachricht_it()));
         }
      }
   }
}
