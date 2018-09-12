package uytube.logica;

public class Puntuacion {
	private boolean valoracion;
	private Usuario usuarioPuntuador;
	
	
	public boolean getValoracion(){
		return valoracion;
	}
	public void setValoracion(boolean valoracionVideo){
		valoracion=valoracionVideo;
	}
	public Usuario getUsuario(){
		return usuarioPuntuador;
	}
	
	public Puntuacion(String nickU, boolean gusta){
		valoracion=gusta;
		UsuarioHandler usuHandler=UsuarioHandler.getInstance();
		Usuario usuarioValorador=usuHandler.find(nickU);
		usuarioPuntuador=usuarioValorador;
	}
	public String getNickPuntuador(){
		return usuarioPuntuador.getNickname();
	}
	
	
}
