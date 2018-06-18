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
        <p>Valor total&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='number' name='valor' required/></p>
        <p>Fecha del evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='date' name='fecha' required/></p>
        <br>
        <input type="hidden" value='${sessionScope.correoUsuario}' name='correoUsuario'/>
        <input type='submit' value='CREAR' name='crear_evento' />
        <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
        </form><br>
    <p><c:out value="${requestScope.mensajeError}"/> </p>
    </body>
</html>
