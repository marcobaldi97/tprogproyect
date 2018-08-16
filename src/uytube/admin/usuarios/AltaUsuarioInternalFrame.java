package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JCalendar;

public class AltaUsuarioInternalFrame extends JInternalFrame {
	private JTextField textFieldNombreC;
	private JTextField textFieldNick;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField txtApellido;

	/**
	 * Create the frame.
	 */
	public AltaUsuarioInternalFrame() {
		setTitle("Alta Usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 319, 373);
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		getContentPane().setLayout(flowLayout);
		
		JPanel datosUsuario = new JPanel();
		datosUsuario.setBorder(new TitledBorder(null, "Datos Usuario", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(datosUsuario);
		datosUsuario.setLayout(new GridLayout(0, 2, 2, 3));
		
		JLabel lblNick = new JLabel("Nick");
		datosUsuario.add(lblNick);
		
		textFieldNick = new JTextField();
		datosUsuario.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		datosUsuario.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			//evento para cuando se pierde el foco de email (el usuario se va a escribir a otro sitio o pulsar alg�n bot�n)
			public void focusLost(FocusEvent e) {
				//VERIFICAR DISPONIBILIDAD DE NICK Y EMAIL
				String nick = textFieldNick.getText();
				String email = textFieldNick.getText();
				//falta controlar si un campo es vacio
				//Boolean disponible = verificarDisponibilidad(nick, email);
				
			}
		});
		datosUsuario.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		datosUsuario.add(lblNombre_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		datosUsuario.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		datosUsuario.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		datosUsuario.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		datosUsuario.add(lblFechaNac);
		
		JDateChooser dateChooser = new JDateChooser();
		datosUsuario.add(dateChooser);
		
		JPanel datosCanalPanel = new JPanel();
		datosCanalPanel.setBorder(new TitledBorder(null, "Datos Canal", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(datosCanalPanel);
		datosCanalPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		datosCanalPanel.add(lblNombre);
		
		textFieldNombreC = new JTextField();
		textFieldNombreC.setEditable(false);
		datosCanalPanel.add(textFieldNombreC);
		textFieldNombreC.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		datosCanalPanel.add(lblDescripcion);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		datosCanalPanel.add(editorPane);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		datosCanalPanel.add(lblPrivacidad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Privado", "Publico"}));
		datosCanalPanel.add(comboBox);
		
	    
	    
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
		
		JLabel label = new JLabel("             ");
		panel.add(label);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CREAR USUARIO
				crearUsuario();
			}
		});
		panel.add(btnCrear);

	}
	private void crearUsuario() {
		
	}

}
