/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared.ui.menu;


public class SASAbusWidgetMarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.map.SASAbusWidgetMarshaller_Helper
{
   protected SASAbusWidgetMarshaller_Helper()
   {
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.DMClickableFlowPanel", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuAboutClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // aboutPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAboutClickHandler)obj).aboutPanel;
            if (value == null)
               structure.property("aboutPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.AboutPanel", structure.property("aboutPanel").structure(), identities, seq, false);
            }
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAboutClickHandler)obj).menu;
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
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuMapClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // areaList
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMapClickHandler)obj).areaList;
            if (value == null)
               structure.property("areaList").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.backend.shared.AreaList", structure.property("areaList").structure(), identities, seq, false);
            }
            // map
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMapClickHandler)obj).map;
            if (value == null)
               structure.property("map").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", structure.property("map").structure(), identities, seq, false);
            }
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMapClickHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMapClickHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuNewsClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuNewsClickHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuNewsClickHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuAreaLinesClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // areaList
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAreaLinesClickHandler)obj).areaList;
            if (value == null)
               structure.property("areaList").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.backend.shared.AreaList", structure.property("areaList").structure(), identities, seq, false);
            }
            // map
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAreaLinesClickHandler)obj).map;
            if (value == null)
               structure.property("map").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", structure.property("map").structure(), identities, seq, false);
            }
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAreaLinesClickHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuAreaLinesClickHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuSettingsClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // menu
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuSettingsClickHandler)obj).menu;
            if (value == null)
               structure.property("menu").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.Menu", structure.property("menu").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuSettingsClickHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.Menu", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.DMFlowPanel", "N/A",structure, identities, seq, true);
            Object value;
            // about
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).about;
            if (value == null)
               structure.property("about").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("about").structure(), identities, seq, false);
            }
            // aboutPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).aboutPanel;
            if (value == null)
               structure.property("aboutPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.AboutPanel", structure.property("aboutPanel").structure(), identities, seq, false);
            }
            // areasAndLine
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).areasAndLine;
            if (value == null)
               structure.property("areasAndLine").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("areasAndLine").structure(), identities, seq, false);
            }
            // favourites
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).favourites;
            if (value == null)
               structure.property("favourites").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("favourites").structure(), identities, seq, false);
            }
            // map
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).map;
            if (value == null)
               structure.property("map").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", structure.property("map").structure(), identities, seq, false);
            }
            // mapItem
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).mapItem;
            if (value == null)
               structure.property("mapItem").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("mapItem").structure(), identities, seq, false);
            }
            // menuOpen
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).menuOpen;
            if (value == null)
               structure.property("menuOpen").nullValue();
            else
            {
                    structure.property("menuOpen").booleanValue((Boolean)value);                          
            }
            // more
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).more;
            if (value == null)
               structure.property("more").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("more").structure(), identities, seq, false);
            }
            // moreClickHandler
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).moreClickHandler;
            if (value == null)
               structure.property("moreClickHandler").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuMoreClickHandler", structure.property("moreClickHandler").structure(), identities, seq, false);
            }
            // moreMenuItems
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).moreMenuItems;
            if (value == null)
               structure.property("moreMenuItems").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMFlowPanel", structure.property("moreMenuItems").structure(), identities, seq, false);
            }
            // navigationPanel
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            // news
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).news;
            if (value == null)
               structure.property("news").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("news").structure(), identities, seq, false);
            }
            // parkings
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).parkings;
            if (value == null)
               structure.property("parkings").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("parkings").structure(), identities, seq, false);
            }
            // search
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).search;
            if (value == null)
               structure.property("search").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("search").structure(), identities, seq, false);
            }
            // sendFeedback
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).sendFeedback;
            if (value == null)
               structure.property("sendFeedback").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("sendFeedback").structure(), identities, seq, false);
            }
            // train
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.Menu)obj).train;
            if (value == null)
               structure.property("train").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"it.bz.tis.sasabus.html5.shared.ui.menu.MenuItem", structure.property("train").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("it.bz.tis.sasabus.html5.shared.ui.menu.MenuMoreClickHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // moreMenuItem
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMoreClickHandler)obj).moreMenuItem;
            if (value == null)
               structure.property("moreMenuItem").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.DMFlowPanel", structure.property("moreMenuItem").structure(), identities, seq, false);
            }
            // moreOpen
            value = ((it.bz.tis.sasabus.html5.shared.ui.menu.MenuMoreClickHandler)obj).moreOpen;
            if (value == null)
               structure.property("moreOpen").nullValue();
            else
            {
                    structure.property("moreOpen").booleanValue((Boolean)value);                          
            }
            if (!superClass)
               structure.close();
         }
      });

   }
}
