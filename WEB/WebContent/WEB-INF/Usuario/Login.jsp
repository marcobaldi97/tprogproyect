<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<link rel="stylesheet" href="media/styles/Login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de Sesion</title>
</head>
<body>
<%@include file="../buscador.jsp" %>

<p id="textoAntes">Por favor ingrese sus datos para el inicio de sesión:</p><br>
<div class="login"><form action="login" method="post">
	Nickname: <input type="text" name="nickInicio"></input><br>
	Contraseña:<input type="password" name="passInicio"></input><br>
	<button type="submit">Iniciar Sesión</button>
	<input type="hidden" name="opcion" value="login"></input>
</form></div>
<%if(request.getAttribute("error")!=null) 
	out.println((String)request.getAttribute("error"));%>

</body>
</html>