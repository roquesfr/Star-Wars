<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Race"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <h1>Recherche Avancée</h1>

            <form action="ListePilotes" method="GET">
                <label for="recherche">Nom du pilote : </label>
                <input type="text" name="recherche" id="recherche">

                <label for="race">Race</label>
                <select name="race" id="race">
                    <option value="" >Toutes</option>
                <c:forEach items="${Race.values()}" var="race">
                    <option value="${race}">${race}</option>  
                </c:forEach>
            </select>

            <label for="chasseur">Chasseur</label>
            <select name="chasseur" id="chasseur">
                <option name="modele">Tous</option>
                <c:forEach items="${ModeleChasseur.values()}" var="modele">
                    <option value="${modele}">${modele.label}</option>
                </c:forEach>
            </select><br>

            <p>Grade</p>
            <input type="radio" name="grade" id="gradevide" value="" checked>
            <label for="gradevide">Tous</label><br/>
            <c:forEach items="${Grade.values()}" var="grade">
                <input type="radio" name="grade" id="grade${grade}" value="${grade}">
                <label for="grade${grade}">${grade.label}</label><br>
            </c:forEach>

            <p>Etat</p>
            <input type="radio" name="etat" id="etatvide" value="" checked>
            <label for="etatvide">Tous</label><br/>
            <c:forEach items="${EtatPilote.values()}" var="etat">
                <input type="radio" name="etat" id="etat${etat}" value="${etat}">
                <label for="etat${etat}">${etat.label}</label><br>
            </c:forEach>


            <input type="submit" value="Chercher">
        </form>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
