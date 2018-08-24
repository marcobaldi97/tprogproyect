package uytube.logica;

public class DtUsuario {
	private String nickname;
	private String nombre;
    private String apellido;
    private String email;
    private DtFecha fecha_nacimiento;
    private byte[] foto;
	
	public DtUsuario(Usuario u) {
		nickname = u.getNickname();
		nombre = u.getNombre();
		apellido = u.getApellido();
		email = u.getEmail();
		fecha_nacimiento = u.getFechaNac();
		foto = u.getFoto();
	}

	//OBS: no compara fotos
	public boolean equals(DtUsuario u) {
		return (nickname == u.getNickname()) && (nombre == u.getNombre()) && (apellido == u.getApellido()) && (email == u.getEmail()) && (fecha_nacimiento == u.getFecha_nacimiento());
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
	
	public DtFecha getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public byte[] getFoto() {
		return foto;
	}
	

}
