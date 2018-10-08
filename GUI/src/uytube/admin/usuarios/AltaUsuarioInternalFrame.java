package uytube.admin.usuarios;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JEditorPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.toedter.calendar.JDateChooser;

import uytube.Imagen;
import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

import javax.swing.JScrollPane;


public class AltaUsuarioInternalFrame extends JInternalFrame {
	private IUsuarioCtrl controlUsr;
	
	private JTextField textFieldNombreC;
	private JTextField textFieldNick;
	private JTextField textFieldEmail;
	private JTextField textFieldNombre;
	private JTextField txtApellido;
	private JEditorPane editorPaneDesc = new JEditorPane();
	private JDateChooser dateChooser;
	private JComboBox comboBoxCat;
	private File archivo;
	
	 public static void infoBox(String infoMessage, String titleBar){
	        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	 }
	/**
	 * Create the frame.
	 * @param iCU 
	 */
	public AltaUsuarioInternalFrame(IUsuarioCtrl iCU,IVideoCtrl iCV) {
		setResizable(true);
		setIconifiable(true);
		controlUsr = iCU;
		
		setTitle("Alta Usuario");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 312, 456);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
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
		
		dateChooser = new JDateChooser();
		datosUsuario.add(dateChooser);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Foto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		
		JLabel lblFotoU = new JLabel("");
		panel_1.add(lblFotoU);
		
		JButton btnElegir = new JButton("Elegir Foto");
		panel_1.add(btnElegir);
		btnElegir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivo = Imagen.elegirImagen();
				if(archivo!=null){
					Image imagen = new ImageIcon(archivo.getAbsolutePath()).getImage();
					lblFotoU.setSize(50,50);
					ImageIcon icono = new ImageIcon(imagen.getScaledInstance(lblFotoU.getWidth(), lblFotoU.getHeight(), Image.SCALE_DEFAULT));
					lblFotoU.setIcon(icono);
				}
			}
		});
		
		
		
		
		
				
		JPanel datosCanalPanel = new JPanel();
		datosCanalPanel.setBorder(new TitledBorder(null, "Datos Canal", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		getContentPane().add(datosCanalPanel);
		datosCanalPanel.setLayout(new GridLayout(0, 2, 2, 5));
		
		JLabel lblNombre = new JLabel("Nombre");
		datosCanalPanel.add(lblNombre);
		
		textFieldNombreC = new JTextField();
		datosCanalPanel.add(textFieldNombreC);
		textFieldNombreC.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		datosCanalPanel.add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		datosCanalPanel.add(scrollPane);
		
		editorPaneDesc = new JEditorPane();
		scrollPane.setViewportView(editorPaneDesc);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		datosCanalPanel.add(lblPrivacidad);
		
		JComboBox comboBoxPrivacidad = new JComboBox();
		comboBoxPrivacidad.setModel(new DefaultComboBoxModel(new String[] {"Privado", "Publico"}));
		datosCanalPanel.add(comboBoxPrivacidad);
		
		JLabel lblCategoria = new JLabel("Categoria");
		datosCanalPanel.add(lblCategoria);
		
		comboBoxCat = new JComboBox();
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {""}));
		datosCanalPanel.add(comboBoxCat);
		
	    
	    
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CREAR USUARIO
				//obtener datos
				String  nick, nom, ape, email, nomCanal,descCanal, catE;
				Privacidad privacidad;
				DtFecha nac;
				nick = textFieldNick.getText();
				email = textFieldEmail.getText(); 
				
				nom = textFieldNombre.getText();
				ape = txtApellido.getText();
				nac = new DtFecha(dateChooser.getDate());
				nomCanal = textFieldNombreC.getText();
				descCanal = editorPaneDesc.getText();
				if (comboBoxPrivacidad.getSelectedIndex()==0){ privacidad=Privacidad.PRIVADO;}
				else{privacidad = Privacidad.PUBLICO;}
			
				catE = (String) comboBoxCat.getSelectedItem();
				
				
				//VERIFICAR DISPONIBILIDAD DE NICK Y EMAIL
				boolean disponible = controlUsr.verificarDispUsuario(nick, email);
				//crear
				if(disponible && verificarCampos()){
					if(textFieldNombreC.getText().isEmpty()){nomCanal=nick; }
					if(comboBoxCat.getSelectedItem()=="" || comboBoxCat.getSelectedIndex()==-1){catE=null;}
					controlUsr.nuevoUsuario(nick,"1234",nom, ape, email, nac, Imagen.imagenToByte(archivo),nomCanal,descCanal,privacidad, catE) ;
					infoBox("Usuario creado con exito", "Alta Usuario");
					setVisible(false);
					dispose();
					limpiar();
				}else if(!disponible){
					//avisar que no se pudo crear
					infoBox("Ya existe el usuario", "Error");
					//limpiar();
				}
			}
		});
		panel.add(btnCrear);
		
		JLabel label = new JLabel("             ");
		panel.add(label);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel.add(btnCancelar);
		
		//CARGAR CATEGORIAS
        DtCategoria[] set_cat=iCV.listarCategorias();
           
        for (int i=0 ; i<set_cat.length; i++) {
             comboBoxCat.addItem(set_cat[i].getNombre());
        }
        comboBoxCat.setSelectedIndex(-1);

	}
	
	private Boolean verificarCampos(){
		if ( textFieldNick.getText().isEmpty() || textFieldEmail.getText().isEmpty()|| textFieldNombre.getText().isEmpty( )
				|| txtApellido.getText().isEmpty() || dateChooser.getDate()==null){
			infoBox("Campos sin completar", "Aviso");
			return false;
		}else {
			return true;
		}
		
	}
	private void limpiar(){
		textFieldNick.setText("");
		textFieldEmail.setText("");
		textFieldNombre.setText("");
		txtApellido.setText("");
		editorPaneDesc.setText("");
		textFieldNombreC.setText("");
		dateChooser.setDate(null);
		comboBoxCat.setSelectedIndex(-1);
	}
	
}
