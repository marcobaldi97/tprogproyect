package uytube.logica;

public class Video {
	private String nombre;
	private String descripcion;
	private int duracionSS;
	private Fecha fecha_publicacion;
	private String URL;
	private Categoria cat;
	
	public Video(String n, String d, int dur, Fecha fp, String url, DtCategoria c) {
		nombre = n;
		descripcion = d;
		duracionSS = dur;
		fecha_publicacion = fp;
		URL = url;
		cat = new Categoria(c.getNombre());
	}
	 public String getNombre() {
		 return nombre;
	 }

}
