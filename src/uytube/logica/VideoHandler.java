package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class VideoHandler {
	private Map<String,Video> videos;
	private static VideoHandler instancia = null;
	
	private VideoHandler() {
		videos = new HashMap<String,Video>();
	}
	
	public static VideoHandler getInstance() {
		if (instancia == null)
			instancia = new VideoHandler();
		return instancia;
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
	
	public String[] listarVideos() {
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
