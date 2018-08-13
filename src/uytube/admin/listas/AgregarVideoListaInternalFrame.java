package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarVideoListaInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarVideoListaInternalFrame frame = new AgregarVideoListaInternalFrame();
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
	public AgregarVideoListaInternalFrame() {
		setTitle("Agregar video a lista de reproduccion");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 192, 300);
		getContentPane().setLayout(new GridLayout(8, 1, 2, 5));
		
		JLabel lblNick = new JLabel("Nick");
		getContentPane().add(lblNick);
		
		JComboBox comboBoxNick = new JComboBox();
		getContentPane().add(comboBoxNick);
		
		JLabel lblVideos = new JLabel("Videos");
		getContentPane().add(lblVideos);
		
		JComboBox comboBoxVideos = new JComboBox();
		getContentPane().add(comboBoxVideos);
		
		JLabel lblListasDeReproduccion = new JLabel("Listas de Reproduccion");
		getContentPane().add(lblListasDeReproduccion);
		
		JComboBox comboBoxListas = new JComboBox();
		getContentPane().add(comboBoxListas);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//agregar el video 
				String nick, video, lista;
				nick =(String) comboBoxNick.getSelectedItem();
				video =(String) comboBoxVideos.getSelectedItem();
				lista =(String) comboBoxListas.getSelectedItem();
			}
		});
		getContentPane().add(btnAgregar);

	}

}
