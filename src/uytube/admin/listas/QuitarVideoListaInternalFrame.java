package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

import uytube.logica.DtVideo;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.UsuarioCtrl;

public class QuitarVideoListaInternalFrame extends JInternalFrame {
	private IUsuarioCtrl controlUsr;

	/**
	 * Create the frame.
	 */
	public QuitarVideoListaInternalFrame(IUsuarioCtrl ICU) {
		controlUsr = ICU;
		setTitle("Quitar Video");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 266, 221);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 10));

		JLabel lblNick = new JLabel("Nick");
		getContentPane().add(lblNick);

		final String[] nicknames = controlUsr.listarNicknamesUsuarios();

		// DefaultComboBoxModel<String> nicknamesModel = new
		// DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> listasModel = new DefaultComboBoxModel<String>();
		DefaultComboBoxModel<String> videosModel = new DefaultComboBoxModel<String>();

		JComboBox comboBoxNick = new JComboBox();
		getContentPane().add(comboBoxNick);
		// comboBoxNick.setModel(nicknamesModel);
		for (final String nickname : nicknames) {
			comboBoxNick.addItem(nickname);
		}
		comboBoxNick.setSelectedIndex(-1);

		JLabel lblListas = new JLabel("Listas");
		getContentPane().add(lblListas);

		JComboBox comboBoxLista = new JComboBox(listasModel);
		getContentPane().add(comboBoxLista);

		JLabel lblVideo = new JLabel("Video");
		getContentPane().add(lblVideo);

		JComboBox comboBoxVideo = new JComboBox(videosModel);
		getContentPane().add(comboBoxVideo);

		comboBoxNick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String nickname = (String) comboBoxNick.getSelectedItem();
				final String[] listasDeUsuario = controlUsr.listarLDRdeUsuario(nickname);
				listasModel.removeAllElements();
				for (final String lista : listasDeUsuario) {
					listasModel.addElement(lista);
				}
				comboBoxLista.setModel(listasModel);
			}
		});

		comboBoxLista.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String nickname = (String) comboBoxNick.getSelectedItem();
				final String listaNombre = (String) comboBoxLista.getSelectedItem();
				if (listaNombre == null) {
					return;
				}
				final String[] videosDeLista = controlUsr.listarVideosListaReproduccionUsuario(nickname, listaNombre);
				videosModel.removeAllElements();
				for (final String video : videosDeLista) {
					videosModel.addElement(video);
				}
				comboBoxVideo.setModel(videosModel);
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		getContentPane().add(btnEliminar);

		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String nickname = (String) comboBoxNick.getSelectedItem();
				final String nombreVideo = (String) comboBoxVideo.getSelectedItem();
				final String nombreLista = (String) comboBoxLista.getSelectedItem();

				final DtVideo video = controlUsr.obtenerInfoAdicVideo(nickname, nombreVideo);

				controlUsr.eliminarVideoLista(nickname, video.getIDVideo(), nombreLista);
				infoBox("Video quitado correctamente", "Quitar video de lista");
				dispose();
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancelar);

	}

	private static void infoBox(String infoMessage, String titleBar) {
		JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

}
