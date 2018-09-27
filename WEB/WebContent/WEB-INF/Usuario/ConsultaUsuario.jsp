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
	<link rel="stylesheet" type="text/css" href="../media/styles/ConsultaUsuario.css"/>
    <script type="text/javascript" src="scriptPestanias.js">activarTab(unTab)</script>
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
	
 <div id="contenedor">
	<div id="usrDatos">
	<table width="80%" id="usrDatosTable">
		<tr>
		<td><img id="fotoUsr" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRrBaBrL0HSQ4XIEXnI_6S75eIW7r1OqZpNadTC_6QavMI2M4Tx" width="100px" height="70px"></td>
		<td>NICK</td>
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
  
</body>
</html>