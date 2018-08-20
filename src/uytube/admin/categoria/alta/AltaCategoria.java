package uytube.admin.categoria.alta;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class AltaCategoria extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaCategoria frame = new AltaCategoria(null);
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
	public AltaCategoria(IVideoCtrl iCV) {
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta Categoria");
		setMaximizable(true);	
		
		JLabel aviso = new JLabel("");
		aviso.setHorizontalAlignment(SwingConstants.CENTER);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 5, 5));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(iCV.existeCategoria(textField_1.getText()) == true) {
					aviso.setText("Categoria ya existente en el sistema.");
				}else {
					aviso.setText("");
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(iCV.existeCategoria(textField_1.getText()) == true) {
					aviso.setText("Categoria ya existente en el sistema.");
				}else {
					aviso.setText("");
				}
			}
		});
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iCV.existeCategoria(textField_1.getText()) == true) {
					aviso.setText("¡Categoria ya existente en el sistema.!");
				}else {
					iCV.crearCategoria(textField_1.getText());
					aviso.setText("Categoria creada con exito");
					textField_1.setText("");
				}
			}
		});
		panel_1.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel_1.add(btnCancelar);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_1, btnAceptar, btnCancelar, lblNombre}));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		

		panel.add(aviso);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_1, btnAceptar, btnCancelar, aviso, getContentPane(), panel_1, lblNombre, panel}));
		

	}

}
