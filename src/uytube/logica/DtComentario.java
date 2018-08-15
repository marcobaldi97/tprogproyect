package uytube.logica;

public class DtComentario {
	private Integer IDComentario;
	private String texto;
	private DtFecha fecha;
	private boolean esPadre;
	
	public Integer getIDComentario(){
		return IDComentario;
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
	public DtComentario(Comentario c){
		IDComentario=c.getIDComentario();
		texto=c.getTexto();
		fecha=c.getFecha();
		esPadre=c.getEsPadre();
	}
}

