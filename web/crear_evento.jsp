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
        
        <input type='button' value='Invitar amigos Evento' onclick="location.href='listarAmigosEventoServlet?correoUsuario=${sessionScope.correoUsuario}'" style=' font-family: Verdana; font-size: 10 pt'><br />
        <br>  
        <br>  
        <br>  
       
        <c:if test="${sessionScope.misAmigosEvento != null }">
        
            <form name="evento" action="crearEventoServlet" method="POST">
            <p>Nombre Evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='nombreEvento' required/></p>
            <p>Tipo de Evento&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="tipoEvento" required>
                <option value="0" selected>(Seleccione evento:)</option>
                <option value="asado">Asado</option>
                <option value="despedida_de_solteres">Despedida de solteres</option>
                <option value="matrimonio">Matricidio</option>
                <option value="futbol">Futbol</option>
                <option value="only_amiguis">Only Amigüis</option>
            </select>
            <p>Quorum&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='number' name='quorum' required/></p>
            <p>Valor total&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='number' name='total' required/></p> 
            <p>Fecha del evento (dd/mm/aaaa)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name='fecha' pattern="/^(0[1-9]|[12]\d|3[01])[\/]0[1-9]|1[0-2])[\/](19|20)\d{2}$/g" required/></p>
            <br> 
            <table><tr><th>Correo</th><th>Nombre</th><th> </th><th> </th></tr>
                <c:forEach items="${sessionScope.misAmigosEvento}" var="amigo">
                    <tr>                   
                        <td><c:out value="${amigo.correoAmigo}"></c:out></td>
                        <td><c:out value="${amigo.nombreAmigo}"></c:out></td>
                    </tr>
                </c:forEach>
            </table><br>
            <br>    
            <input type="hidden" value='${sessionScope.misAmigosEvento}' name='listaAmigosEvento'/>
            <input type="hidden" value='${sessionScope.correoUsuario}' name='correoUsuario'/>
            <input type='submit' value='CREAR' name='crear_evento' />
            <input type='button' value='HOME' onclick="location.href='index.jsp'" style=' font-family: Verdana; font-size: 10 pt'><br/>
            <br>  
        </c:if>>
        </form><br>
    <p><c:out value="${requestScope.mensajeError}"/> </p>
    </body>
</html>


