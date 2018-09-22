package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IVideoCtrl;

/**
 * Servlet implementation class CategoriaServlet
 */
@WebServlet("/Categorias")
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
		Fabrica fabrica=Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		String MUS="Musica";interfazVideos.crearCategoria(MUS);
		DtCategoria[] categorias=interfazVideos.listarCategorias();
		request.setAttribute("listarCategorias", categorias);// se accede con ${categorias} en JSP
		request.getRequestDispatcher("/WEB-INF/Categoria/listarCategorias.jsp").forward(request, response);;
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
