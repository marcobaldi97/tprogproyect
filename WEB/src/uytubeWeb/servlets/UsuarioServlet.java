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
	private void nuevoUsuario(String nickname, String email, String nombre, String apellido, String contrasenia, String contraseniaConfir, String fechaNac, String foto,String nomCanal, String descripcion, String privacidad, String categoria){
		Fabrica fabrica = Fabrica.getInstance();
     	IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
   		DtFecha dtFechaNac = new DtFecha(ParseFecha(fechaNac));
		Privacidad priv;
		if (privacidad=="PRIVADO"){ priv=Privacidad.PRIVADO;}
		else{priv = Privacidad.PUBLICO;}
		usrCtrl.nuevoUsuario(nickname,contrasenia,nombre,apellido,email, dtFechaNac, null,
				nomCanal,descripcion,priv,categoria);
		//FALTA INSERTAR FOTO y CONTROLAR CONTRASEÑA
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
		case "follow":{
			HttpSession session=request.getSession();
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	String usuario_a_seguir = (String) request.getAttribute("usuario_a_seguir");
		 	seguirUsuario(nombre_usuario, usuario_a_seguir);
			break;
		}	
		case "nuevoUsuario":{
			//HttpSession session=request.getSession();
			nuevoUsuario((String)request.getParameter("nickname"),(String)request.getParameter("email"),(String) request.getParameter("nombre"),
					(String)request.getParameter("apellido"),(String)request.getParameter("contrasenia"),(String)request.getParameter("contraseniaConfirmacion"),
					(String)request.getParameter("fecha_nacimiento"),(String)request.getParameter("filename"),(String)request.getParameter("nombre_canal"),
					(String)request.getParameter("descripcion"),(String)request.getParameter("privacidad"),(String)request.getParameter("categoria"));
		
			Fabrica fabrica = Fabrica.getInstance();
	     	IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
			DtUsuario usr= usrCtrl.listarDatosUsuario((String)request.getParameter("nickname"));
			request.setAttribute("dataUsuario", usr);
			request.getRequestDispatcher("WEB-INF/Usuario/ConsultaUsuario.jsp").forward(request, response);
		}
	
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
				response.getWriter().append("se produjo un error en el login");
				doGet(request,response);
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