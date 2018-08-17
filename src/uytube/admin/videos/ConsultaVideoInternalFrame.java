package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultaVideoInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVideoInternalFrame frame = new ConsultaVideoInternalFrame();
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
	public ConsultaVideoInternalFrame() {
		setTitle("Consulta Video");
		setResizable(true);
		setMaximizable(true);
		
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
