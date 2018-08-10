package uytube.logica;

public class Canal {
	private String nombre;
	private String descripcion;
	private Boolean privado;
	
	public Canal(String nom, String desc, Boolean privacidadE) {
		nombre = nom;
		descripcion = desc;
		privado = privacidadE;
	}
	
	public DtCanal mostrarInfoCanal() {
		DtCanal dt = new DtCanal(nombre,descripcion,privado);
		return dt;
	}
	

}
