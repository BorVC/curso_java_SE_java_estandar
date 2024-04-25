package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Pais;

public class PaisesService {

	String dir = "paises.json";
	private Stream<Pais> getPaises(){
		try {
			Gson gson = new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(dir), Pais[].class));//Arrays<Stream>
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	//Lista de continentes
	public List<String> listaContinentes(){
		return getPaises()
				.map(p -> p.getContinente())//Stream<String>
				.distinct()
				.toList();
	}
	
	//Lista de paises buscados por continente
	public List<Pais> listaPaisPorContinente(String continente){
		return getPaises()
				.filter(p -> p.getContinente().equalsIgnoreCase(continente))
				.toList();
	}
	
	//País más poblado
	public Pais paisMasPoblado() {
		return getPaises()
				.max(Comparator.comparingInt(p -> p.getHabitantes()))
				.orElse(null);
	}
	
	//Tabla con paises agrupados por continente
	public Map<String,String> tablaPorContinente(){
		return getPaises()
				.collect(Collectors.toMap(p -> p.getContinente(),p -> p.getCapital()));
				//.collect(Collectors.groupingBy(p -> p.getContinente()));	
	}
	
	public Map<String,List<Pais>> tablaPaisesPorContinente(){
		return getPaises()
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	}
	
	//País a partir de su capital
	public Pais paisPorCapital(String capital) {
		return getPaises()
				.filter(p -> p.getCapital().equalsIgnoreCase(capital))
				.findFirst()
				.orElse(null);			
	}
	
	
}
