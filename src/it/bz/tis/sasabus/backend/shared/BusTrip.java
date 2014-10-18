/*
SASAbusBackend - SASA bus JSON services

Copyright (C) 2013 TIS Innovation Park - Bolzano/Bozen - Italy
Copyright (C) 2014 Davide Montesin <d@vide.bz> - Bolzano/Bozen - Italy

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
public class BusTrip
{
   int                              id;
   transient private IsRunningAtDay runningDays;
   BusTripStop[]                    busTripStop;

   // reverse relation
   int                              busLineId;

   // Derived
   int                              startHHMMSS;
   int                              endHHMMSS;

   protected BusTrip()
   {
   }

   public BusTrip(int id, IsRunningAtDay runningDays, int busLineId)
   {
      super();
      this.id = id;
      this.runningDays = runningDays;
      this.busLineId = busLineId;

      this.busTripStop = new BusTripStop[0];
      this.startHHMMSS = 999999;
      this.endHHMMSS = 000000;
   }

   public int getId()
   {
      return this.id;
   }

   public int getBusLineId()
   {
      return this.busLineId;
   }

   public IsRunningAtDay getIsRunningAtDay()
   {
      return this.runningDays;
   }

   public BusTripStop[] getBusTripStops()
   {
      return this.busTripStop;
   }

   public void setBusTripStop(BusTripStop[] busTripStop)
   {
      this.busTripStop = busTripStop;
   }

   public int getStartHHMMSS()
   {
      return this.startHHMMSS;
   }

   public int getEndHHMMSS()
   {
      return this.endHHMMSS;
   }

}
