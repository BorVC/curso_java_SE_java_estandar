package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;

public class EmpleadosService {

	String dir = "empleados.json";
	private Stream<Empleado> getEmpleados(){
		try {
			Gson gson = new Gson();
			//gson.fromJson(new FileReader(dir), Empleado[].class) crea un Array
			//Pasar a un rray<Stream>
			return Arrays.stream(gson.fromJson(new FileReader(dir), Empleado[].class));//Array<Stream>
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Empleado> empleadosDepartamento(String departamento){
		return getEmpleados()//Stream<Empleado>
				.filter(e -> e.getDepartamento().equals(departamento))//Stream<Empleado>
				.toList();
	}
	
	public Empleado empleadoMayorSalario() {
		return getEmpleados()
				.max(Comparator.comparingDouble(e -> e.getSalario()))
				.orElse(null);
	}
	
	public List<String> listaDepartamentos(){
		return getEmpleados()
				.map(e -> e.getDepartamento())//Stream<String>
				.distinct()
				.toList();
	}
}
