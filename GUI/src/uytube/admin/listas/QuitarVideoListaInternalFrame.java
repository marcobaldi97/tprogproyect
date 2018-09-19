package uytube.admin.listas;

import java.awt.Component;
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
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
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
		DefaultComboBoxModel<DtVideo> videosModel = new DefaultComboBoxModel<DtVideo>();

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
		comboBoxVideo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof DtVideo) {
					DtVideo video = (DtVideo) value;
					setText(video.getNombre());
				}
				return this;
			}
		});
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
				videosModel.removeAllElements();
				if (listaNombre == null) {
					return;
				}
				final DtVideo[] videosDeLista = controlUsr.obtenerDtsVideosListaReproduccionUsuario(nickname,
						listaNombre);
				for (final DtVideo video : videosDeLista) {
					videosModel.addElement(video);
				}
				comboBoxVideo.setModel(videosModel);
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		getContentPane().add(btnEliminar);

		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final String nickname = (String) comboBoxNick.getSelectedItem();
				final DtVideo video = (DtVideo) comboBoxVideo.getSelectedItem();
				final String nombreLista = (String) comboBoxLista.getSelectedItem();

				controlUsr.eliminarVideoLista(nickname, video.getIDVideo(), nombreLista);
				infoBox("Video quitado correctamente", "Quitar video de lista");
				dispose();
			}
		});

		comboBoxVideo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final DtVideo video = (DtVideo) comboBoxVideo.getSelectedItem();

				final boolean btnEliminarEnabled = video != null;
				btnEliminar.setEnabled(btnEliminarEnabled);
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
