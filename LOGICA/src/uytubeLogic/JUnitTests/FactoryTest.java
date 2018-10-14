package uytubeLogic.JUnitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

public class FactoryTest {

	@Test
	public void testGetInstance() {
		Fabrica F1 = Fabrica.getInstance();
		Fabrica F2 = Fabrica.getInstance();
		assertEquals(true, F1 == F2);
	}

	@Test
	public void testGetIUsuarioCtrl() {
		Fabrica F1 = Fabrica.getInstance();
		IUsuarioCtrl ICU1 = F1.getIUsuarioCtrl();
		IUsuarioCtrl ICU2 = F1.getIUsuarioCtrl();
		assertEquals(true, ICU1 == ICU2);
	}

	@Test
	public void testGetIVideoCtrl() {
		Fabrica F1 = Fabrica.getInstance();
		IVideoCtrl VCU1 = F1.getIVideoCtrl();
		IVideoCtrl VCU2 = F1.getIVideoCtrl();
		assertEquals(true, VCU1 == VCU2);

	}

}
