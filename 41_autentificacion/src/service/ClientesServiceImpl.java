package service;

import dao.ClientesDao;
import dao.ClientesDaoFactory;
import model.Cliente;

public class ClientesServiceImpl implements ClientesService {
	
	ClientesDao clientesDao;
	//Contuctor para traer objeto clientesDao
	public ClientesServiceImpl() {
		clientesDao = ClientesDaoFactory.getClientesDao();
	}

	@Override
	public boolean autentificar(String usuario, String password) {
		Cliente cliente = clientesDao.findUsuario(usuario);
		return cliente!=null && cliente.getPassword().equals(password);
	}

	@Override
	public boolean nuevoCliente(Cliente cliente) {
		if(clientesDao.findUsuario(cliente.getUsuario()) != null) {
			return false;
		}
		clientesDao.saveCliente(cliente);
		return true;
	}

}
