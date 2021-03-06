package uytubeLogic.logica;

public class DtCategoria {
	private String nombre;

	public DtCategoria(Categoria categoria) {
		nombre = categoria.getNombre();
	}

	public DtCategoria(final String nombre) {
		this.nombre = nombre;
	}

	public boolean equals(DtCategoria dataTipo) {
		if (dataTipo != null) {
			return nombre == dataTipo.getNombre();
		} else
			return false;
	}

	public DtCategoria() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
