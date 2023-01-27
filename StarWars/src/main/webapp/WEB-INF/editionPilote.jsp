<%-- 
    Document   : editionPilote
    Created on : 27 janv. 2023, 16:09:43
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edition Pilote</title>
    </head>
    <body>
        <form action="MajPiloteServlet" method="post">

            <c:forEach items="${EtatPilote.values()}" var="etat">
                <input id="etat_${etat}" type="radio" name="etat_pilote" value="${etat}">
                <label for="etat_${etat}">${etat.label}</label>
            </c:forEach>
                <br>
            <c:forEach items="${Grade.values()}" var="grade">
                <input id="grade_${grade}" type="radio" name="grade_pilote" value="${grade}">
                <label for="grade_${grade}">${grade.label}</label>
            </c:forEach>

            <p>État du pilote : ${pilote.etat.label}</p>
            <p>Grade du pilote : ${pilote.grade.label}</p>
            <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
            <button type="submit">Modifier</button>
        </form>
    </body>
</html>
