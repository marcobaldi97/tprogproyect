package uytubeWeb.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private void nuevoUsuario(String nickname, String email, String nombre, String apellido, String contrasenia, String contraseniaConfir, String fechaNac, String foto,String nomCanal, String descripcion, String privacidad, String categoria){
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
		case "follow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_seguir = (String) request.getAttribute("usuario_a_seguir");
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
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
			if(UsuarioController.verificarLogin(request.getParameter("nickInicio"), "passInicio")) {
				HttpSession sesion= request.getSession(true);
				
				
				sesion.setAttribute("nombre_usuario", request.getParameter("nickInicio"));
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
		}
	}

}
