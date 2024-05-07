package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cuenta {

	private int numeroCuenta;
	private double saldo;
	private String tipoCuenta;
}
