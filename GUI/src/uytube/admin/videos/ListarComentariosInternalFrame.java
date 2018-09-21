package uytube.admin.videos;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uytubeLogic.logica.DtComentario;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarComentariosInternalFrame extends JInternalFrame {
	private JTextField textFieldNick;
	private JTextField textFieldVideo;
	private JPanel panel_1;
	//private JTree treeComentarios;

	 public static void infoBox(String infoMessage, String titleBar){
	        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	 }
	/**
	 * Create the frame.
	 * @param nomLista 
	 * @param nickU 
	 */
	public ListarComentariosInternalFrame(String nickU, String nomLista) {
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
		textFieldNick.setEditable(false);
		textFieldNick.setText(nickU);
		panel.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblVideo = new JLabel("Video");
		panel.add(lblVideo);
		
		textFieldVideo = new JTextField();
		textFieldVideo.setEditable(false);
		textFieldVideo.setText(nomLista);
		panel.add(textFieldVideo);
		textFieldVideo.setColumns(10);
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
	//	treeComentarios = new JTree();
	//	panel_1.add(treeComentarios);
		try{
			int idVideo = buscarIdVideo(nickU, nomLista);
			//temporalmente crae la fabrica, deberia recibirla por parametro
			Fabrica fabrica = Fabrica.getInstance();
		    IVideoCtrl ICV = fabrica.getIVideoCtrl();
		    DtComentario[] dtComentarios = ICV.listarComentarios(idVideo);
			
			cargarComentarios(dtComentarios);
		}catch (java.lang.NullPointerException e){
			infoBox("El usuario o video no existen, no hay nada que mostrar","Listar Comentarios");
		}
		
		

	}
	private void cargarComentarios(DtComentario[] coments){
		
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios");
		DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		JTree treeComentarios = new JTree(modelo);
		panel_1.add(treeComentarios);
		
		 for(int i=0; i<coments.length; i++){ 
			DefaultMutableTreeNode comentario = new DefaultMutableTreeNode(coments[i].getNickUsuario()+": "+coments[i].getTexto());
			modelo.insertNodeInto(comentario,raiz,i);
			cargarRespuesta(coments[i].getRespuestas(), comentario,raiz, modelo);
		}
		 
		for(int i=0; i<treeComentarios.getRowCount(); i++){
			treeComentarios.expandRow(i);
		}
		
	}
	
	private void cargarRespuesta(DtComentario[] dtRespuestas, DefaultMutableTreeNode comentarioPadre, DefaultMutableTreeNode raiz, DefaultTreeModel modelo){
		for(int i=0; i<dtRespuestas.length; i++){ 
			DefaultMutableTreeNode comentario = new DefaultMutableTreeNode(dtRespuestas[i].getNickUsuario()+": "+ dtRespuestas[i].getTexto());
			modelo.insertNodeInto(comentario,comentarioPadre,i);
			cargarRespuesta(dtRespuestas[i].getRespuestas(), comentario,comentarioPadre, modelo);
		}
	}

	private int buscarIdVideo(String nickU, String nomVideo){
		//verificar que los param recibidos sean correctos
		Fabrica fabrica = Fabrica.getInstance();
	    IUsuarioCtrl ICU = fabrica.getIUsuarioCtrl();
		DtVideo dtVideo = ICU.obtenerInfoAdicVideo(nickU,nomVideo);
		return dtVideo.getIDVideo();
	}

}
