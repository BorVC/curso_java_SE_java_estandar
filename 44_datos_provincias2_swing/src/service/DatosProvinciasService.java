package service;

import java.util.List;

import model.Municipio;
import model.Provincia;

public interface DatosProvinciasService {

	List<String> comunidades();

	List<Provincia> provinciasComunidad(String comunidad);

	List<Municipio> municipiosComunidad(String codigoProvincia);

}