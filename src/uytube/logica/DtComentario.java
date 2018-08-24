package uytube.logica;

public class DtComentario {
	private Integer IDComentario;
	private String texto;
	private DtFecha fecha;
	private String nickUsuario;
	private boolean esPadre;
	private DtComentario[] respuestas;
	
	
	public Integer getIDComentario(){
		return IDComentario;
	}
	public String getNickUsuario(){
		return nickUsuario;
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
	public DtComentario[] getRespuestas(){
		return respuestas;
	}
	public DtComentario(Comentario c){
		IDComentario=c.getIDComentario();
		texto=c.getTexto();
		fecha=c.getFecha();
		esPadre=c.getEsPadre();
		respuestas=c.getDtRespuestas();
		nickUsuario=c.getUsuario().getNickname();
	}
}

