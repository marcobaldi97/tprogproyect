package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import uytube.logica.Categoria;
import uytube.logica.CategoriaHandler;
import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtVideo;
import uytube.logica.ListaReproduccion;
import uytube.logica.Particular;
import uytube.logica.PorDefecto;
import uytube.logica.Video;
import uytube.logica.VideoCtrl;
import uytube.logica.VideoHandler;

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
		DtListaReproduccion[] listaVacia=new DtListaReproduccion[0];
		DtListaReproduccion[] listaActual=VCU.listarLDRPorCategoria("noExiste");
		assertEquals(null, listaActual);
		
	}
	@Test
	public void testListarLDRPorCategoriaExiste(){
		VideoCtrl VCU=VideoCtrl.getInstance();
		VideoHandler VHU=VideoHandler.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		
		Categoria categoriaE=new Categoria("nombreCategoria");
		CHU.addCategoria(categoriaE);
		PorDefecto lr1=new PorDefecto("nombLista","duenio");
		Particular lr2=new Particular("nombLista2","duenio2",false);
		categoriaE.aniadirLDR(lr1);
		categoriaE.aniadirLDR(lr2);
		DtListaReproduccion[] listasActual=VCU.listarLDRPorCategoria("nombreCategoria");
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
		DtVideo[] listaVacia=new DtVideo[0];
		DtVideo[] listaActual=VCU.listarVideosPorCategoria("noExiste");
		assertEquals(null, listaActual);
	}
	
	@Test
	public void testListarVideosPorCategoriaExiste(){
		VideoCtrl VCU=VideoCtrl.getInstance();
		CategoriaHandler CHU=CategoriaHandler.getInstance();
		
		Categoria categoriaE=new Categoria("nombreCategoria");
		CHU.addCategoria(categoriaE);
		
		DtFecha fecha=new DtFecha(new Date(0));
		DtCategoria[] cates=VCU.listarCategorias();
		DtCategoria cate=cates[0];
		
		Video video=new Video("nombre","duenio","descr",20,fecha,"hola.com",cate,true);
		Video video2=new Video("nombre2","duenio2","descr2",20,fecha,"hola2.com",cate,true);
		
		categoriaE.addVideo(video);
		categoriaE.addVideo(video2);
		
		DtVideo[] videosActual=VCU.listarVideosPorCategoria("nombreCategoria");
		DtVideo videoActual1=videosActual[0];
		DtVideo videoActual2=videosActual[1];
		DtVideo video1Dt= new DtVideo(video);
		DtVideo video2Dt= new DtVideo(video2);
		assertEquals(true,video1Dt.equals(videoActual2));
		assertEquals(true,video2Dt.equals(videoActual1));
	}
	@Test
	public void testListarComentarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testNuevoComentario() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		fail("Not yet implemented");
	}

	@Test
	public void testResponderComentario() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		fail("Not yet implemented");
	}

	@Test
	public void testValorarVideo() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		fail("Not yet implemented");
	}

	@Test
	public void testVerDetallesVideoExt() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		fail("Not yet implemented");
	}

	@Test
	public void testInfoAddVideo() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		fail("Not yet implemented");
	}

	@Test
	public void testListarVideosExisten() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		VideoHandler VHU=VideoHandler.getInstance();
				
		Categoria categoriaE=new Categoria("nombreCategoria");
		
		DtFecha fecha=new DtFecha(new Date(0));
		DtCategoria cate=new DtCategoria(categoriaE);
		
		Video video=new Video("nombre","duenio","descr",20,fecha,"hola.com",cate,true);
		Video video2=new Video("nombre2","duenio2","descr2",20,fecha,"hola2.com",cate,true);
		
		VHU.addVideo(video);
		VHU.addVideo(video2);
		DtVideo[] videosActual=VCU.listarVideos();
		DtVideo videoActual1=videosActual[0];
		DtVideo videoActual2=videosActual[1];
		DtVideo video1Dt= new DtVideo(video);
		DtVideo video2Dt= new DtVideo(video2);
		assertEquals(true,video2Dt.equals(videoActual2));
		assertEquals(true,video1Dt.equals(videoActual1));
		
	}
	@Test
	public void testListarVideosNoExisten() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		
		
		
		fail("Not yet implemented");
	}

	@Test
	public void testListarCategorias() {
		VideoCtrl VCU=VideoCtrl.getInstance();
		VCU.crearCategoria("cat1");
		VCU.crearCategoria("cat2");
		DtCategoria[] categorias= VCU.listarCategorias();
		assertEquals(true,categorias[0].getNombre()=="cat2");
		assertEquals(true,categorias[1].getNombre()=="cat1");
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

