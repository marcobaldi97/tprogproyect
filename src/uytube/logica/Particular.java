package uytube.logica;

public class Particular extends ListaReproduccion{
	private boolean privado;
	
	public Particular(String n,String pro, boolean p) {
		super(n,pro);
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


	@Override
	public void agregarVideo(Video v) {

		//videos.put(v.getIDVideo(), v);
		addVideoToMap(v);
		refrescarCategorias();
		CategoriaHandler catH = CategoriaHandler.getInstance();
		Categoria c = catH.find(v.getCategoria().getNombre());
		if (c != null)
			c.aniadirLDR(this);
		v.aniadirListaReproduccion(this);

	}

}
