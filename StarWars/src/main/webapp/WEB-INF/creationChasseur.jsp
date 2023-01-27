<%-- 
    Document   : creationChasseur
    Created on : 27 janv. 2023, 10:10:26
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Création Chasseur</title>
</head>

<body>
    <form action="CreationChasseurServlet" method="post">

        <label for="modele">Modele de chasseur</label>

        <select name="modele" id="modele">
            <c:forEach items="${ModeleChasseur.values()}" var="modele">
            <option value="${modele}">${modele.getLabel()}</option>  
            </c:forEach>
        </select><br>

        <label>Etat du chasseur</label><br>
   
        <c:forEach items="${EtatChasseur.values()}" var="etat">
            <input type="radio" name="etat_chasseur" value="${etat}">
            <label>${etat.getLabel()}</label><br>
        </c:forEach>

        <button type="submit">BFB</button>

    </form>
</body>

</html>