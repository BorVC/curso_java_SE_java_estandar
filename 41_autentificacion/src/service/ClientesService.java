package service;

import model.Cliente;

public interface ClientesService {
	boolean autentificar(String usuario,String password);
	boolean nuevoCliente(Cliente Cliente);
}
