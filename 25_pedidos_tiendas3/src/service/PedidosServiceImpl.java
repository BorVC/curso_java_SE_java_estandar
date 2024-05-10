package service;

import java.util.List;

import dao.DaoFactory;
import dao.TiendasDao;
import dao.PedidosDao;
import model.Pedido;

public class PedidosServiceImpl implements PedidosService {

	
	private List<Pedido> pedidosTienda(String ruta, String tienda) {
		TiendasDao fDao=DaoFactory.getFicheroPedidosDao();
		List<Pedido> pedidosFichero=fDao.getPedidos(ruta);
		//recorremos los pedidos que llegan del fichero y les asignamos 
		//tienda
		pedidosFichero.forEach(p->p.setTienda(tienda));
		return pedidosFichero;
	
	}

	
	private void guardarPedidos(List<Pedido> pedidos) {
		PedidosDao pDao=DaoFactory.getPedidosDao();
		//recorremos lista de pedidos y los guardamos
		pedidos.forEach(p->pDao.save(p));

	}

	@Override
	public void procesarPedidos(String ruta, String tienda) {
		guardarPedidos(pedidosTienda(ruta,tienda));
		
	}

	
}
