package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Curso;
import model.Pais;

public class CursosService {
	String cadenaConexion = "jdbc:mysql://localhost:3306/agenda";
	String usuario="root";
	String password="root";
	String dir = "cursos.json";
	
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
		curso = mostrarInfo(curso.getIdCurso());
		if(existeCurso(curso.getIdCurso()) != null) {
			return false;
		}
		try(Connection con=DriverManager.getConnection(cadenaConexion,usuario,password);){
			//Consulta
			String sql = "INSERT INTO cursos (idCurso,curso,duracion,precio) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//Sustituir parámetros por valores
			ps.setInt(1, 0);
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	//Sacar cursos del json
	private Stream<Curso> getStreamPaises(){
		try {
			Gson gson = new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(dir), Curso[].class));//Stream<Pais>
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	public Curso mostrarInfo(int idCurso) {
		return getStreamPaises()
				.filter(p -> p.getIdCurso() != 0 &&  p.getIdCurso() != idCurso)
				.findFirst()
				.orElse(null);
			
		}
	}
	
	
	
	
	
	
}
