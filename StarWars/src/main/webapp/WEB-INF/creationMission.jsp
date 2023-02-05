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

                <c:choose>
                    <c:when test="${pilotesDispo.isEmpty()}">
                        <aside>
                            <p>Aucun pilote n'est disponible.</p>
                        </aside>
                    </c:when>
                    <c:otherwise>
                        <form action="creationMission" method="post">
                            <div>
                                <label>Intitulé : </label>
                                <input type="text" name="intitule" id="intitule" minlength="7" required>
                                <span class="error">Veuillez saisir un intitulé valide ! (Au moins 7 caractères alpha-numérique)</span>
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
                                <input type="submit" id="submitMission" value="Valider">
                                <input type="reset" value="Reset">
                            </div>

                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
        <script src="assets/script/checkFormMission.js"></script>
    </body>
</html>
