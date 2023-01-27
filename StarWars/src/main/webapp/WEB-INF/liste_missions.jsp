<%-- 
    Document   : liste_pilotes
    Created on : 27 janv. 2023, 11:08:08
    Author     : stag
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rebelles.ga</title>
    </head>
    <body>
        <header>
            <a href="index.html">Retour à l'accueil</a>
        </header>
        <h1>Missions: </h1>
        <div>
            <table>
                <c:forEach items="${missions}" var="mission">
                    <tr>
                        <td><c:out value="${mission.id_mission}"/></td>
                        <td><c:if test="${!mission.completee}">Non </c:if>Complétée</td>
                        <td><c:out value="${mission.dureeHeures}"/>h</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
