package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cuenta;

public class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idCuenta) {
		try (Connection con=LocatorConnection.getConnection();){
			String sql="select * from comunidades where codigo=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, codigo);			
			ResultSet rs=ps.executeQuery();
			return rs.next();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	}

	@Override
	public void updateSaldo(int idCuenta, double nuevoSaldo) {
		// TODO Auto-generated method stub

	}

}
