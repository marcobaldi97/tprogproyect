<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <%@include file = "../cosasComunesDelHead.jsp" %>
    <link rel="stylesheet" href="media/styles/Login.css">
    <title>Inicio de Sesion</title>
</head>

<body>
    <%@include file="../buscador.jsp" %>
    <div class="main-container">
        <%@include file="../sidebar.jsp" %>
        <div class="main-content">

            <p id="textoAntes">Por favor ingrese sus datos para el inicio de sesión:</p><br>
            <div class="login">
                <form action="login" method="post">
                    Nickname: <input type="text" name="nickInicio"><br>
                    Contraseña:<input type="password" name="passInicio"><br>
                    <button type="submit">Iniciar Sesión</button>
                    <input type="hidden" name="opcion" value="login">
                </form>
            </div>
            <% if(request.getAttribute("error")!=null) out.println((String)request.getAttribute("error"));%>
        </div>
    </div>
</body>

</html>
