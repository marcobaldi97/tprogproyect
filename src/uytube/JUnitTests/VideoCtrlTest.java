package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import uytube.logica.Categoria;
import uytube.logica.CategoriaHandler;
import uytube.logica.DtCategoria;
import uytube.logica.DtComentario;
import uytube.logica.DtFecha;
import uytube.logica.DtInfoVideo;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtPuntuacion;
import uytube.logica.DtUsuario;
import uytube.logica.DtVideo;
import uytube.logica.ListaReproduccion;
import uytube.logica.Particular;
import uytube.logica.PorDefecto;
import uytube.logica.Usuario;
import uytube.logica.UsuarioCtrl;
import uytube.logica.Video;
import uytube.logica.VideoCtrl;
import uytube.logica.VideoHandler;
//SECO
public class VideoCtrlTest {

	@Test
	public void testGetInstance() {
		VideoCtrl VCU1,VCU2;
		VCU1=VideoCtrl.getInstance();
		VCU2=VideoCtrl.getInstance();
		assertEquals(true, VCU1==VCU2);
	}

	@Test
	public void testListarLDRPorCategoriaNoExiste() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		DtListaReproduccion[] listaActual=VCU.listarLDRPorCategoria("noExisteLDRNE");
		assertEquals(null, listaActual);
		
	}
	@Test
	public void testListarLDRPorCategoriaExiste(){
		VideoCtrl VCU=VideoCtrl.getInstance();
		VideoHandler VHU=VideoHandler.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		
		Categoria categoriaE=new Categoria("nombreCategoriaListarLDRE");
		CHU.addCategoria(categoriaE);
		PorDefecto lr1=new PorDefecto("nombListaListarLDRE","duenioListarLDRE");
		Particular lr2=new Particular("nombLista2ListarLDRE","duenio2ListarLDRE",false);
		categoriaE.aniadirLDR(lr1);
		categoriaE.aniadirLDR(lr2);
		DtListaReproduccion[] listasActual=VCU.listarLDRPorCategoria("nombreCategoriaListarLDRE");
		DtListaReproduccion listaActual1=listasActual[0];
		DtListaReproduccion listaActual2=listasActual[1];
		DtListaReproduccion dtLista1=new DtListaReproduccion(lr1);
		DtListaReproduccion dtLista2=new DtListaReproduccion(lr2);
		assertEquals(true,listaActual2.equals(dtLista2));
		assertEquals(true,listaActual1.equals(dtLista1));
		
		
		
	}

	@Test
	public void testListarVideosPorCategoriaNoExiste() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		DtVideo[] listaActual=VCU.listarVideosPorCategoria("noExisteLVNE");
		assertEquals(null, listaActual);
	}
	
	@Test
	public void testListarVideosPorCategoriaExiste(){
		VideoCtrl VCU=VideoCtrl.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		
		Categoria categoriaE=new Categoria("nombreCategoriaListarVE");
		CHU.addCategoria(categoriaE);
		
		DtFecha fecha=new DtFecha(new Date(0));
		DtCategoria[] cates=VCU.listarCategorias();
		DtCategoria cate=cates[0];
		
		Video video=new Video("nombreLPCE","duenioLPCE","descr",20,fecha,"hola.com",cate,true);
		Video video2=new Video("nombre2LPCE","duenio2LPCE","descr2",20,fecha,"hola2.com",cate,true);
		
		categoriaE.addVideo(video);
		categoriaE.addVideo(video2);
		
		DtVideo[] videosActual=VCU.listarVideosPorCategoria("nombreCategoriaListarVE");
		DtVideo videoActual1=videosActual[0];
		DtVideo videoActual2=videosActual[1];
		DtVideo video1Dt= new DtVideo(video);
		DtVideo video2Dt= new DtVideo(video2);
		assertEquals(true,video1Dt.equals(videoActual1));
		assertEquals(true,video2Dt.equals(videoActual2));
	}
	@Test
	public void testComentarios() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		String duenioVideo="duenioLC";
		String comentadorVideo1="comentador1LC";

		UCU.nuevoUsuario(duenioVideo,"Jose","Perez","email", fecha,null,"duenioCanal","descripcion",true,"nombreCategoria");
		UCU.nuevoUsuario(comentadorVideo1,"Roberto","Rodriguez","email2", fecha,null,"duenioCanal2","descripcion2",true,"nombreCategoria");
		
		String nombreVideo="nombreListarComentarios";
		UCU.aniadirVideo(duenioVideo,nombreVideo,"descr",20,fecha,"hola.com",null,true);
		DtVideo dtVideo=UCU.obtenerInfoAdicVideo(duenioVideo, nombreVideo);
		VCU.nuevoComentario(dtVideo.getIDVideo(), comentadorVideo1, fecha, "contenido");
		Integer IDCOM=VCU.verDetallesVideoExt(dtVideo.getIDVideo()).getComentarios()[0].getIDComentario();
		VCU.responderComentario(dtVideo.getIDVideo(), IDCOM, comentadorVideo1, fecha, "respuesta1");
		DtComentario[] ComentActuales=VCU.listarComentarios(dtVideo.getIDVideo());
		assertEquals(true, ComentActuales[0].getEsPadre()==true);
		assertEquals(true, ComentActuales[0].getNickUsuario()==comentadorVideo1);
		assertEquals(true, ComentActuales[0].getIDComentario()==IDCOM);
		assertEquals(true, ComentActuales[0].getRespuestas().length==1);
		assertEquals(true, ComentActuales[0].getRespuestas()[0].getNickUsuario()==comentadorVideo1);
		assertEquals(true, ComentActuales[0].getRespuestas()[0].getEsPadre()==false);
		assertEquals(true, ComentActuales[0].getRespuestas()[0].getRespuestas().length==0);
		
	}

	@Test
	public void testValorarVideo() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		VideoHandler VHU=VideoHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		
		String duenioVideo="duenioVV";
		String gustaVideo1="gustaVV";
		String noGustaVideo1="nogustaVV";
		UCU.nuevoUsuario(duenioVideo,"Jose","Perez","email", fecha,null,"duenioCanal","descripcion",true,"nombreCategoria");
		UCU.nuevoUsuario(gustaVideo1,"Juan","Gimenez","email3", fecha,null,"duenioCanal3","descripcion3",true,"nombreCategoria");
		UCU.nuevoUsuario(noGustaVideo1,"Pablo","Pereira","email4", fecha,null,"duenioCanal4","descripcion4",true,"nombreCategoria");
		
		String nombreVideo="nombreValorarVideo";
		UCU.aniadirVideo(duenioVideo,nombreVideo,"descr",20,fecha,"hola.com",null,true);
		
		DtVideo dtVideo=UCU.obtenerInfoAdicVideo(duenioVideo, nombreVideo);
		VCU.valorarVideo(dtVideo.getIDVideo(),gustaVideo1 , true);
		VCU.valorarVideo(dtVideo.getIDVideo(), noGustaVideo1, false);
		Video videoSubido=VHU.find(dtVideo.getIDVideo());
		DtPuntuacion[] puntuaciones=videoSubido.getPuntuaciones();
		assertEquals(true, puntuaciones[0].getNickname()==gustaVideo1);
		assertEquals(true, puntuaciones[0].getValoracion()==true);
		assertEquals(true, puntuaciones[1].getNickname()==noGustaVideo1);
		assertEquals(true, puntuaciones[1].getValoracion()==false);
		VCU.valorarVideo(dtVideo.getIDVideo(), gustaVideo1, false);
		puntuaciones=videoSubido.getPuntuaciones();
		assertEquals(true, puntuaciones[0].getValoracion()==false);
	}

	@Test
	public void testVerDetallesVideoExt() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		VCU.crearCategoria("nombreCategoriaVDE");
		DtCategoria[] cates=VCU.listarCategorias();
		DtCategoria cate=cates[0];
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreVideo="nombreDVE";
		String duenioVideo="duenioDVE";
		String comentadorVideo1="comentador1DVE";
		String gustaVideo1="gustaDVE";
		String noGustaVideo1="nogustaDVE";
		UCU.nuevoUsuario(duenioVideo,"Jose","Perez","email", fecha,null,"duenioCanal","descripcion",true,"nombreCategoria");
		UCU.nuevoUsuario(comentadorVideo1,"Roberto","Rodriguez","email2", fecha,null,"duenioCanal2","descripcion2",true,"nombreCategoria");
		UCU.nuevoUsuario(gustaVideo1,"Juan","Gimenez","email3", fecha,null,"duenioCanal3","descripcion3",true,"nombreCategoria");
		UCU.nuevoUsuario(noGustaVideo1,"Pablo","Pereira","email4", fecha,null,"duenioCanal4","descripcion4",true,"nombreCategoria");
		DtUsuario gustaVideo =UCU.listarDatosUsuario(gustaVideo1);
		DtUsuario noGustaVideo =UCU.listarDatosUsuario(noGustaVideo1);
		UCU.aniadirVideo(duenioVideo,nombreVideo,"descr",20,fecha,"hola.com",cate,true);
		DtVideo dtVideo=UCU.obtenerInfoAdicVideo(duenioVideo, nombreVideo);
		VCU.nuevoComentario(dtVideo.getIDVideo(),comentadorVideo1 , fecha, "hola que ase");
		VCU.valorarVideo(dtVideo.getIDVideo(),gustaVideo1 , true);
		VCU.valorarVideo(dtVideo.getIDVideo(), noGustaVideo1, false);
		
		DtInfoVideo infoActual=VCU.verDetallesVideoExt(dtVideo.getIDVideo());
		DtComentario[] comentariosActual=infoActual.getComentarios();
		DtUsuario[] gustaActual=infoActual.getUsuariosGusta();
		DtUsuario[] noGustaActual=infoActual.getUsuariosNoGusta();
		DtVideo dtVideoActual=infoActual.getInfoVideo();
		
		//assert campo por campo
		assertEquals(true,comentariosActual.length==1);
		assertEquals(true,dtVideo.equals(dtVideoActual));
		assertEquals(true,gustaVideo.equals(gustaActual[0]));
		assertEquals(true,noGustaVideo.equals(noGustaActual[0]));
		//fail("Not yet implemented");
	}

	@Test
	public void testInfoAddVideo() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		VCU.crearCategoria("nombreCategoria");
		DtCategoria[] cates=VCU.listarCategorias();
		DtCategoria cate=cates[0];
		DtFecha fecha=new DtFecha(new Date(0));
		String nombreVideo="nombreIAD";
		String duenioVideo="duenioIAD";
		UCU.nuevoUsuario(duenioVideo,"Jose","Perez","email", fecha,null,"duenioCanal","descripcion",true,"nombreCategoria");
		UCU.aniadirVideo(duenioVideo,nombreVideo,"descr",20,fecha,"hola.com",cate,true);		
		DtVideo infoActual=VCU.infoAddVideo(UCU.obtenerInfoAdicVideo(duenioVideo, nombreVideo).getIDVideo());
		assertEquals(true, infoActual.getNombre()==nombreVideo);
		assertEquals(true, infoActual.getCategoria().equals(cate));
		assertEquals(true, infoActual.getDescripcion()=="descr");
		assertEquals(true, infoActual.getPrivacidad()==true);
	}

	@Test
	public void testListarVideosExisten() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		
		Categoria categoriaE=new Categoria("nombreCategoria");
		CHU.addCategoria(categoriaE);
		DtFecha fecha=new DtFecha(new Date(0));
		DtCategoria cate1=null;
		DtCategoria cate2=new DtCategoria(categoriaE);
		
		Video video=new Video("nombre","duenio","descr",20,fecha,"hola.com",cate1,true);
		Video video2=new Video("nombre2","duenio2","descr2",20,fecha,"hola2.com",cate2,true);
		
		categoriaE.addVideo(video2);
		DtVideo[] videosListados=VCU.listarVideos();
		DtVideo videoActual1=VCU.infoAddVideo(video.getIDVideo());
		DtVideo videoActual2=VCU.infoAddVideo(video2.getIDVideo());
		DtVideo video1Dt= new DtVideo(video);
		DtVideo video2Dt= new DtVideo(video2);
		assertEquals(true,video2Dt.equals(videoActual2));
		assertEquals(true,video1Dt.equals(videoActual1));
		
	}

	@Test
	public void testListarCategorias() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		VCU.crearCategoria("cat1ListarCategorias");
		VCU.crearCategoria("cat2ListarCategorias");
		DtCategoria[] categorias= VCU.listarCategorias();
		boolean existe=false;
		boolean existe2=false;
		for(DtCategoria cat:categorias){
			if(cat.getNombre()=="cat1ListarCategorias"){
				existe=true;
			}
			if(cat.getNombre()=="cat2ListarCategorias"){
				existe2=true;
			}
		}
		assertEquals(true,existe);
		assertEquals(true,existe2);
	}

	@Test
	public void testCrearCategoria() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		VCU.crearCategoria("categoria");
		assertEquals(true, CHU.isMember("categoria"));
		assertEquals(true, VCU.existeCategoria("categoria"));
	}

	@Test
	public void testExisteCategoriaSi() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		VCU.crearCategoria("existe");
		assertEquals(true, VCU.existeCategoria("existe"));
	}
	@Test
	public void testExisteCategoriaNo() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		assertEquals(false, VCU.existeCategoria("noExiste"));
	}

}

