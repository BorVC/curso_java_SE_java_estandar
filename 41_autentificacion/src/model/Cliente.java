package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Cliente {
	private int idCliente;
	private String usuario;
	private String password;
	private String email;
	private int telefono;
}
