package uytube.admin.videos.alta;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public final class AltaVideoMenuItem {
	private final JMenuItem menuItem = new JMenuItem("Alta Video...");
	private final AltaVideoInternalFrame altaVideoInternalFrame;

	private final Container container;

	public AltaVideoMenuItem(final Container container) {
		this.container = container;
		this.altaVideoInternalFrame = new AltaVideoInternalFrame(this.container);

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
		altaVideoInternalFrame.show();
	}
}
