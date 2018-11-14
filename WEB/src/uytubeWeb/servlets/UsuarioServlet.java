package uytubeWeb.servlets;


import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import uytubeLogica.publicar.DtCanal;
import uytubeLogica.publicar.DtFecha;
import uytubeLogica.publicar.DtListaReproduccion;
import uytubeLogica.publicar.DtUsuario;
import uytubeLogica.publicar.DtVideo;
import uytubeLogica.publicar.DtVideoHistorial;
import uytubeLogica.publicar.Privacidad;



/**
 * Servlet implementation class UsuarioServlet
 */

public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 45L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void seguirUsuario(String nombre_usuario, String usuario_a_seguir) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		port.seguirUsuario(nombre_usuario, usuario_a_seguir);
	}
	private void dejarUsuario(String nombre_usuario, String usuario_a_no_seguir) {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
	    port.dejarUsuario(nombre_usuario, usuario_a_no_seguir);
	}

  
 
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		response.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String opcion = (String) request.getParameter("opcion");
		switch (opcion) {
		case "null":
		break;
		case "login" :{
				System.out.println("me voy pal login");
				request.getRequestDispatcher("WEB-INF/Usuario/LoginMobile.jsp").forward(request, response);
			
			break;
		}
		case "logout" :{
			System.out.println("estoy cerrando sesion");
			request.getSession(false).removeAttribute("nombre_usuario");
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/casa");
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
		
		case "historial":{
			HttpSession session=request.getSession();
			if(session!=null)
			{
                String login=(String)session.getAttribute("nombre_usuario");
                if(login!=null)
                {
                	DtVideoHistorial[] historial=port.listarVideoHistorial(login).getItem().toArray(new DtVideoHistorial[0]);
                	request.setAttribute("historial", historial);
                	request.getRequestDispatcher("WEB-INF/Lista Reproduccion/historialVisitas.jsp").forward(request, response);
                }
                else
                {
                	response.sendRedirect(request.getContextPath() + "/casa");
                }
                	
             }
             else
             {
                response.sendRedirect(request.getContextPath() + "/casa");
             }
			break;	
		}
		
		case "Perfil":{
		
			String nickname = (String)request.getParameter("nickname");			
			
			System.out.println("estoy yendo a consultar a " + nickname );
			DtCanal infoCanal = port.mostrarInfoCanal(nickname);
			DtUsuario usuario = port.listarDatosUsuario(nickname);
			request.setAttribute("dataCanal", infoCanal);
			request.setAttribute("dataUsuario", usuario);
			
		 	
	    	String [] seguidores = port.listarUsuariosQueLeSigue(nickname).getItem().toArray(new String[0]);
	    	String [] seguidos = port.listarUsuariosQueSigue(nickname).getItem().toArray(new String[0]);	    	
	    	String[] listasReproduccion = port.listarLDRdeUsuario(nickname).getItem().toArray(new String[0]);
	      
	    	request.setAttribute("dataSeguidores", seguidores);
	    	request.setAttribute("dataSeguidos",seguidos);
	    	request.setAttribute("dataListasReproduccion",listasReproduccion);
			
			DtListaReproduccion[] listas = port.infoLDRdeUsuario("", nickname, Privacidad.PUBLICO).getItem().toArray(new DtListaReproduccion[0]);
		    DtVideo[] videos = port.infoVideosCanal("", nickname, Privacidad.PUBLICO).getItem().toArray(new DtVideo[0]);
	        HttpSession session=request.getSession(false);
	        if(session!=null) {
	            String login=(String)session.getAttribute("nombre_usuario");
	            if(login!=null) {
	                System.out.println("hay un usuario logueado");
	                String [] usrQueSigue = port.listarUsuariosQueSigue(login).getItem().toArray(new String[0]);
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
		                DtVideo[] videosPrivadosSesion=port.infoVideosCanal("", login, Privacidad.PRIVADO).getItem().toArray(new DtVideo[0]); //videos privados del usuario logeado
		                DtListaReproduccion[] listasPrivadasSesion=port.infoLDRdeUsuario("", login, Privacidad.PRIVADO).getItem().toArray(new DtListaReproduccion[0]); //listas privadas del usr log
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
    			Date today = new Date();
    			DtFecha fechaHoy = new DtFecha();
    			GregorianCalendar gcal = new GregorianCalendar();
    			gcal.setTime(today);
    		    XMLGregorianCalendar xgcal = null;
				try {
					xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			fechaHoy.setFecha(xgcal);
    			
    			port.responderComentario(id_video, id_comentario, comentador, fechaHoy, contenido);
    			System.out.println(id_video+"||"+id_comentario+"||"+comentador+"||"+fechaHoy+"||"+contenido);
            }
			break;
		}
		case "darBaja":{
			HttpSession session=request.getSession(false);
			System.out.println("Voy a dar de baja a " + (String)session.getAttribute("nombre_usuario"));
		    port.bajaUsuario((String)session.getAttribute("nombre_usuario"));
		    //cerrar la sesion
			request.getSession(false).removeAttribute("nombre_usuario");
			request.getSession().invalidate();
		    response.sendRedirect(request.getContextPath() + "/casa");
		break;
		}
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		uytubeLogica.publicar.WebServicesService service = new uytubeLogica.publicar.WebServicesService();
	    uytubeLogica.publicar.WebServices port = service.getWebServicesPort();
		// TODO Auto-generated method stub
		
		String opcion = (String) request.getParameter("opcion");
		System.out.println(opcion);
		switch (opcion) {
		case "login" :{
			System.out.println("estoy probando con:");
			System.out.println(request.getParameter("nickInicio"));
			System.out.println(request.getParameter("passInicio"));
			String encodedNick = new String(request.getParameter("nickInicio").getBytes("ISO-8859-1"), "UTF-8");
			String encodedPass = new String(request.getParameter("passInicio").getBytes("ISO-8859-1"), "UTF-8");
			System.out.println("o mejor con: "+encodedNick+" "+encodedPass+"?");
			if(port.verificarLogin(encodedNick, encodedPass)) {
				System.out.println("existe el usuario con esa contrase�a");
				HttpSession sesion= request.getSession(true);
				sesion.setAttribute("nombre_usuario", encodedNick);
				response.sendRedirect(request.getContextPath() + "/casa");
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
				response.getWriter().append("<li><a href='login?opcion=login'>Iniciar Sesion</a></li>   ");
				response.getWriter().append("<li><a href='newUser?opcion=nuevoUsuario'>Nuevo Usuario</a></li>");
			}else {
				response.getWriter().append("<li><a href='login?opcion=logout'>Cerrar Sesion</a></li>");
				response.getWriter().append("<li><a href='profile?opcion=darBaja'>Dar de Baja</a></li>");
				response.getWriter().append("<li><a href='profile?opcion=Perfil&nickname="+URLEncoder.encode(nomUsu,"UTF-8")+"'>Hola, "+nomUsu+"</a></li>");
				
			}
			break;
		}
		case "checkLoginSidebar" :{
			System.out.println("estoy en chekloginsidebar");
		      port.operacionPrueba();
			String nomUsu=(String)request.getSession().getAttribute("nombre_usuario");
			if(nomUsu==null) {
			
			}else {
				response.getWriter().append("<a href=\"history?opcion=historial\">Historial</a>");
				response.getWriter().append("<a href=\"newVideo?opcion=altaVideo\">Nuevo Video</a>");
				response.getWriter().append("<a href=\"newPlaylist?action=nuevaLDR\">Nueva Lista</a>");
			}
			
			break;
		}
		case "checkLoginBootstrap":{
			HttpSession session=request.getSession();
			if(session!=null && session.getAttribute("nombre_usuario")!=null) {
			 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
			 	response.getWriter().write("logged");
			}else {
				response.getWriter().write("not logged");;
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
			boolean disponible=port.verificarDispUsuario(nick, (String)request.getParameter("email"));
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