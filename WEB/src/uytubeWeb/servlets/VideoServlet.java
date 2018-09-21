package uytubeWeb.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoServlet
 */
@WebServlet(name="Video",urlPatterns={"/watch","/newVideo","/modifyVideo","/likeVideo","/newComment","/newResponse"})
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void crearVideo(String nomVideo, String duracion, String url, String fecha, String categoria){
    	System.out.println(fecha);
	 }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opc=request.getParameter("opcion");
		System.out.println(opc);
		switch(opc){
		case "altaVideo":
			System.out.println("Quiero crear video");
			crearVideo(request.getParameter("nombreVideo"),request.getParameter("duracionVideo"),request.getParameter("urlVideo"),
					request.getParameter("fechaVideo"),request.getParameter("categoria"));
		break;
		case "null":
		break;
		default:
			System.out.println("Error");
		break;	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
