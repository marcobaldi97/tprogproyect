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

}
