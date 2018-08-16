package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private DtFecha fecha_nacimiento;
    private String foto;
    private Canal canalPropio;
    private Map<String,Usuario> usuariosQueSigue;
    private Map<String,Usuario> usuariosQueLeSiguen;
	
	public Usuario(String nick,String nom, String ape, String e, DtFecha fn, String fo) {
		// TODO Auto-generated constructor stub
		nickname = nick;
		nombre = nom;
		apellido = ape;
		email = e;
		fecha_nacimiento = fn;
		foto = fo;
		usuariosQueSigue = new HashMap<String, Usuario>();
		usuariosQueLeSiguen = new HashMap<String, Usuario>();
	}
	
	public void createCanal(String nom, String desc, Boolean privacidadE,String catE) {
		canalPropio = new Canal(nom,desc,privacidadE,catE);
	}
	
	public String getNickname() {
		return nickname;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public DtFecha getFechaNac(){
		return fecha_nacimiento;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void editarDatosUsuario(String nom, String ape, DtFecha fn, String fo) {
		nombre = nom;
		apellido = ape;;
		fecha_nacimiento = fn;
		foto = fo;
	}
	
	public DtCanal mostrarInfoCanal() {
		return canalPropio.mostrarInfoCanal();
	}
	
	public DtUsuario listarDatosUsuario() {
		DtUsuario dt = new DtUsuario(this);
		return dt;
	}
	public String getFoto(){
		return foto;
	}
	
	public void aniadirUsuarioASeguir(Usuario u) {
		usuariosQueSigue.put(u.getNickname(),u);
	}
	
	public void removerUsuarioASeguir(Usuario u) {
		usuariosQueSigue.remove(u.getNickname());
	}
	
	public String[] listarUsuariosQueSigue() {
		String[] nicknames = new String[usuariosQueSigue.size()];
		Integer contador = 0;
		for(Map.Entry<String, Usuario> entry : usuariosQueSigue.entrySet()) {
			nicknames[contador] = entry.getKey();
			contador++;
		}
		return nicknames;
	}
	
	public void aniadirUsuarioQueLeSigue(Usuario u) {
		usuariosQueLeSiguen.put(u.getNickname(),u);
	}
	
	public void removerUsuarioQueLeSigue(Usuario u) {
		usuariosQueLeSiguen.remove(u.getNickname());
	}
	
	public void aniadirVideo(String nom, String desc, Integer dur, DtFecha fp, String url, DtCategoria catE, boolean p) {
		canalPropio.aniadirVideo(nom, desc, dur, fp, url, catE, p);
	}
	
	public void ingresarNuevosDatosVideo(String nom, String d, int dur, DtFecha fp, String url, DtCategoria catE, boolean p) {
		canalPropio.ingresarNuevosDatosVideo(nom, d, dur, fp, url, catE, p);
	}
	
	public String[] listarVideosCanal() {
		return canalPropio.listarVideosCanal();
	}
	
	public DtVideo verDetallesVideo(String nombreVideo) {
		return canalPropio.verDetallesVideo(nombreVideo);
	}
	
	public DtListaReproduccion verDetallesListareproduccion(String nombreLista) {
		return canalPropio.verDetallesListareproduccion(nombreLista);
	}
	
	public String[] listarListasReproduccion() {
		return canalPropio.listarListasReproduccion();
	}
	
	public String[] listarUsuarioQueLeSigue() {
		String[] nicknames = new String[usuariosQueLeSiguen.size()];
		Integer contador = 0;
		for(Map.Entry<String, Usuario> entry : usuariosQueLeSiguen.entrySet()) {
			nicknames[contador] = entry.getKey();
			contador++;
		}
		return nicknames;
	}
	
	public String[] listarVideosPorLDR(String nombreLDR) {
		return canalPropio.listarVideosPorLDR(nombreLDR);
	}
	
	public void agregarVideoLDR(Integer id, String nombreLDR) {
			canalPropio.agregarVideoLDR(id,nombreLDR);
	}
	
	public void nuevaListaParticular(String nombreL, Boolean privada) {
		ListaReproduccion lr = new Particular(nombreL,privada);
		canalPropio.addListaReproduccion(lr);
	}

}
