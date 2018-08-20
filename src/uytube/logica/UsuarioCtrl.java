package uytube.logica;

public class UsuarioCtrl implements IUsuarioCtrl {
	private static UsuarioCtrl instance = null; 
	private UsuarioHandler usuarioh;
	private SystemHandler systemh;
	
	private UsuarioCtrl() {
		usuarioh = UsuarioHandler.getInstance();
		systemh = SystemHandler.getInstance();
	}
	
	public static UsuarioCtrl getInstance() {
		if (instance == null) instance = new UsuarioCtrl();
		return instance;
	}
	
	public String[] listarNicknamesUsuarios() {
		return usuarioh.listarNicknamesUsuarios();
	}
	
	public String[] listarVideosCanal(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.listarVideosCanal();
	}
	
	public void nuevaListaPorDefecto(String nombreL) {
		DtListaReproduccion listaNueva = new DtListaReproduccion(nombreL);
		systemh.aniadirListaDefault(listaNueva);
	}
	
	public void nuevaListaParticular(String nickU, String nombreL, Boolean privada) {
		Usuario u = usuarioh.find(nickU);
		u.nuevaListaParticular(nombreL, privada);
	}
	
	public String[] listarLDRdeUsuario(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.listarListasReproduccion();
	}
	
	public void agregarVideoLista(String nickU, Integer id_video, String nombreLDR) {
		Usuario u = usuarioh.find(nickU);
		u.agregarVideoLDR(id_video, nombreLDR);
	}//comentarle a Carmona sobre el cambio con la id.
	
	public void eliminarVideoLista(String nickU, Integer id_video, String nombreLDR){
		Usuario u=usuarioh.find(nickU);
		u.eliminarVideoLista(id_video, nombreLDR);
		
	}
	
	public void cambiarPrivLDR(String nickU, String nombreL, Boolean privE) {
		Usuario u = usuarioh.find(nickU);
		u.cambiarPrivLDR(nombreL, privE);
	}
	
	public void seguirUsuario(String Usu1, String Usu2) {
		Usuario uraiz = usuarioh.find(Usu1);
		Usuario udestino = usuarioh.find(Usu2);
		uraiz.aniadirUsuarioASeguir(udestino);
		udestino.aniadirUsuarioQueLeSigue(uraiz);
	}
	
	public void dejarUsuario(String Usu1, String Usu2) {
		Usuario uraiz = usuarioh.find(Usu1);
		Usuario udestino = usuarioh.find(Usu2);
		uraiz.removerUsuarioASeguir(udestino);
		udestino.removerUsuarioQueLeSigue(uraiz);
	}
	
	public void aniadirVideo(String nickU, String nom, String desc, Integer dur, DtFecha fp, String url, DtCategoria catE, boolean p) {
		Usuario u = usuarioh.find(nickU);
		u.aniadirVideo(nom, desc, dur, fp, url, catE, p);
	}
	
	public void ingresarNuevosDatosVideo(String nickU, String nom, String d, int dur, DtFecha fp, String url, DtCategoria catE, boolean p) {
		Usuario u = usuarioh.find(nickU);
		u.ingresarNuevosDatosVideo(nom, d, dur, fp, url, catE, p);
	}
	
	public Boolean verificarDispUsuario(String nickU, String email) {
		Boolean flag = (usuarioh.memberNickname(nickU) || usuarioh.memberEmail(email));
		return !flag;
	}//true si está disponible, false si ya está ocupado
	
	public void nuevoUsuario(String nick,String nom, String ape, String e, DtFecha fn, String fo,String nombreCanal,String desc,Boolean privacidadE, String catE) {
		Usuario u = new Usuario(nick,nom,ape,e,fn,fo,nombreCanal,desc,privacidadE,catE);
		usuarioh.aniadirUsuario(u);
	}
	
	public DtListaReproduccion infoAdicLDR(String nickU, String nombreL) {
		Usuario u = usuarioh.find(nickU);
		return u.verDetallesListareproduccion(nombreL);
	}
	
	public DtUsuario listarDatosUsuario(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.listarDatosUsuario();
	}
	
	public DtCanal mostrarInfoCanal(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.mostrarInfoCanal();
	}
	
}
