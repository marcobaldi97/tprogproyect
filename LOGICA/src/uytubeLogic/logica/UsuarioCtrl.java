package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uytubeLogic.logica.SystemHandler.Privacidad;

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
		UsuarioHandler usuHandler = UsuarioHandler.getInstance();
		Usuario usuarioParticular = usuHandler.find(nickU);
		return usuarioParticular.memberListaReproduccionPropia(nombreLista);
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
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.listarVideosCanal();
	}

	public DtVideo[] infoVideosCanal(String nickU, Privacidad priv) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.infoVideosCanal(priv);
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
				Usuario usuarioParticular = usuarioh.find(nick);
				usuarioParticular.nuevaListaPorDefecto(nombreL);
			}
		}
		return !foundName;

	}

	public void nuevaListaParticular(String nickU, String nombreL, Privacidad privada) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.nuevaListaParticular(nombreL, nickU, privada);
	}

	public String[] listarLDRdeUsuario(String nickU) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.listarListasReproduccion();
	}

	public void agregarVideoLista(String nickU, Integer id_video, String nombreLDR) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.agregarVideoLDR(id_video, nombreLDR);
	}// comentarle a Carmona sobre el cambio con la id.

	public void eliminarVideoLista(String nickU, Integer id_video, String nombreLDR) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.eliminarVideoLista(id_video, nombreLDR);

	}

	public void cambiarPrivLDR(String nickU, String nombreL, Privacidad privE) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.cambiarPrivLDR(nombreL, privE);
	}

	public void editarDatosUsuario(String nickU, String nuevoNombreU, String nuevoApellidoU,
			DtFecha nuevaFechaNacimientoU, byte[] nuevaFotoU) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.editarDatosUsuario(nuevoNombreU, nuevoApellidoU, nuevaFechaNacimientoU, nuevaFotoU);
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

	public void aniadirVideo(String nickU, String nombreV, String descripcionV, Integer duracionV,
			DtFecha fechaPublicacion, String url, DtCategoria catE, Privacidad privacidadV) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		System.out.println("la url es "+url);
		if(url.contains("https://www.youtube.com/watch?v=")) {
			System.out.println("contiene el watch");
			url=url.replace("https://www.youtube.com/watch?v=", "https://www.youtube.com/embed/");
			System.out.println("ahora es " +url);
		}else if(url.contains("https://youtu.be/")) {
			System.out.println("contiene el punto");
			url=url.replace("https://youtu.be/" ,"https://www.youtube.com/embed/");
			System.out.println("ahora es " + url);
		}
		usuarioParticular.aniadirVideo(nombreV, nickU, descripcionV, duracionV, fechaPublicacion, url, catE,
				privacidadV);
	}

	public void ingresarNuevosDatosVideo(String nickU, String nuevoNombre, String nuevaDescripcion, int nuevaDuracion,
			DtFecha nuevaFechaPublicacion, String nuevaUrl, DtCategoria nuevaCat, Privacidad nuevaPrivacidad) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		usuarioParticular.ingresarNuevosDatosVideo(nuevoNombre, nuevaDescripcion, nuevaDuracion, nuevaFechaPublicacion,
				nuevaUrl, nuevaCat, nuevaPrivacidad);
	}

	public Boolean verificarDispUsuario(String nickU, String email) {
		Boolean flag = usuarioh.memberNickname(nickU) || usuarioh.memberEmail(email);
		return !flag;
	}// true si está disponible, false si ya está ocupado

	public void nuevoUsuario(String nickU, String pass,String nombreUsuario, String apellidoU, String emailU,
			DtFecha fechaNacimientoU, byte[] fotoU, String nombreCanal, String descripcionCanal,
			Privacidad privacidadCanal, String categoriaCanal) {
		Usuario usuarioParticular = new Usuario(nickU, pass,nombreUsuario, apellidoU, emailU, fechaNacimientoU, fotoU,
				nombreCanal, descripcionCanal, privacidadCanal, categoriaCanal);
		usuarioh.aniadirUsuario(usuarioParticular);
	}

	public DtListaReproduccion infoAdicLDR(String nickU, String nombreL) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.verDetallesListareproduccion(nombreL);
	}

	public DtUsuario listarDatosUsuario(String nickU) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.listarDatosUsuario();
	}

	public DtCanal mostrarInfoCanal(String nickU) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.mostrarInfoCanal();
	}

	public DtVideo obtenerInfoAdicVideo(String nickname, String nombreVideo) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.obtenerInfoAdicVideo(nombreVideo);
	}

	public Boolean memberVideoEnUsuario(String nickname, String nombreVideo) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.memberVideoEnUsuario(nombreVideo);
	}

	public String[] listarUsuariosQueSigue(String nickname) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.listarUsuariosQueSigue();
	}

	public String[] listarUsuariosQueLeSigue(String nickname) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.listarUsuariosQueLeSigue();
	}

	public String[] listarVideosListaReproduccionUsuario(String nickname, String nombreLista) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.listarVideosListaReproduccionUsuario(nombreLista);
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nickname, String nombreLista) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(String nicknameUsuario, int idVideo, String nombreListaReproduccion) {
		Usuario usuarioParticular = usuarioh.find(nicknameUsuario);
		return usuarioParticular.memberVideoLista(idVideo, nombreListaReproduccion);
	}

	public void modificarDatosCanal(String nickname, String nombreCanal, String descripcion, Privacidad privacidad,
			String catE) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		usuarioParticular.modificarDatosCanal(nombreCanal, descripcion, privacidad, catE);
	}

	public String[] listarLDRParticularesdeUsuario(String nickname) {
		Usuario usuarioParticular = usuarioh.find(nickname);
		return usuarioParticular.listarLDRParticularesdeUsuario();
	}
	public DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre) {
		
		return usuarioh.listarLDRPublicasPorNombre(nombre);
	}

	@Override
	public DtCanal[] listarCanalesPublicosPorNombre(String nombre) {

		return usuarioh.listarCanalesPublicosPorNombre(nombre);
	}

	@Override
	public DtListaReproduccion[] infoLDRdeUsuario(String nickU, Privacidad priv) {
		Usuario usuarioParticular = usuarioh.find(nickU);
		return usuarioParticular.infoLDRdeUsuario(priv);
	}

	public boolean verificarLogin(String nick,String pass) {
		Usuario usuarioParticular = usuarioh.find(nick);
		return(usuarioParticular!=null && usuarioParticular.getPassword().equals(pass));
	}
}
