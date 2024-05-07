package dao;

import java.util.List;

import model.Movimiento;

public interface MovimientosDao {
	void save(Movimiento movimiento);
	List<Movimiento> findByCuenta(int idCuenta);
}
