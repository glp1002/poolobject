/**
 * @authors: Mario Hurtado Ubierna (mhu1001@alu.ubu.es)
 * 			 Gadea Lucas Pérez (glp1002@alu.ubu.es)
 * 
 * Descripción: Pila de pruebas para ReusablePool.java
 * Fecha: Curso 2022/23
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
// Importamos el objeto ReusablePool
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {

		// Obtenemos una instancia
		ReusablePool rp1 = ReusablePool.getInstance();
		// Comprobamos que la instancia no es nula
		assertNotNull(rp1);

		// Probamos a obtener otra instancia
		ReusablePool rp2 = ReusablePool.getInstance();
		// Comprobamos que la instancia no es nula
		assertNotNull(rp2);

		// Comprobamos que la instancia es la misma (Singleton)
		assertEquals(rp1, rp2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		// El objeto ReusablePool comienza con 2 objetos de clase Reusable
		ReusablePool rp = ReusablePool.getInstance();

		// Obtenemos los dos elementos, no debería lanzar excepción
		try {
			assertNotNull(rp.acquireReusable());
			assertNotNull(rp.acquireReusable());
		} catch (Exception e) {
			fail();
		}

		// Intentamos obtener otro elemento estando el pool vacío.
		// Deberá lanzar la excepción NotFreeInstanceExcepcion.
		try {
			rp.acquireReusable();
		} catch (Exception e) {
			assertEquals(e.getClass(), NotFreeInstanceException.class);
		}

	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
	
		// El objeto ReusablePool comienza con 2 objetos de clase Reusable
		ReusablePool rp = ReusablePool.getInstance();
		Reusable r1 = new Reusable();
		Reusable r2 = new Reusable();
		Reusable r3 = new Reusable();

		// Instroducimos dos reusables distintos, no debería lanzar excepción
		// NOTA: "rp" está vacío debido a la ejecución del test anterior
		try {
			rp.releaseReusable(r1);
			rp.releaseReusable(r2);
		} catch (Exception e) {
			fail();
		}

		// Intentamos meter otro reusable NO REPETIDO superando la capacidad del pool inicial
		try {
			rp.releaseReusable(r3);
		} catch (Exception e) {
			fail();
		}

		// Intentamos liberar una instancia de Reusable ya contenida en el ReusablePool.
		// Deberá lanzar la excepción DuplicatedInstanceException.
		try {
			rp.releaseReusable(r1);
		} catch (Exception e) {
			assertEquals(e.getClass(), DuplicatedInstanceException.class);
		}
		
		try {
			rp.releaseReusable(r2);
		} catch (Exception e) {
			assertEquals(e.getClass(), DuplicatedInstanceException.class);
		}

	}


}
