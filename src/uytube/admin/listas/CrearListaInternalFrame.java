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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("Crear Lista");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 304, 263);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista de reproduccion");
		panel.add(lblTipoDeLista);
		
		JPanel lista = new JPanel();
		getContentPane().add(lista, BorderLayout.CENTER);
		lista.setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblNick = new JLabel("Nick");
		lista.add(lblNick);
		
		
		JComboBox comboBoxNick = new JComboBox();
		lista.add(comboBoxNick);
		
		comboBoxNick.setVisible(false);
		lblNick.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( comboBox.getSelectedItem()=="Particular"){
					comboBoxNick.setVisible(true);
					lblNick.setVisible(true);
				}else {
					comboBoxNick.setVisible(false);
					lblNick.setVisible(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Defecto", "Particular"}));
		panel.add(comboBox);
		
		JLabel lblNombreLista = new JLabel("Nombre lista");
		lista.add(lblNombreLista);
		
		

		
		
		
		textFieldNombre = new JTextField();
		lista.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		lista.add(btnCancelar);
		
		JButton btnCrear = new JButton("Crear");
		lista.add(btnCrear);

	}

}
