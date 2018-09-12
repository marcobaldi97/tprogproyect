package uytube.logica;

import uytube.logica.SystemHandler.Privacidad;

public class DtVideo {
	private Integer IDVideo;
	private String nombre;
	private String propietario;
	private String descripcion;
	private int duracionSS;
	private DtFecha fecha_publicacion;
	private String URL;
	private DtCategoria cat;
	private Privacidad privacidad;
	
	public DtVideo(Video videoBase) {
		IDVideo=videoBase.getIDVideo();
		nombre = videoBase.getNombre();
		setPropietario(videoBase.getPropietario());
		descripcion = videoBase.getDescripcion();
		duracionSS = videoBase.getDuracion();
		fecha_publicacion = videoBase.getFechaPublicacion();
		URL = videoBase.getURL();
		cat = videoBase.getCategoria();
		privacidad = videoBase.getPrivacidad();
	}

	public Integer getIDVideo(){
		return IDVideo;
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
		return fecha_publicacion;
	}
	
	public String getUrl() {
		return URL;
	}
	
	public DtCategoria getCategoria() {
		return cat;
	}
	
	public Privacidad getPrivacidad() {
		return privacidad;
	}
	
	public boolean equals(DtVideo other) {
		return (nombre == other.getNombre())&&(descripcion == other.getDescripcion())&&(duracionSS == other.getDuracion())&&(fecha_publicacion == other.getFechaPublicacion())&&(URL == other.getUrl())&&(cat.equals(getCategoria()))&&(privacidad == other.getPrivacidad());
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
}
