package uytube.admin.videos.modificar;

import java.awt.Container;

import javax.swing.JInternalFrame;

public final class ModificarVideoInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();
	private String videoName;

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
		ModificarVideoFormPanel altaVideoFormPanel = new ModificarVideoFormPanel(internalFrame, videoName);

		internalFrame.add(altaVideoFormPanel.getPanel());
	}

	public void setVideo(final String videoName) {
		this.videoName = videoName;
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
