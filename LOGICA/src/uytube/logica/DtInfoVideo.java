package uytube.logica;

public class DtInfoVideo {
	private DtVideo infoVideo;
	private DtComentario[] comentarios;
	private DtUsuario[] usuariosGusta;
	private DtUsuario[] usuariosNoGusta;

	public DtVideo getInfoVideo() {
		return infoVideo;
	}

	public DtComentario[] getComentarios() {
		return comentarios;
	}

	public DtUsuario[] getUsuariosGusta() {
		return usuariosGusta;
	}

	public DtUsuario[] getUsuariosNoGusta() {
		return usuariosNoGusta;
	}

	public DtInfoVideo(Video videoBase) {
		infoVideo = new DtVideo(videoBase);
		comentarios = videoBase.getComentarios();
		usuariosGusta = videoBase.getUsuariosPuntuadores(true);
		usuariosNoGusta = videoBase.getUsuariosPuntuadores(false);
	}

}
