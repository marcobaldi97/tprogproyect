package uytube.logica;

public class VideoCtrl implements IVideoCtrl{
	private static VideoCtrl instance = null; 
	
	private VideoCtrl() {
	}
	
	public static VideoCtrl getInstance() {
		if (instance == null) instance = new VideoCtrl();
		return instance;
	}
	public DtListaReproduccion [] listarLDRPorCategoria(String cat) 
	{
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(ch.isMember(cat)){
			Categoria cate=ch.find(cat);
			return cate.listarLDR();
		}
		else return null;
	}
	public DtVideo[] listarVideosPorCategoria(String cat){
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(ch.isMember(cat)){
			Categoria cate=ch.find(cat);
			return cate.listarVideos();
		}
		else return null;
	}
	public DtComentario[] listarComentarios(Integer IDVideo){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		return v.getComentarios();
	}
	public void nuevoComentario(Integer IDVideo,String nickU,DtFecha fecha,String contenido){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		v.nuevoComentario(nickU, fecha, contenido);
	}
	public void responderComentario(Integer IDVideo, Integer IDCR, String nickU, DtFecha fecha, String contenido){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		v.responderComentario(IDCR, nickU, fecha, contenido);
	}
	public void valorarVideo(Integer IDVideo, String nickU, boolean valoracion){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		v.valorarVideo(nickU, valoracion);
	}
	public DtInfoVideo verDetallesVideoExt(Integer IDVideo){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		return v.getInfoVideoExt();
	}
	public DtVideo infoAddVideo(Integer IDVideo){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		return v.verDetallesVideo();
	}
	public DtVideo[] listarVideos(){
		VideoHandler vh=VideoHandler.getInstance();
		return vh.listarVideos();
	}
	public DtCategoria[] listarCategorias(){
		CategoriaHandler ch=CategoriaHandler.getInstance();
		return ch.listarCategorias();
	}
	public void crearCategoria(String nombreCat){
		CategoriaHandler ch=CategoriaHandler.getInstance();
		if(!ch.isMember(nombreCat)){
			Categoria c=new Categoria(nombreCat);
			ch.addCategoria(c);
		}
	}
	public boolean existeCategoria(String nombreCat){
		CategoriaHandler ch=CategoriaHandler.getInstance();
		return ch.isMember(nombreCat);
	}
}
