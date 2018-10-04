<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="WEB-INF/error/error404.jsp" %>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page import = "uytubeLogic.logica.DtFecha"%>
<%@ page import = "uytubeLogic.logica.DtUsuario"%>
<%@ page import = "uytubeLogic.logica.DtComentario"%>
<%@ page import = "uytubeLogic.logica.DtUsuario"%>
<%@ page import = "uytubeLogic.logica.DtCanal"%>
<%@ page import = "uytubeLogic.logica.Fabrica"%>
<%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
<%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
<%@ page import = "javax.servlet.http.HttpSession"%>
<%@page import="java.util.Base64"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
	<%
	DtVideo dataVideo = (DtVideo) request.getAttribute("dataVideo");
	String titulo = dataVideo.getNombre();
	String id_video = dataVideo.getIDVideo().toString();
	DtUsuario info_propietario = (DtUsuario) request.getAttribute("usuario_propietario");
	DtCanal canal_propietario = (DtCanal) request.getAttribute("canal_propietario");
	String url_video = dataVideo.getUrl();
	String propietario = dataVideo.getPropietario();
	String descripcion = dataVideo.getDescripcion();
	DtCategoria categoria = dataVideo.getCategoria();
	String nombre_categoria = categoria.getNombre();
	DtFecha fechaPublicacion = dataVideo.getFechaPublicacion();
	Date fecha_publicacion = fechaPublicacion.getFecha();
	int dia = fecha_publicacion.getDate();
	int mes =  fecha_publicacion.getMonth();
	int anio = fecha_publicacion.getYear() + 1900;
	//String url_logo_autor = obtenerURLdeImagen(info_propietario.getFoto());
	String url_logo_autor = "https://i.ytimg.com/vi/5bHimOJb-Xw/hqdefault.jpg";
	String url_logo_usuario_iniciado = "http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG";
	String nombre_canal = canal_propietario.getNombre();
	//estos son los datos que tienen que ver con el usuario propietario y el video en sï¿½.
	//Hasta la 111 es lo que hizo Maria.
	byte[] fotoByte = info_propietario.getFoto();
	String urlFoto = "";
	if(fotoByte != null){
		Base64.Encoder encoder = Base64.getEncoder();
		String fotoString = encoder.encodeToString(fotoByte);
		urlFoto = "data:image/png;base64,"+ fotoString;
	}	
	String logged_state = "";
	String[] listasReproduccionUsuarioLogged = null;
	if((boolean)request.getAttribute("logged") == true){
		logged_state = "true";
		listasReproduccionUsuarioLogged = (String[]) request.getAttribute("listasReproduccionUsuarioLogged");
	}
	else logged_state = "false";
	
	%>
    <meta charset="ISO-8859-1">
	<link rel="stylesheet" href="media/styles/VerVideo.css">
	<title><%=titulo%></title>	
	<script type="text/javascript">
	window.onload=function(){
		var logged = "<%=logged_state%>";
		if(logged == "true"){
	    	document.getElementById("like_button").addEventListener("click", me_gusta_script);
	    	document.getElementById("dislike_button").addEventListener("click", no_me_gusta_script);
	    	document.getElementById("seguir_button").addEventListener("click",seguir_script);
	    	document.getElementById("response_button").addEventListener("click",comentar_video);
	    	document.getElementById("listasUsuarioLogged").addEventListener("click",agregar_lista_script);
		}else{
	    	document.getElementById("like_button").style.display = "none";
	    	document.getElementById("dislike_button").style.display = "none";
	    	document.getElementById("seguir_button").style.display = "none";
	    	document.getElementById("response_button").style.display = "none";
	    	document.getElementById("tabla_para_comentar").style.display = "none";
		}//si no está loggeado, no muestra estos elementos.
	}
	function me_gusta_script() {
		console.log("acabo de dar like");
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				window.alert("me gusta");
			}
		};
		xhttp.open("GET", "likeVideo?id_video="+<%=id_video%>+"&opcion=likeVideo",true);
		xhttp.send();
		console.log("ya envíe la request");
	}
	
	function no_me_gusta_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
	
			}
		};
		var operacion = "dislikeVideo?id_video="+<%=id_video%>+"&opcion=dislikeVideo";
		xhttp.open("GET", operacion, true);
		xhttp.send();
	}
	
	function agregar_lista_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
	
			}
		};
		var nombre_lista = document.getElementById("listasUsuarioLogged").value;
		var operacion = "addVidPlaylist?id_video="+<%=id_video%>+"&action=agregarVideoALista&nombre_lista="+nombre_lista;
		xhttp.open("GET", operacion, true);
		xhttp.send();
	}
	
	function seguir_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "follow?usuario_a_seguir=<%=propietario%>&opcion=follow", true);
		xhttp.send();
	}
	
	function comentar_video() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("demo").innerHTML = this.responseText;
			}
		};
		var contenido = document.getElementById("comentario_a_comentar").value;
		xhttp.open("GET", "newComment?id_video=<%=id_video%>&opcion=comment&contenido=" + contenido, true);
		xhttp.send();
	}
	
	function ir_a_perfil(nombre_dueño_perfil){
		request.setParameter("opcion") = "Perfil";
		request.setParameter("nombre_dueño_perfil") = nombre_dueño_perfil;
		request.getRequestDispatcher("/profile").forward(request, response);
	}

	function youtube_parser(url){
		var regExp = /^.*((youtu.be\/)|(v\/)|(\/u\/\w\/)|(embed\/)|(watch\?))\??v?=?([^#\&\?]*).*/;
		var match = url.match(regExp);
		if (match&&match[7].length==11){
		    var b=match[7];
		    alert("https://www.youtube.com/embed/"+b);
		}else{
		    alert("Url incorrecta");
		}
	}

</script>
</head>
<body >
	<p id="titulo"><%=titulo%></p><br> 
	
	<iframe style="width:100%" height="430px" id="frame" src="<%=url_video%>"></iframe><br>
	<table style="width:100%">
		<tr>
			<th rowspan="2" width="10%"><img id="logo" src=<%=url_logo_autor%> width="100px" height="70px" onclick="ir_a_perfil(<%=propietario%>)"></img></th>
			<th class="texto_simple" id="nombre_autor" width="30%"><%=nombre_canal%></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><p class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></p></th>
			<th rowspan="2" class="botones_like_dislike" width="30%">
				<button class="like_dislike_button" style="width:50%" id="like_button">  Me gusta  </button><button class="like_dislike_button" style="width:50%" id="dislike_button" name="opcion" value="dislikeVideo">No me gusta </button></th>
		</tr>
		<tr>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir">Seguir</button></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="4" class="descripcion"><p align="left"><%=descripcion%></p></th>
		</tr>
		<tr>
			<th colspan="3" class="categoria" width="80%">Categoria: <%=nombre_categoria%></th>
			<th colspan="2" width="20%" class="left_separator"><%if(logged_state == "true") this.htmlListasComboBoxGenerator(out, listasReproduccionUsuarioLogged); %></th>
		</tr>
	</table>
	<table style="width:100%" id = "tabla_para_comentar">
		<tr>
			<th  class="texto_simple" id="nombre_autor">Comentar video:</th>
		</tr>
		<tr>
			<th rowspan="2" width="30%" height="150px"><img id="logo" src=<%=url_logo_usuario_iniciado%> width="100px" height="70px"></img></th>
			<th rowspan="2" width="70%" id="cell_comentar"><textarea class="comentario" id="comentario_a_comentar"></textarea></th>
		</tr>
		<tr>
			<th><button style="width:100%" id="response_button" name="response_button" value="Comentar">  Comentar  </button></th>
		</tr>
	</table>
	<%!//funciones Java
		private void htmlListasComboBoxGenerator(javax.servlet.jsp.JspWriter out, String[] listasRep) throws java.io.IOException{
			if(listasRep.length != 0){
				out.println("<select name=\"listasUsuarioLogged\" id=\"listasUsuarioLogged\">");
				for(int index = 0; index <listasRep.length; index++){
					out.println("<option value=\""+listasRep[index]+"\">"+listasRep[index]+"</option>");
				}
				out.println("</select>");
				out.println("<button id=\"agregar_lista_button\" value=\"Agregar\">Agregar a lista</button>");	
			}
		}//esta función genera el código html para el boton combo box para agregar un video a una lista de reproduccion.
		private void printComentarios(javax.servlet.jsp.JspWriter out, DtComentario[] comentarios) throws java.io.IOException{
			for(int index = 0 ; index < comentarios.length; index++){
				String autor_comentario = comentarios[index].getNickUsuario();
				Date fecha_publicacion_comentario = comentarios[index].getFecha().getFecha();
				int dia_comment, mes_comment, anio_comment;
				dia_comment = fecha_publicacion_comentario.getDate();
				mes_comment = fecha_publicacion_comentario.getMonth();
				anio_comment = fecha_publicacion_comentario.getYear() + 1900;
				String descripcion_comentario = comentarios[index].getTexto();
				DtComentario[] hijos = comentarios[index].getRespuestas();
		   		out.println("<ul class=\"comment\">");
		   		out.println("	<li><img id=\"logo\" src=\"https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2018/04/3hfXV9eW-mAQfO4XNZrGX1OJPTm-FuEjVT_yxNH0cQM.jpg?resize=610%2C343\"></img> <p id=\"nombre_autor\">"+autor_comentario+" "+dia_comment+"/"+mes_comment+"/"+anio_comment+"</p></li>");
				out.println("	<li><p class=\"descripcion\">"+descripcion_comentario+"</p></li>");
				out.println("	<li><button style=\"width:30%\" id=\"response_button\" name=\"response_button\" value=\"Responder\">  Responder  </button></li>");
				if(hijos.length != 0)printComentarios(out,hijos);
				out.println("</ul>");
			}
		}
	%>
	<%
		DtComentario[] comentarios = (DtComentario[]) request.getAttribute("comentarios");
		printComentarios(out,comentarios);
	%>
</body>
</html>
