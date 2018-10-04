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

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

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
		HttpSession session=request.getSession(false);
		
		switch(action) 
		{
			case "details":{
				 if(session!=null) {
			            String login=(String)session.getAttribute("nombre_usuario");
			            if(login!=null) {
							 request.setAttribute("nicknameLogin", login);
			            }
			     }
				 else
				 {
					 request.setAttribute("nicknameLogin", null);

				 } 	
				String nombreLista = request.getParameter("nameList");
				String propietarioLista = request.getParameter("ownerList");
				DtVideo[] videosLista=interfazUsuario.obtenerDtsVideosListaReproduccionUsuario(propietarioLista, nombreLista);
				DtListaReproduccion infoLista = interfazUsuario.infoAdicLDR(propietarioLista, nombreLista);
				request.setAttribute("videosLista", videosLista);
				request.setAttribute("infoLista", infoLista);
				request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/detallesListaReproduccion.jsp").forward(request, response);	
			};break;
			case "list":{
				 if(session!=null) {
			            String login=(String)session.getAttribute("nombre_usuario");
			            if(login!=null) {
			            	DtListaReproduccion[] listasPrivadasSesion=interfazUsuario.infoLDRdeUsuario(login, Privacidad.PRIVADO);
							 request.setAttribute("listasPrivadasSesion", listasPrivadasSesion);

			            }
			     }
				 else
				 {
					 request.setAttribute("listasPrivadasSesion", null);
				 }	 
				
				 DtListaReproduccion[] listas=interfazUsuario.listarLDRPublicasPorNombre("");
				 request.setAttribute("listarListasReproduccion", listas);
				 request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/consultaListaReproduccion.jsp").forward(request, response);
			};break;
			
			case "nuevaLDR":{
				
				if(session!=null && session.getAttribute("nombre_usuario")!=null) {
					request.getRequestDispatcher("WEB-INF/Lista Reproduccion/CrearListaParticular.jsp").forward(request, response);
				}else {
					response.sendRedirect(request.getContextPath() + "/home");
				}
			}
			
			case "agregarVideoALista":{
				session=request.getSession(false);
	            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
	            	String usuario_logged = (String) session.getAttribute("nombre_usuario");
	            	Integer id_video = Integer.parseInt(request.getParameter("id_video"));
					String nombre_lista = request.getParameter("nombre_lista");
					interfazUsuario.agregarVideoLista(usuario_logged, id_video, nombre_lista);
	            }
				break;
			}

		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		Fabrica fabrica=Fabrica.getInstance();
		IVideoCtrl interfazVideos = fabrica.getIVideoCtrl();
		IUsuarioCtrl interfazUsuario = fabrica.getIUsuarioCtrl();
		HttpSession session=request.getSession(false);
		
		switch(action) {
		case "crearLDR":{
			if(session!=null && session.getAttribute("nombre_usuario")!=null) {
				System.out.println((String)session.getAttribute("nombre_usuario"));
				System.out.println(request.getParameter("nombreLista"));
				if(request.getParameter("grupoPrivacidad").equals("Publico")) {
					interfazUsuario.nuevaListaParticular((String)session.getAttribute("nombre_usuario"), request.getParameter("nombreLista"), Privacidad.PUBLICO);
					response.sendRedirect(request.getContextPath() + "/playlist?action=list");
				}else {
					interfazUsuario.nuevaListaParticular((String)session.getAttribute("nombre_usuario"), request.getParameter("nombreLista"), Privacidad.PRIVADO);
					response.sendRedirect(request.getContextPath() + "/playlist?action=list");
				}
				System.out.println("creada la LDR");
			}else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
		}
	}

}
