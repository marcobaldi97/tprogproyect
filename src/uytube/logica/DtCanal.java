package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;



public class DtCanal {
	private String nombre;
	private String descripcion;
	private Privacidad privado;
	private DtCategoria categoria;

	public DtCanal(Canal chanel){
		nombre=chanel.getNombre();
		descripcion=chanel.getDescripcion();
		privado=chanel.getPrivacidad();
		categoria = chanel.getCategoria();
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
	
	public Boolean equals(DtCanal chanel) {
		return (nombre == chanel.getNombre()) && (descripcion == chanel.getDescripcion()) && (privado == chanel.getPrivacidad());
	}

}
