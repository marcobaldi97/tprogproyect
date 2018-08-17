package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import uytube.logica.DtUsuario;
import uytube.logica.IUsuarioCtrl;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaUsuarioInternalFrame extends JInternalFrame {
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomCanal;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable tableSeguidos;
	private JTable tableSeguidores;

	private IUsuarioCtrl controlUsr;
	JDateChooser dateChooser;
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
		setBounds(100, 100, 347, 411);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel label = new JLabel("Nickname");
		panel.add(label);
		
		
		JComboBox comboBoxNick = new JComboBox();
		comboBoxNick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pedir Dt
				DtUsuario usr= controlUsr.listarDatosUsuario((String)comboBoxNick.getSelectedItem());
				//cargar datos
				textFieldEmail.setText(usr.getEmail());
				textFieldNombre.setText(usr.getNombre());
				textFieldApellido.setText(usr.getApellido());
				dateChooser.setDate(usr.getFecha_nacimiento().pasarDTaDate());
				
			}
		});
		panel.add(comboBoxNick);
		
		
		
		JLabel label_1 = new JLabel("Email");
		panel.add(label_1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		panel.add(textFieldEmail);
		
		JLabel label_2 = new JLabel("Nombre");
		panel.add(label_2);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		panel.add(textFieldNombre);
		
		JLabel label_3 = new JLabel("Apellido");
		panel.add(label_3);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		panel.add(textFieldApellido);
		
		JLabel label_4 = new JLabel("Fecha Nac.");
		panel.add(label_4);
		
		dateChooser = new JDateChooser();
		panel.add(dateChooser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(3, 2, 2, 5));
		
		JLabel label_5 = new JLabel("Nombre");
		panel_1.add(label_5);
		
		textFieldNomCanal = new JTextField();
		textFieldNomCanal.setEditable(false);
		textFieldNomCanal.setColumns(10);
		panel_1.add(textFieldNomCanal);
		
		JLabel label_6 = new JLabel("Privacidad");
		panel_1.add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1);
		
		JLabel label_7 = new JLabel("Descripici\u00F3n");
		panel_1.add(label_7);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		panel_1.add(textPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(5, 2, 2, 1));
		
		JLabel label_8 = new JLabel("Nombre");
		panel_2.add(label_8);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_2.add(comboBox_2);
		
		JLabel label_9 = new JLabel("Categoria");
		panel_2.add(label_9);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Listas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(5, 2, 2, 1));
		
		JLabel label_10 = new JLabel("Nombre Lista");
		panel_3.add(label_10);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_3.add(comboBox_3);
		
		JLabel label_11 = new JLabel("Categoria");
		panel_3.add(label_11);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_3.add(textField_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Seguidos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		tableSeguidos = new JTable();
		panel_4.add(tableSeguidos);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seguidores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		tableSeguidores = new JTable();
		panel_5.add(tableSeguidores);
		
		//CARGAR NICK
		String[] nickUsuario = controlUsr.listarNicknamesUsuarios();
		 for(int i=0; i<nickUsuario.length;i++){
			 comboBoxNick.addItem(nickUsuario[i]);
	     }
		 //.....//
		
	}
	

}
