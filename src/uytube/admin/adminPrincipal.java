package uytube.admin;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
//import presentacion.CrearUsuario;

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
	private QuitarVideoListaInternalFrame quitarVideoListIFrame;
	private CrearListaInternalFrame crearListIFrame;

	private IUsuarioCtrl ICU;

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
		 Factory fabrica = Factory.getInstance();
	     ICU = fabrica.getIUsuarioCtrl();
	        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        aUsrIFrame = new AltaUsuarioInternalFrame(ICU);
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
				 conUsrIFrame = new ConsultaUsuarioInternalFrame(ICU);
			     contentPane.setLayout(null);
			     contentPane.add(conUsrIFrame);
			     conUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmConsulta);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 listarUsrIFrame = new ListarUsuariosInternalFrame(ICU);
			     contentPane.setLayout(null);
			     contentPane.add(listarUsrIFrame);
			     listarUsrIFrame.setVisible(true);
			}
		});
		mnUsuario.add(mntmListar);

		VideosMenu videosMenu = new VideosMenu(getContentPane());
		menuBar.add(videosMenu.getMenu());

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
		
		JMenuItem mntmCrear = new JMenuItem("Crear ");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearListIFrame = new CrearListaInternalFrame(ICU);
				contentPane.setLayout(null);
			    contentPane.add(crearListIFrame);
			    crearListIFrame.setVisible(true);	
			}
		});
		mnListas.add(mntmCrear);
		mnListas.add(mntmAgregarVideo);
		
		JMenuItem mntmQuitarVideo = new JMenuItem("Quitar video");
		mntmQuitarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 quitarVideoListIFrame = new QuitarVideoListaInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(quitarVideoListIFrame);
			     quitarVideoListIFrame.setVisible(true);	
			}
		});
		mnListas.add(mntmQuitarVideo);

		JMenu mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
	}

}
