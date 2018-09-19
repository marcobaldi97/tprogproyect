package uytube.logica;

public class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private DtFecha fechaNacimiento;
	private byte[] foto;

	public DtUsuario(Usuario usuarioBase) {
		nickname = usuarioBase.getNickname();
		nombre = usuarioBase.getNombre();
		apellido = usuarioBase.getApellido();
		email = usuarioBase.getEmail();
		fechaNacimiento = usuarioBase.getFechaNac();
		foto = usuarioBase.getFoto();
	}

	// OBS: no compara fotos
	public boolean equals(DtUsuario other) {
		return (nickname == other.getNickname())
				&& (nombre == other.getNombre())
				&& (apellido == other.getApellido())
				&& (email == other.getEmail())
				&& (fechaNacimiento == other.getFechaNacimiento());
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

	public DtFecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public byte[] getFoto() {
		return foto;
	}

}
