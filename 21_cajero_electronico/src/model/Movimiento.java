package model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movimiento {

	private int idMovimiento;
	private int idCuenta;
	private LocalDateTime  fecha;
	private double cantidad;
	private String operacion;
}
