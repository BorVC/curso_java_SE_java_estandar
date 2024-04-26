package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {

	public static Connection getConnection(String url,String usuario,String password) {
		Connection conexion = null;
		if(conexion == null) {
			try {
				conexion = DriverManager.getConnection(url, usuario, password);
				System.out.println("Conexióin establecida con BD");
			} catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Ha habido un error de conexión con la BD");
			}
		}
		return conexion;
	}
}
