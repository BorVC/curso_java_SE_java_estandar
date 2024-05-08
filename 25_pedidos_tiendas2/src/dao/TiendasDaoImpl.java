package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import model.Empleado;
import model.Pedido;
import serializacion.DeserializadorFecha;

public class TiendasDaoImpl implements TiendasDao {
	
	private Stream<Pedido> pedidosFichero(String ruta){		
		try {
			Gson gson = new Gson();
			//gson.fromJson(new FileReader(ruta), Pedido[].class) crea un Array
			//Pasar a un array<Stream>
			return Arrays.stream(gson.fromJson(new FileReader(ruta), Pedido[].class));//Stream<Pedido>
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Stream.empty();
		}
	}
	@Override
	public List<Pedido> getPedidos(String ruta) {
		return pedidosFichero(ruta)
				.toList();
	}

}
