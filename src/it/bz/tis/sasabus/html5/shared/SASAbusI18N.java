/*
SASAbusHTML5 - HTML5 App for SASA bus

Copyright (C) 2013 TIS Innovation Park - Bolzano/Bozen - Italy
Copyright (C) 2013-2014 Davide Montesin <d@vide.bz> - Bolzano/Bozen - Italy

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

package it.bz.tis.sasabus.html5.shared;

import java.util.HashMap;

public class SASAbusI18N
{
   String                                                 language;
   SASAbusI18NKeyLocalizedText[]                          translations;

   transient HashMap<String, SASAbusI18NKeyLocalizedText> cache;

   public String getLocalizedText(String key)
   {
      if (this.cache == null)
      {
         this.cache = new HashMap<String, SASAbusI18NKeyLocalizedText>();
         for (SASAbusI18NKeyLocalizedText t : this.translations)
         {
            this.cache.put(t.key, t);
         }
      }
      String ret = null;
      if (this.cache.get(key) != null)
      {
         ret = this.cache.get(key).text;
      }
      if (ret == null || ret.length() == 0)
      {
         ret = "[" + key + "]";
      }
      return ret;
   }

   public String getLanguage()
   {
      return this.language;
   }

}
