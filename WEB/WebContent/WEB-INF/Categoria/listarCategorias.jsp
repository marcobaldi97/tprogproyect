<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "uytubeLogic.logica.DtCategoria"%>

<!DOCTYPE html>
<html>

<head>
    <%@include file = "../cosasComunesDelHead.jsp" %>
    <meta charset="UTF-8">
    <title>UyTube</title>
</head>

<body>
    <form id="listaCategorias" action="consult" method="post">
        <%
            DtCategoria[] categorias = (DtCategoria[]) request.getAttribute("listarCategorias");
            for (DtCategoria categoria : categorias) {
                String nombreCategoria = categoria.getNombre();
	    %>
            <input type="hidden" name="action" value="consult" class="btn-link">
            <button type="submit" name="type" value="<%= nombreCategoria %>" class="btn-link">
                <%= nombreCategoria %>
            </button><br>
        <%
            }
        %>
    </form>
</body>

</html>
