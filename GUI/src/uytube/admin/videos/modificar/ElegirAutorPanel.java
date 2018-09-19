package uytube.admin.videos.modificar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uytube.logica.DtVideo;

public final class ElegirAutorPanel {
	private final JPanel mainPanel = new JPanel();
	private final BoxLayout panelLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
	private final JTextField authorNicknameTextField = new JTextField();

	private Integer selectedVideoId;

	private DtVideo[] videos = {};
	private DefaultListModel<DtVideo> videoListModel = new DefaultListModel<DtVideo>();
	private final JButton searchAuthorVideosButton = new JButton("Buscar");

	private final JButton editButton = new JButton("Aceptar");
	private final JButton cancelButton = new JButton("Cancelar");

	private final JInternalFrame internalFrameContainer;

	public ElegirAutorPanel(final JInternalFrame internalFrameContainer) {
		this.internalFrameContainer = internalFrameContainer;

		initializePanel();
	}

	private void initializePanel() {
		initializeSearchAuthorVideosButton();
		initializeCancelButton();
		initializePanelLayout();

		mainPanel.setLayout(panelLayout);
	}

	private void initializeSearchAuthorVideosButton() {
		searchAuthorVideosButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String authorNickname = authorNicknameTextField.getText();
				// final DtVideo[] videos = controller.getVideos()
				// this.videos = videos;
				updateVideoList();
			}
		});
	}

	private void updateVideoList() {
		videoListModel.clear();

		for (DtVideo video : videos) {
			videoListModel.addElement(video);
		}
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

	public Integer getSelectedVideoId() {
		return selectedVideoId;
	}

	private void initializePanelLayout() {
		final JLabel autorNicknameLabel = new JLabel("Nickname del autor");

		mainPanel.add(autorNicknameLabel);
		mainPanel.add(authorNicknameTextField);
		mainPanel.add(searchAuthorVideosButton);

		final JList<DtVideo> videoList = new JList<DtVideo>(videoListModel);
		mainPanel.add(new JScrollPane(videoList));

		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());

		buttonsPanel.add(editButton);
		buttonsPanel.add(cancelButton);

		mainPanel.add(buttonsPanel);
	}

	public void setEditButtonActionListener(final ActionListener actionListener) {
		editButton.addActionListener(actionListener);
	}

	public JPanel getPanel() {
		return mainPanel;
	}
}
