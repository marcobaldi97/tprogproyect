package uytubeLogic.logica;

public class DtComentario {
	private Integer idComentario;
	private String texto;
	private DtFecha fecha;
	private String nickUsuario;
	private boolean esPadre;
	private DtComentario[] respuestas;
	private byte[] fotoDuenio;

	public Integer getIDComentario() {
		return idComentario;
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

	public String getNickUsuario() {
		return nickUsuario;
	}

	public String getTexto() {
		return texto;
	}

	public DtFecha getFecha() {
		return fecha;
	}

	public boolean getEsPadre() {
		return esPadre;
	}

	public DtComentario[] getRespuestas() {
		return respuestas;
	}

	public byte[] getFotoUsuarioComentador() {
		return fotoDuenio;
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

	public boolean equals(DtComentario dataTipo) {
		return (idComentario == dataTipo.idComentario) && (texto == dataTipo.getTexto())
				&& (fecha.equals(dataTipo.getFecha()) && (esPadre == dataTipo.getEsPadre())
						&& (nickUsuario == dataTipo.getNickUsuario()));
	}
}
