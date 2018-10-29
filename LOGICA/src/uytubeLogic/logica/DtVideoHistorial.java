/**
 * 
 */
package uytubeLogic.logica;

import java.util.Date;

/**
 * @author Santiago Alaniz
 *
 */
public class DtVideoHistorial implements Comparable<DtVideoHistorial> {
	
	private DtVideo video;
	private Integer cantidadVisita;
	private DtFecha ultimaVisita;

	public DtVideoHistorial() {
		// TODO Auto-generated constructor stub
	}

	

	public DtVideo getVideo() {
		return video;
	}

	public void setVideo(DtVideo video) {
		this.video = video;
	}

	public Integer getCantidadVisita() {
		return cantidadVisita;
	}

	public void setCantidadVisita(int cantidadVisita) {
		this.cantidadVisita = cantidadVisita;
	}

	public DtFecha getUltimaVisita() {
		return ultimaVisita;
	}

	public void setUltimaVisita(DtFecha ultimaVisita) {
		this.ultimaVisita = ultimaVisita;
	}

	public DtVideoHistorial(DtVideo video) {
		this.video = video;
		this.cantidadVisita = 1;
		this.ultimaVisita = new DtFecha(new Date());
	}

	public void actualizar() {
		this.cantidadVisita++;
		this.ultimaVisita.setFecha(new Date());
	}

	@Override
	public int compareTo(DtVideoHistorial other) {
		if (this.cantidadVisita == null || other.getCantidadVisita() == null) {
			return 0;
		}
		return this.cantidadVisita.compareTo(other.getCantidadVisita());
	}
}
