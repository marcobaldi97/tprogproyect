<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	String nombre_canal = canal_propietario.getNombre();
	//estos son los datos que tienen que ver con el usuario propietario y el video en sñ.
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
	//carga del logo y otras cosas.
	String url_logo_usuario_iniciado = "";
	String like_state = "";
	String follow_state = "";
	if(logged_state == "true"){
		url_logo_usuario_iniciado = "http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG";
		like_state = (String)request.getAttribute("like_state");
		follow_state = (String)request.getAttribute("follow_state");
	}else{
		url_logo_usuario_iniciado = "";
		follow_state = "";
		like_state = "";
	}
	//fin de la carga
	DtComentario[] comentarios = (DtComentario[]) request.getAttribute("comentarios");
	Integer tamanio_comentarios = 0;
	for(int i = 0; i < comentarios.length; i++){
		tamanio_comentarios = tamanio_comentarios + comentarios[i].getTamanioArbol();
	}
	%>
	<link rel="stylesheet" href="media/styles/VerVideo.css">
	<title><%=titulo%></title>
	<script type="text/javascript">
	window.onload=function(){
		var logged = "<%=logged_state%>";
		if(logged === "true"){
	    	document.getElementById('listasUsuarioLogged').addEventListener("click",agregar_lista_script);  	
		}//si no estñ loggeado, no muestra estos elementos.
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

	function ir_a_perfil(nombre_dueño_perfil){
		request.setParameter("opcion") = "Perfil";
		request.setParameter("nombre_dueño_perfil") = nombre_dueño_perfil;
		request.getRequestDispatcher("/profile").forward(request, response);
	}
</script>
</head>
<body >
	<p class="titulo" id="titulo"><%=titulo%></p><br>

	<iframe style="width:100%" height="430px" id="frame" src="<%=url_video%>"></iframe><br>
	<table style="width:100%">
		<tr>
			<th rowspan="2" width="10%"><img class="logo" src=<%=url_logo_autor%> width="100px" height="70px" ></img></th>
			<th class="texto_simple" id="nombre_autor" width="30%"><%=nombre_canal%></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><p class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></p></th>
			<th rowspan="2" class="botones_like_dislike" width="30%">
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
				System.out.println(follow_state);
				if(follow_state == "false"){%>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="seguir_script()">Seguir</button></th>
			<%	}else{%>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="dejar_seguir_script()">Dejar de seguir</button></th>
			<%	}//final del else
			}//final del if
			%>
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
				Date fecha_publicacion_comentario = comentarios[i].getFecha().getFecha();
				int dia_comment, mes_comment, anio_comment;
				dia_comment = fecha_publicacion_comentario.getDate();
				mes_comment = fecha_publicacion_comentario.getMonth();
				anio_comment = fecha_publicacion_comentario.getYear() + 1900;
				String descripcion_comentario = comentarios[i].getTexto();
				DtComentario[] hijos = comentarios[i].getRespuestas();
		   		out.println("<ul class=\"comment\">");
				out.println("<li>");
				out.println("<table class=\"comment_box\">");
				out.println("        <tr>");
				out.println("            <td rowspan=\"3\" class=\"img_container\"><img class=\"logo\" src=\"https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2018/04/3hfXV9eW-mAQfO4XNZrGX1OJPTm-FuEjVT_yxNH0cQM.jpg?resize=610%2C343\"></img></td>");
				out.println("            <td style=\"width: 50%\"><p class=\"texto_simple\">"+autor_comentario+"</p></td>");
				out.println("            <td style=\"width: 50%\"><p class=\"texto_simple\">"+dia_comment+"/"+mes_comment+"/"+anio_comment+"</p></td>");
				out.println("        </tr>");
				out.println("        <tr>");
				out.println("            <td colspan=\"2\"><p class=\"descripcion\">"+descripcion_comentario+"</p></td>");
				out.println("        </tr>");
				out.println("        <tr>");
				if(logged_state == "true"){
					out.println("            <td colspan=\"2\"><button style=\"width:100%\" id=\"response_button"+index+"\" class=\"response_button_class\" name=\"response_button\" value=\""+comentarios[i].getIDComentario()+"\" onclick=\"toggle_response_box("+index+")\">  Responder  </button></td>");	
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
		int index = 0;		
		printComentarios(out,comentarios, index, url_logo_usuario_iniciado,logged_state);
	%>
	</div>
</body>
</html>
