package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comentario {
	private Integer iDComentario;
	private String texto;
	private DtFecha fecha;
	private boolean esPadre;
	private Map<Integer, Comentario> respuestas;
	private Usuario usuarioComentador;

	public Comentario(Integer idComentario, String text, DtFecha fech, boolean privacity,
			String nombreUsuarioComentador) {
		iDComentario = idComentario;
		texto = text;
		fecha = fech;
		esPadre = privacity;
		respuestas = new HashMap<Integer, Comentario>();
		UsuarioHandler manejadorUsuario = UsuarioHandler.getInstance();
		Usuario user = manejadorUsuario.find(nombreUsuarioComentador);
		usuarioComentador = user;
	}

	public Integer getIDComentario() {
		return iDComentario;
	}

	public String getTexto() {
		return texto;
	}

	public DtFecha getFecha() {
		return fecha;
	}

	public boolean getEsPadre() {
		return esPadre;
	}

	public void addComentario(Comentario coment) {
		respuestas.put(coment.getIDComentario(), coment);
	}

	public Usuario getUsuario() {
		return usuarioComentador;
	}

	public DtComentario[] getDtRespuestas() {
		List <DtComentario> comments= new ArrayList<DtComentario>();

		for (Map.Entry<Integer, Comentario> entry : respuestas.entrySet()) {
			comments.add(new DtComentario(entry.getValue()));
		}
		Collections.sort(comments);
		DtComentario[] res = comments.toArray(new DtComentario[0]);
		return res;
	}

	public void eliminarHijos() {
		for (Map.Entry<Integer, Comentario> entry : respuestas.entrySet()) {
			respuestas.remove(entry.getKey());
		}
	}

}
