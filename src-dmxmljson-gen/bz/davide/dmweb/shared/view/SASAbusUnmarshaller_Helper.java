/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package bz.davide.dmweb.shared.view;


public class SASAbusUnmarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.map.SASAbusUnmarshaller_Helper
{
   protected SASAbusUnmarshaller_Helper()
   {
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DMWidgetSerializationData", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DMWidgetSerializationData>() {
         @Override public void check(bz.davide.dmweb.shared.view.DMWidgetSerializationData  ret){
            // attachHandlers
            if (ret.attachHandlers != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMWidgetSerializationData.attachHandlers");
            // domReady
            if (ret.domReady != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMWidgetSerializationData.domReady");
            // idseq
            if (ret.idseq != 0)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMWidgetSerializationData.idseq");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DMWidgetSerializationData", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DMWidgetSerializationData ret = new bz.davide.dmweb.shared.view.DMWidgetSerializationData();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DMWidgetSerializationData", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // attachHandlers
            if ((value = structure.property("attachHandlers")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).attachHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("AttachListener"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).attachHandlers = arrayList;
               }
            // domReady
            if ((value = structure.property("domReady")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).domReady = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("AttachListener"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).domReady = arrayList;
               }
            // idseq
            if ((value = structure.property("idseq")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).idseq = (int)value.integer();
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler>() {
         @Override public void check(bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler  ret){
            // widget
            if (ret.widget != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler.widget");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler ret = new bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // widget
            if ((value = structure.property("widget")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler)obj).widget = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler)obj).widget = (bz.davide.dmweb.shared.view.AbstractHtmlElementView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("AbstractHtmlElementView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler)obj).widget = (bz.davide.dmweb.shared.view.AbstractHtmlElementView)o;
                  }
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler>() {
         @Override public void check(bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler  ret){
            // factory
            if (ret.factory != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler.factory");
            // widget
            if (ret.widget != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler.widget");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler ret = new bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // factory
            if ((value = structure.property("factory")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).factory = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).factory = (bz.davide.dmweb.shared.view.DMGwtWidgetHostFactory)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMGwtWidgetHostFactory"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).factory = (bz.davide.dmweb.shared.view.DMGwtWidgetHostFactory)o;
                  }
               }
            // widget
            if ((value = structure.property("widget")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).widget = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).widget = (bz.davide.dmweb.shared.view.AbstractHtmlElementView)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("AbstractHtmlElementView"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).widget = (bz.davide.dmweb.shared.view.AbstractHtmlElementView)o;
                  }
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.SpanView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.SpanView>() {
         @Override public void check(bz.davide.dmweb.shared.view.SpanView  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.SpanView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.SpanView ret = new bz.davide.dmweb.shared.view.SpanView();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.SpanView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.AnchorView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.AnchorView>() {
         @Override public void check(bz.davide.dmweb.shared.view.AnchorView  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.AnchorView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.AnchorView ret = new bz.davide.dmweb.shared.view.AnchorView();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.AnchorView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.ButtonView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.ButtonView>() {
         @Override public void check(bz.davide.dmweb.shared.view.ButtonView  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.ButtonView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.ButtonView ret = new bz.davide.dmweb.shared.view.ButtonView();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.ButtonView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler>() {
         @Override public void check(bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler  ret){
            // navigationPanel
            if (ret.navigationPanel != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler.navigationPanel");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler ret = new bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // navigationPanel
            if ((value = structure.property("navigationPanel")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler)obj).navigationPanel = null;
               else
               {
                  String refid = value.structure().getRefId();    
                  if (refid != null)                              
                     ((bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)identities.get(refid);
                  else {
                     Object o = newInstance(value.structure().getRuntimeClassName("DMHashNavigationPanel"));              
                     internalUnmarschall(value.structure(), o.getClass().getName(), o, identities); 
                     ((bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler)obj).navigationPanel = (bz.davide.dmweb.shared.view.DMHashNavigationPanel)o;
                  }
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.AbstractHtmlElementView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.AbstractHtmlElementView>() {
         @Override public void check(bz.davide.dmweb.shared.view.AbstractHtmlElementView  ret){
            // attachHandlers
            if (ret.attachHandlers != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.AbstractHtmlElementView.attachHandlers");
            // childs
            if (ret.childs != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.AbstractHtmlElementView.childs");
            // clickHandlers
            if (ret.clickHandlers != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.AbstractHtmlElementView.clickHandlers");
            // eventBits
            if (ret.eventBits != 0)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.AbstractHtmlElementView.eventBits");
            // id
            if (ret.id != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.AbstractHtmlElementView.id");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.AbstractHtmlElementView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            return null;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.AbstractHtmlElementView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // attachHandlers
            if ((value = structure.property("attachHandlers")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).attachHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("AttachListener"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).attachHandlers = arrayList;
               }
            // childs
            if ((value = structure.property("childs")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).childs = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("Node"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).childs = arrayList;
               }
            // clickHandlers
            if ((value = structure.property("clickHandlers")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).clickHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("DMClickHandler"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).clickHandlers = arrayList;
               }
            // eventBits
            if ((value = structure.property("eventBits")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).eventBits = (int)value.integer();
               }
            // id
            if ((value = structure.property("id")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).id = null;
               else
               {
                  ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).id = value.string();
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DMHashNavigationPanel", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DMHashNavigationPanel>() {
         @Override public void check(bz.davide.dmweb.shared.view.DMHashNavigationPanel  ret){
            // changeHandlers
            if (ret.changeHandlers != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMHashNavigationPanel.changeHandlers");
            // index
            if (ret.index != 0)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMHashNavigationPanel.index");
            // pages
            if (ret.pages != null)
               throw new RuntimeException("The constructor initialized the field bz.davide.dmweb.shared.view.DMHashNavigationPanel.pages");
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DMHashNavigationPanel", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DMHashNavigationPanel ret = new bz.davide.dmweb.shared.view.DMHashNavigationPanel();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DMHashNavigationPanel", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.DivView", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            // changeHandlers
            if ((value = structure.property("changeHandlers")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).changeHandlers = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("PageChangeHandler"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).changeHandlers = arrayList;
               }
            // index
            if ((value = structure.property("index")) != null)
               if (value.isNull())
                  new RuntimeException("Impossibile value for primitive type");
               else
               {
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).index = (int)value.integer();
               }
            // pages
            if ((value = structure.property("pages")) != null)
               if (value.isNull())
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).pages = null;
               else
               {
                  bz.davide.dmxmljson.unmarshalling.Array arr = value.array();        
                  arr.open();        
                  java.util.ArrayList arrayList = new java.util.ArrayList(arr.length());       
                  while ((value = arr.nextItem()) != null) {                       
                     if (value.isNull())                                           
                        arrayList.add(null);                                       
                     else                                                          
                     {                                                                   
                        bz.davide.dmxmljson.unmarshalling.Structure tmpStructure = value.structure();
                        String refid = tmpStructure.getRefId();    
                        if (refid != null)                              
                           arrayList.add(identities.get(refid));                                                
                        else {
                           Object o = newInstance(tmpStructure.getRuntimeClassName("DivViewChildElement"));              
                           internalUnmarschall(tmpStructure, o.getClass().getName(), o, identities); 
                           arrayList.add(o);                                                
                        }
                     }                                                                   
                  }                                                                   
                  arr.close();        
                  ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).pages = arrayList;
               }
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.DivView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.DivView>() {
         @Override public void check(bz.davide.dmweb.shared.view.DivView  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.DivView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.DivView ret = new bz.davide.dmweb.shared.view.DivView();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.DivView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", obj, identities);
            structure.open();
            String id = structure.getId();
            if (id != null)
               identities.put(id, obj);
            bz.davide.dmxmljson.unmarshalling.Value value;
            structure.close();
         }
      });
      this.emptyObjectCheck.put("bz.davide.dmweb.shared.view.ImgView", new bz.davide.dmxmljson.unmarshalling.EmptyFieldChecker<bz.davide.dmweb.shared.view.ImgView>() {
         @Override public void check(bz.davide.dmweb.shared.view.ImgView  ret){
         }
      });
      this.putInstanceFactory("bz.davide.dmweb.shared.view.ImgView", new bz.davide.dmxmljson.unmarshalling.InstanceFactory() {
         @Override public Object newInstance() throws Exception {
            bz.davide.dmweb.shared.view.ImgView ret = new bz.davide.dmweb.shared.view.ImgView();
            return ret;
         }
      });

      this.putClassUnmarshaller("bz.davide.dmweb.shared.view.ImgView", new bz.davide.dmxmljson.unmarshalling.ClassUnmarshaller() {
         @Override public void unmarshall(bz.davide.dmxmljson.unmarshalling.Structure structure, Object obj, java.util.HashMap<String, Object> identities) throws Exception {
            internalUnmarschall(structure, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", obj, identities);
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
