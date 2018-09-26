<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Por favor ingrese sus datos para el inicio de sesión:<br>
<form action="login" method="post">
	Nickname <input type="text" name="nickInicio"></input><br>
	Contraseña<input type="password" name="passInicio"></input><br>
	<button type="submit">Iniciar Sesión</button>
	<input type="hidden" name="opcion" value="login"></input>
</form>
</body>
</html>