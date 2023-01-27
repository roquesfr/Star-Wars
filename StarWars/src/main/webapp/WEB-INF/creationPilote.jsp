<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.Race"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html lang="fr">
    <head>
        <title>Création d'un nouveau pilote</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Création d'un nouveau pilote</h1>

        <form action="CreationPiloteServlet" method="post">
            <div>
                <label for="nom" id="nom">Nom du pilote : </label>
                <input type="text" name="nom" id="nom" placeholder="Solo" required>
            </div>
            <div>
                <label for="prenom" id="prenom">Prénom du pilote : </label>
                <input type="text" name="prenom" id="prenom" placeholder="Han" required>
            </div>
            <div>
                <label for="race" id="race">Race du pilote : </label>
                <select name="race" id="race">
                    <c:forEach items="${Race.values()}" var="race">
                        <option value="${race}">${race.getLabel()}</option>  
                    </c:forEach>
                </select>
            </div>
            <!--            <div>
                            <label for="race" id="race">Race du pilote : </label>
                            <input type="text" name="race" id="race" placeholder="Humain" required>
                        </div>-->
            <div>
                <label for="age" id="age">Age du pilote : </label>
                <input type="number" name="age" id="age" min="10" max="800" placeholder="10-800" required>
            </div>
            <input type="submit" value="Valider">
        </form>
    </body>
</html>
