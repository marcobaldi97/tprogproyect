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

	public Privacidad getPrivado() {
		return privado;
	}

	public TipoLista getTipoLista() {
		return tipoL;
	}

	public DtCategoria[] getCategoriasLDR() {
		return categoriasLDR;
	}

	public DtListaReproduccion(String nombreL) {
		nombre = nombreL;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaUltimoVideo() {
		return ultimoVideo;
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

	public String getPropietario() {
		return propietario;
	}

}
