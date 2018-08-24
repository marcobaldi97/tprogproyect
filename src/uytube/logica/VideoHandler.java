package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class VideoHandler {
	private Map<Integer,Video> videos;
	private static VideoHandler instancia = null;
	private Integer IDActual;
	
	private VideoHandler() {
		videos = new HashMap<Integer,Video>();
		IDActual=0;
	}
	public Integer getNewID(){
		System.out.println("cree un video");
		return ++IDActual;
	}
	
	public static VideoHandler getInstance() {
		if (instancia == null)
			instancia = new VideoHandler();
		return instancia;
	}
	
	public void addVideo(Video v) {
		videos.put(IDActual, v);
	}
	
	public void removerVideo(Video v) {
		videos.remove(v.getIDVideo());
	}
	
	public Video find(Integer i) {
		return videos.get(i);
	}
	
	public DtVideo[] listarVideos() {
		DtVideo[] infoVideos = new DtVideo[videos.size()];
		Integer contador = 0;
		for(Map.Entry<Integer, Video> entry : videos.entrySet()) {
			DtVideo infoV=new DtVideo(entry.getValue());
			infoVideos[contador] = infoV;
			contador++;
		}
		return infoVideos;
	}
	
	
	

}
