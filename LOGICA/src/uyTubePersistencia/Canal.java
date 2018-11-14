package uyTubePersistencia;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;


import uytubeLogic.logica.SystemHandler.Privacidad;

@Entity
public class Canal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer IdCanal;
	private String nombre;
	private String descripcion;
	private Privacidad privacidadCanal;
	@OneToMany(cascade=CascadeType.PERSIST)
	@MapKeyColumn(name="ID_VIDEOS_CANAL", table="Canal_video")
	@JoinTable(name="Canal_video")
	
	private Map<String, Video> videos;
	@OneToMany(cascade=CascadeType.PERSIST)
	@MapKeyColumn(name="ID_LISTAS_REP_CANAL",table="Canal_lista")
	@JoinTable(name="Canal_lista")
	private Map<String, ListaReproduccion> listasReproduccion;
	public Canal() {
		// TODO Auto-generated constructor stub
	}
	public Canal(uytubeLogic.logica.Canal canal) {
		this.setNombre(canal.getNombre());
		this.setDescripcion(canal.getDescripcion());
		this.setPrivacidadCanal(canal.getPrivacidad());
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIdCanal() {
		return IdCanal;
	}
	public void setIdCanal(Integer idCanal) {
		IdCanal = idCanal;
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
	public Privacidad getPrivacidadCanal() {
		return privacidadCanal;
	}
	public void setPrivacidadCanal(Privacidad privacidadCanal) {
		this.privacidadCanal = privacidadCanal;
	}
	public Map<String, Video> getVideos() {
		return videos;
	}
	public void setVideos(Map<String, Video> videos) {
		this.videos = videos;
	}
	public Map<String, ListaReproduccion> getListasReproduccion() {
		return listasReproduccion;
	}
	public void setListasReproduccion(Map<String, ListaReproduccion> listasReproduccion) {
		this.listasReproduccion = listasReproduccion;
	}
	
	
}
