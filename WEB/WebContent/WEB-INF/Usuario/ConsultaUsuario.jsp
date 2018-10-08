<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page import = "uytubeLogic.logica.DtFecha"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@page import="uytubeLogic.logica.DtListaReproduccion"%>
<%@ page import = "uytubeLogic.logica.DtUsuario"%>
<%@ page import = "uytubeLogic.logica.Fabrica"%>
<%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Base64"%>
<%@ page import = "java.util.Date"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@include file = "../cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" type="text/css" href="media/styles/ConsultaUsuario.css"/>
	<script type="text/javascript" src="scriptPestanias.js">activarTab()</script>
	
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
	int anio = fechaNac.getYear()  + 1900;
	byte[] foto = dataUsuario.getFoto();
	DtCanal dataCanal = (DtCanal) request.getAttribute("dataCanal");
	String nombre_canal = dataCanal.getNombre();
	String descCanal= dataCanal.getDescripcion();
	String categoriaCanal=dataCanal.getCategoria().getNombre();
	   //estos son los datos que tienen que ver con el usuario propietario y el video en sí.
	   byte[] fotoByte = dataUsuario.getFoto();
		String urlFoto = "";
		if(fotoByte != null){
			Base64.Encoder encoder = Base64.getEncoder();
			String fotoString = encoder.encodeToString(fotoByte);
			urlFoto = "data:image/png;base64,"+ fotoString;
		}
	Fabrica fabrica = Fabrica.getInstance();
	IUsuarioCtrl usrCtr = fabrica.getIUsuarioCtrl();
	String [] seguidores = usrCtr.listarUsuariosQueLeSigue(nick);
	String [] seguidos = usrCtr.listarUsuariosQueSigue(nick);
	
	String[] listasReproduccion = usrCtr.listarLDRdeUsuario(nick);
	
	%>

<%@include file="../buscador.jsp" %>
 <div class="main-container">
    <%@include file="../sidebar.jsp" %>
    <div class="main-content">
 <div id="contenedor">
	<div id="usrDatos">
	<table width="80%" id="usrDatosTable">
		<tr>
		<td><img id="logo" src=<%=urlFoto%> width="100px" height="70px"></img><br></td>
		<td>
			<h3> <%=nick%> </h3> <br>
			<%=descCanal%>
		</td>
		
		</tr>
		<tr>
		<td>Seguidores: <%=seguidores.length %></td>
		<td>Seguidos: <%=seguidos.length %></td>
		</tr>
	</table>
	</div>
 <table class="tabs" data-min="0" data-max="3" width="80%">
    <tr>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-0" onclick="activarTab(this)">Datos Personales</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-1" onclick="activarTab(this)">Videos</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-2" onclick="activarTab(this)">Listas de Reproduccion</th>
        <th class="tabck" id="tabck-3" onclick="activarTab(this)">Seguidores y Seguidos</th>
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
            </div>
            <div class="tabdiv" id="tabdiv-3">
	        	Seguidores
	        	<%
				for(String seguidoresUsr: seguidores){
				%>
					 <ul>
						<li><a href="profile?opcion=Perfil&nickname=<%=seguidoresUsr%>"><%=seguidoresUsr%> </a></li>
						
					</ul>
				<%
				}	        	
	        	%>   
	        	Seguidos
	        	<%for(String seguidosUsr: seguidos){
				%>
					 <ul>
						<li><a href="profile?opcion=Perfil&nickname=<%=seguidosUsr%>"><%=seguidosUsr%> </a></li>
					</ul>
				<%
				}
	        	
	        	%>   
            </div>
            <div class="tabdiv" id="tabdiv-1">
                Videos del canal del usuario
                <table id="TablaContenidos2">
					<tr>
					<th valign="top"> Nombre </th>
					<th valign="top"> Descripcion </th>
					<th valign="top"> </th>
					</tr>
                	</tr>
						<%
						DtVideo[] vid = (DtVideo[]) request.getAttribute("videos");
						for (DtVideo entry : vid) {
							String nombreV=entry.getNombre();
							String descV=entry.getDescripcion();
							String propietarioV = entry.getPropietario();
							request.setAttribute("IDVideo", entry.getIDVideo().toString());
							request.setAttribute(nombreV, nombreV);
						%>
					<tr class="videoRow">
					<td id="NombreTD"><%=nombreV%></td>
					<td id="DescripcionTD"><%=descV %></td>
					<td>
					<form action="watch" method="get"> 
					<input type="hidden" name="opcion" value="ver">
					<input type="hidden" name="ID" value="<%=entry.getIDVideo()%>">
					<input type="submit" value="Ver Ahora"> </form> 
					</td>
					</tr>
					<% } %>
					</table>
            </div>
            <div class="tabdiv" id="tabdiv-2">
               Listas de reproduccion
           
				<table id="TablaContenidos">
					<tr>
					<th valign="top"> Nombre </th>
					<th valign="top"> Descripcion </th>
					<th valign="top"> </th>
					</tr>
						<%
						if(request.getAttribute("listas")!=null){
							DtListaReproduccion[] listas=(DtListaReproduccion[]) request.getAttribute("listas");
							for(DtListaReproduccion entry: listas){%>
						<tr class="listaRow">
				
						</td>
						<td id="NombreTD"><%=entry.getNombre()%></td>
						<td id="DescripcionTD"></td>
						<td>
						<form action="playlist" method="get"> 
						<input type="hidden" name="action" value="details">
						<input type="hidden" name="nameList" value="<%=entry.getNombre() %>">
						<input type="hidden" name="ownerList" value="<%=entry.getPropietario() %>">
						<input type="submit" value="Ver Info"> </form> 
						</td>
						</tr>
						
						<%	}
						}
						
						%>
						
					</table>
	            </div>
        </td>
    </tr>   
 </table>
 

 </div>
 </div>
 </div>
 </body>


</html>