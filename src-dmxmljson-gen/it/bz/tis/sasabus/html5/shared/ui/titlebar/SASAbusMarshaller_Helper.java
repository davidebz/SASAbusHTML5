/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared.ui.titlebar;


public class SASAbusMarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.SASAbusMarshaller_Helper
{
   protected SASAbusMarshaller_Helper()
   {
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBarMenuClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBarMenuClickHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBarMapClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // mapWidget
            value = ((it.bz.tis.sasabus.html5.shared.ui.titlebar.TitleBarMapClickHandler)obj).mapWidget;
            if (value == null)
               structure.property("mapWidget").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", structure.property("mapWidget").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });

   }
}