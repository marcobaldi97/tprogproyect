package uytube.logica;

public class UsuarioCtrl {
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
	
	public Usuario[] listarNicknamesUsuarios() {
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
		u.
	}

}
