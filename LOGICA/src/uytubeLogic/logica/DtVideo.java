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
	private DtCategoria cat;
	private Privacidad privacidad;

	public DtVideo(Video videoBase) {
		iDVideo = videoBase.getIDVideo();
		nombre = videoBase.getNombre();
		setPropietario(videoBase.getPropietario());
		descripcion = videoBase.getDescripcion();
		duracionSS = videoBase.getDuracion();
		fechaPublicacion = videoBase.getFechaPublicacion();
		url = videoBase.getURL();
		cat = videoBase.getCategoria();
		privacidad = videoBase.getPrivacidad();
	}

	public Integer getIDVideo() {
		return iDVideo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getDuracion() {
		return duracionSS;
	}

	public DtFecha getFechaPublicacion() {
		return fechaPublicacion;
	}

	public String getUrl() {
		return url;
	}

	public DtCategoria getCategoria() {
		return cat;
	}

	public Privacidad getPrivacidad() {
		return privacidad;
	}

	public boolean equals(DtVideo other) {
		return (nombre == other.getNombre())
				&& (descripcion == other.getDescripcion())
				&& (duracionSS == other.getDuracion())
				&& (fechaPublicacion == other.getFechaPublicacion())
				&& (url == other.getUrl()) && (cat.equals(getCategoria()))
				&& (privacidad == other.getPrivacidad());
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
}
