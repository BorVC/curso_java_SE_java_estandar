package principal;

import tareas.TareaAscendente;
import tareas.TareaDescendente;

public class Lanzador {

	public static void main(String[] args) {
		//Se han de crear objetos de la clase de las tareas
		var t1=new TareaAscendente();
		var t2=new TareaDescendente();
		//Se crean objeos de la clase Thread pasando como parámetros los objetos de las clases de las tareas
		Thread ta=new Thread(t1);
		Thread td=new Thread(t2);
		//Poner en ejecución las tareas
		ta.start();
		td.start();

	}

}
