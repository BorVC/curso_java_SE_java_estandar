package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import model.Pais;
import service.PaisesServiceFactory;

public class TableModelPaisesImpl extends AbstractTableModel {
	List<Pais> paises;
	//Constructor
	public TableModelPaisesImpl(String continente) {
		var paisesService=PaisesServiceFactory.getPaisesService();
		paises=paisesService.getPaisesFiltradosPor(continente);
	}
	@Override
	public int getRowCount() {
		return paises.size();
	}
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0->"Nombre";
			case 1->"Continente";
			case 2->"Capital";
			case 3->"Población";
			default->"";
		};
	}
	@Override
	public Object getValueAt(int row, int column) {
		return switch(column) {
			case 0->paises.get(row).getNombre();
			case 1->paises.get(row).getContinente();
			case 2->paises.get(row).getCapital();
			case 3->paises.get(row).getPoblacion();
			default->"";
		};
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return switch(columnIndex) {
			case 0->String.class;
			case 1->String.class;
			case 2->String.class;
			case 3->Long.class;
			default->String.class;
		};
	}
	
}
