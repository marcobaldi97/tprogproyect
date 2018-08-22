package uytube.admin;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uytube.logica.DtCategoria;
import uytube.logica.DtFecha;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
//import presentacion.CrearUsuario;
import uytube.logica.IVideoCtrl;

import javax.swing.JMenuBar;
import javax.swing.JMenu;

import uytube.admin.videos.VideosMenu;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import uytube.admin.usuarios.*;
import uytube.admin.listas.*;
import uytube.admin.categoria.alta.*;
import uytube.admin.categoria.consulta.*;
import uytube.admin.videos.alta.*;
import uytube.admin.videos.consultar.ConsultarVideoInternalFrame;
import uytube.admin.videos.*;

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
		Factory fabrica = Factory.getInstance();
	    ICU = fabrica.getIUsuarioCtrl();
	    ICV = fabrica.getIVideoCtrl();
	    //Datos de prueba
	    ICV.crearCategoria("deportes");
	    ICV.crearCategoria("Anime OwO");
	    ICV.crearCategoria("n.n");
	     
	    Date fecha1=new Date();
	    fecha1.setTime(666666666);

	    Date fecha2=new Date();
	    fecha2.setTime(777777777);
	     
	    Date fecha3=new Date();
	    fecha1.setTime(333333333);
	    
	    Date fecha4=new Date();
	    fecha1.setTime(454545);
	     
	    DtFecha fechaNacPepe= new DtFecha(fecha1);
	    DtFecha fechaVideo=new DtFecha(fecha2);
	    DtFecha fechaNacEmilio=new DtFecha(fecha3);
	    DtFecha fechaNacRoberto=new DtFecha(fecha4);
	    
	    Integer duracion=7315;
	    ICU.nuevoUsuario("pepeDeportes", "Jose", "Rodriguez", "elpepepatuconsumo@adinet.org", fechaNacPepe, "", "pepeDeportista777", "descripcion", false, "deportes");
	    ICU.nuevoUsuario("RobertoDeportista", "Roberto", "Perez", "robertitocampeon@yahoo.es", fechaNacRoberto, "", "xXrobertoCampeonXx", "mejor descripcion", false, "deportes");
	    ICU.nuevoUsuario("BokuNoNaruto", "Emilio", "Tilio", "megustaelanime@hotmail.com", fechaNacEmilio, "", "AnimeParaTodos", "descripcion otaku", false, "Anime OwO");
	    DtCategoria[]cates=ICV.listarCategorias();
	    ICU.aniadirVideo("pepeDeportes", "hago flexiones por dos horas", "segui mi patreon", duracion, fechaVideo, "www.cosopum", cates[0], false);
	    ICV.valorarVideo(1, "RobertoDeportista", false);
	    //fin datos de prueba
	    

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Usuario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        aUsrIFrame = new AltaUsuarioInternalFrame(ICU,ICV);
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
				 altaVideoFrame = new AltaVideo(ICU,ICV);
			     contentPane.setLayout(null);
			     contentPane.add(altaVideoFrame);
			     altaVideoFrame.setVisible(true);
			}
		});
		mnVideos.add(mntmAlta_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Modificar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarVideoFrame = new ModificarVideo(ICU,ICV);
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
				 addVideoListIFrame = new AgregarVideoListaInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(addVideoListIFrame);
			     addVideoListIFrame.setVisible(true);	
			}
		});
		mnNewMenu_1.add(mntmAgregarVideo);
		
		JMenuItem mntmQuitarVideo = new JMenuItem("Quitar Video");
		mntmQuitarVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 quitarVideoListIFrame = new QuitarVideoListaInternalFrame();
			     contentPane.setLayout(null);
			     contentPane.add(quitarVideoListIFrame);
			     quitarVideoListIFrame.setVisible(true);	
			}
		});
		mnNewMenu_1.add(mntmQuitarVideo);
		
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}

