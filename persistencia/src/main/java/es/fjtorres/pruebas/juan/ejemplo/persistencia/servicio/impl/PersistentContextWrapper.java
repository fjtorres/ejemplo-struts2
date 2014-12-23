package es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.impl;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class PersistentContextWrapper implements Serializable {

   private static final long serialVersionUID = 6397652464407649443L;

   @PersistenceContext
   private EntityManager entityManager;

   public EntityManager getEntityManager() {
      return entityManager;
   }

   public void setEntityManager(final EntityManager entityManager) {
      this.entityManager = entityManager;
   }
}
