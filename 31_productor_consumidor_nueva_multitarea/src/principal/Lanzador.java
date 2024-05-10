package principal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import recursos.Recurso;
import tareas.HiloConsumidor;
import tareas.HiloProductor;

public class Lanzador {

	public static void main(String[] args) {
		Recurso recurso=new Recurso();
		Lock lock=new ReentrantLock();
		Condition condicionLleno=lock.newCondition();
		Condition condicionVacio=lock.newCondition();
		ExecutorService executor=Executors.newCachedThreadPool();
		executor.submit(new HiloProductor(recurso,lock,condicionLleno,condicionVacio));
		executor.submit(new HiloConsumidor(recurso,lock,condicionLleno,condicionVacio));
		

	}

}
