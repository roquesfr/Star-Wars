<%-- Document : liste_pilotes Created on : 27 janv. 2023, 11:08:08 Author : stag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <h1>Pilotes: </h1>
        <div>
            <ul>
            <%--mapGradePilote<Pilote,StatPilote>--%>
                <c:forEach items="${mapGradePilote}" var="map">
                    <li>
                        <form action="EditionPiloteServlet" method="post">
                            <input type="hidden" name="id_pilote" value="${map.key.id_pilote}">
                            <c:out value="${map.key.id_pilote}"/> -
                            <c:out value="${map.value.grade}"/> -
                            <c:out value="${map.key.prenom}"/> -
                            <c:out value="${map.key.nom}"/> -
                            <c:out value="${map.key.race.label}"/> -
                            <c:out value="${map.key.age}"/> ans -
                            <c:out value="${map.key.etat.label}"/> -
                            <c:out value="${map.value.nbMission}"/> -
                            <c:out value="${map.value.nbHeureVol}h de vol"/> |
                            <c:out value="${map.key.chasseur.id_chasseur}"/>-
                            <c:out value="${map.key.chasseur.modele.label}"/>-   
                            <c:out value="${map.key.chasseur.etat}"/>
                            <button type="submit">Modifier</button>
                        </form>
                    </li>

                </c:forEach>
            </ul>
        </div>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>