/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared;


public class FavouriteBusStationListUnmarshaller_Helper extends bz.davide.dmxmljson.unmarshalling.Unmarshaller
{
   protected FavouriteBusStationListUnmarshaller_Helper()
   {
      this.emptyObjectCheck.put("it.bz.tis.sasabus.html5.shared.FavouriteBusStationList", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<it.bz.tis.sasabus.html5.shared.FavouriteBusStationList>() {
         @Override public void check(it.bz.tis.sasabus.html5.shared.FavouriteBusStationList  ret){
            // busStationIds
            if (ret.busStationIds != null)
               throw new RuntimeException("The constructor initialized the field it.bz.tis.sasabus.html5.shared.FavouriteBusStationList.busStationIds");
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.FavouriteBusStationList", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            it.bz.tis.sasabus.html5.shared.FavouriteBusStationList ret = new it.bz.tis.sasabus.html5.shared.FavouriteBusStationList();
            emptyObjectCheck.get("it.bz.tis.sasabus.html5.shared.FavouriteBusStationList").check(ret);
            return ret;
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.FavouriteBusStationList", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // busStationIds
            if ((value = structure.property("busStationIds")) != null)
               if (value.isNull())
                  ((FavouriteBusStationList)obj).busStationIds = null;
               else
               {
                  //hashmap
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.HashMap hashMap = new java.util.HashMap();       
                  while ((value = arr.nextItem()) != null) {                       
                     bz.davide.dmxmljson.unmarshalling.Array item = value.array();        
                     Object key = item.nextItem().string();
                     hashMap.put(key,item.nextItem().string());
                  }                       
                  ((FavouriteBusStationList)obj).busStationIds = hashMap;
               }
            structure.close();
         }
      });

   }
}
