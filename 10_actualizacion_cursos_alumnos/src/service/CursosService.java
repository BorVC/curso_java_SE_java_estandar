package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import service.CursosJsonService;

import model.Curso;

public class CursosService {
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	CursosJsonService cjs = new CursosJsonService();
	
	
	//Buscar curso existe 
	private Curso existeCurso(int idCurso) {
		try(Connection con = DriverManager.getConnection(cadenaConexion, usuario, password);){
			String sql = "SELECT * FROM cursos WHERE idCurso = ? ";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				return new Curso (rs.getInt("idCurso"),
						rs.getString("curso"),
						rs.getInt("duracion"),
						rs.getDouble("precio"),
						null);
			}
			return null;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	//Guardar curso
	public boolean nuevoCurso(Curso curso) {
		curso = cjs.getInfoCurso(curso.getIdCurso());
		if(existeCurso(curso.getIdCurso()) != null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			//Consulta
			String sql = "INSERT INTO cursos (idCurso,curso,duracion,precio) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//Sustituir parámetros por valores
			ps.setInt(1, curso.getIdCurso());
			ps.setString(2, curso.getCurso());
			ps.setInt(3, curso.getDuracion());
			ps.setDouble(4, curso.getPrecio());
			ps.execute();
			return true;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

	
	
}
