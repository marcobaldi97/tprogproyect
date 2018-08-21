package uytube.admin.usuarios;

import java.awt.EventQueue;
import uytube.admin.videos.modificar.*;
import uytube.logica.DtCanal;
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

public class modificarUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomCanal;
	private JTextField textFieldEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dateChooser;
	private JRadioButton rdbtnPrivado;
	private JRadioButton rdbtnPublico;
	private JTextPane textPaneDesc;
	private JComboBox comboBoxVideos;
	private IUsuarioCtrl controlUsr;
	private JTextField textFieldCatCanal;
	private JComboBox comboBoxListas;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
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
		setBounds(100, 100, 509, 394);
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
				limpiar();
				if((String)comboBoxNick.getSelectedItem() != " " && comboBoxNick.getSelectedIndex()!=-1){
					//pedir Dt
					DtUsuario usr= controlUsr.listarDatosUsuario(nickU);
					DtCanal usrCanal = controlUsr.mostrarInfoCanal(nickU);
				
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
		panelDatosUsuario.add(dateChooser);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(true);
				textFieldApellido.setEditable(true);
				dateChooser.enable(true);
				btnModificar.setText("Guardar");
				if(btnModificar.getText()=="Guardar"){
					
				}
			}
		});
		panelDatosUsuario.add(btnModificar);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNombre.setEditable(false);
				textFieldApellido.setEditable(false);
				dateChooser.enable(false);
				btnModificar.setText("Modificar");
			}
		});
		panelDatosUsuario.add(btnCancelar_1);
		
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
		rdbtnPrivado.setSelected(true);
		buttonGroup.add(rdbtnPrivado);
		panelDatosCanal.add(rdbtnPrivado);
		
		JLabel label_1 = new JLabel("");
		panelDatosCanal.add(label_1);
		
		rdbtnPublico = new JRadioButton("Publico");
		buttonGroup.add(rdbtnPublico);
		panelDatosCanal.add(rdbtnPublico);
		
		JLabel lblDescripicin = new JLabel("Descripici\u00F3n");
		panelDatosCanal.add(lblDescripicin);
		
		textPaneDesc = new JTextPane();
		textPaneDesc.setEditable(false);
		panelDatosCanal.add(textPaneDesc);
		
		JLabel label_5 = new JLabel("Categoria");
		panelDatosCanal.add(label_5);
		
		textFieldCatCanal = new JTextField();
		textFieldCatCanal.setText("");
		textFieldCatCanal.setEditable(false);
		textFieldCatCanal.setColumns(10);
		panelDatosCanal.add(textFieldCatCanal);
		
		JButton btnModificar_3 = new JButton("Modificar");
		panelDatosCanal.add(btnModificar_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel label = new JLabel("Nombre");
		panel.add(label);
		
		comboBoxVideos = new JComboBox();
		panel.add(comboBoxVideos);
		
		JButton button = new JButton("Modificar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//abrir videos.modificar
				
			}
		});
		panel.add(button);
		
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
		rdbtnPrivado_1.setSelected(true);
		buttonGroup_1.add(rdbtnPrivado_1);
		panel_1.add(rdbtnPrivado_1);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JRadioButton rdbtnPublico_1 = new JRadioButton("Publico");
		buttonGroup_1.add(rdbtnPublico_1);
		panel_1.add(rdbtnPublico_1);
		
		JButton button_1 = new JButton("Modificar");
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
		limpiar();

	}
	private void limpiar(){
		
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
		textPaneDesc.setText(usrCanal.getDescripcion());
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
}
