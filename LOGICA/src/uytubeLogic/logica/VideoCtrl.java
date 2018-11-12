package uytubeLogic.logica;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class VideoCtrl implements IVideoCtrl {
	private static VideoCtrl instance = null;

	private VideoCtrl() {
	}

	public static VideoCtrl getInstance() {
		if (instance == null)
			instance = new VideoCtrl();
		return instance;
	}

	public DtListaReproduccion[] listarLDRPorCategoria(String cat, Privacidad priv, String nomU) {
		CategoriaHandler CatHandler = CategoriaHandler.getInstance();
		if (CatHandler.isMember(cat)) {
			Categoria cate = CatHandler.find(cat);
			return cate.listarLDR(priv,nomU);
		} else
			return null;
	}

	public DtVideo[] listarVideosPorCategoria(String cat, Privacidad priv, String nomU) {
		CategoriaHandler CatHandler = CategoriaHandler.getInstance();
		if (CatHandler.isMember(cat)) {
			Categoria cate = CatHandler.find(cat);
			return cate.listarVideos(priv,nomU);
		} else
			return null;
	}

	public DtComentario[] listarComentarios(Integer IDVideo) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		return videoEspecifico.getComentarios();
	}

	public void nuevoComentario(Integer IDVideo, String nickU, DtFecha fecha, String contenido) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		videoEspecifico.nuevoComentario(nickU, fecha, contenido);
	}

	public void responderComentario(Integer IDVideo, Integer IDCR, String nickU, DtFecha fecha, String contenido) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		videoEspecifico.responderComentario(IDCR, nickU, fecha, contenido);
	}

	public void valorarVideo(Integer IDVideo, String nickU, boolean valoracion) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		videoEspecifico.valorarVideo(nickU, valoracion);
	}

	public DtInfoVideo verDetallesVideoExt(Integer IDVideo) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		return videoEspecifico.getInfoVideoExt();
	}

	public DtVideo infoAddVideo(Integer IDVideo) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		Video videoEspecifico = VidHandler.find(IDVideo);
		if(videoEspecifico!=null)
			return videoEspecifico.verDetallesVideo();
		else
			return null;
	}

	public DtVideo[] listarVideos() {
		VideoHandler VidHandler = VideoHandler.getInstance();
		return VidHandler.listarVideos();
	}

	public DtCategoria[] listarCategorias() {
		CategoriaHandler CatHandler = CategoriaHandler.getInstance();
		return CatHandler.listarCategorias();
	}

	public void crearCategoria(String nombreCat) {
		CategoriaHandler CatHandler = CategoriaHandler.getInstance();
		if (!CatHandler.isMember(nombreCat)) {
			Categoria nuevaCat = new Categoria(nombreCat);
			CatHandler.addCategoria(nuevaCat);
		}
	}

	public boolean existeCategoria(String nombreCat) {
		CategoriaHandler CatHandler = CategoriaHandler.getInstance();
		return CatHandler.isMember(nombreCat);
	}

	@Override
	public DtVideo[] listarVideosPublicosPorNombre(String nombre) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		return VidHandler.listarVideosPublicosPorNombre(nombre);
	}

	@Override
	public String getEstadoValoracion(Integer IDVideo, String nickUsuario) {
		String status = "";
		DtInfoVideo infoVideo = this.verDetallesVideoExt(IDVideo);
		DtUsuario[] usuariosLikes = infoVideo.getUsuariosGusta();
		DtUsuario[] usuariosDislikes = infoVideo.getUsuariosNoGusta();
		for (int index = 0; index < usuariosLikes.length; index++) {
			if (usuariosLikes[index].getNickname().equals(nickUsuario)) {
				status = "like";
			}
		}
		for (int index = 0; index < usuariosDislikes.length; index++) {
			if (usuariosDislikes[index].getNickname().equals(nickUsuario)) {
				status = "dislike";
			}
		}
		if (status == "")
			status = "neutral";
		return status;
	}

	public boolean memberVideo(Integer idVideo) {
		VideoHandler VidHandler = VideoHandler.getInstance();
		return VidHandler.find(idVideo)!=null;
	}
	
	

}
