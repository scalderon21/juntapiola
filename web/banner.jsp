<%-- 
    Document   : banner
    Created on : 16-06-2018, 15:28:39
    Author     : yanis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p align="right"><font color="green">Usuario Conectado: ${sessionScope.nombreUsuario}</font></p>
        <p align="right"><font color="green">Correo Usuario: ${sessionScope.correoUsuario}</font></p>
    </body>
</html>
