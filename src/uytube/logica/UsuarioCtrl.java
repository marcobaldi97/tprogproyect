package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;



public class UsuarioCtrl implements IUsuarioCtrl {
	private static UsuarioCtrl instance = null;
	private UsuarioHandler usuarioh;
	private SystemHandler systemh;

	public Boolean memberListaReproduccionDefecto(String nombreLista) {
		return systemh.memberListaReproduccionDefecto(nombreLista);
	}

	public Boolean memberUsuario(String nickU) {
		return usuarioh.memberNickname(nickU);
	}

	private UsuarioCtrl() {
		usuarioh = UsuarioHandler.getInstance();
		systemh = SystemHandler.getInstance();
	}

	public Boolean memberListaReproduccionPropia(String nickU, String nombreLista) {
		UsuarioHandler uh = UsuarioHandler.getInstance();
		Usuario u = uh.find(nickU);
		return u.memberListaReproduccionPropia(nombreLista);
	}

	public static UsuarioCtrl getInstance() {
		if (instance == null)
			instance = new UsuarioCtrl();
		return instance;
	}

	public String[] listarNicknamesUsuarios() {
		return usuarioh.listarNicknamesUsuarios();
	}

	public String[] listarVideosCanal(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.listarVideosCanal();
	}

	public boolean nuevaListaPorDefecto(String nombreL) {
		boolean foundName = false;
		String[] nicks = usuarioh.listarNicknamesUsuarios();
		int i = 0;
		while (!foundName && i < nicks.length) {
			Usuario usu = usuarioh.find(nicks[i]);
			if (usu.memberListaReproduccionPropia(nombreL)) {
				foundName = true;
			}
			i++;
		}
		if (!foundName) {
			DtListaReproduccion listaNueva = new DtListaReproduccion(nombreL);
			systemh.aniadirListaDefault(listaNueva);
			for (String nick : nicks) {
				Usuario u = usuarioh.find(nick);
				u.nuevaListaPorDefecto(nombreL);
			}
		}
		return !foundName;

	}

	public void nuevaListaParticular(String nickU, String nombreL, Boolean privada) {
		Usuario u = usuarioh.find(nickU);
		u.nuevaListaParticular(nombreL, nickU, privada);
	}

	public String[] listarLDRdeUsuario(String nickU) {
		Usuario u = usuarioh.find(nickU);
		return u.listarListasReproduccion();
	}

	public void agregarVideoLista(String nickU, Integer id_video, String nombreLDR) {
		Usuario u = usuarioh.find(nickU);
		u.agregarVideoLDR(id_video, nombreLDR);
	}// comentarle a Carmona sobre el cambio con la id.

	public void eliminarVideoLista(String nickU, Integer id_video, String nombreLDR) {
		Usuario u = usuarioh.find(nickU);
		u.eliminarVideoLista(id_video, nombreLDR);

	}

	public void cambiarPrivLDR(String nickU, String nombreL, Boolean privE) {
		Usuario u = usuarioh.find(nickU);
		u.cambiarPrivLDR(nombreL, privE);
	}

	public void editarDatosUsuario(String nickU, String nom, String ape, DtFecha fn, byte[] fo) {
		Usuario u = usuarioh.find(nickU);
		u.editarDatosUsuario(nom, ape, fn, fo);
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

	public void aniadirVideo(String nickU, String nom, String desc, Integer dur, DtFecha fp, String url,
			DtCategoria catE, Privacidad p) {
		Usuario u = usuarioh.find(nickU);
		u.aniadirVideo(nom, nickU, desc, dur, fp, url, catE, p);
	}

	public void ingresarNuevosDatosVideo(String nickU, String nom, String d, int dur, DtFecha fp, String url,
			DtCategoria catE, Privacidad p) {
		Usuario u = usuarioh.find(nickU);
		u.ingresarNuevosDatosVideo(nom, d, dur, fp, url, catE, p);
	}

	public Boolean verificarDispUsuario(String nickU, String email) {
		Boolean flag = (usuarioh.memberNickname(nickU) || usuarioh.memberEmail(email));
		return !flag;
	}// true si está disponible, false si ya está ocupado

	public void nuevoUsuario(String nick, String nom, String ape, String e, DtFecha fn, byte[] fo, String nombreCanal,
			String desc, Privacidad privacidadE, String catE) {
		Usuario u = new Usuario(nick, nom, ape, e, fn, fo, nombreCanal, desc, privacidadE, catE);
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

	public DtVideo obtenerInfoAdicVideo(String nickname, String nombreVideo) {
		Usuario u = usuarioh.find(nickname);
		return u.obtenerInfoAdicVideo(nombreVideo);
	}

	public Boolean memberVideoEnUsuario(String nickname, String nombreVideo) {
		Usuario u = usuarioh.find(nickname);
		return u.memberVideoEnUsuario(nombreVideo);
	}

	public String[] listarUsuariosQueSigue(String nickname) {
		Usuario u = usuarioh.find(nickname);
		return u.listarUsuariosQueSigue();
	}

	public String[] listarUsuariosQueLeSigue(String nickname) {
		Usuario u = usuarioh.find(nickname);
		return u.listarUsuariosQueLeSigue();
	}

	public String[] listarVideosListaReproduccionUsuario(String nickname, String nombreLista) {
		Usuario u = usuarioh.find(nickname);
		return u.listarVideosListaReproduccionUsuario(nombreLista);
	}


	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nickname, String nombreLista) {
		Usuario u = usuarioh.find(nickname);
		return u.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(String nicknameUsuario, int idVideo, String nombreListaReproduccion) {
		Usuario u = usuarioh.find(nicknameUsuario);
		return u.memberVideoLista(idVideo,nombreListaReproduccion);
	}
	
	public void modificarDatosCanal(String nickname, String nombreCanal, String descripcion, Privacidad privacidad, String catE) {
		Usuario u = usuarioh.find(nickname);
		u.modificarDatosCanal(nombreCanal,descripcion,privacidad,catE);
	}
	
	public String[] listarLDRParticularesdeUsuario(String nickname) {
		Usuario u = usuarioh.find(nickname);
		return u.listarLDRParticularesdeUsuario();
	}
}
