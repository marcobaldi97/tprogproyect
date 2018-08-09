package uytube.admin.videos;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public final class ModificarVideoMenuItem {
	private final JMenuItem menuItem = new JMenuItem("Modificar Video...");
	private final ModificarVideoInternalFrame modificarVideoInternalFrame;

	private final Container container;

	public ModificarVideoMenuItem(final Container container) {
		this.container = container;
		this.modificarVideoInternalFrame = new ModificarVideoInternalFrame(this.container);

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
				showAltaVideoInternalFrame();
			}
		});
	}

	private void showAltaVideoInternalFrame() {
		modificarVideoInternalFrame.show();
	}
}
