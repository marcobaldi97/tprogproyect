package uytubeLogic.logica;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class Particular extends ListaReproduccion {
	private Privacidad privado;

	public Particular(String nombreLista, String pro, Privacidad privacidadLista) {
		super(nombreLista, pro);
		privado = privacidadLista;
	}

	public Privacidad getPrivado() {
		return privado;
	}

	public void cambiarPrivLDR(Privacidad privE) {
		privado = privE;
	}

	@Override
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion infoLista = new DtListaReproduccion(this);
		return infoLista;
	}

	@Override
	public void agregarVideo(Video videoAAgregar) {

		// videos.put(v.getIDVideo(), v);
		addVideoToMap(videoAAgregar);
		refrescarCategorias();
		CategoriaHandler catH = CategoriaHandler.getInstance();
		Categoria categoriaVideo = catH.find(videoAAgregar.getCategoria()
				.getNombre());
		if (categoriaVideo != null)
			categoriaVideo.aniadirLDR(this);
		videoAAgregar.aniadirListaReproduccion(this);

	}

	@Override
	public void removerVideo(Integer idVideo) {
		if (existeVideo(getVideo(idVideo))) {
			Categoria categoria = getVideo(idVideo).getObjetoCategoria();
			removerCategoria(categoria);
			categoria.removerLDR(this);
			removeVideoFromMap(idVideo);
			refrescarCategorias();
		}
	}

	@Override
	public DtListaReproduccion toDt() {
		
		return new DtListaReproduccion(this);
	}

	@Override
	public uyTubePersistencia.ListaReproduccion persistir() {
		uyTubePersistencia.ListaReproduccion particularP = new uyTubePersistencia.ListaReproduccion(this);
		return particularP;
	}

}
