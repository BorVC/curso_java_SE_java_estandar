package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.Contacto;

public class AgendaService1 {

	//Variables conexión
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario = "root";
	String password = "root";
	//Métod nuevo contacto
	public void nuevoContacto(Contacto contacto) {
		try (Connection conexion = ConexionBaseDeDatos.getConnection(cadenaConexion, usuario, password)){
			//Consulta preparada
			String sql = "INSERT INTO contactos (nombre,email,edad) VALUES (?,?,?)";
			PreparedStatement ps = conexion.prepareStatement(sql);
			//Sustituimos parámetros por valores
			ps.setString(1, contacto.getNombre());
			ps.setString(2, contacto.getEmail());
			ps.setInt(3, contacto.getEdad());
			ps.execute();//NO se manda otra vez la SQL
		} catch(SQLException ex) {
		    ex.printStackTrace();
		}
	}
	
	public boolean eliminarContacto(String email) {
		try (Connection conexion = ConexionBaseDeDatos.getConnection(cadenaConexion, usuario, password)) {
			//Consulta
			String sql = "DELETE FROM contactos WHERE email = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			//Sustituir parámetros por valores
			ps.setString(1, email);
			ps.execute();
			return ps.executeUpdate() > 0;
		} catch (SQLException ex) {
		    ex.printStackTrace();
		    return false;
		}
	}
	
	public boolean actualizarContacto(int edad,String email) {
		try (Connection conexion = ConexionBaseDeDatos.getConnection(cadenaConexion, usuario, password)){
			//Consulta
			String sql = "UPDATE contactos SET edad = ? WHERE email = ?";
			PreparedStatement ps = conexion.prepareStatement(sql);
			//Sustituir parámetros
			ps.setInt(1, edad);
			ps.setString(2, email);
			ps.execute();
			return ps.executeUpdate() > 0;
		} catch(SQLException ex) {
		    ex.printStackTrace();
		    return false;
	    }
	}
}
