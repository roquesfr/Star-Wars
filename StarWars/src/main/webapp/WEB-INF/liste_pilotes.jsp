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
                            <c:out value="${pilote.etat.label}"/>
                            <button type="submit">Modifier</button>
                        </form>
                    </li>

                </c:forEach>
            </ul>
        </div>
    </body>
</html>
