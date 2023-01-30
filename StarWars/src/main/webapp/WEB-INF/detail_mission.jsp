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
        <h1>Mission n° <c:out value="${mission.id_mission}"/> </h1>
        <div>
            <h2>Cloture</h2>
            <c:if test="${mission.completee}">
                Cette mission a déjà été cloturée.<br/>
                Durée: <c:out value="${mission.dureeHeures}"/>h
            </c:if>
            <c:if test="${!mission.completee}">
                <form action="ClotureMission" method="POST">
                    <input type="hidden" name="id" value="${mission.id_mission}">
                    <label for="nbHeures">Durée en heures: </label>
                    <input type="number" name="nbHeures" id="nbHeures" min="1" required><br/>
                    <input type="submit" value="Cloturer">
                </form>
            </c:if>
            <h2>Participants</h2>
            <c:forEach items="${mission.pilotes}" var="pilote">
                <table>
                    <tr>
                        <td><c:out value="${pilote.id_pilote}"/></td>
                        <td><c:out value="${pilote.grade.label}"/></td>
                        <td>
                            <c:out value="${pilote.prenom}"/> 
                            <c:out value="${pilote.nom}"/>
                        </td>
                        <td><c:out value="${pilote.race}"/></td>
                        <td><c:out value="${pilote.age}"/> ans</td>
                        <td><c:out value="${pilote.etat.label}"/></td>
                    </tr>
                </table>
            </c:forEach>
        </div>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
