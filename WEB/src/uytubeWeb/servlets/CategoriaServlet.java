package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet(name="Categorias",urlPatterns={"/consult","/list"})
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		
		String action = request.getParameter("action");
		Fabrica fabrica=Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		 
		System.out.println("estoy en categoria servlet GET");
		
		
		switch(action) 
		{
			case "consult":{
				String categoria = request.getParameter("type");
				System.out.println(categoria);
				HttpSession session=request.getSession(false);
				if(session!=null) {
					String login=(String)session.getAttribute("nombre_usuario");
					if(login!=null) {
						DtVideo[] videos=interfazVideos.listarVideosPorCategoria(categoria, Privacidad.PUBLICO, login);
						DtListaReproduccion[] listaReproduccion=interfazVideos.listarLDRPorCategoria(categoria, Privacidad.PUBLICO, login);
						request.setAttribute("videos", videos);
						request.setAttribute("listas", listaReproduccion);
					}else{
						DtVideo[] videos=interfazVideos.listarVideosPorCategoria(categoria, Privacidad.PUBLICO, "");
						DtListaReproduccion[] listaReproduccion=interfazVideos.listarLDRPorCategoria(categoria, Privacidad.PUBLICO, "");
						request.setAttribute("videos", videos);
						request.setAttribute("listas", listaReproduccion);
					}
				}
				request.setAttribute("titulo", "Consulta de Categoria");
				request.getRequestDispatcher("WEB-INF/Busqueda.jsp").forward(request, response);
			};break;
			
			case "listarEmbed":{
				System.out.println("estoy aqui aqui para quereerte");
				//DtCategoria[] categorias = interfazVideos.listarCategorias();
				uytubeLogica.publicar.DtCategoria[] categoriasWS= port.listarCategorias().getItem().toArray(new uytubeLogica.publicar.DtCategoria[0]);
				response.getWriter().append("<ul>");
				for(uytubeLogica.publicar.DtCategoria entry:categoriasWS) {
					response.getWriter().append("<li><a href='consult?action=consult&type="+entry.getNombre()+"'>"+entry.getNombre()+"</a> </li>");
				}
				response.getWriter().append("</ul>");
			}
		
		}
		
		
		//request.getRequestDispatcher("/WEB-INF/Categoria/consultaCategoria.jsp").forward(request, response);
		 
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
