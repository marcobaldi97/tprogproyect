package uytube.admin.videos.consultar;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public final class ConsultarVideoMenuItem {
	private final JMenuItem menuItem = new JMenuItem("Consultar Video...");
	private final ConsultarVideoInternalFrame consultarVideoInternalFrame;

	private final Container container;

	public ConsultarVideoMenuItem(final Container container) {
		this.container = container;
		this.consultarVideoInternalFrame = new ConsultarVideoInternalFrame();
		this.container.add(this.consultarVideoInternalFrame);

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
				showConsultarVideoInternalFrame();
			}
		});
	}

	private void showConsultarVideoInternalFrame() {
		consultarVideoInternalFrame.show();
	}
}
