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
import uytubeLogic.logica.Puntuacion;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class verUsuariosEliminados extends JInternalFrame {
	private JTable tableCanal;
	private JTable tableUsuarios;
	private JTable tableDatosUsr;
	private JLabel lblDatosCanal;
	private JLabel lblListas;
	private JTable tableListas;
	private JTable tableVideos;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

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
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
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
		
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
	
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		panel.add(lblDatosUsuario);
		
		tableDatosUsr = new JTable(ModeloUsuarioDatos());
		panel.add(tableDatosUsr);
		tableDatosUsr.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblDatosCanal = new JLabel("Datos Canal");
		panel_1.add(lblDatosCanal);
		
		tableCanal = new JTable(ModeloCanal());
		panel_1.add(tableCanal);
		tableCanal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblListas = new JLabel("Listas");
		getContentPane().add(lblListas);
		
		JLabel lblVideos = new JLabel("Videos");
		getContentPane().add(lblVideos);
		
		tableListas = new JTable(ModeloListas());
		tableListas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(tableListas);
		
		tableVideos = new JTable(ModeloVideos());
		tableVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(tableVideos);
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
			Canal userC = user.getCanalPropio();
			//limpiar tablas
			limpiarTabla(tableCanal);
			limpiarTabla(tableDatosUsr);
			//cargar tabla
			DefaultTableModel modeloTabla= (DefaultTableModel) tableDatosUsr.getModel();
			modeloTabla.setRowCount(0);
			modeloTabla.addRow(new Object[]{user.getNickname(),user.getEmail(),user.getNombre(),user.getApellido(),
					user.getFechaNacimiento()});
		
			DefaultTableModel modeloTablaCanal=(DefaultTableModel) tableCanal.getModel();
			modeloTablaCanal.setRowCount(0);
			modeloTablaCanal.addRow(new Object[]{userC.getIdCanal(),userC.getNombre(),userC.getDescripcion(),userC.getPrivacidadCanal()});
			//cargar listas y videos
			Map<String, ListaReproduccion> userL = userC.getListasReproduccion();
			Map<String, Video> userV = userC.getVideos();
			DefaultTableModel modeloListas= (DefaultTableModel) tableListas.getModel();
			modeloListas.setRowCount(0);
			DefaultTableModel modeloVideos= (DefaultTableModel) tableVideos.getModel();
			modeloVideos.setRowCount(0);
			for (Entry<String, ListaReproduccion> entry : userL.entrySet()) {
				modeloListas.addRow(new Object[]{entry.getValue().getIdListaRep(),entry.getValue().getNombre()});
				for (Entry<Integer, Video> entryV : entry.getValue().getVideos().entrySet()) {
					modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});
				}
			}
			for (Entry<String, Video> entryV : userV.entrySet()) {
				modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});			
			}
		}
	}
}
