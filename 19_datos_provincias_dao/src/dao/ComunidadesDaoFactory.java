package dao;

//3 métodos por cada interface para su implementación
public class ComunidadesDaoFactory {
	public static ComunidadesDao getComunidadesDao() {
		return new ComunidadesDaoImpl();
	}
	public static ProvinciasDao getProvinciasDao() {
		return new ProvinciasDaoImpl();
	}
	public static MunicipiosDao getMunicipiosDao() {
		return new MunicipiosDaoImpl();
	}
}
