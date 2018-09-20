package uytube.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import uytube.logica.SystemHandler.Privacidad;

public class Video {
	private Integer idVideo;
	private String nombre;
	private String propietario;
	private String descripcion;
	private int duracion;
	private DtFecha fechaPublicacion;
	private String urlVideo;
	private Categoria cat;
	private Privacidad privacidad;
	private Map<Integer, Comentario> comentarios;
	private List<ListaReproduccion> listas;
	private List<Puntuacion> puntuaciones;

	public Video(String nombreVideo, String propietario, String descripcionV, int duracionV, DtFecha fechapubli,
			String url, DtCategoria categ, Privacidad privacidadVideo) {
		VideoHandler vidHandler = VideoHandler.getInstance();
		SystemHandler SysHandler = SystemHandler.getInstance();
		idVideo = vidHandler.getNewID();
		nombre = nombreVideo;
		setPropietario(propietario);
		descripcion = descripcionV;
		duracion = duracionV;
		fechaPublicacion = fechapubli;
		urlVideo = url;
		listas = new LinkedList<ListaReproduccion>();
		CategoriaHandler catHandler = CategoriaHandler.getInstance();
		if (categ != null && catHandler.isMember(categ.getNombre())) {
			cat = catHandler.find(categ.getNombre()); // si la categoria existe
														// la asigno, si no?
			cat.addVideo(this);
		} else
			cat = SysHandler.getSinCat();
		privacidad = privacidadVideo;
		comentarios = new HashMap<Integer, Comentario>();
		puntuaciones = new ArrayList<Puntuacion>();
		vidHandler.addVideo(this);

	}

	public Integer getIDVideo() {
		return idVideo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracion;
	}

	public DtFecha getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getURL() {
		return urlVideo;
	}

	public DtCategoria getCategoria() {
		DtCategoria res = new DtCategoria(cat);
		return res;
	}

	public Privacidad getPrivacidad() {
		return privacidad;
	}

	public Categoria getObjetoCategoria() {
		return cat;
	}

	public void setPrivacidad(Privacidad privacidad) {
		this.privacidad = privacidad;
	}

	public void aniadirListaReproduccion(ListaReproduccion ldr) {
		if (!listas.contains(ldr)) {
			listas.add(ldr);
		}
	}

	public void removerListaReproduccion(ListaReproduccion ldr) {
		listas.remove(ldr);
	}

	public void ingresarNuevosDatosVideo(String descripcionV, int duracionV, DtFecha fechaPublicacionV, String url,
			DtCategoria categoriaV, Privacidad privacidadV) {
		for (ListaReproduccion ldr : listas) {
			ldr.removerCategoria(cat);
			cat.removerLDR(ldr);
		}
		SystemHandler SysHandler = SystemHandler.getInstance();
		descripcion = descripcionV;
		duracion = duracionV;
		fechaPublicacion = fechaPublicacionV;
		urlVideo = url;
		CategoriaHandler catHandler = CategoriaHandler.getInstance();
		cat.removerVideo(this);

		if (categoriaV != null) {
			if (catHandler.isMember(categoriaV.getNombre())) {
				Categoria categoriaNueva = catHandler.find(categoriaV.getNombre());
				cat = categoriaNueva;
				categoriaNueva.addVideo(this);
			}
		} else
			cat = SysHandler.getSinCat();
		privacidad = privacidadV;
		for (ListaReproduccion ldr : listas) {
			ldr.refrescarCategorias();
			cat.aniadirLDR(ldr);
		}
	}

	public DtComentario[] getComentarios() {
		Integer contador = 0;
		Integer tamanio = 0;

		for (Map.Entry<Integer, Comentario> entry : comentarios.entrySet()) {
			if (entry.getValue().getEsPadre()) {
				tamanio++;
			}
		}
		DtComentario[] res = new DtComentario[tamanio];
		for (Map.Entry<Integer, Comentario> entry : comentarios.entrySet()) {
			if (entry.getValue().getEsPadre()) {
				res[contador] = new DtComentario(entry.getValue());
				contador++;
			}
		}
		return res;
	}

	public void nuevoComentario(String nickU, DtFecha fecha, String cont) {
		SystemHandler SysHandler = SystemHandler.getInstance();
		Comentario comentarioNuevo = new Comentario(SysHandler.recibirIDComentario(), cont, fecha, true, nickU);
		comentarios.put(comentarioNuevo.getIDComentario(), comentarioNuevo);
	}

	public void responderComentario(Integer IDCR, String nickU, DtFecha fecha, String cont) {
		SystemHandler SysHandler = SystemHandler.getInstance();
		if (comentarios.containsKey(IDCR)) {
			Comentario comentarioPadre = comentarios.get(IDCR);
			Comentario comentarioNuevo = new Comentario(SysHandler.recibirIDComentario(), cont, fecha, false, nickU);
			comentarioPadre.addComentario(comentarioNuevo);
			comentarios.put(comentarioNuevo.getIDComentario(), comentarioNuevo);
		}
	}

	public DtPuntuacion[] getPuntuaciones() {
		DtPuntuacion[] puntajes = new DtPuntuacion[puntuaciones.size()];
		for (int i = 0; i < puntuaciones.size(); i++) {
			Puntuacion puntuacionVideo = puntuaciones.get(i);
			puntajes[i] = new DtPuntuacion(puntuacionVideo);
		}
		return puntajes;

	}

	public void addPuntuacion(Puntuacion puntuacionVideo) {
		puntuaciones.add(puntuacionVideo);
	}

	public DtVideo verDetallesVideo() {
		DtVideo infoVideo = new DtVideo(this);
		return infoVideo;
	}

	public void valorarVideo(String nickU, boolean valoracion) {
		int i = 0;
		while (i < puntuaciones.size() && puntuaciones.get(i).getNickPuntuador() != nickU) {
			i++;
		}
		if (i < puntuaciones.size()) {
			puntuaciones.get(i).setValoracion(valoracion);
		} else {
			Puntuacion puntuacionVideo = new Puntuacion(nickU, valoracion);
			addPuntuacion(puntuacionVideo);
		}

	}

	public DtListaReproduccion[] getListas() {
		DtListaReproduccion[] listasADevolver = new DtListaReproduccion[listas.size()];
		int iterador = 0;
		for (ListaReproduccion lista : listas) {
			if (lista instanceof PorDefecto)
				listasADevolver[iterador] = new DtListaReproduccion((PorDefecto) lista);
			else if (lista instanceof Particular)
				listasADevolver[iterador] = new DtListaReproduccion((Particular) lista);
			iterador++;
		}
		return listasADevolver;
	}

	public DtUsuario[] getUsuariosPuntuadores(boolean valoracion) {
		int puntSize = 0;
		for (Puntuacion puntuacionVideo : puntuaciones) {
			if (puntuacionVideo.getValoracion() == valoracion)
				puntSize++;
		}
		DtUsuario[] usu = new DtUsuario[puntSize];
		int i = 0;
		for (Puntuacion puntuacionVideo : puntuaciones) {
			if (puntuacionVideo.getValoracion() == valoracion) {
				usu[i] = new DtUsuario(puntuacionVideo.getUsuario());
				i++;
			}

		}
		return usu;
	}

	public DtInfoVideo getInfoVideoExt() {
		DtInfoVideo res = new DtInfoVideo(this);
		return res;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

}
