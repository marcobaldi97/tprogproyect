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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class ConsultaCategoriaJInternalFrame extends JInternalFrame {
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCategoriaJInternalFrame frame = new ConsultaCategoriaJInternalFrame();
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
	public ConsultaCategoriaJInternalFrame() {
		setTitle("Listar por categorias");
		setBounds(100, 100, 473, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblSeleccioneUnaCategoria = new JLabel("Seleccione una categoria");
		panel.add(lblSeleccioneUnaCategoria);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblListas = new JLabel("Listas");
		panel_1.add(lblListas);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.PINK);
		panel_1.add(separator_1);
		
		table = new JTable();
		panel_1.add(table);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblVideos = new JLabel("Videos");
		panel_2.add(lblVideos);
		
		JSeparator separator = new JSeparator();
		panel_2.add(separator);
		
		table_1 = new JTable();
		panel_2.add(table_1);

	}
}
