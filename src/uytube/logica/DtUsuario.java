package uytube.logica;

public class DtUsuario {
	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private Fecha fecha_nacimiento;
    private String foto;
	
	public DtUsuario(String nick,String nom, String ape, String e, Fecha fn, String fo) {
		nickname = nick;
		nombre = nom;
		apellido = ape;
		email = e;
		fecha_nacimiento = fn;
		foto = fo;
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(DtUsuario u) {
		return (nickname == u.getNickname()) && (nombre == u.getNombre()) && (apellido == u.getApellido()) && (email == u.getEmail()) && (fecha_nacimiento == u.getFecha_nacimiento()) && (foto == u.getFoto());
	}
	
	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Fecha getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	
	public String getFoto() {
		return foto;
	}
	

}
