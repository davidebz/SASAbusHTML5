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

package it.bz.tis.sasabus.backend.server.sasabusdb;

import it.bz.tis.sasabus.backend.shared.Area;
import it.bz.tis.sasabus.backend.shared.BusLine;
import it.bz.tis.sasabus.backend.shared.BusStation;
import it.bz.tis.sasabus.backend.shared.BusStop;
import it.bz.tis.sasabus.backend.shared.BusTrip;
import it.bz.tis.sasabus.backend.shared.BusTripStop;
import it.bz.tis.sasabus.backend.shared.BusTripStopReference;
import it.bz.tis.sasabus.backend.shared.LatLng;
import it.bz.tis.sasabus.backend.shared.SASAIsRunningAtDay;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * @author Davide Montesin <d@vide.bz>
 */
public class SASAbusDBFromSqliteLoader
{
   public static SASAbusDBServerImpl load(File sqlitePath) throws ClassNotFoundException, SQLException
   {
      SASAbusDBServerImpl sasabusdb = new SASAbusDBServerImpl();
      loadDataAndMainRelations(sasabusdb, sqlitePath);

      sasabusdb.lastModified = sqlitePath.lastModified();

      return sasabusdb;
   }

   private static void loadDataAndMainRelations(SASAbusDBServerImpl sasabusdb, File sqlitePath)
                                                                                               throws ClassNotFoundException,
                                                                                               SQLException
   {
      Class.forName("org.sqlite.JDBC");
      Connection conn = DriverManager.getConnection("jdbc:sqlite:" + sqlitePath.getAbsolutePath());

      loadStartDay(conn, sasabusdb);

      HashMap<Integer, BusStop> busStopsById = loadBusStationsAndBusStops(conn, sasabusdb);
      IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>> busLinesByBusStation = new IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>>();
      loadAreas(conn, sasabusdb, busStopsById, busLinesByBusStation);

      for (BusStation busStation : busLinesByBusStation.keySet())
      {
         busStation.setBusLines(new ArrayList<BusLine>(busLinesByBusStation.get(busStation).keySet()).toArray(new BusLine[0]));
      }

      conn.close();

   }

   private static void loadStartDay(Connection conn, SASAbusDBServerImpl sasabusdb) throws SQLException
   {
      String query = "select strftime('%Y%m%d',da_data) from validita";
      ResultSet rs = conn.createStatement().executeQuery(query);
      rs.next();
      sasabusdb.firstDay = rs.getString(1);
      rs.close();
   }

   private static HashMap<Integer, BusStop> loadBusStationsAndBusStops(Connection conn,
                                                                       SASAbusDBServerImpl sasabusdb)
                                                                                                     throws SQLException
   {
      HashMap<Integer, BusStop> busStopsById = new HashMap<Integer, BusStop>();

      String query = "select id, nome_it, nome_de, latitudine, longitudine from paline order by nome_it, nome_de, id";
      ResultSet rs = conn.createStatement().executeQuery(query);

      ArrayList<BusStation> busStationsList = new ArrayList<BusStation>();

      BusStation last = null;
      while (rs.next())
      {
         int id = rs.getInt("id");
         String nome_it = rs.getString("nome_it");
         String nome_de = rs.getString("nome_de");
         double lat = rs.getDouble("latitudine");
         double lon = rs.getDouble("longitudine");

         // Check if the last station has the same name
         if (last == null || !last.getName_it().equals(nome_it) || !last.getName_de().equals(nome_de))
         {
            last = new BusStation(nome_it, nome_de);
            busStationsList.add(last);
         }
         BusStop busStop = new BusStop(last, id, lat, lon);
         busStopsById.put(busStop.getId(), busStop);
      }

      for (BusStation busStation : busStationsList)
      {
         sasabusdb.busStationsById.put(busStation.getId(), busStation);
      }
      rs.close();

      return busStopsById;
   }

   private static void loadAreas(Connection conn,
                                 SASAbusDBServerImpl sasabusdb,
                                 HashMap<Integer, BusStop> busStopsById,
                                 IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>> busLinesByBusStation)
                                                                                                                  throws SQLException
   {
      ArrayList<Area> areaList = new ArrayList<Area>();

      String query = "select id ,  nome_it , nome_de, nome_table from bacini order by id";
      ResultSet rs = conn.createStatement().executeQuery(query);
      while (rs.next())
      {
         int bacino_id = rs.getInt("id");
         String nome_it = rs.getString("nome_it");
         String nome_de = rs.getString("nome_de");
         String prefixTable = rs.getString("nome_table");
         LatLng[] bounds = null;

         switch (bacino_id)
         {
            case 1:
               bounds = new LatLng[Area.boundLats_bz.length];
               for (int i = 0; i < bounds.length; i++)
               {
                  bounds[i] = new LatLng(Area.boundLats_bz[i], Area.boundLons_bz[i]);
               }
            break;
            case 2:
               bounds = new LatLng[Area.boundLats_me.length];
               for (int i = 0; i < bounds.length; i++)
               {
                  bounds[i] = new LatLng(Area.boundLats_me[i], Area.boundLons_me[i]);
               }
            break;
            case 3:
               bounds = new LatLng[Area.boundLats_su.length];
               for (int i = 0; i < bounds.length; i++)
               {
                  bounds[i] = new LatLng(Area.boundLats_su[i], Area.boundLons_su[i]);
               }
            break;
         }

         Area area = new Area(bacino_id, nome_it, nome_de, bounds);

         areaList.add(area);

         loadBusLines(conn, area, prefixTable, busStopsById, sasabusdb, busLinesByBusStation);

      }
      sasabusdb.areas = areaList.toArray(new Area[0]);
      rs.close();
   }

