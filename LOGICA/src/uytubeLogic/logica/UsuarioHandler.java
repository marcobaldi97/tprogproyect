package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class UsuarioHandler {
	private Map<String, Usuario> usuarios;
	private static UsuarioHandler instancia = null;

	private UsuarioHandler() {
		usuarios = new HashMap<String, Usuario>();
	}

	public void aniadirUsuario(Usuario usuarioParticular) {
		usuarios.put(usuarioParticular.getNickname(), usuarioParticular);
	}

	public void removerUsuario(Usuario usuarioParticular) {
		usuarios.remove(usuarioParticular.getNickname());
	}

	public Usuario find(String nickname) {
		return usuarios.get(nickname);
	}

	public boolean memberUsuario(Usuario usuarioParticular) {
		return usuarios.containsValue(usuarioParticular);
	}

	public boolean memberNickname(String nickUsuario) {
		return usuarios.containsKey(nickUsuario);
	}

	public boolean memberEmail(String emailUsuario) {
		Boolean existe = false;
		for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			if (emailUsuario == entry.getValue().getEmail())
				existe = true;
		}
		return existe;
	}

	public String[] listarNicknamesUsuarios() {
		String[] nickUsuarios = new String[usuarios.size()];
		Integer contador = 0;
		for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			String nickU = entry.getKey();
			nickUsuarios[contador] = nickU;
			contador++;
		}
		return nickUsuarios;

	}

	public DtCanal[] listarCanalesPublicosPorNombre(String nombre) {
		List<DtCanal> listaUsuarios = new ArrayList<DtCanal>();
		for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			if (entry.getValue().mostrarInfoCanal().getPrivado() == Privacidad.PUBLICO
					&& (entry.getValue().mostrarInfoCanal().getNombre().toLowerCase().contains(nombre.toLowerCase())
							||entry.getValue().mostrarInfoCanal().getDescripcion().toLowerCase().contains(nombre.toLowerCase())))
				listaUsuarios.add(entry.getValue().mostrarInfoCanal());
		}
		DtCanal[] resultadosBusqueda = listaUsuarios.toArray(new DtCanal[0]);
		return resultadosBusqueda;
	}

	public DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre) {
		List<DtListaReproduccion> listaLDR = new ArrayList<DtListaReproduccion>();
		for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			DtListaReproduccion[] listasEnVideo = entry.getValue().getListas();
			for (DtListaReproduccion lista : listasEnVideo) {
				if (lista.getPrivado() == Privacidad.PUBLICO
						&& lista.getNombre().toLowerCase().contains(nombre.toLowerCase())
						&& !listaLDR.contains(lista)) {
					listaLDR.add(lista);
				}
			}
		}
		DtListaReproduccion[] resultadosBusqueda = listaLDR.toArray(new DtListaReproduccion[0]);
		return resultadosBusqueda;
	}

	public static UsuarioHandler getInstance() {
		if (instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}

}
