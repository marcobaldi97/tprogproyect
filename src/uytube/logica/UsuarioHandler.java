package uytube.logica;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioHandler {
	private Map<String,Usuario> usuarios;
	private static UsuarioHandler instancia = null;
	
	public UsuarioHandler() {
		usuarios = new HashMap<String, Usuario>();
	}
	
	public void añadirUsuario(Usuario u) {
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
	
    public Usuario[] getUsuarios() {
        if (usuarios.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuarios.values();
            Object[] o = usrs.toArray();
            Usuario[] usuariosA = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuariosA[i] = (Usuario) o[i];
            }

            return usuariosA;
        }
    }
	
	public static UsuarioHandler getInstance() {
		if(instancia == null)
			instancia = new UsuarioHandler();
		return instancia;
	}

}
