package adaptadores;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Municipio;
import model.Provincia;
import service.DatosProvinciasServiceFactory;

public class TablemodelMunicipiosImpl extends AbstractTableModel {
	List<Municipio> municipios;
	
	//Constructor
	public TablemodelMunicipiosImpl (String codProvinciao) {
		var municipiosService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		municipios = municipiosService.municipiosComunidad(codProvinciao);
	}
	
	
	@Override
	public int getRowCount() {
		return municipios.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	@Override
	public String getColumnName(int column) {
		return switch(column) {
			case 0->"Nombre";
			case 1->"Población";
			case 2->"Altitud";
			case 3->"Superficie";
			default->"";
		};
	}

	@Override
	public Object getValueAt(int co, int columnIndex) {
		return switch(column) {
		case 0->paises.get(row).getNombre();
		case 1->paises.get(row).getContinente();
		case 2->paises.get(row).getCapital();
		case 3->paises.get(row).getPoblacion();
		default->"";
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
