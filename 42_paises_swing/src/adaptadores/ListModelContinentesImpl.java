package adaptadores;

import java.util.List;

import javax.swing.DefaultListModel;

import service.PaisesServiceFactory;

public class ListModelContinentesImpl extends DefaultListModel<String> {

	//Atributos
	List<String> continentes;
	
	//Constructor
	public ListModelContinentesImpl() {
		var paisesService  = PaisesServiceFactory.getPaisesService();
		continentes=paisesService.listaContinentes();
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
