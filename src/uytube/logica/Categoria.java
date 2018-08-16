package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class Categoria {
	private String nombre;
	private Map<String,Video> videos;
	private Map<String,ListaReproduccion> LDR;
	
	public Categoria(String n) {
		nombre = n;
		videos = new HashMap<String,Video>();
		LDR=new HashMap<String,ListaReproduccion>();
	}
	public void aniadirLDR(ListaReproduccion lr){
		LDR.put(lr.getNombre(), lr);
	}
	public void removerLDR(ListaReproduccion lr){
		LDR.remove(lr.getNombre());
	}
	public String getNombre() {
		return nombre;
	}
	
	public void addVideo(Video v) {
		videos.put(v.getNombre(), v);
	}
	
	public void removerVideo(Video v) {
		videos.remove(v.getNombre());
	}
	
	public Video find(String s) {
		return videos.get(s);
	}
	
	public DtCategoria getInfoCategoria() { 
		DtCategoria dt = new DtCategoria(this);
		return dt;
	}

	public DtVideo[] listarVideos() {
		DtVideo[] res=new DtVideo[videos.size()];
		Integer contador=0;
		for(Map.Entry<String, Video> entry : videos.entrySet()) {
			res[contador] = new DtVideo(entry.getValue());
			contador++;
		}
		return null;
	}

	
}
