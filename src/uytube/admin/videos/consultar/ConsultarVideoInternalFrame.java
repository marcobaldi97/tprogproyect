package uytube.admin.videos.consultar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uytube.admin.adminPrincipal;
import uytube.admin.videos.ListarComentariosInternalFrame;
import uytube.admin.videos.modificar.ModificarVideoInternalFrame;
import uytube.logica.DtInfoVideo;
import uytube.logica.DtUsuario;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class ConsultarVideoInternalFrame extends JInternalFrame {
	static final long serialVersionUID = 113423;

	Factory fabrica = Factory.getInstance();
    IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
    IVideoCtrl VCU = fabrica.getIVideoCtrl();
	private JComboBox authorNicknameComboBox = new JComboBox();
	private final JButton searchVideosButton = new JButton("Buscar");

	private final JPanel mainPanel = new JPanel();
	private final JPanel videoDetailsPanel = new JPanel();

	private DtVideo[] videos;
	private boolean ready;
	private DefaultListModel<String> videoListModel = new DefaultListModel<String>();
	private DefaultListModel<String> UsuariosGListModel = new DefaultListModel<String>();
	private DefaultListModel<String> UsuariosNoGListModel = new DefaultListModel<String>();
	private	final JList<String> videoList;

	private DtVideo selectedVideo;
	private DtInfoVideo infoVideo;
	
	private String authorNickname="";

	private JTextField videoNameTextField = new JTextField();
	private JTextField videoDescriptionTextField = new JTextField();
	private JTextField videoURLTextField = new JTextField();
	private JTextField videoDuracionTextField = new JTextField();
	private final JPanel panel = new JPanel();
	private final JPanel panel_1 = new JPanel();
	private final JTabbedPane TabComunidad = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel UsuGusta = new JPanel();
	private final JList<String> listGusta = new JList<>(UsuariosGListModel);
	private final JPanel UsuNoGusta = new JPanel();
	private final JList<String> listNoGusta = new JList<>(UsuariosNoGListModel);
	private final JPanel Comentarios = new JPanel();
	private final JLabel lblVideosDelAutor = new JLabel("Videos del autor:");
	private final JButton btnCargar = new JButton("Cargar");
	private final JLabel lblCategoria = new JLabel("Categoria");
	private final JTextField txtCategoria = new JTextField();
	
	 public static void infoBox(String infoMessage, String titleBar){
	        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	 }
	 
	//funcion para cuando es llamada con un video.
	public void llamadaParticular(String nicknameAutor, String nombreVideo) {
		authorNicknameComboBox.setSelectedItem(nicknameAutor);
		authorNickname = nicknameAutor;
		authorNicknameComboBox.setEnabled(false);
		videoListModel.clear();
		videoListModel.addElement(nombreVideo);
		videoListModel.setElementAt(videoListModel.getElementAt(0), 0);
	}

	public ConsultarVideoInternalFrame() {
		txtCategoria.setEditable(false);
		txtCategoria.setColumns(10);
		setTitle("Consultar Video");
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(2);
		borderLayout.setHgap(2);
		setResizable(true);
		setMaximizable(true);

		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 330);

		getContentPane().add(mainPanel);

		final BoxLayout mainPanelLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(mainPanelLayout);

		final JLabel authorNicknameLabel = new JLabel("Nickname del autor:");
		authorNicknameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		authorNicknameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		mainPanel.add(authorNicknameLabel);
		String[] nicknamesArray = ICU.listarNicknamesUsuarios();
		authorNicknameComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleVideoSearch();
				videoNameTextField.setText("");
				videoDescriptionTextField.setText("");
				videoURLTextField.setText("");
				videoDuracionTextField.setText("");
				txtCategoria.setText("");
			}
		});
		authorNicknameComboBox.setModel(new DefaultComboBoxModel(nicknamesArray));
		authorNicknameComboBox.setSelectedIndex(-1);
		mainPanel.add(authorNicknameComboBox);

		initializeSearchVideosButton();
		mainPanel.add(searchVideosButton);
		searchVideosButton.setVisible(false);//poner true si se quiere el boton.

		//restaurar el final, si no funciona .
		videoList = new JList<>(videoListModel);
		
		
		videoList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					ready=false;
					if(!videoList.isSelectionEmpty()){
						String nomVideo=videoList.getSelectedValue();
						selectedVideo=ICU.obtenerInfoAdicVideo(authorNickname, nomVideo);
						infoVideo=VCU.verDetallesVideoExt(selectedVideo.getIDVideo());
						handleVideoSelect(infoVideo);
					}
				}
			}
		});
		lblVideosDelAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblVideosDelAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		mainPanel.add(lblVideosDelAutor);
		mainPanel.add(new JScrollPane(videoList));

		initializeVideoDetailsPane();
		mainPanel.add(videoDetailsPanel);
				videoDetailsPanel.add(panel);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
		
				final JLabel videoNameLabel = new JLabel("Nombre:");
				panel.add(videoNameLabel);
				videoNameTextField.setEditable(false);
				panel.add(videoNameTextField);
				
						final JLabel videoDescriptionLabel = new JLabel("Descripcion:");
						panel.add(videoDescriptionLabel);
						videoDescriptionTextField.setEditable(false);
						panel.add(videoDescriptionTextField);
						
								final JLabel videoURLLabel = new JLabel("URL:");
								panel.add(videoURLLabel);
								videoURLTextField.setEditable(false);
								panel.add(videoURLTextField);
								
										final JLabel videoDuracionLabel = new JLabel("Duracion:");
										panel.add(videoDuracionLabel);
										videoDuracionTextField.setEditable(false);
										panel.add(videoDuracionTextField);
										
										panel.add(lblCategoria);
										
										panel.add(txtCategoria);
										videoDetailsPanel.add(panel_1);
										panel_1.setLayout(new GridLayout(0, 1, 0, 0));
										TabComunidad.setToolTipText("");
										
										panel_1.add(TabComunidad);
										
										TabComunidad.addTab("Le Gusta", null, UsuGusta, null);
										UsuGusta.setLayout(new GridLayout(0, 1, 0, 0));
										
										UsuGusta.add(listGusta);
										
										TabComunidad.addTab("No Le Gusta", null, UsuNoGusta, null);
										UsuNoGusta.setLayout(new GridLayout(0, 1, 0, 0));
										
										UsuNoGusta.add(listNoGusta);
										
										TabComunidad.addTab("Comentarios", null, Comentarios, null);
										btnCargar.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												if(!videoList.isSelectionEmpty()&&authorNicknameComboBox.getSelectedIndex()!=-1){
													String nick = (String) authorNicknameComboBox.getSelectedItem();
													String video = videoList.getSelectedValue();
													if(!nick.isEmpty() && !video.isEmpty()){
														 ListarComentariosInternalFrame comentariosIFrame = new ListarComentariosInternalFrame((String) authorNicknameComboBox.getSelectedItem(),videoList.getSelectedValue());
														 adminPrincipal.getFrames()[0].setLayout(null);
														 adminPrincipal.getFrames()[0].add(comentariosIFrame);
														 comentariosIFrame.show();
													}else{
														infoBox("No hay usuario y/o video seleccionado","Consulta Video");
													}
												}else{
													infoBox("No hay usuario y/o video seleccionado","Consulta Video");
												}
											}
										});
										
										Comentarios.add(btnCargar);
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
		authorNickname = (String) authorNicknameComboBox.getSelectedItem();
		
		videoListModel.clear();
		UsuariosGListModel.clear();
		UsuariosNoGListModel.clear();
	    if(ICU.memberUsuario(authorNickname)){
	    	
	    	String[] videosCanal=ICU.listarVideosCanal(authorNickname);
	    	for(String vid:videosCanal){
	    		
	    		videoListModel.addElement(vid);
	    		
	    	}
	    	ready=true;
	    }
	}

	private void handleVideoSelect(final DtInfoVideo selectedVideo) {
		this.infoVideo = selectedVideo;

		videoNameTextField.setText(this.selectedVideo.getNombre());
		videoDescriptionTextField.setText(this.selectedVideo.getDescripcion());
		videoURLTextField.setText(this.selectedVideo.getUrl());
		txtCategoria.setText(this.selectedVideo.getCategoria().getNombre());
		Integer duracionMM=this.selectedVideo.getDuracion()/60;
		Integer duracionSS=this.selectedVideo.getDuracion()%60;
		videoDuracionTextField.setText(Integer.toString(duracionMM)+":"+Integer.toString(duracionSS));//arreglar la duracion para que la muestre en minutos
		
		
		DtUsuario[] usuGustan=selectedVideo.getUsuariosGusta();
		DtUsuario[] usuNoGustan=selectedVideo.getUsuariosNoGusta();
		
		String[]nickUsuGustan=new String[usuGustan.length];
		String[]nickUsuNoGustan=new String[usuNoGustan.length];
		
		int i=0;
		UsuariosGListModel.clear();
		for(DtUsuario usuario:usuGustan){
			nickUsuGustan[i]=usuario.getNickname();
			UsuariosGListModel.addElement(nickUsuGustan[i]);
			i++;
		}
		i=0;
		UsuariosNoGListModel.clear();
		for(DtUsuario usuario:usuNoGustan){
			nickUsuNoGustan[i]=usuario.getNickname();
			UsuariosNoGListModel.addElement(nickUsuNoGustan[i]);
			i++;
		}
		//el clear de comentarios
		//aca falta agregar a los comentarios
	}

	private void initializeVideoDetailsPane() {
		videoDetailsPanel.setLayout(new GridLayout(0, 2, 0, 0));
	}

}
