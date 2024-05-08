package dao;

public class DaoFactory {
	public static TiendasDao getFicheroPedidosDao() {
		return new TiendasDaoImpl();
	}
	
	public static PedidosDao getPedidosDao() {
		return new PedidosDaoImpl();
	}
}
