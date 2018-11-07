package uyTubePersistencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	
	public Pair<Integer,String>[] listarUsuariosPersistidos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		List<Usuario> usuarios= em.createQuery("Select u from Usuario u").getResultList();
		List<Pair<Integer,String>> nicknames = new ArrayList<Pair<Integer,String>>();
		for(Usuario usuarioParticular:usuarios) {
			nicknames.add(new Pair<Integer,String>(usuarioParticular.getIdUsuario(),usuarioParticular.getNickname()));
		}
		Pair<Integer,String>[] pares=nicknames.toArray(new Pair[0]);
		return pares;
		
	}
	
	public Usuario getInfoUsuario(Integer idVid) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		Usuario found = em.find(Usuario.class, idVid);
		return found;
	}

}
