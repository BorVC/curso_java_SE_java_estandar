package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import model.Pedido;
import utilidades.Util;

public class PedidosService {
	String fichero="pedidos.csv";
	Path pt = Path.of(fichero);
	//cada pedido se graba en una línea:
	//producto,unidades,fechaPedido
	public void borrarPedidos() {
		try {
			Files.deleteIfExists(pt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void nuevoPedido(Pedido pedido) {	
		try{
			Files.writeString(pt, Util.convertirPedidoACadena(pedido),StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Pedido pedidoMasReciente() {
		try {
			return Files.lines(pt)
					.map(n -> Util.convertirCadenaAPedido(n))
					.max(Comparator.comparing((Pedido p)->p.getFechaPedido()))
					.orElse(null);
					
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public List<Pedido> pedidosEntreFechas(LocalDate f1, LocalDate f2) {
		
		try{
			return Files.lines(pt)
					.map(n -> Util.convertirCadenaAPedido(n))
					.filter(p -> p.getFechaPedido().compareTo(f1)>=0 && p.getFechaPedido().compareTo(f2)<=0)
					.toList();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public Pedido pedidoProximoFecha(LocalDate fecha) {
	
		try{
			return Files.lines(pt)
			.map(n -> Util.convertirCadenaAPedido(n))
			.min(Comparator.comparingLong(p->Math.abs(ChronoUnit.DAYS.between(p.getFechaPedido(), fecha))))
			.orElse(null);

		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}

	}
	
	public void eliminarPedido(String producto) {
		try {
			String pedidos = Files.lines(pt)
					.map(p -> Util.convertirCadenaAPedido(p))
					.filter( p -> p.getProducto() != producto)
					.map(s -> Util.convertirPedidoACadena(s))
					.toString();
			Files.writeString(pt, pedidos);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<Pedido> listaPedidos(){
		try {
			return Files.lines(pt)
					.map(n -> Util.convertirCadenaAPedido(n))
					.toList();
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
