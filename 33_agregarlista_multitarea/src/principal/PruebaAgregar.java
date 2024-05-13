package principal;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PruebaAgregar {

	public static void main(String[] args) throws InterruptedException {
		//No es thread-safe (thread segura) no se cumpliran todas las peticiones
		//ArrayList<Integer> lista = new ArrayList<Integer>();
		//Es thread segura
		CopyOnWriteArrayList<Integer> lista = new CopyOnWriteArrayList<Integer>();
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 1; i <= 100000;i++) {
			executor.submit(()-> lista.add((int)(Math.random()*500+1)));
		}
		
		Thread.sleep(10000);
		System.out.println("Tamaño de la lista " + lista.size());

	}

}
