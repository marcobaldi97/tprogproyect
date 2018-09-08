package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;



import uytube.logica.DtCanal;
import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtUsuario;
import uytube.logica.DtVideo;
import uytube.logica.ListaReproduccion;
import uytube.logica.SystemHandler;
import uytube.logica.SystemHandler.Privacidad;
import uytube.logica.Usuario;
import uytube.logica.UsuarioCtrl;
import uytube.logica.UsuarioHandler;
import uytube.logica.Video;
import uytube.logica.VideoCtrl;
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		assertEquals(true, UCU.memberUsuario(nombreU));
	}

	@Test
	public void testMemberListaReproduccionPropia() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreLDRMember";
		String nombreL="nombreListaLDRMember";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		String nombreU2="nombreListarNickU2";
		UCU.nuevoUsuario(nombreU2, "Pedro", "Peres", "www.cosoarroba6",fecha , null, "canal2", "descripcion2", Privacidad.PRIVADO, null);
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.aniadirVideo(nombreU, nombreV, "descr", 20, fecha, "hola.com", null, Privacidad.PUBLICO);
		UCU.aniadirVideo(nombreU, nombreV2, "descr", 20, fecha, "hola.com", null, Privacidad.PUBLICO);
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.nuevaListaPorDefecto(nombreL);
		assertEquals(true,UCU.memberListaReproduccionDefecto(nombreL));
		assertEquals(true, UCU.memberListaReproduccionPropia(nombreU, nombreL));
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
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
	public void testlistarLDRParticularesdeUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombrelistarLDRPUsuario";
		String nombreL="nombreLNuevaLDRPUsuario";
		String nombreL2="nombreLNuevaLDRPUsuario2";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.nuevaListaParticular(nombreU, nombreL, true);
		UCU.nuevaListaPorDefecto(nombreL2);
		String[] listasP=UCU.listarLDRParticularesdeUsuario(nombreU);
		boolean existe=false;
		boolean existe2=false;
		for(String lista:listasP){
			if(lista==nombreL){
				existe=true;
			}
			if(lista==nombreL2){
				existe2=true;
			}
		}
		assertEquals(true,existe);
		assertEquals(false,existe2);
	}
	
	
	@Test
	public void testAgregarYEliminarVideoLista() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		UsuarioHandler uh=UsuarioHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreagregarVideolista";
		String nombreL="nombreLagregVidLista";
		String nombreV="nombreVagregVidLista";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.aniadirVideo(nombreU, nombreV, "descripcion", 20, fecha, "www.hola.tv", null, Privacidad.PUBLICO);
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
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
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
		
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		DtUsuario dtUsuario=UCU.listarDatosUsuario(nombreU);
		assertEquals(true,dtUsuario.getNickname()==nombreU);
		assertEquals(true,dtUsuario.getNombre()=="Jose");
		assertEquals(true,dtUsuario.getApellido()=="Ramirez");
		assertEquals(true,dtUsuario.getEmail()=="www.cosoarroba3");
		assertEquals(true,dtUsuario.getFecha_nacimiento().equals(fecha));
		assertEquals(true,dtUsuario.getFoto()==null);
		UCU.editarDatosUsuario(nombreU, "Josefina", "Ramireza", fecha2, null);
		dtUsuario=UCU.listarDatosUsuario(nombreU);
		assertEquals(true,dtUsuario.getNickname()==nombreU);
		assertEquals(true,dtUsuario.getNombre()=="Josefina");
		assertEquals(true,dtUsuario.getApellido()=="Ramireza");
		assertEquals(true,dtUsuario.getEmail()=="www.cosoarroba3");
		assertEquals(true,dtUsuario.getFecha_nacimiento().equals(fecha2));
		assertEquals(true,dtUsuario.getFoto()==null);
	}

	@Test
	public void testSeguiryDejardeSeguirUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		
		DtFecha fecha=new DtFecha(new Date(0));
		DtFecha fecha2=new DtFecha(new Date(1));
		String nombreU="nombreSeguirUsuario";
		String nombreU2="nombreSeguirUsuario2";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.nuevoUsuario(nombreU2, "Luis", "Rosas", "www.arrobe", fecha2, null, "canal2", "descr2", Privacidad.PRIVADO, null);
		UCU.seguirUsuario(nombreU, nombreU2);
		
		String seguidos1[]=UCU.listarUsuariosQueSigue(nombreU);
		String seguidores1[]=UCU.listarUsuariosQueLeSigue(nombreU);
		String seguidos2[]=UCU.listarUsuariosQueSigue(nombreU2);
		String seguidores2[]=UCU.listarUsuariosQueLeSigue(nombreU2);
		boolean seguidos1Ok=false;
		boolean seguidores1Ok=true;
		boolean seguidos2Ok=true;
		boolean seguidores2Ok=false;
		
		for(String nick:seguidos1){
			if(nick==nombreU2)
				seguidos1Ok=true;
		}
		for(String nick:seguidos2){
			if(nick==nombreU){
				seguidos2Ok=false;
			}
		}
		for(String nick:seguidores1){
			if(nick==nombreU2){
				seguidores1Ok=false;
			}
		}
		for(String nick:seguidores2){
			if(nick==nombreU){
				seguidores2Ok=true;
			}
		}
		assertEquals(true,seguidos1Ok);
		assertEquals(true,seguidos2Ok);
		assertEquals(true,seguidores1Ok);
		assertEquals(true,seguidores2Ok);
		UCU.dejarUsuario(nombreU2, nombreU);
		seguidos1=UCU.listarUsuariosQueSigue(nombreU);
		seguidores1=UCU.listarUsuariosQueLeSigue(nombreU);
		seguidos2=UCU.listarUsuariosQueSigue(nombreU2);
		seguidores2=UCU.listarUsuariosQueLeSigue(nombreU2);
		for(String nick:seguidos1){
			if(nick==nombreU2)
				seguidos1Ok=true;
		}
		for(String nick:seguidos2){
			if(nick==nombreU){
				seguidos2Ok=false;
			}
		}
		for(String nick:seguidores1){
			if(nick==nombreU2){
				seguidores1Ok=false;
			}
		}
		for(String nick:seguidores2){
			if(nick==nombreU){
				seguidores2Ok=true;
			}
		}
		assertEquals(true,seguidos1Ok);
		assertEquals(true,seguidos2Ok);
		assertEquals(true,seguidores1Ok);
		assertEquals(true,seguidores2Ok);
		UCU.dejarUsuario(nombreU, nombreU2);
		seguidos1=UCU.listarUsuariosQueSigue(nombreU);
		seguidores1=UCU.listarUsuariosQueLeSigue(nombreU);
		seguidos2=UCU.listarUsuariosQueSigue(nombreU2);
		seguidores2=UCU.listarUsuariosQueLeSigue(nombreU2);
		seguidos1Ok=true;
		seguidores1Ok=true;
		seguidos2Ok=true;
		seguidores2Ok=true;
		for(String nick:seguidos1){
			if(nick==nombreU2)
				seguidos1Ok=false;
		}
		for(String nick:seguidos2){
			if(nick==nombreU){
				seguidos2Ok=false;
			}
		}
		for(String nick:seguidores1){
			if(nick==nombreU2){
				seguidores1Ok=false;
			}
		}
		for(String nick:seguidores2){
			if(nick==nombreU){
				seguidores2Ok=false;
			}
		}
		assertEquals(true,seguidos1Ok);
		assertEquals(true,seguidos2Ok);
		assertEquals(true,seguidores1Ok);
		assertEquals(true,seguidores2Ok);
	}


	@Test
	public void testAniadirVideo() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		UsuarioHandler uh=UsuarioHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreaniadirvideo";
		String nombreV="nombreVaniadirVideo";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.aniadirVideo(nombreU, nombreV, "descripcion", 20, fecha, "www.hola.tv", null, Privacidad.PUBLICO);
		String[] videos=UCU.listarVideosCanal(nombreU);
		boolean existe=false;
		for (String vid:videos){
			if(vid==nombreV)
				existe=true;
		}
		assertEquals(true, existe);
	}

	@Test
	public void testIngresarNuevosDatosVideo() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		VideoCtrl VCU=VideoCtrl.getInstance();
		SystemHandler sh=SystemHandler.getInstance();
		VCU.crearCategoria("catego");
		DtCategoria[] categoriasEnSistema=VCU.listarCategorias();
		DtCategoria cate=null;
		for(DtCategoria categoria:categoriasEnSistema){
			if(categoria.getNombre()=="catego")
				cate=categoria;
		}
		UsuarioHandler uh=UsuarioHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		DtFecha fecha2=new DtFecha(new Date(3));
		String nombreU="nombreingresarNuevosDatosVideo";
		String nombreV="nombreVingresarNuevosDatosVideo";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcionU", Privacidad.PUBLICO, null);
		UCU.aniadirVideo(nombreU, nombreV, "descripcion", 20, fecha, "www.hola.tv", null, Privacidad.PUBLICO);
		DtVideo dtVid=UCU.obtenerInfoAdicVideo(nombreU, nombreV);
		assertEquals(true,dtVid.getNombre()==nombreV);
		assertEquals(true,dtVid.getDescripcion()=="descripcion");
		assertEquals(true,dtVid.getDuracion()==20);
		assertEquals(true,dtVid.getFechaPublicacion()==fecha);
		assertEquals(true,dtVid.getUrl()=="www.hola.tv");
		assertEquals(true,dtVid.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		assertEquals(true,dtVid.getPrivacidad()==Privacidad.PUBLICO);
		
		UCU.ingresarNuevosDatosVideo(nombreU, nombreV, "nuevaDescr", 30, fecha2, "holanuevo.tv", cate, Privacidad.PRIVADO);
		dtVid=UCU.obtenerInfoAdicVideo(nombreU, nombreV);
		assertEquals(true,dtVid.getNombre()==nombreV);
		assertEquals(true,dtVid.getDescripcion()=="nuevaDescr");
		assertEquals(true,dtVid.getDuracion()==30);
		assertEquals(true,dtVid.getFechaPublicacion()==fecha2);
		assertEquals(true,dtVid.getUrl()=="holanuevo.tv");
		assertEquals(true,dtVid.getCategoria().equals(cate));
		assertEquals(true,dtVid.getPrivacidad()==Privacidad.PRIVADO);
	}

	@Test
	public void testVerificarDispUsuario() {
		DtFecha fecha=new DtFecha(new Date(0));
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		String nombreU="nombreVerifDispUsuario";
		String nombreU2="nombreVerifDispUsuario2";
		String emailU="emailVerifDispUsuario";
		String emailU2="emailVerfDispUsuario2";
		assertEquals(true,UCU.verificarDispUsuario(nombreU, emailU));
		UCU.nuevoUsuario(nombreU, "Jose", "Gimenez", emailU, fecha, null, "elnombredelpepe", "describido", Privacidad.PRIVADO, null);
		assertEquals(false,UCU.verificarDispUsuario(nombreU, emailU));
		assertEquals(false,UCU.verificarDispUsuario(nombreU, emailU2));
		assertEquals(false,UCU.verificarDispUsuario(nombreU2, emailU));
		assertEquals(false,UCU.verificarDispUsuario(nombreU, emailU2));
		assertEquals(true,UCU.verificarDispUsuario(nombreU2, emailU2));
		UCU.nuevoUsuario(nombreU2, "Pedro", "Rodriguez", emailU2, fecha, null, "elnombredelpedro", "describidisimo", Privacidad.PRIVADO, null);
		assertEquals(false,UCU.verificarDispUsuario(nombreU2, emailU2));
	}


	@Test
	public void testInfoAdicLDR() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreagregarInfoAdicLDR";
		String nombreL="nombreLagregInfoAdicLDR";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.nuevaListaParticular(nombreU, nombreL, false);
		DtListaReproduccion dtLDR=UCU.infoAdicLDR(nombreU, nombreL);
		assertEquals(true,dtLDR.getNombre()==nombreL);
		assertEquals(true,dtLDR.getPropietario()==nombreU);
		assertEquals(true,dtLDR.getCategoriasLDR().length==0);
		
	}

	@Test
	public void testListarDatosUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreagregarInfoAdicLDR";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		DtUsuario usuarioActual=UCU.listarDatosUsuario(nombreU);
		assertEquals(true,usuarioActual.getNickname()==nombreU);
		assertEquals(true,usuarioActual.getNombre()=="Jose");
		assertEquals(true,usuarioActual.getApellido()=="Ramirez");
		assertEquals(true,usuarioActual.getEmail()=="www.cosoarroba3");
		assertEquals(true,usuarioActual.getFecha_nacimiento().equals(fecha));
		assertEquals(true,usuarioActual.getFoto()==null);
		
	}

	@Test
	public void testMostrarInfoCanal() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		SystemHandler sh=SystemHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreMostrarInfoCanal";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		DtCanal dtActual=UCU.mostrarInfoCanal(nombreU);
		DtCanal dtActual2=UCU.mostrarInfoCanal(nombreU);
		assertEquals(true,dtActual.equals(dtActual2));
		assertEquals(true,dtActual.getNombre()=="canal");
		assertEquals(true,dtActual.getDescripcion()=="descripcion");
		assertEquals(true,dtActual.getPrivacidad()==Privacidad.PUBLICO);
		assertEquals(true,dtActual.getCategoria().equals(new DtCategoria(sh.getSinCat())));
	}
	@Test
	public void testModificarDatosCanal(){
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		VideoCtrl VCU=VideoCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		SystemHandler sh=SystemHandler.getInstance();
		String nombreU="nombreModificarDatosCanal";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PRIVADO, null);
		DtCanal dtActual=UCU.mostrarInfoCanal(nombreU);
		assertEquals("canal",dtActual.getNombre());
		assertEquals("descripcion",dtActual.getDescripcion());
		assertEquals(Privacidad.PRIVADO,dtActual.getPrivacidad());
		assertEquals(true,dtActual.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		String nombreCat="nuevaCat";
		VCU.crearCategoria(nombreCat);
		UCU.modificarDatosCanal(nombreU, "nomCanal", "nuevaDesc", Privacidad.PRIVADO, nombreCat);
		dtActual=UCU.mostrarInfoCanal(nombreU);
		assertEquals("nomCanal",dtActual.getNombre());
		assertEquals("nuevaDesc",dtActual.getDescripcion());
		assertEquals(Privacidad.PRIVADO,dtActual.getPrivacidad());
		assertEquals(nombreCat,dtActual.getCategoria().getNombre());
		UCU.modificarDatosCanal(nombreU, "nomCanal2", "nuevaDesc2", Privacidad.PUBLICO, null);
		dtActual=UCU.mostrarInfoCanal(nombreU);
		assertEquals("nomCanal2",dtActual.getNombre());
		assertEquals("nuevaDesc2",dtActual.getDescripcion());
		assertEquals(Privacidad.PUBLICO,dtActual.getPrivacidad());
		assertEquals(true,dtActual.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		DtCanal dtActual2=UCU.mostrarInfoCanal(nombreU);
		assertEquals(true,dtActual.equals(dtActual2));
	}

	@Test
	public void testObtenerInfoAdicVideo() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		SystemHandler sh=SystemHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreInfoAdicVideo";
		String nombreV="nombreVInfoAdicVideo";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.aniadirVideo(nombreU, nombreV, "descrito", 40, fecha, "url", null, Privacidad.PUBLICO);
		DtVideo video=UCU.obtenerInfoAdicVideo(nombreU, nombreV);
		assertEquals(true,video.getNombre()==nombreV);
		assertEquals(true,video.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		assertEquals(true,video.getDescripcion()=="descrito");
		assertEquals(true,video.getDuracion()==40);
		assertEquals(true,video.getFechaPublicacion().equals(fecha));
		assertEquals(true,video.getPrivacidad()==Privacidad.PUBLICO);
		
		
	}

	@Test
	public void testMemberVideoEnUsuario() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreMemberVideoEnUsuario";
		String nombreV="nombreVMemberVideoEnUsuario";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		assertEquals(false,UCU.memberVideoEnUsuario(nombreU, nombreV));
		UCU.aniadirVideo(nombreU, nombreV, "descrito", 40, fecha, "url", null, Privacidad.PUBLICO);
		assertEquals(true,UCU.memberVideoEnUsuario(nombreU, nombreV));
	}
	
	@Test
	public void testListarYObtenerVideosdeLDR() {
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreU="nombreLYOVLDR";
		String nombreV1="nombreVLYOVLDR1";
		String nombreV2="nombreVLYOVLDR2";
		String nombreL="nombreLYOVLDR";
		UCU.nuevoUsuario(nombreU, "Jose", "Ramirez", "www.cosoarroba3",fecha , null, "canal", "descripcion", Privacidad.PUBLICO, null);
		UCU.nuevaListaParticular(nombreU, nombreL, true);
		UCU.aniadirVideo(nombreU, nombreV1, "descrito", 30, fecha, "url", null, Privacidad.PRIVADO);
		UCU.aniadirVideo(nombreU, nombreV2, "descrito2", 40, fecha, "url2", null, Privacidad.PUBLICO);
		DtVideo video1=UCU.obtenerInfoAdicVideo(nombreU, nombreV1);
		DtVideo video2=UCU.obtenerInfoAdicVideo(nombreU, nombreV2);
		String[] listadoVideosLDR=UCU.listarVideosListaReproduccionUsuario(nombreU, nombreL);
		DtVideo[] infoVideosLDR=UCU.obtenerDtsVideosListaReproduccionUsuario(nombreU, nombreL);
		assertEquals(false,UCU.memberVideoLista(nombreU, 1, nombreL));
		assertEquals(true,listadoVideosLDR.length==0);
		assertEquals(true,infoVideosLDR.length==0);
		UCU.agregarVideoLista(nombreU, video1.getIDVideo(), nombreL);
		UCU.agregarVideoLista(nombreU, video2.getIDVideo(), nombreL);
		listadoVideosLDR=UCU.listarVideosListaReproduccionUsuario(nombreU, nombreL);
		infoVideosLDR=UCU.obtenerDtsVideosListaReproduccionUsuario(nombreU, nombreL);
		assertEquals(true,UCU.memberVideoLista(nombreU, infoVideosLDR[0].getIDVideo(), nombreL));
		assertEquals(true,UCU.memberVideoLista(nombreU, infoVideosLDR[1].getIDVideo(), nombreL));
		assertEquals(true,listadoVideosLDR.length==2);
		assertEquals(true,infoVideosLDR.length==2);
		boolean existe1enListado=false;
		boolean existe2enListado=false;
		boolean existe1enData=false;
		boolean existe2enData=false;
		
		for(String nomVideo:listadoVideosLDR){
			if(nomVideo==nombreV1){
				existe1enListado=true;
			}
			if(nomVideo==nombreV2){
				existe2enListado=true;
			}
			
		}
		for(DtVideo dtActual:infoVideosLDR){
			if(dtActual.equals(video1)){
				existe1enData=true;
			}
			if(dtActual.equals(video2)){
				existe2enData=true;
			}
		}
		assertEquals(true,existe1enListado);
		assertEquals(true,existe2enListado);
		assertEquals(true,existe1enData);
		assertEquals(true,existe2enData);
		
	}
}
