package uytubeLogic.logica;

import java.util.Date;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Privacidad privado;
	private DtCategoria categoria;
	private Date ultimoVideo;
	private String propietario;

	public DtCanal(Canal chanel) {
		nombre = chanel.getNombre();
		descripcion = chanel.getDescripcion();
		privado = chanel.getPrivacidad();
		categoria = chanel.getCategoria();
		ultimoVideo = chanel.getFechaUltimoVideo();
		propietario = chanel.getPropietario();
	}


	public DtCanal() {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Privacidad getPrivado() {
		return privado;
	}


	public void setPrivado(Privacidad privado) {
		this.privado = privado;
	}


	public DtCategoria getCategoria() {
		return categoria;
	}


	public void setCategoria(DtCategoria categoria) {
		this.categoria = categoria;
	}


	public Date getUltimoVideo() {
		return ultimoVideo;
	}


	public void setUltimoVideo(Date ultimoVideo) {
		this.ultimoVideo = ultimoVideo;
	}


	public String getPropietario() {
		return propietario;
	}


	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}


	public Boolean equals(DtCanal chanel) {
		return (nombre == chanel.getNombre()) && (descripcion == chanel.getDescripcion())
				&& (privado == chanel.getPrivado());
	}

}
