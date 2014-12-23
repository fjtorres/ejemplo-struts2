package es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio;

import java.io.Serializable;
import java.util.List;

import es.fjtorres.pruebas.juan.ejemplo.comun.OrderBy;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.AbstractModel;

public interface IPersistenceService<T extends AbstractModel, Id extends Serializable> {

   /**
    * Persist entity.
    * 
    * @param pEntity
    *           Entity instance to persist.
    * @throws NullPointerException
    *            If entity is null.
    */
   void persist(T pEntity) throws NullPointerException;

   /**
    * Merge entity.
    * 
    * @param pEntity
    *           Entity instance to merge.
    * @return Merged instance.
    * @throws NullPointerException
    *            If entity is null or entity id is null.
    */
   T update(T pEntity) throws NullPointerException;

   /**
    * Delete entity.
    * 
    * @param pEntity
    *           Entity instance to delete.
    * @throws NullPointerException
    *            If entity is null or entity id is null.
    */
   void delete(T pEntity) throws NullPointerException;

   /**
    * Delete entity by id.
    * 
    * @param pId
    *           Entity identifier to delete.
    * @param pPersistenceClass
    *           Entity class.
    * @throws NullPointerException
    *            If id is null or persistence class is null.
    */
   void delete(Id pId, Class<T> pPersistenceClass) throws NullPointerException;

   /**
    * Find entity by identifier.
    * 
    * @param pId
    *           Entity identifier for search.
    * @param pPersistenceClass
    *           Entity class.
    * @return Entity with the given identifier.
    * @throws NullPointerException
    *            If id is null or persistence class is null.
    *
    */
   T findById(Id pId, Class<T> pPersistenceClass) throws NullPointerException;

   Long count(final Class<T> pPersistenceClass);

   List<T> find(int startPosition, int maxResults, String sortField,
         OrderBy sortDirection, Class<T> pPersistenceClass);
}
