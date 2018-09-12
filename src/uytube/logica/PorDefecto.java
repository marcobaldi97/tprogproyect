package uytube.logica;

public class PorDefecto extends ListaReproduccion {

	public PorDefecto(String nombreLista, String propietarioLista) {
		super(nombreLista, propietarioLista);
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
		videoAAgregar.aniadirListaReproduccion(this);

	}

	@Override
	public void removerVideo(Integer idVideo) {
		removeVideoFromMap(idVideo);
	}

}
