package uytubeLogic.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class Usuario {
	private String nickname;
	private String pass;
	private String nombre;
	private String apellido;
	private String email;
	private DtFecha fechaNacimiento;
	private byte[] foto;
	private Canal canalPropio;
	private Map<String, Usuario> usuariosQueSigue;
	private Map<String, Usuario> usuariosQueLeSiguen;

	public static byte[] imagenToByte(File archivo) {
		// imagen a byte[]
		try {
			byte[] imgFoto = new byte[(int) archivo.length()];
			InputStream inte = new FileInputStream(archivo);
			inte.read(imgFoto);
			return imgFoto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public Usuario(String nickU, String passU, String nombreU, String apellidoU, String emailU, DtFecha fechaNacU,
			byte[] fotoU, String nombreCanal, String descripcionCanal, Privacidad privacidadCanal, String catCanal) {
		// TODO Auto-generated constructor stub
		nickname = nickU;
		pass = passU;
		nombre = nombreU;
		apellido = apellidoU;
		email = emailU;
		fechaNacimiento = fechaNacU;
		if (fotoU == null || (fotoU != null && fotoU.length == 0)) {
			// agregarle foto por defecto
			File archivo = new File("LOGICA/src/usuarioPorDefecto.png");
			foto = imagenToByte(archivo);
		} else {
			foto = fotoU;
		}

		usuariosQueSigue = new HashMap<String, Usuario>();
		usuariosQueLeSiguen = new HashMap<String, Usuario>();
		this.createCanal(nombreCanal, nickU, descripcionCanal, privacidadCanal, catCanal);
		;

	}

	public void createCanal(String nombreCanal, String propietarioCanal, String descricpcionCanal,
			Privacidad privacidadCanal, String categoriaCanal) {
		canalPropio = new Canal(nombreCanal, propietarioCanal, descricpcionCanal, privacidadCanal, categoriaCanal);
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return pass;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public DtFecha getFechaNac() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void editarDatosUsuario(String nuevoNombre, String nuevoApellido, DtFecha nuevaFechaNacimiento,
			byte[] fotoUsuario) {
		nombre = nuevoNombre;
		apellido = nuevoApellido;
		fechaNacimiento = nuevaFechaNacimiento;
		foto = fotoUsuario;
	}

	public DtCanal mostrarInfoCanal() {
		return canalPropio.mostrarInfoCanal();
	}

	public DtUsuario listarDatosUsuario() {
		DtUsuario infoUsuario = new DtUsuario(this);
		return infoUsuario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void aniadirUsuarioASeguir(Usuario usuarioParticular) {
		usuariosQueSigue.put(usuarioParticular.getNickname(), usuarioParticular);
	}

	public void removerUsuarioASeguir(Usuario usuarioParticular) {
		usuariosQueSigue.remove(usuarioParticular.getNickname());
	}

	public String[] listarUsuariosQueSigue() {
		String[] nicknames = new String[usuariosQueSigue.size()];
		Integer contador = 0;
		for (Map.Entry<String, Usuario> entry : usuariosQueSigue.entrySet()) {
			nicknames[contador] = entry.getKey();
			contador++;
		}
		return nicknames;
	}

	public void aniadirUsuarioQueLeSigue(Usuario usuarioParticular) {
		usuariosQueLeSiguen.put(usuarioParticular.getNickname(), usuarioParticular);
	}

	public void removerUsuarioQueLeSigue(Usuario usuarioParticular) {
		usuariosQueLeSiguen.remove(usuarioParticular.getNickname());
	}

	public void aniadirVideo(String nombreVideo, String propietarioVideo, String descripcionVideo, Integer duracion,
			DtFecha fechaPublicacion, String url, DtCategoria catE, Privacidad privacidadVideo) {
		canalPropio.aniadirVideo(nombreVideo, propietarioVideo, descripcionVideo, duracion, fechaPublicacion, url, catE,
				privacidadVideo);
	}

	public void ingresarNuevosDatosVideo(String nom, String descripcionVideo, int duracion, DtFecha fechaPublicacion,
			String url, DtCategoria catE, Privacidad privacidadVideo) {
		canalPropio.ingresarNuevosDatosVideo(nom, descripcionVideo, duracion, fechaPublicacion, url, catE,
				privacidadVideo);
	}

	public String[] listarVideosCanal() {
		return canalPropio.listarVideosCanal();
	}

	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		return canalPropio.verDetallesListareproduccion(nombreLista);
	}

	public String[] listarListasReproduccion() {
		return canalPropio.listarListasReproduccion();
	}

	public String[] listarUsuariosQueLeSigue() {
		String[] nicknames = new String[usuariosQueLeSiguen.size()];
		Integer contador = 0;
		for (Map.Entry<String, Usuario> entry : usuariosQueLeSiguen.entrySet()) {
			nicknames[contador] = entry.getKey();
			contador++;
		}
		return nicknames;
	}

	public String[] listarVideosPorLDR(String nombreLDR) {
		return canalPropio.listarVideosPorLDR(nombreLDR);
	}

	public void agregarVideoLDR(Integer idVideo, String nombreLDR) {
		canalPropio.agregarVideoLDR(idVideo, nombreLDR);
	}

	public void nuevaListaParticular(String nombreL, String pro, Privacidad privada) {
		Particular ldr = new Particular(nombreL, pro, privada);
		canalPropio.addListaReproduccion(ldr);
	}

	public void cambiarPrivLDR(String nombreL, Privacidad privE) {
		canalPropio.cambiarPrivLDR(nombreL, privE);
	}

	public void eliminarVideoLista(Integer id_video, String nombreLDR) {
		canalPropio.eliminarVideoLista(id_video, nombreLDR);
	}

	public Boolean memberListaReproduccionPropia(String nombreLista) {

		return canalPropio.memberListaReproduccionPropia(nombreLista);
	}

	public void nuevaListaPorDefecto(String nombreL) {
		canalPropio.nuevaListaPorDefecto(nombreL, nickname);

	}

	public DtVideo obtenerInfoAdicVideo(String nombreVideo) {
		return canalPropio.obtenerInfoAdicVideo(nombreVideo);
	}

	public Boolean memberVideoEnUsuario(String nombreVideo) {
		return canalPropio.memberVideoEnUsuario(nombreVideo);
	}

	public String[] listarVideosListaReproduccionUsuario(String nombreLista) {
		return canalPropio.listarVideosListaReproduccionUsuario(nombreLista);
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		// TODO Auto-generated method stub
		return canalPropio.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(int idVideo, String nombreListaReproduccion) {
		return canalPropio.memberVideoLista(idVideo, nombreListaReproduccion);
	}

	public void modificarDatosCanal(String nombreCanal, String descripcion, Privacidad privacidad, String catE) {
		canalPropio.modificarDatosCanal(nombreCanal, descripcion, privacidad, catE);
	}

	public String[] listarLDRParticularesdeUsuario() {
		return canalPropio.listarLDRParticularesdeUsuario();
	}

	public DtVideo[] infoVideosCanal(String filtro, Privacidad priv) {
		return canalPropio.infoVideosCanal(filtro, priv);
	}

	public DtListaReproduccion[] infoLDRdeUsuario(String filtro, Privacidad priv) {
		return canalPropio.infoLDRdeUsuario(filtro, priv);
	}

	public DtListaReproduccion[] getListas() {
		return canalPropio.getListas();
	}

}
