package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.DatosProvinciasServiceFactory;

public class ComboboxModelComunidadesImpl extends DefaultComboBoxModel<String> {
	List <String> comunidades;
	//Constructor
	public ComboboxModelComunidadesImpl() {
		/*DatosProvinciasService*/ var comunidadesService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		comunidades = comunidadesService.comunidades();
	}
	
	@Override
	public int getSize() {
		return comunidades.size();
	}
	@Override
	public String getElementAt(int index) {
		return comunidades.get(index);
	}

}
