package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CrearListaInternalFrame extends JInternalFrame {
	private JTextField textFieldNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearListaInternalFrame frame = new CrearListaInternalFrame();
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
	public CrearListaInternalFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista de reproduccion");
		panel.add(lblTipoDeLista);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Defecto", "Particular"}));
		panel.add(comboBox);
		
		JPanel lista = new JPanel();
		getContentPane().add(lista, BorderLayout.CENTER);
		lista.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNick = new JLabel("Nick");
		lista.add(lblNick);
		
		JComboBox comboBox_1 = new JComboBox();
		lista.add(comboBox_1);
		
		JLabel lblNombre = new JLabel("Nombre lista");
		lista.add(lblNombre);
		
		textFieldNombre = new JTextField();
		lista.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		lista.add(btnCancelar);
		
		JButton btnCrear = new JButton("Crear");
		lista.add(btnCrear);

	}

}
