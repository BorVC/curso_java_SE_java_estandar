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
import java.util.stream.Collectors;

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
	
	public void eliminarPedido1(String producto) {
		try {
			List<String> listaPedidos = Files.lines(pt)
					.map(s -> Util.convertirCadenaAPedido(s))
					.filter(p -> !p.getProducto().equals(producto))
					.map(p -> Util.convertirPedidoACadena(p) + System.lineSeparator() )
					.collect(Collectors.toList());
			Files.write(pt, listaPedidos,StandardOpenOption.TRUNCATE_EXISTING);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    public void eliminarPedido(String producto) {
    try {
        Files.write(pt, 
                    Files.lines(pt)
                         .filter(line -> !Util.convertirCadenaAPedido(line).getProducto().equals(producto))
                         .map(line -> Util.convertirPedidoACadena(Util.convertirCadenaAPedido(line)))
                         .collect(Collectors.toList()),
                    StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException ex) {
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
