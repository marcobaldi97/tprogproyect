package uytube.logica;

public class DtListaReproduccion {
	private String nombre;
	private String propietario;
	private boolean privado;
	private DtCategoria[] categoriasLDR;
	
	public DtListaReproduccion(PorDefecto ldr){
		nombre=ldr.getNombre();
		propietario= ldr.getPropietario();
		privado=false;
		categoriasLDR=ldr.getInfoCategorias();
	}
	public DtListaReproduccion(Particular ldr){
		nombre=ldr.getNombre();
		propietario=ldr.getPropietario();
		privado=ldr.getPrivado();
		categoriasLDR=ldr.getInfoCategorias();
	}
	
	public boolean getPrivado(){ 
		return privado;
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
	public String getPropietario() {
		return propietario;
	}

}
