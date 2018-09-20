<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "uytube.logica.DtVideo"%>
<%@ page import = "uytube.logica.DtCategoria"%>
<%@ page import = "uytube.logica.DtFecha"%>
<%@ page import = "uytube.logica.DtUsuario"%>
<%@ page import = "uytube.logica.Factory"%>
<%@ page import = "uytube.logica.IUsuarioCtrl"%>
<%@ page import = "uytube.logica.IVideoCtrl"%>
<%@ page import = "java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="VerVideo.css">
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body height="100%" width="100%">
	<% DtVideo dataVideo = (DtVideo) request.getAttribute("dataVideo");
	   String titulo = dataVideo.getNombre();	
	   String url_video = dataVideo.getUrl();
	   String propietario = dataVideo.getPropietario();
	   DtCategoria categoria = dataVideo.getCategoria();
	   String nombre_categoria = categoria.getNombre();
	   DtFecha fechaPublicacion = dataVideo.getFechaPublicacion();
	   Date fecha_publicacion = fechaPublicacion.getFecha();
	   int dia = fecha_publicacion.getDay();
	   int mes =  fecha_publicacion.getMonth();
	   int anio = fecha_publicacion.getYear();
	   Factory fabrica = Factory.getInstance();
	   IUsuarioCtrl controlador_usuario = fabrica.getIUsuarioCtrl();
	   DtUsuario info_propietario = controlador_usuario.listarDatosUsuario(propietario);
	   String nombre_canal = controlador_usuario.mostrarInfoCanal(propietario).getNombre();
	   //estos son los datos que tienen que ver con el usuario propietario y el video en s�.
	%>
	<script>
		void me_gusta_script(){}
	</script>
	<script>
		void no_me_gusta_script(){}
	</script>
	<script>
		void agregar_lista_script(){}
	</script>
	<script>
		void seguir_script(){}
	</script>
	<t id="titulo"><%=titulo%>></t><br>
	<iframe width="100%" height="430px" src="<%=url_video%>"></iframe><br>
	<table width="100%">
		<tr>
			<th rowspan="2" width="10%"><img id="logo" src="https://yt3.ggpht.com/a-/AN66SAx_Kkbq6jXKpAECX77DOrAuYREUbX2S_ZtJWQ=s48-mo-c-c0xffffffff-rj-k-no" width="100px" height="70px"> </th>
			<th class="texto_simple" id="nombre_autor" width="30%" href><%=nombre_canal%></th>
			<th rowspan="2" class="right_left_separators"  id="fecha_publicacion" width="30%"><t class="texto_simple"><%=dia%>/<%=mes%>/<%=anio%></t></th>
			<th rowspan="2" class="botones_like_dislike" width="30%">
				<button class="like_dislike_button" style="width:50%" id="like_button" name="like_button" value="Me gusta" onclick="javascript:me_gusta_script();">  Me gusta  </button><button class="like_dislike_button" style="width:50%" id="dislike_button" name="dislike_button" value="No me gusta" onclick="javascript:no_me_gusta_script();">No me gusta </button></th>
		</tr>
		<tr>
			<th><button id="seguir_button" name="boton_seguir" value="Seguir" onclick="javascript:seguir_script();">Seguir</button></th>
		</tr>
		<tr>
			<th  class="encapsulated_border" colspan="4" class="descripcion"><p align="left">Descripci�n</p></th>
		</tr>
		<tr>
			<th colspan="3" class="categoria" width="80%">Categor�a: <%=nombre_categoria%></th>
			<th colspan="2" width="20%" class="left_separator"><button id="agregar_lista_button" name="add_lista_button" onclick="javascript:agregar_lista_script();">Agregar a lista...</button>
		</tr>
	</table>
	<table width="100%" >
		<tr colspan="3">
			<th  class="texto_simple" id="nombre_autor">Comentar video:</th>
		</tr>
		<tr>
			<th rowspan="2" width="20%" height="150px"><img width="100%" height="150px" id="logo" src="http://www.sddistribuciones.com//Portadas/GSCBSG90486_3.JPG" width="100px" height="70px"></img></th>
			<th rowspan="2" width="80%" id="cell_comentar"><textarea class="comentario" id="comentario_a_comentar"></textarea></th>
		</tr>
		<tr>
			<th><button style="width:100%" id="response_button" name="response_button" value="Comentar">  Comentar  </button></th>
		</tr>
	</table>
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