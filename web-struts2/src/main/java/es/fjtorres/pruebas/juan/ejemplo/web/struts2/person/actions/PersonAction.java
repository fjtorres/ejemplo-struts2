package es.fjtorres.pruebas.juan.ejemplo.web.struts2.person.actions;

import javax.inject.Inject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.Person;
import es.fjtorres.pruebas.juan.ejemplo.servicios.IPersonService;
import es.fjtorres.pruebas.juan.ejemplo.web.struts2.Messages;

/**
 * Action to display form and manage the operations about person entity.
 * 
 * @author fjtorres
 *
 */
@Component
public class PersonAction extends AbstractPersonAction {

   /**
    * UID.
    */
   private static final long serialVersionUID = -7958719738429905876L;

   /**
    * Indicates if the person is selected.
    */
   private boolean update;

   /**
    * Selected person id.
    */
   private Long selectedId;

   /**
    * Current person entity.
    */
   private Person model;

   @Inject
   public PersonAction(final IPersonService pPersonService) {
      super(pPersonService);
   }

   /**
    * Show creation form.
    * 
    * @return Result name.
    */
   @SkipValidation
   @Action(value = ACTION_CREATE, results = {
      @Result(name = SUCCESS, location = VIEW_FORM)
   })
   public String create() {
      setModel(new Person());
      return SUCCESS;
   }

   /**
    * Show update form and load model for the selected person.
    * 
    * @return Result name.
    */
   @SkipValidation
   @Action(value = ACTION_UPDATE, results = {
      @Result(name = SUCCESS, location = VIEW_FORM)
   })
   public String update() {
      if (selectedId == null) {
         addActionError(getText("error.not_element_selected"));
      } else {
         setUpdate(true);
         setModel(getPersonService().findById(getSelectedId()));
      }
      return SUCCESS;
   }

   /**
    * Save current model.
    * 
    * @return Result name.
    */
   @Validations(requiredStrings = {
         @RequiredStringValidator(
               fieldName = "model.firstName",
               key = Messages.VALIDATION_REQUIRED,
               messageParams = {
                  "getText('field.firstName')"
               }),
         @RequiredStringValidator(
               fieldName = "model.lastName",
               key = Messages.VALIDATION_REQUIRED,
               messageParams = {
                  "getText('field.lastName')"
               })
   }, requiredFields = {
      @RequiredFieldValidator(
            fieldName = "model.birthday",
            key = Messages.VALIDATION_REQUIRED,
            messageParams = {
               "getText('field.birthday')"
            })
   })
   @Action(value = ACTION_SAVE, results = {
         @Result(name = SUCCESS, type = ResultType.RA, params = {
               ResultType.RA_P_NAMESPACE, NAMESPACE,
               ResultType.RA_P_ACTIONNAME, ACTION_LIST
         }), @Result(name = INPUT, location = VIEW_FORM)
   })
   public String save() {
      if (isUpdate()) {
         getPersonService().update(getModel());
         addActionMessage(getText("msg.update.ok"));
      } else {
         getPersonService().persist(getModel());
         addActionMessage(getText("msg.create.ok"));
      }
      return SUCCESS;
   }

   public boolean isUpdate() {
      return update;
   }

   public void setUpdate(final boolean update) {
      this.update = update;
   }

   public Person getModel() {
      return model;
   }

   public void setModel(final Person model) {
      this.model = model;
   }

   public Long getSelectedId() {
      return selectedId;
   }

   public void setSelectedId(final Long selectedId) {
      this.selectedId = selectedId;
   }
}
