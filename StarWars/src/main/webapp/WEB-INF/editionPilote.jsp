<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/style/style.css">
        <title>Edition pilote</title>
    </head>

    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <main>
                <div class="form">
                    <h1>Mise à jour de la fiche du pilote : </h1>
                    <form action="MajPiloteServlet" method="post">
                        <div id="listRadio">
                            <div>
                                <label>Etat du pilote : </label>
                                <div id="list">
                                <c:if test="${pilote.etat == EtatPilote.EnMission}">
                                    <p>Le pilote est en mission.<br/>
                                        Veuillez clôturer la mission en cours avant de changer l'état du pilote.</p>
                                    </c:if>
                                    <c:if test="${pilote.etat != EtatPilote.EnMission}">
                                        <c:forEach items="${EtatPilote.values()}" var="etat">
                                            <c:if test="${etat.selectionable}">
                                            <input id="etat_${etat}" type="radio" name="etat_pilote" value="${etat}" 
                                                   <c:if test="${etat == pilote.etat}">checked </c:if>>
                                            <label for="etat_${etat}">${etat.label}</label>
                                        </c:if>
                                    </c:forEach>
                                    <br>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label>Grade du pilote : </label>
                            <div id="list">
                                <c:forEach items="${Grade.values()}" var="grade">
                                    <input id="grade_${grade}" type="radio" name="grade_pilote" value="${grade}"
                                           <c:if test="${grade == pilote.grade}">checked</c:if>>
                                    <label for="grade_${grade}">${grade.label}</label>
                                </c:forEach>
                            </div>
                        </div>
                        <div>
                            <c:if test="${pilote.possedeChasseur()}">
                                <p>Chasseur du pilote : ${pilote.chasseur.modele.label} n° ${pilote.chasseur.id_chasseur}</p>
                            </c:if>
                            <label for="modele">Chasseur</label>
                            <select name="modele" id="modele">
                                <c:if test="${pilote.possedeChasseur()}">
                                    <option value="">Conserver</option>
                                </c:if>
                                <option value="-1">Aucun</option>
                                <c:forEach items="${chasseurs}" var="chasseur">
                                    <option value="${chasseur.id_chasseur}">${chasseur.id_chasseur}-${chasseur.modele.label}-${chasseur.etat.label}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <aside>
                        <p>État du pilote : ${pilote.etat.label}</p>
                        <p>Grade du pilote : ${pilote.grade.label}</p>
                    </aside>

                    <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
                    <!--<button type="submit">Modifier</button>-->
                    <div>
                        <input type="submit" value="Valider la mise à jour">
                        <input type="reset" value="Reset">
                    </div>
                </form>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>