<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <%@ page import = "uytubeLogic.logica.DtCategoria"%>
  <%@ page import = "uytubeLogic.logica.Fabrica"%>
  <%@ page import = "uytubeLogic.logica.IVideoCtrl"%>
  <%@ page import = "uytubeLogic.logica.IUsuarioCtrl"%>
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
            <input type="text" name="nickname" id="nickname" ><br>
            Correo electronico:<br>
            <input type="email" name="email" id="email" onchange="comprobarDisponibilidadUsr()"><br>
            <p id=disponible></p>
            <script>
           		 function comprobarDisponibilidadUsr() {
           			var xhttp = new XMLHttpRequest();
	                xhttp.onreadystatechange = function () {
	                  if (this.readyState == 4 && this.status == 200) {
	                    document.getElementById("disponible").innerHTML = this.responseText;
	                  }
	                };
	                xhttp.open("POST", "nuevoUsuario?opcion=nuevoUsuario&nick="+document.getElementById("nickname").value+"&email="+document.getElementById("email").value, true);
	                xhttp.send();
              	}
            </script>
            <script>
                    function comprobarFormulario(frm){
                    	
	            		contra1= document.getElementById("pass1").value;
	                 	contra2= document.getElementById("pass2").value;
	            		if(contra1!=contra2){
	                 	   	alert("Las contraseñas son distintas!"); 
	                     }                      
	
	            	    if(contra1==contra2){
	            			return true;
	            		 }else{
	            		    return false;
	            		 }
            		 }
            </script>
            Nombre:<br>
            <input type="text" name="nombre"><br>
            Apellido:<br>
            <input type="text" name="apellido"><br>
            Contraseña:<br>
            
            <input type="password" id="pass1" name="contrasenia"><br>
            Confirmar Contraseña:<br>
            <input type="password" id="pass2" name="contraseniaConfirmacion"><br>
			<a id=correctaPass></a>
            
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
            <input type="radio" name="privacidad" value="PRIVADO">Privado
            <input type="radio" name="privacidad" value="PUBLICO">Publico<br>
            Categoria(opcional)<br>
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
			
            <button id="crearUsuario" name="opcion" value="nuevoUsuario" onclick="return comprobarFormulario(this.form)">Crear</button>
        	

    	</form>
    </div>
    </div>

</body>
</html>
