<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="../error/error404.jsp" %>
<%@ page import = "uytubeLogica.publicar.DtVideo"%>
<%@ page import = "uytubeLogica.publicar.DtCategoria"%>
<%@ page import = "uytubeLogica.publicar.DtFecha"%>
<%@ page import = "uytubeLogica.publicar.DtUsuario"%>
<%@ page import = "uytubeLogica.publicar.DtComentario"%>
<%@ page import = "uytubeLogica.publicar.DtCanal"%>


<%@ page import = "javax.servlet.http.HttpSession"%>
<%@page import="java.util.Base64"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../cosasComunesDelHead.jsp" %>
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
	Date fecha_publicacion = fechaPublicacion.getFecha().toGregorianCalendar().getTime();
	int dia = fecha_publicacion.getDate();
	int mes =  fecha_publicacion.getMonth() + 1;
	int anio = fecha_publicacion.getYear() + 1900;
	int cantLikes = (int) request.getAttribute("cantLikes");//acordarse de cambiar estos dos.
	int cantDislikes = (int) request.getAttribute("cantDislikes");;
	//String url_logo_autor = obtenerURLdeImagen(info_propietario.getFoto());
	String url_logo_autor = "";
	byte[] fotoComentador = info_propietario.getFoto();
	String urlFotoComentador = "";
	String fotoString = "";
	if(fotoComentador != null){
		Base64.Encoder encoder = Base64.getEncoder();
		fotoString = encoder.encodeToString(fotoComentador);
		url_logo_autor = "data:image/png;base64,"+ fotoString;
	}
	String nombre_canal = canal_propietario.getNombre();
	//estos son los datos que tienen que ver con el usuario propietario y el video en sñ.
	//Hasta la 111 es lo que hizo Maria.
	String logged_state = "";
	String[] listasReproduccionUsuarioLogged = null;
	if((boolean)request.getAttribute("logged") == true){
		logged_state = "true";
		listasReproduccionUsuarioLogged = (String[]) request.getAttribute("listasReproduccionUsuarioLogged");
	}
	else logged_state = "false";
	//carga del logo y otras cosas.
	String url_logo_usuario_iniciado = "";
	String like_state = "";
	String follow_state = "";
	if(logged_state == "true"){
		DtUsuario dataUsuario = (DtUsuario) request.getAttribute("dataUsuario");
		url_logo_usuario_iniciado = "http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG";
		byte[] fotoByteUsuarioLogged = dataUsuario.getFoto();
		System.out.println("Es lo siguiente un null? :"+fotoByteUsuarioLogged+"y el nombre está bien?: "+dataUsuario.getNickname());
		if(fotoByteUsuarioLogged != null){
			Base64.Encoder encoder = Base64.getEncoder();
			fotoString = encoder.encodeToString(fotoByteUsuarioLogged);
			url_logo_usuario_iniciado = "data:image/png;base64,"+ fotoString;
		}
		like_state = (String)request.getAttribute("like_state");
		follow_state = (String)request.getAttribute("follow_state");
	}else{
		url_logo_usuario_iniciado = "";
		follow_state = "";
		like_state = "";
	}
	//fin de la carga
	DtComentario[] comentarios = (DtComentario[]) request.getAttribute("comentarios");
	%>
	<link rel="stylesheet" href="media/styles/VerVideo.css">
	<title><%=titulo%></title>
	<script type="text/javascript">
	window.onload=function(){
		var logged = "<%=logged_state%>";
	}

	function toggle_response_box(index){
		var response_box = "response_box" + index;
	    var x = document.getElementById(response_box);
	    if (x.style.display === "none") {
	        x.style.display = "inline-table";
	    } else {
	        x.style.display = "none";
	    }
	}
	
	function toggle_followers_box(){
		var x = document.getElementById("followers_box");
	    if (x.style.display === "none") {
	        x.style.display = "block";
	    } else {
	        x.style.display = "none";
	    }
	}

	function submit_response(index){
		var response_button = "response_button" + index;
		var id_comentario = document.getElementById(response_button).value;
		var comentario_a_comentar = "comentario_a_comentar" + index;
		var contenido_comentario = document.getElementById(comentario_a_comentar).value;
		var response_box = "response_box" + index;
		document.getElementById(response_box).style.display = "none";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
			}
		};
		xhttp.open("GET", "responseComment?id_video="+<%=id_video%>+"&opcion=responderComentario&id_comentario="+id_comentario+"&contenido="+contenido_comentario,true);
		xhttp.send();
		location.reload(true);
	}

	function me_gusta_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
			}
		};
		xhttp.open("GET", "likeVideo?id_video="+<%=id_video%>+"&opcion=likeVideo",true);
		xhttp.send();
		location.reload(true);
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
		location.reload(true);
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
		console.log("el nombre de la lista a agregar es: "+nombre_lista);
		xhttp.send();
		location.reload(true);
	}

	function seguir_script() {
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "follow?usuario_a_seguir=<%=propietario%>&opcion=follow", true);
		xhttp.send();
		location.reload(true);
	}
	
	function dejar_seguir_script(){
		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", "leaveFollow?usuario_a_seguir=<%=propietario%>&opcion=leaveFollow", true);
		xhttp.send();
		location.reload(true);
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
		location.reload(true);
	}

	function ir_a_perfil(){
		request.setAttribute("opcion","Perfil");
		request.setAttribute("nombre_dueño_perfil",<%=propietario%>);
		request.getRequestDispatcher("/profile").forward(request, response);
	}
