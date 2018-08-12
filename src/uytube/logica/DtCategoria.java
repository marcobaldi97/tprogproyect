package uytube.logica;

import java.util.Map;

public class DtCategoria {
	private String nombre;
	
	public DtCategoria(String n) {
		nombre = n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean equals(DtCategoria dt) {
		return nombre == dt.getNombre();
	}

}
