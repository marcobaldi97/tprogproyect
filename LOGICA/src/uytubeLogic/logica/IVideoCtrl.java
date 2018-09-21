package uytubeLogic.logica;

public interface IVideoCtrl {
	public abstract DtListaReproduccion[] listarLDRPorCategoria(String cat);

	public abstract DtVideo[] listarVideosPorCategoria(String cat);

	public abstract DtComentario[] listarComentarios(Integer IDVideo);

	public abstract void nuevoComentario(Integer IDVideo, String nickU,
			DtFecha fecha, String contenido);

	public abstract void responderComentario(Integer IDVideo, Integer IDCR,
			String nickU, DtFecha fecha, String contenido);

	public abstract void valorarVideo(Integer IDVideo, String nickU,
			boolean valoracion);

	public abstract DtInfoVideo verDetallesVideoExt(Integer IDVideo);

	public abstract DtVideo infoAddVideo(Integer IDVideo);

	public abstract DtVideo[] listarVideos();

	public abstract DtCategoria[] listarCategorias();

	public abstract void crearCategoria(String nombreCat);

	public abstract boolean existeCategoria(String nombreCat);
	
	public abstract DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre);
	
	public abstract DtVideo[] listarVideosPublicosPorNombre(String nombre);
}
