package uytube.logica;

import java.util.Map;

public class DtCategoria {
	private String nombre;
	
	public DtCategoria(String n) {
		nombre = n;
	}
	public DtCategoria(Categoria c){
		nombre=c.getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}

}
