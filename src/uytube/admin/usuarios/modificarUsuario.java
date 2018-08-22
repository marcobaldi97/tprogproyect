package uytube.admin.usuarios;

import java.awt.EventQueue;

import uytube.admin.adminPrincipalBienHecho;
import uytube.admin.videos.consultar.ConsultarVideoInternalFrame;
import uytube.admin.videos.modificar.*;
import uytube.logica.DtCanal;
import uytube.logica.DtFecha;
import uytube.logica.DtUsuario;
import uytube.logica.IUsuarioCtrl;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class modificarUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomCanal;
	private JTextField textFieldEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dateChooser;
	private JRadioButton rdbtnPrivado;
	private JRadioButton rdbtnPublico;
	private JComboBox comboBoxVideos;
	private IUsuarioCtrl controlUsr;
	private JTextField textFieldCatCanal;
	private JComboBox comboBoxListas;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnModificar ;
	private JButton btnCancelar_2;
	private JTextArea textAreaDesc;
	
	private DtUsuario usr;
	private DtCanal usrCanal;
	
	 public static void infoBox(String infoMessage, String titleBar){
	        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	 }
	/**
	 * Create the frame.
	 * @param iCU 
	 */
	
	public modificarUsuario(IUsuarioCtrl iCU) {
		
		
		controlUsr = iCU;
		
		setTitle("Modificar Usuario");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 404, 434);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDatosUsuario);
		panelDatosUsuario.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel lblNickname = new JLabel("Nickname");
		panelDatosUsuario.add(lblNickname);
		
		JComboBox comboBoxNick = new JComboBox();
		comboBoxNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickU = (String)comboBoxNick.getSelectedItem();
				if((String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1){
					//pedir Dt
					usr= controlUsr.listarDatosUsuario(nickU);
					usrCanal = controlUsr.mostrarInfoCanal(nickU);
				
					cargarDatos(usr, usrCanal, nickU);
			}
		}
		});
		comboBoxNick.setSelectedIndex(-1);
		panelDatosUsuario.add(comboBoxNick);
		
		JLabel lblEmail = new JLabel("Email");
		panelDatosUsuario.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		panelDatosUsuario.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		panelDatosUsuario.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		panelDatosUsuario.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		panelDatosUsuario.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		panelDatosUsuario.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		panelDatosUsuario.add(lblFechaNac);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		panelDatosUsuario.add(dateChooser);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setEnabled(false);
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(false);
				textFieldApellido.setEditable(false);
				dateChooser.setEnabled(false);
				btnModificar.setText("Modificar");
				String nickU = (String)comboBoxNick.getSelectedItem();
				if((String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1){
					//pedir Dt
					usr= controlUsr.listarDatosUsuario(nickU);
					usrCanal = controlUsr.mostrarInfoCanal(nickU);
					
					limpiar();
					cargarDatos(usr, usrCanal, nickU);
				}
				btnCancelar_1.setEnabled(false);
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  nickU, nom, ape;
				DtFecha nac;
				nickU = (String) comboBoxNick.getSelectedItem();
							
				nom = textFieldNombre.getText();
				ape = textFieldApellido.getText();
				nac = new DtFecha(dateChooser.getDate());
			
				//verificar campos!!
				
				if(btnModificar.getText()=="Guardar"){
					if(verificarCamposDatosUsu()){
						controlUsr.editarDatosUsuario(nickU,nom,ape, nac,"Foto");						
						infoBox("Usuario modificado","Modificar usuario");
						
						textFieldNombre.setEditable(false);
						textFieldApellido.setEditable(false);
						dateChooser.setEnabled(false);
						btnModificar.setText("Modificar");
					}
					btnCancelar_1.setEnabled(false);
				}else if(btnModificar.getText()=="Modificar"){
					textFieldNombre.setEditable(true);
					textFieldApellido.setEditable(true);
					dateChooser.setEnabled(true);
					btnCancelar_1.setEnabled(true);
					//((JTextField) dateChooser.getDateEditor()).setEditable(true);  
					btnModificar.setText("Guardar");
				}
			}
		});
		panelDatosUsuario.add(btnModificar);
		panelDatosUsuario.add(btnCancelar_1);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JLabel label = new JLabel("Nombre");
		panel.add(label);
		
		comboBoxVideos = new JComboBox();
		panel.add(comboBoxVideos);
		
		JButton button = new JButton("Modificar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//abrir videos.modificar
				openModificarVideo();
				
			}
		});
		panel.add(button);
		
		JPanel panelDatosCanal = new JPanel();
		panelDatosCanal.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDatosCanal);
		panelDatosCanal.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		panelDatosCanal.add(lblNombre_1);
		
		textFieldNomCanal = new JTextField();
		textFieldNomCanal.setEditable(false);
		panelDatosCanal.add(textFieldNomCanal);
		textFieldNomCanal.setColumns(10);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		panelDatosCanal.add(lblPrivacidad);
		
		rdbtnPrivado = new JRadioButton("Privado");
		rdbtnPrivado.setEnabled(false);
		rdbtnPrivado.setSelected(true);
		buttonGroup.add(rdbtnPrivado);
		panelDatosCanal.add(rdbtnPrivado);
		
		JLabel label_1 = new JLabel("");
		panelDatosCanal.add(label_1);
		
		rdbtnPublico = new JRadioButton("Publico");
		rdbtnPublico.setEnabled(false);
		buttonGroup.add(rdbtnPublico);
		panelDatosCanal.add(rdbtnPublico);
		
		JLabel lblDescripicin = new JLabel("Descripici\u00F3n");
		panelDatosCanal.add(lblDescripicin);
		
		JScrollPane scrollPane = new JScrollPane();
		panelDatosCanal.add(scrollPane);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setEditable(false);
		scrollPane.setViewportView(textAreaDesc);
		
		JLabel label_5 = new JLabel("Categoria");
		panelDatosCanal.add(label_5);
		
		textFieldCatCanal = new JTextField();
		textFieldCatCanal.setText("");
		textFieldCatCanal.setEditable(false);
		textFieldCatCanal.setColumns(10);
		panelDatosCanal.add(textFieldCatCanal);
		
		JButton btnModificar_3 = new JButton("Modificar");
		btnModificar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  nickU, nom, ape;
				DtFecha nac;
				nickU = (String) comboBoxNick.getSelectedItem();
							
				nom = textFieldNombre.getText();
				ape = textFieldApellido.getText();
				nac = new DtFecha(dateChooser.getDate());
			
				//verificar campos!!
				
				if(btnModificar_3.getText()=="Guardar"){
					if(verificarCamposDatosUsu()){
						controlUsr.editarDatosUsuario(nickU,nom,ape, nac,"Foto");						
						infoBox("Canal modificado","Modificar usuario");
						
						rdbtnPrivado.setEnabled(false);
						rdbtnPublico.setEnabled(false);
						
						textAreaDesc.setEditable(false);
						btnModificar_3.setText("Modificar");
					}
					btnCancelar_1.setEnabled(false);
				}else if(btnModificar.getText()=="Modificar"){
					rdbtnPrivado.setEnabled(true);
					rdbtnPublico.setEnabled(true);
					
					textAreaDesc.setEditable(true);
					btnModificar_3.setText("Guardar");
					
					btnCancelar_2.setEnabled(true);
				}
			}
		});
		panelDatosCanal.add(btnModificar_3);
		
		btnCancelar_2 = new JButton("Cancelar");
		btnCancelar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*textFieldNombre.setEditable(false);
				textFieldApellido.setEditable(false);
				dateChooser.setEnabled(false);
				btnModificar.setText("Modificar");
				String nickU = (String)comboBoxNick.getSelectedItem();
				if((String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1){
					//pedir Dt
					usr= controlUsr.listarDatosUsuario(nickU);
					usrCanal = controlUsr.mostrarInfoCanal(nickU);
					
					limpiar();
					cargarDatos(usr, usrCanal, nickU);
				}
				*/
				btnCancelar_2.setEnabled(false);
				
			}
		});
		btnCancelar_2.setEnabled(false);
		panelDatosCanal.add(btnCancelar_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos listas de reproduccion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel label_2 = new JLabel("Nombre Lista");
		panel_1.add(label_2);
		
		comboBoxListas = new JComboBox();
		panel_1.add(comboBoxListas);
		
		JLabel lblPrivacidad_1 = new JLabel("Privacidad");
		panel_1.add(lblPrivacidad_1);
		
		JRadioButton rdbtnPrivado_1 = new JRadioButton("Privado");
		rdbtnPrivado_1.setEnabled(false);
		rdbtnPrivado_1.setSelected(true);
		buttonGroup_1.add(rdbtnPrivado_1);
		panel_1.add(rdbtnPrivado_1);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JRadioButton rdbtnPublico_1 = new JRadioButton("Publico");
		rdbtnPublico_1.setEnabled(false);
		buttonGroup_1.add(rdbtnPublico_1);
		panel_1.add(rdbtnPublico_1);
		
		JButton button_1 = new JButton("Modificar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_1.setText("Guardar");
				rdbtnPrivado_1.setEnabled(true);
				rdbtnPublico_1.setEnabled(true);
				if(button_1.getText()=="Guardar"){
					String nickU = (String)comboBoxNick.getSelectedItem();
					String nombreL = (String)comboBoxListas.getSelectedItem();
					boolean privE=false;
					if(rdbtnPrivado.isSelected()){privE=true;}
					controlUsr.cambiarPrivLDR(nickU,nombreL,privE);
				}						
			}
		});
		panel_1.add(button_1);
		
		JLabel label_8 = new JLabel("");
		getContentPane().add(label_8);
		
		JLabel label_4 = new JLabel("                               ");
		getContentPane().add(label_4);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				dispose();
			}
		});
		getContentPane().add(btnCancelar);
		
		JLabel label_9 = new JLabel("");
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		getContentPane().add(label_11);
		//CARGAR NICK
		String[] nickUsuario = controlUsr.listarNicknamesUsuarios();
		for(int i=0; i<nickUsuario.length;i++){
			 comboBoxNick.addItem(nickUsuario[i]);
		}
		comboBoxNick.setSelectedIndex(-1);
		limpiar();

	}
	private void openModificarVideo(){
		   int idVideo; //como obtengo el idVideo??
		   
		   ModificarVideoInternalFrame modVideoIFrame = new ModificarVideoInternalFrame(adminPrincipalBienHecho.getFrames()[0]);
		   adminPrincipalBienHecho.getFrames()[0].setLayout(null);
		  // adminPrincipalBienHecho.getFrames()[0].add(modVideoIFrame);
		   modVideoIFrame.show();
	}
	private void limpiar(){
		 textFieldEmail.setText("");
			textFieldNombre.setText("");
			textFieldApellido.setText("");
			dateChooser.setDate(null);
			
			textFieldNomCanal.setText("");
			textFieldCatCanal.setText("");
			
			//textFieldPriv.setText("");
			
			comboBoxVideos.setSelectedIndex(-1);
			comboBoxVideos.removeAllItems();
			
			comboBoxListas.setSelectedIndex(-1);
			comboBoxListas.removeAllItems();
	 }


	private void cargarDatos(DtUsuario usr, DtCanal usrCanal, String nickU){
		textFieldEmail.setText(usr.getEmail());
		textFieldNombre.setText(usr.getNombre());
		textFieldApellido.setText(usr.getApellido());
		dateChooser.setDate(usr.getFecha_nacimiento().getFechaNac());
		
		textFieldNomCanal.setText(usrCanal.getNombre());
		if (usrCanal.getPrivacidad()){
			rdbtnPrivado.setSelected(true);
		}else{
			rdbtnPublico.setSelected(true);
		}
		textAreaDesc.setText(usrCanal.getDescripcion());
		textFieldCatCanal.setText(usrCanal.getCategoria().getNombre());
		
		//CARGAR VIDEOS
		String[] nomVideos = controlUsr.listarVideosCanal(nickU);
		for(int i=0; i<nomVideos.length;i++){
			 comboBoxVideos.addItem(nomVideos[i]);
		}
		comboBoxVideos.setSelectedIndex(-1);
		
		//CARGAR LISTAS
		String[] nomListas = controlUsr.listarLDRdeUsuario(nickU);
		for(int e=0; e<nomListas.length;e++){
			 comboBoxListas.addItem(nomListas[e]);
		}
		comboBoxListas.setSelectedIndex(-1);		
	}
	private Boolean verificarCamposDatosUsu(){
		if( textFieldEmail.getText().isEmpty()|| textFieldNombre.getText().isEmpty()
				|| textFieldApellido.getText().isEmpty() || dateChooser.getDate()==null){
			infoBox("Campos sin completar", "Aviso");
			return false;
		}else{return true;}
		
	}
}
