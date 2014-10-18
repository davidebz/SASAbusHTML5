/*
SASAbusBackend - SASA bus JSON services

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

package it.bz.tis.sasabus.backend.shared;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class BusTripStop
{
   int id;
   int timeHHMMSS;

   int busStopId;

   public BusTripStop(int id, int timeHHMMSS, int busStopId)
   {
      super();
      this.id = id;
      this.timeHHMMSS = timeHHMMSS;
      this.busStopId = busStopId;

   }

   BusTripStop()
   {
   }

   public int getId()
   {
      return this.id;
   }

   public int getTimeHHMMSS()
   {
      return this.timeHHMMSS;
   }

   public int getBusStopId()
   {
      return this.busStopId;
   }

}
