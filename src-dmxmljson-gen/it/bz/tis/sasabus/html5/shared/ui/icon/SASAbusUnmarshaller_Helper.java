/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared.ui.icon;


public class SASAbusUnmarshaller_Helper extends it.bz.tis.sasabus.html5.shared.SASAbusUnmarshaller_Helper
{
   protected SASAbusUnmarshaller_Helper()
   {
      this.emptyObjectCheck.put("it.bz.tis.sasabus.html5.shared.ui.icon.Icon", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<it.bz.tis.sasabus.html5.shared.ui.icon.Icon>() {
         @Override public void check(it.bz.tis.sasabus.html5.shared.ui.icon.Icon  ret){
            emptyObjectCheck.get("bz.davide.dmweb.shared.view.ImgView").check(ret);
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.icon.Icon", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            it.bz.tis.sasabus.html5.shared.ui.icon.Icon ret = new it.bz.tis.sasabus.html5.shared.ui.icon.Icon();
            emptyObjectCheck.get("it.bz.tis.sasabus.html5.shared.ui.icon.Icon").check(ret);
            return ret;
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.icon.Icon", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.ImgView", obj, identities);
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
