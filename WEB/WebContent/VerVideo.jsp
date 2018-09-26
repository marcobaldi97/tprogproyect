<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error404.jsp" %>
<%@ page import = "uytubeLogic.logica.DtVideo"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>
<%@ page import = "uytubeLogic.logica.DtFecha"%>
<%@ page import = "uytubeLogic.logica.DtUsuario"%>
<%@ page import = "uytubeLogic.logica.DtComentario"%>
<%@ page import = "uytubeLogic.logica.Fabrica"%>
<%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
<%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file = "WEB-INF/cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" href="VerVideo.css">
	<title>Insert title here</title>
</head>
<body height="100%" width="100%">
	<%
		DtVideo dataVideo = (DtVideo) request.getAttribute("dataVideo");
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
		Fabrica fabrica = Fabrica.getInstance();
		String url_logo_autor = "https://i.ytimg.com/vi/5bHimOJb-Xw/hqdefault.jpg";
		String url_logo_usuario_iniciado = "http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG";
		IUsuarioCtrl controlador_usuario = fabrica.getIUsuarioCtrl();
		DtUsuario info_propietario = controlador_usuario.listarDatosUsuario(propietario);
		String nombre_canal = controlador_usuario.mostrarInfoCanal(propietario).getNombre();
		//estos son los datos que tienen que ver con el usuario propietario y el video en s�.
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
	<script type="text/javascript">
		function me_gusta_script(){
		    var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		      if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("demo").innerHTML = this.responseText;
		      }
		    };
		    xhttp.open("GET", "/likeVideo?id_video="+id_video+"&opcion=likeVideo", true);
		    xhttp.send();
		}
	</script>
	<script type="text/javascript">
		function no_me_gusta_script(){
		    var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		      if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("demo").innerHTML = this.responseText;
		      }
		    };
		    xhttp.open("GET", "/dislikeVideo?id_video="+id_video+"&opcion=dislikeVideo", true);
		    xhttp.send();
		}
	</script>
	<script type="text/javascript">
		function agregar_lista_script(){
			request.setAttribute();
		}
	</script>
	<script type="text/javascript">
		function seguir_script(){
		    var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		      if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("demo").innerHTML = this.responseText;
		      }
		    };
		    xhttp.open("GET", "/follow?usuario_a_seguir="+propietario+"&opcion=follow", true);
		    xhttp.send();
		}
	</script>
	<script type="text/javascript">
		function comentar_video(){
		    var xhttp = new XMLHttpRequest();
		    xhttp.onreadystatechange = function() {
		      if (this.readyState == 4 && this.status == 200) {
		        document.getElementById("demo").innerHTML = this.responseText;
		      }
		    };
		    String contenido = document.getElementById("comentario_a_comentar");
		    xhttp.open("GET", "/newComment?id_video="+id_video+"&opcion=comment&contenido="+contenido, true);
		    xhttp.send();
		}
	</script>
	<t id="titulo"><%=titulo%></t><br>
	<iframe width="100%" height="430px" src="<%=url_video%>"></iframe><br>
	<table width="100%">
		<tr>
			<th rowspan="2" width="10%"><img id="logo" src=<%=url_logo_autor %> width="100px" height="70px"> </th>
			<th class="texto_simple" id="nombre_autor" width="30%"><%=nombre_canal%></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><t class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></t></th>
			<th rowspan="2" class="botones_like_dislike" width="30%">
				<button class="like_dislike_button" style="width:50%" id="like_button" name="opcion" value="likeVideo" onclick="me_gusta_script()">  Me gusta  </button><button class="like_dislike_button" style="width:50%" id="dislike_button" name="opcion" value="dislikeVideo" onclick="no_me_gusta_script()">No me gusta </button></th>
		</tr>
		<tr>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="seguir_script()">Seguir</button></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="4" class="descripcion"><p align="left"><%=descripcion%></p></th>
		</tr>
		<tr>
			<th colspan="3" class="categoria" width="80%">Categor�a: <%=nombre_categoria%></th>
			<th colspan="2" width="20%" class="left_separator"><button id="agregar_lista_button" name="add_lista_button" onclick="agregar_lista_script()">Agregar a lista...</button>
		</tr>
	</table>
	<table width="100%" >
		<tr colspan="3">
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
	<%
		DtComentario[] comentarios = (DtComentario[]) request.getAttribute("comentarios");
		for(int index = 0 ; index < comentarios.length; index++){//este for es para los padres
			String autor_comentario = comentarios[index].getNickUsuario();
			Date fecha_publicacion_comentario = comentarios[index].getFecha().getFecha();
			int dia_comment, mes_comment, anio_comment;
			dia_comment = fecha_publicacion_comentario.getDate();
			mes_comment = fecha_publicacion_comentario.getMonth();
			anio_comment = fecha_publicacion_comentario.getYear() + 1900;
			String descripcion_comentario = comentarios[index].getTexto();
			%>
				<table width="100%" height="20%">
					<tr>
						<th id="logo_container" class="right_separator" rowspan="3" width="10%" height="100%"><img id="logo" src="https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2018/04/3hfXV9eW-mAQfO4XNZrGX1OJPTm-FuEjVT_yxNH0cQM.jpg?resize=610%2C343"></img></th>
						<th  class="texto_simple" id="nombre_autor" colspan="2"><%=autor_comentario%></th>
						<th class="right_left_separators"  id="fecha_publicacion" width="30%"><t class="texto_simple"><%=dia_comment%>/<%=mes_comment%>/<%=anio_comment%></t></th>
					</tr>
					<tr>
						<th  class="encapsulated_border" colspan="3" class="descripcion"><p align="left"><%=descripcion_comentario%></p></th>
					</tr>
					<tr>
						<th colspan="2"></th>
						<th><button style="width:100%" id="response_button" name="response_button" value="Responder">  Responder  </button></th>
					</tr>
				</table>
			<%
		}
	%>
	<table width="100%" height="20%">
		<tr>
			<th id="logo_container" class="right_separator" rowspan="3" width="10%" height="100%"><img id="logo" src="https://i0.wp.com/blogthinkbig.com/wp-content/uploads/2018/04/3hfXV9eW-mAQfO4XNZrGX1OJPTm-FuEjVT_yxNH0cQM.jpg?resize=610%2C343"></img></th>
			<th  class="texto_simple" id="nombre_autor" colspan="2">Autor Comentario</th>
			<th class="right_left_separators"  id="fecha_publicacion" width="30%"><t class="texto_simple">Fecha de publicaci�n</t></th>
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
