package uytubeWeb.servlets;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
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
		IUsuarioCtrl interfazUsuario = fabrica.getIUsuarioCtrl();
		HttpSession session=request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		switch(action) 
		{
		
			case "removeVideo":{
				String id_video= (String) request.getParameter("ID");
				String nombreLista = (String) request.getParameter("List");
				
				if(session!=null) {
		            String login=(String)session.getAttribute("nombre_usuario");
		            if(login!=null) {
		            	interfazUsuario.eliminarVideoLista(login, Integer.parseInt(id_video), nombreLista);
		            	response.sendRedirect(request.getContextPath() + "/modifyPlaylist?action=modify&nameList="+nombreLista+"&ownerList="+login);		
		            }
				}
				}break;
			
			case "Privacy":{
				String privacidad= (String) request.getParameter("grupoPrivacidad");
				String nombreLista = (String) request.getParameter("List");
				Privacidad privacidad_lista;
				if(privacidad.equals("Publico"))
				{
					privacidad_lista=Privacidad.PUBLICO;
				}
				else
				{
					privacidad_lista=Privacidad.PRIVADO;
							
				}	
				
				if(session!=null) {
		            String login=(String)session.getAttribute("nombre_usuario");
		            if(login!=null) {
		            	System.out.println(login);
		            	System.out.println(nombreLista);
		            	System.out.println(privacidad);

		            	interfazUsuario.cambiarPrivLDR(login, nombreLista, privacidad_lista);
		            	response.sendRedirect(request.getContextPath() + "/home");		
		            }
				}
				}break;	
				
				
			case "modify":
			{
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
			request.getRequestDispatcher("/WEB-INF/Lista Reproduccion/modificarListaReproduccion.jsp").forward(request, response);	
				
			}break;
		
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

			
			case "nuevaLDR":{
				
				if(session!=null && session.getAttribute("nombre_usuario")!=null) {
					request.getRequestDispatcher("WEB-INF/Lista Reproduccion/CrearListaParticular.jsp").forward(request, response);
				}else {
					response.sendRedirect(request.getContextPath() + "/home");
				}
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
		IUsuarioCtrl interfazUsuario = fabrica.getIUsuarioCtrl();
		HttpSession session=request.getSession(false);
		
		switch(action) {
		case "crearLDR":{
			
			if(session!=null && session.getAttribute("nombre_usuario")!=null) {
				System.out.println((String)session.getAttribute("nombre_usuario"));
				System.out.println(request.getParameter("nombreLista"));
				String encodedLista = new String(request.getParameter("nombreLista").getBytes("ISO-8859-1"), "UTF-8");
				if(request.getParameter("grupoPrivacidad").equals("Publico")) {
					System.out.println("cree una listirijilla " + encodedLista);
					interfazUsuario.nuevaListaParticular((String)session.getAttribute("nombre_usuario"), encodedLista, Privacidad.PUBLICO);
					response.sendRedirect(request.getContextPath() + "/playlist?action=list");
				}else {
					interfazUsuario.nuevaListaParticular((String)session.getAttribute("nombre_usuario"), encodedLista, Privacidad.PRIVADO);
					response.sendRedirect(request.getContextPath() + "/playlist?action=list");
				}
				System.out.println("creada la LDR");
			}else {
				response.sendRedirect(request.getContextPath() + "/home");
			}
		}
		case "modificarLista":{
			DtListaReproduccion dataLista = (DtListaReproduccion) request.getAttribute("dtLista");
			break;
		}
		}
	}

}
