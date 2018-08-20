package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class SystemHandler {
	private static SystemHandler instance = null;
	private Map<String,DtListaReproduccion> listasDefault;
	private int id_comentario = 0;
	
	private SystemHandler() {
		listasDefault = new HashMap<String,DtListaReproduccion>();
	}
	
	public static SystemHandler getInstance(){
		if(instance == null) instance = new SystemHandler();
		return instance;
	}
	
	public int recibirId_Comentario() {
		int aux = id_comentario;
		id_comentario++;
		return aux;
	}//devuelve una key 

	public void aniadirListaDefault(DtListaReproduccion dt) {
		listasDefault.put(dt.getNombre(), dt);
	}
	
	
	
	public void removerListaDefault(String n) {
		listasDefault.remove(n);
	}
	
	public void memberListaDefault(DtListaReproduccion dt) {
		listasDefault.containsKey(dt.getNombre());
	}
	
	public Boolean memberListaReproduccionDefecto(String nombreLista) {
		return listasDefault.containsKey(nombreLista);
	}
	
	public DtListaReproduccion getLista(String n) {
		return listasDefault.get(n);
	}
	
	public DtListaReproduccion[] obtenerListasReproduccion(){
		DtListaReproduccion[] dtListas = new DtListaReproduccion[listasDefault.size()];
		int contador = 0;
		for(Map.Entry<String, DtListaReproduccion> entry : listasDefault.entrySet()) {
			dtListas[contador] = entry.getValue();
			contador++;
		}
		return dtListas;
	}
	
}
