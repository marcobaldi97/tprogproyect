package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


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
	private JLabel aviso;
	
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
		setBounds(100, 100, 319, 406);
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
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
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
				boolean privacidad;
				DtFecha nac;
				nick = textFieldNick.getText();
				email = textFieldEmail.getText(); 
				
				nom = textFieldNombre.getText();
				ape = txtApellido.getText();
				nac = new DtFecha(dateChooser.getDate());
				nomCanal = textFieldNombreC.getText();
				descCanal = editorPaneDesc.getText();
				if (comboBoxPrivacidad.getSelectedIndex()==0){ privacidad=true;}
				else{privacidad = false;}
			
				catE = (String) comboBoxCat.getSelectedItem();
				
				
				//VERIFICAR DISPONIBILIDAD DE NICK Y EMAIL
				boolean disponible = controlUsr.verificarDispUsuario(nick, email);
				//crear
				if(disponible && verificarCampos()){
					controlUsr.nuevoUsuario(nick,nom, ape, email, nac,"foto",nomCanal,descCanal,privacidad, catE) ;
					aviso.setText("Usuario creado con exito");
					limpiar();
				}else if(!disponible){
					//avisar que no se pudo crear
					aviso.setText("Ya existe el usuario");
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
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_1 = new JLabel("                                                     ");
		panel_1.add(label_1);
		
		aviso = new JLabel("");
		panel_1.add(aviso);
		
		//CARGAR CATEGORIAS
        DtCategoria[] set_cat=iCV.listarCategorias();
        
        
        for(int i=0; i<set_cat.length;i++){
             comboBoxCat.addItem(set_cat[i].getNombre());
        }

	}
	
	private Boolean verificarCampos(){
		if(textFieldNick.getText().isEmpty() || textFieldEmail.getText().isEmpty()|| textFieldNombre.getText().isEmpty()
				|| txtApellido.getText().isEmpty() || dateChooser.getDate()==null || textFieldNombreC.getText().isEmpty()){
			aviso.setText("Campos sin completar");
			return false;
		}else{return true;}
		
	}
	private void limpiar(){
		textFieldNick.setText("");
		textFieldEmail.setText("");
		textFieldNombre.setText("");
		txtApellido.setText("");
		editorPaneDesc.setText("");
		textFieldNombreC.setText("");
		dateChooser.setDate(null);
		comboBoxCat.setSelectedIndex(-1);;
	}
	
}
