package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import uyTubePersistencia.Canal;
import uyTubePersistencia.ListaReproduccion;
import uyTubePersistencia.PersistenciaCtrl;
import uyTubePersistencia.Usuario;
import uyTubePersistencia.Video;
import uytube.admin.adminPrincipal;
import uytube.admin.listas.ConsultaListaInternalFrame;
import uytubeLogic.logica.Puntuacion;
import uytubeLogic.logica.SystemHandler.Privacidad;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class verUsuariosEliminados extends JInternalFrame {
	private JTable tableUsuarios;
	private JTable tableDatosUsr;
	private JLabel lblListas;
	private JTable tableListas;
	private JTable tableVideos;
	private JPanel panel;
	private JPanel panel_2;
	private JButton btnVerInfoLista;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnVerInfoVideo;
	private Map<String, ListaReproduccion> userL;
	private Map<String, Video> userV;
	private JPanel panel_5;
	private JLabel label_8;
	private JTextField textFieldNombreC;
	private JLabel label_9;
	private JTextField textFieldPrivacidad;
	private JLabel label_10;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JTextField textFieldNombre;
	private JLabel label_11;
	private JTextField textFieldApellido;
	private JLabel label_12;
	private JTextField textFieldNick;
	private JTextField textFieldEmail;
	private JTextField textFieldFechanac;
	private JLabel lblId;
	private JTextField textFieldIdCanal;
	private JTextPane textPane;
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
	 public void limpiarTabla(JTable tabla){
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount()-1;
        for (int i = a; i>= 0; i--) {          
        	tb.removeRow(tb.getRowCount()-1);
        }
    }
	DefaultTableModel ModeloUsuario() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID"); 
		model.addColumn("Nick");
		return model;
	};
	DefaultTableModel ModeloListas() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID"); 
		model.addColumn("Nombre");
		return model;
	};
	DefaultTableModel ModeloVideos() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID"); 
		model.addColumn("Nombre");
		return model;
	};
	DefaultTableModel ModeloUsuarioDatos() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("Nick"); 
		model.addColumn("Email");
		model.addColumn("Nombre");
		model.addColumn("APellido");
		model.addColumn("Fecha Nacimiento");
		return model;
	};
	DefaultTableModel ModeloCanal()
	{
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nombre");
		model.addColumn("Descripcion");
		model.addColumn("Privacidad");
		return model;
	};
	
	public verUsuariosEliminados() {
		setTitle("Usuarios Eliminados");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 529, 640);
		getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
		
		panel_2 = new JPanel();
		getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		panel_2.add(lblUsuarios);
		
		
		tableUsuarios = new JTable(ModeloUsuario());
		panel_2.add(tableUsuarios);
		tableUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cargarDatosUsuario();
				
			}
		});
		tableUsuarios.setAutoscrolls(true);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 2, 1));
		
		label_5 = new JLabel("Nickname");
		panel_1.add(label_5);
		
		textFieldNick = new JTextField();
		textFieldNick.setEditable(false);
		textFieldNick.setColumns(10);
		panel_1.add(textFieldNick);
		
		label_6 = new JLabel("Email");
		panel_1.add(label_6);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setText("");
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		panel_1.add(textFieldEmail);
		
		label_7 = new JLabel("Nombre");
		panel_1.add(label_7);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText("");
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		panel_1.add(textFieldNombre);
		
		label_11 = new JLabel("Apellido");
		panel_1.add(label_11);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setText("");
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		panel_1.add(textFieldApellido);
		
		label_12 = new JLabel("Fecha Nac.");
		panel_1.add(label_12);
		
		textFieldFechanac = new JTextField();
		textFieldFechanac.setEditable(false);
		panel_1.add(textFieldFechanac);
		textFieldFechanac.setColumns(10);
		
	//	scrollPane_1 = new JScrollPane(tableUsuarios);
		//scrollPane_1.setBounds(10,60,780,500);
	//	panel_2.add(scrollPane_1);
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 5, 5));
		
	
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		panel.add(lblDatosUsuario);
		
		tableDatosUsr = new JTable(ModeloUsuarioDatos());
		panel.add(tableDatosUsr);
		tableDatosUsr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 2, 5));
		
		lblId = new JLabel("ID");
		panel_5.add(lblId);
		
		textFieldIdCanal = new JTextField();
		textFieldIdCanal.setEditable(false);
		panel_5.add(textFieldIdCanal);
		textFieldIdCanal.setColumns(10);
		
		label_8 = new JLabel("Nombre");
		panel_5.add(label_8);
		
		textFieldNombreC = new JTextField();
		textFieldNombreC.setText("");
		textFieldNombreC.setEditable(false);
		textFieldNombreC.setColumns(10);
		panel_5.add(textFieldNombreC);
		
		label_9 = new JLabel("Privacidad");
		panel_5.add(label_9);
		
		textFieldPrivacidad = new JTextField();
		textFieldPrivacidad.setText((String) null);
		textFieldPrivacidad.setEditable(false);
		textFieldPrivacidad.setColumns(10);
		panel_5.add(textFieldPrivacidad);
		
		label_10 = new JLabel("Descripición");
		panel_5.add(label_10);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_5.add(scrollPane);
		
		textPane = new JTextPane();
		textPane.setText("");
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		panel_3 = new JPanel();
		getContentPane().add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblListas = new JLabel("Listas");
		panel_3.add(lblListas);
		
		tableListas = new JTable(ModeloListas());
		panel_3.add(tableListas);
		tableListas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnVerInfoLista = new JButton("Ver Info Lista");
		btnVerInfoLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableListas.getSelectedRow()>=0){
					DefaultTableModel tm = (DefaultTableModel) tableListas.getModel();
					String idLista= (String) tm.getValueAt(tableListas.getSelectedRow(),1);
					ListaReproduccion listaR = userL.get(idLista);
					VerInfoListaEliminada listaIFrame = new VerInfoListaEliminada(listaR);
					adminPrincipal.getFrames()[0].setLayout(null);
					adminPrincipal.getFrames()[0].add(listaIFrame);
					listaIFrame.show();
				}
			}
		});
		panel_3.add(btnVerInfoLista);
		
		panel_4 = new JPanel();
		getContentPane().add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblVideos = new JLabel("Videos");
		panel_4.add(lblVideos);
		
		tableVideos = new JTable(ModeloVideos());
		panel_4.add(tableVideos);
		tableVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnVerInfoVideo = new JButton("Ver Info Video");
		btnVerInfoVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableVideos.getSelectedRow()>=0){
					DefaultTableModel tm = (DefaultTableModel) tableVideos.getModel();
					String idVideo= (String) tm.getValueAt(tableVideos.getSelectedRow(),1);
					Video videoE = userV.get(idVideo);
					
				//	VerInfoVideoEliminado videoIFrame = new VerInfoVideoEliminado(videoE);
				//	adminPrincipal.getFrames()[0].setLayout(null);
				//	adminPrincipal.getFrames()[0].add(videoIFrame);
				//	videoIFrame.show();
				}
			}
		});
		panel_4.add(btnVerInfoVideo);
		cargarUsuarios();

	}
	public void cargarUsuarios(){
		PersistenciaCtrl p = new PersistenciaCtrl();
		Map<Integer, String> usrPersistidos= p.listarUsuariosPersistidos();
		DefaultTableModel modelo_usuarios= (DefaultTableModel) tableUsuarios.getModel();
		modelo_usuarios.setRowCount(0);
		if(!usrPersistidos.isEmpty()){			
			for(Map.Entry<Integer,String> entry : usrPersistidos.entrySet()){
				modelo_usuarios.addRow(new Object[]{entry.getKey(),entry.getValue()});
			}
		}else{
			modelo_usuarios.addRow(new Object[]{0,"No hay usuarios"});
		}
	}
	public void cargarDatosUsuario(){
		System.out.println("Quiero mostrar datos user");
		if(tableUsuarios.getSelectedRow()>=0){
			PersistenciaCtrl p = new PersistenciaCtrl();
			
			DefaultTableModel tm = (DefaultTableModel) tableUsuarios.getModel();
			Integer dato= (Integer) tm.getValueAt(tableUsuarios.getSelectedRow(),0);
			
			Usuario user = p.getInfoUsuario(dato);
			if(user!= null){
				Canal userC = user.getCanalPropio();
			
				//cargar datos usr
				textFieldApellido.setText(user.getApellido());
				textFieldEmail.setText(user.getEmail());
				textFieldFechanac.setText(user.getFechaNacimiento());
				textFieldNick.setText(user.getNickname());
				textFieldNombre.setText(user.getNombre());
				
				//cargar datos canal
				textFieldNombreC.setText(userC.getNombre());
				textFieldIdCanal.setText(Integer.toString(userC.getIdCanal()));
				if(userC.getPrivacidadCanal() == Privacidad.PRIVADO){
					textFieldPrivacidad.setText("Privado");
				}else{
					textFieldPrivacidad.setText("Publico");
				}
				textPane.setText(userC.getDescripcion());
			
				//cargar listas y videos
				userL = userC.getListasReproduccion();
				userV = userC.getVideos();
				DefaultTableModel modeloListas= (DefaultTableModel) tableListas.getModel();
				modeloListas.setRowCount(0);
				DefaultTableModel modeloVideos= (DefaultTableModel) tableVideos.getModel();
				modeloVideos.setRowCount(0);
				for (Entry<String, ListaReproduccion> entry : userL.entrySet()) {
					modeloListas.addRow(new Object[]{entry.getValue().getIdListaRep(),entry.getValue().getNombre()});
				/*	for (Entry<Integer, Video> entryV : entry.getValue().getVideos().entrySet()) {
						modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});
					}*/
				}
				for (Entry<String, Video> entryV : userV.entrySet()) {
					modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});			
				}
			}
		}
	}
}
