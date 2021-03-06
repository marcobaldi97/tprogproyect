package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import javax.swing.JButton;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;

import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

import javax.swing.event.ListSelectionEvent;


public class ValorarVideo extends JInternalFrame {
	
	private String nickUsuario;
	private String nickValorador;
	private String nomVideo=null;
	private Integer IDVideo=-1;
	private Boolean valoracion;
	private DefaultListModel<String> videoListModel = new DefaultListModel<String>();
	private final ButtonGroup MeGustaBtnGroup = new ButtonGroup();
	private JComboBox<String> comboBoxN2;
	
	private static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	Fabrica fabrica=Fabrica.getInstance();
	IUsuarioCtrl ICU=fabrica.getIUsuarioCtrl();
	IVideoCtrl VCU=fabrica.getIVideoCtrl();

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
		setTitle("Valorar Video");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 597, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel lblNickname = new JLabel("Nickname");
		panel_2.add(lblNickname);
		
		JComboBox<String> comboBoxNickname = new JComboBox<String>();
		
		panel_2.add(comboBoxNickname);
		
		
		//Cargar Nick
		String[] nickUsuarios = ICU.listarNicknamesUsuarios();
		
		for(int i=0; i<nickUsuarios.length;i++){
			 comboBoxNickname.addItem(nickUsuarios[i]);
	    }
		comboBoxNickname.setSelectedIndex(-1);
		
		
		JList<String> listVideos = new JList<>(videoListModel);
		listVideos.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()&&!listVideos.isSelectionEmpty()) {
					nomVideo=listVideos.getSelectedValue();
					DtVideo vid=ICU.obtenerInfoAdicVideo(nickUsuario, nomVideo);
					IDVideo=vid.getiDVideo();
					comboBoxN2.setEnabled(true);
				}
			}
		});
		panel.add(listVideos, BorderLayout.CENTER);
		 
		 
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
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnValorar = new JButton("Valorar");
		
		panel_5.add(btnValorar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		panel_5.add(btnCancelar);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_6.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		comboBoxN2 = new JComboBox<String>();
		comboBoxN2.setEnabled(false);
		comboBoxN2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxN2.getSelectedIndex()!=-1 && comboBoxNickname.getSelectedIndex()!=-1){
					String nickU = (String) comboBoxNickname.getSelectedItem();
					nickValorador=comboBoxNickname.getSelectedItem().toString();
				}
			}
		});
		panel_4.add(comboBoxN2);
		comboBoxN2.setSelectedIndex(-1);
		for(int i=0; i<nickUsuarios.length;i++){
			 comboBoxN2.addItem(nickUsuarios[i]);
	     }
		comboBoxN2.setSelectedIndex(-1);
		
		comboBoxNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxNickname.getSelectedIndex()!=-1){
					String nickU = (String) comboBoxNickname.getSelectedItem();
					limpiar();
					//pedir Dt
					nickUsuario=comboBoxNickname.getSelectedItem().toString();
					cargarVideos(nickUsuario);		
					
				}
			}
		});
		
		JLabel lblNickDelQue = new JLabel("Nick del que valora");
		panel_4.add(lblNickDelQue);
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7);
		
		JRadioButton rdbtnMeGusta = new JRadioButton("Me Gusta");
		rdbtnMeGusta.setSelected(true);
		MeGustaBtnGroup.add(rdbtnMeGusta);
		panel_7.add(rdbtnMeGusta);
		
		JRadioButton rdbtnNoMeGusta = new JRadioButton("No Me Gusta");
		MeGustaBtnGroup.add(rdbtnNoMeGusta);
		panel_7.add(rdbtnNoMeGusta);
		btnValorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMeGusta.isSelected())
					valoracion=true;
				else
					valoracion=false;
				if(IDVideo!=-1&&nickUsuario!=null&&nickValorador!=null&&comboBoxNickname.getSelectedIndex()!=-1&&comboBoxN2.getSelectedIndex()!=-1){
					VCU.valorarVideo(IDVideo, nickValorador, valoracion);
					
					infoBox("Se valor� con exito", "Valoracion exitosa");
					setVisible(false);
					dispose();
				}
			}
		});
	}
	private void limpiar(){
		videoListModel.clear();
		IDVideo=-1;
		nickUsuario=null;
		nickValorador=null;
		comboBoxN2.setEnabled(false);
		comboBoxN2.setSelectedIndex(-1);
	}
	private void cargarVideos(String nickU){
		String[] nomVideos=ICU.listarVideosCanal(nickU);
		for(String videoName:nomVideos){
			videoListModel.addElement(videoName);
		}
	}

}
