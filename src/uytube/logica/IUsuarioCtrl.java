package uytube.logica;

public interface IUsuarioCtrl {
	
	public abstract String[] listarNicknamesUsuarios();
	
	public abstract String[] listarVideosCanal(String nickU) ;
	
	public abstract void nuevaListaPorDefecto(String nombreL) ;
	
	public abstract void nuevaListaParticular(String nickU, String nombreL, Boolean privada) ;
	
	public abstract String[] listarLDRdeUsuario(String nickU) ;
	
	public abstract void agregarVideoLista(String nickU, Integer id_video, String nombreLDR) ;
	
	public abstract  void cambiarPrivLDR(String nickU, String nombreL, Boolean privE) ;
	
	public abstract void seguirUsuario(String Usu1, String Usu2) ;
	
	public abstract void dejarUsuario(String Usu1, String Usu2) ;
	
	public abstract void aniadirVideo(String nickU, String nom, String desc, Integer dur, DtFecha fp, String url, DtCategoria catE, boolean p);
	
	public abstract void ingresarNuevosDatosVideo(String nickU, String nom, String d, int dur, DtFecha fp, String url, DtCategoria catE, boolean p);
	
	public abstract Boolean verificarDispUsuario(String nickU, String email);
	
	public abstract void nuevoUsuario(String nick,String nom, String ape, String e, DtFecha fn, String fo, String nombreCanal, String desc,Boolean privacidadE, String catE) ;
	
	public abstract DtListaReproduccion infoAdicLDR(String nickU, String nombreL) ;
	
	public abstract DtUsuario listarDatosUsuario(String nickU);
	
	public abstract DtCanal mostrarInfoCanal(String nickU);

	public abstract Boolean memberListaReproduccionDefecto(String nombreLista);

	public abstract Boolean memberListaReproduccionPropia(String nickU, String nombreLista);


}
