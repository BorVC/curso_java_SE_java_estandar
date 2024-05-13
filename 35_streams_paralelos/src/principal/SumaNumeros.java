package principal;

import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.LongStream;

public class SumaNumeros {

	public static void main(String[] args) {
		//Inicio d ela instrucción
		LocalTime t1 = LocalTime.now();
		System.out.println(LongStream.rangeClosed(1, 1000000)
		.parallel()//Ejecuta en modo multitarea de manera paralela
		.sum());

		//Final de la instrucción
		LocalTime t2 = LocalTime.now();
		Duration p = Duration.between(t1, t2);
		System.out.println("Tiempo en el que se realizan las peticiones: "+ p);
	}

}
