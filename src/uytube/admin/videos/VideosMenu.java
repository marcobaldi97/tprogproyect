package uytube.admin.videos;

import java.util.ArrayList;
import java.awt.Container;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import uytube.admin.videos.alta.AltaVideoMenuItem;
import uytube.admin.videos.modificar.ModificarVideoMenuItem;;

public final class VideosMenu {
	private final JMenu menu = new JMenu("Videos");
	private final ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();

	private final Container container;

	public VideosMenu(final Container container) {
		this.container = container;

		initializeMenu();
	}

	public JMenu getMenu() {
		return menu;
	}

	private void initializeMenu() {
		initializeMenuItems();
		addMenuItemsToMenu();

		menu.setMnemonic(KeyEvent.VK_V);
	}

	private void initializeMenuItems() {
		AltaVideoMenuItem altaVideoMenuItem = new AltaVideoMenuItem(container);
		ModificarVideoMenuItem modificarVideoMenuItem = new ModificarVideoMenuItem(container);

		menuItems.add(altaVideoMenuItem.getMenuItem());
		menuItems.add(modificarVideoMenuItem.getMenuItem());
	}

	private void addMenuItemsToMenu() {
		for (JMenuItem menuItem : menuItems) {
			menu.add(menuItem);
		}
	}
}
