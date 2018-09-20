package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytube.logica.DtCanal;
import uytube.logica.DtListaReproduccion;
import uytube.logica.DtVideo;
import uytube.logica.Factory;
import uytube.logica.IUsuarioCtrl;
import uytube.logica.IVideoCtrl;

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
		if(request.getParameter(busqueda)==null)
			request.setAttribute("busqueda", defaultBusqueda);
		Factory fabrica = Factory.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		IUsuarioCtrl interfazUsuarios = fabrica.getIUsuarioCtrl();
		DtVideo[] videos = interfazVideos.listarVideosPublicosPorNombre(request.getParameter(busqueda));
		DtCanal[] canales = interfazUsuarios.listarCanalesPorNombre(request.getParameter(busqueda));
		DtListaReproduccion[] listas = interfazVideos.listarLDRPublicasPorNombre(busqueda);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
