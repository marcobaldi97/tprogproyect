package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import uytube.logica.Categoria;
import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.DtVideo;
import uytube.logica.SystemHandler;
import uytube.logica.Video;
import uytube.logica.VideoCtrl;

public class VideoTest {

	@Test
	public void testIngresarNuevosDatosVideo() {
		String nombreVideo="nombreINDV";
		SystemHandler sh=SystemHandler.getInstance();
		DtFecha fecha=new DtFecha(new Date(0));
		DtFecha fechaN=new DtFecha(new Date(2));
		Categoria categoriaE=new Categoria("cateINDV");
		DtCategoria cate1=null;
		DtCategoria cate2=new DtCategoria(categoriaE);
		VideoCtrl VCU=VideoCtrl.getInstance();
		VCU.crearCategoria("cateINDV");
		Video video=new Video(nombreVideo,"duenio","descr",20,fecha,"hola.com",cate2,true);
		assertEquals(true,video.getNombre()==nombreVideo);
		assertEquals(true,video.getCategoria().equals(cate2));
		assertEquals(true,video.getPropietario()=="duenio");
		assertEquals(true,video.getDescripcion()=="descr");
		assertEquals(true,video.getFechaPublicacion().equals(fecha));
		assertEquals(true,video.getPrivacidad()==true);
		assertEquals(true,video.getDuracion()==20);
		assertEquals(true,video.getURL()=="hola.com");
		video.ingresarNuevosDatosVideo("nuevaDesc", 30, fechaN, "hola2.com", cate1, false);
		assertEquals(true,video.getNombre()==nombreVideo);
		assertEquals(true,video.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		assertEquals(true,video.getPropietario()=="duenio");
		assertEquals(true,video.getDescripcion()=="nuevaDesc");
		assertEquals(true,video.getFechaPublicacion().equals(fechaN));
		assertEquals(true,video.getPrivacidad()==false);
		assertEquals(true,video.getDuracion()==30);
		assertEquals(true,video.getURL()=="hola2.com");
	}

	@Test
	public void testNuevoComentario() {
		fail("Not yet implemented");
	}

	@Test
	public void testResponderComentario() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPuntuacion() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerDetallesVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testValorarVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInfoVideoExt() {
		fail("Not yet implemented");
	}

}
