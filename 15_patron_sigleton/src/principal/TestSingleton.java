package principal;

import service.SingletonService;

public class TestSingleton {

	public static void main(String[] args) {
		//var s1 = new SingletonService();//No se puede instanciar la clase
		var s2 = SingletonService.getInstance();//Llamada al método static desde la propia clase
		var s3 = SingletonService.getInstance();
		System.out.println(s2 == s3);//true

	}

}
