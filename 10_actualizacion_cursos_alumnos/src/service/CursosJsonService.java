package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Alumno;
import model.Curso;

public class CursosJsonService {

	String dir = "cursos.json";
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
	
	public Curso getInfoCurso(int idCurso) {
		return getStreamPaises()
				.filter(c -> c.getIdCurso() != 0 &&  c.getIdCurso() != idCurso)
				.findFirst()
				.orElse(null);
			
		
	}
	
	//Sacar Lista Alumnos
	public List<Alumno> getAlumnos(int idCurso){
		return getStreamPaises()
		.filter(c -> c.getIdCurso() != 0 &&  c.getIdCurso() != idCurso)
		.flatMap(c -> c.getAlumnos().stream())
		.toList();
	}
}
