package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import uytube.admin.Imagen;
import uytube.admin.adminPrincipal;
import uytube.admin.adminPrincipalBienHecho;
import uytube.admin.listas.ConsultaListaInternalFrame;
import uytube.admin.videos.ModificarVideo;
import uytube.admin.videos.consultar.ConsultarVideoInternalFrame;
import uytube.logica.DtCanal;
import uytube.logica.DtCategoria;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtUsuario;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import com.toedter.components.JLocaleChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.event.ItemEvent;
import javax.swing.JButton;


public class ConsultaUsuarioInternalFrame extends JInternalFrame {
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomCanal;
	private JTextPane textPaneDesc;
	private JComboBox comboBoxVideos;
	private JComboBox<String> comboBoxListas;
	private IUsuarioCtrl controlUsr;
	JDateChooser dateChooser;
	private JTextField textFieldPrivacidad;
	private JTextField textFieldCatCanal;
	private JTextArea textAreaDescVideo;
	private JList listSeguidos;
	private JList listSeguidores;
	private JLabel lblFoto;
	
	
	public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Create the frame.
	 * @param iCU 
	 */
	public ConsultaUsuarioInternalFrame(IUsuarioCtrl iCU) {
		controlUsr = iCU;
		
		setTitle("Consulta Usuario");
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 618, 460);
		getContentPane().setLayout(new GridLayout(0, 3, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		
		lblFoto = new JLabel("");
		panel.add(lblFoto);
		
		JPanel panelDUsuario = new JPanel();
		panelDUsuario.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDUsuario);
		panelDUsuario.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel label = new JLabel("Nickname");
		panelDUsuario.add(label);
		
		
		JComboBox<String> comboBoxNick = new JComboBox();
		comboBoxNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickU = (String)comboBoxNick.getSelectedItem();
				//limpiar();
				if((String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1){
					//pedir Dt
					DtUsuario usr= controlUsr.listarDatosUsuario(nickU);
					DtCanal usrCanal = controlUsr.mostrarInfoCanal(nickU);
					limpiar();
					cargarDatos(usr, usrCanal, nickU);
				}
			}
		});
		panelDUsuario.add(comboBoxNick);
		
		
		
		JLabel label_1 = new JLabel("Email");
		panelDUsuario.add(label_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		panelDUsuario.add(textFieldEmail);
		
		JLabel label_2 = new JLabel("Nombre");
		panelDUsuario.add(label_2);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		panelDUsuario.add(textFieldNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		panelDUsuario.add(label_3);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		panelDUsuario.add(textFieldApellido);
		
		JLabel label_4 = new JLabel("Fecha Nac.");
		panelDUsuario.add(label_4);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setEnabled(false);
		panelDUsuario.add(dateChooser);
		comboBoxNick.setSelectedIndex(-1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JPanel panelDCanal = new JPanel();
		panelDCanal.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDCanal);
		panelDCanal.setLayout(new GridLayout(0, 2, 2, 5));
		
		JLabel label_5 = new JLabel("Nombre");
		panelDCanal.add(label_5);
		
		textFieldNomCanal = new JTextField();
		textFieldNomCanal.setEditable(false);
		textFieldNomCanal.setColumns(10);
		panelDCanal.add(textFieldNomCanal);
		
		JLabel label_6 = new JLabel("Privacidad");
		panelDCanal.add(label_6);
		
		textFieldPrivacidad = new JTextField();
		textFieldPrivacidad.setEditable(false);
		panelDCanal.add(textFieldPrivacidad);
		textFieldPrivacidad.setColumns(10);
		
		JLabel label_7 = new JLabel("Descripici\u00F3n");
		panelDCanal.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDCanal.add(scrollPane);
		
		textPaneDesc = new JTextPane();
		scrollPane.setViewportView(textPaneDesc);
		textPaneDesc.setEditable(false);
		
		JLabel lblCategoria = new JLabel("Categoria");
		panelDCanal.add(lblCategoria);
		
		textFieldCatCanal = new JTextField();
		textFieldCatCanal.setEditable(false);
		panelDCanal.add(textFieldCatCanal);
		textFieldCatCanal.setColumns(10);
		
		JPanel panelDVideo = new JPanel();
		panelDVideo.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDVideo);
		panelDVideo.setLayout(new GridLayout(4, 2, 2, 5));
		
		JLabel label_8 = new JLabel("Nombre");
		panelDVideo.add(label_8);
		
		comboBoxVideos = new JComboBox();
		comboBoxVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String video = (String)comboBoxVideos.getSelectedItem();
				if( comboBoxVideos.getSelectedIndex()!=-1){
					//crear dtVideo
					DtVideo dtVideo = controlUsr.obtenerInfoAdicVideo((String)comboBoxNick.getSelectedItem(), video);
					//cargar datos video
					textAreaDescVideo.setText(dtVideo.getDescripcion());
				}
			}
		});
		panelDVideo.add(comboBoxVideos);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panelDVideo.add(lblDescripcion);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelDVideo.add(scrollPane_4);
		
		textAreaDescVideo = new JTextArea();
		textAreaDescVideo.setEditable(false);
		scrollPane_4.setViewportView(textAreaDescVideo);
		
		JButton btnMasInformacion = new JButton("Mas informacion");
		btnMasInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abrir consulta video
				openConsultarVideo();
			}
		});
		panelDVideo.add(btnMasInformacion);
		
		JPanel panelDLista = new JPanel();
		panelDLista.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Listas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelDLista);
		panelDLista.setLayout(new GridLayout(4, 2, 2, 5));
		
		JLabel label_10 = new JLabel("Nombre Lista");
		panelDLista.add(label_10);
		comboBoxListas = new JComboBox();
		comboBoxListas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//cargar datos lista
							//
						
			}
		});
		panelDLista.add(comboBoxListas);
		
		JButton btnMasInformacion_1 = new JButton("Mas informacion");
		btnMasInformacion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Factory fabrica = Factory.getInstance();
				IVideoCtrl ICV = fabrica.getIVideoCtrl();
				ConsultaListaInternalFrame listaIFrame = new ConsultaListaInternalFrame(controlUsr,ICV);
				String lista = (String)comboBoxListas.getSelectedItem();
				String nickU = (String)comboBoxNick.getSelectedItem();

				if(comboBoxListas.getSelectedIndex()!=-1 && (String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1 ){
					listaIFrame.llamadaParticular(nickU, lista);
					adminPrincipal.getFrames()[0].setLayout(null);
					adminPrincipal.getFrames()[0].add(listaIFrame);
					listaIFrame.show();
				}else{
					infoBox("Falta seleccionar usuario y/o lista","Consulta usuario");
				}
			
			}
		});
		panelDLista.add(btnMasInformacion_1);
		
		JPanel panelSeguidos = new JPanel();
		panelSeguidos.setBorder(new TitledBorder(null, "Seguidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelSeguidos);
		panelSeguidos.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelSeguidos.add(scrollPane_1);
		
		listSeguidos = new JList();
		listSeguidos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listSeguidos);
		
		JPanel panelSeguidores = new JPanel();
		panelSeguidores.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seguidores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelSeguidores);
		panelSeguidores.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panelSeguidores.add(scrollPane_2);
		
		listSeguidores = new JList();
		listSeguidores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_2.setViewportView(listSeguidores);
		
		//CARGAR NICK
		String[] nickUsuario = controlUsr.listarNicknamesUsuarios();
		for(int i=0; i<nickUsuario.length;i++){
			 comboBoxNick.addItem(nickUsuario[i]);
	     }
		comboBoxNick.setSelectedIndex(-1);
		limpiar();
		 //.....//
		
	}
	private void cargarDatos(DtUsuario usr, DtCanal usrCanal, String nickU){
		textFieldEmail.setText(usr.getEmail());
		textFieldNombre.setText(usr.getNombre());
		textFieldApellido.setText(usr.getApellido());
		dateChooser.setDate(usr.getFecha_nacimiento().getFecha());
		
		textFieldNomCanal.setText(usrCanal.getNombre());
		if (usrCanal.getPrivacidad()){
			textFieldPrivacidad.setText("Privado");
		}else{
			textFieldPrivacidad.setText("Publico");
		}
		textPaneDesc.setText(usrCanal.getDescripcion());
		textFieldCatCanal.setText(usrCanal.getCategoria().getNombre());
		
		byte[] fotoUsr=usr.getFoto();
		if(fotoUsr!=null){
			lblFoto.setVisible(true);
			BufferedImage image = Imagen.byteToImagen(fotoUsr);
			lblFoto.setSize(140,140);
		 	ImageIcon icono = new ImageIcon(image.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
		 	lblFoto.setIcon(icono);
		}else{
			 ImageIcon icono = new ImageIcon();
			 lblFoto.setIcon(icono);
		 }
		//CARGAR VIDEOS
		String[] nomVideos = controlUsr.listarVideosCanal(nickU);
		for(int i=0; i<nomVideos.length;i++){
			 comboBoxVideos.addItem(nomVideos[i]);
		}
		comboBoxVideos.setSelectedIndex(-1);
		textAreaDescVideo.setText(null);
		//CARGAR LISTAS
		String[] nomListas = controlUsr.listarLDRdeUsuario(nickU);

		for(int e=0; e<nomListas.length;e++){
			 comboBoxListas.addItem(nomListas[e]);
		}
		comboBoxListas.setSelectedIndex(-1);
				
		//CARGAR SEGUIDOS
		String[] usrSigue = controlUsr.listarUsuariosQueSigue(nickU);
		DefaultListModel model=new DefaultListModel();
		listSeguidos.setModel(model);
	  
		for(int i=0; i<usrSigue.length;i++){
			model.addElement(usrSigue[i]);
		}
		//CARRGAR SEGUIDORES 
		String[] usrSiguedores = controlUsr.listarUsuariosQueLeSigue(nickU);
		DefaultListModel model2=new DefaultListModel();
		listSeguidores.setModel(model2);
		for(int i=0; i<usrSiguedores.length;i++){
			model2.addElement(usrSiguedores[i]);
		}
		
	}
	private void openConsultarVideo(){
	   //modificarUsuario modUsrIFrame = new modificarUsuario();
	   ConsultarVideoInternalFrame consVideoIFrame = new ConsultarVideoInternalFrame();
	   adminPrincipalBienHecho.getFrames()[0].setLayout(null);
	   adminPrincipalBienHecho.getFrames()[0].add(consVideoIFrame);
	   consVideoIFrame.show();
	   consVideoIFrame.moveToFront(); 
	//   modUsrIFrame.setVisible(true);
	 }
	 private void limpiar(){
		 textFieldEmail.setText("");
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			dateChooser.setDate(null);
			

			lblFoto.setIcon(null);
			lblFoto.setVisible(false);
			

			textFieldNomCanal.setText("");
			textFieldPrivacidad.setText(null);
			
			textPaneDesc.setText("");
			textFieldCatCanal.setText("");
			
			comboBoxVideos.setSelectedIndex(-1);
			comboBoxVideos.removeAllItems();
			
			comboBoxListas.setSelectedIndex(-1);
			comboBoxListas.removeAllItems();
			
			textAreaDescVideo.setText(null);
			DefaultListModel model2=new DefaultListModel();
			listSeguidores.setModel(model2);
			listSeguidos.setModel(model2);
			
	 }
}
