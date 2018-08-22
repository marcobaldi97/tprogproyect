package uytube.admin.categoria.consulta;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.Panel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import uytube.logica.DtCategoria;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IVideoCtrl;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Listar por categorias");
		setBounds(100, 100, 473, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Video = new JPanel();
		JPanel panel = new JPanel();
		JPanel panel_LDR = new JPanel();
		
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		getContentPane().add(panel_LDR, BorderLayout.WEST);
		panel_LDR.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		getContentPane().add(panel_Video, BorderLayout.EAST);
		panel_Video.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSeleccioneUnaCategoria = new JLabel("Seleccione una categoria");
		panel.add(lblSeleccioneUnaCategoria);
		
		JLabel lblListas = new JLabel("Listas");
		panel_LDR.add(lblListas);
		
		JSeparator separator_1 = new JSeparator();
		panel_LDR.add(separator_1);
		
		JSeparator separator = new JSeparator();
		panel_Video.add(separator);
		
		JLabel lblVideos = new JLabel("Videos");
		panel_Video.add(lblVideos);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
	
		
		table_Video = new JTable(ModeloNombrePropietario());
		table_LDR = new JTable(ModeloNombrePropietario());
		
		panel_Video.add(table_Video);
		panel_LDR.add(table_LDR);
		
		
		DtCategoria[] set_cat=iCV.listarCategorias();
		for(int i=0; i<set_cat.length;i++) {comboBox.addItem(set_cat[i].getNombre());}
		comboBox.setSelectedIndex(-1);
		
		comboBox.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e) 
				{
					DefaultTableModel modelo_video= (DefaultTableModel) table_Video.getModel();
					DefaultTableModel modelo_ldr= (DefaultTableModel) table_LDR.getModel();
					
					modelo_video.getDataVector().removeAllElements();
					revalidate();
					modelo_ldr.getDataVector().removeAllElements();
					revalidate();
					
					modelo_video.addRow(new Object[]{"NOMBRE","PROPIETARIO"});
					modelo_ldr.addRow(new Object[]{"NOMBRE","PROPIETARIO"});
					
					DtVideo [] listarvideos= iCV.listarVideosPorCategoria(comboBox.getSelectedItem().toString());
					for(int i=0;i<listarvideos.length;i++) 
					{
						modelo_video.addRow(new Object[]{listarvideos[i].getNombre(),listarvideos[i].getPropietario()});
					}
					
					DtListaReproduccion [] listarLDR= iCV.listarLDRPorCategoria(comboBox.getSelectedItem().toString());
					for(int i=0; i<listarLDR.length;i++) 
					{
						modelo_ldr.addRow(new Object[] {listarLDR[i].getNombre(),listarLDR[i].getPropietario()});
					}
					


					
				//infoBox(comboBox.getSelectedItem().toString(),"");
				}
		});
		
			

		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
