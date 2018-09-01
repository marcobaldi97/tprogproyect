package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import uytube.admin.adminPrincipal;
import uytube.admin.videos.consultar.ConsultarVideoInternalFrame;
import uytube.admin.videos.modificar.ModificarVideoInternalFrame;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtVideo;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;
import uytube.logica.ListaReproduccion.TipoLista;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

public class ConsultaListaInternalFrame extends JInternalFrame {
	private JLabel textFieldNombreLista;
	private JLabel textFieldPrivacidadLista;
	private JComboBox comboBoxNicknames;
	private DefaultListModel<String> modelListVideos = new DefaultListModel<>();
	private JList<String> listVideos = new JList<>(modelListVideos);
	private DefaultListModel<String> modelListListas = new DefaultListModel<>();
	private JList<String> listListas = new JList<>( modelListListas );
	private boolean ready = false;
	private boolean ready2 = false;
	
    private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

	/**
	 * Create the frame.
	 * @param iCV 
	 */
	public ConsultaListaInternalFrame(IUsuarioCtrl iCU, IVideoCtrl iCV) {
		setResizable(true);
		setTitle("Consulta Lista Reproduccion");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(4, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 2, 4, 4));
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNickname);
		
		comboBoxNicknames = new JComboBox();
		String[] nicknamesArray = iCU.listarNicknamesUsuarios();
		comboBoxNicknames.setModel(new DefaultComboBoxModel(nicknamesArray));
		comboBoxNicknames.setSelectedIndex(-1);
		comboBoxNicknames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listListas.setSelectedIndex(-1);
				modelListListas.removeAllElements();
				listVideos.setSelectedIndex(-1);
				modelListVideos.removeAllElements();
				textFieldNombreLista.setText("");
				textFieldPrivacidadLista.setText("");
				String nombreSeleccionado = (String) comboBoxNicknames.getSelectedItem();
				String[] listasNombresListas = iCU.listarLDRdeUsuario(nombreSeleccionado);
				for (int i = 0; i < listasNombresListas.length; i++) {
					modelListListas.addElement(listasNombresListas[i]);
				}//cargo la lista		
				ready = true;
				ready2 = false;
			}
		});
		panel.add(comboBoxNicknames);
		
		JLabel lblListas = new JLabel("Listas:");
		lblListas.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblListas);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setViewportView(listListas);
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 4, 2, 2));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNombre);
		
		textFieldNombreLista = new JLabel();
		panel_1.add(textFieldNombreLista);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPrivacidad);
		
		textFieldPrivacidadLista = new JLabel();
		panel_1.add(textFieldPrivacidadLista);
		
		JLabel lblTipoDeLista = new JLabel("Tipo de Lista:");
		lblTipoDeLista.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTipoDeLista);
		
		JLabel lblTextfieldtipolista = new JLabel("");
		panel_1.add(lblTextfieldtipolista);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblVideo = new JLabel("Videos:");
		lblVideo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblVideo);	
		listVideos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && ready && ready2) {
					ready2 = false;
					if(!listVideos.isSelectionEmpty()) {
						
					}
				}
			}
		});
		panel_2.add(listVideos);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		
		JButton btnVerInfoVideo = new JButton("Ver Info Video");
		panel_4.add(btnVerInfoVideo);
		btnVerInfoVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listVideos.isSelectionEmpty() == false) {
					ConsultarVideoInternalFrame consVideoIFrame = new ConsultarVideoInternalFrame();
					adminPrincipal.getFrames()[0].setLayout(null);
					adminPrincipal.getFrames()[0].add(consVideoIFrame);
					//Veo si puedo llamar la ventana condicionada para eso.
					String nombreLista = listListas.getSelectedValue();
					String nombreSeleccionado = (String) comboBoxNicknames.getSelectedItem();
					String nombreVideo = listVideos.getSelectedValue();
					DtVideo[] dtvideos = iCU.obtenerDtsVideosListaReproduccionUsuario(nombreSeleccionado, nombreLista);
					String nicknameAutor = "";
					for(int i = 0; i < dtvideos.length; i++) {
						if(nombreVideo == dtvideos[i].getNombre()) {
							nicknameAutor = dtvideos[i].getPropietario();
						}
					}
					//
					consVideoIFrame.llamadaParticular(nicknameAutor, nombreVideo);
					consVideoIFrame.show();
				}else infoBox("No hay ningun video seleccionado","Aviso");
			}
		});
		listListas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting() && ready) {
					ready = false;
					ready2 = false;
					if(!listListas.isSelectionEmpty()){
						String nombreLista = listListas.getSelectedValue();
						String nombreSeleccionado = (String) comboBoxNicknames.getSelectedItem();
						//carga de video.
						listVideos.setSelectedIndex(-1);
						modelListVideos.removeAllElements();
						String[] nombreVideos = iCU.listarVideosListaReproduccionUsuario(nombreSeleccionado, nombreLista);
						for (int i = 0; i < nombreVideos.length; i++) {
							modelListVideos.addElement(nombreVideos[i]);
						}
						//fin de carga de videos.
						DtListaReproduccion dtLista = iCU.infoAdicLDR(nombreSeleccionado, nombreLista);
						textFieldNombreLista.setText(dtLista.getNombre());
						if(dtLista.getPrivado() == true) {
							textFieldPrivacidadLista.setText("Privada");
						}else textFieldPrivacidadLista.setText("Publica");
						if(dtLista.getTipoLista() ==TipoLista.PARTICULAR){
							lblTextfieldtipolista.setText("Particular");
						}else{
							lblTextfieldtipolista.setText("Por Defecto");
						}
						ready = true;
						ready2=true;
					}
				}
			}
		});
	}
	

	public void llamadaParticular(String nickU, String lista) {
		comboBoxNicknames.setSelectedItem(nickU);
		comboBoxNicknames.setEnabled(false);
		 modelListListas.clear();
		 modelListListas.addElement(lista);
		 modelListListas.setElementAt( modelListListas.getElementAt(0), 0);
		 listListas.setSelectedIndex(0);
	}

}
