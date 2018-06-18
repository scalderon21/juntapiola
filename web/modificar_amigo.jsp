<%-- 
    Document   : modificar_amigo
    Created on : 16-06-2018, 20:21:30
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="misestilos.css">
    </head>
    <body>
        <h1>Modificar Amigo</h1>
        <br>
        <c:if test="${empty requestScope.msj}">
            <form action="modificarAmigosServlet" method="post">
                <input type="hidden" value="${sessionScope.correoUsuario}" name="correoUsuario"/>
                <input type="hidden" value="${requestScope.a.correoAmigo}" name="correoAntiguo"/><br>
                Correo : <input type="email" placeholder="${requestScope.a.correoAmigo}" name="correo" required/><br>
                Nombre : <input type="text" placeholder="${requestScope.a.nombreAmigo}" name="nombre" required/><br>
                <br>
                <input type="submit" value="Modificar"/>
            </form>
        </c:if>
        <c:if test="${not empty requestScope.msj}">
            <c:out value="${requestScope.msj}"/>
            <input type="button" value="Ver amigos" onclick="location='listarAmigosServlet?correoUsuario=${sessionScope.correoUsuario}'">
        </c:if>
        <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
    </body>
</html>