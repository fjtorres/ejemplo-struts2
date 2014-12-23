package es.fjtorres.pruebas.juan.ejemplo.servicios.impl;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotEquals;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.Person;
import es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.IPersistenceService;

public class PersonServiceImplTest {

	@Mock
	private IPersistenceService<Person, Long> mockPersistenceService;

	private PersonServiceImpl instance;

	@BeforeMethod
	public void before() {
		MockitoAnnotations.initMocks(this);
		instance = new PersonServiceImpl(mockPersistenceService);
	}

	@AfterMethod
	public void after() {
		validateMockitoUsage();
	}

	@Test
	public void persistTest() {
		instance.persist(new Person());
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void persistNullEntityTest() {
		doThrow(new NullPointerException()).when(mockPersistenceService)
				.persist(null);
		instance.persist(null);
	}

	@Test
	public void updateTest() {
		final Person entity = new Person();
		entity.setId(0L);
		when(mockPersistenceService.update(entity)).thenReturn(entity);
		final Person resultEntity = instance.update(entity);
		assertNotEquals(resultEntity, entity);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void updateNullEntityTest() {
		doThrow(new NullPointerException()).when(mockPersistenceService)
				.update(null);
		instance.update(null);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void updateEntityWithoutIdTest() {
		final Person entity = new Person();
		doThrow(new NullPointerException()).when(mockPersistenceService)
				.update(entity);
		instance.update(entity);
	}

	@Test
	public void deleteTest() {
		final Person entity = new Person();
		entity.setId(0L);
		instance.delete(entity);
	}

	@Test
	public void findByIdTest() {
		final Person mockResult = new Person();
		mockResult.setId(0L);
		mockResult.setFirstName("TEST");
		when(mockPersistenceService.findById(0L, Person.class)).thenReturn(
				mockResult);
		final Person result = instance.findById(0L);
		assertNotEquals(result, mockResult);
	}
}
