package uytube.logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Video {
	private Integer IDVideo;
	private String nombre;
	private String descripcion;
	private int duracion;
	private DtFecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	private boolean privacidad;
	private Map<Integer,Comentario> comentarios;
	private ArrayList<Puntuacion> puntuaciones;
	
	public Video(String n, String d, int dur, DtFecha fp, String url, DtCategoria c, boolean p) {
		VideoHandler vh=VideoHandler.getInstance();
		IDVideo=vh.getNewID();
		nombre = n;
		descripcion = d;
		duracion = dur;
		fecha_publicacion = fp;
		URL = url;
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(ch.isMember(c.getNombre()))
			cat=ch.find(c.getNombre());//si la categoria existe la asigno, si no?
		privacidad = p;
		comentarios=new HashMap<Integer,Comentario>();
		puntuaciones=new ArrayList<Puntuacion>();
		vh.addVideo(this);
		
	}
	public Integer getIDVideo(){
		return IDVideo;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public int getDuracion(){
		return duracion;
	}
	public DtFecha getFechaPublicacion(){
		return fecha_publicacion;
	}
	public String getURL(){
		return URL;
	}
	public DtCategoria getCategoria(){
		DtCategoria res=new DtCategoria(cat);
		return res;
	}
	public boolean getPrivacidad(){
		return privacidad;
	}
	
	public void ingresarNuevosDatosVideo(String d, int dur, DtFecha fp, String url, DtCategoria c, boolean p) {
		descripcion = d;
		duracion = dur;
		fecha_publicacion = fp;
		URL = url;
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(ch.isMember(c.getNombre()))
			cat=ch.find(c.getNombre());
		privacidad = p;
	}
	
	public DtComentario[] getComentarios(){
		Integer contador = 0;
		DtComentario[] res=new DtComentario[comentarios.size()];
		for(Map.Entry<Integer, Comentario> entry : comentarios.entrySet()) {
			res[contador] = new DtComentario(entry.getValue());
			contador++;
		}
		return res;
	}
	public void nuevoComentario(String nickU,DtFecha fecha, String cont){
		//por ahora no se de donde sacar el IDComentario asi que les pongo 1
		Comentario c=new Comentario(1, cont, fecha,true, nickU);
		comentarios.put(c.getIDComentario(), c);
	}
	
	public void responderComentario(Integer IDCR,String nickU,DtFecha fecha,String cont){
		//esto cambia del DCC porque tengo un map, asi que no tengo que iterar todo para buscar
		//por ahora no se de donde sacar el IDComentario asi que les pongo 2
		if(comentarios.containsKey(IDCR)){
			Comentario c=comentarios.get(IDCR);
			Comentario cn=new Comentario(2, cont, fecha,false, nickU);
			c.addComentario(cn);
			comentarios.put(cn.getIDComentario(), cn);
		}
	}
	public DtPuntuacion[] getPuntuaciones(){
		DtPuntuacion[] puntajes=new DtPuntuacion[puntuaciones.size()];
		for(int i=0;i<puntuaciones.size();i++){
			Puntuacion p= puntuaciones.get(i);
			puntajes[i]=new DtPuntuacion(p);
		}
		return puntajes;
		
	}
	public void addPuntuacion(Puntuacion p){
		puntuaciones.add(p);
	}
	
	public DtVideo verDetallesVideo() {
		DtVideo dt = new DtVideo(this);
		return dt;
	}
	
	public void valorarVideo(String nickU,boolean valoracion){
		int i=0;
		while(i<puntuaciones.size()&&puntuaciones.get(i).getNickPuntuador()!=nickU){
			i++;
		}
		if(i<puntuaciones.size()){
			puntuaciones.get(i).setValoracion(valoracion);
		}else{
			Puntuacion p=new Puntuacion(nickU,valoracion);
			puntuaciones.add(p);
		}
		
	}
	
	public DtUsuario[] getUsuariosPuntuadores(boolean v){
		ArrayList<DtUsuario> usu=new ArrayList<DtUsuario>();
		for(Puntuacion p :puntuaciones){
			if(p.getValoracion()==v)
				usu.add(new DtUsuario(p.getUsuario()));
		}
		return (DtUsuario[]) usu.toArray();
	}
	
	public DtInfoVideo getInfoVideoExt(){
		DtInfoVideo res=new DtInfoVideo(this);
		return res;
	}

}
