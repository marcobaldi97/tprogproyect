package uytubeLogic.JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import uytubeLogic.logica.Comentario;
import uytubeLogic.logica.DtComentario;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.UsuarioCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

public class ComentarioTest {

	@Test
	public void comentarioFunciones() {
		String nombreU = "nombreComentario";
		UsuarioCtrl UCU = UsuarioCtrl.getInstance();
		DtFecha fecha = new DtFecha(new Date(2));
		UCU.nuevoUsuario(nombreU, "1234", "pedrito", "gimenez", "email.com", fecha, null, "nombrecito", "descripcion",
				Privacidad.PUBLICO, null);
		Comentario coment = new Comentario(1, "texto", fecha, true, nombreU);
		assertEquals(nombreU, coment.getUsuario().getNickname());
		assertEquals(true, coment.getEsPadre());
		assertEquals(fecha, coment.getFecha());
		assertEquals((Integer) 1, coment.getIDComentario());
		assertEquals(fecha, coment.getFecha());
		Comentario respuesta = new Comentario(2, "textoR", fecha, false, nombreU);
		coment.addComentario(respuesta);
		DtComentario dtRespuesta = new DtComentario(respuesta);
		DtComentario dtActual = coment.getDtRespuestas()[0];
		assertEquals(true, dtRespuesta.equals(dtActual));
	}

}
