package uytubeLogic.logica;

public class DtComentario {
	private Integer idComentario;
	private String texto;
	private DtFecha fecha;
	private String nickUsuario;
	private boolean esPadre;
	private DtComentario[] respuestas;
	private byte[] fotoDuenio;



	public Integer getIdComentario() {
		return idComentario;
	}



	public void setIdComentario(Integer idComentario) {
		this.idComentario = idComentario;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public DtFecha getFecha() {
		return fecha;
	}



	public void setFecha(DtFecha fecha) {
		this.fecha = fecha;
	}



	public String getNickUsuario() {
		return nickUsuario;
	}



	public void setNickUsuario(String nickUsuario) {
		this.nickUsuario = nickUsuario;
	}



	public boolean isEsPadre() {
		return esPadre;
	}



	public void setEsPadre(boolean esPadre) {
		this.esPadre = esPadre;
	}



	public DtComentario[] getRespuestas() {
		return respuestas;
	}



	public void setRespuestas(DtComentario[] respuestas) {
		this.respuestas = respuestas;
	}



	public byte[] getFotoDuenio() {
		return fotoDuenio;
	}



	public void setFotoDuenio(byte[] fotoDuenio) {
		this.fotoDuenio = fotoDuenio;
	}



	public Integer getTamanioArbol() {
		if (respuestas.length == 0) {
			return 1;
		} else {
			Integer cantRespuestas = 1;
			for (DtComentario entry : this.respuestas) {
				cantRespuestas = cantRespuestas + entry.getTamanioArbol();
			}
			return cantRespuestas;
		}
	}



	public DtComentario(Comentario comment) {
		nickUsuario = comment.getUsuario().getNickname();
		idComentario = comment.getIDComentario();
		texto = comment.getTexto();
		fecha = comment.getFecha();
		esPadre = comment.getEsPadre();
		respuestas = comment.getDtRespuestas();
		fotoDuenio = comment.getUsuario().getFoto();
	}

	public DtComentario() {
		// TODO Auto-generated constructor stub
	}



	public boolean equals(DtComentario dataTipo) {
		return (idComentario == dataTipo.idComentario) && (texto == dataTipo.getTexto())
				&& (fecha.equals(dataTipo.getFecha()) && (esPadre == dataTipo.isEsPadre())
						&& (nickUsuario == dataTipo.getNickUsuario()));
	}
}
