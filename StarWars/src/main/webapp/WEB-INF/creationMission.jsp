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
        <h1>Création d'une nouvelle mission</h1>

        <form action="CreationMission" method="post">
            <div>
                <label>Intitulé : </label>
                <input type="text" name="intitule" id="intitule" required>
            </div>
            <div>
                <label for="pilotes">Participants : </label>
                <select name="pilotes" id="pilotes" required multiple>
                    <c:forEach items="${pilotesDispo}" var="pilote">
                        <option value="${pilote.id_pilote}">${pilote.prenom} ${pilote.nom}</option>  
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Valider">
        </form>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
