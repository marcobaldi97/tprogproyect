package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet({"/login","/newUser","/profile","/modifyUser","/follow"})
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
	private void nuevoUsuario(String nickname,String pass, String email, String nombre, String apellido, String contrasenia, String contraseniaConfir, String fechaNac, String foto,String nomCanal, String descripcion, String privacidad, String categoria){
		System.out.println("OKK");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = (String) request.getParameter("opcion");
		switch (opcion) {
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
		/*case "nuevoUsuario":{
			HttpSession session=request.getSession();
			nuevoUsuario((String)session.getAttribute("nickname"),(String)session.getAttribute("email"),(String)session.getAttribute("nombre"),
					(String)session.getAttribute("apellido"),(String)session.getAttribute("contrasenia"),(String)session.getAttribute("contraseniaConfirmacion"),
					(String)session.getAttribute("fecha_nacimiento"),(String)session.getAttribute("filename"),(String)session.getAttribute("nombre_canal"),
					(String)session.getAttribute("descripcion"),(String)session.getAttribute("privacidad"),(String)session.getAttribute("categoria"));
		}*/
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opcion = (String) request.getParameter("opcion");
		switch (opcion) {
		case "login" :{
			Fabrica fabrica=Fabrica.getInstance();
			IUsuarioCtrl UsuarioController = fabrica.getIUsuarioCtrl();
			System.out.println("estoy probando con:");
			System.out.println(request.getParameter("nickInicio"));
			System.out.println(request.getParameter("passInicio"));
			if(UsuarioController.verificarLogin(request.getParameter("nickInicio"), request.getParameter("passInicio"))) {
				System.out.println("existe el usuario con esa contraseña");
				HttpSession sesion= request.getSession(true);
				sesion.setAttribute("nombre_usuario", request.getParameter("nickInicio"));
				response.sendRedirect(request.getContextPath() + "/home");
			}else {
				System.out.println("no existe el usuario con esa contraseña");
				request.setAttribute("error", "Se produjo un error en el ingreso de datos");
				doGet(request,response);
			}
			break;
		}
		case "checkLogin" :{
			String nomUsu=(String)request.getSession().getAttribute("nombre_usuario");
			if(nomUsu==null) {
				response.getWriter().append("<a href='login?opcion=login'>Iniciar Sesion</a>");
			}else
				response.getWriter().append("<a href='login?opcion=logout'>Cerrar Sesion</a>");
			break;
		}
		case "follow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_seguir = (String) request.getAttribute("usuario_a_seguir");
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
			break;
		}
		}
	}

}
