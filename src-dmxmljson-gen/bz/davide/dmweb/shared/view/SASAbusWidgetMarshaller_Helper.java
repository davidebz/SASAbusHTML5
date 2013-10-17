/*********************************************************************************
 *                                                                               *
 * WARNING: File automatically generated by DMXmlJson. DON'T CHANGE IT manually! *
 *                                                                               *
 *********************************************************************************/

package bz.davide.dmweb.shared.view;


public class SASAbusWidgetMarshaller_Helper extends it.bz.tis.sasabus.html5.shared.ui.map.SASAbusWidgetMarshaller_Helper
{
   protected SASAbusWidgetMarshaller_Helper()
   {
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMWidgetSerializationData", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // attachHandlers
            value = ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).attachHandlers;
            if (value == null)
               structure.property("attachHandlers").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("attachHandlers").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.AttachListener", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // domReady
            value = ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).domReady;
            if (value == null)
               structure.property("domReady").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("domReady").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.AttachListener", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // i18n
            value = ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).i18n;
            if (value == null)
               structure.property("i18n").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.i18n.I18NData", structure.property("i18n").structure(), identities, seq, false);
            }
            // idseq
            value = ((bz.davide.dmweb.shared.view.DMWidgetSerializationData)obj).idseq;
            if (value == null)
               structure.property("idseq").nullValue();
            else
            {
                    structure.property("idseq").integer((Integer)value);                          
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // widget
            value = ((bz.davide.dmweb.shared.view.DMWidgetEventAttachHandler)obj).widget;
            if (value == null)
               structure.property("widget").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.AbstractHtmlElementView", structure.property("widget").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // factory
            value = ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).factory;
            if (value == null)
               structure.property("factory").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.DMGwtWidgetHostFactory", structure.property("factory").structure(), identities, seq, false);
            }
            // widget
            value = ((bz.davide.dmweb.shared.view.DMGwtWidgetHostAttachHandler)obj).widget;
            if (value == null)
               structure.property("widget").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.AbstractHtmlElementView", structure.property("widget").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.SpanView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.AnchorView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.ButtonView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // navigationPanel
            value = ((bz.davide.dmweb.shared.view.DMHashNavigationPanelAttachHandler)obj).navigationPanel;
            if (value == null)
               structure.property("navigationPanel").nullValue();
            else
            {
                     internalMarschall(value, value.getClass().getName(),"bz.davide.dmweb.shared.view.DMHashNavigationPanel", structure.property("navigationPanel").structure(), identities, seq, false);
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.AbstractHtmlElementView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            Object value;
            // attachHandlers
            value = ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).attachHandlers;
            if (value == null)
               structure.property("attachHandlers").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("attachHandlers").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.AttachListener", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // childs
            value = ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).childs;
            if (value == null)
               structure.property("childs").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("childs").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.AbstractHtmlElementView", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // clickHandlers
            value = ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).clickHandlers;
            if (value == null)
               structure.property("clickHandlers").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("clickHandlers").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.DMClickHandler", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // eventBits
            value = ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).eventBits;
            if (value == null)
               structure.property("eventBits").nullValue();
            else
            {
                    structure.property("eventBits").integer((Integer)value);                          
            }
            // id
            value = ((bz.davide.dmweb.shared.view.AbstractHtmlElementView)obj).id;
            if (value == null)
               structure.property("id").nullValue();
            else
            {
                    structure.property("id").string((String)value);                          
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMHashNavigationPanel", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.DivView", "N/A",structure, identities, seq, true);
            Object value;
            // changeHandlers
            value = ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).changeHandlers;
            if (value == null)
               structure.property("changeHandlers").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("changeHandlers").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.PageChangeHandler", array.item().structure(), identities, seq, false);
               }                                                              
            }
            // index
            value = ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).index;
            if (value == null)
               structure.property("index").nullValue();
            else
            {
                    structure.property("index").integer((Integer)value);                          
            }
            // pages
            value = ((bz.davide.dmweb.shared.view.DMHashNavigationPanel)obj).pages;
            if (value == null)
               structure.property("pages").nullValue();
            else
            {
               java.util.ArrayList arrayList = (java.util.ArrayList)value;                        
               bz.davide.dmxmljson.marshalling.Array array = structure.property("pages").array();        
               for (Object o: arrayList) {                                    
                  if (o == null)                                              
                     array.item().nullValue();                                
                  else                                                        
                     internalMarschall(o, o.getClass().getName(), "bz.davide.dmweb.shared.view.AbstractHtmlElementView", array.item().structure(), identities, seq, false);
               }                                                              
            }
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DivView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.DMHTML", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });
      this.putClassMarshaller("bz.davide.dmweb.shared.view.ImgView", new bz.davide.dmxmljson.marshalling.ClassMarshaller() {
         @Override public void marshall(Object obj, String compileTimeClassName, bz.davide.dmxmljson.marshalling.Structure structure, java.util.IdentityHashMap<Object, bz.davide.dmxmljson.marshalling.Structure> identities, long[] seq, boolean superClass) throws Exception {
            if (!superClass) {
               if (isReference(structure, obj, identities, seq))
                  return;
               identities.put(obj, structure);
               structure.open(shortName(compileTimeClassName), shortName(obj.getClass().getName()), null);
            }
            internalMarschall(obj, "bz.davide.dmweb.shared.view.AbstractHtmlElementView", "N/A",structure, identities, seq, true);
            Object value;
            if (!superClass)
               structure.close();
         }
      });

   }
}
