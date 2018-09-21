package uytube.admin.videos.consultar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarCategoriasInternalFrame extends JInternalFrame {
	private DefaultListModel<String> modelList = new DefaultListModel<>();
	private JList<String> list = new JList<>(modelList);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarCategoriasInternalFrame frame = new ListarCategoriasInternalFrame(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param iCV 
	 */
	public ListarCategoriasInternalFrame(IVideoCtrl iCV) {
		setTitle("Listar Categorias");
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCategorias);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		//cargo las categorias
		DtCategoria[] dt  = iCV.listarCategorias();
		for(int i = 0; i < dt.length; i++) {
			modelList.addElement(dt[i].getNombre());
		}//carga de la list.
		scrollPane.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel_2.add(btnCerrar);

	}

}
