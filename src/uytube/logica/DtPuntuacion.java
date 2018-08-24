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
	public DtPuntuacion(Puntuacion p){
		valoracion=p.getValoracion();
		nickname=p.getNickPuntuador();
	}
}
