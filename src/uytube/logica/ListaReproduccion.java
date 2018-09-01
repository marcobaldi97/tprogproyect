package uytube.logica;

import java.util.HashMap;
import java.util.Map;

public abstract class ListaReproduccion {
	private String nombre;
	private String propietario;
	private Map<Integer, Video> videos;
	private Map<String, Categoria> categorias;

	public ListaReproduccion(String nombLDR, String pro) {
		nombre = nombLDR;
		propietario = pro;
		videos = new HashMap<Integer, Video>();
		categorias = new HashMap<String, Categoria>();
	}
	public enum TipoLista{
		PORDEFECTO,
		PARTICULAR;
	}
	public String getNombre() {
		return nombre;
	}
	public void addVideoToMap(Video v){
		videos.put(v.getIDVideo(), v);
	}
	public void removeVideoFromMap(Integer id){
		videos.remove(id);
	}

	public abstract DtListaReproduccion verDetallesListareproduccion();

	public String[] listarVideos() {
		String[] nombreVideos = new String[videos.size()];
		Integer contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			nombreVideos[contador] = entry.getValue().getNombre();
			contador++;
		}
		return nombreVideos;
	}

	public void refrescarCategorias() {
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			Categoria categoria = entry.getValue().getObjetoCategoria();
			categoria.aniadirLDR(this);

			categorias.put(categoria.getNombre(), entry.getValue().getObjetoCategoria());
		}

	}

	public void removerVideo(Integer id) {
		Categoria categoria = videos.get(id).getObjetoCategoria();
		categorias.remove(categoria.getNombre());
		categoria.removerLDR(this);
		removeVideoFromMap(id);
		refrescarCategorias();
	}

	public abstract void agregarVideo(Video v);

	public DtCategoria[] getInfoCategorias() {
		DtCategoria[] res = new DtCategoria[categorias.size()];
		int i = 0;
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
			res[i] = new DtCategoria(entry.getValue());
			i++;
		}
		return res;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		DtVideo[] dtvideos = new DtVideo[videos.size()];
		int contador = 0;
		for (Map.Entry<Integer, Video> entry : videos.entrySet()) {
			DtVideo dt = new DtVideo(entry.getValue());
			dtvideos[contador] = dt;
			contador++;
		}
		return dtvideos;
	}

	public boolean existeVideo(Video video) {
		return videos.containsKey(video.getIDVideo());
	}

	public void removerCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		categorias.remove(cat.getNombre());
	}

}
