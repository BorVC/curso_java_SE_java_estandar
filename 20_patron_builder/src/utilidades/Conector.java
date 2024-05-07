package utilidades;

public class Conector {
	private String modo;
	private int tipo;
	private String direccion;
	private boolean estado;
	private String protocolo;
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getProtocolo() {
		return protocolo;
	}
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}
	
	public static class ConectorBuilder {
		Conector conector;
		//Constrructor crea objto Builder
		public ConectorBuilder() {
			conector = new Conector();
		}
		
		//Métodos
		//Establecer modo
		public ConectorBuilder modo(String modo) {
			conector.setModo(modo);
			return this;
		}
		
		//Estableceer tipo
		public ConectorBuilder tipo(int tipo) {
			if(tipo < 0) {
				tipo = 0;
			}
			conector.setTipo(tipo);
			return this;
		}
		
		//establecer estado
		public ConectorBuilder estado(boolean estado) {
			conector.setEstado(estado);
			return this;
		}
		
		//Establecer direccion
		public ConectorBuilder direccion(String direccion) {
			conector.setDireccion(direccion);;
			return this;
		}
		
		//Establecer protocolo
		public ConectorBuilder protocolo(String protocolo) {
			conector.setProtocolo(protocolo);;
			return this;
		}
		
		public Conector build() {
			return conector;
		}
	}
}
