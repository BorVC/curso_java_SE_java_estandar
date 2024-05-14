package service;

public class ClientesServiceFactory {
	
	public static ClientesService getClientesService() {
		return new ClientesServiceImpl();
	}

}
