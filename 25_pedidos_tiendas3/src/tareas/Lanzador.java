package tareas;

import java.io.IOException;
import java.util.List;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class Lanzador {
	static String ruta1="c:\\temp\\pedidos\\tienda1.json";
	static String ruta2="c:\\temp\\pedidos\\tienda2.json";
	static String ruta3="c:\\temp\\pedidos\\tienda3.json";
	public static void main(String[] args) throws IOException {
		
		PedidosService service=PedidosServiceFactory.getPedidosService();
		new Thread(()->service.procesarPedidos(ruta1, "tienda1")).start();
		new Thread(()->service.procesarPedidos(ruta2, "tienda2")).start();
		new Thread(()->service.procesarPedidos(ruta3, "tienda3")).start();
		/*new Thread(new TareaPedido(ruta1,"tienda1")).start();
		new Thread(new TareaPedido(ruta2,"tienda2")).start();
		new Thread(new TareaPedido(ruta3,"tienda3")).start();*/
		System.out.println("Pedidos enviados. Pulse tecla para continuar");
		System.in.read();
	}

}
/*class TareaPedido implements Runnable{
	private String ruta;
	private String tienda;
	
	public TareaPedido(String ruta, String tienda) {
		super();
		this.ruta = ruta;
		this.tienda = tienda;
	}

	@Override
	public void run() {
		PedidosService service=PedidosServiceFactory.getPedidosService();
		service.guardarPedidos(service.pedidosTienda(ruta, tienda));		
	}
	
}*/
