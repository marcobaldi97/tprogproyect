package uytube.logica;

public class Factory {
	private static Factory instancia;

	private Factory() {

	}

	public static Factory getInstance() {
		if (instancia == null) {
			instancia = new Factory();
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
