package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public abstract class ListaReproduccion {
	protected String nombre;//Esto puede ser un error.
	protected Map<Integer,Video> videos;
	protected Map<String,Categoria> categorias;
	
	
	public ListaReproduccion() {
		videos = new HashMap<Integer,Video>();
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
		for(Map.Entry<Integer, Video> entry : videos.entrySet()) {
			nombreVideos[contador] = entry.getValue().getNombre();
			contador++;
		}
		return nombreVideos;
	}
	
	private void refrescarCategorias(){
		for(Map.Entry<Integer, Video> entry : videos.entrySet()) {
			categorias.put(entry.getValue().getObjetoCategoria().getNombre(), entry.getValue().getObjetoCategoria());
		}		
	}
	
	public void removerVideo(Integer id) {
		String categoriaNombre = videos.get(id).getCategoria().getNombre();
		categorias.remove(categoriaNombre);		
		videos.remove(id);
		refrescarCategorias();
	}

	public void agregarVideo(Video v) {
		videos.put(v.getIDVideo(), v);
		refrescarCategorias();
	};

}
