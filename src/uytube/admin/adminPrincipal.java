package uytube.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import uytube.admin.videos.VideosMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import uytube.admin.usuarios.*;
public class adminPrincipal extends JFrame {

	private JPanel contentPane;
	private AltaUsuarioInternalFrame aUsrIFrame;

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
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        aUsrIFrame = new AltaUsuarioInternalFrame();
		        contentPane.setLayout(null);
		        contentPane.add(aUsrIFrame);
		        aUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmAlta);

		//VideosMenu videosMenu = new VideosMenu(getContentPane());
		//menuBar.add(videosMenu.getMenu());

		JMenu mnListas = new JMenu("LIstas");
		menuBar.add(mnListas);

		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
	}

}
