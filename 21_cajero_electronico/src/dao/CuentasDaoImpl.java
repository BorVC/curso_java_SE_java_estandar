package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import locator.LocatorConnection;
import model.Cuenta;

class CuentasDaoImpl implements CuentasDao {

	@Override
	public Cuenta findById(int idCuenta) {
		try (Connection c = LocatorConnection.getConnection()) {
			String sql = """
					SELECT *
					FROM cuentas
					WHERE numeroCuenta = ?
					""";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, idCuenta);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipocuenta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null; 
	}

	@Override
	public void updateSaldo(int idCuenta, double nuevoSaldo) {
		try (Connection con=LocatorConnection.getConnection()){
			String sql="UPDATE cuentas SET saldo=? WHERE numeroCuenta=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setDouble(1, nuevoSaldo);
			ps.setInt(2, idCuenta);
			ps.execute();
		}catch(SQLException ex) {
			ex.printStackTrace();
		} 

	}

}
