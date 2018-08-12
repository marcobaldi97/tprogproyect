package uytube.logica;

public abstract class ListaReproduccion {
	protected String nombre;//Esto puede ser un error.
	
	public ListaReproduccion() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(nombre);
		return dt;
	}

}
