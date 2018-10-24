<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <%@include file = "../cosasComunesDelHead.jsp" %>
    <link rel="stylesheet" href="media/styles/AltaVideo.css">

    <%@ page import = "uytubeLogic.logica.DtCategoria"%>
    <title>Alta Video</title>
</head>

<body>
    <%@include file = "../buscador.jsp" %>
    <div class="main-container">
        <%@include file = "../sidebar.jsp" %>
        <div class="main-content">
            <form action="newVideo" method="post">
                Nombre del Video:<br />
                <input class="AltaVideo" type="text" name="nombreVideo" /><br />
                Duracion:<br />
                <input class="AltaVideo" type="text" name="duracionVideo" /><br />
                URL:<br />
                <input class="AltaVideo" type="text" name="urlVideo" /><br />
                Descripcion:<br />
                <input class="AltaVideo" type="text" name="descVideo" /><br />
                Fecha:<br />
                <script class="AltaVideo" type="text/javascript" src="fechaInput.js"></script>
                <input class="AltaVideo" type="text" id="datepicker" name="fechaVideo"><br />
                Categoria:<br />

                <select class="AltaVideo" name="categoria">
                	<option value="Sin Categoria">Sin Categoria</option>
               		<%
               		DtCategoria[] cat = (DtCategoria[]) request.getAttribute("listadoCat");
			     	String opciones="";
			       	for (int i=0;i<cat.length;i++)
			       	{
			       	 opciones=opciones+"<option value="+cat[i].getNombre()+">"+cat[i].getNombre()+"</option>";
			
		 	     	}
      				%>
                    <%=opciones %>
                </select><br />
                <button class="AltaVideo"  name="opcion" value="altaVideo">Crear</button>
            </form>
        </div>
    </div>
</body>

</html>
