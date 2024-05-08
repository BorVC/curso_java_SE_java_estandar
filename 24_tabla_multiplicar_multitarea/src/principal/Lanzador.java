package principal;

import tareas.TareaTabla;

public class Lanzador {

	public static void main(String[] args) {
		new Thread(new TareaTabla(5)).start();
		new Thread(new TareaTabla(7)).start();
		new Thread(new TareaTabla(3)).start();
		
		var ob = new TareaTabla(2);
		var pb1 = new Thread(ob);
		pb1.start();

	}

}
