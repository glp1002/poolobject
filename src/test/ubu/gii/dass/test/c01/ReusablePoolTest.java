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

		//Obtenemos una instancia
		ReusablePool rp1 = ReusablePool.getInstance();
		// Comprobamos que la instancia no es nula
		assertNotEquals(null, rp1);

		// Probamos a obtener otra instancia
		ReusablePool rp2 = ReusablePool.getInstance();
		// Comprobamos que la instancia no es nula
		assertNotEquals(null, rp2);
		// Comprobamos que la instancia es la misma (Singleton)
		assertEquals(rp1, rp2);
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}
