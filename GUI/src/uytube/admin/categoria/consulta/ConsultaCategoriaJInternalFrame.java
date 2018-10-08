package uytube.admin.categoria.consulta;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.IVideoCtrl;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ConsultaCategoriaJInternalFrame extends JInternalFrame {
	private JTable table_LDR;
	private JTable table_Video;

	/**
	 * Launch the application. COMENTADO FUNCIONA IGUAL
	 */
	/*public static void main(String[] args) {
		Factory fabrica = Factory.getInstance();
	    
	    IVideoCtrl ICV = fabrica.getIVideoCtrl();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCategoriaJInternalFrame frame = new ConsultaCategoriaJInternalFrame(ICV);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @param iCV 
	 */
	
	public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	DefaultTableModel ModeloNombrePropietario() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("Nombre"); 
		model.addColumn("Propietario");
		return model;
	};
	
	public ConsultaCategoriaJInternalFrame(IVideoCtrl iCV) {
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Listar por categorias");
		setBounds(100, 100, 550, 400);
		
		JPanel panel_Video = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel_LDR = new JPanel();
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 5, 5));
		
		getContentPane().add(panel_LDR);
		
		getContentPane().add(panel_Video);
		
		JLabel lblSeleccioneUnaCategoria = new JLabel("Seleccione una categoria");
		panel.add(lblSeleccioneUnaCategoria);
		panel_LDR.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblListas = new JLabel("Listas");
		panel_LDR.add(lblListas);
		panel_Video.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblVideos = new JLabel("Videos");
		panel_Video.add(lblVideos);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JScrollPane scrollPaneVideos = new JScrollPane();
		panel_Video.add(scrollPaneVideos);
		table_Video = new JTable(ModeloNombrePropietario());
		scrollPaneVideos.setViewportView(table_Video);
		
		JScrollPane scrollPaneLDR = new JScrollPane();
		panel_LDR.add(scrollPaneLDR);
		
		table_LDR = new JTable(ModeloNombrePropietario());
		scrollPaneLDR.setViewportView(table_LDR);
		
		
		DtCategoria[] set_cat=iCV.listarCategorias();
		for(int i=0; i<set_cat.length;i++) {comboBox.addItem(set_cat[i].getNombre());}
		comboBox.setSelectedIndex(-1);
		
		JSeparator separator = new JSeparator();
		panel.add(separator);
		
		comboBox.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e) 
				{
					DefaultTableModel modelo_video= (DefaultTableModel) table_Video.getModel();
					DefaultTableModel modelo_ldr= (DefaultTableModel) table_LDR.getModel();
					
					modelo_video.setRowCount(0);
					modelo_ldr.setRowCount(0);

					DtVideo [] listarvideos= iCV.listarVideosPorCategoria(comboBox.getSelectedItem().toString());
					DtListaReproduccion [] listarLDR= iCV.listarLDRPorCategoria(comboBox.getSelectedItem().toString());
					
					if(listarvideos.length>0) 
					{
						
						for(int i=0;i<listarvideos.length;i++) 
						{
							modelo_video.addRow(new Object[]{listarvideos[i].getNombre(),listarvideos[i].getPropietario()});
						}
					}
					else
					{
						modelo_video.addRow(new Object[]{"NO HAY","VIDEOS"});

					}	
					
					if(listarLDR.length>0) 
					{
						
						for(int i=0; i<listarLDR.length;i++) 
						{
							modelo_ldr.addRow(new Object[] {listarLDR[i].getNombre(),listarLDR[i].getPropietario()});
						}
					}
					else
					{
						modelo_ldr.addRow(new Object[]{"NO HAY","LISTAS"});

					}	

				
				}
		});
		
			

		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