   private static void loadBusLines(Connection conn,
                                    Area area,
                                    String prefixTable,
                                    HashMap<Integer, BusStop> busStopsById,
                                    SASAbusDBServerImpl sasabusdb,
                                    IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>> busLinesByBusStation)
                                                                                                                     throws SQLException
   {
      String query = "select id, num_lin from " + prefixTable + "linee "; // order complex, maded in java

      ResultSet rs = conn.createStatement().executeQuery(query);
      while (rs.next())
      {
         int db_line_id = rs.getInt("id");
         int line_id = db_line_id * 100 + area.getId(); // make id unique for all areas
         String num = rs.getString("num_lin");
         BusLine busLine = new BusLine(line_id, num, area);
         IdentityHashMap<BusStop, Void> busLineUniqueBusStops = new IdentityHashMap<BusStop, Void>();
         loadBusTrips(conn,
                      busLine,
                      db_line_id,
                      prefixTable,
                      busStopsById,
                      sasabusdb,
                      busLineUniqueBusStops,
                      busLinesByBusStation);

         BusStop[] busLineStops = new ArrayList<BusStop>(busLineUniqueBusStops.keySet()).toArray(new BusStop[0]);
         busLine.setBusStops(busLineStops);

      }
      rs.close();

   }

   private static void loadBusTrips(Connection conn,
                                    BusLine busLine,
                                    int db_line_id,
                                    String prefixTable,
                                    HashMap<Integer, BusStop> busStopsById,
                                    SASAbusDBServerImpl sasabusdb,
                                    IdentityHashMap<BusStop, Void> busLineUniqueBusStops,
                                    IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>> busLinesByBusStation)
                                                                                                                     throws SQLException
   {

      String query = "select id, effettuazione from "
                     + prefixTable
                     + "corse  where lineaId = "
                     + db_line_id
                     + " order by orario_partenza";

      ResultSet rs = conn.createStatement().executeQuery(query);
      while (rs.next())
      {
         int trip_id = rs.getInt("id");
         String effettuazione = rs.getString("effettuazione");
         BusTrip busTrip = new BusTrip(trip_id,
                                       new SASAIsRunningAtDay(sasabusdb.firstDay, effettuazione),
                                       busLine.getId());

         loadBusTripStops(conn,
                          busTrip,
                          busLine,
                          prefixTable,
                          busStopsById,
                          sasabusdb,
                          busLineUniqueBusStops,
                          busLinesByBusStation);

         sasabusdb.trips.add(busTrip);

      }

      rs.close();
   }

   private static void loadBusTripStops(Connection conn,
                                        BusTrip busTrip,
                                        BusLine busLine,
                                        String prefixTable,
                                        HashMap<Integer, BusStop> busStopsById,
                                        SASAbusDBServerImpl sasabusdb,
                                        IdentityHashMap<BusStop, Void> busLineUniqueBusStops,
                                        IdentityHashMap<BusStation, IdentityHashMap<BusLine, Void>> busLinesByBusStation)
                                                                                                                         throws SQLException
   {
      String query = "select id, palinaId, orario from "
                     + prefixTable
                     + "orarii where corsaId = "
                     + busTrip.getId()
                     + " order by progressivo";

      ResultSet rs = conn.createStatement().executeQuery(query);
      ArrayList<BusTripStop> busTripStopList = new ArrayList<BusTripStop>();
      while (rs.next())
      {
         int stop_id = rs.getInt("id");
         int palina_id = rs.getInt("palinaId");
         String time = rs.getString("orario");
         String[] timeParts = time.split(":");
         int timeHHMMSS = Integer.parseInt(timeParts[2])
                          + Integer.parseInt(timeParts[1])
                          * 100
                          + Integer.parseInt(timeParts[0])
                          * 10000;

         BusStop busStop = busStopsById.get(palina_id);

         if (busStop != null) // db integrity?
         {

            BusTripStop busTripStop = new BusTripStop(stop_id, timeHHMMSS, busStop.getId());

            // BusLine cache

            busLineUniqueBusStops.put(busStop, null);

            IdentityHashMap<BusLine, Void> busLines = busLinesByBusStation.get(busStop.getBusStation());
            if (busLines == null)
            {
               busLines = new IdentityHashMap<BusLine, Void>();
               busLinesByBusStation.put(busStop.getBusStation(), busLines);
            }
            busLines.put(busLine, null);

            // BusTripStopCache
            ArrayList<BusTripStopReference> busTripStops = sasabusdb.busTripStopByBusStationId.get(busStop.getBusStation().getId());
            if (busTripStops == null)
            {
               busTripStops = new ArrayList<BusTripStopReference>();
               sasabusdb.busTripStopByBusStationId.put(busStop.getBusStation().getId(), busTripStops);
            }
            busTripStops.add(new BusTripStopReference(busTrip, busTripStopList.size()));

            busTripStopList.add(busTripStop);
         }
      }
      busTrip.setBusTripStop(busTripStopList.toArray(new BusTripStop[0]));
      rs.close();
   }
}
