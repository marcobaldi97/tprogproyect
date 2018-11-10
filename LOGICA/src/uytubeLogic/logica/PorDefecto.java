package uytubeLogic.logica;

import java.util.HashMap;
import java.util.Map;

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

	@Override
	public DtListaReproduccion toDt() {
		return new DtListaReproduccion(this);
	}

	@Override
	public uyTubePersistencia.ListaReproduccion persistir() {
		uyTubePersistencia.ListaReproduccion defectoP = new uyTubePersistencia.ListaReproduccion(this);
		Map<Integer, uyTubePersistencia.Video> videosListaP = new HashMap<Integer, uyTubePersistencia.Video>();
		return defectoP;
	}

}
