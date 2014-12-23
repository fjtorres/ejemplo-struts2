package es.fjtorres.pruebas.juan.ejemplo.servicios.impl;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

import es.fjtorres.pruebas.juan.ejemplo.comun.PageWrapper;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.AbstractModel;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.IPersistenceService;
import es.fjtorres.pruebas.juan.ejemplo.servicios.IGenericModelService;

@Transactional(readOnly = true)
public abstract class AbstractGenericModelService<T extends AbstractModel, Id extends Serializable>
      implements IGenericModelService<T, Id> {

   private final IPersistenceService<T, Id> persistenceService;

   private final Class<T> persistenceClass;

   public AbstractGenericModelService(
         final IPersistenceService<T, Id> pPersistenceService,
         final Class<T> pPersistenceClass) {
      this.persistenceService = pPersistenceService;
      this.persistenceClass = pPersistenceClass;
   }

   public IPersistenceService<T, Id> getPersistenceService() {
      return persistenceService;
   }

   /**
    * @see IPersistenceService#persist(AbstractModel)
    */
   @Override
   @Transactional
   public void persist(final T entity) {
      getPersistenceService().persist(entity);
   }

   /**
    * @see IPersistenceService#update(AbstractModel)
    */
   @Override
   @Transactional
   public T update(final T entity) {
      return getPersistenceService().update(entity);
   }

   /**
    * @see IPersistenceService#delete(AbstractModel)
    */
   @Override
   @Transactional
   public void delete(final T entity) {
      getPersistenceService().delete(entity);
   }

   /**
    * @see IPersistenceService#findById(Serializable, Class)
    */
   @Override
   public T findById(final Id identifier) {
      return getPersistenceService().findById(identifier, persistenceClass);
   }

   @Override
   public PageWrapper<T> find(final PageWrapper<T> pWrapper) {
      pWrapper.setTotalResults(getPersistenceService().count(persistenceClass));
      final int startPosition = (pWrapper.getCurrentPage() - 1)
            * pWrapper.getPageSize();
      pWrapper.setItems(getPersistenceService().find(startPosition,
            pWrapper.getPageSize(), pWrapper.getSortField(),
            pWrapper.getSortDirection(), persistenceClass));

      return pWrapper;
   }
}
