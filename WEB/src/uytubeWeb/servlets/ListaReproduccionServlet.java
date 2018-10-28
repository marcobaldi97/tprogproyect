package uytubeWeb.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogica.publicar.DtListaReproduccion;
import uytubeLogica.publicar.DtVideo;
import uytubeLogica.publicar.Privacidad;

/**
 * Servlet implementation class ListaReproduccionServlet
 */
@WebServlet({ "/playlist", "/addVidPlaylist", "/removeVidPlaylist", "/modifyPlaylist", "/newPlaylist" })

public class ListaReproduccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaReproduccionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();

		switch (action) {

		case "removeVideo": {
			String id_video = (String) request.getParameter("ID");
			String nombreLista = (String) request.getParameter("List");

			if (session != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				if (login != null) {
					port.eliminarVideoLista(login, Integer.parseInt(id_video), nombreLista);
					response.sendRedirect(request.getContextPath() + "/modifyPlaylist?action=modify&nameList="
							+ nombreLista + "&ownerList=" + login);
				}
			}
		}
			break;

		case "Privacy": {
			String privacidad = (String) request.getParameter("grupoPrivacidad");
			String nombreLista = (String) request.getParameter("List");
			Privacidad privacidad_lista;
			if (privacidad.equals("Publico")) {
				privacidad_lista = Privacidad.PUBLICO;
			} else {
				privacidad_lista = Privacidad.PRIVADO;

			}

			if (session != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				if (login != null) {
					System.out.println(login);
					System.out.println(nombreLista);
					System.out.println(privacidad);

					port.cambiarPrivLDR(login, nombreLista, privacidad_lista);
					response.sendRedirect(request.getContextPath() + "/home");
				}
			}
		}
			break;

		case "modify": {
			if (session != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				if (login != null) {
					request.setAttribute("nicknameLogin", login);
				}
			} else {
				request.setAttribute("nicknameLogin", null);

			}
			String nombreLista = request.getParameter("nameList");
			String propietarioLista = request.getParameter("ownerList");
			DtVideo[] videosLista = port.obtenerDtsVideosListaReproduccionUsuario(propietarioLista, nombreLista).getItem().toArray(new DtVideo[0]);
			DtListaReproduccion infoLista = port.infoListaReproduccion(propietarioLista, nombreLista);
			request.setAttribute("videosLista", videosLista);
			request.setAttribute("infoLista", infoLista);
			request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/modificarListaReproduccion.jsp").forward(request,
					response);

		}
			break;

		case "details": {
			if (session != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				if (login != null) {
					request.setAttribute("nicknameLogin", login);
				}
			} else {
				request.setAttribute("nicknameLogin", null);

			}

			// String nombreLista = request.getParameter("nameList");
			String encodedLista = new String(request.getParameter("nameList").getBytes("ISO-8859-1"), "UTF-8");
			String encodedOwner = new String(request.getParameter("ownerList").getBytes("ISO-8859-1"), "UTF-8");
			String propietarioLista = request.getParameter("ownerList");
			String nombreLista = request.getParameter("nameList");
			String URLdecodedLista = URLDecoder.decode(nombreLista, "UTF-8");
			String URLdecodedOwner = URLDecoder.decode(propietarioLista, "UTF-8");
			System.out.println("NOMBRE LISTA" + nombreLista + " " + encodedLista + " " + URLdecodedLista);
			System.out.println("NOMBRE DUEÑO" + propietarioLista + " " + encodedOwner + " " + URLdecodedOwner);

			uytubeLogica.publicar.DtVideo[] videosLista = port
					.listarVideoListaReproduccion(propietarioLista, nombreLista).getItem()
					.toArray(new uytubeLogica.publicar.DtVideo[0]);
			uytubeLogica.publicar.DtListaReproduccion infoLista = port.infoListaReproduccion(propietarioLista,
					nombreLista);
			request.setAttribute("videosLista", videosLista);
			request.setAttribute("infoLista", infoLista);
			request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/detallesListaReproduccion.jsp").forward(request,
					response);
		}
			;
			break;
		case "list": {
			if (session != null) {
				String login = (String) session.getAttribute("nombre_usuario");
				if (login != null) {
					DtListaReproduccion[] listasPrivadasSesion = port.infoLDRdeUsuario(null, login,
							Privacidad.PRIVADO).getItem().toArray(new DtListaReproduccion[0]);
					request.setAttribute("listasPrivadasSesion", listasPrivadasSesion);

				}
			} else {
				request.setAttribute("listasPrivadasSesion", null);
			}

			DtListaReproduccion[] listas = port.listarLDRPublicasPorNombre("newUser").getItem().toArray(new DtListaReproduccion[0]);
			request.setAttribute("listarListasReproduccion", listas);
			request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/consultaListaReproduccion.jsp").forward(request,
					response);

		}
			;
			break;

		case "agregarVideoALista": {
			session = request.getSession(false);
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				String usuario_logged = (String) session.getAttribute("nombre_usuario");
				Integer id_video = Integer.parseInt(request.getParameter("id_video"));
				String encodedLista = new String(request.getParameter("nombre_lista").getBytes("ISO-8859-1"), "UTF-8");
				System.out.println("el nombre de la lista es: " + encodedLista);
				port.agregarVideoLista(usuario_logged, id_video, encodedLista);
			}
			break;
		}

		case "nuevaLDR": {

			if (session != null && session.getAttribute("nombre_usuario") != null) {
				request.getRequestDispatcher("WEB-INF/Lista Reproduccion/CrearListaParticular.jsp").forward(request,
						response);
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
		uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		HttpSession session = request.getSession(false);

		switch (action) {
		case "crearLDR": {
			String nombreUsuario = (String) session.getAttribute("nombre_usuario");
			if (session != null && session.getAttribute("nombre_usuario") != null) {
				System.out.println(nombreUsuario);
				System.out.println(request.getParameter("nombreLista"));
				String encodedLista = new String(request.getParameter("nombreLista").getBytes("ISO-8859-1"), "UTF-8");
				if (request.getParameter("grupoPrivacidad").equals("Publico")) {
					System.out.println("cree una listirijilla " + encodedLista);
					if (!port.memberListaReproduccionPropia(nombreUsuario, encodedLista)) {
						port.nuevaListaParticular(nombreUsuario, encodedLista, Privacidad.PUBLICO);
						response.sendRedirect(request.getContextPath() + "/playlist?action=details&ownerList="
								+ URLEncoder.encode(nombreUsuario, "UTF-8") + "&nameList="
								+ URLEncoder.encode(encodedLista, "UTF-8"));
					} else
						response.getWriter().print("la lista ya existe para ese usuario");

				} else {
					if (!port.memberListaReproduccionPropia(nombreUsuario, encodedLista)) {
						port.nuevaListaParticular(nombreUsuario, encodedLista, Privacidad.PRIVADO);
						response.sendRedirect(request.getContextPath() + "/playlist?action=details&ownerList="
								+ nombreUsuario + "&nameList=" + encodedLista);
					} else
						response.getWriter().print("la lista ya existe para ese usuario");

				}
				System.out.println("creada la LDR");
			} else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
			break;
		case "modificarLista": {
			DtListaReproduccion dataLista = (DtListaReproduccion) request.getAttribute("dtLista");
			break;
		}
		}
	}

}
