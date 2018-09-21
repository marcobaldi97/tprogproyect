package uytubeLogic.logica;

public class Fabrica {
	private static Fabrica instancia;

	private Fabrica() {

	}

	public static Fabrica getInstance() {
		if (instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}

	public IUsuarioCtrl getIUsuarioCtrl() {
		return UsuarioCtrl.getInstance();
	}

	public IVideoCtrl getIVideoCtrl() {
		return VideoCtrl.getInstance();
	}
}
