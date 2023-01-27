<%-- 
    Document   : editionChasseur
    Created on : 27 janv. 2023, 12:12:04
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edition Chasseur</title>
    </head>
    <body>
        <form action="MajChasseurServlet" method="post">
            <select name="modele"> 
                <c:forEach items="${ModeleChasseur.values()}" var="modele">
                    <option value="${modele}">${modele.label}</option>   
                </c:forEach>
            </select>
            
            <c:forEach items="${EtatChasseur.values()}" var="etat">
                <input type="radio" name="etat_chasseur" value="${etat}">
                <label>${etat.label}</label>
            </c:forEach>
                
            <p>Modèle du chasseur : ${chasseur.modele.label}</p>
            <p>État du chasseur : ${chasseur.etat.label}</p>
            <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
            <button type="submit">Modifier</button>
        </form>
    </body>
</html>
