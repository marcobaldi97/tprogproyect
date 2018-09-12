package uytube.logica;

import java.util.HashMap;
import java.util.Map;

public class CategoriaHandler {
	private Map<String, Categoria> categorias;
	private static CategoriaHandler instancia = null;

	private CategoriaHandler() {
		// TODO Auto-generated constructor stub
		categorias = new HashMap<String, Categoria>();
	}

	public static CategoriaHandler getInstance() {
		if (instancia == null)
			instancia = new CategoriaHandler();
		return instancia;
	}

	public void addCategoria(Categoria categ) {
		categorias.put(categ.getNombre(), categ);
	}

	public void removerCategoria(Categoria categ) {
		categorias.remove(categ.getNombre());
	}

	public Categoria find(String nombreCateg) {
		return categorias.get(nombreCateg);
	}

	public DtCategoria[] listarCategorias() {
		DtCategoria[] dtCategorias = new DtCategoria[categorias.size()];
		Integer contador = 0;
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {
			dtCategorias[contador] = new DtCategoria(entry.getValue());
			contador++;
		}
		return dtCategorias;
	}

	public boolean isMember(String nomCat) {
		return categorias.containsKey(nomCat);
	}

}
