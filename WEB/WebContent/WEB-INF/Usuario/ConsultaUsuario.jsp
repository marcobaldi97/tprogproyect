<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page import = "uytubeLogic.logica.DtFecha"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page import = "uytubeLogic.logica.DtUsuario"%>
<%@ page import = "uytubeLogic.logica.Fabrica"%>
<%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@include file = "../cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" type="text/css" href="media/styles/ConsultaUsuario.css"/>
	<script type="text/javascript" src="../Usuario/scriptPestanias.js">activarTab()</script>
	
    <title>Consulta Usuario</title>
</head>
<body>
<% 
	DtUsuario dataUsuario = (DtUsuario) request.getAttribute("dataUsuario");
	String nick = dataUsuario.getNickname();
	String nombre = dataUsuario.getNombre();
	String apellido = dataUsuario.getApellido();
	Date fechaNac = dataUsuario.getFechaNacimiento().getFecha();
	int dia = fechaNac.getDay();
	int mes = fechaNac.getMonth();
	int anio = fechaNac.getYear();
	byte[] foto = dataUsuario.getFoto();
	DtCanal dataCanal = (DtCanal) request.getAttribute("dataCanal");
	String nombre_canal = dataCanal.getNombre();
	String descCanal= dataCanal.getDescripcion();
	String categoriaCanal=dataCanal.getCategoria().getNombre();
	   //estos son los datos que tienen que ver con el usuario propietario y el video en sí.
	%>

<%@include file="../buscador.jsp" %>
 <div class="main-container">
    <%@include file="../sidebar.jsp" %>
    <div class="main-content">
 <div id="contenedor">
	<div id="usrDatos">
	<table width="80%" id="usrDatosTable">
		<tr>
		<td><img id="fotoUsr" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrBaBrL0HSQ4XIEXnI_6S75eIW7r1OqZpNadTC_6QavMI2M4Tx" width="100px" height="70px"></td>
		<td><%=nick%></td>
		</tr>
		<tr>
		<td>Cant. Seguidores</td>
		<td>Cant. Seguidos</td>
		<td><button id="botonSeguir" value="Seguir" onclick="msg()">Seguir</button></td>		
		</tr>
	</table>
	</div>
 <table class="tabs" data-min="0" data-max="2" width="80%">
    <tr>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-0" onclick="activarTab(this)">Datos Personales</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-1" onclick="activarTab(this)">Videos</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-2" onclick="activarTab(this)">Listas de Reproduccion</th>
    </tr>
    <tr class="filadiv">
        <td colspan="6" id="tab-0">
            <div class="tabdiv" id="tabdiv-0">
            <h3>Datos Usuario</h3><br>
            Nombre: <%=nombre%><br>
            Apellido:<%=apellido%><br>
            Fecha Nacimiento:<%=dia %>/<%=mes%>/<%=anio%><br>
            <h3>Datos Canal</h3><br>
         	Nombre:<%=nombre_canal %> <br>
            Descripcion:<%=descCanal %><br>
            Categoria:<%=categoriaCanal %><br>
            	  (si es del usurio logeado puede modificar sus datos)
            </div>
            <div class="tabdiv" id="tabdiv-1">
                Videos del canal del usuario
                (cuando selecciona un video, ir a consulta video)
                (si es del usurio logeado puede modificar sus datos)
            </div>
            <div class="tabdiv" id="tabdiv-2">
                Listas de reproduccion
                (como consulta de lista)
                (si es del usurio logeado puede modificar sus datos)
            </div>
        </td>
    </tr>   
 </table>
 </div>
 </div>
 </div>
 </body>
<script>
window.onload = function() {
    activarTab(document.getElementById("tabck-0"));
}; //al cargar salga abierta la primera pestaña
function activarTab(unTab) {


try {
    //Los elementos div de todas las pestañas están todos juntos en una
    //única celda de la segunda fila de la tabla de estructura de pestañas.
    //Hemos de buscar la seleccionada, ponerle display block y al resto
    //ponerle display none.
    var id = unTab.id;
    if (id){
        var tr = unTab.parentNode || unTab.parentElement;
        var tbody = tr.parentNode || tr.parentElement;
        var table = tbody.parentNode || tbody.parentElement;
        //Pestañas en varias filas
        if (table.getAttribute("data-filas")!=null){
            var filas = tbody.getElementsByTagName("tr");
            var filaDiv = filas[filas.length-1];
            tbody.insertBefore(tr, filaDiv);
        }
        //Para compatibilizar con la versión anterior, si la tabla no tiene los
        //atributos data-min y data-max le ponemos los valores que tenían antes del
        //cambio de versión.
        var desde = table.getAttribute("data-min");
        if (desde==null) desde = 0;
        var hasta = table.getAttribute("data-max");
        if (hasta==null) hasta = MAXTABS;
        var idTab = id.split("tabck-");
        var numTab = parseInt(idTab[1]);
        //Las "tabdiv" son los bloques interiores mientras que los "tabck"
        //son las pestañas.
        var esteTabDiv = document.getElementById("tabdiv-" + numTab);
        for (var i=desde; i<=hasta; i++) {
            var tabdiv = document.getElementById("tabdiv-" + i);
            if (tabdiv) {
                var tabck = document.getElementById("tabck-" + i);
                if (tabdiv.id == esteTabDiv.id) {
                    tabdiv.style.display = "block";
                    tabck.style.color = "slategrey";
                    tabck.style.borderBottomColor = "rgb(235, 235, 225)";
                } else {
                    tabdiv.style.display = "none";
                    tabck.style.color = "black";
                    tabck.style.borderBottomColor = "gray";
                }
            }
        }
    }
} catch (e) {
    alert("Error al activar una pestaña. " + e.message);
}
}
</script>

</html>