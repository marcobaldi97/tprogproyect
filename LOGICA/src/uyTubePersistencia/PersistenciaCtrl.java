package uyTubePersistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.event.ListSelectionEvent;

import javafx.util.Pair;

public class PersistenciaCtrl {
	public Usuario[] getUsuariosPersistidos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		List<Usuario> usuarios= em.createQuery("Select u from Usuario u").getResultList();
		return usuarios.toArray(new Usuario[0]);
	}
	
	public Map<Integer,String> listarUsuariosPersistidos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		List<Usuario> usuarios= em.createQuery("Select u from Usuario u").getResultList();
		Map<Integer,String> pares = new HashMap<Integer,String>();
		for(Usuario usuarioParticular:usuarios) {
			pares.put(usuarioParticular.getIdUsuario(), usuarioParticular.getNickname());
		}
		return pares;
		
	}
	
	public Usuario getInfoUsuario(Integer idVid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		Usuario found = em.find(Usuario.class, idVid);
		return found;
	}

}
