package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class SystemHandler {
	public enum Privacidad{
		PRIVADO,
		PUBLICO;
	}
	private static SystemHandler instance = null;
	private Map<String,DtListaReproduccion> listasDefault;
	private int id_comentario = 0;
	private Categoria sinCat=new Categoria("Sin Categoria");
	
	private SystemHandler() {
		listasDefault = new HashMap<String,DtListaReproduccion>();
	}
	public Categoria getSinCat(){
		return sinCat;
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

	public void aniadirListaDefault(DtListaReproduccion nuevaListaPorDefecto) {
		listasDefault.put(nuevaListaPorDefecto.getNombre(), nuevaListaPorDefecto);
	}
	
	
	
	public void removerListaDefault(String nombreLista) {
		listasDefault.remove(nombreLista);
	}
	
	public void memberListaDefault(DtListaReproduccion infoListaPorDefecto) {
		listasDefault.containsKey(infoListaPorDefecto.getNombre());
	}
	
	public Boolean memberListaReproduccionDefecto(String nombreLista) {
		return listasDefault.containsKey(nombreLista);
	}
	
	public DtListaReproduccion getLista(String nombreLista) {
		return listasDefault.get(nombreLista);
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
