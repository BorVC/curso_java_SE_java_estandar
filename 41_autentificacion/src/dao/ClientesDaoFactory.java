package dao;

public class ClientesDaoFactory {
	
	public static ClientesDao getClientesDao() {
		return new ClientesDaoImpl();
	}
}
