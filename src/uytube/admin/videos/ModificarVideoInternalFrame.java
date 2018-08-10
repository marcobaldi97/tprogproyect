package uytube.admin.videos;

import java.awt.Container;

import javax.swing.JInternalFrame;

public final class ModificarVideoInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();

	private final Container container;

	public ModificarVideoInternalFrame(Container container) {
		this.container = container;
		this.container.add(internalFrame);

		initializeInternalFrame();
	}

	private void initializeInternalFrame() {
		internalFrame.setVisible(false);
		internalFrame.setTitle("Alta Video");
		internalFrame.setClosable(true);
		internalFrame.setResizable(true);
		internalFrame.pack();

		addContentToInternalFrame();
	}

	private void addContentToInternalFrame() {
		AltaVideoFormPanel altaVideoFormPanel = new AltaVideoFormPanel(internalFrame);

		internalFrame.add(altaVideoFormPanel.getPanel());
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
