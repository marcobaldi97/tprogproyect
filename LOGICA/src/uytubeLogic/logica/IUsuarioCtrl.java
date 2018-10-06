package uytubeLogic.logica;

import uytubeLogic.logica.SystemHandler.Privacidad;

public interface IUsuarioCtrl {

	public abstract String[] listarNicknamesUsuarios();

	public abstract String[] listarVideosCanal(String nickU);

	public abstract boolean nuevaListaPorDefecto(String nombreL);

	public abstract void nuevaListaParticular(String nickU, String nombreL,
			Privacidad privada);

	public abstract String[] listarLDRdeUsuario(String nickU);

	public abstract void agregarVideoLista(String nickU, Integer id_video,
			String nombreLDR);

	public abstract void cambiarPrivLDR(String nickU, String nombreL,
			Privacidad privE);

	public abstract void seguirUsuario(String Usu1, String Usu2);

	public abstract void dejarUsuario(String Usu1, String Usu2);

	public abstract void aniadirVideo(String nickU, String nombreV,
			String descripcionV, Integer duracionV, DtFecha fechaPublicacionV,
			String urlV, DtCategoria catV, Privacidad privacidadV);

	public abstract void ingresarNuevosDatosVideo(String nickU,
			String nuevoNombreV, String nuevaDescripcionV, int nuevaDuracionV,
			DtFecha nuevaFechaPublicacionV, String nuevaURL,
			DtCategoria nuevaCatV, Privacidad nuevaPrivacidadV);

	public abstract Boolean verificarDispUsuario(String nickU, String email);

	public abstract void nuevoUsuario(String nickU, String pass, String nombreU,
			String apellidoU, String emailU, DtFecha fechaNacimientoU,
			byte[] fotoU, String nombreCanal, String descripcionCanal,
			Privacidad privacidadCanal, String categoriaCanal);

	public abstract void editarDatosUsuario(String nickU, String nuevoNombreU,
			String nuevoApeliidoU, DtFecha nuevaFechaNacU, byte[] nuevaFotoU);

	public abstract DtListaReproduccion infoAdicLDR(String nickU, String nombreL);

	public abstract DtUsuario listarDatosUsuario(String nickU);

	public abstract DtCanal mostrarInfoCanal(String nickU);

	public abstract Boolean memberListaReproduccionDefecto(String nombreLista);

	public abstract Boolean memberListaReproduccionPropia(String nickU,
			String nombreLista);

	public abstract Boolean memberUsuario(String nickU);

	public abstract DtVideo obtenerInfoAdicVideo(String nickname,
			String nombreVideo);

	public abstract Boolean memberVideoEnUsuario(String nickname,
			String nombreVideo);

	public abstract String[] listarUsuariosQueSigue(String nickname);

	public abstract String[] listarUsuariosQueLeSigue(String nickname);

	public abstract String[] listarVideosListaReproduccionUsuario(
			String nickname, String nombreLista);

	public abstract void eliminarVideoLista(String nickU, Integer id_video,
			String nombreLDR);

	public abstract DtVideo[] obtenerDtsVideosListaReproduccionUsuario(
			String nickname, String nombreLista);

	public abstract boolean memberVideoLista(String nicknameUsuario,
			int idVideo, String nombreListaReproduccion);

	public abstract void modificarDatosCanal(String nickname,
			String nombreCanal, String descripcion, Privacidad privacidad,
			String catE);

	public abstract String[] listarLDRParticularesdeUsuario(String nickname);
	
	public abstract DtCanal[] listarCanalesPublicosPorNombre(String nombre);

	public abstract DtVideo[] infoVideosCanal(String nickU, Privacidad priv);
	
	public abstract DtListaReproduccion[] infoLDRdeUsuario(String nickU,Privacidad priv);
	
	public abstract DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre);
	
	public abstract boolean verificarLogin(String nick,String pass);
	
}
