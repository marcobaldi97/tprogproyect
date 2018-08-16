package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import uytube.logica.IUsuarioCtrl;

import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ListarUsuariosInternalFrame extends JInternalFrame {
	/**
	 * Create the frame.
	 * @param iCU 
	 */
	private IUsuarioCtrl controlUsr;
	
	public ListarUsuariosInternalFrame(IUsuarioCtrl iCU) {
		controlUsr = iCU;
		
		setClosable(true);
		setMaximizable(true);
		setTitle("Listar Usuarios");
		setResizable(true);
		setBounds(100, 100, 286, 292);
		
		JList listUsuarios = new JList();
		listUsuarios.setBorder(new EmptyBorder(0, 0, 0, 0));
		listUsuarios.setToolTipText("Usuarios");
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//CARGAR USUARIOS
		String[] usr = controlUsr.listarNicknamesUsuarios();
		
		DefaultListModel model=new DefaultListModel();
	    listUsuarios.setModel(model);
	  
	    for(int i=0; i<usr.length;i++){
	    	  model.addElement(usr[i]);
	     }
	    
		getContentPane().add(listUsuarios, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		panel.add(lblUsuarios);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.EAST);
		

	}

}
