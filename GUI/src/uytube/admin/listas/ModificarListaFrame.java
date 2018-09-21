package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.Particular;
import uytubeLogic.logica.SystemHandler.Privacidad;

import java.awt.Component;

public class ModificarListaFrame extends JInternalFrame {
	private JComboBox comboBoxNicknames;
	private JComboBox comboBoxListas;
	private JRadioButton rdbtnPrivada;
	private JRadioButton rdbtnPublica;
	private JButton btnCancelar;
	private JButton btnModificar;
	private ButtonGroup group;
	
	private Boolean ready = false;
	private Boolean ready2 = false;
	
    private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarListaFrame frame = new ModificarListaFrame(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param iCU 
	 * @param iCV 
	 */
	public ModificarListaFrame(IUsuarioCtrl iCU, IVideoCtrl iCV) {
		setTitle("Modifcar Lista");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(4, 2, 4, 4));
		
		JLabel lblNickname = new JLabel("Nickname:");
		getContentPane().add(lblNickname);
		
		comboBoxNicknames = new JComboBox();
		comboBoxNicknames.setEditable(false);
		String[] nicknamesArray = iCU.listarNicknamesUsuarios();
		comboBoxNicknames.setModel(new DefaultComboBoxModel(nicknamesArray));
		comboBoxNicknames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nickname = (String) comboBoxNicknames.getSelectedItem();
				String[] nombresListas = iCU.listarLDRParticularesdeUsuario(nickname);
				comboBoxListas.setModel(new DefaultComboBoxModel(nombresListas));
				group.clearSelection();
				ready = true;
				ready2= false;
			}
		});
		getContentPane().add(comboBoxNicknames);
		
		JLabel lblListas = new JLabel("Listas:");
		getContentPane().add(lblListas);
		
		comboBoxListas = new JComboBox();
		comboBoxListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ready) {
					ready = true;
					if(!comboBoxListas.getSelectedItem().equals("") ) {
						String nickname = (String) comboBoxNicknames.getSelectedItem();
						String nombreLista = (String) comboBoxListas.getSelectedItem();
						DtListaReproduccion dtLista = iCU.infoAdicLDR(nickname, nombreLista);
						Privacidad privacidad = dtLista.getPrivado(); 
						if (privacidad == Privacidad.PRIVADO) {
							group.setSelected(rdbtnPrivada.getModel(),true);
						}else group.setSelected(rdbtnPublica.getModel(),true);
						ready2 = true;
					}else{
						ready = false;
					}
				}
			}
		});
		getContentPane().add(comboBoxListas);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		getContentPane().add(lblPrivacidad);
		
		JPanel panelPrivacidad = new JPanel();
		getContentPane().add(panelPrivacidad);
		panelPrivacidad.setLayout(new GridLayout(0, 2, 1, 0));
		
		group = new ButtonGroup();
		
		rdbtnPrivada = new JRadioButton("Privada");
		panelPrivacidad.add(rdbtnPrivada);
		
		rdbtnPublica = new JRadioButton("Publica");
		panelPrivacidad.add(rdbtnPublica);
		
	    group.add(rdbtnPrivada);
	    group.add(rdbtnPublica);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		getContentPane().add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ready){
					if(ready2) {
						String nickname = (String) comboBoxNicknames.getSelectedItem();
						String nombreLista = (String) comboBoxListas.getSelectedItem();
						Privacidad privacidad = Privacidad.PUBLICO;
						if(group.isSelected(rdbtnPrivada.getModel())) privacidad = Privacidad.PRIVADO;
						iCU.cambiarPrivLDR(nickname, nombreLista, privacidad);
						infoBox("Se ha modificado la lista de reproduccion.","¡Exito!");
						setVisible(false);
						dispose();
					}else infoBox("No se ha seleccionado una privacidad y/o lista","Error");
				}else infoBox("No se ha seleccionado nickname y/o la lista.","Error");
			}
		});
		getContentPane().add(btnModificar);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxNicknames, comboBoxListas, rdbtnPrivada, btnCancelar, btnModificar, rdbtnPublica, panelPrivacidad, lblPrivacidad, lblNickname, lblListas}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxNicknames, comboBoxListas, rdbtnPrivada, rdbtnPublica, btnCancelar, btnModificar, getContentPane(), lblNickname, lblListas, lblPrivacidad, panelPrivacidad}));

	}

}
