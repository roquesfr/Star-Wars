<%-- 
    Document   : liste_pilotes
    Created on : 27 janv. 2023, 11:08:08
    Author     : stag
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <h1>Pilotes: </h1>
        <div>
            <ul>
                <c:forEach items="${pilotes}" var="pilote">
                    <li>
                        <form action="EditionPiloteServlet" method="post">
                            <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
                            <c:out value="${pilote.id_pilote}"/> -
                            <c:out value="${pilote.grade.label}"/> -
                            <c:out value="${pilote.prenom}"/> -
                            <c:out value="${pilote.nom}"/> -
                            <c:out value="${pilote.race.label}"/> -
                            <c:out value="${pilote.age}"/> ans -
                            <c:out value="${pilote.etat.label}"/> -
                            <c:out value="${nbMission}"/> -
                            <c:out value="${heureVol}h de vol"/> |
                            <c:out value="${pilote.chasseur.id_chasseur}"/>-
                            <c:out value="${pilote.chasseur.modele.label}"/>-   
                            <c:out value="${pilote.chasseur.etat}"/>
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
