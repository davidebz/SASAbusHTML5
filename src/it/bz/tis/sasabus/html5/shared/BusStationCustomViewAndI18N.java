/*
SASAbusHTML5 - HTML5 App for SASA bus

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

public class BusStationCustomViewAndI18N
{
   SASAbusI18N           i18n;
   BusStationCustomView  busStationCustomView;
   BusRoutingViewFactory busRoutingViewFactory;

   public SASAbusI18N getI18n()
   {
      return this.i18n;
   }

   public BusStationCustomView getBusStationCustomView()
   {
      return this.busStationCustomView;
   }

   public BusRoutingViewFactory getBusRoutingViewFactory()
   {
      return this.busRoutingViewFactory;
   }
}
