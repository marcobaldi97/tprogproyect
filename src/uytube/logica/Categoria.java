package uytube.logica;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Categoria {
	private String nombre;
	private Map<String,Video> videos;
	private Map<String,ListaReproduccion> LDR;
	
	public Categoria(String n) {
		nombre = n;
		videos = new HashMap<String,Video>();
		LDR=new HashMap<String,ListaReproduccion>();
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
		DtCategoria dt = new DtCategoria(nombre);
		return dt;
	}

	
}
