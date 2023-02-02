<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.Race"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <main>
                <div class="form">
                <h1>Création d'un nouveau pilote</h1>

                <form action="creationPilote" method="post" style="display: flex; flex-direction: column">
                    <div style="display: flex;column-gap: 1em ">
                        <label  for="nom" style="flex-basis: 8.2em">Nom du pilote : </label>
                        <input type="text" name="nom" id="nom" placeholder="Solo" pattern="[/\p{L}/\s-]+" required>
                    </div>
                    <div style="display: flex;column-gap: 1em">
                        <label  for="prenom" style="flex-basis: 8.2em">Prénom du pilote : </label>
                        <input type="text" name="prenom" id="prenom" placeholder="Han" pattern="[/\p{L}/\s-]+" required>
                    </div>
                    <div style="display: flex;column-gap: 1em">
                        <label  for="race" style="flex-basis: 8.2em">Race du pilote : </label>
                        <select name="race" id="race">
                        <c:forEach items="${Race.values()}" var="race">
                            <option value="${race}">${race.label}</option>  
                        </c:forEach>
                    </select>
                </div>
                <!--            <div>
                                <label for="race" id="race">Race du pilote : </label>
                                <input type="text" name="race" id="race" placeholder="Humain" required>
                            </div>-->
                <div style="display: flex;column-gap: 1em">
                    <label  for="age" style="flex-basis: 8.2em">Age du pilote : </label>
                    <input type="number" name="age" id="age" min="10" max="800" placeholder="10-800" required>
                </div>
                <div>
                <input type="submit" value="Valider l'inscription">
                <input type="reset" value="Reset">
            </div>
            </form>
        </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
