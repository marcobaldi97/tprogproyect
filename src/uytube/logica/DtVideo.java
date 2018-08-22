package uytube.logica;

public class DtVideo {
	private Integer IDVideo;
	private String nombre;
	private String propietario;
	private String descripcion;
	private int duracionSS;
	private DtFecha fecha_publicacion;
	private String URL;
	private DtCategoria cat;
	private boolean privacidad;
	
	public DtVideo(Video v) {
		IDVideo=v.getIDVideo();
		nombre = v.getNombre();
		propietario=v.getPropietario();
		descripcion = v.getDescripcion();
		duracionSS = v.getDuracion();
		fecha_publicacion = v.getFechaPublicacion();
		URL = v.getURL();
		cat = v.getCategoria();
		privacidad = v.getPrivacidad();
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
	
	public boolean getPrivacidad() {
		return privacidad;
	}
	
	public boolean equals(DtVideo dt) {
		return (nombre == dt.getNombre())&&(descripcion == dt.getDescripcion())&&(duracionSS == dt.getDuracion())&&(fecha_publicacion == dt.getFechaPublicacion())&&(URL == dt.getUrl())&&(cat.equals(getCategoria()))&&(privacidad == dt.getPrivacidad());
	}
}
