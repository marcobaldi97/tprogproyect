<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<head>
 	<%@include file = "cosasComunesDelHead.jsp" %>
 	<%
 	String nombreUsuario = "";
 	if (session != null && session.getAttribute("nombre_usuario") != null){
 		nombreUsuario = (String) session.getAttribute("nombre_usuario");
 	}
 	%>
</head>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-left" href="home"><img style="height: 60px;" src="media/images/Logo.png" alt="uyTube"></img></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	  	<form class="navbar-form navbar-left" action="search" method="get">
	    	<div class="form-group">
	    		<input type="text" class="form-control" placeholder="Buscar...">
	    	</div>
	  		<button type="submit" class="btn btn-default">Buscar</button>
	  	</form>
      <ul class="nav navbar-nav navbar-right">
      	<%if (session != null && session.getAttribute("nombre_usuario") != null){%>
	    <li><a href='login?opcion=logout'>Cerrar Sesion</a></li>
		<li><a href='profile?opcion=Perfil&nickname="+URLEncoder.encode(nomUsu,"UTF-8")+"'>Hola, <%=nombreUsuario%></a></li>
		<%}else{%>
		<li><a href='login?opcion=login'>Iniciar Sesion</a></li>
		<li><a href='newUser?opcion=nuevoUsuario'>Nuevo Usuario</a></li>
		<%}%>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
