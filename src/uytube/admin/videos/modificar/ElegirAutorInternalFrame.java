package uytube.admin.videos.modificar;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

public final class ElegirAutorInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();

	final ElegirAutorPanel elegirAutorPanel = new ElegirAutorPanel(internalFrame);

	final ModificarVideoInternalFrame modificarVideoInternalFrame = new ModificarVideoInternalFrame(internalFrame);

	private final Container container;

	public ElegirAutorInternalFrame(final Container container) {
		this.container = container;
		this.container.add(internalFrame);

		initializeInternalFrame();
	}

	private void initializeInternalFrame() {
		internalFrame.setVisible(false);
		internalFrame.setTitle("Elegir Autor");
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
		internalFrame.setSize(330, 300);

		addContentToInternalFrame();
	}

	private void addContentToInternalFrame() {
		elegirAutorPanel.setEditButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openModificarVideoInternalFrame();
			}
		});

		internalFrame.add(elegirAutorPanel.getPanel());
	}

	private void openModificarVideoInternalFrame() {
		final String selectedVideoId = elegirAutorPanel.getSelectedVideoId();

		modificarVideoInternalFrame.setVideo(selectedVideoId);
		modificarVideoInternalFrame.show();
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
