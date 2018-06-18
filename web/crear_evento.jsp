<%-- 
    Document   : crear_evento
    Created on : 18-jun-2018, 13:08:44
    Author     : sebai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CREAR EVENTO</title>
    </head>
    <body>
        <h1>CREAR EVENTO</h1>
        <form name="evento" action="crearEventoServlet" method="POST">
        <p>Correo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='email' name='correo' size='50' required/></p>
        <p>Nombre&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='nombre' size='45' required/></p>
        <p>Clave&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='password' name='clave' size='30' required/></p>
        <br>
        <input type='submit' value='CREAR' name='crear_evento' />
        <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
        </form><br>
    <p><c:out value="${requestScope.mensajeError}"/> </p>
    </body>
</html>
