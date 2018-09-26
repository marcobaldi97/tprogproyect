<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file = "WEB-INF/cosasComunesDelHead.jsp" %>
	<link rel="stylesheet" href="media/styles/AltaUsuario.css">
	<title>Alta Usuario</title>
</head>
<body>
	<%@include file="WEB-INF/buscador.jsp" %>

    <div class="main-container">
        <%@include file="WEB-INF/sidebar.jsp" %>
        <div class="main-content">
            <form class="alta-usuario-form" action="newUser" method ="post">
            Nickname:<br>
            <input type="text" name="nickname"><br>
            Correo electronico:<br>
            <input type="email" name="email"><br>
            Nombre:<br>
            <input type="text" name="nombre"><br>
            Apellido:<br>
            <input type="text" name="apellido"><br>
            Contrase�a:<br>
            <input type="password" name="contrasenia"><br>
            Confirmar Contrase�a:<br>
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
            <input type="radio" name="privacidad" value="Privado">Privado
            <input type="radio" name="privacidad" value="Publico">Publico<br>
            Categoria(opcional)<br>
                <select name="categoria">
                <option value="cat1">cat1</option>
                <option value="cat2">cat2</option>
                <option value="cat3">cat3</option>
                <option value="cat4">cat4</option>
                </select><br>

            <button type="submit" id="crearUsuario" name="opcion" value="nuevoUsuario">Crear</button>
            <input type="reset" value="Limpiar campos" name="boton_limpiar" class="input"><br>

            </form>
        </div>
    </div>

</body>
</html>
