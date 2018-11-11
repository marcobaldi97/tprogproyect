package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.util.Map;

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

public class verUsuariosEliminados extends JInternalFrame {
	private JTable tableCanal;
	private JTable tableUsuarios;
	private JTable tableDatosUsr;
	private JLabel lblDatosCanal;
	private JList listListas;
	private JList listVideos;
	private JLabel lblListas;

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
		getContentPane().setLayout(new GridLayout(0, 2, 2, 4));
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		getContentPane().add(lblUsuarios);
		
		
		tableUsuarios = new JTable(ModeloUsuario());
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tableUsuarios.getSelectedRow()>0){
					PersistenciaCtrl p = new PersistenciaCtrl();
					DefaultTableModel tm = (DefaultTableModel) tableUsuarios.getModel();
					Integer dato=Integer.valueOf((String) tm.getValueAt(tableUsuarios.getSelectedRow(),0));
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
					//cargar jlist
					Map<String, ListaReproduccion> userL = userC.getListasReproduccion();
					Map<String, Video> userV = userC.getVideos();
					
				}
			}
		});
		cargarUsuarios();
		getContentPane().add(tableUsuarios);
		
	
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		getContentPane().add(lblDatosUsuario);
		
		tableDatosUsr = new JTable(ModeloUsuarioDatos());
		getContentPane().add(tableDatosUsr);
		
		lblDatosCanal = new JLabel("Datos Canal");
		getContentPane().add(lblDatosCanal);
		
		tableCanal = new JTable();
		getContentPane().add(tableCanal);
		
		lblListas = new JLabel("Listas");
		getContentPane().add(lblListas);
		
		JLabel lblVideos = new JLabel("Videos");
		getContentPane().add(lblVideos);
		
		listListas = new JList();
		listListas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(listListas);
		
		listVideos = new JList();
		listVideos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getContentPane().add(listVideos);

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
}
