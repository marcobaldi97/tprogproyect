<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <%@include file = "WEB-INF/cosasComunesDelHead.jsp" %>
    <link rel="stylesheet" href="media/styles/AltaVideo.css">

    <%@ page import = "uytubeLogic.logica.DtCategoria"%>
    <%@ page import = "uytubeLogic.logica.Fabrica"%>
    <%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
    <title>Alta Video</title>
</head>

<body>
    <%@include file = "WEB-INF/buscador.jsp" %>
    <div class="main-container">
        <%@include file = "WEB-INF/sidebar.jsp" %>
        <div class="main-content">
            <form action="/UyTubeWeb/newVideo" method="get">
                Nombre del Video:<br />
                <input type="text" name="nombreVideo" /><br />
                Duracion:<br />
                <input type="text" name="duracionVideo" /><br />
                URL:<br />
                <input type="text" name="urlVideo" /><br />
                Descripcion:<br />
                <input type="text" name="descVideo" /><br />
                Fecha:<br />
                <script type="text/javascript" src="fechaInput.js"></script>
                <input type="text" id="datepicker" name="fechaVideo"><br />
                Categoria:<br />

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
                <button id="crearVideo" name="opcion" value="altaVideo">Crear</button>
            </form>
        </div>
    </div>
</body>

</html>
