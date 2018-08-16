package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class help extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help frame = new help();
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
	public help() {
		setBounds(100, 100, 254, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(9, 1, 8, 8));
		
		JLabel label = new JLabel("Nick");
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JLabel label_1 = new JLabel("Videos");
		panel.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1);
		
		JLabel label_2 = new JLabel("Listas de Reproduccion");
		panel.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2);
		
		JButton button = new JButton("Agregar");
		panel.add(button);

	}

}
