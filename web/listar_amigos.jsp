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
                        <td><input type="button" value="Modificar" onclick="location='buscarAmigoServlet?correo=${amigo.correoAmigo} &correoUsuario=${amigo.correoUsuario}'"/></td>
                        <td><input type="button" value="Eliminar" onclick="location='eliminarAmigoServlet?correoAmigo=${amigo.correoAmigo} &correoUsuario=${amigo.correoUsuario}'"/></td>
                    </tr>
                </c:forEach>
            </table><br>
            Total de Amigos = <c:out value="${requestScope.cantidadAmigos}" escapeXml="true"></c:out>          
        </c:if><br>
        <br>
        <c:out value="${requestScope.msj}"/>
        <c:out value="${requestScope.msjBorrado}"/>
        <br>
        <br><input type="button" value="Volver Atrás" onclick="location.href='index.jsp'" style="font-family: Verdana; font-size: 10 pt"><br />
        
    </body>
</html>
