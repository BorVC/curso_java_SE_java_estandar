package service;

public class FormacionServiceFactory {
	//Método static crea implementación AlumnoServiceImpl
		public static AlumnosService getAlumnosService() {
			return new AlumnosServiceImpl();

		}
		
		public static CursosService getCursosService() {
			return new CursosServiceImpl();
		}
		
		public static CursosJsonService getCursosJsonService() {
			return new CursosJsonServiceImpl();
		}
}
