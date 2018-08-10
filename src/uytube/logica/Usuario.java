package uytube.logica;

public class Usuario {
	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private Fecha fecha_nacimiento;
    private String foto;
	
	public Usuario(String nick,String nom, String ape, String e, Fecha fn, String fo) {
		// TODO Auto-generated constructor stub
		nickname = nick;
		nombre = nom;
		apellido = ape;
		email = e;
		fecha_nacimiento = fn;
		foto = fo;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void editarDatosUsuario(String nom, String ape, Fecha fn, String fo) {
		nombre = nom;
		apellido = ape;;
		fecha_nacimiento = fn;
		foto = fo;
	}
	
	public DtUsuario listarDatosUsuario() {
		DtUsuario dt = new DtUsuario(nickname,nombre,apellido,email,fecha_nacimiento,foto);
		return dt;
	}
	 
	
	
}
