package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public abstract class ListaReproduccion {
	private String nombre;//Esto puede ser un error.
	private Map<String,Video> videos;
	
	public ListaReproduccion(String nombLDR) {
		nombre=nombLDR;
		videos = new HashMap<String,Video>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}
	
	public String[] listarVideos() 
	{
		String[] nombreVideos = new String[videos.size()];
		Integer contador = 0;
		for(Map.Entry<String, Video> entry : videos.entrySet()) {
			nombreVideos[contador] = entry.getKey();
			contador++;
		}
		return nombreVideos;
	}

	public void agregarVideo(String nombreVideo) {
		
		
	};

}
