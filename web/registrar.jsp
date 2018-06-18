<%-- 
    Document   : registrar.jsp
    Created on : 06-10-2017, 19:29:21
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NUEVO USUARIO</title>
        <link rel="stylesheet" href="misestilos.css">
    </head>
    <body>
        <h1>CREAR NUEVO USUARIO</h1>
        <form name="usuario" action="crearUsuarioServlet" method="POST">
        <p>Correo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='email' name='correo' size='50' required/></p>
        <p>Nombre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='nombre' size='45' required/></p>
        <p>Clave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='password' name='clave' size='30' required/></p>
        <br>
        <input type='submit' value='CREAR' name='ing_usuario' />
        <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
        </form><br>
    <p><c:out value="${requestScope.mensajeError}"/> </p>
    </body>
</html>
