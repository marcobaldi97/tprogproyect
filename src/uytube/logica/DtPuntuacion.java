package uytube.logica;

public class DtPuntuacion {
	private boolean valoracion;
	private String nickname;
	
	public boolean getValoracion(){
		return valoracion;
	}
	public String getNickname(){
		return nickname;
	}
	public DtPuntuacion(boolean gusta, String nickU){
		valoracion=gusta;
		nickname=nickU;
	}
	public DtPuntuacion(Puntuacion p){
		valoracion=p.getValoracion();
		nickname=p.getNickPuntuador();
	}
}
