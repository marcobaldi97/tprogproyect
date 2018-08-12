package uytube.logica;

public class DtVideo {
	private String nombre;
	private String descripcion;
	private int duracionSS;
	private Fecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	private boolean privacidad;
	
	public DtVideo(String n, String d, int dur, Fecha fp, String url, Categoria c, boolean p) {
		nombre = n;
		descripcion = d;
		duracionSS = dur;
		fecha_publicacion = fp;
		URL = url;
		cat = c;
		privacidad = p;
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
	
	public Fecha getFechaPublicacion() {
		return fecha_publicacion;
	}
	
	public String getUrl() {
		return URL;
	}
	
	public Categoria getCategoria() {
		return cat;
	}
	
	public boolean getPrivacidad() {
		return privacidad;
	}
	
	public boolean equals(DtVideo dt) {
		return (nombre == dt.getNombre())&&(descripcion == dt.getDescripcion())&&(duracionSS == dt.getDuracion())&&(fecha_publicacion == dt.getFechaPublicacion())&&(URL == dt.getUrl())&&(cat == dt.getCategoria())&&(privacidad == dt.getPrivacidad());
	}
}
