package uytube.logica;

public class DtVideo {
	private String nombre;
	private String descripcion;
	private int duracionSS;
	private Fecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	private boolean privacidad;
	
	public DtVideo(String n, String d, int dur, Fecha fp, String url, DtCategoria c, boolean p) {
		nombre = n;
		descripcion = d;
		duracionSS = dur;
		fecha_publicacion = fp;
		URL = url;
		cat = new Categoria(c.getNombre());
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
}
