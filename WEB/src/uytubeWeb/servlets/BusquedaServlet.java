package uytubeWeb.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogica.publicar.DtCanal;
import uytubeLogica.publicar.DtListaReproduccion;
import uytubeLogica.publicar.DtVideo;
import uytubeLogica.publicar.Privacidad;



/**
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/search")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BusquedaServlet() {
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
		// TODO Auto-generated method stub
		String busqueda="busqueda";
		String defaultBusqueda="";
		System.out.println(request.getParameter(busqueda));
		if(request.getParameter(busqueda)==null) {
			request.setAttribute(busqueda, defaultBusqueda);
		}
		else {
			request.setAttribute(busqueda, request.getParameter(busqueda));
		}
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		DtVideo[] videos = port.listarVideosPublicosPorNombre((String)request.getAttribute(busqueda)).getItem().toArray(new DtVideo[0]);
		DtCanal[] canales = port.listarCanalesPublicosPorNombre((String)request.getAttribute(busqueda)).getItem().toArray(new DtCanal[0]);
		DtListaReproduccion[] listas = port.listarLDRPublicasPorNombre((String)request.getAttribute(busqueda)).getItem().toArray(new DtListaReproduccion[0]);
		
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String login=(String)session.getAttribute("nombre_usuario");
			if(login!=null) {
				System.out.println("hay un usuario logueado");
				DtVideo[] videosPrivadosSesion=port.infoVideosCanal((String)request.getAttribute(busqueda),login, Privacidad.PRIVADO).getItem().toArray(new DtVideo[0]);
				DtListaReproduccion[] listasPrivadasSesion=port.infoLDRdeUsuario((String)request.getAttribute(busqueda),login, Privacidad.PRIVADO).getItem().toArray(new DtListaReproduccion[0]);
				List<DtVideo> videosAux= new ArrayList<DtVideo>(Arrays.asList(videos));
				videosAux.addAll(Arrays.asList(videosPrivadosSesion));
				videos=videosAux.toArray(new DtVideo[0]);
				List<DtListaReproduccion> listasAux = new ArrayList<DtListaReproduccion>(Arrays.asList(listas));
				listasAux.addAll(Arrays.asList(listasPrivadasSesion));
				listas=listasAux.toArray(new DtListaReproduccion[0]);
			}
		}
		String parametroListas="listas";
		String parametroCanales="canales";
		String parametroVideos="videos";
		
		request.setAttribute(parametroListas, listas);
		request.setAttribute(parametroCanales, canales);
		request.setAttribute(parametroVideos, videos);
		
		request.setAttribute("titulo", "Resultados de Busqueda");
		request.getRequestDispatcher("/WEB-INF/Busqueda.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
