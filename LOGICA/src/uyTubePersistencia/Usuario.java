package uyTubePersistencia;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import uytubeLogic.logica.DtFecha;
 
@Entity
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer IdUsuario;
	
	private String nickname;
	private String pass;
	private String nombre;
	private String apellido;
	private String email;
	private DtFecha fechaNacimiento;
	private byte[] foto;
	@OneToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="Canal")
	private Canal canalPropio;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(uytubeLogic.logica.Usuario usuario) {
		this.setNickname(usuario.getNickname());
		this.setNombre(usuario.getNombre());
		this.setApellido(usuario.getApellido());
		this.setEmail(usuario.getEmail());
		this.setFechaNacimiento(new DtFecha(usuario.getFechaNac().getFecha()));
		this.setFoto(usuario.getFoto());
		this.setPass(usuario.getPassword());
	}
	public Integer getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public DtFecha getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(DtFecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Canal getCanalPropio() {
		return canalPropio;
	}
	public void setCanalPropio(Canal canalPropio) {
		this.canalPropio = canalPropio;
	}

}
