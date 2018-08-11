package uytube.logica;
import java.util.HashMap;
import java.util.Map;

public class CategoriaHandler {
	private Map<String,Categoria> categorias;
	private static CategoriaHandler instancia = null;
	
	private CategoriaHandler() {
		// TODO Auto-generated constructor stub
		categorias = new HashMap<String,Categoria>();
	}
	
	public static CategoriaHandler getInstance() {
		if (instancia == null)
			instancia = new CategoriaHandler();
		return instancia;
	}
	
	public void addCategoria(Categoria c) {
		categorias.put(c.getNombre(), c);
	}
	
	public void removerCategoria(Categoria c) {
		categorias.remove(c.getNombre());
	}
	
	public Categoria find(String s) {
		return categorias.get(s);
	}
	
	public DtCategoria[] listarCategorias() {
		DtCategoria[] dtCategorias = new DtCategoria[categorias.size()];
		Integer contador = 0;
		for(Map.Entry<String, Categoria> entry : categorias.entrySet()) {
			String nom = entry.getValue().getNombre();
			dtCategorias[contador] = new DtCategoria(nom);
			contador++;
		}
		return dtCategorias;
	}

}
