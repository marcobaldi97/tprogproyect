package uytube.datosPrueba;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import uytube.admin.adminPrincipal;

public class Imagen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

		public static File elegirImagen(){
			File archivo = null;
			JFileChooser fileChooser = new JFileChooser();
			if(fileChooser.showOpenDialog(adminPrincipal.getFrames()[0]) == JFileChooser.APPROVE_OPTION){
				archivo = fileChooser.getSelectedFile();
			}
			return archivo;
		}
		//convertir una imagen a byte[]
		public static byte[] imagenToByte(File archivo){
			 //imagen a byte[]
			try{
				byte[] imgFoto = new byte[(int) archivo.length()]; 
				InputStream inte = new FileInputStream(archivo);
				inte.read(imgFoto);
				return imgFoto;
			}catch(Exception e){
				System.out.println(e.getMessage());}
			return null;
		}
		public static BufferedImage byteToImagen(byte[] imgFoto){
			//pasar byte[] a foto
	        BufferedImage image = null;
	        InputStream in = new ByteArrayInputStream(imgFoto);
	        
	        try {
				image = ImageIO.read(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return image;
			
		}
	/*COMO MOSTRAR FOTO 
	 	public void mostrarImagen(BufferedImage image){
	 		//muestrar foto
	    	ImageIcon icono = new ImageIcon(image);
	    	lblFoto.setIcon(icono);
	    	lblFoto.setSize(lblFoto.getWidth(), lblFoto.getHeight());
	   		JOptionPane.showMessageDialog(null, "Imagen guardada", "Imagen", JOptionPane.INFORMATION_MESSAGE);
					
		} */
		/*CICLO DE USO
		    File archivo = elegirImagen();
            byte[] imgFoto = imagenToByte(archivo);
            BufferedImage image = byteToImagen(imgFoto);
            mostrarImagen(image);
		 */
	
}