</script>
</head>
<body >
	<%@include file="../buscador.jsp" %>
    <div class="main-container">
    <%@include file="../sidebar.jsp" %>
    <div class="main-content">
	<p class="titulo" id="titulo"><%=titulo%></p><br>

	<iframe style="width:100%" height="430px" id="frame" src="<%=url_video%>"></iframe><br>
	<table style="width:100%">
		<tr>
			<th rowspan="2" width="10%"><img class="logo" src=<%=url_logo_autor%> width="100px" height="70px" ></img></th>
			<th class="texto_simple" id="nombre_autor" width="30%"><a onclick="ir_a_perfil()"><%=nombre_canal%></a></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><p class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></p></th>
			<th rowspan="1" class="botones_like_dislike" width="30%">
				<%if(logged_state.equals("true")){
					System.out.println("Este es el estado actual: "+like_state);
					if(like_state.equals("neutral")){%>
				<button class="like_dislike_button" style="width:50%" id="like_button" onclick = "me_gusta_script()">  Me gusta  </button><button class="like_dislike_button" style="width:50%" id="dislike_button" name="opcion" value="dislikeVideo" onclick="no_me_gusta_script()">No me gusta </button></th>
				<%	}if(like_state.equals("like")){%>
				<button class="like_dislike_button" style="width:100%" id="dislike_button" name="opcion" value="dislikeVideo" onclick="no_me_gusta_script()">No me gusta </button></th>
				<%	}if(like_state.equals("dislike")){%>
				<button class="like_dislike_button" style="width:100%" id="like_button" onclick = "me_gusta_script()">  Me gusta  </button></th>
				<%	}	
				}	%>		
		</tr>
		<tr>
			<%
			if(logged_state == "true"){
				DtUsuario dataUsuario2 = (DtUsuario) request.getAttribute("dataUsuario");
				String nombre_user_loggeado = dataUsuario2.getNickname();
				if(!propietario.equals(nombre_user_loggeado)){
					System.out.println(follow_state);
					if(follow_state == "false"){%>
				<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="seguir_script()">Seguir</button></th>
				<%	}else{%>
				<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="dejar_seguir_script()">Dejar de seguir</button></th>
				<%	}//final del else	
				}else{
				%>
				<th></th>
				<%	
				}
			}//final del if
			%>
			<th><p class="texto_simple">Likes:<%=cantLikes%> Dislikes:<%=cantDislikes%></p></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="4" class="descripcion"><p align="left"><%=descripcion%></p></th>
		</tr>
		<tr>
			<th colspan="3" class="categoria" width="80%">Categoria: <%=nombre_categoria%></th>
			<th colspan="2" width="20%" class="left_separator"><%if(logged_state == "true") this.htmlListasComboBoxGenerator(out, listasReproduccionUsuarioLogged); %></th>
		</tr>
	</table>
	<%if(logged_state == "true"){ %>
	<table style="width:100%" id = "tabla_para_comentar">
		<tr>
			<th  class="texto_simple" id="nombre_autor">Comentar video:</th>
		</tr>
		<tr>
			<th rowspan="2" width="30%" height="150px"><img class="logo" src=<%=url_logo_usuario_iniciado%> width="100px" height="70px"></img></th>
			<th rowspan="2" width="70%" id="cell_comentar"><textarea class="comentario" id="comentario_a_comentar"></textarea></th>
		</tr>
		<tr>
			<th><button style="width:100%" id="response_button" name="response_button" value="Comentar" onclick="comentar_video()">  Comentar  </button></th>
		</tr>
	</table>
	<%}%>
	<%!//funciones Java
		private void htmlListasComboBoxGenerator(javax.servlet.jsp.JspWriter out, String[] listasRep) throws java.io.IOException{
			if(listasRep.length != 0){
				out.println("<select class=\"combo_box_listas\" name=\"listasUsuarioLogged\" id=\"listasUsuarioLogged\">");
				for(int index = 0; index <listasRep.length; index++){
					out.println("<option value=\""+listasRep[index]+"\">"+listasRep[index]+"</option>");
				}
				out.println("</select><button id=\"agregar_lista_button\" value=\"Agregar\" onclick=\"agregar_lista_script()\">Agregar a lista</button>");
			}
		}//esta funciñn genera el codigo html para el boton combo box para agregar un video a una lista de reproduccion.
		private int printComentarios(javax.servlet.jsp.JspWriter out, DtComentario[] comentarios,int index, String url_logo_usuario_iniciado, String logged_state) throws java.io.IOException{
			for(int i = 0  ; i < comentarios.length; i++){
				String autor_comentario = comentarios[i].getNickUsuario();
				Date fecha_publicacion_comentario = comentarios[i].getFecha().getFecha().toGregorianCalendar().getTime();
				int dia_comment, mes_comment, anio_comment;
				dia_comment = fecha_publicacion_comentario.getDate();
				mes_comment = fecha_publicacion_comentario.getMonth() + 1;
				anio_comment = fecha_publicacion_comentario.getYear() + 1900;
				String descripcion_comentario = comentarios[i].getTexto();
				DtComentario[] hijos = comentarios[i].getRespuestas().toArray(new DtComentario[0]);
				byte[] fotoComentador = comentarios[i].getFotoDuenio();
				String urlFotoComentador = "";
				if(fotoComentador != null){
					Base64.Encoder encoder = Base64.getEncoder();
					String fotoString = encoder.encodeToString(fotoComentador);
					urlFotoComentador = "data:image/png;base64,"+ fotoString;
				}
		   		out.println("<ul class=\"comment\">");
				out.println("<li>");
				out.println("<table class=\"comment_box\">");
				out.println("        <tr>");
				out.println("            <td rowspan=\"3\" class=\"img_container\"><img class=\"logo\" src=\""+urlFotoComentador+"\"></img></td>");
				out.println("            <td style=\"width: 50%\"><p class=\"texto_simple\">"+autor_comentario+"</p></td>");
				out.println("            <td style=\"width: 50%\"><p class=\"texto_simple\">"+dia_comment+"/"+mes_comment+"/"+anio_comment+"</p></td>");
				out.println("        </tr>");
				out.println("        <tr>");
				out.println("            <td colspan=\"2\"><p class=\"descripcion\">"+descripcion_comentario+"</p></td>");
				out.println("        </tr>");
				out.println("        <tr>");
				if(logged_state == "true"){
					out.println("            <td colspan=\"2\"><button style=\"width:100%\" id=\"response_button"+index+"\" class=\"response_button_class\" name=\"response_button\" value=\""+comentarios[i].getIdComentario()+"\" onclick=\"toggle_response_box("+index+")\">  Responder  </button></td>");	
				}
				out.println("        </tr>");
				out.println("    </table>");
				if(logged_state == "true"){
					out.println("<table style=\"display:none;\" class=\"response_box\" id=\"response_box"+index+"\">");
					out.println("		 <tr>");
					out.println("		 	 <td class=\"img_container\"><img id=\"mini_logo\" class=\"logo\" src=\""+url_logo_usuario_iniciado+"\"></img></td>");
					out.println("		 	 <td><textarea class=\"comentario_text_area\" id=\"comentario_a_comentar"+index+"\"></textarea></td>");
					out.println("		 	 <td><button class=\"response_button_class\"  id=\"submit_response_button"+index+"\" name=\"response_button\" value=\"Responder\" onclick=\"submit_response("+index+")\">  Responder  </button></td>");
					out.println("		 </tr>");
					out.println("    </table>");
				}
				out.println("</li>");
				index++;
				index = printComentarios(out,hijos,index,url_logo_usuario_iniciado,logged_state);
				out.println("</ul>");
				
			}
			return index;
		}
	%>
	<div class="comment_container">
	<%
		if(logged_state.equals("true")){
			DtUsuario dataUsuario2 = (DtUsuario) request.getAttribute("dataUsuario");
			String nombre_user_loggeado = dataUsuario2.getNickname();
			if(propietario.equals(nombre_user_loggeado)){
				String[] listaLikes = (String[]) request.getAttribute("listaLikes");
				String[] listaDislikes = (String[]) request.getAttribute("listaDislikes");
	%>		
			<button style="" class="response_button_class" onclick="toggle_followers_box()">Lista usuarios likes/dislikes</button>
			<div style="display: none;" class="followers_box" id="followers_box">
			<p class="texto_simple">Usuarios que dieron like:</p>
			<ul>
	<%
			for(int index = 0; index < listaLikes.length;index++) {
	%>
				<li><a href="profile?opcion=Perfil&nickname=<%=listaLikes[index]%>"><%=listaLikes[index]%> </a></li>
	<%			
			}//imprimo los usuarios likes
	%>			
			</ul>
			<p class="texto_simple">Usuarios que dieron dislike:</p>
			<ul>
	<%
			for(int index = 0; index < listaDislikes.length;index++) {
	%>
				<li><a href="profile?opcion=Perfil&nickname=<%=listaDislikes[index]%>"><%=listaDislikes[index]%> </a></li>
	<%			
			}//imprimo los usuarios dislikes
	%>			
			</ul>
			</div>
	<%			
			}
		}//esto va a ser para que el propietario pueda ver los usuarios que le dieron like o dislike a su video.
		int index = 0;		
		printComentarios(out,comentarios, index, url_logo_usuario_iniciado,logged_state);
	%>
	</div>
	        </div>
    </div>
</body>
</html>
