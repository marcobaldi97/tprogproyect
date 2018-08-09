package uytube.admin.videos;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Group;

public final class AltaVideoFormPanel {
	private final JPanel panel = new JPanel();
	private final GroupLayout panelLayout = new GroupLayout(panel);
	private final JTextField nicknameTextField = new JTextField();

	public AltaVideoFormPanel() {
		initializePanel();

		panel.add(nicknameTextField);
	}

	private void initializePanel() {
		initializePanelLayout();

		panel.setLayout(panelLayout);
	}

	private void initializePanelLayout() {
		panelLayout.setAutoCreateContainerGaps(true);
		panelLayout.setAutoCreateGaps(true);

		Group horizontalGroup = panelLayout.createParallelGroup()
				.addGroup(panelLayout.createSequentialGroup().addComponent(nicknameTextField));

		Group verticalGroup = panelLayout.createSequentialGroup()
				.addGroup(panelLayout.createParallelGroup().addComponent(nicknameTextField));

		panelLayout.setHorizontalGroup(horizontalGroup);
		panelLayout.setVerticalGroup(verticalGroup);
	}

	public JPanel getPanel() {
		return panel;
	}
}
