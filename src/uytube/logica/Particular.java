package uytube.logica;

public class Particular extends ListaReproduccion{
	private boolean privado;
	
	public Particular(String n, boolean p) {
		super(n);
		privado = p;
	}
	
	
	public boolean getPrivado() {
		return privado;
	}
	
	public void cambiarPrivLDR(Boolean privE) {
		privado = privE;
	}

	@Override
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}

}
