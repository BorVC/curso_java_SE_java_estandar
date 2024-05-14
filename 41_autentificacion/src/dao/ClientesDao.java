package dao;

import model.Cliente;

public interface ClientesDao {
	Cliente findUsuario(String usuario);
	void saveCliente(Cliente cliente);
	
}
