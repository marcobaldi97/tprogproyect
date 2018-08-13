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
import uytube.admin.listas.*;
public class adminPrincipal extends JFrame {

	private JPanel contentPane;
	private AltaUsuarioInternalFrame aUsrIFrame;
	private modificarUsuario modUsrIFrame;
	private ConsultaUsuarioInternalFrame conUsrIFrame;
	private ListarUsuariosInternalFrame listarUsrIFrame;
	private AgregarVideoListaInternalFrame addVideoListIFrame;

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
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 modUsrIFrame = new modificarUsuario();
			     contentPane.setLayout(null);
			     contentPane.add(modUsrIFrame);
			     modUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmModificar);
		
		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 conUsrIFrame = new ConsultaUsuarioInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(conUsrIFrame);
			     conUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmConsulta);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 listarUsrIFrame = new ListarUsuariosInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(listarUsrIFrame);
			     listarUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmListar);

		//VideosMenu videosMenu = new VideosMenu(getContentPane());
		//menuBar.add(videosMenu.getMenu());

		JMenu mnListas = new JMenu("Listas");
		menuBar.add(mnListas);
		
		JMenuItem mntmAgregarVideo = new JMenuItem("Agregar video");
		mntmAgregarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 addVideoListIFrame = new AgregarVideoListaInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(addVideoListIFrame);
			     addVideoListIFrame.setVisible(true);	
			}
		});
		mnListas.add(mntmAgregarVideo);

		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
	}

}
