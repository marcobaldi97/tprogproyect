package uytube.logica;

public class DtListaReproduccion {
	private String nombre;
	private DtCategoria[] categoriasLDR;
	
	public DtListaReproduccion(ListaReproduccion ldr){
		nombre=ldr.getNombre();
		categoriasLDR=ldr.getInfoCategorias();
	}
	
	public DtCategoria[] getCategoriasLDR(){
		return categoriasLDR;
	}
	
	public DtListaReproduccion(String nombreL) {
		nombre = nombreL;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(DtListaReproduccion dt) {
		return nombre == dt.getNombre();
	}

}
