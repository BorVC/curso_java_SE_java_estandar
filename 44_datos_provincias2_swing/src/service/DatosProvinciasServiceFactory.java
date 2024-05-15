package service;

public class DatosProvinciasServiceFactory {
	public static DatosProvinciasService getDatosProvinciasService() {
		return new DatosProvinciasServiceImpl();
	}

}
