package uytubeLogic.logica;

import java.util.Date;

import uytubeLogic.logica.ListaReproduccion.TipoLista;
import uytubeLogic.logica.SystemHandler.Privacidad;

public class DtListaReproduccion {
	private String nombre;
	private String propietario;
	private Privacidad privado;
	private DtCategoria[] categoriasLDR;
	private TipoLista tipoL;
	private Date ultimoVideo;

	public DtListaReproduccion(PorDefecto ldr) {
		nombre = ldr.getNombre();
		propietario = ldr.getPropietario();
		privado = Privacidad.PRIVADO;
		categoriasLDR = ldr.getInfoCategorias();
		tipoL = TipoLista.PORDEFECTO;
		ultimoVideo = ldr.getFechaUltimoVideo();
	}

	public DtListaReproduccion(Particular ldr) {
		nombre = ldr.getNombre();
		propietario = ldr.getPropietario();
		privado = ldr.getPrivado();
		categoriasLDR = ldr.getInfoCategorias();
		tipoL = TipoLista.PARTICULAR;
		ultimoVideo = ldr.getFechaUltimoVideo();
	}


	public DtListaReproduccion(String nombreL) {
		nombre = nombreL;
	}

	public boolean equals(Object o) {
		if (o instanceof DtListaReproduccion) {
			DtListaReproduccion other = (DtListaReproduccion) o;
			return nombre == other.getNombre() && propietario == other.getPropietario();
		}
		return false;
	}

	public boolean equals(DtListaReproduccion other) {
		return nombre == other.getNombre() && propietario == other.getPropietario();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Privacidad getPrivado() {
		return privado;
	}

	public void setPrivado(Privacidad privado) {
		this.privado = privado;
	}

	public DtCategoria[] getCategoriasLDR() {
		return categoriasLDR;
	}

	public void setCategoriasLDR(DtCategoria[] categoriasLDR) {
		this.categoriasLDR = categoriasLDR;
	}

	public TipoLista getTipoL() {
		return tipoL;
	}

	public void setTipoL(TipoLista tipoL) {
		this.tipoL = tipoL;
	}

	public Date getUltimoVideo() {
		return ultimoVideo;
	}

	public void setUltimoVideo(Date ultimoVideo) {
		this.ultimoVideo = ultimoVideo;
	}


}
