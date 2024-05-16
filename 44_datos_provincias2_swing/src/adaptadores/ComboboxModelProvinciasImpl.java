package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Provincia;
import service.DatosProvinciasServiceFactory;

public class ComboboxModelProvinciasImpl extends DefaultComboBoxModel<Provincia> {
	List<Provincia> provincias;
	//Constructor
	public ComboboxModelProvinciasImpl(String comunidad) {
		/*DatosProvinciasService*/ var provinciasService = DatosProvinciasServiceFactory.getDatosProvinciasService();
		provincias = provinciasService.provinciasComunidad(comunidad);
	}
	@Override
	public int getSize() {
		return provincias.size();
	}
	@Override
	public Provincia getElementAt(int index) {
		return provincias.get(index);
	}
	
}
