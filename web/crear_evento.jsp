<%-- 
    Document   : listar_amigos
    Created on : 16-06-2018, 19:29:55
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="banner.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Junta Piola</title>
        <link rel="shortcut icon" href="imagenes/icono.png">
        <link rel="stylesheet" href="misestilos.css">
    </head>
    <body>
        <h1>CREAR EVENTO</h1>
        <form name="evento" action="crearEventoServlet" method="POST">
        <p>Nombre Evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='nombreEvento' required/></p>
        <p>Tipo de Evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <select name="tipoEvento">
            <option value="0" selected>(Seleccione evento:)</option>
            <option value="asado">Asado</option>
            <option value="despedida_de_solteres">Despedida de solteres</option>
            <option value="matrimonio">Matricidio</option>
            <option value="futbol">Futbol</option>
            <option value="only_amiguis">Only Amigüis</option>
        </select>
        <p>Quorum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='number' name='quorum' required/></p>
        <p>Valor total&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='number' name='total' required/></p> 
        <p>Fecha del evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='fecha' pattern="/^(0[1-9]|[12]\d|3[01])[\/]0[1-9]|1[0-2])[\/](19|20)\d{2}$/g" required/></p>
        <br>
        
        <c:if test="${requestScope.cantidadAmigos > 0 }">
            <table><tr><td>Correo</td><td>Nombre</td></tr>
                <c:forEach items="${requestScope.listaAmigos}" var="amigo">
                    <tr>
                        <td><c:out value="${amigo.correoAmigo}"></c:out></td>
                        <td><c:out value="${amigo.nombreAmigo}"></c:out></td>
                        <td><input type="button" value="Modificar" onclick="location='buscarAmigoServlet?correo=${amigo.correoAmigo} &correoUsuario=${amigo.correoUsuario}'"/></td>
                        <td><input type="button" value="Eliminar" onclick="location='eliminarAmigoServlet?correoAmigo=${amigo.correoAmigo} &correoUsuario=${amigo.correoUsuario}'"/></td>
                    </tr>
                </c:forEach>
            </table><br>
            Total de Amigos = <c:out value="${requestScope.cantidadAmigos}" escapeXml="true"></c:out>          
        </c:if><br>
        
        <input type="hidden" value='${sessionScope.correoUsuario}' name='correoUsuario'/>
        <input type='submit' value='CREAR' name='crear_evento' />
        <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
        </form><br>
    <p><c:out value="${requestScope.mensajeError}"/> </p>
    </body>
</html>
