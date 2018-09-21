package uytubeLogic.logica;

import java.util.Date;

import uytubeLogic.logica.SystemHandler.Privacidad;

public class DtCanal {
	private String nombre;
	private String descripcion;
	private Privacidad privado;
	private DtCategoria categoria;
	private Date ultimoVideo;

	public DtCanal(Canal chanel) {
		nombre = chanel.getNombre();
		descripcion = chanel.getDescripcion();
		privado = chanel.getPrivacidad();
		categoria = chanel.getCategoria();
		ultimoVideo = chanel.getFechaUltimoVideo();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Privacidad getPrivacidad() {
		return privado;
	}

	public DtCategoria getCategoria() {
		return categoria;
	}
	
	public Date getFechaUltimoVideo() {
		return ultimoVideo;
	}

	public Boolean equals(DtCanal chanel) {
		return (nombre == chanel.getNombre()) && (descripcion == chanel.getDescripcion())
				&& (privado == chanel.getPrivacidad());
	}

}
