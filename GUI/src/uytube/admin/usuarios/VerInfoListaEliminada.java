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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerInfoListaEliminada extends JInternalFrame {
	private JTable tableDatosLista;
	private JTable tableVideos;
	private Map<Integer, Video> userV;
	
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
		
		JLabel lblDatosLista = new JLabel("Datos Lista");
		panel.add(lblDatosLista);
		
		tableDatosLista = new JTable(ModeloLista());
		panel.add(tableDatosLista);
		
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
					VerInfoVideoEliminado videoIFrame = new VerInfoVideoEliminado(videoE);
					adminPrincipal.getFrames()[0].setLayout(null);
					adminPrincipal.getFrames()[0].add(videoIFrame);
					videoIFrame.show();
				}
			}
		});
		
		tableVideos = new JTable(ModeloVideos());
		panel_1.add(tableVideos);
		panel_1.add(btnVerInfoVideo);
		
		cargarDatos(lista);

	}
	
	public void cargarDatos(ListaReproduccion lista){
		DefaultTableModel modeloDatosLista= (DefaultTableModel) tableDatosLista.getModel();
		modeloDatosLista.addRow(new Object[]{lista.getIdListaRep(),lista.getNombre(),lista.getTipo(), lista.getPrivado()});
		DefaultTableModel modeloVideos= (DefaultTableModel) tableVideos.getModel();
		userV = lista.getVideos();
		for (Entry<Integer, Video> entryV : userV.entrySet()) {
			modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});
		}
	}

}
