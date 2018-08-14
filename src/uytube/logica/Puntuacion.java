package uytube.logica;

public class Puntuacion {
	private boolean valoracion;
	private Usuario usuarioPuntuador;
	
	
	public boolean getValoracion(){
		return valoracion;
	}
	public void setValoracion(boolean v){
		valoracion=v;
	}
	public Usuario getUsuario(){
		return usuarioPuntuador;
	}
	public void setUsuario(Usuario u){
		usuarioPuntuador=u;
	}
	
	public Puntuacion(String nickU, boolean gusta){
		valoracion=gusta;
		UsuarioHandler uh=UsuarioHandler.getInstance();
		Usuario u=uh.find(nickU);
		usuarioPuntuador=u;
	}
	public String getNickPuntuador(){
		return usuarioPuntuador.getNickname();
	}
	
	
}
