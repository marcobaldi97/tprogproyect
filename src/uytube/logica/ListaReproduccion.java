package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public abstract class ListaReproduccion {
	private String nombre;
	private String propietario;
	private Map<Integer,Video> videos;
	private Map<String,Categoria> categorias;
	
	public ListaReproduccion(String nombLDR, String pro) {
		nombre=nombLDR;
		propietario=pro;
		videos = new HashMap<Integer,Video>();
		categorias = new HashMap<String,Categoria>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public abstract DtListaReproduccion verDetallesListareproduccion();
	
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
	
	public DtCategoria[] getInfoCategorias(){
		DtCategoria[] res=new DtCategoria[categorias.size()];
		int i=0;
		for(Map.Entry<String,Categoria> entry:categorias.entrySet()){
			res[i]=new DtCategoria(entry.getValue());
			i++;
		}
		return res;
	}

}
