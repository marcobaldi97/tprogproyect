package uytubeWeb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import uytubeLogica.publicar.DtCanal;
import uytubeLogica.publicar.DtCategoria;
import uytubeLogica.publicar.DtComentario;
import uytubeLogica.publicar.DtFecha;
import uytubeLogica.publicar.DtInfoVideo;
import uytubeLogica.publicar.DtUsuario;
import uytubeLogica.publicar.DtVideo;
import uytubeLogica.publicar.Privacidad;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet(name = "VideoServlet", urlPatterns = { "/watch", "/newVideo", "/modifyVideo", "/likeVideo", "/dislikeVideo",
		"/newComment", "/newResponse", "/leaveFollow" })
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (Exception e) {
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

	private void crearVideo(String login, String nomVideo, String duracion, String url, String fecha, String categoria,
			String descripcionV) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		System.out.println("estoy creando el video");
		DtFecha fechaPublicacionV = new DtFecha();
		Date laDate = ParseFecha(fecha);
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(laDate);
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fechaPublicacionV.setFecha(xgcal);
		DtCategoria catV = new DtCategoria();
		catV.setNombre(categoria);
		port.aniadirVideo(login, nomVideo, descripcionV, (Integer.parseInt(duracion)), fechaPublicacionV, url, catV,
				Privacidad.PRIVADO);

	}

	private void seguirUsuario(String nombre_usuario, String propietario) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		port.seguirUsuario(nombre_usuario, propietario);
	}

	private void dejarDeSeguirUsuario(String nombre_usuario, String propietario) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		System.out.println("el usuario es :" + nombre_usuario + " y el propietario es : " + propietario);
		port.dejarUsuario(nombre_usuario, propietario);
		;
	}

	private void comentarVideo(int id_video, String comentador, String contenido) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		Date fecha_actual = new Date();
		DtFecha fecha = new DtFecha();
		Date laDate = fecha_actual;
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(laDate);
		XMLGregorianCalendar xgcal = null;
		try {
			xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fecha.setFecha(xgcal);
		port.nuevoComentario(id_video, comentador, fecha, contenido);
	}

	private String[] conseguirNicknamesUsuariosDelDtUsuario(DtUsuario[] dataUsuario) {
		String[] listaADevolver = new String[dataUsuario.length];
		for (int index = 0; index < dataUsuario.length; index++) {
			listaADevolver[index] = dataUsuario[index].getNickname();
		}
		return listaADevolver;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("estoy en videoServlet GET");
		String opc = request.getParameter("opcion");
		System.out.println(opc);
		switch (opc) {
		case "altaVideo": {
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				DtCategoria[] cat = port.listarCategorias().getItem().toArray(new DtCategoria[0]);
				for (DtCategoria entry : cat) {
					entry.setNombre(entry.getNombre().replace(" ", "||"));
				}
				request.setAttribute("listadoCat", cat);
				request.getRequestDispatcher("WEB-INF/Video/AltaVideo.jsp").forward(request, response);
			}else
				response.sendRedirect(request.getContextPath() + "/casa");
			break;
		}
		case "null":
			break;
		case "likeVideo": {
			System.out.println("Quiero darle me gusta a un video");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				Integer id_video = Integer.parseInt(request.getParameter("id_video"));
				String nombre_usuario = (String) session.getAttribute("nombre_usuario");
				port.valorarVideo(id_video, nombre_usuario, true);
				System.out.println("usuario " + nombre_usuario + " id_video:" + id_video);// esto es para ver si no
																							// manda nada null.
				System.out.println("le di me gusta");
			}
			break;
		}
		case "dislikeVideo": {
			System.out.println("Quiero darle no me gusta a un video");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				Integer id_video = Integer.parseInt(request.getParameter("id_video"));
				String nombre_usuario = (String) session.getAttribute("nombre_usuario");
				port.valorarVideo(id_video, nombre_usuario, false);
				System.out.println("usuario " + nombre_usuario + " id_video:" + id_video);
				System.out.println("le di no me gusta");
			}
			break;
		}
		case "ver": {

			System.out.println("Quiero ver un video");
			if (port.memberVideo(Integer.parseInt(request.getParameter("ID")))) {
				System.out.println("EL VIDEO ES NULL?");
				System.out.println(port.memberVideo(Integer.parseInt(request.getParameter("ID"))));
				DtVideo dataVideo = port.infoAddVideo(Integer.parseInt(request.getParameter("ID")));
				
				request.setAttribute("dataVideo", dataVideo);
				DtComentario[] comentarios = port.listarComentarios(dataVideo.getIDVideo()).getItem()
						.toArray(new DtComentario[0]);
				request.setAttribute("comentarios", comentarios);
				DtUsuario usuario_propietario = port.listarDatosUsuario(dataVideo.getPropietario());
				request.setAttribute("usuario_propietario", usuario_propietario);
				DtCanal canal_propietario = port.mostrarInfoCanal(dataVideo.getPropietario());
				request.setAttribute("canal_propietario", canal_propietario);
				DtInfoVideo infoVideo = port.verDetallesVideoExt(Integer.parseInt(request.getParameter("ID")));
				request.setAttribute("cantLikes", infoVideo.getUsuariosGusta().size());
				request.setAttribute("cantDislikes", infoVideo.getUsuariosNoGusta().size());
				String[] listaLikes = conseguirNicknamesUsuariosDelDtUsuario(
						infoVideo.getUsuariosGusta().toArray(new DtUsuario[0]));
				String[] listaDislikes = conseguirNicknamesUsuariosDelDtUsuario(
						infoVideo.getUsuariosNoGusta().toArray(new DtUsuario[0]));
				request.setAttribute("listaLikes", listaLikes);
				request.setAttribute("listaDislikes", listaDislikes);
				HttpSession session = request.getSession(false);
				if (session != null && session.getAttribute("nombre_usuario") != null) {
					request.setAttribute("logged", true);
					String usuarioLogged = (String) session.getAttribute("nombre_usuario");
					String[] listasReproduccionUsuarioLogged = port.listarLDRdeUsuario(usuarioLogged).getItem()
							.toArray(new String[0]);
					request.setAttribute("listasReproduccionUsuarioLogged", listasReproduccionUsuarioLogged);
					Integer IDVideo = Integer.parseInt(request.getParameter("ID"));
					port.agregarVisita(IDVideo, usuarioLogged);
					request.setAttribute("like_state", port.getEstadoValoracion(IDVideo, usuarioLogged));
					// calificacion de estado de valoraci�n.
					String[] usuariosSeguidores = port.listarUsuariosQueLeSigue(dataVideo.getPropietario()).getItem()
							.toArray(new String[0]);
					boolean flagFollow = false;
					for (int i = 0; i < usuariosSeguidores.length; i++) {
						if (usuariosSeguidores[i].equals(usuarioLogged))
							flagFollow = true;
					}
					if (flagFollow == true)
						request.setAttribute("follow_state", "true");
					else
						request.setAttribute("follow_state", "false");
					// calificacion de estado de seguir.
					DtUsuario usuarioLoggedData = port.listarDatosUsuario(usuarioLogged);
					request.setAttribute("dataUsuario", usuarioLoggedData);

				} else {
					request.setAttribute("logged", false);
				}
				if (request.getHeader("User-Agent").indexOf("Mobile") != -1) {
					request.getRequestDispatcher("/WEB-INF/Video/VerVideoMobile.jsp").forward(request, response);
				} else {
					request.getRequestDispatcher("/WEB-INF/Video/VerVideo.jsp").forward(request, response);
				}
			} else
				response.sendRedirect(request.getContextPath() + "/casa");

			break;
		}
		case "follow": {
			System.out.println("Quiero seguir a un usuario");
			HttpSession session = request.getSession();
			String propietario = request.getParameter("usuario_a_seguir");
			String nombre_usuario = (String) session.getAttribute("nombre_usuario");
			seguirUsuario(nombre_usuario, propietario);
			break;
		}
		case "leaveFollow": {
			System.out.println("Quiero dejar de seguir a un usuario");
			HttpSession session = request.getSession();
			String propietario = request.getParameter("usuario_a_seguir");
			String nombre_usuario = (String) session.getAttribute("nombre_usuario");
			dejarDeSeguirUsuario(nombre_usuario, propietario);
			break;
		}
		case "comment": {
			System.out.println("Quiero hacer un comentario");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				String comentador = (String) session.getAttribute("nombre_usuario");
				int id_video = Integer.parseInt(request.getParameter("id_video"));
				String contenido = request.getParameter("contenido");
				comentarVideo(id_video, comentador, contenido);
				System.out.println("comentador " + comentador + " id_video:" + id_video + "contenido: " + contenido);
			}

			break;
		}
		case "modificarVideo": {
			// aca modificar video
			DtVideo dataVideo = (DtVideo) request.getAttribute("dtVideo");
			response.getWriter().append("no esta hecho aun");
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
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		// TODO Auto-generated method stub
		System.out.println("estoy en videoServlet POST");
		String opc = request.getParameter("opcion");
		System.out.println(opc);
		switch (opc) {
		case "altaVideo":

			System.out.println("Quiero crear video");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				String nombreVideo = new String(request.getParameter("nombreVideo").getBytes("ISO-8859-1"), "UTF-8");
				String duracionVideo = new String(request.getParameter("duracionVideo").getBytes("ISO-8859-1"),
						"UTF-8");
				String urlVideo = request.getParameter("urlVideo");
				String fechaVideo = request.getParameter("fechaVideo");
				String categoria = new String(request.getParameter("categoria").getBytes("ISO-8859-1"), "UTF-8")
						.replace("||", " ");
				System.out.println("hola pepito " + categoria);
				System.out.println("hola pepote " + request.getParameter("categoria"));
				String descVideo = new String(request.getParameter("descVideo").getBytes("ISO-8859-1"), "UTF-8");
				if (nombreVideo != "" && duracionVideo != "" && isInteger(duracionVideo) && urlVideo != "" && fechaVideo != "" && descVideo != "") {
					crearVideo(login,nombreVideo, duracionVideo, urlVideo, fechaVideo, categoria, descVideo);
					response.sendRedirect(request.getContextPath() + "/casa");
				} else {
					response.getWriter().append("Error, verifique los campos nuevamente");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/casa");
			}
			break;
		case "modificarVideo": {
			// aca modificar video
			DtVideo dataVideo = (DtVideo) request.getAttribute("dtVideo");
			response.getWriter().append("no esta hecho aun");
			break;
		}

		default:
			System.out.println("Error");
			break;
		}
	}

}
