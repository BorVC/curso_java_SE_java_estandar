package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Cliente {
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
}
