package uytubeLogic.logica;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class ListaReproduccion {
	private String nombre;
	private String propietario;
	private Map<Integer, Video> videos;
	private Map<String, Categoria> categorias;

	public ListaReproduccion(String nombLDR, String pro) {
		nombre = nombLDR;
		propietario = pro;
		videos = new HashMap<Integer, Video>();
		categorias = new HashMap<String, Categoria>();
	}

	public Video getVideo(Integer idVideo) {
		return videos.get(idVideo);
	}

	public enum TipoLista {
		PORDEFECTO, PARTICULAR;
	}

	public String getNombre() {
		return nombre;
	}

	public void addVideoToMap(Video videoAAgregar) {
		videos.put(videoAAgregar.getIDVideo(), videoAAgregar);
	}

	public void removeVideoFromMap(Integer idVideo) {
		videos.remove(idVideo);
	}

	public abstract DtListaReproduccion verDetallesListareproduccion();

	public String[] listarVideos() {
		String[] nombreVideos = new String[videos.size()];
		Integer contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			nombreVideos[contador] = entry.getValue().getNombre();
			contador++;
		}
		return nombreVideos;
	}

	public void refrescarCategorias() {
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			Categoria categoria = entry.getValue().getObjetoCategoria();
			System.out.println("cate "+categoria.getNombre());
			System.out.println("igual? "+categoria.getNombre().equals(SystemHandler.getInstance().getSinCat().getNombre()));
				
			if(!categoria.getNombre().equals(SystemHandler.getInstance().getSinCat().getNombre())) {
				categoria.aniadirLDR(this);

			categorias.put(categoria.getNombre(), entry.getValue()
					.getObjetoCategoria());
			}
		}

	}

	public abstract void removerVideo(Integer idVideo);

	public abstract void agregarVideo(Video videoAAgregar);

	public DtCategoria[] getInfoCategorias() {
		DtCategoria[] res = new DtCategoria[categorias.size()];
		int i = 0;
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
			res[i] = new DtCategoria(entry.getValue());
			i++;
		}
		return res;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		DtVideo[] dtvideos = new DtVideo[videos.size()];
		int contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			DtVideo dt = new DtVideo(entry.getValue());
			dtvideos[contador] = dt;
			contador++;
		}
		return dtvideos;
	}

	public boolean existeVideo(Video video) {
		return videos.containsKey(video.getIDVideo());
	}

	public void removerCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		categorias.remove(cat.getNombre());
	}
	
	public Date getFechaUltimoVideo() {
		Date LastFecha = new Date(0);
		boolean found = false;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			if (!found) {
				LastFecha = entry.getValue().getFechaPublicacion().getFecha();
				found = true;
			} else if (entry.getValue().getFechaPublicacion().getFecha().before(LastFecha)) {
				LastFecha = entry.getValue().getFechaPublicacion().getFecha();
			}
		}
		return LastFecha;
	}
	
	public abstract DtListaReproduccion toDt();

	public abstract uyTubePersistencia.ListaReproduccion persistir();

	public Map<Integer, Video> getVideos() {
		return videos;
	}

	public void setVideos(Map<Integer, Video> videos) {
		this.videos = videos;
	}

	public void eliminarVideos() {
		Iterator<Integer> it = videos.keySet().iterator();
		while (it.hasNext()) {
		   it.next();
		   it.remove();
		   // videos.remove(key);
		 }
	}



}
