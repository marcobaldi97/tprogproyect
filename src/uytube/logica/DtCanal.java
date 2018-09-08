package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;



public class DtCanal {
	private String nombre;
	private String descripcion;
	private Privacidad privado;
	private DtCategoria categoria;

	public DtCanal(Canal c){
		nombre=c.getNombre();
		descripcion=c.getDescripcion();
		privado=c.getPrivacidad();
		categoria = c.getCategoria();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Privacidad getPrivacidad() {
		return privado;
	}
	
	public DtCategoria getCategoria() {
		return categoria;
	}
	
	public Boolean equals(DtCanal c) {
		return (nombre == c.getNombre()) && (descripcion == c.getDescripcion()) && (privado == c.getPrivacidad());
	}

}
