package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTree;

import uytube.logica.DtComentario;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarComentariosInternalFrame extends JInternalFrame {
	private JTextField textFieldNick;
	private JTextField textFieldVideo;
	private JLabel lblComentario;

	/**
	 * Create the frame.
	 */
	public ListarComentariosInternalFrame() {
		setTitle("Comentarios");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JLabel lblNick = new JLabel("Nick");
		panel.add(lblNick);
		
		textFieldNick = new JTextField();
		panel.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblVideo = new JLabel("Video");
		panel.add(lblVideo);
		
		textFieldVideo = new JTextField();
		panel.add(textFieldVideo);
		textFieldVideo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idVideo = buscarIdVideo(textFieldNick.getText(),textFieldVideo.getText());
				//temporalmente crae la fabrica, deberia recibirla por parametro
				//el nick y video deberia recibirlo por parametro
				Factory fabrica = Factory.getInstance();
			    IVideoCtrl ICV = fabrica.getIVideoCtrl();
				DtComentario[] dtComentarios = ICV.listarComentarios(idVideo);
				
				cargarComentarios(dtComentarios);
			}
		});
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		lblComentario = new JLabel("COMENTARIO");
		panel_1.add(lblComentario);
		
		JTree treeComentarios = new JTree();
		panel_1.add(treeComentarios);
		
		

	}
	private void cargarComentarios(DtComentario[] coments){
		lblComentario.setText(coments[0].getTexto());
		
	}
	
	private int buscarIdVideo(String nickU, String nomVideo){
		Factory fabrica = Factory.getInstance();
	    IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
		DtVideo dtVideo = ICU.obtenerInfoAdicVideo(nickU,nomVideo);
		return dtVideo.getIDVideo();
	}

}
