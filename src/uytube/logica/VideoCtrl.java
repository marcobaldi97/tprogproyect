package uytube.logica;

public class VideoCtrl {
	
	DtListaReproduccion [] listarLDRPorCategoria(String cat) 
	{
		DtListaReproduccion [] resultado=null;
		
		return resultado;
	}
	public DtComentario[] listarComentarios(Integer IDVideo){
		VideoHandler vh=VideoHandler.getInstance();
		Video v=vh.find(IDVideo);
		return v.getComentarios();
	}
}
