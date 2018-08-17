package uytube.logica;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Boolean privado;
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
	
	public Boolean getPrivacidad() {
		return privado;
	}
	
	public DtCategoria getCategoria() {
		return categoria;
	}
	
	public Boolean equals(DtCanal c) {
		return (nombre == c.getNombre()) && (descripcion == c.getDescripcion()) && (privado == c.getPrivacidad());
	}

}
