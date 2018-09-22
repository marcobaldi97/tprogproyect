package uytubeWeb.servlets;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;




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
    private void crearVideo(String nomVideo, String duracion, String url, String fecha, String categoria, String descripcionV ){
       Fabrica fabrica = Fabrica.getInstance();
 	   IUsuarioCtrl usrCtrl = fabrica.getIUsuarioCtrl();
 	   IVideoCtrl ICV = fabrica.getIVideoCtrl();
 	   creaUsrPrueba();
 	   ICV.crearCategoria(categoria); //crea la categoria para que no haya problemas
 	   DtFecha fechaPublicacionV= new DtFecha(ParseFecha(fecha));
 	   DtCategoria catV = new DtCategoria(categoria);
 	   usrCtrl.aniadirVideo("horacio", nomVideo, descripcionV,(Integer.parseInt(duracion)), fechaPublicacionV, url, catV, Privacidad.PUBLICO);
 	   Boolean ok=  usrCtrl.memberVideoEnUsuario("horacio",nomVideo);
 	   if(ok){
 		   System.out.println("OKKKK");
 	   }
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
					request.getParameter("fechaVideo"),request.getParameter("categoria"),request.getParameter("descVideo"));
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
