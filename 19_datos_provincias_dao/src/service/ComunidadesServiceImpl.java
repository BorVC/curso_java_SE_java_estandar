package service;

import java.util.List;

import dao.ComunidadesDao;
import dao.ComunidadesDaoFactory;
import dao.MunicipiosDao;
import dao.ProvinciasDao;
import model.Comunidad;
import model.Municipio;
import model.Provincia;

public class ComunidadesServiceImpl implements ComunidadesService {
	ComunidadesDao comunidadesDao;
	ProvinciasDao provinciasDao;
	MunicipiosDao municipiosDao;
	
	public ComunidadesServiceImpl() {
		comunidadesDao=ComunidadesDaoFactory.getComunidadesDao();
		provinciasDao=ComunidadesDaoFactory.getProvinciasDao();
		municipiosDao=ComunidadesDaoFactory.getMunicipiosDao();
	}

	@Override
	public int saveComunidades(List<Comunidad> comunidades) {
		//Solución 1 recorriendo la lista de comunidades y comprobando cuantas puede salvar y realizando la suma de las mismas
		/*int cont = 0;
		for(Comunidad c : comunidades) {
			if(!comunidadesDao.existComunidad(c.getCodigo())) {
				comunidadesDao.save(c);
				cont++;
			}
		}
		return cont;*/
		//Con programación funcional
		/*return (int)comunidades.stream()
				.filter(c -> !comunidadesDao.existComunidad(c.getCodigo()))
				.peek(c -> comunidadesDao.save(c))
				.count();*/
		
		//Solución 2
		/*List <Comunidad> listaAux = new ArrayList<Comunidad>();
		for(Comunidad c : comunidades) {
			if(!comunidadesDao.existComunidad(c.getCodigo())) {
				listaAux.add(c);
			}
		}
		comunidadesDao.save(listaAux);*/
		
		//Con programación funcional
		List <Comunidad> listaAux = comunidades.stream()
				.filter(c -> !comunidadesDao.existComunidad(c.getCodigo()))
				.toList();
		comunidadesDao.save(listaAux);
		return listaAux.size();
		
		
				
	}

	@Override
	public int saveProvincias(List<Provincia> provincias) {
		List<String> codigos =provinciasDao.findCodigos();
		List <Provincia> listaAux = provincias.stream()
				.filter(p -> !codigos.contains(p.getCodigo()))
				.toList();
		provinciasDao.saveProvincias(listaAux);
		return listaAux.size();
	}

	@Override
	public int saveMunicipios(List<Municipio> municipios) {
		List<String> codigos=municipiosDao.findCodigos();
		List<Municipio> aux=municipios.stream()
				.filter(p->!codigos.contains(p.getCodigo()))
				.toList();
		municipiosDao.saveMunicipios(aux);
		return aux.size();
	}
	
}
