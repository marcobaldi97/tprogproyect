package uytube.JUnitTests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import uytube.logica.Categoria;
import uytube.logica.DtCategoria;
import uytube.logica.DtComentario;
import uytube.logica.DtFecha;
import uytube.logica.DtPuntuacion;
import uytube.logica.DtVideo;
import uytube.logica.Puntuacion;
import uytube.logica.SystemHandler;
import uytube.logica.SystemHandler.Privacidad;
import uytube.logica.UsuarioCtrl;
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
		Video video=new Video(nombreVideo,"duenio","descr",20,fecha,"hola.com",cate2,Privacidad.PRIVADO);
		assertEquals(true,video.getNombre()==nombreVideo);
		assertEquals(true,video.getCategoria().equals(cate2));
		assertEquals(true,video.getPropietario()=="duenio");
		assertEquals(true,video.getDescripcion()=="descr");
		assertEquals(true,video.getFechaPublicacion().equals(fecha));
		assertEquals(true,video.getPrivacidad()==Privacidad.PRIVADO);
		assertEquals(true,video.getDuracion()==20);
		assertEquals(true,video.getURL()=="hola.com");
		video.ingresarNuevosDatosVideo("nuevaDesc", 30, fechaN, "hola2.com", cate1, Privacidad.PUBLICO);
		assertEquals(true,video.getNombre()==nombreVideo);
		assertEquals(true,video.getCategoria().equals(new DtCategoria(sh.getSinCat())));
		assertEquals(true,video.getPropietario()=="duenio");
		assertEquals(true,video.getDescripcion()=="nuevaDesc");
		assertEquals(true,video.getFechaPublicacion().equals(fechaN));
		assertEquals(true,video.getPrivacidad()==Privacidad.PUBLICO);
		assertEquals(true,video.getDuracion()==30);
		assertEquals(true,video.getURL()=="hola2.com");
	}

	@Test
	public void testNuevoComentario() {
		String nombreVideo="nombreNC";
		String nombreU="nombreUNC";
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(2));
		UCU.nuevoUsuario(nombreU, "pedrito", "gimenez", "email.com", fecha, null, "nombrecito", "descripcion", Privacidad.PRIVADO, null);
		Video video=new Video(nombreVideo,"pepito","descrito",20,fecha,"url.com",null,Privacidad.PRIVADO);
		video.nuevoComentario(nombreU, fecha, "contenidoComentario");
		video.nuevoComentario(nombreU, fecha, "contenidoComentario2");
		DtComentario[] comentarios=video.getComentarios();
		assertEquals(2,comentarios.length);
		boolean existe1=false;
		boolean existe2=false;
		for(DtComentario comentarioParticular:comentarios){
			if(comentarioParticular.getEsPadre()==true&&comentarioParticular.getNickUsuario()==nombreU&&comentarioParticular.getRespuestas().length==0&&comentarioParticular.getTexto()=="contenidoComentario"){
				existe1=true;
			}
			if(comentarioParticular.getEsPadre()==true&&comentarioParticular.getNickUsuario()==nombreU&&comentarioParticular.getRespuestas().length==0&&comentarioParticular.getTexto()=="contenidoComentario2"){
				existe2=true;
			}
		}
		assertTrue(existe1);
		assertTrue(existe2);
		
	}

	@Test
	public void testResponderComentario() {
		String nombreVideo="nombreRC";
		String nombreU="nombreURC";
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(2));
		UCU.nuevoUsuario(nombreU, "pedrito", "gimenez", "email.com", fecha, null, "nombrecito", "descripcion", Privacidad.PRIVADO, null);
		Video video=new Video(nombreVideo,"pepito","descrito",20,fecha,"url.com",null,Privacidad.PRIVADO);
		video.nuevoComentario(nombreU, fecha, "contenidoComentario");
		DtComentario[] comentarios=video.getComentarios();
		
		video.responderComentario(comentarios[0].getIDComentario(), nombreU, fecha, "contenidoComentario2");
		comentarios=video.getComentarios();
		assertEquals(1,comentarios.length);
		boolean existe1=false;
		boolean existe2=false;
		for(DtComentario comentarioParticular:comentarios){
			if(comentarioParticular.getEsPadre()==true && comentarioParticular.getNickUsuario()==nombreU&&comentarioParticular.getRespuestas().length==1&&comentarioParticular.getTexto()=="contenidoComentario"){
				existe1=true;
			}
			DtComentario[] respuestas=comentarioParticular.getRespuestas();
			if(respuestas.length>0){
				DtComentario respuestaParticular=respuestas[0];
				if(respuestaParticular.getEsPadre()==false&&respuestaParticular.getNickUsuario()==nombreU&&respuestaParticular.getRespuestas().length==0&&respuestaParticular.getTexto()=="contenidoComentario2"){
					existe2=true;
				}
			}
		}
		assertTrue(existe1);
		assertTrue(existe2);
	}

	@Test
	public void testValorarVideo() {
		String nombreVideo="nombreAP";
		String nombreU="nombreUAP";
		String nombreU2="nombreUAP2";
		UsuarioCtrl UCU=UsuarioCtrl.getInstance();
		DtFecha fecha=new DtFecha(new Date(2));
		UCU.nuevoUsuario(nombreU, "pedrito", "gimenez", "email.com", fecha, null, "nombrecito", "descripcion", Privacidad.PRIVADO, null);
		UCU.nuevoUsuario(nombreU2, "pedrito", "gimenez", "email.com", fecha, null, "nombrecito", "descripcion", Privacidad.PRIVADO, null);
		Video video=new Video(nombreVideo,"pepito","descrito",20,fecha,"url.com",null,Privacidad.PRIVADO);
		video.valorarVideo(nombreU, true);
		video.valorarVideo(nombreU2,false);
		DtPuntuacion[] puntuaciones=video.getPuntuaciones();
		boolean existe1=false;
		boolean existe2=false;
		for(DtPuntuacion puntActual:puntuaciones){
			if(puntActual.getNickname()==nombreU && puntActual.getValoracion()==true){
				existe1=true;
			}
			if(puntActual.getNickname()==nombreU2 && puntActual.getValoracion()==false){
				existe2=true;
			}
		}
		assertTrue(existe1);
		assertTrue(existe2);
	}

}