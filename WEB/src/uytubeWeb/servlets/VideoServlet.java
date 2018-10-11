package uytubeWeb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtComentario;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtInfoVideo;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet(name = "VideoServlet", urlPatterns = { "/watch", "/newVideo", "/modifyVideo", "/likeVideo", "/dislikeVideo",
		"/newComment", "/newResponse" })
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	private boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e )
	   {
	      return false;
	   }
	}

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

	private void crearVideo(String login,String nomVideo, String duracion, String url, String fecha, String categoria,
			String descripcionV) {
		System.out.println("estoy creando el video");
		Fabrica fabrica = Fabrica.getInstance();
		IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
		DtFecha fechaPublicacionV = new DtFecha(ParseFecha(fecha));
		DtCategoria catV = new DtCategoria(categoria);
		usrCtrl.aniadirVideo(login, nomVideo, descripcionV, (Integer.parseInt(duracion)), fechaPublicacionV, url,
				catV, Privacidad.PRIVADO);

	}


	private void seguirUsuario(String nombre_usuario, String propietario) {
		Fabrica fabrica = Fabrica.getInstance();
		IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
		usrCtrl.seguirUsuario(nombre_usuario, propietario);
	}

	private void comentarVideo(int id_video, String comentador, String contenido) {
		Fabrica fabrica = Fabrica.getInstance();
		IVideoCtrl interfaz_video = fabrica.getIVideoCtrl();
		Date fecha_actual = new Date();
		DtFecha fecha = new DtFecha(fecha_actual);
		interfaz_video.nuevoComentario(id_video, comentador, fecha, contenido);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("estoy en videoServlet GET");
		String opc = request.getParameter("opcion");
		System.out.println(opc);
		switch (opc) {
		case "altaVideo":{
			HttpSession session=request.getSession(false);
			if(session!=null && session.getAttribute("nombre_usuario")!=null)
				request.getRequestDispatcher("WEB-INF/Video/AltaVideo.jsp").forward(request, response);
			else
				response.sendRedirect(request.getContextPath() + "/home");
			break;
		}
		case "null":
			break;
		case "likeVideo": {
			System.out.println("Quiero darle me gusta a un video");
			HttpSession session=request.getSession(false);
            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
    		 	Integer id_video = Integer.parseInt(request.getParameter("id_video"));
    		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
    			Fabrica fabrica = Fabrica.getInstance();
    			IVideoCtrl interfaz_video = fabrica.getIVideoCtrl();
    			interfaz_video.valorarVideo(id_video, nombre_usuario, true);
    		 	System.out.println("usuario "+nombre_usuario+" id_video:" +id_video);//esto es para ver si no manda nada null.
    		 	System.out.println("le di me gusta");
            }
		 	break;
		}
		case "dislikeVideo": {
			System.out.println("Quiero darle no me gusta a un video");
			HttpSession session=request.getSession(false);
            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
    		 	Integer id_video = Integer.parseInt(request.getParameter("id_video"));
    		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
    			Fabrica fabrica = Fabrica.getInstance();
    			IVideoCtrl interfaz_video = fabrica.getIVideoCtrl();
    			interfaz_video.valorarVideo(id_video, nombre_usuario, false);
    		 	System.out.println("usuario "+nombre_usuario+" id_video:" +id_video);
    		 	System.out.println("le di no me gusta");
            }
		 	break;
		}
		case "ver": {
			System.out.println("Quiero ver un video");
			Fabrica fabricaControladores = Fabrica.getInstance();
			IVideoCtrl vidController = fabricaControladores.getIVideoCtrl();
			IUsuarioCtrl usrController = fabricaControladores.getIUsuarioCtrl();
			DtVideo dataVideo = vidController.infoAddVideo(Integer.parseInt(request.getParameter("ID")));
			request.setAttribute("dataVideo", dataVideo);
			DtComentario[] comentarios = vidController.listarComentarios(dataVideo.getIDVideo());
			request.setAttribute("comentarios", comentarios);
			DtUsuario usuario_propietario = usrController.listarDatosUsuario(dataVideo.getPropietario());
			request.setAttribute("usuario_propietario", usuario_propietario);
			DtCanal canal_propietario = usrController.mostrarInfoCanal(dataVideo.getPropietario());
			request.setAttribute("canal_propietario",canal_propietario);
			HttpSession session=request.getSession(false);
            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
            	request.setAttribute("logged" ,true);
            	String usuarioLogged = (String) session.getAttribute("nombre_usuario");
            	String[] listasReproduccionUsuarioLogged = usrController.listarLDRdeUsuario(usuarioLogged);
            	request.setAttribute("listasReproduccionUsuarioLogged", listasReproduccionUsuarioLogged);
            	Integer IDVideo = Integer.parseInt(request.getParameter("ID"));
            	request.setAttribute("like_state", vidController.getEstadoValoracion(IDVideo, usuarioLogged));
            	//calificacion de estado de valoraci�n.
            	String[] usuariosSeguidores = usrController.listarUsuariosQueLeSigue(dataVideo.getPropietario());
            	boolean flagFollow = false;
            	for(int i = 0;i<usuariosSeguidores.length;i++){
            		if(usuariosSeguidores[i] == usuarioLogged) flagFollow = true;
            	}
            	if(flagFollow == true) 
            		request.setAttribute("follow_state", "true");
            	else request.setAttribute("follow_state", "false");
            	//calificacion de estado de seguir.
            }else{
            	request.setAttribute("logged" ,false);
            }
			request.getRequestDispatcher("/WEB-INF/Video/VerVideo.jsp").forward(request, response);
			break;
		}
		case "follow": {
			System.out.println("Quiero seguir a un usuario");
			HttpSession session = request.getSession();
			String propietario = request.getParameter("propietario");
			String nombre_usuario = (String) session.getAttribute("nombre_usuario");
			seguirUsuario(nombre_usuario, propietario);
			break;
		}
		case "comment": {
			System.out.println("Quiero hacer un comentario");
			HttpSession session=request.getSession(false);
            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
    			String comentador = (String)session.getAttribute("nombre_usuario");
    			int id_video = Integer.parseInt(request.getParameter("id_video"));
    			String contenido = request.getParameter("contenido");
    			comentarVideo(id_video, comentador, contenido);
    			System.out.println("comentador "+comentador+" id_video:" +id_video+ "contenido: "+contenido);
            }

			break;
		}
		case "modificarVideo":{
			//aca modificar video
			DtVideo dataVideo = (DtVideo) request.getAttribute("dtVideo");
			
			break;
		}
		default:
			System.out.println("Error");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("estoy en videoServlet POST");
		String opc = request.getParameter("opcion");
		System.out.println(opc);
		switch (opc) {
		case "altaVideo":
			
			System.out.println("Quiero crear video");
			HttpSession session=request.getSession(false);
			if(session!=null && session.getAttribute("nombre_usuario")!=null) {
				String login = (String)session.getAttribute("nombre_usuario");
				String nombreVideo = new String(request.getParameter("nombreVideo").getBytes("ISO-8859-1"), "UTF-8");
				String duracionVideo = new String(request.getParameter("duracionVideo").getBytes("ISO-8859-1"), "UTF-8");
				String urlVideo = request.getParameter("urlVideo");
				String fechaVideo = request.getParameter("fechaVideo");
				String categoria = new String(request.getParameter("categoria").getBytes("ISO-8859-1"), "UTF-8");
				String descVideo = new String(request.getParameter("descVideo").getBytes("ISO-8859-1"), "UTF-8");
				if (nombreVideo != "" && duracionVideo != "" && isInteger(duracionVideo) && urlVideo != "" && fechaVideo != "" && descVideo != "") {
					crearVideo(login,nombreVideo, duracionVideo, urlVideo, fechaVideo, categoria, descVideo);
					response.sendRedirect(request.getContextPath() + "/home");
				} else {
					response.getWriter().append("Error, verifique los campos nuevamente");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
			break;

		default:
			System.out.println("Error");
			break;
		}
	}

}
