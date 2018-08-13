package uytube.logica;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Usuario {
	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private Fecha fecha_nacimiento;
    private String foto;
    private Canal canalPropio;
    private Map<String,Usuario> usuariosQueSigue;
    private Map<String,Usuario> usuariosQueLeSiguen;
	
	public Usuario(String nick,String nom, String ape, String e, Fecha fn, String fo) {
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
	
	public void createCanal(String nom, String desc, Boolean privacidadE) {
		canalPropio = new Canal(nom,desc,privacidadE);
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void editarDatosUsuario(String nom, String ape, Fecha fn, String fo) {
		nombre = nom;
		apellido = ape;;
		fecha_nacimiento = fn;
		foto = fo;
	}
	
	public DtCanal mostrarInfoCanal() {
		return canalPropio.mostrarInfoCanal();
	}
	
	public DtUsuario listarDatosUsuario() {
		DtUsuario dt = new DtUsuario(nickname,nombre,apellido,email,fecha_nacimiento,foto);
		return dt;
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
	
	public String[] listarUsuarioQueLeSigue() {
		String[] nicknames = new String[usuariosQueLeSiguen.size()];
		Integer contador = 0;
		for(Map.Entry<String, Usuario> entry : usuariosQueLeSiguen.entrySet()) {
			nicknames[contador] = entry.getKey();
			contador++;
		}
		return nicknames;
	}

}
