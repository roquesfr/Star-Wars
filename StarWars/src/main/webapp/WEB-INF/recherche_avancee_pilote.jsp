<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Race"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
    <head>
        <title>Rebelles.ga</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
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
            </select><br>
            
            Grade
            <input type="radio" name="grade" id="gradevide" value="" checked>
            <label for="gradevide">Tous</label><br/>
            <c:forEach items="${Grade.values()}" var="grade">
                <input type="radio" name="grade" id="grade${grade}" value="${grade}">
                <label for="grade${grade}">${grade.label}</label><br>
            </c:forEach>
            
            Etat
            <input type="radio" name="etat" id="etatvide" value="" checked>
            <label for="etatvide">Tous</label><br/>
            <c:forEach items="${EtatPilote.values()}" var="etat">
                <input type="radio" name="etat" id="etat${etat}" value="${etat}">
                <label for="etat${etat}">${etat.label}</label><br>
            </c:forEach>
            <input type="submit" value="Chercher">
        </form>
    </body>
</html>
