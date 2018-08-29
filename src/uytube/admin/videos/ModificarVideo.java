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
	private JComboBox comboBoxNombreVideo = new JComboBox();
	private JTextField textFieldURL = new JTextField();
	private JDateChooser dateChooserFecha = new JDateChooser();
	private JTextArea textAreaDesc = new JTextArea();
	private JComboBox comboBoxCategoria = new JComboBox();
	private JSpinner spinnerDuracion = new JSpinner();
	private JComboBox comboBoxPrivacidad = new JComboBox();

	private static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	private void cargarDatos(DtVideo datosVideo) {
		textFieldURL.setText(datosVideo.getUrl());
		textAreaDesc.setText(datosVideo.getDescripcion());
		comboBoxCategoria.setSelectedItem(datosVideo.getCategoria().getNombre());
		spinnerDuracion.setValue(datosVideo.getDuracion());
		if (datosVideo.getPrivacidad() == true)
			comboBoxPrivacidad.setSelectedItem("Privado");
		else
			comboBoxPrivacidad.setSelectedItem("Publico");
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
		setResizable(true);
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
				comboBoxNombreVideo.removeAllItems();
				if (comboBoxNicknames.getSelectedIndex() != -1) {
					String[] nombresVideos = iCU.listarVideosCanal(comboBoxNicknames.getSelectedItem().toString());

					for (final String nombreVideo : nombresVideos) {
						comboBoxNombreVideo.addItem(nombreVideo);
					}
				}
			}
		});
		String[] nicknamesArray = iCU.listarNicknamesUsuarios();
		for (final String nickname : nicknamesArray) {
			comboBoxNicknames.addItem(nickname);
		}
		comboBoxNicknames.setSelectedIndex(-1);
		getContentPane().add(comboBoxNicknames);

		JLabel lblNombreVideo = new JLabel("Nombre Video:");
		lblNombreVideo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNombreVideo);

		comboBoxNombreVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxNicknames.getSelectedIndex() != -1) {
					String nickname = comboBoxNicknames.getSelectedItem().toString();
					String nombreVideo = comboBoxNombreVideo.getSelectedItem().toString();
					DtVideo datosVideo = iCU.obtenerInfoAdicVideo(nickname, nombreVideo);
					cargarDatos(datosVideo);
				}
			}
		});
		getContentPane().add(comboBoxNombreVideo);

		JLabel lblNewLabel = new JLabel("URL Video:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		getContentPane().add(textFieldURL);
		textFieldURL.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDescripcion);

		getContentPane().add(textAreaDesc);

		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblDuracion);

		spinnerDuracion.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		getContentPane().add(spinnerDuracion);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblFecha);

		getContentPane().add(dateChooserFecha);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCategoria);

		// empiezo a cargar las categorias.
		DtCategoria[] categoriasDts = iCV.listarCategorias();
		for (final DtCategoria categoria : categoriasDts) {
			comboBoxCategoria.addItem(categoria.getNombre());
		}
		comboBoxCategoria.setSelectedIndex(-1);
		// termino de cargar las categorias
		getContentPane().add(comboBoxCategoria);

		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPrivacidad);

		comboBoxPrivacidad.setModel(new DefaultComboBoxModel(new String[] { "Privado", "Publico" }));
		comboBoxPrivacidad.setSelectedIndex(-1);
		getContentPane().add(comboBoxPrivacidad);

		JButton btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnNewButtonCancelar);

		JButton btnNewButtonAceptar = new JButton("Aceptar");
		btnNewButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String nickname = (String) comboBoxNicknames.getSelectedItem();
				final String nombreVideo = (String) comboBoxNombreVideo.getSelectedItem();
				final String descripcion = textAreaDesc.getText();
				final int duracion = (int) spinnerDuracion.getValue();
				final DtFecha fecha = new DtFecha(dateChooserFecha.getDate());
				final String url = textFieldURL.getText();
				final DtCategoria categoria = new DtCategoria((String) comboBoxCategoria.getSelectedItem());
				final boolean privado = ((String) comboBoxPrivacidad.getSelectedItem()).equals("Privado");

				iCU.ingresarNuevosDatosVideo(nickname, nombreVideo, descripcion, duracion, fecha, url, categoria,
						privado);

				infoBox("Video modificado con exito", "Modificar video");
				dispose();
			}
		});
		getContentPane().add(btnNewButtonAceptar);

	}

}
