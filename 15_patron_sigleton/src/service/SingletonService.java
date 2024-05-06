package service;

public class SingletonService {
	//Atributo de tipo SingletonService para q se pueda llamar a la clase
	private static SingletonService instance;
	//Constructor privado q evita q se puedan instanciar objetos de esta clase
	private SingletonService() {
		instance = this;
	}
	
	//Método q permite instanciar un único objeto de la clase
	public static SingletonService getInstance() {
		if(instance == null) {//Si no existe crea la instancia
			new SingletonService();
		}
		return instance;
		
	}
}
