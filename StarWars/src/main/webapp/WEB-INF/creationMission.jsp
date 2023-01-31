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
                <h1>Création d'une nouvelle mission</h1>

                <form action="creationMission" method="post">
                    <div>
                        <label>Intitulé : </label>
                        <input type="text" name="intitule" id="intitule" pattern="[0-9a-zA-Z/\s-]+" required>
                    </div>
                    <div>
                        <label for="pilotes">Participants : </label>
                        <select name="pilotes" id="pilotes" required multiple>
                            <c:forEach items="${pilotesDispo}" var="pilote">
                                <option value="${pilote.id_pilote}">${pilote.prenom} ${pilote.nom}</option>  
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <input type="submit" value="Valider">
                        <input type="reset" value="Reset">
                    </div>
                </form>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
