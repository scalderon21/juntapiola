<%-- 
    Document   : index
    Created on : 16-06-2018, 15:21:41
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Junta Piola</title>
        <link rel="stylesheet" href="misestilos.css">
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty sessionScope.nombreUsuario}">
                <jsp:include page="banner.jsp"/>
                <!-- Menú de navegación del sitio -->
                <ul class="navbar">
                    <li><a href="registrar.jsp">Crear Evento</a>
                    <li><a href="agregar_amigo.jsp">Agregar Amigo</a>    
                    <li><a href="listarAmigosServlet?correoUsuario=${sessionScope.correoUsuario}">Listar Amigos</a>
                    <li><a href="buscar.jsp">Ver Pagos</a>
                    <li><a href="salir.jsp">Cerrar Sesion</a>
                </ul>
                <!-- Contenido principal -->
                <h1>Tienda Virtual</h1>

                <p>¡Bienvenido a nuestra tienda virtual!

                <p>Aquí encontrará lo que usted está buscando.
                <br>También le informamos que tenemos importantes promociones que no lo dejarán indiferente...

                <p>Estamos a su disposición

                <!-- Este es un comentario en HTML -->
                <address><br></address>
            </c:when>
            <c:otherwise>
                Debe loguearse en el sistema<br>
                <br>
                <c:if test="${not empty requestScope.mensaje}">
                    <p><c:out value="${requestScope.mensaje}"></c:out></p>
                </c:if>
                <h1>INGRESO DE USUARIO</h1>
                <form action="loginServlet" method="POST">
                    Ingrese Correo :<br>
                    <input type="email" name="correo" value="" size="50" required/><br>
                    Ingrese Clave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<br>
                    <input type="password" name="clave" value="" size="10" required/><br>
                    <p><c:out value="${requestScope.mensajeError}"></c:out></p>
                    <br>
                    <br><input type="submit" value="Ingresar" name="ing_login" />
                    <!--<input type="button" value="Volver Atrás" onclick="history.back()" style="font-family: Verdana; font-size: 10 pt"><br />-->
                </form>
                <br>
                <br>Crear un usuario <input type="button" value="Registrar" onclick="location.href='registrar.jsp'"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
