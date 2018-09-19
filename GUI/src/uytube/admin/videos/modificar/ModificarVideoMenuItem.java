package uytube.admin.videos.modificar;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public final class ModificarVideoMenuItem {
	private final JMenuItem menuItem = new JMenuItem("Modificar Video...");
	private final ElegirAutorInternalFrame elegirAutorInternalFrame;

	private final Container container;

	public ModificarVideoMenuItem(final Container container) {
		this.container = container;
		this.elegirAutorInternalFrame = new ElegirAutorInternalFrame(this.container);

		initializeMenuItem();
	}

	public JMenuItem getMenuItem() {
		return menuItem;
	}

	private void initializeMenuItem() {
		addClickEventHandlerToMenuItem();
	}

	private void addClickEventHandlerToMenuItem() {
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showElegirAutorInternalFrame();
			}
		});
	}

	private void showElegirAutorInternalFrame() {
		elegirAutorInternalFrame.show();
	}
}
