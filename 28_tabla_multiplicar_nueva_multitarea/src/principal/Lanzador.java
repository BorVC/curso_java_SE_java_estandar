package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tareas.TareaTabla;

public class Lanzador {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new TareaTabla(5));
		executor.submit(new TareaTabla(7));
		executor.submit(new TareaTabla(3));

		executor.shutdown();

	}

}
