package uytube.logica;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Categoria {
	private String nombre;
	private List <Video> videos;
	private List<ListaReproduccion> LDR;
	
	public Categoria(String n) {
		nombre = n;
		videos = new LinkedList<Video>();
		LDR=new LinkedList<ListaReproduccion>();
	}
	public void aniadirLDR(ListaReproduccion lr){
		if(!LDR.contains(lr)) {LDR.add(lr);}	
	}
	public void removerLDR(ListaReproduccion lr){
		LDR.remove(lr.getNombre());
	}
	public String getNombre() {
		return nombre;
	}
	
	public void addVideo(Video v) {
		if(!videos.contains(v)) {videos.add(v);}
		
	}
	
	public void removerVideo(Video v) {
		videos.remove(v.getNombre());
	}
	
	/*public Video find(String s) {
		return videos.get(s);
	}*/
	
	public DtCategoria getInfoCategoria() { 
		DtCategoria dt = new DtCategoria(this);
		return dt;
	}

	public DtVideo[] listarVideos() {
		DtVideo[] res=new DtVideo[videos.size()];
		Integer contador=0;
		for(Video v: videos) {
			res[contador] = new DtVideo(v);
			contador++;
		}
		return res;
	}
	public DtListaReproduccion[] listarLDR() {
		DtListaReproduccion [] res = new DtListaReproduccion[LDR.size()];
		Integer contador=0;
		for(ListaReproduccion ldr: LDR) 
		{
			res[contador]= ldr.verDetallesListareproduccion();
			contador++;
		}
		return res;
	}

	
}
