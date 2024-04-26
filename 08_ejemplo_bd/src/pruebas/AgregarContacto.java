package pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarContacto {

	public static void main(String[] args) {
		/*String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
		String usuario = "root";
		String password = "root";
		
		//Creamos la conexión
		try(Connection con=DriverManager.getConnection(usuario, usuario, password)){
			//Ejecución consulta SQl
			String sql = "insert into contactos(nombre,email,edad) values ('contacto3','email3@gmail.com',44)";
			//Creamos el Statement
			Statement st = con.createStatement();
			st.execute(sql);
			System.out.println("Registro añadido");
		}catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		String cadenaConexion="jdbc:mysql://localhost:3306/agenda";
		String usuario="root";
		String password="root";
		String name="nombrex";
		String email="emailx@gmail.com";
		int edad=20;
		//Creamos la conexión y cierre al ser un try con recursos
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			/*
			//Ejecución consulta SQl
			String sql="insert into contactos(nombre,email,edad) values('"+name+"','"+email+"',"+edad+")";
			//Creamos el Statement
			Statement st=con.createStatement();
			st.execute(sql);
			*/
			//consultas preparadas
			String sql="insert into contactos(nombre,email,edad) values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			//sustituimos parámetros por valores
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, edad);
			ps.execute();//NO se manda otra vez la SQL
			System.out.println("Registro añadido!!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	

	}
	
}
