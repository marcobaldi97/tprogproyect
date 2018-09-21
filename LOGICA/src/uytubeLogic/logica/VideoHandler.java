package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class VideoHandler {
	private Map<Integer, Video> videos;
	private static VideoHandler instancia = null;
	private Integer iDActual;

	private VideoHandler() {
		videos = new HashMap<Integer, Video>();
		iDActual = 0;
	}

	public Integer getNewID() {
		return ++iDActual;
	}

	public static VideoHandler getInstance() {
		if (instancia == null)
			instancia = new VideoHandler();
		return instancia;
	}

	public void addVideo(Video vidAAgregar) {
		videos.put(iDActual, vidAAgregar);
	}

	public void removerVideo(Video vidARemover) {
		videos.remove(vidARemover.getIDVideo());
	}

	public Video find(Integer IDClave) {
		return videos.get(IDClave);
	}

	public DtVideo[] listarVideos() {
		DtVideo[] infoVideos = new DtVideo[videos.size()];
		Integer contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			DtVideo infoV = new DtVideo(entry.getValue());
			infoVideos[contador] = infoV;
			contador++;
		}
		return infoVideos;
	}

	public DtVideo[] listarVideosPublicosPorNombre(String nombre) {
		int cantVideosConNombre = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			if (entry.getValue().getNombre().contains(nombre)
					&& entry.getValue().getPrivacidad() == (Privacidad.PUBLICO))
				cantVideosConNombre++;

		}
		DtVideo[] infoVideos = new DtVideo[cantVideosConNombre];
		int iterador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			if (entry.getValue().getNombre().contains(nombre)
					&& entry.getValue().getPrivacidad() == (Privacidad.PUBLICO))
				infoVideos[iterador] = new DtVideo(entry.getValue());
		}
		return infoVideos;
	}

	public DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre) {
		List<DtListaReproduccion> listaLDR = new ArrayList<DtListaReproduccion>();
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			DtListaReproduccion[] listasEnVideo = entry.getValue().getListas();
			for (DtListaReproduccion lista : listasEnVideo) {

				if (lista.getPrivado() == Privacidad.PUBLICO && lista.getNombre().contains(nombre)) {
					listaLDR.add(lista);
				}
			}
		}
		DtListaReproduccion[] resultadosBusqueda = listaLDR.toArray(new DtListaReproduccion[0]);
		return resultadosBusqueda;
	}

	public DtVideo member(String nomVideo, String nick) {
		DtVideo infoVideo = null;
		for (Entry<Integer, Video> entry : videos.entrySet()) {
			if (nomVideo == entry.getValue().getNombre() && nick == entry.getValue().getPropietario())
				infoVideo = new DtVideo(entry.getValue());
		}
		return infoVideo;
	}

}
