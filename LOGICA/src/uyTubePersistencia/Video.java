package uyTubePersistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.SystemHandler.Privacidad;

@Entity
public class Video implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer idVideo;
	private String nombre;
	private String descripcion;
	private int duracion;
	private DtFecha fechaPublicacion;
	private String urlVideo;
	private Privacidad privacidad;
	public Video() {
		// TODO Auto-generated constructor stub
	}
	public Video(uytubeLogic.logica.Video video) {
		this.setIdVideo(video.getIDVideo());
		this.setDescripcion(video.getDescripcion());
		this.setNombre(video.getNombre());
		this.setDuracion(video.getDuracion());
		this.setFechaPublicacion(new DtFecha(video.getFechaPublicacion().getFecha()));
		this.setPrivacidad(video.getPrivacidad());
		this.setUrlVideo(video.getURL());
	}
	public Integer getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
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
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public DtFecha getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(DtFecha fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getUrlVideo() {
		return urlVideo;
	}
	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}
	public Privacidad getPrivacidad() {
		return privacidad;
	}
	public void setPrivacidad(Privacidad privacidad) {
		this.privacidad = privacidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
