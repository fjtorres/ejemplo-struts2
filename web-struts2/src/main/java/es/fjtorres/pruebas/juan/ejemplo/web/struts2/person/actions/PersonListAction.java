package es.fjtorres.pruebas.juan.ejemplo.web.struts2.person.actions;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import es.fjtorres.pruebas.juan.ejemplo.comun.OrderBy;
import es.fjtorres.pruebas.juan.ejemplo.comun.PageWrapper;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.Person;
import es.fjtorres.pruebas.juan.ejemplo.servicios.IPersonService;

/**
 * Action to display the people list.
 * 
 * @author fjtorres
 *
 */
public class PersonListAction extends AbstractPersonAction {

   /**
    * UID.
    */
   private static final long serialVersionUID = -7071693734558770141L;

   private PageWrapper<Person> wrapper;

   @Inject
   public PersonListAction(final IPersonService pPersonService) {
      super(pPersonService);
   }

   /**
    * Load and show people list.
    * 
    * @return Result name.
    */
   @Action(value = ACTION_LIST, results = {
      @Result(name = SUCCESS, location = VIEW_LIST)
   })
   public String show() {

      final PageWrapper<Person> wrapper = new PageWrapper<>(1, 10, "firstName",
            OrderBy.ASC);
      setWrapper(getPersonService().find(wrapper));

      return SUCCESS;
   }

   public PageWrapper<Person> getWrapper() {
      return wrapper;
   }

   public void setWrapper(final PageWrapper<Person> wrapper) {
      this.wrapper = wrapper;
   }
}
