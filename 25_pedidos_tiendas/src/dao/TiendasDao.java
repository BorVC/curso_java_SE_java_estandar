package dao;

import java.util.List;

import model.Pedido;

public interface TiendasDao {
	List<Pedido> getPedidos(String ruta);
}
