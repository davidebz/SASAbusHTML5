/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package bz.davide.dmweb.shared.i18n;


public class SASAbusWidgetUnmarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.SASAbusWidgetUnmarshaller_Helper
{
   protected SASAbusWidgetUnmarshaller_Helper()
   {
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.i18n.I18NData", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.i18n.I18NData>() {
         @Override public void check(bz.davide.dmweb.shared.i18n.I18NData  ret){
            // language
            if (ret.language != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.i18n.I18NData.language");
            // map
            if (ret.map != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.i18n.I18NData.map");
            emptyObjectCheck.get("bz.davide.dmweb.shared.i18n.I18N").check(ret);
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.i18n.I18NData", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.i18n.I18NData ret = new bz.davide.dmweb.shared.i18n.I18NData();
            emptyObjectCheck.get("bz.davide.dmweb.shared.i18n.I18NData").check(ret);
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.i18n.I18NData", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.i18n.I18N", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // language
            if ((value = structure.property("language")) != null)
               if (value.isNull())
                  ((I18NData)obj).language = null;
               else
               {
                  ((I18NData)obj).language = value.string();
               }
            // map
            if ((value = structure.property("map")) != null)
               if (value.isNull())
                  ((I18NData)obj).map = null;
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
                  ((I18NData)obj).map = hashMap;
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.i18n.I18N", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.i18n.I18N>() {
         @Override public void check(bz.davide.dmweb.shared.i18n.I18N  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.i18n.I18N", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return null;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.i18n.I18N", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            structure.close();
         }
      });

   }
}
