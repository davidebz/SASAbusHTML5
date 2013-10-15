/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package it.bz.tis.sasabus.html5.shared.ui.map;


public class SASAbusWidgetUnmarshaller_Helper extends it.bz.tis.sasabus.backend.shared.SASAbusWidgetUnmarshaller_Helper
{
   protected SASAbusWidgetUnmarshaller_Helper()
   {
      this.putInstanceFactory("it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap((Void)null);
         }
      });

      this.putClassUnmarshaller("it.bz.tis.sasabus.html5.shared.ui.map.SASAbusMap", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.DivView", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // areaList
            if ((value = structure.property("areaList")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).areaList = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).areaList = (it.bz.tis.sasabus.backend.shared.AreaList)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("AreaList"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).areaList = (it.bz.tis.sasabus.backend.shared.AreaList)o;
                  }
               }
            // close
            if ((value = structure.property("close")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).close = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).close = (bz.davide.dmweb.shared.view.ButtonView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("ButtonView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).close = (bz.davide.dmweb.shared.view.ButtonView)o;
                  }
               }
            // controls
            if ((value = structure.property("controls")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).controls = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).controls = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).controls = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
            // gpsIcon
            if ((value = structure.property("gpsIcon")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).gpsIcon = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).gpsIcon = (it.bz.tis.sasabus.html5.shared.ui.icon.GpsIcon)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("GpsIcon"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).gpsIcon = (it.bz.tis.sasabus.html5.shared.ui.icon.GpsIcon)o;
                  }
               }
            // mapDiv
            if ((value = structure.property("mapDiv")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).mapDiv = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).mapDiv = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).mapDiv = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
            // navigationPanel
            if ((value = structure.property("navigationPanel")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).navigationPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMHashNavigationPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)o;
                  }
               }
            // overwievMap
            if ((value = structure.property("overwievMap")) != null)
               if (value.isNull())
                  ((SASAbusMap)obj).overwievMap = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((SASAbusMap)obj).overwievMap = (bz.davide.dmweb.shared.view.DivView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DivView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((SASAbusMap)obj).overwievMap = (bz.davide.dmweb.shared.view.DivView)o;
                  }
               }
         }
      });

   }
}
