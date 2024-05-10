package tareas;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import recursos.Recurso;

public class HiloProductor implements Runnable {
	private Recurso recurso;
	private Lock lock;
	private Condition condicionLleno;
	private Condition condicionVacio;
	

	public HiloProductor(Recurso recurso, Lock lock, Condition condicionLleno, Condition condicionVacio) {
		super();
		this.recurso = recurso;
		this.lock = lock;
		this.condicionLleno = condicionLleno;
		this.condicionVacio = condicionVacio;
	}


	@Override
	public void run() {
		while(true) {
			int num=(int)(Math.random()*100+1);
			lock.lock();
			if(recurso.isLleno()) {
				try {
					System.out.println("Recurso lleno, esperando...");
					condicionLleno.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			recurso.guardar(num);
			System.out.println("Produciendo: "+num);
			condicionVacio.signal();
			lock.unlock();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
