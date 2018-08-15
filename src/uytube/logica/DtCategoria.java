package uytube.logica;


public class DtCategoria {
	private String nombre;
	
	public DtCategoria(Categoria c){
		nombre=c.getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(DtCategoria dt) {
		return nombre == dt.getNombre();
	}

}
