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

public class AltaUsuarioInternalFrame extends JInternalFrame {
	private JTextField textFieldNombreCanal;
	private JTextField textFieldNick;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuarioInternalFrame frame = new AltaUsuarioInternalFrame();
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
	public AltaUsuarioInternalFrame() {
		setTitle("Alta Usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 319, 399);
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
			}
		});
		datosUsuario.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		datosUsuario.add(lblNombre_1);
		
		textFieldNombre = new JTextField();
		datosUsuario.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		datosUsuario.add(lblApellido);
		
		txtApellido = new JTextField();
		datosUsuario.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		datosUsuario.add(lblFechaNac);
		
		JPanel datosCanalPanel = new JPanel();
		datosCanalPanel.setBorder(new TitledBorder(null, "Datos Canal", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(datosCanalPanel);
		datosCanalPanel.setLayout(new GridLayout(4, 2, 1, 2));
		
		JLabel lblNombre = new JLabel("Nombre");
		datosCanalPanel.add(lblNombre);
		
		textFieldNombreCanal = new JTextField();
		datosCanalPanel.add(textFieldNombreCanal);
		textFieldNombreCanal.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		datosCanalPanel.add(lblDescripcin);
		
		JTextArea textAreaDesc = new JTextArea();
		textAreaDesc.setColumns(6);
		textAreaDesc.setRows(2);
		datosCanalPanel.add(textAreaDesc);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		datosCanalPanel.add(lblPrivacidad);
		
		JRadioButton rdbtnPrivado = new JRadioButton("Privado");
		rdbtnPrivado.setSelected(true);
		datosCanalPanel.add(rdbtnPrivado);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		datosCanalPanel.add(textPane);
		
		JRadioButton rdbtnPblico = new JRadioButton("P\u00FAblico");
		datosCanalPanel.add(rdbtnPblico);
		
	    //grupo de radio buttons
		//de esta forma solo se puede seleccionar uno a la vez
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnPrivado);
	    group.add(rdbtnPblico);
	    
	    
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
