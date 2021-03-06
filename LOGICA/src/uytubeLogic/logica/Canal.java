package uytubeLogic.logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
//prueba commit
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class Canal {

	private String nombre;
	private String descripcion;
	private Privacidad privacidadCanal;
	private Categoria cate;
	private Map<String, Video> videos;
	private Map<String, ListaReproduccion> listasReproduccion;
	private Map<Integer,DtVideoHistorial> favoritoHistorico;
	private String propietario;
	//carmona puto
	public String getNombre() {
		return nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Privacidad getPrivacidad() {
		return privacidadCanal;
	}

	public DtCategoria getCategoria() {
		DtCategoria dataTipo = new DtCategoria(cate);
		return dataTipo;
	}

	public void addListaReproduccion(Particular listaRep) {
		listasReproduccion.put(listaRep.getNombre(), listaRep);
	}

	public void addListaReproduccion(PorDefecto listaRep) {
		listasReproduccion.put(listaRep.getNombre(), listaRep);
	}

	public ListaReproduccion findLista(String nombreLista) {
		return listasReproduccion.get(nombreLista);
	}

	public String[] listarListasReproduccion() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			if (entry.getValue() != null) {
				String nomb = entry.getValue().getNombre();
				nombresListas[contador] = nomb;
				contador++;
			} // Se agreg� esta linea para tratar de evitar los punteros
				// nulos.
		}
		return nombresListas;
	}

	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		DtListaReproduccion dataTipo = null;
		if (memberListaReproduccionPropia(nombreLista)) {
			ListaReproduccion listaRep = findLista(nombreLista);
			dataTipo = listaRep.verDetallesListareproduccion();
		}
		return dataTipo;
	}

	public Canal(String nomb, String proprietary, String desc, Privacidad privacidadE, String catE) {
		nombre = nomb;
		descripcion = desc;
		privacidadCanal = privacidadE;
		propietario = proprietary;
		CategoriaHandler manejadorCategoria = CategoriaHandler.getInstance();
		if (catE != null && manejadorCategoria.isMember(catE)) {
			cate = manejadorCategoria.find(catE);
		} else {
			SystemHandler manejadorSistema = SystemHandler.getInstance();
			cate = manejadorSistema.getSinCat();
		}
		videos = new HashMap<String, Video>();
		listasReproduccion = new HashMap<String, ListaReproduccion>();
		favoritoHistorico = new HashMap<Integer, DtVideoHistorial>();
		SystemHandler manejadorSistema = SystemHandler.getInstance();
		DtListaReproduccion[] listasDefault = manejadorSistema.obtenerListasReproduccion();
		for (int index = 0; index < listasDefault.length; index++) {
			PorDefecto listaRep = new PorDefecto(listasDefault[index].getNombre(), proprietary);
			addListaReproduccion(listaRep);
		}
	}

	public DtCanal mostrarInfoCanal() {
		DtCanal dataTipo = new DtCanal(this);
		return dataTipo;
	}

	public void addVideo(Video vVideo) {
		videos.put(vVideo.getNombre(), vVideo);
	}

	public Video findVideo(String sNombre) {
		return videos.get(sNombre);
	}

	public void aniadirVideo(String nomb, String proprietary, String desc, Integer duracion, DtFecha fechaPublicacion,
			String urlVideo, DtCategoria catE, Privacidad priv) {
		Video vVideo = new Video(nomb, proprietary, desc, duracion, fechaPublicacion, urlVideo, catE, priv);
		this.addVideo(vVideo);
		VideoHandler vidH = VideoHandler.getInstance();
		vidH.addVideo(vVideo);
	}

	public void ingresarNuevosDatosVideo(String nomb, String desc, int duracion, DtFecha fechaPublicacion,
			String urlVideo, DtCategoria catE, Privacidad priv) {
		Video vVideo = videos.get(nomb);
		vVideo.ingresarNuevosDatosVideo(desc, duracion, fechaPublicacion, urlVideo, catE, priv);
	}

	public String[] listarVideosCanal() {
		String[] nombresVideos = new String[videos.size()];
		Integer contador = 0;
		for (Map.Entry<String, Video> entry : videos.entrySet()) {
			String nomb = entry.getValue().getNombre();
			nombresVideos[contador] = nomb;
			contador++;
		}
		return nombresVideos;
	}

	public String[] listarVideosPorLDR(String nombreLDR) {

		return listasReproduccion.get(nombreLDR).listarVideos();
	}

	public void agregarVideoLDR(Integer identificador, String nombreLDR) {
		VideoHandler manejadorVideo = VideoHandler.getInstance();
		Video vVideo = manejadorVideo.find(identificador);
		listasReproduccion.get(nombreLDR).agregarVideo(vVideo);
	}

	public void cambiarPrivLDR(String nombreL, Privacidad privE) {
		Particular listaRep = (Particular) listasReproduccion.get(nombreL);
		listaRep.cambiarPrivLDR(privE);
	}

	public void eliminarVideoLista(Integer id_video, String nombreLDR) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLDR);
		listaRep.removerVideo(id_video);
	}

	public Boolean memberListaReproduccionPropia(String nombreLista) {
		return listasReproduccion.containsKey(nombreLista);
	}

	public void nuevaListaPorDefecto(String nombreL, String proprietary) {
		PorDefecto ldr = new PorDefecto(nombreL, proprietary);
		listasReproduccion.put(nombreL, ldr);
	}

	public DtVideo obtenerInfoAdicVideo(String nombreVideo) {
		DtVideo dataTipo = new DtVideo(videos.get(nombreVideo));
		return dataTipo;
	}

	public Boolean memberVideoEnUsuario(String nombreVideo) {
		return videos.containsKey(nombreVideo);
	}

	public String[] listarVideosListaReproduccionUsuario(String nombreLista) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLista);
		return listaRep.listarVideos();
	}

	public DtVideo[] obtenerDtsVideosListaReproduccionUsuario(String nombreLista) {
		ListaReproduccion listaRep = listasReproduccion.get(nombreLista);
		return listaRep.obtenerDtsVideosListaReproduccionUsuario(nombreLista);
	}

	public boolean memberVideoLista(int idVideo, String nombreListaReproduccion) {
		VideoHandler videoH = VideoHandler.getInstance();
		Video video = videoH.find(idVideo);
		ListaReproduccion lista = this.findLista(nombreListaReproduccion);
		return lista.existeVideo(video);
	}

	public void modificarDatosCanal(String nombreCanal, String descripcion2, Privacidad privacidad, String catE2) {
		nombre = nombreCanal;
		descripcion = descripcion2;
		privacidadCanal = privacidad;
		if (catE2 != null) {
			CategoriaHandler manejadorCategoria = CategoriaHandler.getInstance();
			cate = manejadorCategoria.find(catE2);
		} else {
			SystemHandler manejadorSistema = SystemHandler.getInstance();
			cate = manejadorSistema.getSinCat();
		}

		if (privacidad.equals(Privacidad.PRIVADO)) {
			cambiarPrivacidadVideosAPrivado();
			cambiarPrivacidadListasParticularesAPrivado();
		}
	}

	private void cambiarPrivacidadVideosAPrivado() {
		for (final Map.Entry<String, Video> entry : videos.entrySet()) {
			final Video video = entry.getValue();
			video.setPrivacidad(Privacidad.PRIVADO);
		}
	}

	private void cambiarPrivacidadListasParticularesAPrivado() {
		for (final Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			final ListaReproduccion listaReproduccion = entry.getValue();

			if (listaReproduccion instanceof Particular) {
				final Particular listaParticular = (Particular) listaReproduccion;
				listaParticular.cambiarPrivLDR(Privacidad.PRIVADO);
			}
		}
	}

	public String[] listarLDRParticularesdeUsuario() {
		String[] nombresListas = new String[listasReproduccion.size()];
		Integer contador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			if (entry.getValue() != null) {
				if (entry.getValue() instanceof Particular) {
					String nomb = entry.getValue().getNombre();
					nombresListas[contador] = nomb;
					contador++;
				}
			} // Se agreg� esta linea para tratar de evitar los punteros
				// nulos.
		}
		String[] nombresListasAjustado = new String[contador];
		for (int i = 0; i < contador; i++) {
			nombresListasAjustado[i] = nombresListas[i];
		}
		return nombresListasAjustado;
	}

	public Date getFechaUltimoVideo() {
		Date LastFecha = new Date(0);
		boolean found = false;
		for (Map.Entry<String, Video> entry : videos.entrySet()) {
			if (!found) {
				LastFecha = entry.getValue().getFechaPublicacion().getFecha();
				found = true;
			} else if (entry.getValue().getFechaPublicacion().getFecha().before(LastFecha)) {
				LastFecha = entry.getValue().getFechaPublicacion().getFecha();
			}
		}
		return LastFecha;
	}

	public DtVideo[] infoVideosCanal(String filtro, Privacidad priv) {
		if (filtro == null)
			filtro = "";
		List<DtVideo> listaVideos = new ArrayList<DtVideo>();
		for (Map.Entry<String, Video> entry : videos.entrySet()) {
			if (entry.getValue().getPrivacidad() == priv
					&& (entry.getValue().getNombre().toLowerCase().contains(filtro.toLowerCase())
							|| entry.getValue().getDescripcion().toLowerCase().contains(filtro.toLowerCase())))
				listaVideos.add(new DtVideo(entry.getValue()));
		}
		return listaVideos.toArray(new DtVideo[0]);
	}

	public DtListaReproduccion[] infoLDRdeUsuario(String filtro, Privacidad priv) {
		if (filtro == null)
			filtro = "";
		List<DtListaReproduccion> listaLDR = new ArrayList<DtListaReproduccion>();
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			if (entry.getValue() instanceof Particular) {
				Particular listaP = (Particular) entry.getValue();
				if (listaP.getPrivado() == priv && listaP.getNombre().toLowerCase().contains(filtro.toLowerCase()))
					listaLDR.add(new DtListaReproduccion(listaP));
			} else {
				PorDefecto listaPD = (PorDefecto) entry.getValue();
				// las por defecto son SIEMPRE privadas
				if (priv == Privacidad.PRIVADO && listaPD.getNombre().toLowerCase().contains(filtro.toLowerCase())) {
					listaLDR.add(new DtListaReproduccion(listaPD));
				}
			}
		}
		return listaLDR.toArray(new DtListaReproduccion[0]);
	}

	public DtListaReproduccion[] getListas() {
		DtListaReproduccion[] listasADevolver = new DtListaReproduccion[listasReproduccion.size()];
		int iterador = 0;
		for (Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			listasADevolver[iterador] = entry.getValue().toDt();
			iterador++;
		}
		return listasADevolver;
	}


	public void agregarVisita(Integer id_video) 
	{
		if(favoritoHistorico.containsKey(id_video))
		{
			DtVideoHistorial videoHistorial=favoritoHistorico.get(id_video);
			videoHistorial.actualizar();
			System.out.println("estoy actualizando");
		}
		else
		{
			System.out.println("no estoy actualizando");
			VideoHandler manejadorVideo = VideoHandler.getInstance();
			Video videoActual = manejadorVideo.find(id_video);
			DtVideo dtVideoActual = new DtVideo(videoActual);
			DtVideoHistorial nuevoVideoHistorial = new DtVideoHistorial(dtVideoActual);
			favoritoHistorico.put(id_video, nuevoVideoHistorial);
		}
		
		
	}
	
	public DtVideoHistorial[] getFavoritoHistorico()
	{
		List <DtVideoHistorial> favHis= new ArrayList<DtVideoHistorial>();

		for (Map.Entry<Integer,DtVideoHistorial> entry : favoritoHistorico.entrySet()) {
			favHis.add(new DtVideoHistorial(entry.getValue()));
		}
		Collections.sort(favHis,Collections.reverseOrder());
		DtVideoHistorial[] res = favHis.toArray(new DtVideoHistorial[0]);
		return res;
		
	}
				

	public void eliminarVideoCanal(String videoNombre){
		Video videoEliminar = findVideo(videoNombre);
		videos.remove(videoEliminar);
		VideoHandler vidH = VideoHandler.getInstance();
		vidH.removerVideo(videoEliminar);
	}

	public uyTubePersistencia.Canal persistir() {
		uyTubePersistencia.Canal CanalP = new uyTubePersistencia.Canal(this);
		
		Map<String, uyTubePersistencia.Video> videosP = new HashMap<String, uyTubePersistencia.Video>();
		for (final Map.Entry<String, Video> entry : videos.entrySet()) {
			List <DtListaReproduccion> listasEnVid = Arrays.asList(entry.getValue().getListas());
			boolean videoEnListaPropia=false;
			for(DtListaReproduccion lista:listasEnVid) {
				if(lista.getPropietario().equals(this.getPropietario())) {
					videoEnListaPropia=true;
				}
			}
			if(!videoEnListaPropia)
				videosP.put(entry.getValue().getNombre(), entry.getValue().persistir());
		}
		CanalP.setVideos(videosP);
		
		Map<String, uyTubePersistencia.ListaReproduccion> listasReproduccionP = new HashMap<String, uyTubePersistencia.ListaReproduccion>();
		for (final Map.Entry<String, ListaReproduccion> entry : listasReproduccion.entrySet()) {
			listasReproduccionP.put(entry.getValue().getNombre(), entry.getValue().persistir()); //agrego al map la lista persistida
			Map<Integer, uyTubePersistencia.Video> videosPenLista = new HashMap<Integer, uyTubePersistencia.Video>(); 
			for(Entry<Integer, Video> entryV: entry.getValue().getVideos().entrySet()) { //para cada video dentro de la lista real
				if(entryV.getValue().getPropietario().equals(this.getPropietario())){  //si el video es del canal
					uyTubePersistencia.Video vidPersistidoEnLista = entryV.getValue().persistir(); //persistir
					videosPenLista.put(vidPersistidoEnLista.getIdVideo(), vidPersistidoEnLista); //aniadir al map de los videos de la lista
				}
			}
			listasReproduccionP.get(entry.getValue().getNombre()).setVideos(videosPenLista);  //agregarle todos los videos a la lista persistida
		}
		
		CanalP.setListasReproduccion(listasReproduccionP);
		
		
		return CanalP;
	}

	public void eliminarTodosVideoLista(String nomLista) {
		if(listasReproduccion.containsKey(nomLista)){
			listasReproduccion.get(nomLista).eliminarVideos();
		}
	}

}

