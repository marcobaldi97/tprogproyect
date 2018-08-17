package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import uytube.logica.DtCanal;
import uytube.logica.DtUsuario;
import uytube.logica.IUsuarioCtrl;


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


public class ConsultaUsuarioInternalFrame extends JInternalFrame {
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomCanal;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable tableSeguidos;
	private JTable tableSeguidores;
	private JTextPane textPaneDesc;
	private JComboBox comboBoxVideos;
	private JComboBox comboBoxListas;
	private IUsuarioCtrl controlUsr;
	JDateChooser dateChooser;
	private JTextField textFieldPrivacidad;
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
		setBounds(100, 100, 384, 411);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
		
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
				limpiar();
				if((String)comboBoxNick.getSelectedItem() != " "){
					//pedir Dt
					DtUsuario usr= controlUsr.listarDatosUsuario(nickU);
					DtCanal usrCanal = controlUsr.mostrarInfoCanal(nickU);
				
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
		
		JPanel panelDCanal = new JPanel();
		panelDCanal.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDCanal);
		panelDCanal.setLayout(new GridLayout(3, 2, 2, 5));
		
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
		
		JPanel panelDVideo = new JPanel();
		panelDVideo.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDVideo);
		panelDVideo.setLayout(new GridLayout(5, 2, 2, 1));
		
		JLabel label_8 = new JLabel("Nombre");
		panelDVideo.add(label_8);
		
		comboBoxVideos = new JComboBox();
		comboBoxVideos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String video = (String)comboBoxVideos.getSelectedItem();
				if(video != " "){
					//pedir Dt
					
					//DtVideo dtVideo = 
					//cargar datos video
				}
			}
		});
		panelDVideo.add(comboBoxVideos);
		
		JLabel label_9 = new JLabel("Categoria");
		panelDVideo.add(label_9);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		panelDVideo.add(textField_4);
		
		JPanel panelDLista = new JPanel();
		panelDLista.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Listas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelDLista);
		panelDLista.setLayout(new GridLayout(5, 2, 2, 1));
		
		JLabel label_10 = new JLabel("Nombre Lista");
		panelDLista.add(label_10);
		
		comboBoxListas = new JComboBox();
		panelDLista.add(comboBoxListas);
		
		JLabel label_11 = new JLabel("Categoria");
		panelDLista.add(label_11);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panelDLista.add(textField_5);
		
		JPanel panelSeguidos = new JPanel();
		panelSeguidos.setBorder(new TitledBorder(null, "Seguidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelSeguidos);
		panelSeguidos.setLayout(new GridLayout(1, 0, 0, 0));
		
		tableSeguidos = new JTable();
		panelSeguidos.add(tableSeguidos);
		
		JPanel panelSeguidores = new JPanel();
		panelSeguidores.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seguidores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelSeguidores);
		panelSeguidores.setLayout(new GridLayout(1, 0, 0, 0));
		
		tableSeguidores = new JTable();
		panelSeguidores.add(tableSeguidores);
		
		//CARGAR NICK
		String[] nickUsuario = controlUsr.listarNicknamesUsuarios();
		comboBoxNick.addItem(" ");
		 for(int i=0; i<nickUsuario.length;i++){
			 comboBoxNick.addItem(nickUsuario[i]);
	     }
		 //.....//
		
	}
	private void cargarDatos(DtUsuario usr, DtCanal usrCanal, String nickU){
		textFieldEmail.setText(usr.getEmail());
		textFieldNombre.setText(usr.getNombre());
		textFieldApellido.setText(usr.getApellido());
		dateChooser.setDate(usr.getFecha_nacimiento().getFechaNac());
		
		textFieldNomCanal.setText(usrCanal.getNombre());
		if (usrCanal.getPrivacidad()){
			textFieldPrivacidad.setText("Privado");
		}else{
			textFieldPrivacidad.setText("Publico");
		}
		textPaneDesc.setText(usrCanal.getDescripcion());
		
		//CARGAR VIDEOS
		String[] nomVideos = controlUsr.listarVideosCanal(nickU);
		comboBoxVideos.addItem(" ");
		for(int i=0; i<nomVideos.length;i++){
			 comboBoxVideos.addItem(nomVideos[i]);
		}
		//CARGAR LISTAS
		//si esta vacio da error!!!!
		//String[] nomListas = controlUsr.listarLDRdeUsuario(nickU);
	/*	comboBoxListas.addItem(" ");
		for(int e=0; e<nomListas.length;e++){
			 comboBoxListas.addItem(nomListas[e]);
		}*/
	}
	 private void limpiar(){
		 textFieldEmail.setText("");
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			dateChooser.setDate(null);
			
			textFieldNomCanal.setText("");
			textFieldPrivacidad.setText("");
			
			textPaneDesc.setText("");
	 }
}
