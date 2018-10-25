package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uytubeLogic.logica.SystemHandler.Privacidad;

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

	public DtVideo[] listarVideos(Privacidad priv, String nomU) {
		DtVideo[] resultado;
		Integer contador = 0;
		if (priv == null && nomU == null) {
			resultado = new DtVideo[videos.size()];
			for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
				resultado[contador] = new DtVideo(entry.getValue());
				contador++;
			}
		} else if(priv!=null && nomU != null){
			List<DtVideo> videosPriv = new ArrayList<DtVideo>();
			for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
				if (entry.getValue().getPrivacidad().equals(priv) || entry.getValue().getPropietario().equals(nomU)) {
					videosPriv.add(new DtVideo(entry.getValue()));
				}
			}
			
			resultado = videosPriv.toArray(new DtVideo[0]);
		}else{
			resultado = new DtVideo[0];
		}
		return resultado;
	}

	public DtListaReproduccion[] listarLDR(Privacidad priv, String nomU) {
		DtListaReproduccion[] resultado;
		Integer contador = 0;
		if (priv == null && nomU == null) {
			resultado = new DtListaReproduccion[lDReproduccion.size()];
			for (ListaReproduccion lDReproduccion : lDReproduccion) {
				resultado[contador] = lDReproduccion.verDetallesListareproduccion();
				contador++;
			}
		} else if(nomU!=null && priv!=null){
			List<DtListaReproduccion> listasPriv = new ArrayList<DtListaReproduccion>();
			for (ListaReproduccion lista : lDReproduccion) {
				DtListaReproduccion entry = lista.toDt();
				if (entry.getPrivado().equals(priv) || entry.getPropietario().contentEquals(nomU))
					listasPriv.add(entry);
			}
			resultado = listasPriv.toArray(new DtListaReproduccion[0]);
		}else{
			resultado=new DtListaReproduccion[0];
		}
		return resultado;
}

}
