package uytube.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import uytube.admin.videos.VideosMenu;

public class adminPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPrincipal frame = new adminPrincipal();
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
	public adminPrincipal() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		VideosMenu videosMenu = new VideosMenu(getContentPane());
		menuBar.add(videosMenu.getMenu());

		JMenu mnListas = new JMenu("LIstas");
		menuBar.add(mnListas);

		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
	}

}
