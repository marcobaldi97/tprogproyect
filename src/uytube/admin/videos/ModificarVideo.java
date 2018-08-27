package uytube.admin.videos;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.DtVideo;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

public class ModificarVideo extends JInternalFrame {
	private JComboBox comboBoxNombreVideo;
	private JTextField textFieldURL;
	private JDateChooser dateChooserFecha;
	private JTextArea textAreaDesc;
	private JComboBox comboBoxCategoria;
	private JSpinner spinnerDuracion;
	private JComboBox comboBoxPrivacidad;
	
    private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void cargarDatos(DtVideo datosVideo) {
		textFieldURL.setText(datosVideo.getUrl());
		textAreaDesc.setText(datosVideo.getDescripcion());
		comboBoxCategoria.setSelectedItem(datosVideo.getCategoria().getNombre());
		spinnerDuracion.setValue(datosVideo.getDuracion());
		if(datosVideo.getPrivacidad() == true) comboBoxPrivacidad.setSelectedItem("Privado");
		else comboBoxPrivacidad.setSelectedItem("Publico");
		dateChooserFecha.setDate(datosVideo.getFechaPublicacion().getFecha());
    }
    
    private void limpiarDatos() {
    	textFieldURL.setText("");
    	Date dateRespawn = new Date();
    	dateChooserFecha.setDate(dateRespawn);
    	textAreaDesc.setText("");
    	comboBoxCategoria.setSelectedItem("");
    	spinnerDuracion.setValue(0);
    	comboBoxPrivacidad.setSelectedItem("Privado");
    }
    
    private void bloquearDatos() {
    	textFieldURL.setEnabled(false);
    	textAreaDesc.setEnabled(false);
    	comboBoxCategoria.setEnabled(false);
    	spinnerDuracion.setEnabled(false);
    	comboBoxPrivacidad.setEnabled(false);
    }
    
    private void habilitarDatos() {
    	textFieldURL.setEnabled(true);
    	textAreaDesc.setEnabled(true);
    	comboBoxCategoria.setEnabled(true);
    	spinnerDuracion.setEnabled(true);
    	comboBoxPrivacidad.setEnabled(true);
    }
	
	/**
	 * Create the frame.
	 */
	public ModificarVideo(IUsuarioCtrl iCU, IVideoCtrl iCV) {
		setTitle("Modificar Video");
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
		comboBoxNicknames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxNicknames.getSelectedIndex() != -1) {
					if(comboBoxNicknames.getSelectedItem().equals("") != true) {
						comboBoxNombreVideo.setEnabled(true);
						String[] nombresVideos = iCU.listarVideosCanal(comboBoxNicknames.getSelectedItem().toString());
						comboBoxNombreVideo.setModel(new DefaultComboBoxModel(nombresVideos));
					}else {
						comboBoxNombreVideo.setEnabled(false);
					}
				}
			}
		});
		comboBoxNicknames.setEditable(true);
		String[] nicknamesArray = iCU.listarNicknamesUsuarios();
		comboBoxNicknames.setModel(new DefaultComboBoxModel(nicknamesArray));
		getContentPane().add(comboBoxNicknames);
		
		JLabel lblNombreVideo = new JLabel("Nombre Video:");
		lblNombreVideo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNombreVideo);
		
		comboBoxNombreVideo = new JComboBox();
		comboBoxNombreVideo.setEnabled(false);
		comboBoxNombreVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxNicknames.getSelectedIndex() != -1) {
					if(comboBoxNombreVideo.getSelectedItem().equals("") != true) {
						String nickname = comboBoxNicknames.getSelectedItem().toString();
						String nombreVideo = comboBoxNombreVideo.getSelectedItem().toString();
						DtVideo datosVideo = iCU.obtenerInfoAdicVideo(nickname, nombreVideo);
						textFieldURL.setText(datosVideo.getUrl());
						String textAreaPopulator = datosVideo.getDescripcion();
						textAreaDesc.setText(textAreaPopulator);
						comboBoxCategoria.setSelectedItem(datosVideo.getCategoria().getNombre());
						spinnerDuracion.setValue(datosVideo.getDuracion());
						if(datosVideo.getPrivacidad() == true) comboBoxPrivacidad.setSelectedItem("Privado");
						else comboBoxPrivacidad.setSelectedItem("Publico");
						dateChooserFecha.setDate(datosVideo.getFechaPublicacion().getFecha());
					}else {
						limpiarDatos();
					}
				}
			}
		});
		getContentPane().add(comboBoxNombreVideo);
		
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
		
		spinnerDuracion = new JSpinner();
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
		
		
		comboBoxCategoria = new JComboBox();
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
		
		comboBoxPrivacidad = new JComboBox();
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

			}
		});
		getContentPane().add(btnNewButtonAceptar);

	}

}
