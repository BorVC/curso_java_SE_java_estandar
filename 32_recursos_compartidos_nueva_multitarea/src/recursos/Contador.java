package recursos;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
	private int valor;
	private Lock lock;
	public Contador() {
		lock=new ReentrantLock();
	}
	public  void incrementar() {
			lock.lock();
			int temp=valor;
			temp=temp+1;
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valor=temp;
			lock.unlock();
		
	}
	public int getValor() {
		return valor;
	}
}
