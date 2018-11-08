package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class verUsuariosEliminados extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verUsuariosEliminados frame = new verUsuariosEliminados();
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
	public verUsuariosEliminados() {
		setBounds(100, 100, 450, 300);

	}

}
