package uytube.logica;

public class PorDefecto extends ListaReproduccion{

	public PorDefecto(String n) {
		super(n);
	}

	@Override
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}

}
