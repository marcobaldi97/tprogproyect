package uytubeWeb.servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;




/**
 * Servlet implementation class VideoServlet
 */
@WebServlet(name="VideoServlet",urlPatterns={"/watch","/newVideo","/modifyVideo","/likeVideo","/dislikeVideo","/newComment","/newResponse"})
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void creaUsrPrueba(){
    	   Fabrica fabrica = Fabrica.getInstance();
     	   IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
		Date fecha = ParseFecha("25/02/1962");
		DtFecha fechaNac = new DtFecha(fecha);
		String HR="hrubio";
		usrCtrl.nuevoUsuario("horacio", "Horacio", "Rubino", "horacio.rubino@guambia.com.uy", fechaNac, null,
				"Canal Horacio", "El canal Horacio es para publicar contenido divertido",Privacidad.PUBLICO, "Entretenimiento");
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
    private void crearVideo(String nomVideo, String duracion, String url, String fecha, String categoria, String descripcionV, HttpServletResponse response ){
       Fabrica fabrica = Fabrica.getInstance();
 	   IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
 	   IVideoCtrl ICV = fabrica.getIVideoCtrl();
 	   creaUsrPrueba();
 	   DtFecha fechaPublicacionV= new DtFecha(ParseFecha(fecha));
 	   DtCategoria catV = new DtCategoria(categoria);
 	   usrCtrl.aniadirVideo("horacio", nomVideo, descripcionV,(Integer.parseInt(duracion)), fechaPublicacionV, url, catV, Privacidad.PUBLICO);
	   try {
		response.sendRedirect("/UyTubeWeb/AltaVideo.jsp");
	   } catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
 	 
    }
    private void verVideo(DtVideo dataVideo) {
    	
    }
    private void valorarVideo(int id_video, String nombre_usuario, boolean like) {
		Fabrica fabrica = Fabrica.getInstance();
	 	IVideoCtrl interfaz_video = fabrica.getIVideoCtrl();
    	interfaz_video.valorarVideo(id_video,nombre_usuario,like);
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
					request.getParameter("fechaVideo"),request.getParameter("categoria"),request.getParameter("descVideo"),response);
		break;
		case "null":
		break;
		case "likeVideo":{
			System.out.println("Quiero darle me gusta a un video");
			HttpSession session=request.getSession();
		 	Integer id_video = (int) request.getAttribute("id_video");
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	valorarVideo(id_video,nombre_usuario,true);
		 	break;
		}
		case "dislikeVideo":{
			System.out.println("Quiero darle no me gusta a un video");
			HttpSession session=request.getSession();
		 	Integer id_video = (int) request.getAttribute("id_video");
		 	String nombre_usuario = (String)session.getAttribute("nombre_usuario");
		 	valorarVideo(id_video,nombre_usuario,false);
		 	break;
		}
		case "ver":{
			System.out.println("Quiero ver un video");
			Fabrica fabricaControladores=Fabrica.getInstance();
			IVideoCtrl VidController=fabricaControladores.getIVideoCtrl();
			DtVideo dataVideo=VidController.infoAddVideo(Integer.parseInt(request.getParameter("ID")));
			request.setAttribute("dataVideo", dataVideo);
			request.getRequestDispatcher("VerVideo.jsp").forward(request, response);
			break;
		}
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
