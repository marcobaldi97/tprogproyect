package uytube.JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

public class FactoryTest {

	@Test
	public void testGetInstance() {
		Factory F1 = Factory.getInstance();
		Factory F2 = Factory.getInstance();
		assertEquals(true, F1 == F2);
	}

	@Test
	public void testGetIUsuarioCtrl() {
		Factory F1 = Factory.getInstance();
		IUsuarioCtrl ICU1 = F1.getIUsuarioCtrl();
		IUsuarioCtrl ICU2 = F1.getIUsuarioCtrl();
		assertEquals(true, ICU1 == ICU2);
	}

	@Test
	public void testGetIVideoCtrl() {
		Factory F1 = Factory.getInstance();
		IVideoCtrl VCU1 = F1.getIVideoCtrl();
		IVideoCtrl VCU2 = F1.getIVideoCtrl();
		assertEquals(true, VCU1 == VCU2);

	}

}
