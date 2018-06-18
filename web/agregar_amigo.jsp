<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="banner.jsp"/>
<!DOCTYPE html>
<html>
<head>
  <title>Junta Piola</title>
  <link rel="shortcut icon" href="imagenes/icono.png">
  <link rel="stylesheet" href="misestilos.css">
</head>
<body>
    <h1>Agregar Amigo</h1><br>
    <form name='amigos' action='agregarAmigosServlet' method='POST'>
        Ingrese Correo&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type='email' name='correo' size='50' required/><br>
        <br>
        Ingrese Nombre:<input type='text' name='nombre' size='45' required/><br>
        <input type="hidden" value="${sessionScope.correoUsuario}" name="correoUsuario"/><br>
        <input type='submit' value='Agregar'/>
        <input type='button' value='Volver Atrás' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br />
    </form>
    <br>
    <c:out value="${requestScope.msj}"/>
</body>
</html>