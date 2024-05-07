package view;

import service.ComunidadesService;
import service.ComunidadesServiceFactory;
import service.DatosProvinciasService;

import service.DatosProvinciasService;

public class Volcado {

	public static void main(String[] args) {
		/*var comService=new ComunidadesService();
		var provService=new DatosProvinciasService();
		comService.saveComunidades(provService.comunidades());
		comService.saveProvincias(provService.provincias());
		comService.saveMunicipios(provService.municipios());
		System.out.println("Volcado completado!!");*/
		
		var comService=ComunidadesServiceFactory.getComunidadesService();
		var provService=new DatosProvinciasService();
		System.out.println("Comunidades guardadas: "+ comService.saveComunidades(provService.comunidades()));
		System.out.println("Provincias guardadas: "+ comService.saveProvincias(provService.provincias()));
		System.out.println("Municipios guardados: "+ comService.saveMunicipios(provService.municipios()));
		System.out.println("Volcado completado!!");
		
		

	}

}
