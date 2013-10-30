/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared.ui;


public class SASAbusWidgetUnmarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.menu.SASAbusWidgetUnmarshaller_Helper
{
   protected SASAbusWidgetUnmarshaller_Helper()
   {
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.HomePanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.HomePanel((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.HomePanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.DivView", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // favouriteBusStationListPanel
            if ((value = structure.property("favouriteBusStationListPanel")) != null)
               if (value.isNull())
                  ((HomePanel)obj).favouriteBusStationListPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((HomePanel)obj).favouriteBusStationListPanel = (it.bz.tis.sasabus.html5.shared.ui.FavouriteBusStationListPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("FavouriteBusStationListPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((HomePanel)obj).favouriteBusStationListPanel = (it.bz.tis.sasabus.html5.shared.ui.FavouriteBusStationListPanel)o;
                  }
               }
            // favouriteContainer
            if ((value = structure.property("favouriteContainer")) != null)
               if (value.isNull())
                  ((HomePanel)obj).favouriteContainer = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((HomePanel)obj).favouriteContainer = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((HomePanel)obj).favouriteContainer = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
            // introText
            if ((value = structure.property("introText")) != null)
               if (value.isNull())
                  ((HomePanel)obj).introText = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((HomePanel)obj).introText = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((HomePanel)obj).introText = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
            // map
            if ((value = structure.property("map")) != null)
               if (value.isNull())
                  ((HomePanel)obj).map = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((HomePanel)obj).map = (it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("SASAbusMap"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((HomePanel)obj).map = (it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap)o;
                  }
               }
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.AboutPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.AboutPanel((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.AboutPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.DivView", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.AboutPanelCloseHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.AboutPanelCloseHandler((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.AboutPanelCloseHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // aboutPanel
            if ((value = structure.property("aboutPanel")) != null)
               if (value.isNull())
                  ((AboutPanelCloseHandler)obj).aboutPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((AboutPanelCloseHandler)obj).aboutPanel = (it.bz.tis.sasabus.html5.shared.ui.AboutPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("AboutPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((AboutPanelCloseHandler)obj).aboutPanel = (it.bz.tis.sasabus.html5.shared.ui.AboutPanel)o;
                  }
               }
            // thirdPartyLicenses
            if ((value = structure.property("thirdPartyLicenses")) != null)
               if (value.isNull())
                  ((AboutPanelCloseHandler)obj).thirdPartyLicenses = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((AboutPanelCloseHandler)obj).thirdPartyLicenses = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((AboutPanelCloseHandler)obj).thirdPartyLicenses = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.AboutPanelShow3rdPartyLicenses", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.AboutPanelShow3rdPartyLicenses((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.AboutPanelShow3rdPartyLicenses", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // licensesPanel
            if ((value = structure.property("licensesPanel")) != null)
               if (value.isNull())
                  ((AboutPanelShow3rdPartyLicenses)obj).licensesPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((AboutPanelShow3rdPartyLicenses)obj).licensesPanel = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((AboutPanelShow3rdPartyLicenses)obj).licensesPanel = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
         }
      });
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.FavouriteBusStationListPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.FavouriteBusStationListPanel((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.FavouriteBusStationListPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.DivView", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // areaList
            if ((value = structure.property("areaList")) != null)
               if (value.isNull())
                  ((FavouriteBusStationListPanel)obj).areaList = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((FavouriteBusStationListPanel)obj).areaList = (it.bz.tis.sasabus.backend.shared.AreaList)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("AreaList"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((FavouriteBusStationListPanel)obj).areaList = (it.bz.tis.sasabus.backend.shared.AreaList)o;
                  }
               }
            // map
            if ((value = structure.property("map")) != null)
               if (value.isNull())
                  ((FavouriteBusStationListPanel)obj).map = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((FavouriteBusStationListPanel)obj).map = (it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("SASAbusMap"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((FavouriteBusStationListPanel)obj).map = (it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap)o;
                  }
               }
            // navigationPanel
            if ((value = structure.property("navigationPanel")) != null)
               if (value.isNull())
                  ((FavouriteBusStationListPanel)obj).navigationPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((FavouriteBusStationListPanel)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMHashNavigationPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((FavouriteBusStationListPanel)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)o;
                  }
               }
         }
      });

   }
}
