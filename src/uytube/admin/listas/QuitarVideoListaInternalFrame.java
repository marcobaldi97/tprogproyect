package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JList;

public class QuitarVideoListaInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuitarVideoListaInternalFrame frame = new QuitarVideoListaInternalFrame();
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
	public QuitarVideoListaInternalFrame() {
		setTitle("Quitar Video");
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 266, 221);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 10));
		
		JLabel lblNick = new JLabel("Nick");
		getContentPane().add(lblNick);
		
		JComboBox comboBoxNick = new JComboBox();
		getContentPane().add(comboBoxNick);
		
		JLabel lblListas = new JLabel("Listas");
		getContentPane().add(lblListas);
		
		JList list = new JList();
		getContentPane().add(list);
		
		JLabel lblVideo = new JLabel("Video");
		getContentPane().add(lblVideo);
		
		JComboBox comboBoxVideo = new JComboBox();
		getContentPane().add(comboBoxVideo);
		
		JButton btnEliminar = new JButton("Eliminar");
		getContentPane().add(btnEliminar);
		
		JButton btnCancelar = new JButton("Cancelar");
		getContentPane().add(btnCancelar);

	}

}
