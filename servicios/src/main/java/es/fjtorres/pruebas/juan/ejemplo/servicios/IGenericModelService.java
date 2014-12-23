package es.fjtorres.pruebas.juan.ejemplo.servicios;

import java.io.Serializable;

import es.fjtorres.pruebas.juan.ejemplo.comun.PageWrapper;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.AbstractModel;

public interface IGenericModelService<T extends AbstractModel, Id extends Serializable> {

   void persist(T entity);

   T update(T entity);

   void delete(T entity);

   T findById(Id identifier);

   PageWrapper<T> find(PageWrapper<T> wrapper);
}
