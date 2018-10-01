<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error404.jsp" %>
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
<%@page import="java.util.Base64"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file = "../cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" href="media/styles/VerVideo.css">
	<title>Insert title here</title>
</head>
<body >
<script type="text/javascript">
	function me_gusta_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				window.alert("me gusta");
			}
		};
		String
		operacion = "likeVideo?id_video=" + id_video + "&opcion=likeVideo";
		xhttp.open("GET", "likeVideo?id_video=" + id_video + "&opcion=likeVideo",
				true);
		xhttp.send();
	}
	
	function no_me_gusta_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
	
			}
		};
		String
		operacion = "dislikeVideo?id_video=" + id_video + "&opcion=dislikeVideo";
		System.out.println("operacion");
		xhttp.open("GET", operacion, true);
		xhttp.send();
	}
	
	function agregar_lista_script() {
		request.setAttribute();
	}
	
	function seguir_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "/follow?usuario_a_seguir=" + propietario
				+ "&opcion=follow", true);
		xhttp.send();
	}
	
	function comentar_video() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("demo").innerHTML = this.responseText;
			}
		};
		String
		contenido = document.getElementById("comentario_a_comentar");
		xhttp.open("GET", "/newComment?id_video=" + id_video
				+ "&opcion=comment&contenido=" + contenido, true);
		xhttp.send();
}</script>
	<%!
		private String obtenerURLdeImagen(byte[] imagen){
			Base64.Encoder encoder = Base64.getEncoder();
			String imagen_a_string = encoder.encodeToString(imagen);
			String url_a_devolver = "data:image/png;base64,"+imagen_a_string;
			return url_a_devolver;
		}//descodifica la imagen
		
	%>
	<%
		DtVideo dataVideo = (DtVideo) request.getAttribute("dataVideo");
		String id_video = dataVideo.getIDVideo().toString();
		DtUsuario info_propietario = (DtUsuario) request.getAttribute("usuario_propietario");
		DtCanal canal_propietario = (DtCanal) request.getAttribute("canal_propietario");
		String titulo = dataVideo.getNombre();
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
		//estos son los datos que tienen que ver con el usuario propietario y el video en s�.
		
		byte[] fotoByte = info_propietario.getFoto();
		Base64.Encoder encoder = Base64.getEncoder();
		String fotoString = encoder.encodeToString(fotoByte);
		String urlFoto = "data:image/png;base64,"+ fotoString;
	%>
	
	<%/*int id_video = 21;
	  String url_video = "https://www.youtube.com/embed/5bHimOJb-Xw";
	  String titulo = "Pomf Pomf With lyrics and Download";
	  String propietario = "johnchandler100";
	  String nombre_canal = "johnchandler100";
	  String descripcion = "Onii-san what's that sticky stuff on me?";
	  String nombre_categoria = "Loli-power";
	  int dia=9; int mes=8;int anio=1997;
	  String url_logo_autor = "https://i.ytimg.com/vi/5bHimOJb-Xw/hqdefault.jpg";
	  String url_logo_usuario_iniciado = "http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG";
	  *///datos de prueba
	%>
	
	<p id="titulo"><%=titulo%></p><br>
	
	<img src="<%= urlFoto%>"/>
	
	<iframe width="100%" height="430px" src="<%=url_video%>"></iframe><br>
	<table width="100%">
		<tr>
			<th rowspan="2" width="10%"><img id="logo" src=<%=url_logo_autor %> width="100px" height="70px"> </th>
			<th class="texto_simple" id="nombre_autor" width="30%"><%=nombre_canal%></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><p class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></p></th>
			<th rowspan="2" class="botones_like_dislike" width="30%">
				<button class="like_dislike_button" style="width:50%" id="like_button" onclick="me_gusta_script()">  Me gusta  </button><button class="like_dislike_button" style="width:50%" id="dislike_button" name="opcion" value="dislikeVideo" onclick="no_me_gusta_script()">No me gusta </button></th>
		</tr>
		<tr>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="seguir_script()">Seguir</button></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="4" class="descripcion"><p align="left"><%=descripcion%></p></th>
		</tr>
		<tr>
			<th colspan="3" class="categoria" width="80%">Categoria: <%=nombre_categoria%></th>
			<th colspan="2" width="20%" class="left_separator"><button id="agregar_lista_button" name="add_lista_button" onclick="agregar_lista_script()">Agregar a lista...</button>
		</tr>
	</table>
	<table width="100%" >
		<tr>
			<th  class="texto_simple" id="nombre_autor">Comentar video:</th>
		</tr>
		<tr>
			<th rowspan="2" width="20%" height="150px"><img width="100%" height="150px" id="logo" src=<%=url_logo_usuario_iniciado%> width="100px" height="70px"></img></th>
			<th rowspan="2" width="80%" id="cell_comentar"><textarea class="comentario" id="comentario_a_comentar"></textarea></th>
		</tr>
		<tr>
			<th><button style="width:100%" id="response_button" name="response_button" value="Comentar">  Comentar  </button></th>
		</tr>
	</table>
	<%!
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
	<table width="100%" height="20%">
		<tr>
			<th id="logo_container" class="right_separator" rowspan="3" width="10%" height="100%"><img id="logo" src="https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2018/04/3hfXV9eW-mAQfO4XNZrGX1OJPTm-FuEjVT_yxNH0cQM.jpg?resize=610%2C343"></img></th>
			<th  class="texto_simple" id="nombre_autor" colspan="2">Autor Comentario</th>
			<th class="right_left_separators"  id="fecha_publicacion" width="30%"><p class="texto_simple">Fecha de publicaci�n</p></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="3" class="descripcion"><p align="left">Descripci�n</p></th>
		</tr>
		<tr>
			<th colspan="2"></th>
			<th><button style="width:100%" id="response_button" name="response_button" value="Responder">  Responder  </button></th>
		</tr>
	</table>
</body>
</html>