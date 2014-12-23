package es.fjtorres.pruebas.juan.ejemplo.persistencia.servicio.impl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertNotEquals;

import javax.persistence.EntityManager;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.fjtorres.pruebas.juan.ejemplo.persistencia.modelo.Person;

public class JpaPersistenceServiceImplTest {

	@Mock
	private EntityManager mockEntityManager;

	@Mock
	private PersistentContextWrapper mockContextWrapper;

	private JpaPersistenceServiceImpl<Person, Long> instance;

	@BeforeMethod
	public void before() {
		MockitoAnnotations.initMocks(this);
		when(mockContextWrapper.getEntityManager()).thenReturn(
				mockEntityManager);

		instance = new JpaPersistenceServiceImpl<>(mockContextWrapper);
	}

	@Test
	public void persistTest() {
		instance.persist(new Person());
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void persistNullEntityTest() {
		instance.persist(null);
	}

	@Test
	public void updateTest() {
		final Person entity = new Person();
		entity.setId(0L);
		when(mockEntityManager.merge(any())).thenReturn(entity);
		final Person resultEntity = instance.update(entity);
		assertNotEquals(resultEntity, entity);
		validateMockitoUsage();
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void updateNullEntityTest() {
		instance.update(null);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void updateEntityWithoutIdTest() {
		instance.update(new Person());
	}

	@Test
	public void deleteTest() {
		final Person entity = new Person();
		entity.setId(0L);
		instance.delete(entity);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void deleteNullEntityTest() {
		instance.delete(null);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void deleteEntityWithoutIdTest() {
		instance.delete(new Person());
	}

	@Test
	public void deleteByIdTest() {
		instance.delete(0L, Person.class);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void deleteByIdWithNullIdTest() {
		instance.delete(null, Person.class);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void deleteByIdWithNullPersistentClassTest() {
		instance.delete(0L, null);
	}

	@Test
	public void findByIdTest() {
		final Person mockEntity = new Person();
		when(mockEntityManager.find(Person.class, 0L)).thenReturn(mockEntity);
		final Person resultEntity = instance.findById(0L, Person.class);
		assertNotEquals(resultEntity, mockEntity);
		validateMockitoUsage();
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void findByIdWithNullIdTest() {
		instance.findById(null, Person.class);
	}

	@Test(expectedExceptions = { NullPointerException.class })
	public void findByIdWithNullPersistentClassTest() {
		instance.findById(0L, null);
	}
}
