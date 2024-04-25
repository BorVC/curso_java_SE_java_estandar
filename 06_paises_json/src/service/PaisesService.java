package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
	
	public List<String> listaContinentes(){
		return getPaises()
				.map(p -> p.getContinente())//Stream<String>
				.distinct()
				.toList();
	}
	
	public List<Pais> listaPaisPorContinente(String continente){
		return getPaises()
				.filter(p -> p.getContinente().equals(continente))
				.toList();
	}
	
	public Pais paisMasPoblado() {
		return getPaises()
				.max(Comparator.comparingInt(p -> p.getHabitantes()))
				.orElse(null);
	}
	
	public Map<Boolean,Pais> tablaPorContinente(){
		return getPaises()
				.collect(Collectors.groupingBy(p -> p.getContinente()));
				
	}
	
	
}
