package uytube.admin.videos.modificar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class ModificarVideoFormPanel {
	private final JPanel panel = new JPanel();
	private final BoxLayout panelLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
	private final Integer videoId;
	private final JTextField videoNameTextField = new JTextField();
	private final JTextField videoURLTextField = new JTextField();
	private final JTextField videoDescriptionTextField = new JTextField();
	private final JTextField videoDuracionTextField = new JTextField();

	private final JButton editButton = new JButton("Editar");
	private final JButton cancelButton = new JButton("Cancelar");

	private final JInternalFrame internalFrameContainer;

	public ModificarVideoFormPanel(final JInternalFrame internalFrameContainer, final Integer videoId) {
		this.internalFrameContainer = internalFrameContainer;
		this.videoId = videoId;

		initializePanel();
	}

	private void initializePanel() {
		initializeEditButton();
		initializeCancelButton();
		initializePanelLayout();

		panel.setLayout(panelLayout);
	}

	private void initializeEditButton() {
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				editVideo();
			}
		});
	}

	private void editVideo() {
		final String videoName = videoNameTextField.getText();
		final String videoURL = videoURLTextField.getText();
		final String videoDescription = videoDescriptionTextField.getText();

		// videoCtrl.editVideo(videoId, videoName, videoURL, videoDescription);
	}

	private void initializeCancelButton() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				closeInternalFrameContainer();
			}
		});
	}

	private void closeInternalFrameContainer() {
		internalFrameContainer.dispose();
	}

	private void initializePanelLayout() {
		final JLabel videoNameLabel = new JLabel("Nombre del video");
		panel.add(videoNameLabel);
		panel.add(videoNameTextField);

		final JLabel videoURLLabel = new JLabel("URL del video");
		panel.add(videoURLLabel);
		panel.add(videoURLTextField);

		final JLabel videoDescriptionLabel = new JLabel("Descripcion del video");
		panel.add(videoDescriptionLabel);
		panel.add(videoDescriptionTextField);

		final JLabel videoDurationLabel = new JLabel("Duracion del video");
		panel.add(videoDurationLabel);
		panel.add(videoDuracionTextField);

		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());

		buttonsPanel.add(editButton);
		buttonsPanel.add(cancelButton);

		panel.add(buttonsPanel);
	}

	public JPanel getPanel() {
		return panel;
	}
}
