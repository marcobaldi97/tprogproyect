<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <%@include file = "../cosasComunesDelHead.jsp" %>
    <link rel="stylesheet" href="media/styles/Login.css">
    <title>Inicio de Sesion</title>
</head>

<body class="login loli">
    <%@include file="../buscadorBootstrap.jsp" %>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-xs-12">
				<h2>Por favor ingrese sus datos para el inicio de sesión:</h2>
			</div>		
    	</div>
    	<div class="row">
    		<div class="col-xs-12">
    			<form action="login" method="post">
                    <h3>Nickname:</h3><input type="text" name="nickInicio"><br>
                    <h3>Contraseña:</h3><input type="password" name="passInicio"><br>
                    <button type="submit">Iniciar Sesión</button>
                    <input type="hidden" name="opcion" value="login">
                </form>
    		</div>
    	</div>
    	<div class="row">
    		<div class="col-xs-12"><h3><% if(request.getAttribute("error")!=null) out.println((String)request.getAttribute("error"));%></h3></div>
    	</div>
    </div>
</body>
</html>
