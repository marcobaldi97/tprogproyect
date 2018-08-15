package uytube.logica;

public class DtListaReproduccion {
	private String nombre;
	
	public DtListaReproduccion(ListaReproduccion ldr){
		nombre=ldr.getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(DtListaReproduccion dt) {
		return nombre == dt.getNombre();
	}

}
