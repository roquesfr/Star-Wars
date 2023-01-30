<%-- Document : liste_chasseurs Created on : 27 janv. 2023, 08:58:02 Author : stag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/style/style.css">
        <title>Liste des chasseurs</title>
    </head>

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
                                <form action="EditionChasseurServlet" method="get">
                                    <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
                                    <c:out value="${chasseur.id_chasseur}"/> -
                                    <c:out value="${chasseur.modele.label}"/> -
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