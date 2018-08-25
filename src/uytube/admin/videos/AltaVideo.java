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
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class AltaVideo extends JInternalFrame {
	private JTextField textFieldNombreVideo;
	private JTextField textFieldURL;
	private JDateChooser dateChooserFecha;
	private JTextArea textAreaDesc;
	private JSpinner spinnerDuracion;
	private JComboBox comboBoxNicknames;
	private JComboBox comboBoxCategoria;

    private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void clear() {
    	comboBoxNicknames.setSelectedIndex(-1);
    	textFieldNombreVideo.setText("");
    	textFieldURL.setText("");
    	textAreaDesc.setText("");
    	comboBoxCategoria.setSelectedItem(-1);
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
		
		comboBoxNicknames = new JComboBox();
		comboBoxNicknames.setEditable(true);
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
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setEditable(true);
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
		
		
		comboBoxCategoria = new JComboBox();
		//empiezo a cargar las categorias.
		DtCategoria[] categoriasDts = iCV.listarCategorias();
		String[] nombresCategoriasArray = new String[categoriasDts.length];
		for(int i = 0; i < categoriasDts.length; i++) {
			nombresCategoriasArray[i] = categoriasDts[i].getNombre();
		}
		comboBoxCategoria.setModel(new DefaultComboBoxModel(nombresCategoriasArray));
		//termino de cargar las categorias
		comboBoxCategoria.setSelectedIndex(-1);
		getContentPane().add(comboBoxCategoria);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPrivacidad);
		
		JComboBox comboBoxPrivacidad = new JComboBox();
		comboBoxPrivacidad.setEnabled(false);
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
				if(iCU.memberUsuario(nickU) == true) {
					if(iCU.memberVideoEnUsuario(nickU, nom) != true) {
						if(!textFieldNombreVideo.getText().equals("")) {
							String desc = textAreaDesc.getText();
							Integer dur = (Integer) spinnerDuracion.getValue();
							DtFecha fp = new DtFecha(dateChooserFecha.getDate());
							String url = textFieldURL.getText();
							//asigno categoria.
							DtCategoria catE = null;
							String nombreCategoria =(String) comboBoxCategoria.getSelectedItem(); //Puede haber un problema aca
							if(comboBoxCategoria.getSelectedIndex() == -1) {
								catE = null;
							}else {
								Boolean flag = false;
								int i = 0;
								while (( i < categoriasDts.length) && (flag == false)){
									if(nombreCategoria == categoriasDts[i].getNombre()) {
										catE = categoriasDts[i];
										flag = true;
									}
									i++;
								}
							}
							//termino de asignar categoria
							//Asigno privado
							boolean p = false;
							if(comboBoxPrivacidad.getSelectedItem() == "privado") p = true;
							else p = false;
							//termino de asignar privado.
							iCU.aniadirVideo(nickU, nom, desc, dur, fp, url, catE, p);
							infoBox("Video creado exitosamente","Exito");
							clear();
					    	int freshIndex = 0;
					    	spinnerDuracion.setValue(Integer.valueOf(freshIndex));
							setVisible(false);
							dispose();
						}else infoBox("El titulo no puede estar vacio.","Error");
					}else infoBox("Ya existe el nombre del video en el canal del usuario seleccionado.","Error");
				}else infoBox("No existe el usuario en el sistema.","Error");
			}
		});
		getContentPane().add(btnNewButtonAceptar);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNicknameAutor, comboBoxPrivacidad, lblNombreVideo, lblNewLabel, lblDescripcion, lblDuracion, lblFecha, dateChooserFecha.getCalendarButton(), lblCategoria, lblPrivacidad, comboBoxNicknames, textFieldNombreVideo, textFieldURL, textAreaDesc, spinnerDuracion, dateChooserFecha, comboBoxCategoria, btnNewButtonAceptar, btnNewButtonCancelar}));

	}

}
