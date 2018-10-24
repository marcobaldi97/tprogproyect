package uytubeLogic.logica;

public class DtInfoVideo {
	private DtVideo infoVideo;
	private DtComentario[] comentarios;
	private DtUsuario[] usuariosGusta;
	private DtUsuario[] usuariosNoGusta;

	
	public DtVideo getInfoVideo() {
		return infoVideo;
	}


	public void setInfoVideo(DtVideo infoVideo) {
		this.infoVideo = infoVideo;
	}


	public DtComentario[] getComentarios() {
		return comentarios;
	}


	public void setComentarios(DtComentario[] comentarios) {
		this.comentarios = comentarios;
	}


	public DtUsuario[] getUsuariosGusta() {
		return usuariosGusta;
	}


	public void setUsuariosGusta(DtUsuario[] usuariosGusta) {
		this.usuariosGusta = usuariosGusta;
	}


	public DtUsuario[] getUsuariosNoGusta() {
		return usuariosNoGusta;
	}


	public void setUsuariosNoGusta(DtUsuario[] usuariosNoGusta) {
		this.usuariosNoGusta = usuariosNoGusta;
	}


	public DtInfoVideo(Video videoBase) {
		infoVideo = new DtVideo(videoBase);
		comentarios = videoBase.getComentarios();
		usuariosGusta = videoBase.getUsuariosPuntuadores(true);
		usuariosNoGusta = videoBase.getUsuariosPuntuadores(false);
	}

}
