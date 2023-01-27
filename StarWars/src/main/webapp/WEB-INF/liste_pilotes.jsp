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
            <table>
                <c:forEach items="${pilotes}" var="pilote">
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
                </c:forEach>
            </table>
        </div>
    </body>
</html>
