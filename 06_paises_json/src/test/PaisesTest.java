package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.PaisesService;

class PaisesTest {

	static PaisesService service;
	@BeforeAll
	static void setUpBeforeClass() {
		service = new PaisesService();
	}
	@Test
	void testListaContinentes() {
		assertEquals(7, service.listaContinentes().size());
	}

	@Test
	void testListaPaisPorContinente() {
		assertEquals(50, service.listaPaisPorContinente("Asia").size());
	}

	@Test
	void testPaisMasPoblado() {
		assertEquals("China", service.paisMasPoblado().getNombre());
	}

	/*@Test
	void testTablaPorContinente() {
		fail("Not yet implemented");
	}

	@Test
	void testTablaPaisesPorContinente() {
		fail("Not yet implemented");
	}*/

	@Test
	void testPaisPorCapital() {
		assertEquals("Afghanistan", service.paisPorCapital("Kabul").getNombre());
	}

}
