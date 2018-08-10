package uytube.admin.videos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;

public final class AltaVideoFormPanel {
	private final JPanel panel = new JPanel();
	private final GroupLayout panelLayout = new GroupLayout(panel);
	private final JTextField userNicknameTextField = new JTextField();
	private final JTextField videoNameTextField = new JTextField();
	private final JTextField videoURLTextField = new JTextField();

	private final JButton acceptButton = new JButton("Accept");
	private final JButton cancelButton = new JButton("Cancel");

	public AltaVideoFormPanel() {
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

	private void initializeCancelButton() {
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
	}

	private void initializePanelLayout() {
		panelLayout.setAutoCreateContainerGaps(true);
		panelLayout.setAutoCreateGaps(true);

		final Group horizontalGroup = panelLayout.createParallelGroup().addComponent(userNicknameTextField)
				.addComponent(videoNameTextField).addComponent(videoURLTextField)
				.addGroup(panelLayout.createSequentialGroup().addComponent(acceptButton));

		final Group verticalGroup = panelLayout.createSequentialGroup().addComponent(userNicknameTextField)
				.addComponent(videoNameTextField).addComponent(videoURLTextField);

		panelLayout.setHorizontalGroup(horizontalGroup);
		panelLayout.setVerticalGroup(verticalGroup);
	}

	private void createVideo() {
		final String userNickname = userNicknameTextField.getText();
		final String videoName = videoNameTextField.getText();
		final String videoURL = videoURLTextField.getText();
	}

	public JPanel getPanel() {
		return panel;
	}
}
