package uytube.logica;


public class DtInfoVideo {
	private DtVideo infoVideo;
	private DtComentario[] comentarios;
	private DtUsuario[] usuariosGusta;
	private DtUsuario[] usuariosNoGusta;
	
	public DtVideo getInfoVideo(){
		return infoVideo;
	}
	public DtComentario[] getComentarios(){
		return comentarios;
	}
	public DtUsuario[] getUsuariosGusta(){
		return usuariosGusta;
	}
	public DtUsuario[] getUsuariosNoGusta(){
		return usuariosNoGusta;
	}
	public DtInfoVideo(Video v){
		infoVideo=new DtVideo(v);
		comentarios=v.getComentarios();
		usuariosGusta=v.getUsuariosPuntuadores(true);
		usuariosNoGusta=v.getUsuariosPuntuadores(false);
	}
	
}
