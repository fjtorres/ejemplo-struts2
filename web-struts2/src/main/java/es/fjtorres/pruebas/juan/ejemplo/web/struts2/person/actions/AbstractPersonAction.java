package es.fjtorres.pruebas.juan.ejemplo.web.struts2.person.actions;

import es.fjtorres.pruebas.juan.ejemplo.servicios.IPersonService;
import es.fjtorres.pruebas.juan.ejemplo.web.struts2.actions.AbstractAction;

public abstract class AbstractPersonAction extends AbstractAction {

   /**
	 * 
	 */
   private static final long serialVersionUID = 4999292977402226083L;

   public static final String ACTION_CREATE = "create";
   public static final String ACTION_LIST = "list";
   public static final String ACTION_SAVE = "save";
   public static final String ACTION_UPDATE = "update";

   public static final String NAMESPACE = "/person";

   public static final String VIEW_FORM = "form.jsp";
   public static final String VIEW_LIST = "list.jsp";

   private final IPersonService personService;

   public AbstractPersonAction(final IPersonService personService) {
      super();
      this.personService = personService;
   }

   public IPersonService getPersonService() {
      return personService;
   }
}
