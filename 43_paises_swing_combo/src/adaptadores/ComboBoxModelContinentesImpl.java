package adaptadores;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.PaisesServiceFactory;

public class ComboBoxModelContinentesImpl extends DefaultComboBoxModel<String> {
	List<String> continentes;
	public ComboBoxModelContinentesImpl() {
		var paisesService=PaisesServiceFactory.getPaisesService();
		continentes=paisesService.getContinentes();
	}
	@Override
	public int getSize() {
		return continentes.size();
	}
	@Override
	public String getElementAt(int index) {
		return continentes.get(index);
	}
	
}
