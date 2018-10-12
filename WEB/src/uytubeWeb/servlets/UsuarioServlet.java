package uytubeWeb.servlets;


import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet({"/login","/profile","/modifyUser","/follow","/responseComment"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void seguirUsuario(String nombre_usuario, String usuario_a_seguir) {
		Fabrica fabrica = Fabrica.getInstance();
		IUsuarioCtrl interfaz_usuario = fabrica.getIUsuarioCtrl();
		interfaz_usuario.seguirUsuario(nombre_usuario, usuario_a_seguir);
	}
	private void dejarUsuario(String nombre_usuario, String usuario_a_no_seguir) {
		Fabrica fabrica = Fabrica.getInstance();
		IUsuarioCtrl interfaz_usuario = fabrica.getIUsuarioCtrl();
		interfaz_usuario.dejarUsuario(nombre_usuario, usuario_a_no_seguir);
	}

  
 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion = (String) request.getParameter("opcion");
		switch (opcion) {
		case "null":
		break;
		case "login" :{
				System.out.println("me voy pal login");
				request.getRequestDispatcher("WEB-INF/Usuario/Login.jsp").forward(request, response);
			
			break;
		}
		case "logout" :{
			System.out.println("estoy cerrando sesion");
			request.getSession(false).removeAttribute("nombre_usuario");
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/home");
			break;
		}
		case "follow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_seguir = (String) request.getParameter("usuario_a_seguir");
		 	System.out.println("usuario: "+nombre_usuario+ " va a seguir a :"+usuario_a_seguir);
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
		 	break;
		}	
		case "unfollow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_no_seguir = (String) request.getParameter("usuario_a_no_seguir");
		 	dejarUsuario(nombre_usuario, usuario_a_no_seguir);
		 	break;
		}	
		case "Perfil":{
		
			String nickname = (String)request.getParameter("nickname");
			Fabrica fabrica=Fabrica.getInstance();
			IUsuarioCtrl interfazUsuarios = fabrica.getIUsuarioCtrl();
			
			
			System.out.println("estoy yendo a consultar a " + nickname );
			DtCanal infoCanal = interfazUsuarios.mostrarInfoCanal(nickname);
			DtUsuario usuario = interfazUsuarios.listarDatosUsuario(nickname);
			request.setAttribute("dataCanal", infoCanal);
			request.setAttribute("dataUsuario", usuario);
			
			DtListaReproduccion[] listas = interfazUsuarios.infoLDRdeUsuario(nickname, Privacidad.PUBLICO);
		    DtVideo[] videos = interfazUsuarios.infoVideosCanal(nickname, Privacidad.PUBLICO);
	        HttpSession session=request.getSession(false);
	        if(session!=null) {
	            String login=(String)session.getAttribute("nombre_usuario");
	            if(login!=null) {
	                System.out.println("hay un usuario logueado");
	                String [] usrQueSigue = interfazUsuarios.listarUsuariosQueSigue(login);
	                boolean loSigue = false;
	                int i=0;
	                while((i<usrQueSigue.length) && (loSigue==false)){
	                    if( usrQueSigue[i].equals(nickname)) {loSigue=true;}
	                	i++;
	                }
	                System.out.println(login+"sigue a?"+nickname+"  "+loSigue);
	                request.setAttribute("usrSigueAlOtro", loSigue);
	                if(login.equals(nickname)){
	                	//request.setAttribute("duenioCanal", true);
		                DtVideo[] videosPrivadosSesion=interfazUsuarios.infoVideosCanal(login, Privacidad.PRIVADO); //videos privados del usuario logeado
		                DtListaReproduccion[] listasPrivadasSesion=interfazUsuarios.infoLDRdeUsuario(login, Privacidad.PRIVADO); //listas privadas del usr log
		                List<DtVideo> videosAux= new ArrayList<DtVideo>(Arrays.asList(videos));
		                videosAux.addAll(Arrays.asList(videosPrivadosSesion));
		                videos=videosAux.toArray(new DtVideo[0]);
		                List<DtListaReproduccion> listasAux = new ArrayList<DtListaReproduccion>(Arrays.asList(listas));
		                listasAux.addAll(Arrays.asList(listasPrivadasSesion));
		                listas=listasAux.toArray(new DtListaReproduccion[0]);
	                }
	             }
	        }
	        String parametroListas="listas";
	        String parametroVideos="videos";

	        request.setAttribute(parametroListas, listas);
	        request.setAttribute(parametroVideos, videos);
	        request.setAttribute("duenioCanal", false);
	        
	        if(session!=null){
	        	String login=(String)session.getAttribute("nombre_usuario");
	       		if(login!=null) {
	       			if(login.equals(nickname)){ request.setAttribute("duenioCanal", true); }
	        	 	request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuarioLogeado.jsp").forward(request, response);
	       		}else{
	       		 	request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuario.jsp").forward(request, response);
	       		}
	        }else{
	         	request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuario.jsp").forward(request, response);
	        }
			break;
		}
		case "responderComentario":{
			HttpSession session=request.getSession(false);{
			}
            if(session!=null && session.getAttribute("nombre_usuario")!=null) {
    			int id_video = Integer.parseInt(request.getParameter("id_video"));
    			int id_comentario = Integer.parseInt(request.getParameter("id_comentario"));
    			String contenido = request.getParameter("contenido");
    			String comentador = (String)session.getAttribute("nombre_usuario");
    			Fabrica fabricaControladores = Fabrica.getInstance();
    			IVideoCtrl vidController = fabricaControladores.getIVideoCtrl();
    			Date today = new Date();
    			DtFecha fechaHoy = new DtFecha(today);
    			vidController.responderComentario(id_video, id_comentario, comentador, fechaHoy, contenido);
    			System.out.println(id_video+"||"+id_comentario+"||"+comentador+"||"+fechaHoy+"||"+contenido);
            }
			break;
		}
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = (String) request.getParameter("opcion");
		System.out.println(opcion);
		switch (opcion) {
		case "login" :{
			Fabrica fabrica=Fabrica.getInstance();
			IUsuarioCtrl UsuarioController = fabrica.getIUsuarioCtrl();
			System.out.println("estoy probando con:");
			System.out.println(request.getParameter("nickInicio"));
			System.out.println(request.getParameter("passInicio"));
			if(UsuarioController.verificarLogin(request.getParameter("nickInicio"), request.getParameter("passInicio"))) {
				System.out.println("existe el usuario con esa contrase�a");
				HttpSession sesion= request.getSession(true);
				sesion.setAttribute("nombre_usuario", request.getParameter("nickInicio"));
				response.sendRedirect(request.getContextPath() + "/home");
			}else {
				System.out.println("no existe el usuario con esa contrase�a");
				request.setAttribute("error", "Se produjo un error en el ingreso de datos");
				doGet(request,response);
			}
			break;
		}
		case "checkLogin" :{
			
			String nomUsu=(String)request.getSession().getAttribute("nombre_usuario");
			System.out.println("el usuario logueado es " + nomUsu);
			if(nomUsu==null) {
				response.getWriter().append("<a href='login?opcion=login'>Iniciar Sesion</a>   ");
				response.getWriter().append("<a href='newUser?opcion=nuevoUsuario'>Nuevo Usuario</a>");
			}else {
				response.getWriter().append("<a href='login?opcion=logout'>Cerrar Sesion</a>");
				response.getWriter().append("<a href='profile?opcion=Perfil&nickname="+URLEncoder.encode(nomUsu,"UTF-8")+"'>Hola, "+nomUsu+"</a>");
				
			}
			break;
		}
		case "checkLoginSidebar" :{
			System.out.println("estoy en chekloginsidebar");
			String nomUsu=(String)request.getSession().getAttribute("nombre_usuario");
			if(nomUsu==null) {
			
			}else {
				response.getWriter().append("<a href=\"newVideo?opcion=altaVideo\">Nuevo Video</a>");
				response.getWriter().append("<a href=\"newPlaylist?action=nuevaLDR\">Nueva Lista</a>");
			}
			
			break;
		}
		case "follow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_seguir = (String) request.getAttribute("usuario_a_seguir");
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
			break;
		}
		case "checkDispUsr":{
			String nick = URLDecoder.decode(request.getParameter("nickname"), "UTF-8");
			System.out.println(nick);
			Fabrica fabrica = Fabrica.getInstance();
			IUsuarioCtrl usuarioCtrl = fabrica.getIUsuarioCtrl();
			boolean disponible=usuarioCtrl.verificarDispUsuario(nick, (String)request.getParameter("email"));
    		if(!disponible){
    			response.getWriter().print("el nick y/o email estan ocupados"); 
    	  	}
		break;	
		}
		case "nuevoUsuario":{
			
			break;
			
		}
		}
		}
	
}