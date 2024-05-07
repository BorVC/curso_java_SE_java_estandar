package principal;

import utilidades.Conector;

public class Test {

	public static void main(String[] args) {
		Conector conector = new Conector.ConectorBuilder()
				.direccion("prueba")
				.estado(true)
				.protocolo("http")
				.build();

	}

}
