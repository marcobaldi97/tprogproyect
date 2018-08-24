package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import uytube.logica.DtFecha;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtUsuario;
import uytube.logica.DtVideo;
import uytube.logica.ListaReproduccion;
import uytube.logica.Usuario;
import uytube.logica.UsuarioCtrl;
import uytube.logica.UsuarioHandler;
import uytube.logica.Video;
import uytube.logica.VideoHandler;

public class UsuarioCtrlTest {

	@Test
	public void testMemberListaReproduccionDefecto() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		String nombreL="nombreListaMemberLDR por defecto";
		assertEquals(false, UCU.memberListaReproduccionDefecto(nombreL));
		UCU.nuevaListaPorDefecto(nombreL);
		assertEquals(true,UCU.memberListaReproduccionDefecto(nombreL));
	}

	@Test
	public void testMemberUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreUsuarioMember";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		assertEquals(true, UCU.memberUsuario(nombreU));
	}

	@Test
	public void testMemberListaReproduccionPropia() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreLDRMember";
		String nombreL="nombreListaLDRMember";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		assertEquals(false, UCU.memberListaReproduccionPropia(nombreU, nombreL));
		UCU.nuevaListaParticular(nombreU, nombreL, false);
		assertEquals(true, UCU.memberListaReproduccionPropia(nombreU, nombreL));
	}

	@Test
	public void testGetInstance() {
		UsuarioCtrl UCU1=UsuarioCtrl.getInstance();
		UsuarioCtrl UCU2=UsuarioCtrl.getInstance();
		assertEquals(true,UCU1==UCU2);
	}

	@Test
	public void testListarNicknamesUsuarios() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreListarNickU";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		String nombreU2="nombreListarNickU2";
		UCU.nuevoUsuario(nombreU2, "Pedro", "Peres", "www.cosoarroba6",fecha , "foto2", "canal2", "descripcion2", true, null);
		String[] usuarios=UCU.listarNicknamesUsuarios();
		boolean existe=false;
		boolean existe2=false;
		for(String nick:usuarios){
			if(nick==nombreU)
				existe=true;
			if(nick==nombreU2)
				existe2=true;
		}
		assertEquals(true, existe);
		assertEquals(true, existe2);
	}

	@Test
	public void testListarVideosCanal() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreListarVideosCanal";
		String nombreV="nombreVideoListarVideosCanal";
		String nombreV2="nombreVideoListarVideosCanal";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		UCU.aniadirVideo(nombreU, nombreV, "descr", 20, fecha, "hola.com", null, false);
		UCU.aniadirVideo(nombreU, nombreV2, "descr", 20, fecha, "hola.com", null, false);
		String[] videos=UCU.listarVideosCanal(nombreU);
		boolean existe=false;
		boolean existe2=false;
		for(String vid:videos){
			if (vid==nombreV)
				existe=true;
			if (vid==nombreV2)
				existe2=true;
		}
		assertEquals(true, existe);
		assertEquals(true, existe2);
	}

	@Test
	public void testNuevaListaPorDefecto() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreNuevaLDR por defecto";
		String nombreL="nombreLNuevaLDR por defecto";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		UCU.nuevaListaPorDefecto(nombreL);
		assertEquals(true,UCU.memberListaReproduccionDefecto(nombreL));
		assertEquals(true, UCU.memberListaReproduccionPropia(nombreU, nombreL));
	}

	@Test
	public void testNuevaListaParticular() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreNuevaLDR particular";
		String nombreL="nombreLNuevaLDR particular";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		assertEquals(false, UCU.memberListaReproduccionPropia(nombreU, nombreL));
		UCU.nuevaListaParticular(nombreU, nombreL, false);
		assertEquals(true, UCU.memberListaReproduccionPropia(nombreU, nombreL));
	}

	@Test
	public void testListarLDRdeUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombrelistarLDRUsuario";
		String nombreL="nombreLNuevaLDRUsuario";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		boolean existe=false;
		boolean existe2=false;
		String[] listas=UCU.listarLDRdeUsuario(nombreU);
		for(String list:listas){
			if(nombreL==list){
				existe=true;
			}
		}
		
		UCU.nuevaListaParticular(nombreU, nombreL, true);
		listas=UCU.listarLDRdeUsuario(nombreU);
		for(String list:listas){
			if(nombreL==list){
				existe2=true;
			}
		}
		assertEquals(false, existe);
		assertEquals(true, existe2);
	}

	@Test
	public void testAgregarYEliminarVideoLista() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		UsuarioHandler uh=UsuarioHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreagregarVideolista";
		String nombreL="nombreLagregVidLista";
		String nombreV="nombreVagregVidLista";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		UCU.aniadirVideo(nombreU, nombreV, "descripcion", 20, fecha, "www.hola.tv", null, false);
		UCU.nuevaListaParticular(nombreU, nombreL, false);
		DtVideo dt=UCU.obtenerInfoAdicVideo(nombreU, nombreV);
		Integer IDVideo=dt.getIDVideo();
		UCU.agregarVideoLista(nombreU, IDVideo, nombreL);
		Usuario u=uh.find(nombreU);
		String[] videosEnLDR=u.listarVideosPorLDR(nombreL);
		boolean existe=false;
		boolean existe2=false;
		for(String vid:videosEnLDR){
			if(vid==nombreV)
				existe=true;
		}
		assertEquals(true, existe);
		UCU.eliminarVideoLista(nombreU, IDVideo, nombreL);
		videosEnLDR=u.listarVideosPorLDR(nombreL);
		for(String vid:videosEnLDR){
			if(vid==nombreV)
				existe2=true;
		}
		assertEquals(false, existe2);
	}


	@Test
	public void testCambiarPrivLDR() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreagregarVideolista";
		String nombreL="nombreLagregVidLista";
		String nombreL2="nombreL2";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		UCU.nuevaListaParticular(nombreU, nombreL, false);
		DtListaReproduccion dtLDR=UCU.infoAdicLDR(nombreU, nombreL);
		UCU.nuevaListaPorDefecto(nombreL2);
		boolean existe=false;
		boolean existe2=false;
		existe=dtLDR.getPrivado();
		UCU.cambiarPrivLDR(nombreU, nombreL, true);
		dtLDR=UCU.infoAdicLDR(nombreU, nombreL);
		existe2=dtLDR.getPrivado();
		assertEquals(false, existe);
		assertEquals(true, existe2);
	}

	@Test
	public void testEditarDatosUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		DtFecha fecha2=new DtFecha(new Date(1));
		String nombreU="nombreEditarDatosUsuario";
		
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , "foto", "canal", "descripcion", false, null);
		DtUsuario dtUsuario=UCU.listarDatosUsuario(nombreU);
		assertEquals(true,dtUsuario.getNickname()==nombreU);
		assertEquals(true,dtUsuario.getNombre()=="Jose");
		assertEquals(true,dtUsuario.getApellido()=="Ramirez");
		assertEquals(true,dtUsuario.getEmail()=="www.cosoarroba3");
		assertEquals(true,dtUsuario.getFecha_nacimiento().equals(fecha));
		assertEquals(true,dtUsuario.getFoto()=="foto");
		UCU.editarDatosUsuario(nombreU, "Josefina", "Ramireza", fecha2, "foto2");
		dtUsuario=UCU.listarDatosUsuario(nombreU);
		assertEquals(true,dtUsuario.getNickname()==nombreU);
		assertEquals(true,dtUsuario.getNombre()=="Josefina");
		assertEquals(true,dtUsuario.getApellido()=="Ramireza");
		assertEquals(true,dtUsuario.getEmail()=="www.cosoarroba3");
		assertEquals(true,dtUsuario.getFecha_nacimiento().equals(fecha2));
		assertEquals(true,dtUsuario.getFoto()=="foto2");
	}

	@Test
	public void testSeguirUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testDejarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testAniadirVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testIngresarNuevosDatosVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerificarDispUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testNuevoUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testInfoAdicLDR() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarDatosUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testMostrarInfoCanal() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerInfoAdicVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testMemberVideoEnUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarUsuariosQueSigue() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarUsuariosQueLeSigue() {
		fail("Not yet implemented");
	}

}
