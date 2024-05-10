package principal;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lanzador {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//lanzar dos tareas que se ejecuten concurrentemente. Una de ellas
		//calculará la suma de todos los números entre 1 y 100, y la otra calculará 
		//el factorial de un número cualquiera.
		//Cuando las tareas finalicen, el programa principal mostrará los resultados
		//mientras las tareas estén ejecución, el programa principal
		//estará haciendo otras cosas
		
		//tarea suma
		CompletableFuture<Integer> f1=CompletableFuture.supplyAsync(()->{
			int suma=0;
			for(int i=1;i<=100;i++) {
				suma+=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return suma;
		});
		//tarea factorial 6
		CompletableFuture<Integer> f2=CompletableFuture.supplyAsync(()->{
			int p=1;
			for(int i=1;i<=6;i++) {
				p*=i;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return p;
		});
		//el main sigue haciendo algo hasta que las tareas terminen,
		//momento en el que se mostrarán los resultados
		f1.whenCompleteAsync((r,e)->System.out.println("Suma de los números: "+r));
		f2.whenCompleteAsync((r,e)->System.out.println("Factorial de 6: "+r));
		for(int i=1;i<=100;i++) {
			System.out.println("El main haciendo cosas....");
			Thread.sleep(50);
		}
		
		
		
	}

}
