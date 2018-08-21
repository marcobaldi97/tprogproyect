package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JRadioButton;

public class ValorarVideo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValorarVideo frame = new ValorarVideo();
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
	public ValorarVideo() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNickname = new JLabel("Nickname");
		panel_2.add(lblNickname);
		
		JComboBox comboBox = new JComboBox();
		panel_2.add(comboBox);
		
		
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		JLabel lblIngreseValoracion = new JLabel("Ingrese Valoracion");
		panel_3.add(lblIngreseValoracion);
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnValorar = new JButton("Valorar");
		panel_5.add(btnValorar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_5.add(btnCancelar);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		
		JRadioButton rdbtnMeGusta = new JRadioButton("Me Gusta");
		panel_6.add(rdbtnMeGusta);
		
		JRadioButton rdbtnNoMeGusta = new JRadioButton("No Me Gusta");
		panel_6.add(rdbtnNoMeGusta);

	}

}
