package uytube.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import uytube.admin.categoria.alta.AltaCategoria;
import uytube.admin.categoria.consulta.ConsultaCategoriaJInternalFrame;
import uytube.admin.listas.AgregarVideoListaInternalFrame;
import uytube.admin.listas.ConsultaListaInternalFrame;
import uytube.admin.listas.CrearListaInternalFrame;
import uytube.admin.listas.ModificarListaFrame;
import uytube.admin.listas.QuitarVideoListaInternalFrame;
import uytube.admin.usuarios.AltaUsuarioInternalFrame;
import uytube.admin.usuarios.ConsultaUsuarioInternalFrame;
import uytube.admin.usuarios.ListarUsuariosInternalFrame;
import uytube.admin.usuarios.modificarUsuario;
import uytube.admin.usuarios.verUsuariosEliminados;
import uytube.admin.videos.AltaVideo;
import uytube.admin.videos.ModificarVideo;
import uytube.admin.videos.ValorarVideo;
import uytube.admin.videos.consultar.ConsultarVideoInternalFrame;
import uytube.admin.videos.consultar.ListarCategoriasInternalFrame;
import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

public class adminPrincipal extends JFrame {

	private JPanel contentPane;

	private AltaUsuarioInternalFrame aUsrIFrame;
	private modificarUsuario modUsrIFrame;
	private ConsultaUsuarioInternalFrame conUsrIFrame;
	private ListarUsuariosInternalFrame listarUsrIFrame;
	private AgregarVideoListaInternalFrame addVideoListIFrame;
	private QuitarVideoListaInternalFrame quitarVideoListIFrame;
	private CrearListaInternalFrame crearListIFrame;
	private ConsultaCategoriaJInternalFrame consultacategoria;
	private AltaVideo altaVideoFrame;
	private ConsultarVideoInternalFrame consultarVideoFrame;
	private ModificarVideo modificarVideoFrame;
	private ValorarVideo valorarVideoFrame;
	private ConsultaListaInternalFrame consultaListaFrame;
	private ListarCategoriasInternalFrame listarCategoriasFrame;
	private ModificarListaFrame modificarListaFrame;
	private verUsuariosEliminados verUsrEliminadosFrame;
	private IUsuarioCtrl ICU;
	private IVideoCtrl ICV;

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
		Fabrica fabrica = Fabrica.getInstance();
		ICU = fabrica.getIUsuarioCtrl();
		ICV = fabrica.getIVideoCtrl();
		DatosDePrueba dP = new DatosDePrueba();
		dP.cargarDatosDePrueba();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aUsrIFrame = new AltaUsuarioInternalFrame(ICU, ICV);
				contentPane.setLayout(null);
				contentPane.add(aUsrIFrame);
				aUsrIFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAlta);

		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modUsrIFrame = new modificarUsuario(ICU);
				contentPane.setLayout(null);
				contentPane.add(modUsrIFrame);
				modUsrIFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmModificar);

		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conUsrIFrame = new ConsultaUsuarioInternalFrame(ICU);
				contentPane.setLayout(null);
				contentPane.add(conUsrIFrame);
				conUsrIFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmConsulta);

		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsrIFrame = new ListarUsuariosInternalFrame(ICU);
				contentPane.setLayout(null);
				contentPane.add(listarUsrIFrame);
				listarUsrIFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListar);

		JMenu mnVideos = new JMenu("Videos");
		menuBar.add(mnVideos);

		JMenuItem mntmAlta_1 = new JMenuItem("Alta");
		mntmAlta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaVideoFrame = new AltaVideo(ICU, ICV);
				contentPane.setLayout(null);
				contentPane.add(altaVideoFrame);
				altaVideoFrame.setVisible(true);
			}
		});
		mnVideos.add(mntmAlta_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarVideoFrame = new ModificarVideo(ICU, ICV);
				contentPane.setLayout(null);
				contentPane.add(modificarVideoFrame);
				modificarVideoFrame.setVisible(true);
			}
		});
		mnVideos.add(mntmNewMenuItem);

		JMenuItem mntmConsulta_1 = new JMenuItem("Consulta");
		mntmConsulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVideoFrame = new ConsultarVideoInternalFrame();
				contentPane.setLayout(null);
				contentPane.add(consultarVideoFrame);
				consultarVideoFrame.setVisible(true);
			}
		});
		mnVideos.add(mntmConsulta_1);

		JMenuItem mntmValorar = new JMenuItem("Valorar");
		mntmValorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorarVideoFrame = new ValorarVideo();
				contentPane.setLayout(null);
				contentPane.add(valorarVideoFrame);
				valorarVideoFrame.setVisible(true);
			}
		});
		mnVideos.add(mntmValorar);

		JMenu mnNewMenu_1 = new JMenu("Listas");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearListIFrame = new CrearListaInternalFrame(ICU);
				contentPane.setLayout(null);
				contentPane.add(crearListIFrame);
				crearListIFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmCrear);

		JMenuItem mntmAgregarVideo = new JMenuItem("Agregar Video");
		mntmAgregarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addVideoListIFrame = new AgregarVideoListaInternalFrame(ICU);
				contentPane.setLayout(null);
				contentPane.add(addVideoListIFrame);
				addVideoListIFrame.setVisible(true);
			}
		});
		
		JMenuItem mntmModificar_1 = new JMenuItem("Modificar");
		mntmModificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarListaFrame = new ModificarListaFrame(ICU, ICV);
				contentPane.setLayout(null);
				contentPane.add(modificarListaFrame);
				modificarListaFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmModificar_1);
		mnNewMenu_1.add(mntmAgregarVideo);

		JMenuItem mntmQuitarVideo = new JMenuItem("Quitar Video");
		mntmQuitarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarVideoListIFrame = new QuitarVideoListaInternalFrame(ICU);
				contentPane.setLayout(null);
				contentPane.add(quitarVideoListIFrame);
				quitarVideoListIFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmQuitarVideo);

		JMenuItem mntmConsulta_3 = new JMenuItem("Consulta");
		mntmConsulta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultaListaFrame = new ConsultaListaInternalFrame(ICU, ICV);
				contentPane.setLayout(null);
				contentPane.add(consultaListaFrame);
				consultaListaFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmConsulta_3);

		JMenu mnCategorias = new JMenu("Categorias");
		menuBar.add(mnCategorias);

		JMenuItem mntmAlta_2 = new JMenuItem("Alta");
		mntmAlta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaCategoria ac = new AltaCategoria(ICV);
				contentPane.setLayout(null);
				contentPane.add(ac);
				ac.setVisible(true);
			}
		});
		mnCategorias.add(mntmAlta_2);

		JMenuItem mntmConsulta_2 = new JMenuItem("Consulta");
		mntmConsulta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultacategoria = new ConsultaCategoriaJInternalFrame(ICV);
				contentPane.setLayout(null);
				contentPane.add(consultacategoria);
				consultacategoria.setVisible(true);
			}
		});
		mnCategorias.add(mntmConsulta_2);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarCategoriasFrame = new ListarCategoriasInternalFrame(ICV);
				contentPane.setLayout(null);
				contentPane.add(listarCategoriasFrame);
				listarCategoriasFrame.setVisible(true);

			}
		});
		mnCategorias.add(mntmListar_1);
		
		JMenu mnUsuariosEliminados = new JMenu("Usuarios Eliminados");
		mnUsuariosEliminados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verUsrEliminadosFrame = new verUsuariosEliminados();
				contentPane.setLayout(null);
				contentPane.add(verUsrEliminadosFrame);
				verUsrEliminadosFrame.setVisible(true);
			}
		});
		menuBar.add(mnUsuariosEliminados);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
