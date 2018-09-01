package uytube.logica;

public class PorDefecto extends ListaReproduccion{

	public PorDefecto(String n, String pro) {
		super(n,pro);
	}

	@Override
	public DtListaReproduccion verDetallesListareproduccion() {
		DtListaReproduccion dt = new DtListaReproduccion(this); 
		return dt;
	}

	@Override
	public void agregarVideo(Video v) {

		//videos.put(v.getIDVideo(), v);
		addVideoToMap(v);
		v.aniadirListaReproduccion(this);

	}

	@Override
	public void removerVideo(Integer id) {
		removeVideoFromMap(id);
	}

}
