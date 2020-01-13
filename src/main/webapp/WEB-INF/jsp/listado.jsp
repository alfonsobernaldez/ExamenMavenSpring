<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Stock de Motores</h1>
        
        <a href="alta.htm">Nueva motor</a>
        <table>
            <tr>
                <th>Modelo</th>
                <th>Fabricante</th>
                <th>Potencia</th>
                <th>Peso</th>
                <th>Cantidad</th>
            </tr>
            <c:forEach items="${motores}" var="motor">
                <tr>
                    <td>
                        <c:out value="${motor.modelo}">    </c:out>
                    </td>
                    <td>
                        <c:out value="${motor.fabricante}">    </c:out>
                    </td>
                    <td>
                        <c:out value="${motor.potencia}">    </c:out>
                    </td>
                    <td>
                        <c:out value="${motor.peso}">    </c:out>
                    </td>
                    <td>
                        <c:out value="${motor.cantidad}">    </c:out>
                    </td>
                    <td>Modificar</td>
                    <td>Eliminar</td>
                </tr>
            </c:forEach>
        </table>
            
    </body>
</html>
