package service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Pais;

public class PaisesService {

	String dir = "paises.json";
	private Stream<Pais> getStreamPaises(){
			Gson gson = new Gson();
			String url = "https://restcountries.com/v2/all";
			//Creammos objeto REQUEST para configurar la petición
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			//Creamos objeto CLIENT para hacer  la llamada
			HttpClient client = HttpClient.newBuilder()
					.build();
			//Realizamos la llamada
			try {
				HttpResponse<String> respuesta = client.send(request, BodyHandlers.ofString());
				return Arrays.stream(gson.fromJson(respuesta.body(), Pais[].class));
			} catch (IOException | InterruptedException ex) {
				ex.printStackTrace();
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
