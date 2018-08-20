package uytube.admin.videos.modificar;

import java.awt.Container;

import javax.swing.JInternalFrame;

public final class ModificarVideoInternalFrame {
	private final JInternalFrame internalFrame = new JInternalFrame();
	private Integer videoId;

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
		internalFrame.setSize(330, 500);

		addContentToInternalFrame();
	}

	private void addContentToInternalFrame() {
		ModificarVideoFormPanel altaVideoFormPanel = new ModificarVideoFormPanel(internalFrame, videoId);

		internalFrame.add(altaVideoFormPanel.getPanel());
	}

	public void setVideo(final Integer videoId) {
		this.videoId = videoId;
	}

	public void show() {
		internalFrame.show();
	}

	public void hide() {
		internalFrame.hide();
	}
}
