package uytube.logica;

import java.util.HashMap;
import java.util.Map;

public class Canal {
	private String nombre;
	private String descripcion;
	private Boolean privado;
	private Map<String,Video> videos;
	private Map<String,ListaReproduccion> listasReproduccion;
	
	public void addListaReproduccion(ListaReproduccion lr) {
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
		for(Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			String nom = entry.getValue().getNombre();
			nombresListas[contador] = nom;
			contador++;
		}
		return nombresListas;
	}
	
	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		ListaReproduccion lr = findLista(nombreLista);
		DtListaReproduccion dt = lr.verDetallesListareproduccion();
		return dt;
	}
	
	public Canal(String nom, String desc, Boolean privacidadE) {
		nombre = nom;
		descripcion = desc;
		privado = privacidadE;
		videos = new HashMap<String,Video>();
	}
	
	public DtCanal mostrarInfoCanal() {
		DtCanal dt = new DtCanal(nombre,descripcion,privado);
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
	
	public void añadirVideo(String nom, String desc, Integer dur, Fecha fp, String url, DtCategoria catE, boolean p) {
		Video v = new Video(nom, desc, dur, fp, url, catE, p);
		CategoriaHandler catH = CategoriaHandler.getInstance();
		Categoria c = catH.find(catE.getNombre());
		c.addVideo(v);
		this.addVideo(v);
		VideoHandler vidH = VideoHandler.getInstance();
		vidH.addVideo(v);
	}
	
	public void ingresarNuevosDatosVideo(String nom, String d, int dur, Fecha fp, String url, DtCategoria catE, boolean p) {
		VideoHandler vidH = VideoHandler.getInstance();
		Video v = vidH.find(nom);
		v.ingresarNuevosDatosVideo(d, dur, fp, url, catE, p);
	}
	
	public DtVideo verDetallesVideo(String nombreVideo) {
		VideoHandler vidH = VideoHandler.getInstance();
		Video v = vidH.find(nombreVideo);
		DtVideo dt = v.verDetallesVideo();
		return dt;
	}
	
	public String[] listarVideosCanal() {
		String[] nombresVideos = new String[videos.size()];
		Integer contador = 0;
		for(Map.Entry<String, Video> entry : videos.entrySet()) {
			String nom = entry.getValue().getNombre();
			nombresVideos[contador] = nom;
			contador++;
		}
		return nombresVideos;
	}
	

}
