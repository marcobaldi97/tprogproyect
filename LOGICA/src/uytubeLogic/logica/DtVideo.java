package uytubeLogic.logica;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class DtVideo {
	private Integer iDVideo;
	private String nombre;
	private String propietario;
	private String descripcion;
	private int duracionSS;
	private DtFecha fechaPublicacion;
	private String url;
	private DtCategoria categoria;
	private Privacidad privacidad;

	public DtVideo(Video videoBase) {
		iDVideo = videoBase.getIDVideo();
		nombre = videoBase.getNombre();
		setPropietario(videoBase.getPropietario());
		descripcion = videoBase.getDescripcion();
		duracionSS = videoBase.getDuracion();
		fechaPublicacion = videoBase.getFechaPublicacion();
		url = videoBase.getURL();
		categoria = videoBase.getCategoria();
		privacidad = videoBase.getPrivacidad();
	}

	
	public boolean equals(DtVideo other) {
		return (nombre == other.getNombre())
				&& (descripcion == other.getDescripcion())
				&& (duracionSS == other.getDuracionSS())
				&& (fechaPublicacion == other.getFechaPublicacion())
				&& (url == other.getUrl()) && (categoria.equals(getCategoria()))
				&& (privacidad == other.getPrivacidad());
	}


	public Integer getiDVideo() {
		return iDVideo;
	}


	public DtVideo() {
		// TODO Auto-generated constructor stub
	}


	public void setiDVideo(Integer iDVideo) {
		this.iDVideo = iDVideo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPropietario() {
		return propietario;
	}


	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getDuracionSS() {
		return duracionSS;
	}


	public void setDuracionSS(int duracionSS) {
		this.duracionSS = duracionSS;
	}


	public DtFecha getFechaPublicacion() {
		return fechaPublicacion;
	}


	public void setFechaPublicacion(DtFecha fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	

	public DtCategoria getCategoria() {
		return categoria;
	}


	public void setCategoria(DtCategoria categoria) {
		this.categoria = categoria;
	}


	public Privacidad getPrivacidad() {
		return privacidad;
	}


	public void setPrivacidad(Privacidad privacidad) {
		this.privacidad = privacidad;
	}
	

}
