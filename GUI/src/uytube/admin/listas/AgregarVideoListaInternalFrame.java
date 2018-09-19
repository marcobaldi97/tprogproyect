
package uytube.admin.listas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import uytube.logica.DtCategoria;
import uytube.logica.DtVideo;
import uytube.logica.IUsuarioCtrl;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class AgregarVideoListaInternalFrame extends JInternalFrame {

	/**
	 * Create the frame.
	 * @param iCU 
	 */
	public static void infoBox(String infoMessage, String titleBar)
	{
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public AgregarVideoListaInternalFrame(IUsuarioCtrl iCU) 
	{
		setTitle("Agregar video a lista de reproduccion");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 192, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblAutor = new JLabel("Autor");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.WEST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 0);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 2;
		getContentPane().add(lblAutor, gbc_lblAutor);
		
		JComboBox comboBoxAutor = new JComboBox();
		GridBagConstraints gbc_comboBoxAutor = new GridBagConstraints();
		gbc_comboBoxAutor.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAutor.gridx = 0;
		gbc_comboBoxAutor.gridy = 3;
		getContentPane().add(comboBoxAutor, gbc_comboBoxAutor);
		
		JLabel lblVideos = new JLabel("Videos");
		lblVideos.setEnabled(false);
		GridBagConstraints gbc_lblVideos = new GridBagConstraints();
		gbc_lblVideos.anchor = GridBagConstraints.WEST;
		gbc_lblVideos.insets = new Insets(0, 0, 5, 0);
		gbc_lblVideos.gridx = 0;
		gbc_lblVideos.gridy = 4;
		getContentPane().add(lblVideos, gbc_lblVideos);
		
		JComboBox comboBoxVideos = new JComboBox();
		GridBagConstraints gbc_comboBoxVideos = new GridBagConstraints();
		gbc_comboBoxVideos.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxVideos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVideos.gridx = 0;
		gbc_comboBoxVideos.gridy = 5;
		getContentPane().add(comboBoxVideos, gbc_comboBoxVideos);
		
		JLabel lblUsuario = new JLabel("Usuario");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 7;
		getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		JComboBox comboBoxUsuario = new JComboBox();
		GridBagConstraints gbc_comboBoxUsuario = new GridBagConstraints();
		gbc_comboBoxUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxUsuario.gridx = 0;
		gbc_comboBoxUsuario.gridy = 8;
		getContentPane().add(comboBoxUsuario, gbc_comboBoxUsuario);
		
		JLabel lblListas = new JLabel("Listas");
		lblListas.setEnabled(false);
		GridBagConstraints gbc_lblListas = new GridBagConstraints();
		gbc_lblListas.anchor = GridBagConstraints.WEST;
		gbc_lblListas.insets = new Insets(0, 0, 5, 0);
		gbc_lblListas.gridx = 0;
		gbc_lblListas.gridy = 9;
		getContentPane().add(lblListas, gbc_lblListas);
		
		JComboBox comboBoxListas = new JComboBox();
		comboBoxListas.setEnabled(false);
		GridBagConstraints gbc_comboBoxListas = new GridBagConstraints();
		gbc_comboBoxListas.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxListas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListas.gridx = 0;
		gbc_comboBoxListas.gridy = 10;
		getContentPane().add(comboBoxListas, gbc_comboBoxListas);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAceptar.gridx = 0;
		gbc_btnAceptar.gridy = 11;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		
		String[] set_nicknames=iCU.listarNicknamesUsuarios();
		for(int i=0; i<set_nicknames.length;i++) {comboBoxAutor.addItem(set_nicknames[i]);comboBoxUsuario.addItem(set_nicknames[i]);}
		comboBoxAutor.setSelectedIndex(-1);
		comboBoxUsuario.setSelectedIndex(-1);

		
		comboBoxAutor.addActionListener(new ActionListener() //evento combobox AUTOR
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				String[] videos_canal=iCU.listarVideosCanal(comboBoxAutor.getSelectedItem().toString());
				comboBoxVideos.removeAllItems();
				
				if(videos_canal.length>0) 
				{
					lblVideos.setEnabled(true);
					comboBoxVideos.setEnabled(true);
					for(int i=0;i<videos_canal.length;i++) {comboBoxVideos.addItem(videos_canal[i]);}
					//comboBoxVideos.setSelectedIndex(-1);
					comboBoxVideos.setToolTipText("Videos de "+comboBoxAutor.getSelectedItem().toString());

				}
				else
				{
					lblVideos.setEnabled(false);
					comboBoxVideos.setEnabled(false);
					comboBoxVideos.setToolTipText("No hay videos de "+comboBoxAutor.getSelectedItem().toString());
				}
				btnAceptar.setEnabled(comboBoxListas.isEnabled()&&comboBoxVideos.isEnabled());
			}
		});
		
		comboBoxUsuario.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String[] listas_canal=iCU.listarLDRdeUsuario(comboBoxUsuario.getSelectedItem().toString());
				comboBoxListas.removeAllItems();
				
				if(listas_canal.length>0) 
				{
					lblListas.setEnabled(true);
					comboBoxListas.setEnabled(true);
					for(int i=0;i<listas_canal.length;i++) {comboBoxListas.addItem(listas_canal[i]);}
					//comboBoxVideos.setSelectedIndex(-1);
					comboBoxListas.setToolTipText("Listas de "+comboBoxUsuario.getSelectedItem().toString());

				}
				else
				{
					lblListas.setEnabled(false);
					comboBoxListas.setEnabled(false);
					comboBoxListas.setToolTipText("No hay listas de "+comboBoxUsuario.getSelectedItem().toString());
				}
				btnAceptar.setEnabled(comboBoxListas.isEnabled()&&comboBoxVideos.isEnabled());
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String nicknameAutor = (String) comboBoxAutor.getSelectedItem();
				String nicknameUsuario= (String)comboBoxUsuario.getSelectedItem();
				String nombreVideo =(String) comboBoxVideos.getSelectedItem();
				String nombreListaReproduccion = (String) comboBoxListas.getSelectedItem();
				DtVideo video = iCU.obtenerInfoAdicVideo(nicknameAutor, nombreVideo);
				int idVideo = video.getIDVideo();
				if(!iCU.memberVideoLista(nicknameUsuario,idVideo,nombreListaReproduccion)) 
				{
					iCU.agregarVideoLista(nicknameUsuario, idVideo, nombreListaReproduccion);
					infoBox("Video agregado correctamente","Agregar Video a Lista");
				}
				else
				{
					infoBox("El video ya esta agregado","Agregar Video a Lista");
				}
				dispose();
			}
		});
		

	}

}
