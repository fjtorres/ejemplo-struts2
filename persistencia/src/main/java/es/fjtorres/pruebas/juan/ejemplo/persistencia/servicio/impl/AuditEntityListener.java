package es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.impl;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.AbstractModel;

/**
 * JPA Listener to check audit properties (creationDate and modificationDate).
 * 
 * @author fjtorres
 *
 * @param <T>
 *           Entity model type.
 */
public class AuditEntityListener<T extends AbstractModel> {

   /**
    * Set creationDate and modificationDate in model before persit event.
    * 
    * @param model
    *           Entity model instance.
    */
   @PrePersist
   public void prePersit(final T model) {
      if (model != null) {
         final Date currentDate = new Date();
         model.setCreationDate(currentDate);
         model.setModificationDate(currentDate);
      }
   }

   /**
    * Update modificationDate in model before update event.
    * 
    * @param model
    *           Entity model instance.
    */
   @PreUpdate
   public void preUpdate(final T model) {
      if (model != null) {
         model.setModificationDate(new Date());
      }
   }
}
