<%-- 
    Document   : liste_chasseurs
    Created on : 27 janv. 2023, 08:58:02
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
        <h1>Chasseurs: </h1>
        <div>
            <ul>
                <c:forEach items="${chasseurs}" var="chasseur">
                    <li>
                        <c:out value="${chasseur.id_chasseur}"/> -
                        <c:out value="${chasseur.modele}"/> -
                        <c:out value="${chasseur.etat}"/>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
