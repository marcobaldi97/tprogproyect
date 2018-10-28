package uytubeLogica.publicar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.DtCanal;
import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.DtFecha;
import uytubeLogic.logica.DtListaReproduccion;
import uytubeLogic.logica.DtUsuario;
import uytubeLogic.logica.DtVideo;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IUsuarioCtrl;
import uytubeLogic.logica.IVideoCtrl;
import uytubeLogic.logica.SystemHandler.Privacidad;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServices {

    private Endpoint endpoint = null;
    public WebServices(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    } //VERIFICAR PUERTO

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    @WebMethod
    public void operacionPrueba(){
    	System.out.println("LLAMADO A FUNC DEL WEB SERVICE");    }
    @WebMethod
    public void cargarDatos() {
    	DatosDePrueba dp= new DatosDePrueba();
    	dp.cargarDatosDePrueba();
    }
    @WebMethod
    public DtCategoria[] listarCategorias() {
    	Fabrica fab=Fabrica.getInstance();
    	IVideoCtrl IVI = fab.getIVideoCtrl();
    	return IVI.listarCategorias();
    }
    
    @WebMethod
    public DtVideo[] listarVideoListaReproduccion(String propietario, String nombreLista) {
    	Fabrica fabrica=Fabrica.getInstance();
    	IUsuarioCtrl usuarioCtrl=fabrica.getIUsuarioCtrl();
    	DtVideo[] videosLista=usuarioCtrl.obtenerDtsVideosListaReproduccionUsuario(propietario, nombreLista);
    	return videosLista;
    }
    
    @WebMethod
    public DtListaReproduccion infoListaReproduccion(String propietario, String nombreLista) {
    	Fabrica fabrica=Fabrica.getInstance();
    	IUsuarioCtrl usuarioCtrl=fabrica.getIUsuarioCtrl();
    	DtListaReproduccion infoLista=usuarioCtrl.infoAdicLDR(propietario, nombreLista);
    	return infoLista;
    }   
    
    @WebMethod
    public DtVideo[] listarVideosPorCategoria(String nomCategoria,Privacidad priv, String login) {
    	Fabrica fab=Fabrica.getInstance();
    	IVideoCtrl IVI = fab.getIVideoCtrl();
    	return IVI.listarVideosPorCategoria(nomCategoria, priv, login);
    }
    
    @WebMethod
    public DtListaReproduccion[] listarLDRPorCategoria(String nomCategoria,Privacidad priv, String login) {
    	Fabrica fab=Fabrica.getInstance();
    	IVideoCtrl IVI = fab.getIVideoCtrl();
    	return IVI.listarLDRPorCategoria(nomCategoria, priv, login);
    }
    
    @WebMethod
    public DtVideo[] listarVideosPublicosPorNombre(String nombre) {
    	Fabrica fab=Fabrica.getInstance();
    	IVideoCtrl IVI = fab.getIVideoCtrl();
    	return IVI.listarVideosPublicosPorNombre(nombre);
    }
    
    @WebMethod
    public DtCanal[] listarCanalesPublicosPorNombre(String nombre) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarCanalesPublicosPorNombre(nombre);
    }
    
    @WebMethod
    public DtListaReproduccion[] listarLDRPublicasPorNombre(String nombre) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarLDRPublicasPorNombre(nombre);
    }
    
    @WebMethod
    public DtVideo[] infoVideosCanal(String filtro, String login, Privacidad priv) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.infoVideosCanal(filtro, login, priv);
    }
    
    @WebMethod
    public DtListaReproduccion[] infoLDRdeUsuario(String filtro, String login, Privacidad priv) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.infoLDRdeUsuario(filtro, login, priv);
    }
    
    @WebMethod
    public DtCanal mostrarInfoCanal(String nickname) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.mostrarInfoCanal(nickname);
    }
    
    @WebMethod
    public DtUsuario listarDatosUsuario(String nickname) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarDatosUsuario(nickname);
    }
    
    @WebMethod
    public String[] listarUsuariosQueLeSigue(String nickname) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarUsuariosQueLeSigue(nickname);
    }
    
    @WebMethod
    public String[] listarUsuariosQueSigue(String nickname) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarUsuariosQueSigue(nickname);
    }
    
    @WebMethod
    public String[] listarLDRdeUsuario(String nickname) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.listarLDRdeUsuario(nickname);
    }
    @WebMethod
    public void responderComentario(Integer id_video, Integer id_comentario, String comentador, DtFecha fechaHoy, String contenido) {
    	Fabrica fab=Fabrica.getInstance();
    	IVideoCtrl IVI = fab.getIVideoCtrl();
    	IVI.responderComentario(id_video, id_comentario, comentador, fechaHoy, contenido);
    }
    
    @WebMethod
    public boolean verificarLogin(String nick, String pass) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.verificarLogin(nick, pass);
    }
    
    @WebMethod
    public void seguirUsuario(String nombre_usuario, String usuario_a_seguir) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	IUI.seguirUsuario(nombre_usuario, usuario_a_seguir);
    }
    
    @WebMethod
    public void dejarUsuario(String nombre_usuario, String usuario_a_no_seguir) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	IUI.dejarUsuario(nombre_usuario, usuario_a_no_seguir);
    }
    
    @WebMethod
    public boolean verificarDispUsuario(String nick, String email) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	return IUI.verificarDispUsuario(nick, email);
    }
    
    @WebMethod
    public void nuevoUsuario(String nickname,String contrasenia,String nombre,String apellido,String email,DtFecha dtFechaNac,byte[] foto,String nomCanal,
			String descripcion, Privacidad priv,String categoria) {
    	Fabrica fab=Fabrica.getInstance();
    	IUsuarioCtrl IUI = fab.getIUsuarioCtrl();
    	IUI.nuevoUsuario(nickname, contrasenia, nombre, apellido, email, dtFechaNac, foto, nomCanal,
    			descripcion, priv, categoria);
    }
    
}
