package uytube.logica;

//prueba commit
import java.util.HashMap;
import java.util.Map;

public class Canal {
	private String nombre;
	private String descripcion;
	private Boolean privado;
	private Categoria cate;
	private Map<String, Video> videos;
	private Map<String, ListaReproduccion> listasReproduccion;

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Boolean getPrivacidad() {
		return privado;
	}

	public DtCategoria getCategoria() {
		DtCategoria dt = new DtCategoria(cate);
		return dt;
	}

	public void addListaReproduccion(Particular lr) {
		listasReproduccion.put(lr.getNombre(), lr);
	}

	public void addListaReproduccion(PorDefecto lr) {
		listasReproduccion.put(lr.getNombre(), lr);
	}

	public void removeListaReproduccion(ListaReproduccion lr) {
		listasReproduccion.remove(lr.getNombre());
	}

	public ListaReproduccion findLista(String s) {
		return listasReproduccion.get(s);
	}

	public String[] listarListasReproduccion() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			if (entry.getValue() != null) {
				String nom = entry.getValue().getNombre();
				nombresListas[contador] = nom;
				contador++;
			} // Se agreg� esta linea para tratar de evitar los punteros nulos.
		}
		return nombresListas;
	}

	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		DtListaReproduccion dt = null;
		if (memberListaReproduccionPropia(nombreLista)) {
			ListaReproduccion lr = findLista(nombreLista);
			dt = lr.verDetallesListareproduccion();
		}
		return dt;
	}

	public Canal(String nom, String pro, String desc, Boolean privacidadE, String catE) {
		nombre = nom;
		descripcion = desc;
		privado = privacidadE;
		if (catE != null) {
			CategoriaHandler ch = CategoriaHandler.getInstance();
			cate = ch.find(catE);
		} else {
			SystemHandler sh = SystemHandler.getInstance();
			cate = sh.getSinCat();
		}
		videos = new HashMap<String, Video>();
		listasReproduccion = new HashMap<String, ListaReproduccion>();
		SystemHandler sh = SystemHandler.getInstance();
		DtListaReproduccion[] listasDefault = sh.obtenerListasReproduccion();
		for (int index = 0; index < listasDefault.length; index++) {
			PorDefecto lr = new PorDefecto(listasDefault[index].getNombre(), pro);
			addListaReproduccion(lr);
		}
	}

	public DtCanal mostrarInfoCanal() {
		DtCanal dt = new DtCanal(this);
		return dt;
	}

	public void addVideo(Video v) {
		videos.put(v.getNombre(), v);
	}

	public void removerVideo(Video v) {
		videos.remove(v.getNombre());
	}

	public Video findVideo(String s) {
		return videos.get(s);
	}

	public void aniadirVideo(String nom, String pro, String desc, Integer dur, DtFecha fp, String url, DtCategoria catE,
			boolean p) {
		Video v = new Video(nom, pro, desc, dur, fp, url, catE, p);
		this.addVideo(v);
		VideoHandler vidH = VideoHandler.getInstance();
		vidH.addVideo(v);
	}

	public void ingresarNuevosDatosVideo(String nom, String d, int dur, DtFecha fp, String url, DtCategoria catE,
			boolean p) {
		Video v = videos.get(nom);
		v.ingresarNuevosDatosVideo(d, dur, fp, url, catE, p);
	}

	public String[] listarVideosCanal() {
		String[] nombresVideos = new String[videos.size()];
		Integer contador = 0;
		for (Map.Entry<String, Video> entry : videos.entrySet()) {
			String nom = entry.getValue().getNombre();
			nombresVideos[contador] = nom;
			contador++;
		}
		return nombresVideos;
	}

	public String[] listarVideosPorLDR(String nombreLDR) {

		return listasReproduccion.get(nombreLDR).listarVideos();
	}

	public void agregarVideoLDR(Integer id, String nombreLDR) {
		VideoHandler vh = VideoHandler.getInstance();
		Video v = vh.find(id);
		listasReproduccion.get(nombreLDR).agregarVideo(v);
	}

	public void cambiarPrivLDR(String nombreL, Boolean privE) {
		Particular lr = (Particular) listasReproduccion.get(nombreL);
		lr.cambiarPrivLDR(privE);
	}

	public void eliminarVideoLista(Integer id_video, String nombreLDR) {
		// TODO Auto-generated method stub
		ListaReproduccion lr = listasReproduccion.get(nombreLDR);
		lr.removerVideo(id_video);
	}

	public Boolean memberListaReproduccionPropia(String nombreLista) {
		return listasReproduccion.containsKey(nombreLista);
	}

	public void nuevaListaPorDefecto(String nombreL, String pro) {
		PorDefecto ldr = new PorDefecto(nombreL, pro);
		listasReproduccion.put(nombreL, ldr);
	}

	public DtVideo obtenerInfoAdicVideo(String nombreVideo) {
		DtVideo dt = new DtVideo(videos.get(nombreVideo));
		return dt;
	}

	public Boolean memberVideoEnUsuario(String nombreVideo) {
		return videos.containsKey(nombreVideo);
	}

	public String[] listarVideosListaReproduccionUsuario(String nombreLista) {
		ListaReproduccion lr = listasReproduccion.get(nombreLista);
		return lr.listarVideos();
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		// TODO Auto-generated method stub
		ListaReproduccion lr = listasReproduccion.get(nombreLista);
		return lr.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(int idVideo, String nombreListaReproduccion) {
		VideoHandler videoH = VideoHandler.getInstance();
		Video video = videoH.find(idVideo);
		ListaReproduccion lista = this.findLista(nombreListaReproduccion);
		return lista.existeVideo(video);
	}

	public void modificarDatosCanal(String nombreCanal, String descripcion2, Boolean privacidad, String catE2) {
		nombre = nombreCanal;
		descripcion = descripcion2;
		privado = privacidad;
		if (catE2 != null) {
			CategoriaHandler ch = CategoriaHandler.getInstance();
			cate = ch.find(catE2);
		} else {
			SystemHandler sh = SystemHandler.getInstance();
			cate = sh.getSinCat();
		}

		if (privacidad) {
			cambiarPrivacidadVideosAPrivado();
			cambiarPrivacidadListasParticularesAPrivado();
		}
	}

	private void cambiarPrivacidadVideosAPrivado() {
		for (final Map.Entry<String, Video> entry : videos.entrySet()) {
			final Video video = entry.getValue();
			video.setPrivacidad(true);
		}
	}

	private void cambiarPrivacidadListasParticularesAPrivado() {
		for (final Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			final ListaReproduccion listaReproduccion = entry.getValue();

			if (listaReproduccion instanceof Particular) {
				final Particular listaParticular = (Particular) listaReproduccion;
				listaParticular.cambiarPrivLDR(true);
			}
		}
	}

	public String[] listarLDRParticularesdeUsuario() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			if (entry.getValue() != null) {
				if(entry.getValue() instanceof Particular) {
					String nom = entry.getValue().getNombre();
					nombresListas[contador] = nom;
					contador++;
				}
			} // Se agreg� esta linea para tratar de evitar los punteros nulos.
		}
		String[] nombresListasAjustado = new String[contador];
		for(int i = 0; i < contador;i++){
			nombresListasAjustado[i] = nombresListas[i];
		}
		return nombresListasAjustado;
	}
}
