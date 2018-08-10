package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class Categoria {
	private String nombre;
	private Map<String,Video> videos;
	
	public Categoria(String n) {
		nombre = n;
		videos = new HashMap<String,Video>();
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
	
	public DtCategoria getInfoCategoria() { 
		DtCategoria dt = new DtCategoria(nombre);
		return dt;
	}
	
}
