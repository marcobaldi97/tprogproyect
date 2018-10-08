package uytube.admin.categoria.alta;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import uytubeLogic.logica.IVideoCtrl;

public class AltaCategoria extends JInternalFrame {
	private JTextField textField_1;

	 public static void infoBox(String infoMessage, String titleBar){
	        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	 }
	/**
	 * Create the frame.
	 * @param iCV 
	 */
	public AltaCategoria(IVideoCtrl iCV) {
		setResizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Alta Categoria");
		setMaximizable(true);
		
		setBounds(100, 100, 326, 159);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_2.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_2.add(btnCancelar);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_1, btnAceptar, btnCancelar, lblNombre}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField_1, btnAceptar, btnCancelar, getContentPane(), panel_1, lblNombre}));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iCV.existeCategoria(textField_1.getText()) == true) {
					infoBox("Categoria ya existente en el sistema","Alta Categoria");
				}else if(textField_1.getText().isEmpty()) {
					infoBox("Categoria no valida", "Alta Categoria");
				}else{
					iCV.crearCategoria(textField_1.getText());
					infoBox("Categoria creada con exito","Alta Categoria");
					dispose();
				}
			}
		});
		

	}

}
