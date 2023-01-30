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
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <h1>Missions: </h1>
        <div>
            <table>
                <c:forEach items="${missions}" var="mission">
                    <tr>
                        <td><c:out value="${mission.id_mission}"/></td>
                        <td><c:if test="${!mission.completee}">Non </c:if>Complétée</td>
                        <td><c:out value="${mission.dureeHeures}"/>h</td>
                        <td><form action="DetailMission" method="POST">
                                <input type="hidden" name="id" value="${mission.id_mission}">
                                <input type="submit" value="Détail">
                            </form></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
