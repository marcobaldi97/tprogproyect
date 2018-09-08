package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;


public interface IUsuarioCtrl {

	public abstract String[] listarNicknamesUsuarios();

	public abstract String[] listarVideosCanal(String nickU);

	public abstract boolean nuevaListaPorDefecto(String nombreL);

	public abstract void nuevaListaParticular(String nickU, String nombreL, Privacidad privada);

	public abstract String[] listarLDRdeUsuario(String nickU);

	public abstract void agregarVideoLista(String nickU, Integer id_video, String nombreLDR);

	public abstract void cambiarPrivLDR(String nickU, String nombreL, Privacidad privE);

	public abstract void seguirUsuario(String Usu1, String Usu2);

	public abstract void dejarUsuario(String Usu1, String Usu2);

	public abstract void aniadirVideo(String nickU, String nom, String desc, Integer dur, DtFecha fp, String url,
			DtCategoria catE, Privacidad p);

	public abstract void ingresarNuevosDatosVideo(String nickU, String nom, String d, int dur, DtFecha fp, String url,
			DtCategoria catE, Privacidad p);

	public abstract Boolean verificarDispUsuario(String nickU, String email);

	public abstract void nuevoUsuario(String nick, String nom, String ape, String e, DtFecha fn, byte[] fo,
			String nombreCanal, String desc, Privacidad privacidadE, String catE);

	public abstract void editarDatosUsuario(String nickU, String nom, String ape, DtFecha fn, byte[] fo);

	public abstract DtListaReproduccion infoAdicLDR(String nickU, String nombreL);

	public abstract DtUsuario listarDatosUsuario(String nickU);

	public abstract DtCanal mostrarInfoCanal(String nickU);

	public abstract Boolean memberListaReproduccionDefecto(String nombreLista);

	public abstract Boolean memberListaReproduccionPropia(String nickU, String nombreLista);

	public abstract Boolean memberUsuario(String nickU);

	public abstract DtVideo obtenerInfoAdicVideo(String nickname, String nombreVideo);

	public abstract Boolean memberVideoEnUsuario(String nickname, String nombreVideo);

	public abstract String[] listarUsuariosQueSigue(String nickname);

	public abstract String[] listarUsuariosQueLeSigue(String nickname);

	public abstract String[] listarVideosListaReproduccionUsuario(String nickname, String nombreLista);
	
	public abstract void eliminarVideoLista(String nickU, Integer id_video, String nombreLDR);

	public abstract DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nickname, String nombreLista);

	public abstract boolean memberVideoLista(String nicknameUsuario, int idVideo, String nombreListaReproduccion);
	
	public abstract void modificarDatosCanal(String nickname, String nombreCanal, String descripcion, Privacidad privacidad, String catE);

	public abstract String[] listarLDRParticularesdeUsuario(String nickname);

}
