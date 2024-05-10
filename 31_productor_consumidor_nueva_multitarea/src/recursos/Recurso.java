package recursos;

import java.util.ArrayList;
import java.util.List;

public class Recurso {
	List<Integer> nums=new ArrayList<>();
	boolean lleno;
	boolean vacio;
	public void guardar(int dato) {
		nums.add(dato);
	}
	public int sacar() {
		return nums.remove(nums.size()-1);
	}
	public boolean isLleno() {
		if(nums.size()<5) {
			return false;
		}
		return true;
	}
	public boolean isVacio() {
		return nums.isEmpty();
	}
}
