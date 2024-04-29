package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.AgendaService;

class AgendaTest {

	@BeforeAll
	static void setUpBeforeClass()  {
		AgendaService service  = new AgendaService();
	}

	@Test
	void testNuevoContacto() {
		fail("Not yet implemented");
	}

	@Test
	void testEliminarContacto() {
		fail("Not yet implemented");
	}

	@Test
	void testBuscarContactoPorId() {
		fail("Not yet implemented");
	}

	@Test
	void testGetContactos() {
		fail("Not yet implemented");
	}

}
