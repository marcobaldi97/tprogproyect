package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;

public class Particular extends ListaReproduccion{
	private Privacidad privado;
	
	public Particular(String n,String pro, Privacidad p) {
		super(n,pro);
		privado = p;
	}
	
	
	public Privacidad getPrivado() {
		return privado;
	}
	
	public void cambiarPrivLDR(Privacidad privE) {
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


	@Override
	public void removerVideo(Integer id) {
		if(existeVideo(getVideo(id))){
			Categoria categoria = getVideo(id).getObjetoCategoria();
			removerCategoria(categoria);
			categoria.removerLDR(this);
			removeVideoFromMap(id);
			refrescarCategorias();
		}
	}

}
