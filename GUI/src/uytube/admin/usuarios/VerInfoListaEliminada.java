package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uyTubePersistencia.ListaReproduccion;
import uyTubePersistencia.Video;
import uytube.admin.adminPrincipal;
import uytubeLogic.logica.ListaReproduccion.TipoLista;
import uytubeLogic.logica.SystemHandler.Privacidad;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VerInfoListaEliminada extends JInternalFrame {
	private JTable tableVideos;
	private Map<Integer, Video> userV;
	private JTextField textFieldNombre;
	private JTextField textFieldTipo;
	private JTextField textFieldprivacidad;
	private JTextField textFieldId;
	
	DefaultTableModel ModeloLista() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID"); 
		model.addColumn("Nombre");
		model.addColumn("Tipo de Lista");
		model.addColumn("Privacidad");
		return model;
	};
	DefaultTableModel ModeloVideos() 
	{
		DefaultTableModel model = new DefaultTableModel(); 
		model.addColumn("ID"); 
		model.addColumn("Nombre");
		return model;
	};
	/**
	 * Create the frame.
	 */
	public VerInfoListaEliminada(ListaReproduccion lista) {
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 5, 5));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblDatosLista = new JLabel("Datos Lista");
		panel.add(lblDatosLista);
		
		JLabel Id = new JLabel("Id:");
		panel.add(Id);
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		panel.add(textFieldId);
		
		JLabel label = new JLabel("Nombre:");
		panel.add(label);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		panel.add(textFieldNombre);
		
		JLabel lblTipo = new JLabel("Tipo:");
		panel.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setEditable(false);
		panel.add(textFieldTipo);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		panel.add(lblPrivacidad);
		
		textFieldprivacidad = new JTextField();
		textFieldprivacidad.setEditable(false);
		panel.add(textFieldprivacidad);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel lblVideosDeLa = new JLabel("Videos de la Lista");
		panel_1.add(lblVideosDeLa);
		
		JButton btnVerInfoVideo = new JButton("Ver Info Video");
		btnVerInfoVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tableVideos.getSelectedRow()>=0){
					DefaultTableModel tm = (DefaultTableModel) tableVideos.getModel();
					Integer idVideo= (Integer) tm.getValueAt(tableVideos.getSelectedRow(),0);
					Video videoE = userV.get(idVideo);
				//	VerInfoVideoEliminado videoIFrame = new VerInfoVideoEliminado(videoE);
				//	adminPrincipal.getFrames()[0].setLayout(null);
				//	adminPrincipal.getFrames()[0].add(videoIFrame);
				//	videoIFrame.show();
				}
			}
		});
		
		tableVideos = new JTable(ModeloVideos());
		panel_1.add(tableVideos);
		panel_1.add(btnVerInfoVideo);
		
		cargarDatos(lista);

	}
	
	public void cargarDatos(ListaReproduccion lista){

		textFieldId.setText(Integer.toString(lista.getIdListaRep()));
		textFieldNombre.setText(lista.getNombre());
		if(lista.getTipo() == TipoLista.PARTICULAR){
			textFieldTipo.setText("Particular");
		}else{
			textFieldTipo.setText("Por defecto");
		}
		if(lista.getPrivado() == Privacidad.PRIVADO){
			textFieldprivacidad.setText("Privado");
		}else{
			textFieldprivacidad.setText("Publico");
		}
		
		
		DefaultTableModel modeloVideos= (DefaultTableModel) tableVideos.getModel();
		userV = lista.getVideos();
		for (Entry<Integer, Video> entryV : userV.entrySet()) {
			modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});
		}
	}

}
