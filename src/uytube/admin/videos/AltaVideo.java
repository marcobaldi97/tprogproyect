package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AltaVideo extends JInternalFrame {
	private JTextField textFieldNombreVideo;
	private JTextField textFieldURL;
	private JTextField textField;
	private JDateChooser dateChooserFecha;

    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaVideo frame = new AltaVideo(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param iCU 
	 * @param iCV 
	 */
	public AltaVideo(IUsuarioCtrl iCU, IVideoCtrl iCV) {
		setTitle("Alta Video");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(9, 2, 5, 5));
		
		JLabel lblNicknameAutor = new JLabel("Nickname Autor:");
		lblNicknameAutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicknameAutor.setVerticalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNicknameAutor);
		
		JComboBox comboBoxNicknames = new JComboBox();
		String[] nicknamesArray = iCU.listarNicknamesUsuarios();
		comboBoxNicknames.setModel(new DefaultComboBoxModel(nicknamesArray));
		getContentPane().add(comboBoxNicknames);
		
		JLabel lblNombreVideo = new JLabel("Nombre Video:");
		lblNombreVideo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNombreVideo);
		
		textFieldNombreVideo = new JTextField();
		getContentPane().add(textFieldNombreVideo);
		textFieldNombreVideo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("URL Video:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);
		
		textFieldURL = new JTextField();
		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDescripcion);
		
		JTextArea textAreaDesc = new JTextArea();
		getContentPane().add(textAreaDesc);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDuracion);
		
		JSpinner spinnerDuracion = new JSpinner();
		spinnerDuracion.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(spinnerDuracion);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);
		
		dateChooserFecha = new JDateChooser();
		getContentPane().add(dateChooserFecha);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCategoria);
		
		
		JComboBox comboBoxCategoria = new JComboBox();
		//empiezo a cargar las categorias.
		DtCategoria[] categoriasDts = iCV.listarCategorias();
		String[] nombresCategoriasArray = new String[categoriasDts.length];
		for(int i = 0; i < categoriasDts.length; i++) {
			nombresCategoriasArray[i] = categoriasDts[i].getNombre();
		}
		comboBoxCategoria.setModel(new DefaultComboBoxModel(nombresCategoriasArray));
		//termino de cargar las categorias
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPrivacidad);
		
		JComboBox comboBoxPrivacidad = new JComboBox();
		comboBoxPrivacidad.setModel(new DefaultComboBoxModel(new String[] {"Privado", "Publico"}));
		getContentPane().add(comboBoxPrivacidad);
		
		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		getContentPane().add(btnNewButtonCancelar);
		
		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickU = (String) comboBoxNicknames.getSelectedItem();
				String nom = textFieldNombreVideo.getText();
				if(iCU.memberVideoEnUsuario(nickU, nom) != true) {
					String desc = textAreaDesc.getText();
					Integer dur = (Integer) spinnerDuracion.getValue();
					DtFecha fp = new DtFecha(dateChooserFecha.getDate());
					String url = textFieldURL.getText();
					//asigno categoria.
					DtCategoria catE = null;
					Boolean flag = false;
					int i = 0;
					while (( i < categoriasDts.length) && (flag == false)){
						if(comboBoxCategoria.getSelectedItem() == categoriasDts[i].getNombre()) {
							catE = categoriasDts[i];
							flag = true;
						}
						i++;
					}
					//termino de asignar categoria
					//Asigno privado
					boolean p = false;
					if(comboBoxPrivacidad.getSelectedItem() == "privado") p = true;
					else p = false;
					//termino de asignar privado.
					iCU.aniadirVideo(nickU, nom, desc, dur, fp, url, catE, p);
					infoBox("Video creado exitosamente","Exito");
				}else infoBox("Ya existe el nombre del video en el canal del usuario seleccionado.","Error");
			}
		});
		getContentPane().add(btnNewButtonAceptar);

	}

}
