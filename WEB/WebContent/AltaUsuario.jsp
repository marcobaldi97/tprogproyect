<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page import = "uytubeLogic.logica.DtCategoria"%>
    <%@ page import = "uytubeLogic.logica.Fabrica"%>
    <%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
    <%@include file = "WEB-INF/cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" href="media/styles/AltaUsuario.css">
	<title>Alta Usuario</title>
</head>
<body>
	<%@include file="WEB-INF/buscador.jsp" %>

    <div class="main-container">
        <%@include file="WEB-INF/sidebar.jsp" %>
        <div class="main-content">
            <form class="alta-usuario-form" action="/UyTubeWeb/newUser" method ="post">
            Nickname:<br>
            <input type="text" name="nickname"><br>
            Correo electronico:<br>
            <input type="email" name="email"><br>
            Nombre:<br>
            <input type="text" name="nombre"><br>
            Apellido:<br>
            <input type="text" name="apellido"><br>
            Contraseña:<br>
            <input type="password" name="contrasenia"><br>
            Confirmar Contraseña:<br>
            <input type="password" name="contraseniaConfirmacion"><br>
            <script type="text/javascript" src="fechaInput.js"></script>
            Fecha nacimiento:<br>
            <input type="text" id="datepicker" name="fecha_nacimiento"><br/>
            Imagen(opcional):<br>
            <input type="file" name="filename" accept="image/gif, image/jpeg, image/png"><br>
            Nombre canal(opcional):<br>
            <input type="text" name="nombre_canal"><br>
            Descripcion:<br>
            <input type="textarea" name="descripcion"><br>
            Defina su privacidad:<br>
            <input type="radio" name="privacidad" value="PRIVADO">Privado
            <input type="radio" name="privacidad" value="PUBLICO">Publico<br>
            Categoria(opcional)<br>
            <select name="categoria">
               		<%
					Fabrica fabrica = Fabrica.getInstance();
					IVideoCtrl videoCtr = fabrica.getIVideoCtrl();
			 		DtCategoria[] cat = videoCtr.listarCategorias();
			     	String opciones="";
			       	for (int i=0;i<cat.length;i++)
			       	{
			       	 opciones=opciones+"<option value="+cat[i].getNombre()+">"+cat[i].getNombre()+"</option>";
			
		 	     	}
      				%>
                    <%=opciones %>
              </select><br />

            <button id="crearUsuario" name="opcion" value="nuevoUsuario">Crear</button>
        

            </form>
        </div>
    </div>

</body>
</html>
