package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.ErrorFuenteDatosException;

public class NotasService {
	String fichero="notas.txt";
	Path pt = Path.of(fichero);
	
	public void borrarNotas() {
		try {
			Files.deleteIfExists(pt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void agregarNota(double nota) {
		try{
			if(Files.notExists(pt)) {//Crea el fichero si no existe en modo APPEND.(Sobreescritura)
				Files.createFile(pt);
			}
			Files.writeString(pt, nota + System.lineSeparator(), StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	public double media() throws ErrorFuenteDatosException{//throws propaga la excepción

		try{
			return Files.lines(pt)//Stream<String>
			.collect(Collectors.averagingDouble(n -> Double.parseDouble(n)))
			;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();//provoca la excepción
		}
	}
	public double max() throws ErrorFuenteDatosException{

		try{
			return Files.lines(pt)
					.max(Comparator.comparingDouble(n -> Double.parseDouble(n)))
					.map(n -> Double.parseDouble(n))
					.orElse(0.0);
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();//provoca la excepción
		}
	}
	public double min() throws ErrorFuenteDatosException{
		double min=Double.MAX_VALUE;
		
		String linea;
		try{
			return Files.lines(pt)
					.min(Comparator.comparing(n -> Double.parseDouble(n)))
					.map(n -> Double.parseDouble(n))
					.orElse(0.0);
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();//provoca la excepción
		}	
	}
	public List<Double> obtenerNotas() throws ErrorFuenteDatosException{
		ArrayList<Double> aux=new ArrayList<Double>();
		try{
			return Files.lines(pt)
					.map(n -> Double.parseDouble(n))
					.toList();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new ErrorFuenteDatosException();//provoca la excepción
		}
	}
}
