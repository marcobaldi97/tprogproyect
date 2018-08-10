package uytube.admin.videos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;

public final class ModificarVideoFormPanel {
	private final JPanel panel = new JPanel();
	private final GroupLayout panelLayout = new GroupLayout(panel);
	private final JTextField userNicknameTextField = new JTextField();
	private final JTextField videoNameTextField = new JTextField();
	private final JTextField videoURLTextField = new JTextField();

	private final JButton acceptButton = new JButton("Aceptar");
	private final JButton cancelButton = new JButton("Cancelar");

	private final JInternalFrame internalFrameContainer;

	public ModificarVideoFormPanel(final JInternalFrame internalFrameContainer) {
		this.internalFrameContainer = internalFrameContainer;

		initializePanel();

		panel.add(userNicknameTextField);
	}

	private void initializePanel() {
		initializeAcceptButton();
		initializeCancelButton();
		initializePanelLayout();

		panel.setLayout(panelLayout);
	}

	private void initializeAcceptButton() {
		acceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createVideo();
			}
		});
	}

	private void createVideo() {
		final String userNickname = userNicknameTextField.getText();
		final String videoName = videoNameTextField.getText();
		final String videoURL = videoURLTextField.getText();

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
		panelLayout.setAutoCreateContainerGaps(true);
		panelLayout.setAutoCreateGaps(true);

		final JLabel userNicknameLabel = new JLabel("Nickname del autor");
		final JLabel videoNameLabel = new JLabel("Nombre del video");
		final JLabel videoURLLabel = new JLabel("URL del video");

		final Group horizontalGroup = panelLayout.createParallelGroup().addComponent(userNicknameLabel)
				.addComponent(userNicknameTextField).addComponent(videoNameLabel).addComponent(videoNameTextField)
				.addComponent(videoURLLabel).addComponent(videoURLTextField)
				.addGroup(panelLayout.createSequentialGroup().addComponent(acceptButton).addComponent(cancelButton));

		final Group verticalGroup = panelLayout.createSequentialGroup().addComponent(userNicknameLabel)
				.addComponent(userNicknameTextField).addComponent(videoNameLabel).addComponent(videoNameTextField)
				.addComponent(videoURLLabel).addComponent(videoURLTextField)
				.addGroup(panelLayout.createParallelGroup().addComponent(acceptButton).addComponent(cancelButton));

		panelLayout.setHorizontalGroup(horizontalGroup);
		panelLayout.setVerticalGroup(verticalGroup);
	}

	public JPanel getPanel() {
		return panel;
	}
}
