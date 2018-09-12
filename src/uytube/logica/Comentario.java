package uytube.logica;
import java.util.HashMap;
import java.util.Map;
public class Comentario {
	private Integer iDComentario;
	private String texto;
	private DtFecha fecha;
	private boolean esPadre;
	private Map<Integer, Comentario> respuestas;
	private Usuario usuarioComentador;
	
	public Comentario(Integer idComentario, String text, DtFecha fech, boolean privacity, String nombreUsuarioComentador){
		iDComentario=idComentario;
		texto=text;
		fecha=fech;
		esPadre=privacity;
		respuestas=new HashMap<Integer, Comentario>();
		UsuarioHandler manejadorUsuario=UsuarioHandler.getInstance();
		Usuario user=manejadorUsuario.find(nombreUsuarioComentador);
		usuarioComentador=user;
	}
	
	
	public Integer getIDComentario(){
		return iDComentario;
	}

	public String getTexto(){
		return texto;
	}

	public DtFecha getFecha(){
		return fecha;
	}

	public boolean getEsPadre(){
		return esPadre;
	}

	public void addComentario(Comentario coment){
		respuestas.put(coment.getIDComentario(), coment);
	}
	public Usuario getUsuario(){
		return usuarioComentador;
	}

	public DtComentario[] getDtRespuestas(){
		DtComentario[] res=new DtComentario[respuestas.size()];
		int contador =0;
		
		for (Map.Entry<Integer, Comentario> entry : respuestas.entrySet()) {
			res[contador] = new DtComentario(entry.getValue());
			contador++;
		}
		return res;
	}
	
}
