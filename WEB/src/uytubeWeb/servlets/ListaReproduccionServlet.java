package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;

/**
 * Servlet implementation class ListaReproduccionServlet
 */
@WebServlet({"/playlist","/addVidPlaylist","/removeVidPlaylist","/modifyPlaylist","/newPlaylist"})


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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Fabrica fabrica=Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		IUsuarioCtrl interfazUsuario = fabrica.getIUsuarioCtrl();
		
		switch(action) 
		{
			case "details":{
				String nombreLista = request.getParameter("nameList");
				String propietarioLista = request.getParameter("ownerList");
				DtVideo[] videosLista=interfazUsuario.obtenerDtsVideosListaReproduccionUsuario(propietarioLista, nombreLista);
				DtListaReproduccion infoLista = interfazUsuario.infoAdicLDR(propietarioLista, nombreLista);
				request.setAttribute("videosLista", videosLista);
				request.setAttribute("infoLista", infoLista);
				request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/detallesListaReproduccion.jsp").forward(request, response);



				
			};break;
			case "list":{
				
				 DtListaReproduccion[] listas=interfazVideos.listarLDRPublicasPorNombre("");
				 request.setAttribute("listarListasReproduccion", listas);
				 request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/consultaListaReproduccion.jsp").forward(request, response);
				
				
			};break;
		
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
