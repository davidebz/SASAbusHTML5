/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared;


public class SASAbusMarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.titlebar.SASAbusMarshaller_Helper
{
   protected SASAbusMarshaller_Helper()
   {
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.SASAbusWebPage$InitParameters", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // aboutInfos
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPage.InitParameters)obj).aboutInfos;
            if (value == null)
               structure.property("aboutInfos").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.AboutInfos", structure.property("aboutInfos").structure(), identities, seq, false);
            }
            // custom
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPage.InitParameters)obj).custom;
            if (value == null)
               structure.property("custom").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N", structure.property("custom").structure(), identities, seq, false);
            }
            // homePageCustomFragment
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPage.InitParameters)obj).homePageCustomFragment;
            if (value == null)
               structure.property("homePageCustomFragment").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.HomePageCustomFragment", structure.property("homePageCustomFragment").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.SASAbusI18N", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // language
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusI18N)obj).language;
            if (value == null)
               structure.property("language").nullValue();
            else
            {
                    structure.property("language").string((String)value);                          
            }
            // translations
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusI18N)obj).translations;
            if (value == null)
               structure.property("translations").nullValue();
            else
            {
               it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText[] rawarray = (it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText[])value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("translations").array(rawarray.length);        
               for (Object o: rawarray) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                     internalMarschall(o, o.getClass().getName(), "it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText", array.item().structure(), identities, seq, false);
               }                                                              
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.HomePageCustomIntroText", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // introText
            value = ((it.bz.tis.sasabus.html5.shared.HomePageCustomIntroText)obj).introText;
            if (value == null)
               structure.property("introText").nullValue();
            else
            {
                    structure.property("introText").string((String)value);                          
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // busStationCustomView
            value = ((it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N)obj).busStationCustomView;
            if (value == null)
               structure.property("busStationCustomView").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.BusStationCustomView", structure.property("busStationCustomView").structure(), identities, seq, false);
            }
            // i18n
            value = ((it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N)obj).i18n;
            if (value == null)
               structure.property("i18n").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.SASAbusI18N", structure.property("i18n").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // cover
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).cover;
            if (value == null)
               structure.property("cover").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.DivView", structure.property("cover").structure(), identities, seq, false);
            }
            // custom
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).custom;
            if (value == null)
               structure.property("custom").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.BusStationCustomViewAndI18N", structure.property("custom").structure(), identities, seq, false);
            }
            // homePanel
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).homePanel;
            if (value == null)
               structure.property("homePanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.HomePanel", structure.property("homePanel").structure(), identities, seq, false);
            }
            // map
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).map;
            if (value == null)
               structure.property("map").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", structure.property("map").structure(), identities, seq, false);
            }
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            // wrapper
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusWebPageAttachHandler)obj).wrapper;
            if (value == null)
               structure.property("wrapper").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.DivView", structure.property("wrapper").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // key
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText)obj).key;
            if (value == null)
               structure.property("key").nullValue();
            else
            {
                    structure.property("key").string((String)value);                          
            }
            // text
            value = ((it.bz.tis.sasabus.html5.shared.SASAbusI18NKeyLocalizedText)obj).text;
            if (value == null)
               structure.property("text").nullValue();
            else
            {
                    structure.property("text").string((String)value);                          
            }
            if (!superClass)
               structure.close();
         }
      });

   }
}
