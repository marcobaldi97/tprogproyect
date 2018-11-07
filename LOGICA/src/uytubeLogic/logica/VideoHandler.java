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
		List<DtVideo> listaVideos = new ArrayList<DtVideo>();
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			if (entry.getValue().getPrivacidad() == Privacidad.PUBLICO
					&& (entry.getValue().getNombre().toLowerCase().contains(nombre.toLowerCase())
							|| entry.getValue().getDescripcion().toLowerCase().contains(nombre.toLowerCase()))) {
				listaVideos.add(new DtVideo(entry.getValue()));
			}
		}
		DtVideo[] resultadosBusqueda = listaVideos.toArray(new DtVideo[0]);
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

	public void eliminarComentariosYValoraciones(Usuario usrEliminar) {
		DtComentario[] comentarios;
		for(Entry<Integer, Video> video: videos.entrySet()){
			//valoraciones(puntuaciones)
			video.getValue().eliminarPuntuacion(usrEliminar);
			//comentarios
			video.getValue().eliminarComentarios(usrEliminar);
		}
		
	}

}
