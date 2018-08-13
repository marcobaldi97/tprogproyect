package uytube.admin.usuarios;

import java.awt.EventQueue;

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

public class modificarUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomC;
	private JTextField textFieldEmail;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarUsuario frame = new modificarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public modificarUsuario() {
		setTitle("Modificar Usuario");
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 254, 548);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDatosUsuario);
		panelDatosUsuario.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel lblNickname = new JLabel("Nickname");
		panelDatosUsuario.add(lblNickname);
		
		JComboBox comboBox = new JComboBox();
		panelDatosUsuario.add(comboBox);
		
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
		
		JDateChooser dateChooser = new JDateChooser();
		panelDatosUsuario.add(dateChooser);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		panelDatosUsuario.add(btnCancelar_1);
		
		JButton btnModificar = new JButton("Modificar");
		panelDatosUsuario.add(btnModificar);
		
		JPanel panelDatosCanal = new JPanel();
		panelDatosCanal.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelDatosCanal);
		panelDatosCanal.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		panelDatosCanal.add(lblNombre_1);
		
		textFieldNomC = new JTextField();
		textFieldNomC.setEditable(false);
		panelDatosCanal.add(textFieldNomC);
		textFieldNomC.setColumns(10);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		panelDatosCanal.add(lblPrivacidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Privado", "Publico"}));
		panelDatosCanal.add(comboBox_1);
		
		JLabel lblDescripicin = new JLabel("Descripici\u00F3n");
		panelDatosCanal.add(lblDescripicin);
		
		JTextPane textPaneDesc = new JTextPane();
		textPaneDesc.setEditable(false);
		panelDatosCanal.add(textPaneDesc);
		
		JButton btnModificar_3 = new JButton("Modificar");
		panelDatosCanal.add(btnModificar_3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel label = new JLabel("Nombre");
		panel.add(label);
		
		JComboBox comboBox_NomVideo = new JComboBox();
		panel.add(comboBox_NomVideo);
		
		JLabel label_1 = new JLabel("Categoria");
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		panel.add(textField);
		
		JButton button = new JButton("Modificar");
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos listas de reproduccion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 2, 1));
		
		JLabel label_2 = new JLabel("Nombre Lista");
		panel_1.add(label_2);
		
		JComboBox comboBoxListasR = new JComboBox();
		panel_1.add(comboBoxListasR);
		
		JLabel label_3 = new JLabel("Categoria");
		panel_1.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JButton button_1 = new JButton("Modificar");
		panel_1.add(button_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		getContentPane().add(btnCancelar);

	}

}
