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
		// Comprobación de la pregunta 4
		//System.out.println("testGetInstance");
		
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
	@Test(expected = NotFreeInstanceException.class)
	public void testAcquireReusable() throws NotFreeInstanceException {
		// El objeto ReusablePool comienza con 2 objetos de clase Reusable
		ReusablePool rp = ReusablePool.getInstance();
		
		// Comprobación de la pregunta 4:
		// System.out.println("testAcquireReusable");
		
		// Obtenemos los dos elementos, no debería lanzar excepción
		try {
			Reusable r1 = rp.acquireReusable();
			assertNotNull(r1);
			r1.util();
			Reusable r2 = rp.acquireReusable();
			assertNotNull(r2);
			r2.util();
		} catch (Exception e) {
			fail();
		}

		// Comprobación de la pregunta 4:
		//System.out.println("Procedemos a contar los objetos: ");
		//int contador = 0;

		// Intentamos obtener elementos hasta cuando el pool se encuentre vacío.
		// Deberá lanzar la excepción NotFreeInstanceExcepcion.
		while(true)
		{
			// Comprobación de la pregunta 4:
			//contador = contador + 1;
			
			rp.acquireReusable();

			// Comprobación de la pregunta 4
			//System.out.println(contador);
			

		}
		


	}

	/**
	 * Test method for
	 * {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 * @throws DuplicatedInstanceException
	 */
	@Test(expected = DuplicatedInstanceException.class)
	public void testReleaseReusable() throws DuplicatedInstanceException {
		// Comprobación de la pregunta 4
		//System.out.println("testReleaseReusable");

		// El objeto ReusablePool comienza con 2 objetos de clase Reusable
		ReusablePool rp = ReusablePool.getInstance();
		Reusable r1 = new Reusable();
		r1.util();
		Reusable r2 = new Reusable();
		r2.util();
		Reusable r3 = new Reusable();
		r3.util();

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

		rp.releaseReusable(r1);

		


	}


}
