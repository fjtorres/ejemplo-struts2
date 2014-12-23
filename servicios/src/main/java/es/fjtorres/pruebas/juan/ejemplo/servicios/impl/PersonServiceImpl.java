package es.fjtorres.pruebas.juan.ejemplo.servicios.impl;

import javax.inject.Inject;
import javax.inject.Named;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.Person;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.IPersistenceService;
import es.fjtorres.pruebas.juan.ejemplo.servicios.IPersonService;

@Named("personService")
public class PersonServiceImpl extends
      AbstractGenericModelService<Person, Long> implements IPersonService {

   @Inject
   public PersonServiceImpl(
         final IPersistenceService<Person, Long> pPersistenceService) {
      super(pPersistenceService, Person.class);
   }
}
