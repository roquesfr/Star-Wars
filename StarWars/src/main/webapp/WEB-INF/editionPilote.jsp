<%-- 
    Document   : editionPilote
    Created on : 27 janv. 2023, 16:09:43
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edition Pilote</title>
    </head>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <form action="MajPiloteServlet" method="post">

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

            <c:forEach items="${Grade.values()}" var="grade">
                <input id="grade_${grade}" type="radio" name="grade_pilote" value="${grade}"
                       <c:if test="${grade == pilote.grade}">checked</c:if>>
                <label for="grade_${grade}">${grade.label}</label>
            </c:forEach>
            <br>
            <label for="modele">Chasseur</label>
            <select name="modele" id="modele">
                <option value="0">Aucun</option>
                <c:forEach items="${chasseurs}" var="chasseur">
                    <option value="${chasseur.id_chasseur}">${chasseur.id_chasseur}-${chasseur.modele.label}-${chasseur.etat.label}</option>
                </c:forEach>
            </select>

            <p>Chasseur du pilote : ${pilote.chasseur.id_chasseur}-${pilote.chasseur.modele.label}-${pilote.chasseur.etat}</p>

            <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
            <button type="submit">Modifier</button>
        </form>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
