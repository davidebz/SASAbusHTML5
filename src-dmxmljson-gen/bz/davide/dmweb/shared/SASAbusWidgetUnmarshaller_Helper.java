/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package bz.davide.dmweb.shared;


public class SASAbusWidgetUnmarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.SASAbusWidgetUnmarshaller_Helper
{
   protected SASAbusWidgetUnmarshaller_Helper()
   {
      this.putInstanceFactory("bz.davide.dmweb.shared.DMWidgetSerializationData", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMWidgetSerializationData((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMWidgetSerializationData", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // attachHandlers
            if ((value = structure.property("attachHandlers")) != null)
               if (value.isNull())
                  ((DMWidgetSerializationData)obj).attachHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMAttachHandler"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMWidgetSerializationData)obj).attachHandlers = arrayList;
               }
            // domReady
            if ((value = structure.property("domReady")) != null)
               if (value.isNull())
                  ((DMWidgetSerializationData)obj).domReady = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMAttachHandler"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMWidgetSerializationData)obj).domReady = arrayList;
               }
            // i18n
            if ((value = structure.property("i18n")) != null)
               if (value.isNull())
                  ((DMWidgetSerializationData)obj).i18n = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((DMWidgetSerializationData)obj).i18n = (bz.davide.dmweb.shared.i18n.I18NData)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("I18NData"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((DMWidgetSerializationData)obj).i18n = (bz.davide.dmweb.shared.i18n.I18NData)o;
                  }
               }
            // idseq
            if ((value = structure.property("idseq")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((DMWidgetSerializationData)obj).idseq = (int)value.integer();
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMWidgetEventAttachHandler((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // widget
            if ((value = structure.property("widget")) != null)
               if (value.isNull())
                  ((DMWidgetEventAttachHandler)obj).widget = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((DMWidgetEventAttachHandler)obj).widget = (bz.davide.dmweb.shared.DMWidget)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMWidget"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((DMWidgetEventAttachHandler)obj).widget = (bz.davide.dmweb.shared.DMWidget)o;
                  }
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMGwtWidgetHostAttachHandler((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // factory
            if ((value = structure.property("factory")) != null)
               if (value.isNull())
                  ((DMGwtWidgetHostAttachHandler)obj).factory = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((DMGwtWidgetHostAttachHandler)obj).factory = (bz.davide.dmweb.shared.DMGwtWidgetHostFactory)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMGwtWidgetHostFactory"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((DMGwtWidgetHostAttachHandler)obj).factory = (bz.davide.dmweb.shared.DMGwtWidgetHostFactory)o;
                  }
               }
            // widget
            if ((value = structure.property("widget")) != null)
               if (value.isNull())
                  ((DMGwtWidgetHostAttachHandler)obj).widget = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((DMGwtWidgetHostAttachHandler)obj).widget = (bz.davide.dmweb.shared.DMWidget)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMWidget"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((DMGwtWidgetHostAttachHandler)obj).widget = (bz.davide.dmweb.shared.DMWidget)o;
                  }
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMLabel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMLabel((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMLabel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMWidget", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMAnchor", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMAnchor((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMAnchor", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMWidget", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMButton", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMButton((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMButton", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMWidget", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMHashNavigationPanelAttachHandler((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // navigationPanel
            if ((value = structure.property("navigationPanel")) != null)
               if (value.isNull())
                  ((DMHashNavigationPanelAttachHandler)obj).navigationPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((DMHashNavigationPanelAttachHandler)obj).navigationPanel = (bz.davide.dmweb.shared.DMHashNavigationPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMHashNavigationPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((DMHashNavigationPanelAttachHandler)obj).navigationPanel = (bz.davide.dmweb.shared.DMHashNavigationPanel)o;
                  }
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMWidget", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return null;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMWidget", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // attachHandlers
            if ((value = structure.property("attachHandlers")) != null)
               if (value.isNull())
                  ((DMWidget)obj).attachHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMAttachHandler"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMWidget)obj).attachHandlers = arrayList;
               }
            // childs
            if ((value = structure.property("childs")) != null)
               if (value.isNull())
                  ((DMWidget)obj).childs = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMWidget"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMWidget)obj).childs = arrayList;
               }
            // clickHandlers
            if ((value = structure.property("clickHandlers")) != null)
               if (value.isNull())
                  ((DMWidget)obj).clickHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMClickHandler"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMWidget)obj).clickHandlers = arrayList;
               }
            // eventBits
            if ((value = structure.property("eventBits")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((DMWidget)obj).eventBits = (int)value.integer();
               }
            // id
            if ((value = structure.property("id")) != null)
               if (value.isNull())
                  ((DMWidget)obj).id = null;
               else
               {
                  ((DMWidget)obj).id = value.string();
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMHashNavigationPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMHashNavigationPanel((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMHashNavigationPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMFlowPanel", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // changeHandlers
            if ((value = structure.property("changeHandlers")) != null)
               if (value.isNull())
                  ((DMHashNavigationPanel)obj).changeHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("PageChangeHandler"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMHashNavigationPanel)obj).changeHandlers = arrayList;
               }
            // index
            if ((value = structure.property("index")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((DMHashNavigationPanel)obj).index = (int)value.integer();
               }
            // pages
            if ((value = structure.property("pages")) != null)
               if (value.isNull())
                  ((DMHashNavigationPanel)obj).pages = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  java.util.ArrayList arrayList = new java.util.ArrayList();       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        String refid = value.structure().getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(value.structure().getRuntimeClassName("DMWidget"));              
                           internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  ((DMHashNavigationPanel)obj).pages = arrayList;
               }
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMFlowPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMFlowPanel((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMFlowPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMComplexPanel", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMClickableFlowPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMClickableFlowPanel((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMClickableFlowPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMFlowPanel", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMComplexPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return null;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMComplexPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMWidget", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.DMImage", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return new bz.davide.dmweb.shared.DMImage((Void)null);
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.DMImage", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.DMWidget", obj, identities);
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
         }
      });

   }
}
