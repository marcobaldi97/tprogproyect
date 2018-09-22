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

import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

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
		//ESTO BORRARLO DE INMEDIATO
		DatosDePrueba data=new DatosDePrueba();
		data.cargarDatosDePrueba();
		//CUANDO ESTO FUNQUE BIEN
		Fabrica fabrica = Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		IUsuarioCtrl interfazUsuarios = fabrica.getIUsuarioCtrl();
		DtVideo[] videos = interfazVideos.listarVideosPublicosPorNombre((String)request.getAttribute(busqueda));
		DtCanal[] canales = interfazUsuarios.listarCanalesPorNombre((String)request.getAttribute(busqueda));
		DtListaReproduccion[] listas = interfazVideos.listarLDRPublicasPorNombre((String)request.getAttribute(busqueda));
		
		HttpSession session=request.getSession();
		if(session.getAttribute("usuarioLogueado")!=null) {
			String login=(String)session.getAttribute("login");
			DtVideo[] videosPrivadosSesion=interfazUsuarios.infoVideosCanal(login, Privacidad.PRIVADO);
			DtListaReproduccion[] listasPrivadasSesion=interfazUsuarios.infoLDRdeUsuario(login, Privacidad.PRIVADO);
			List<DtVideo> videosAux= new ArrayList<DtVideo>(Arrays.asList(videos));
			videosAux.addAll(Arrays.asList(videosPrivadosSesion));
			videos=videosAux.toArray(new DtVideo[0]);
			List<DtListaReproduccion> listasAux = new ArrayList<DtListaReproduccion>(Arrays.asList(listas));
			listasAux.addAll(Arrays.asList(listasPrivadasSesion));
			listas=listasAux.toArray(new DtListaReproduccion[0]);
		}
		String parametroListas="listas";
		String parametroCanales="canales";
		String parametroVideos="videos";
		request.setAttribute(parametroListas, listas);
		request.setAttribute(parametroCanales, canales);
		request.setAttribute(parametroVideos, videos);
		
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
