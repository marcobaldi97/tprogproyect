package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class UsuarioHandler {
	private Map<String,Usuario> usuarios;
	private static UsuarioHandler instancia = null;
	
	private UsuarioHandler() {
		usuarios = new HashMap<String, Usuario>();
	}
	
	public void aniadirUsuario(Usuario u) {
		usuarios.put(u.getNickname(), u);
	}
	
	public void removerUsuario(Usuario u) {
		usuarios.remove(u.getNickname());
	}
	
	public Usuario find(String nickname) {
		return usuarios.get(nickname);
	}
	
	public boolean memberUsuario(Usuario u) {
		return usuarios.containsValue(u);
	}
	
	public boolean memberNickname(String n) {
		return usuarios.containsKey(n);
	}
	
	public boolean memberEmail(String e) {
		Boolean existe = false;
		for(Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
			if(e == entry.getValue().getEmail())
				existe = true;
		}
		return existe;
	}
	
    public String[] listarNicknamesUsuarios() {
    		String[] nickUsuarios = new String[usuarios.size()];
    		Integer contador = 0;
    		for(Map.Entry<String,Usuario> entry : usuarios.entrySet()) {
    			String nickU=entry.getKey();
    			nickUsuarios[contador] = nickU;
    			contador++;
    		}
    		return nickUsuarios;
        
    }
	
	public static UsuarioHandler getInstance() {
		if(instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}

}
