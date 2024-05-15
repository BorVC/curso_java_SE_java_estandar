package service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Pais;

public interface PaisesService {

	List<String> getContinentes();

	List<Pais> getPaisesFiltradosPor(String continente);

	Optional<Pais> getPaisMasPoblado();

	Map<String, List<Pais>> getTablaPaisContinente();

	//nombre del pais
	String getPaisFiltradoPor(String capital);

}