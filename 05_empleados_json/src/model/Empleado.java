package model;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
public class Empleado {
	//@SerializedName(value = "nombre") 
	private String nombre;
	private String email;
	private double salario;
	private String departamento;
	
}
