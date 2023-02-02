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
                    <div style="display:flex; flex-direction: row; flex-wrap: wrap; gap:1em 3%">

                    <c:forEach items="${chasseurs}" var="chasseur">

                        <form action="editionChasseur" method="get" style="display: flex;flex-direction: column; row-gap: .7em; flex-basis: 27%">
                            <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
                            <c:out value="${chasseur.matricule}"/> - 
                            <c:out value="${chasseur.etat.label}"/>
                            <c:choose>
                                <c:when test="${chasseur.etat != EtatChasseur.Affecte}">
                                <button type="submit" >Modifier</button>
                            </c:when>
                            <c:otherwise>
                                <button type="button" disabled >Modifier</button>
                            </c:otherwise>
                            </c:choose>
                            
                        </form>

                    </c:forEach>

                </div>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>