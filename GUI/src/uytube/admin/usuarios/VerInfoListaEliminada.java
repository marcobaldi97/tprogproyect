package uytube.admin.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uyTubePersistencia.ListaReproduccion;
import uyTubePersistencia.Video;

import javax.swing.JButton;

public class VerInfoListaEliminada extends JInternalFrame {
	private JTable tableDatosLista;
	private JTable tableVideos;

	
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
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
		panel_1.add(btnVerInfoVideo);
		
		tableVideos = new JTable(ModeloVideos());
		panel_1.add(tableVideos);
		
		cargarDatos(lista);

	}
	
	public void cargarDatos(ListaReproduccion lista){
		DefaultTableModel modeloDatosLista= (DefaultTableModel) tableDatosLista.getModel();
		modeloDatosLista.addRow(new Object[]{lista.getIdListaRep(),lista.getNombre(),lista.getTipo(), lista.getPrivado()});
		DefaultTableModel modeloVideos= (DefaultTableModel) tableVideos.getModel();
		for (Entry<Integer, Video> entryV : lista.getVideos().entrySet()) {
			modeloVideos.addRow(new Object[]{entryV.getValue().getIdVideo(),entryV.getValue().getNombre()});
		}
	}

}
