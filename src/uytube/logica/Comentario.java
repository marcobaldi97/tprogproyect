package uytube.logica;
import java.util.HashMap;
import java.util.Map;
public class Comentario {
	private Integer IDComentario;
	private String texto;
	private DtFecha fecha;
	private boolean esPadre;
	private Map<Integer,Comentario> respuestas;
	private Usuario usuarioComentador;
	
	public Comentario(Integer ID, String t,DtFecha f,boolean p, Usuario u){
			IDComentario=ID;
			texto=t;
			fecha=f;
			esPadre=p;
			respuestas=new HashMap<Integer,Comentario>();
			usuarioComentador=u;
	}
	public Comentario(Integer ID, String t,DtFecha f,boolean p, String u){
		IDComentario=ID;
		texto=t;
		fecha=f;
		esPadre=p;
		respuestas=new HashMap<Integer,Comentario>();
		UsuarioHandler uh=UsuarioHandler.getInstance();
		Usuario usu=uh.find(u);
		usuarioComentador=usu;
	}
	
	
	public Integer getIDComentario(){
		return IDComentario;
	}
	public void setIDComentario(Integer i){
		IDComentario=i;
	}
	public String getTexto(){
		return texto;
	}
	public void setTexto(String t){
		texto=t;
	}public DtFecha getFecha(){
		return fecha;
	}
	public void setFecha(DtFecha f){
		fecha=f;
	}public boolean getEsPadre(){
		return esPadre;
	}
	public void setEsPadre(boolean p){
		esPadre=p;
	}
	public void addComentario(Comentario c){
		respuestas.put(c.getIDComentario(), c);
	}
	public Usuario getUsuario(){
		return usuarioComentador;
	}
	public void setUsuario(Usuario u){
		usuarioComentador=u;
	}
	public DtComentario[] getDtRespuestas(){
		DtComentario[] res=new DtComentario[respuestas.size()];
		int contador =0;
		
		for(Map.Entry<Integer, Comentario> entry : respuestas.entrySet()) {
			res[contador] = new DtComentario(entry.getValue());
			contador++;
		}
		return res;
	}
	
}
