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
	private Stream<Pais> getStreamPaises(){
		try {
			Gson gson = new Gson();
			return Arrays.stream(gson.fromJson(new FileReader(dir), Pais[].class));//Stream<Pais>
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	
	//Lista de continentes
	public List<String> listaContinentes(){
		return getStreamPaises()
				.map(p -> p.getContinente())//Stream<String>
				.distinct()
				.toList();
	}
	
	//Lista de paises buscados por continente
	public List<Pais> listaPaisPorContinente(String continente){
		return getStreamPaises()
				.filter(p -> p.getContinente().equalsIgnoreCase(continente))
				.toList();
	}
	
	//País más poblado
	public Pais paisMasPoblado() {
		return getStreamPaises()
				.max(Comparator.comparingLong(p -> p.getHabitantes()))
				.orElse(null);
	}
	
	//Tabla con paises agrupados por continente
	public Map<String,String> tablaPorContinente(){
		return getStreamPaises()
				.collect(Collectors.toMap(p -> p.getContinente(),p -> p.getCapital()));	
	}
	
	public Map<String,List<Pais>> tablaPaisesPorContinente(){
		return getStreamPaises()
				.collect(Collectors.groupingBy(p -> p.getContinente()));
	}
	
	//País a partir de su capital
	public Pais paisPorCapital(String capital) {
		return getStreamPaises()
				.filter(p -> p.getCapital() != null  && p.getCapital().equalsIgnoreCase(capital))//Stream<Pais>
				.findFirst()//Optional<Pais>
				.orElse(null);			
	}
	
	public String paisPorString(String capital) {
		return getStreamPaises()
				.filter(p -> p.getCapital() != null  && p.getCapital().equalsIgnoreCase(capital))//Stream<Pais>
				.findFirst()//Optiona<Pais>
				.map(p -> p.getNombre())//Optiona<String>
				.orElse("");

	}
	
	
}
