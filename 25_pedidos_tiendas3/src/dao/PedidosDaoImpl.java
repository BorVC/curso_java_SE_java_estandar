package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Pedido;

public class PedidosDaoImpl implements PedidosDao {

	@Override
	public void save(Pedido pedido) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="insert into pedidos(producto,tienda,fechaPedido,precio) values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, pedido.getProducto());
			
			ps.setString(2, pedido.getTienda());
			ps.setDate(3, Date.valueOf(pedido.getFechaPedido()));
			ps.setDouble(4, pedido.getPrecio());
			ps.execute();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
