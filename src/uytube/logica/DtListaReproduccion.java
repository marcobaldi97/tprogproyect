package uytube.logica;

import uytube.logica.ListaReproduccion.TipoLista;
import uytube.logica.SystemHandler.Privacidad;

public class DtListaReproduccion {
	private String nombre;
	private String propietario;
	private Privacidad privado;
	private DtCategoria[] categoriasLDR;
	private TipoLista tipoL;
	
	public DtListaReproduccion(PorDefecto ldr){
		nombre=ldr.getNombre();
		propietario= ldr.getPropietario();
		privado=Privacidad.PRIVADO;
		categoriasLDR=ldr.getInfoCategorias();
		tipoL=TipoLista.PORDEFECTO;
	}
	public DtListaReproduccion(Particular ldr){
		nombre=ldr.getNombre();
		propietario=ldr.getPropietario();
		privado=ldr.getPrivado();
		categoriasLDR=ldr.getInfoCategorias();
		tipoL=TipoLista.PARTICULAR;
	}
	
	public Privacidad getPrivado(){ 
		return privado;
	}
	public TipoLista getTipoLista(){
		return tipoL;
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
