<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="ConsultaUsuario.css"/>
    <script type="text/javascript" src="scriptPestanias.js">activarTab(unTab)</script>
 

<title>Consulta Usuario</title>
</head>
<body>
 <table class="tabs" data-min="0" data-max="2">
    <tr>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-0" onclick="activarTab(this)">Inicio</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-1" onclick="activarTab(this)">Videos</th>
        <th class="tabcks">&nbsp;</th>
        <th class="tabck" id="tabck-2" onclick="activarTab(this)">Listas de Reproduccion</th>
    </tr>
    <tr class="filadiv">
        <td colspan="6" id="tab-0">
            <div class="tabdiv" id="tabdiv-0">
                  Datos Usuario (nombre, apellido, descripcion canal, seguidores, etc)
            	  (si es del usurio logeado puede modificar sus datos)
            </div>
            <div class="tabdiv" id="tabdiv-1">
                Videos del canal del usuario
                (cuando selecciona un video, ir a consulta video)
                (si es del usurio logeado puede modificar sus datos)
            </div>
            <div class="tabdiv" id="tabdiv-2">
                Listas de reproduccion
                (como consulta de lista)
                (si es del usurio logeado puede modificar sus datos)
            </div>
        </td>
    </tr>
   
 </table>
  
</body>
</html>