package uyTubePersistencia;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;

public class Test {

	public static void test() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("UyTubeJPA");
		EntityManager em = emf.createEntityManager();
		DatosDePrueba pepe= new DatosDePrueba();
		pepe.cargarDatosDePrueba();
		
		em.getTransaction().begin();
		
		Fabrica fab = Fabrica.getInstance();
		IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
		uyTubePersistencia.Usuario usuarioPrueba= IUI.persistirUsuario("kairoh");
		uyTubePersistencia.Usuario usuarioPrueba2 = IUI.persistirUsuario("tabarec");
		
		em.persist(usuarioPrueba);
		em.persist(usuarioPrueba2);
		em.flush();
		em.getTransaction().commit();
		
		for (Object obj : em.createQuery("Select f from Usuario f").getResultList()) {
			Usuario f = (Usuario) obj;
			System.out.println("************Usuario obtenido con una query: " + f.getNickname()+" con ID autogenerada: "+f.getIdUsuario());
		}
		Usuario found=em.find(Usuario.class, 7);
		if(found!=null) {
			System.out.println(found.getFechaNacimiento());
			Canal foundCanal=found.getCanalPropio();
			System.out.println(found.getCanalPropio().getNombre());
			Map<String, ListaReproduccion> lists = foundCanal.getListasReproduccion();
			for(Entry<String, ListaReproduccion> entry: lists.entrySet()) {
				System.out.println("LISTA");
				System.out.println("ID: "+entry.getValue().getIdListaRep());
				System.out.println("Nom: "+entry.getValue().getNombre());
				System.out.println("	VIDEOS EN LISTA:");
				for(Entry<Integer, Video> entryV:entry.getValue().getVideos().entrySet()) {
					System.out.println("	ID Vid: "+entryV.getValue().getIdVideo());
					System.out.println("	Nom Vid: "+entryV.getValue().getNombre());
				}
			}
			Map<String, Video> vids =foundCanal.getVideos();
			System.out.println("VIDEOS NO EN LISTAS:");
			for(Entry<String, Video> entryV: vids.entrySet()) {
				System.out.println("	ID Vid: "+entryV.getValue().getIdVideo());
				System.out.println("	Nom Vid: "+entryV.getValue().getNombre());
				
			}
		}
	}

}
