package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TestEscritura {

	public static void main(String[] args) {
		String ruta="nombres.txt";
		Path pt=Path.of(ruta);
		try {
			if(Files.notExists(pt)) {
				Files.createFile(pt);
			}
			Files.writeString(pt, "cadena1\n",StandardOpenOption.APPEND);
			Files.writeString(pt, "cadena2\n",StandardOpenOption.APPEND);
			Files.writeString(pt, "cadena3\n",StandardOpenOption.APPEND);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
