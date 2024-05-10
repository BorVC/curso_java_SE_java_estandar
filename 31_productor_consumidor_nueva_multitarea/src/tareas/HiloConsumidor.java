package tareas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import recursos.Recurso;

public class HiloConsumidor implements Runnable {
	private Recurso recurso;
	private Lock lock;
	private Condition condicionLleno;
	private Condition condicionVacio;
	
	public HiloConsumidor(Recurso recurso, Lock lock, Condition condicionLleno, Condition condicionVacio) {
		super();
		this.recurso = recurso;
		this.lock = lock;
		this.condicionLleno = condicionLleno;
		this.condicionVacio = condicionVacio;
	}

	@Override
	public void run() {
		while(true) {
			lock.lock();
			if(recurso.isVacio()) {
				try {
					System.out.println("Recurso vacío, esperando...");
					condicionVacio.await();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Consumiendo: "+recurso.sacar());
			condicionLleno.signal();
			lock.unlock();
			
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block 
				e.printStackTrace();
			}
		}

	}

}
