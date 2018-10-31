/**
 * 
 */
package uytubeLogic.logica;

import java.util.Date;

/**
 * @author Santiago Alaniz
 *
 */
public class DtVideoHistorial {

	private DtVideo video;
	private int cantidadVisita;
	private DtFecha ultimaVisita;
	
	public DtVideoHistorial(DtVideo video) 
	{
		this.video=video;
		this.cantidadVisita=1;
		this.ultimaVisita= new DtFecha(new Date());
	}

	public void actualizar() 
	{
		this.cantidadVisita++;
		this.ultimaVisita.setFecha(new Date());
	}
}
