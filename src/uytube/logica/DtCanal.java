package uytube.logica;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Boolean privado;

	public DtCanal(String nom, String desc, Boolean privacidadE) {
		nombre = nom;
		descripcion = desc;
		privado = privacidadE;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Boolean getPrivacidad() {
		return privado;
	}
	
	public Boolean equals(DtCanal c) {
		return (nombre == c.getNombre()) && (descripcion == c.getDescripcion()) && (privado == c.getPrivacidad());
	}

}
