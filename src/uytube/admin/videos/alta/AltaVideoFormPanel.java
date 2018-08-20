package uytube.admin.videos.alta;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class AltaVideoFormPanel {
	private final JPanel mainPanel = new JPanel();
	private final BoxLayout panelLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	private final JTextField userNicknameTextField = new JTextField();
	private final JTextField videoNameTextField = new JTextField();
	private final JTextField videoURLTextField = new JTextField();
	private final JTextArea videoDescriptionTextArea = new JTextArea();
	private final JComboBox<String> videoCategoryComboBox = new JComboBox<>();

	private final JButton acceptButton = new JButton("Aceptar");
	private final JButton cancelButton = new JButton("Cancelar");

	private final JInternalFrame internalFrameContainer;

	public AltaVideoFormPanel(final JInternalFrame internalFrameContainer) {
		this.internalFrameContainer = internalFrameContainer;

		initializePanel();
	}

	private void initializePanel() {
		initializeAcceptButton();
		initializeCancelButton();
		initializePanelLayout();

		mainPanel.setLayout(panelLayout);
	}

	private void initializeAcceptButton() {
		acceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createVideo();
				closeInternalFrameContainer();
			}
		});
	}

	private void createVideo() {
		final String userNickname = userNicknameTextField.getText();
		final String videoName = videoNameTextField.getText();
		final String videoURL = videoURLTextField.getText();
		final String videoDescription = videoDescriptionTextArea.getText();
		final String videoCategory = (String) videoCategoryComboBox.getSelectedItem();

		// videoCtrl.createVideo(userNickname, videoName, videoUrl);
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
		final JLabel userNicknameLabel = new JLabel("Nickname del autor");
		final JLabel videoNameLabel = new JLabel("Nombre del video");
		final JLabel videoURLLabel = new JLabel("URL del video");
		final JLabel videoDescriptionLabel = new JLabel("Descripcion del video");
		final JLabel videoCategoryLabel = new JLabel("Categoria del video");

		mainPanel.add(userNicknameLabel);
		mainPanel.add(userNicknameTextField);

		mainPanel.add(videoNameLabel);
		mainPanel.add(videoNameTextField);

		mainPanel.add(videoURLLabel);
		mainPanel.add(videoURLTextField);

		mainPanel.add(videoDescriptionLabel);
		mainPanel.add(videoDescriptionTextArea);

		for (final String category : getVideoCategories()) {
			videoCategoryComboBox.addItem(category);
		}

		mainPanel.add(videoCategoryLabel);
		mainPanel.add(videoCategoryComboBox);

		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());

		buttonsPanel.add(acceptButton);
		buttonsPanel.add(cancelButton);

		mainPanel.add(buttonsPanel);
	}

	private String[] getVideoCategories() {
		// Fetch the categories from the controller.
		final String[] categories = {};

		return categories;
	}

	public JPanel getPanel() {
		return mainPanel;
	}
}
