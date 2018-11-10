package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import uyTubePersistencia.PersistenciaCtrl;
import uyTubePersistencia.Usuario;
import uytubeLogic.logica.Puntuacion;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class verUsuariosEliminados extends JInternalFrame {
	private JTable tableCanal;
	private JTable tableUsuarios;
	private JTable tableDatosUsr;

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
	
	public verUsuariosEliminados() {
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		getContentPane().add(lblUsuarios);
		
		
		tableUsuarios = new JTable(ModeloUsuario());
		tableUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tableUsuarios.getSelectedRow()>0){
					//cargar datos de tableUsuariosDatos y la de canal
				}
			}
		});
		cargarUsuarios();
		getContentPane().add(tableUsuarios);
		
	
		
		JLabel lblDatosUsuario = new JLabel("Datos Usuario");
		getContentPane().add(lblDatosUsuario);
		
		tableDatosUsr = new JTable(ModeloUsuarioDatos());
		getContentPane().add(tableDatosUsr);
		
		tableCanal = new JTable();
		getContentPane().add(tableCanal);

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
