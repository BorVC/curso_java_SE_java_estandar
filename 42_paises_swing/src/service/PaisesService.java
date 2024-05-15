package service;

import java.util.List;
import java.util.Map;

import model.Pais;

public interface PaisesService {

	//Lista de continentes
	List<String> listaContinentes();

	//Lista de paises buscados por continente
	List<Pais> listaPaisPorContinente(String continente);

	//País más poblado
	Pais paisMasPoblado();

	//Tabla con paises agrupados por continente
	Map<String, String> tablaPorContinente();

	Map<String, List<Pais>> tablaPaisesPorContinente();

	//País a partir de su capital
	Pais paisPorCapital(String capital);

	String paisPorString(String capital);

}