package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class modificarUsuario extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNomC;
	private JTextField textFieldNombreV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificarUsuario frame = new modificarUsuario();
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
	public modificarUsuario() {
		setBounds(100, 100, 450, 482);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panelDatosUsuario = new JPanel();
		panelDatosUsuario.setBorder(new TitledBorder(null, "Datos usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosUsuario = new GridBagConstraints();
		gbc_panelDatosUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_panelDatosUsuario.fill = GridBagConstraints.BOTH;
		gbc_panelDatosUsuario.gridx = 0;
		gbc_panelDatosUsuario.gridy = 0;
		getContentPane().add(panelDatosUsuario, gbc_panelDatosUsuario);
		panelDatosUsuario.setLayout(new GridLayout(9, 1, 2, 1));
		
		JLabel lblNickname = new JLabel("Nickname");
		panelDatosUsuario.add(lblNickname);
		
		JComboBox comboBox = new JComboBox();
		panelDatosUsuario.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email");
		panelDatosUsuario.add(lblEmail);
		
		JLabel lblNombre = new JLabel("Nombre");
		panelDatosUsuario.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		panelDatosUsuario.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		panelDatosUsuario.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		panelDatosUsuario.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblFechaNac = new JLabel("Fecha Nac.");
		panelDatosUsuario.add(lblFechaNac);
		
		JButton btnModificar = new JButton("Modificar");
		panelDatosUsuario.add(btnModificar);
		
		JPanel panelDatosCanal = new JPanel();
		panelDatosCanal.setBorder(new TitledBorder(null, "Datos canal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelDatosCanal = new GridBagConstraints();
		gbc_panelDatosCanal.insets = new Insets(0, 0, 5, 0);
		gbc_panelDatosCanal.fill = GridBagConstraints.BOTH;
		gbc_panelDatosCanal.gridx = 1;
		gbc_panelDatosCanal.gridy = 0;
		getContentPane().add(panelDatosCanal, gbc_panelDatosCanal);
		panelDatosCanal.setLayout(new GridLayout(10, 1, 0, 0));
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		panelDatosCanal.add(lblNombre_1);
		
		textFieldNomC = new JTextField();
		textFieldNomC.setEditable(false);
		panelDatosCanal.add(textFieldNomC);
		textFieldNomC.setColumns(10);
		
		JLabel lblDescripicin = new JLabel("Descripici\u00F3n");
		panelDatosCanal.add(lblDescripicin);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		panelDatosCanal.add(editorPane);
		
		JList list = new JList();
		list.setBorder(new TitledBorder(null, "Videos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelDatosCanal.add(list);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDatosCanal.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		panel.add(lblNombre_2);
		
		textFieldNombreV = new JTextField();
		panel.add(textFieldNombreV);
		textFieldNombreV.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel.add(lblCategoria);

	}

}
