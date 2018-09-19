package uytube.logica;

//prueba commit
import java.util.HashMap;
import java.util.Map;

import uytube.logica.SystemHandler.Privacidad;

public class Canal {

	private String nombre;
	private String descripcion;
	private Privacidad privacidadCanal;
	private Categoria cate;
	private Map<String, Video> videos;
	private Map<String, ListaReproduccion> listasReproduccion;

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Privacidad getPrivacidad() {
		return privacidadCanal;
	}

	public DtCategoria getCategoria() {
		DtCategoria dataTipo = new DtCategoria(cate);
		return dataTipo;
	}

	public void addListaReproduccion(Particular listaRep) {
		listasReproduccion.put(listaRep.getNombre(), listaRep);
	}

	public void addListaReproduccion(PorDefecto listaRep) {
		listasReproduccion.put(listaRep.getNombre(), listaRep);
	}

	public void removeListaReproduccion(ListaReproduccion listaRep) {
		listasReproduccion.remove(listaRep.getNombre());
	}

	public ListaReproduccion findLista(String nombreLista) {
		return listasReproduccion.get(nombreLista);
	}

	public String[] listarListasReproduccion() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion
				.entrySet()) {
			if (entry.getValue() != null) {
				String nomb = entry.getValue().getNombre();
				nombresListas[contador] = nomb;
				contador++;
			} // Se agreg� esta linea para tratar de evitar los punteros
				// nulos.
		}
		return nombresListas;
	}

	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		DtListaReproduccion dataTipo = null;
		if (memberListaReproduccionPropia(nombreLista)) {
			ListaReproduccion listaRep = findLista(nombreLista);
			dataTipo = listaRep.verDetallesListareproduccion();
		}
		return dataTipo;
	}

	public Canal(String nomb, String proprietary, String desc,
			Privacidad privacidadE, String catE) {
		nombre = nomb;
		descripcion = desc;
		privacidadCanal = privacidadE;
		if (catE != null) {
			CategoriaHandler manejadorCategoria = CategoriaHandler
					.getInstance();
			cate = manejadorCategoria.find(catE);
		} else {
			SystemHandler manejadorSistema = SystemHandler.getInstance();
			cate = manejadorSistema.getSinCat();
		}
		videos = new HashMap<String, Video>();
		listasReproduccion = new HashMap<String, ListaReproduccion>();
		SystemHandler manejadorSistema = SystemHandler.getInstance();
		DtListaReproduccion[] listasDefault = manejadorSistema
				.obtenerListasReproduccion();
		for (int index = 0; index < listasDefault.length; index++) {
			PorDefecto listaRep = new PorDefecto(
					listasDefault[index].getNombre(), proprietary);
			addListaReproduccion(listaRep);
		}
	}

	public DtCanal mostrarInfoCanal() {
		DtCanal dataTipo = new DtCanal(this);
		return dataTipo;
	}

	public void addVideo(Video vVideo) {
		videos.put(vVideo.getNombre(), vVideo);
	}

	public void removerVideo(Video vVideo) {
		videos.remove(vVideo.getNombre());
	}

	public Video findVideo(String sNombre) {
		return videos.get(sNombre);
	}

	public void aniadirVideo(String nomb, String proprietary, String desc,
			Integer duracion, DtFecha fechaPublicacion, String urlVideo,
			DtCategoria catE, Privacidad priv) {
		Video vVideo = new Video(nomb, proprietary, desc, duracion,
				fechaPublicacion, urlVideo, catE, priv);
		this.addVideo(vVideo);
		VideoHandler vidH = VideoHandler.getInstance();
		vidH.addVideo(vVideo);
	}

	public void ingresarNuevosDatosVideo(String nomb, String desc,
			int duracion, DtFecha fechaPublicacion, String urlVideo,
			DtCategoria catE, Privacidad priv) {
		Video vVideo = videos.get(nomb);
		vVideo.ingresarNuevosDatosVideo(desc, duracion, fechaPublicacion,
				urlVideo, catE, priv);
	}

	public String[] listarVideosCanal() {
		String[] nombresVideos = new String[videos.size()];
		Integer contador = 0;
		for (Map.Entry<String, Video> entry : videos.entrySet()) {
			String nomb = entry.getValue().getNombre();
			nombresVideos[contador] = nomb;
			contador++;
		}
		return nombresVideos;
	}

	public String[] listarVideosPorLDR(String nombreLDR) {

		return listasReproduccion.get(nombreLDR).listarVideos();
	}

	public void agregarVideoLDR(Integer identificador, String nombreLDR) {
		VideoHandler manejadorVideo = VideoHandler.getInstance();
		Video vVideo = manejadorVideo.find(identificador);
		listasReproduccion.get(nombreLDR).agregarVideo(vVideo);
	}

	public void cambiarPrivLDR(String nombreL, Privacidad privE) {
		Particular listaRep = (Particular) listasReproduccion.get(nombreL);
		listaRep.cambiarPrivLDR(privE);
	}

	public void eliminarVideoLista(Integer id_video, String nombreLDR) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLDR);
		listaRep.removerVideo(id_video);
	}

	public Boolean memberListaReproduccionPropia(String nombreLista) {
		return listasReproduccion.containsKey(nombreLista);
	}

	public void nuevaListaPorDefecto(String nombreL, String proprietary) {
		PorDefecto ldr = new PorDefecto(nombreL, proprietary);
		listasReproduccion.put(nombreL, ldr);
	}

	public DtVideo obtenerInfoAdicVideo(String nombreVideo) {
		DtVideo dataTipo = new DtVideo(videos.get(nombreVideo));
		return dataTipo;
	}

	public Boolean memberVideoEnUsuario(String nombreVideo) {
		return videos.containsKey(nombreVideo);
	}

	public String[] listarVideosListaReproduccionUsuario(String nombreLista) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLista);
		return listaRep.listarVideos();
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLista);
		return listaRep.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(int idVideo, String nombreListaReproduccion) {
		VideoHandler videoH = VideoHandler.getInstance();
		Video video = videoH.find(idVideo);
		ListaReproduccion lista = this.findLista(nombreListaReproduccion);
		return lista.existeVideo(video);
	}

	public void modificarDatosCanal(String nombreCanal, String descripcion2,
			Privacidad privacidad, String catE2) {
		nombre = nombreCanal;
		descripcion = descripcion2;
		privacidadCanal = privacidad;
		if (catE2 != null) {
			CategoriaHandler manejadorCategoria = CategoriaHandler
					.getInstance();
			cate = manejadorCategoria.find(catE2);
		} else {
			SystemHandler manejadorSistema = SystemHandler.getInstance();
			cate = manejadorSistema.getSinCat();
		}

		if (privacidad.equals(Privacidad.PRIVADO)) {
			cambiarPrivacidadVideosAPrivado();
			cambiarPrivacidadListasParticularesAPrivado();
		}
	}

	private void cambiarPrivacidadVideosAPrivado() {
		for (final Map.Entry<String, Video> entry : videos.entrySet()) {
			final Video video = entry.getValue();
			video.setPrivacidad(Privacidad.PRIVADO);
		}
	}

	private void cambiarPrivacidadListasParticularesAPrivado() {
		for (final Map.Entry<String, ListaReproduccion> entry : listasReproduccion
				.entrySet()) {
			final ListaReproduccion listaReproduccion = entry.getValue();

			if (listaReproduccion instanceof Particular) {
				final Particular listaParticular = (Particular) listaReproduccion;
				listaParticular.cambiarPrivLDR(Privacidad.PRIVADO);
			}
		}
	}

	public String[] listarLDRParticularesdeUsuario() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion
				.entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue() instanceof Particular) {
					String nomb = entry.getValue().getNombre();
					nombresListas[contador] = nomb;
					contador++;
				}
			} // Se agreg� esta linea para tratar de evitar los punteros
				// nulos.
		}
		String[] nombresListasAjustado = new String[contador];
		for (int i = 0; i < contador; i++) {
			nombresListasAjustado[i] = nombresListas[i];
		}
		return nombresListasAjustado;
	}
}
