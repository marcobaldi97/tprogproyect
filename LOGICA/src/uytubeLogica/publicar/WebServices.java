package uytubeLogica.publicar;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import uytube.datosPrueba.DatosDePrueba;
import uytubeLogic.logica.DtCategoria;
import uytubeLogic.logica.Fabrica;
import uytubeLogic.logica.IVideoCtrl;

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
}
