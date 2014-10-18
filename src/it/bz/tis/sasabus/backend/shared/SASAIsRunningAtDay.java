/*
SASAbusBackend - SASA bus JSON services

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

import java.util.Calendar;

public class SASAIsRunningAtDay implements IsRunningAtDay
{
   String runningDays;
   String firstDay_yyyymmdd;

   public SASAIsRunningAtDay(String firstDay_yyyymmdd, String runningDays)
   {
      super();
      this.firstDay_yyyymmdd = firstDay_yyyymmdd;
      this.runningDays = runningDays;
   }

   @Override
   public boolean isRunning(String yyyymmdd)
   {
      int dayIndex = this.daysBetween(this.firstDay_yyyymmdd, yyyymmdd);
      char dayBit = this.runningDays.charAt(dayIndex);
      return dayBit == '1';
   }

   private int daysBetween(String start_yyyymmdd, String end_yyyymmdd)
   {
      return (int) (this.daysFrom1970(end_yyyymmdd) - this.daysFrom1970(start_yyyymmdd));
   }

   private long daysFrom1970(String yyyymmdd)
   {
      Calendar calendar = Calendar.getInstance();
      calendar.setLenient(false);
      calendar.set(Calendar.YEAR, Integer.parseInt(yyyymmdd.substring(0, 4)));
      calendar.set(Calendar.MONTH, Integer.parseInt(yyyymmdd.substring(4, 6)) - 1);
      calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(yyyymmdd.substring(6, 8)));
      calendar.set(Calendar.HOUR_OF_DAY, 8); // don't use midnight, daylight saving time can cross date
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      long millis = calendar.getTimeInMillis();
      long days = millis / (1000L * 60L * 60L * 24L);
      return days;
   }
}
