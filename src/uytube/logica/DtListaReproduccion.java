package uytube.logica;

public class DtListaReproduccion {
	private String nombre;
	
	public DtListaReproduccion(String n) {
		nombre = n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(DtListaReproduccion dt) {
		return nombre == dt.getNombre();
	}

}
