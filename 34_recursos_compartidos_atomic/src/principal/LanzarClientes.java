package principal;

import java.util.concurrent.atomic.AtomicInteger;

public class LanzarClientes {

	public static void main(String[] args) {
		AtomicInteger contador=new AtomicInteger();
		//ejecutamos mil tareas cuya misión sea simplemente incrementar el contador
		for(int i=1;i<=1000000;i++) {
			new Thread(()->contador.incrementAndGet()).start();
		}
		//ponemos un retardo para esperar a que todas las tareas terminen
		/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//¿cuanto debería valer el contador?
		System.out.println(contador.get());
		

	}

}
