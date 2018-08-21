package uytube.logica;

public class PorDefecto extends ListaReproduccion{

	public PorDefecto(String n, String pro) {
		super(n,pro);
	}

	@Override
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}

}
