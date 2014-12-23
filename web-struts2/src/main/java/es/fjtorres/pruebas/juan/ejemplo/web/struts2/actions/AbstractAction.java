package es.fjtorres.pruebas.juan.ejemplo.web.struts2.actions;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Base action with generic methods, constants, etc.
 * 
 * @author fjtorres
 *
 */
public abstract class AbstractAction extends ActionSupport {

   /**
    * UID.
    */
   private static final long serialVersionUID = 6888317877658087814L;

   /**
    * Result type constants.
    * 
    * @author fjtorres
    *
    */
   protected static class ResultType {

      /**
       * Result type "redirectAction".
       */
      public static final String RA = "redirectAction";

      /**
       * Parameter "namespace" for result type "redirectAction"
       */
      public static final String RA_P_NAMESPACE = "namespace";

      /**
       * Parameter "actionName" for result type "redirectAction"
       */
      public static final String RA_P_ACTIONNAME = "actionName";
   }

   public boolean isActiveMenu(final String option) {
      return ActionContext.getContext().getName().equals(option);
   }

   public boolean isActiveNamespace(final String namespace) {
      return ServletActionContext.getActionMapping().getNamespace().equals(
            namespace);
   }

}
