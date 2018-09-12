package uytube.logica;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Categoria {
	private String nombre;
	private Map<Integer, Video> videos;
	private List<ListaReproduccion> lDReproduccion;

	public Categoria(String name) {
		nombre = name;
		videos = new HashMap<Integer, Video>();
		lDReproduccion = new LinkedList<ListaReproduccion>();
	}

	public void aniadirLDR(ListaReproduccion listaReproduccion) {
		if (!lDReproduccion.contains(listaReproduccion)) {
			lDReproduccion.add(listaReproduccion);
		}
	}

	public void removerLDR(ListaReproduccion listaReproduccion) {
		lDReproduccion.remove(listaReproduccion);
	}

	public String getNombre() {
		return nombre;
	}

	public void addVideo(Video video) {
		videos.put(video.getIDVideo(), video);
	}

	public void removerVideo(Video video) {
		videos.remove(video.getIDVideo());
	}

	/*
	 * public Video find(String s) { return videos.get(s); }
	 */

	public DtCategoria getInfoCategoria() {
		DtCategoria dataTipo = new DtCategoria(this);
		return dataTipo;
	}

	public DtVideo[] listarVideos() {
		DtVideo[] resultado = new DtVideo[videos.size()];
		Integer contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			resultado[contador] = new DtVideo(entry.getValue());
			contador++;
		}
		return resultado;
	}

	public DtListaReproduccion[] listarLDR() {
		DtListaReproduccion[] resultado = new DtListaReproduccion[lDReproduccion
				.size()];
		Integer contador = 0;
		for (ListaReproduccion lDReproduccion : lDReproduccion) {
			resultado[contador] = lDReproduccion.verDetallesListareproduccion();
			contador++;
		}
		return resultado;
	}

}
