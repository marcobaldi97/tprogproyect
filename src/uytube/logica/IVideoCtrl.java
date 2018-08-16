package uytube.logica;

public interface IVideoCtrl {
	public DtListaReproduccion [] listarLDRPorCategoria(String cat);
	public DtVideo[] listarVideosPorCategoria(String cat);
	public DtComentario[] listarComentarios(Integer IDVideo);
	public void nuevoComentario(Integer IDVideo,String nickU,DtFecha fecha,String contenido);
	public void responderComentario(Integer IDVideo, Integer IDCR, String nickU, DtFecha fecha, String contenido);
	public void valorarVideo(Integer IDVideo, String nickU, boolean valoracion);
	public DtInfoVideo verDetallesVideoExt(Integer IDVideo);
	public DtVideo infoAddVideo(Integer IDVideo);
	public DtVideo[] listarVideos();
	public DtCategoria[] listarCategorias();
	public void crearCategoria(String nombreCat);
	public boolean existeCategoria(String nombreCat);
}
