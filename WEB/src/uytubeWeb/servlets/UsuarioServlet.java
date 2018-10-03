package uytubeWeb.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet({"/login","/newUser","/profile","/modifyUser","/follow"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Object document;
       
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

  public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
	private void nuevoUsuario(String nickname,String pass, String email, String nombre, String apellido, String contrasenia, String contraseniaConfir, String fechaNac, String foto,String nomCanal, String descripcion, String privacidad, String categoria){
		Fabrica fabrica = Fabrica.getInstance();
     	IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
   		DtFecha dtFechaNac = new DtFecha(ParseFecha(fechaNac));
		Privacidad priv;
		if (privacidad=="PRIVADO"){ priv=Privacidad.PRIVADO;}
		else{priv = Privacidad.PUBLICO;}
		usrCtrl.nuevoUsuario(nickname,contrasenia,nombre,apellido,email, dtFechaNac, null,
				nomCanal,descripcion,priv,categoria);
		//FALTA INSERTAR FOTO y CONTROLAR CONTRASE�A

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
		 	String usuario_a_seguir = (String) request.getAttribute("usuario_a_seguir");
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
			break;
		}	
		case "nuevoUsuario":{
			System.out.println("nuevo usuario GET");
			request.getRequestDispatcher("WEB-INF/Usuario/AltaUsuario.jsp").forward(request, response);
			break;
		}
		case "Perfil":{
			String nickname = (String)request.getParameter("nickname");
			Fabrica fabrica=Fabrica.getInstance();
			IUsuarioCtrl UsuarioController = fabrica.getIUsuarioCtrl();
			System.out.println("estoy yendo a consultar a " + nickname);
			DtCanal infoCanal = UsuarioController.mostrarInfoCanal(nickname);
			DtUsuario usuario = UsuarioController.listarDatosUsuario(nickname);
			request.setAttribute("dataCanal", infoCanal);
			request.setAttribute("dataUsuario", usuario);
			request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuario.jsp").forward(request, response);
			
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
			if(nomUsu==null) {
				response.getWriter().append("<a href='login?opcion=login'>Iniciar Sesion</a>   ");
				response.getWriter().append("<a href='newUser?opcion=nuevoUsuario'>Nuevo Usuario</a>");
			}else
				response.getWriter().append("<a href='login?opcion=logout'>Cerrar Sesion</a>");
			break;
		}
		case "checkLoginSidebar" :{
			System.out.println("estoy en chekloginsidebar");
			String nomUsu=(String)request.getSession().getAttribute("nombre_usuario");
			if(nomUsu==null) {
			
			}else
				response.getWriter().append("<a href=\"newVideo?opcion=altaVideo\">nuevoVideo</a>");
			
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
			System.out.println((String)request.getParameter("nickname"));
			Fabrica fabrica = Fabrica.getInstance();
			IUsuarioCtrl usuarioCtrl = fabrica.getIUsuarioCtrl();
			boolean disponible=usuarioCtrl.verificarDispUsuario((String)request.getParameter("nickname"), (String)request.getParameter("email"));
    		if(!disponible){
    			response.getWriter().print("el nick y/o email estan ocupados"); 
    	  	}
		break;	
		}
		case "nuevoUsuario":{
			System.out.println((String)request.getParameter("nickname"));
			Fabrica fabrica = Fabrica.getInstance();
			IUsuarioCtrl usuarioCtrl = fabrica.getIUsuarioCtrl();
			boolean disponible=usuarioCtrl.verificarDispUsuario((String)request.getParameter("nickname"), (String)request.getParameter("email"));
			boolean passIguales =(String)request.getParameter("pass1")==(String)request.getParameter("pass2");
			if(disponible && passIguales){
    			nuevoUsuario((String)request.getParameter("nickname"),(String)request.getParameter("contrasenia"),(String)request.getParameter("email"),(String) request.getParameter("nombre"),
    					(String)request.getParameter("apellido"),(String)request.getParameter("contrasenia"),(String)request.getParameter("contraseniaConfirmacion"),
    					(String)request.getParameter("fecha_nacimiento"),(String)request.getParameter("filename"),(String)request.getParameter("nombre_canal"),
    					(String)request.getParameter("descripcion"),(String)request.getParameter("privacidad"),(String)request.getParameter("categoria"));
    		//	Fabrica fabrica = Fabrica.getInstance();
    	     	IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
    	       	DtCanal infoCanal = usrCtrl.mostrarInfoCanal((String)request.getParameter("nickname"));
    			DtUsuario usuario = usrCtrl.listarDatosUsuario((String)request.getParameter("nickname"));
    			request.setAttribute("dataCanal", infoCanal);
    			request.setAttribute("dataUsuario", usuario);
    			request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuario.jsp").forward(request, response);
        	}else{
        		response.getWriter().print("Compruebe los datos"); 
        	}
			break;
			
		}
		}
		}
	
}