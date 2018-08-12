package uytube.logica;

public class Video {
	private String nombre;
	private String descripcion;
	private int duracionSS;
	private Fecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	private boolean privacidad;
	
	public Video(String n, String d, int dur, Fecha fp, String url, DtCategoria c, boolean p) {
		nombre = n;
		descripcion = d;
		duracionSS = dur;
		fecha_publicacion = fp;
		URL = url;
		cat = new Categoria(c.getNombre());
		privacidad = p;
	}
	
	public void ingresarNuevosDatosVideo(String d, int dur, Fecha fp, String url, DtCategoria c, boolean p) {
		descripcion = d;
		duracionSS = dur;
		fecha_publicacion = fp;
		URL = url;
		cat = new Categoria(c.getNombre());
		privacidad = p;
	}
	
	public DtVideo verDetallesVideo() {
		DtVideo dt = new DtVideo(nombre,descripcion,duracionSS,fecha_publicacion,URL,cat,privacidad);
		return dt;
	}
	
	public String getNombre() {
		return nombre;
	}

}
