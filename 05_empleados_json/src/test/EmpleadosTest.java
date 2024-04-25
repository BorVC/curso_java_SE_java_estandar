package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import service.EmpleadosService;

class EmpleadosTest {

	static EmpleadosService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		service=new EmpleadosService();
	}

	@Test
	void testEmpleadosDepartamento() {
		assertEquals(2, service.empleadosDepartamento("RRHH").size());
	}

	@Test
	void testEmpleadoMayorSalario() {
		assertEquals("Javier", service.empleadoMayorSalario().getNombre());
	}

	@Test
	void testListaDepartamentos() {
		assertEquals(3, service.listaDepartamentos().size());
	}

}
