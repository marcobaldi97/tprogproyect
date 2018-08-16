package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.BorderLayout;

public class ListarUsuariosInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuariosInternalFrame frame = new ListarUsuariosInternalFrame();
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
	public ListarUsuariosInternalFrame() {
		setClosable(true);
		setMaximizable(true);
		setTitle("Listar Usuarios");
		setResizable(true);
		setBounds(100, 100, 450, 300);
		
		JList listUsuarios = new JList();
		getContentPane().add(listUsuarios, BorderLayout.CENTER);

	}

}
