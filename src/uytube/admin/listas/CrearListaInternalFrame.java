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

import uytube.logica.IUsuarioCtrl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CrearListaInternalFrame extends JInternalFrame {
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private IUsuarioCtrl controlUsr;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Create the frame.
	 * @param iCU 
	 */
	public CrearListaInternalFrame(IUsuarioCtrl iCU) {
		controlUsr = iCU;
		setTitle("Crear Lista");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 304, 198);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblTipoDeLista = new JLabel("Tipo de lista ");
		panel.add(lblTipoDeLista);
		
		JPanel lista = new JPanel();
		getContentPane().add(lista, BorderLayout.CENTER);
		lista.setLayout(new GridLayout(0, 3, 8, 10));
		
		JLabel lblNick = new JLabel("Nick");
		lista.add(lblNick);
		
		
		JComboBox comboBoxNick = new JComboBox();
		lista.add(comboBoxNick);
		String[] nickUsuario = controlUsr.listarNicknamesUsuarios();
		comboBoxNick.addItem(" ");
		 for(int i=0; i<nickUsuario.length;i++){
			 comboBoxNick.addItem(nickUsuario[i]);
		 }
		comboBoxNick.setVisible(false);
		lblNick.setVisible(false);
	
		
		JLabel label = new JLabel("");
		lista.add(label);
		
		JLabel lblNombreLista = new JLabel("Nombre lista");
		lista.add(lblNombreLista);
		
	
		textFieldNombre = new JTextField();
		lista.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
	
		
		JLabel label_1 = new JLabel("");
		lista.add(label_1);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		lista.add(lblPrivacidad);
		
		JRadioButton rdbtnPrivada = new JRadioButton("Privada");
		rdbtnPrivada.setSelected(true);
		buttonGroup_1.add(rdbtnPrivada);
		lista.add(rdbtnPrivada);
		
		JRadioButton rdbtnPublica = new JRadioButton("Publica");
		buttonGroup_1.add(rdbtnPublica);
		lista.add(rdbtnPublica);
		
		JRadioButton rdbtnPorDefecto = new JRadioButton("Por defecto");
		rdbtnPorDefecto.setSelected(true);
		rdbtnPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxNick.setVisible(false);
				lblNick.setVisible(false);	
				lblPrivacidad.setVisible(false);
				rdbtnPrivada.setVisible(false);
				rdbtnPublica.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnPorDefecto);
		panel.add(rdbtnPorDefecto);
		
		JRadioButton rdbtnParticular = new JRadioButton("Particular");
		rdbtnParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxNick.setVisible(true);
				lblNick.setVisible(true);
				lblPrivacidad.setVisible(true);
				rdbtnPrivada.setVisible(true);
				rdbtnPublica.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnParticular);
		panel.add(rdbtnParticular);
		
		lblPrivacidad.setVisible(false);
		rdbtnPrivada.setVisible(false);
		rdbtnPublica.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		lista.add(btnCancelar);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreLista = textFieldNombre.getText();
				String nickU = (String) comboBoxNick.getSelectedItem();
				boolean priv=true;
				//verificar si los datos ingresados estanb bien
				if(rdbtnPorDefecto.isSelected()){
					controlUsr.nuevaListaPorDefecto(nombreLista) ;
				}else{
					if(rdbtnPublica.isSelected()){priv = false;}
					controlUsr.nuevaListaParticular(nickU, nombreLista, priv) ;
				}
				//mensaje de que se creo
			}
		});
		
		JLabel label_2 = new JLabel("");
		lista.add(label_2);
		lista.add(btnCrear);
	}

}
