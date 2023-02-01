<%-- Document : liste_chasseurs Created on : 27 janv. 2023, 08:58:02 Author : stag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur" %>
<!DOCTYPE html>
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <main>
                <div class="form">
                    <h1>Chasseurs:</h1>
                    <div>
                        <ul>
                        <c:forEach items="${chasseurs}" var="chasseur">
                            <li>
                                <form action="editionChasseur" method="get">
                                    <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
                                    <c:out value="${chasseur.matricule}"/> - 
                                    <c:out value="${chasseur.etat.label}"/>
                                    <c:if test="${chasseur.etat != EtatChasseur.Affecte}">
                                        <button type="submit">Modifier</button>
                                    </c:if>
                                </form>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>