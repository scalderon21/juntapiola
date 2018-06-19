<%-- 
    Document   : invitar_amigos_evento
    Created on : 18-jun-2018, 22:24:52
    Author     : sebai
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="banner.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="misestilos.css">
    </head>
    <body>
        <h1>LISTADO DE AMIGOS</h1><br>
        <c:if test="${requestScope.cantidadAmigos > 0 }">
            <table><tr><th>Correo</th><th>Nombre</th><th> </th><th> </th></tr>
                <c:forEach items="${requestScope.listaAmigos}" var="amigo">
                    <tr>
                    
                        <td><c:out value="${amigo.correoAmigo}"></c:out></td>
                        <td><c:out value="${amigo.nombreAmigo}"></c:out></td>
                        <input type="hidden" value='${requestScope.correoUsuario}' name='correoUsuario'/>
                        <td><button id="btnCorreo" type="button" value="${amigo.correoAmigo}" onclick="location='listarAmigosEventoServlet?correoAmigo=${amigo.correoAmigo} &nombreAmigo=${amigo.nombreAmigo} &correoUsuario=${requestScope.correoUsuario} &cantidadAmigos=${requestScope.cantidadAmigos} &listaAmigos=${requestScope.listaAmigos}'"/>Invitar</button></td>                      
                        
                    </tr>
                </c:forEach>
            </table><br>
            <script>
                function myFunction() {
                    //Ingresamos un mensaje a mostrar
                    var correo = document.getElementById("btnCorreo").value;
                    var mensaje = confirm("¿Enviar invitacion al correo "+correo+"?");
                    //Detectamos si el usuario acepto el mensaje
                    if (mensaje) {
                        alert("¡Mensaje enviado!");
                        document.getElementById("btnCorreo").disabled = true;

                    }
                    //Detectamos si el usuario denegó el mensaje
                    else {
                        alert("¡No se envio el mensaje!");
                    }
                }
</script>
            Total de Amigos = <c:out value="${requestScope.cantidadAmigos}" escapeXml="true"></c:out>          
        </c:if><br>
        <br>
        <br>
        <br><input type="button" value="Volver Atrás" onclick="location.href='crear_evento.jsp'" style="font-family: Verdana; font-size: 10 pt"><br />
        
    </body>
</html>

