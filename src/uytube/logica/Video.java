package uytube.logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Video {
	private Integer IDVideo;
	private String nombre;
	private String propietario;
	private String descripcion;
	private int duracion;
	private DtFecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	private boolean privacidad;
	private Map<Integer,Comentario> comentarios;
	private ArrayList<Puntuacion> puntuaciones;
	
	
	public Video(String n,String pro, String d, int dur, DtFecha fp, String url, DtCategoria c, boolean p) {
		VideoHandler vh=VideoHandler.getInstance();
		SystemHandler sh=SystemHandler.getInstance();
		IDVideo=vh.getNewID();
		nombre = n;
		setPropietario(pro);
		descripcion = d;
		duracion = dur;
		fecha_publicacion = fp;
		URL = url;
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(c!=null && ch.isMember(c.getNombre())){
				cat=ch.find(c.getNombre());//si la categoria existe la asigno, si no?
				cat.addVideo(this);
		}else
			cat=sh.getSinCat();
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
	
	public Categoria getObjetoCategoria(){
		return cat;
	}
	
	public void ingresarNuevosDatosVideo(String d, int dur, DtFecha fp, String url, DtCategoria c, boolean p) {
		SystemHandler sh=SystemHandler.getInstance();
		descripcion = d;
		duracion = dur;
		fecha_publicacion = fp;
		URL = url;
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(c!=null){
			if(ch.isMember(c.getNombre())){
				cat=ch.find(c.getNombre());//si la categoria existe la asigno, si no?
			}
			
		}else
			cat=sh.getSinCat();
		privacidad = p;
	}
	
	public DtComentario[] getComentarios(){
		Integer contador = 0;
		Integer tamanio=0;
		
		for(Map.Entry<Integer, Comentario> entry : comentarios.entrySet()) {
			if(entry.getValue().getEsPadre()){
				tamanio++;
			}
		}
		DtComentario[] res=new DtComentario[tamanio];
		for(Map.Entry<Integer, Comentario> entry : comentarios.entrySet()) {
			if(entry.getValue().getEsPadre()){
				res[contador]=new DtComentario(entry.getValue());
				contador++;
			}
		}
		return res;
	}
	public void nuevoComentario(String nickU,DtFecha fecha, String cont){
		SystemHandler sh=SystemHandler.getInstance();
		Comentario c=new Comentario(sh.recibirId_Comentario(), cont, fecha,true, nickU);
		comentarios.put(c.getIDComentario(), c);
	}
	
	public void responderComentario(Integer IDCR,String nickU,DtFecha fecha,String cont){
		//esto cambia del DCC porque tengo un map, asi que no tengo que iterar todo para buscar
		SystemHandler sh=SystemHandler.getInstance();
		if(comentarios.containsKey(IDCR)){
			Comentario c=comentarios.get(IDCR);
			Comentario cn=new Comentario(sh.recibirId_Comentario(), cont, fecha,false, nickU);
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
		int puntSize=0;
		for(Puntuacion p:puntuaciones){
			if(p.getValoracion()==v)
				puntSize++;
		}
		DtUsuario[] usu=new DtUsuario[puntSize];
		int i=0;
		for(Puntuacion p :puntuaciones){
			if(p.getValoracion()==v){
				usu[i]=(new DtUsuario(p.getUsuario()));
				i++;
			}
			
		}
		return usu;
	}
	
	public DtInfoVideo getInfoVideoExt(){
		DtInfoVideo res=new DtInfoVideo(this);
		return res;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

}
