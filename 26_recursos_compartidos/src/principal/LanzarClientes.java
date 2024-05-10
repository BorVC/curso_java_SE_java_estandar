package principal;

import recursos.Contador;

public class LanzarClientes {

	public static void main(String[] args) {
		Contador cont=new Contador();
		//ejecutamos mil tareas cuya misión sea simplemente incrementar el contador
		for(int i=1;i<=1000;i++) {
			new Thread(()->cont.incrementar()).start();
		}
		//ponemos un retardo para esperar a que todas las tareas terminen
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//¿cuanto debería valer el contador?
		System.out.println(cont.getValor());
		

	}

}
