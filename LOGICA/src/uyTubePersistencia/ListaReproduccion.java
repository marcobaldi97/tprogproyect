package uyTubePersistencia;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import uytubeLogic.logica.ListaReproduccion.TipoLista;
import uytubeLogic.logica.Particular;
import uytubeLogic.logica.PorDefecto;
import uytubeLogic.logica.Video;
import uytubeLogic.logica.SystemHandler.Privacidad;



@Entity
public class ListaReproduccion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idListaRep;
	private String nombre;
	private TipoLista tipo;
	private Privacidad privado;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="Lista_video")
	private Map<Integer, uyTubePersistencia.Video> videos;
	
	public ListaReproduccion() {
	}
	
	public ListaReproduccion(Particular particular) {
		nombre=particular.getNombre();
		tipo=TipoLista.PARTICULAR;
		privado=particular.getPrivado();
		//ke hago con los bideos camona aiuda
	}
	public ListaReproduccion(PorDefecto porDefecto) {
		nombre=porDefecto.getNombre();
		tipo=TipoLista.PORDEFECTO;
		privado=Privacidad.PRIVADO;
		//ke hago con los bideos camona aiuda
	}

	public Integer getIdListaRep() {
		return idListaRep;
	}
	public void setIdListaRep(Integer idListaRep) {
		this.idListaRep = idListaRep;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public TipoLista getTipo() {
		return tipo;
	}
	public void setTipo(TipoLista tipo) {
		this.tipo = tipo;
	}
	public Privacidad getPrivado() {
		return privado;
	}
	public void setPrivado(Privacidad privado) {
		this.privado = privado;
	}
	public Map<Integer, uyTubePersistencia.Video> getVideos() {
		return videos;
	}
	public void setVideos(Map<Integer, uyTubePersistencia.Video> videos) {
		this.videos = videos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
