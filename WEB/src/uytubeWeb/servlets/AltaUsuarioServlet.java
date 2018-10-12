package uytubeWeb.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

/**
 * Servlet implementation class AltaUsuarioServlet
 */
@WebServlet("/newUser")
@MultipartConfig( fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class AltaUsuarioServlet extends HttpServlet {
	public static Date ParseFecha(String fecha) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date fechaDate = null;
		try {
			fechaDate = formato.parse(fecha);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return fechaDate;
	}

	public static byte[] imagenToByte(File archivo) {
		// imagen a byte[]
		try {
			byte[] imgFoto = new byte[(int) archivo.length()];
			InputStream inte = new FileInputStream(archivo);
			inte.read(imgFoto);
			return imgFoto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	private void nuevoUsuario(String nickname, String email, String nombre, String apellido, String contrasenia,
			String fechaNac, byte[] foto, String nomCanal, String descripcion, String privacidad, String categoria) {
		Fabrica fabrica = Fabrica.getInstance();
		System.out.println("la foto es" + foto);
		IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
		DtFecha dtFechaNac = new DtFecha(ParseFecha(fechaNac));
		Privacidad priv;
		if (privacidad == "PRIVADO") {
			priv = Privacidad.PRIVADO;
		} else {
			priv = Privacidad.PUBLICO;
		}

		try {
			usrCtrl.nuevoUsuario(nickname, contrasenia, nombre, apellido, email, dtFechaNac, foto,
					nomCanal, descripcion, priv, categoria);
		} catch (NullPointerException e) {
			usrCtrl.nuevoUsuario(nickname, contrasenia, nombre, apellido, email, dtFechaNac, null, nomCanal,
					descripcion, priv, categoria);
		}

	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("nuevo usuario GET");
		request.getRequestDispatcher("WEB-INF/Usuario/AltaUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("altaUsuario POST");
		if (request.getContentType() != null && request.getContentType().toLowerCase().indexOf("multipart/form-data") > -1 ) {
			System.out.println("ah re loco es multiparte");
			}
		// TODO Auto-generated method stub
		Fabrica fabrica = Fabrica.getInstance();
		IUsuarioCtrl usuarioCtrl = fabrica.getIUsuarioCtrl();
		// Part filePart = request.getPart("file"); // Retrieves <input type="file"
		// name="file">
		// filename =
		// Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE
		// fix.
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(new ServletRequestContext(request));
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<FileItem> iter = items.iterator();
		String nickname = null,nombre = null,apellido = null,contrasenia = null,contraseniaConfirmacion = null,email = null,fecha_nacimiento = null,nombre_canal = null,descripcion = null,privacidad = null,filename = null,categoria = null;
		byte[] foto=null;
		while (iter.hasNext()) {
			FileItem item = iter.next();

			if (item.isFormField()) {
				String nombreParam = item.getFieldName();
				switch (nombreParam) {
					case "nickname": {
						nickname = item.getString();
						break;
					}
					case "nombre": {
						nombre = item.getString();
						break;
					}
					case "apellido": {
						apellido = item.getString();
						break;
					}
					case "contrasenia": {
						contrasenia = item.getString();
						break;
					}
					case "contraseniaConfirmacion": {
						contraseniaConfirmacion = item.getString();
						break;
					}
					case "email": {
						email = item.getString();
						break;
					}
					case "fecha_nacimiento": {
						fecha_nacimiento = item.getString();
						break;
					}
					case "nombre_canal": {
						nombre_canal = item.getString();
						break;
					}
					case "descripcion": {
						descripcion = item.getString();
						break;
					}
					case "privacidad":{
						privacidad = item.getString();
					}
					case "categoria":{
						categoria = item.getString();
						break;
					}
				}
			} else {
				foto = item.get();
			}
		}
		System.out.println("estoy aca y " + nickname + " es lo que encontré");
		System.out.println("el archivo tiene ruta " + filename);
		
		  if (nickname.isEmpty() || email.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || fecha_nacimiento.isEmpty()) {
		 response.getWriter().print("Hay campos sin completar"); } else { boolean
		 disponible = usuarioCtrl.verificarDispUsuario(nickname, email); boolean
		 passIguales = contrasenia.equals(contraseniaConfirmacion); if (disponible &&
		  passIguales) { nuevoUsuario(nickname, email, nombre, apellido, contrasenia,
		  fecha_nacimiento, foto, nombre_canal, descripcion, privacidad,
		 categoria);
		  
		  IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl(); DtCanal infoCanal =
		  usrCtrl.mostrarInfoCanal(nickname); DtUsuario usuario =
		  usrCtrl.listarDatosUsuario(nickname); request.setAttribute("dataCanal",
		  infoCanal); request.setAttribute("dataUsuario", usuario); String nickAEnviar
		  = nickname; System.out.println("el nick ah re loco " + nickAEnviar);
		  response.sendRedirect(request.getContextPath() +
		  "/profile?opcion=Perfil&nickname=" + URLEncoder.encode(nickAEnviar,
		  "UTF-8")); } else { response.getWriter().print("Compruebe los datos"); } }
	
	}

}
