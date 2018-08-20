package uytube.admin.videos.consultar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;

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

public class ConsultarVideoInternalFrame extends JInternalFrame {
	static final long serialVersionUID = 113423;

	private JTextField authorNicknameTextField = new JTextField();
	private final JButton searchVideosButton = new JButton("Buscar");

	private final JPanel mainPanel = new JPanel();
	private final JPanel videoDetailsPanel = new JPanel();

	private DtVideo[] videos = {};
	private DefaultListModel<DtVideo> videoListModel = new DefaultListModel<DtVideo>();

	private DtVideo selectedVideo;

	private JTextField videoNameTextField = new JTextField();
	private JTextField videoDescriptionTextField = new JTextField();
	private JTextField videoURLTextField = new JTextField();
	private JTextField videoDuracionTextField = new JTextField();

	public ConsultarVideoInternalFrame() {
		setResizable(true);
		setMaximizable(true);

		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

		add(mainPanel);

		final BoxLayout mainPanelLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainPanelLayout);

		final JLabel authorNicknameLabel = new JLabel("Nickname del autor");
		mainPanel.add(authorNicknameLabel);
		mainPanel.add(authorNicknameTextField);

		initializeSearchVideosButton();
		mainPanel.add(searchVideosButton);

		final JList<DtVideo> videoList = new JList<DtVideo>(videoListModel);
		mainPanel.add(new JScrollPane(videoList));

		initializeVideoDetailsPane();
		mainPanel.add(videoDetailsPanel);
	}

	private void initializeSearchVideosButton() {
		searchVideosButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleVideoSearch();
			}
		});
	}

	private void handleVideoSearch() {
		final String authorNickname = authorNicknameTextField.getText();
		// TODO: Get author's videos and set `videos` member;

		videoListModel.clear();

		for (DtVideo video : videos) {
			videoListModel.addElement(video);
		}
	}

	private void handleVideoSelect(final DtVideo selectedVideo) {
		this.selectedVideo = selectedVideo;

		videoNameTextField.setText(this.selectedVideo.getNombre());
		videoDescriptionTextField.setText(this.selectedVideo.getDescripcion());
		videoURLTextField.setText(this.selectedVideo.getUrl());
		videoDuracionTextField.setText(Integer.toString(this.selectedVideo.getDuracion()));
	}

	private void initializeVideoDetailsPane() {
		videoDetailsPanel.setLayout(new BoxLayout(videoDetailsPanel, BoxLayout.Y_AXIS));

		final JLabel videoNameLabel = new JLabel("Nombre");
		videoDetailsPanel.add(videoNameLabel);
		videoDetailsPanel.add(videoNameTextField);

		final JLabel videoDescriptionLabel = new JLabel("Descripcion");
		videoDetailsPanel.add(videoDescriptionLabel);
		videoDetailsPanel.add(videoDescriptionTextField);

		final JLabel videoURLLabel = new JLabel("URL");
		videoDetailsPanel.add(videoURLLabel);
		videoDetailsPanel.add(videoURLTextField);

		final JLabel videoDuracionLabel = new JLabel("Nombre");
		videoDetailsPanel.add(videoDuracionLabel);
		videoDetailsPanel.add(videoDuracionTextField);
	}

}
