package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public abstract class ListaReproduccion {
	protected String nombre;//Esto puede ser un error.
	protected Map<String,Video> videos;
	protected Map<String,Categoria> categorias;
	
	
	public ListaReproduccion() {
		videos = new HashMap<String,Video>();
		categorias = new HashMap<String,Categoria>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}
	
	public String[] listarVideos(){
		String[] nombreVideos = new String[videos.size()];
		Integer contador = 0;
		for(Map.Entry<String, Video> entry : videos.entrySet()) {
			nombreVideos[contador] = entry.getKey();
			contador++;
		}
		return nombreVideos;
	}
	
	private void refresacarCategorias(){
		for(Map.Entry<String, Video> entry : videos.entrySet()) {
			categorias.put(entry.getKey(), entry.getValue().getObjetoCategoria());
		}		
	}

	public void agregarVideo(String nombreVideo) {
		
	};

}
