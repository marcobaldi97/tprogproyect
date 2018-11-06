package uyTubePersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		DatosDePrueba pepe= new DatosDePrueba();
		pepe.cargarDatosDePrueba();
		
		em.getTransaction().begin();
		
		Fabrica fab = Fabrica.getInstance();
		IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
		uyTubePersistencia.Usuario usuarioPrueba= IUI.persistirUsuario("kairoh");
		
		em.persist(usuarioPrueba);
		em.flush();
		em.getTransaction().commit();

	}

}
