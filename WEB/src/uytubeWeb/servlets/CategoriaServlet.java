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
import uytubeLogic.logica.IVideoCtrl;

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
		
		
		String action = request.getParameter("action");
		Fabrica fabrica=Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		 
		System.out.println("estoy en categoria servlet GET");
		
		
		switch(action) 
		{
			case "consult":{
				String categoria = request.getParameter("type");
				System.out.println(categoria);
				DtVideo[] videos=interfazVideos.listarVideosPorCategoria(categoria);
				DtListaReproduccion[] listaReproduccion=interfazVideos.listarLDRPorCategoria(categoria);
				request.setAttribute("videos", videos);
				request.setAttribute("listas", listaReproduccion);
				//una pequeña pruebita
				//request.getRequestDispatcher("/WEB-INF/Categoria/consultaCategoria.jsp").forward(request, response);
				request.setAttribute("titulo", "Consulta de Categoria");
				request.getRequestDispatcher("WEB-INF/Busqueda.jsp").forward(request, response);
			};break;
			case "list":{
				
				 DtCategoria[] categorias=interfazVideos.listarCategorias();
				 request.setAttribute("listarCategorias", categorias);
				 request.getRequestDispatcher("/WEB-INF/Categoria/listarCategorias.jsp").forward(request, response);
				
				
			};break;
			
			case "listarEmbed":{
				System.out.println("estoy aqui aqui para quereerte");
				DtCategoria[] categorias = interfazVideos.listarCategorias();
				response.getWriter().append("<ul>");
				for(DtCategoria entry:categorias) {
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
