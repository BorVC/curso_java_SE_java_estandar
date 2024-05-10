package principal;

import recursos.Recurso;
import tareas.HiloConsumidor;
import tareas.HiloProductor;

public class Lanzador {

	public static void main(String[] args) {
		Recurso recurso=new Recurso();
		new Thread(new HiloProductor(recurso)).start();
		new Thread(new HiloConsumidor(recurso)).start();
		

	}

}
