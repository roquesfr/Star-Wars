<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@page import="fr.ldnr.starwars.modele.Grade" %>
        <%@page import="fr.ldnr.starwars.modele.EtatPilote" %>
            <%@page import="fr.ldnr.starwars.modele.Race" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                    <html lang="fr">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
                        <link rel="stylesheet" href="assets/style/style.css">
                        <title>Recherche avancée de pilote</title>
                    </head>

                    <body>
                        <!--HEADER-->
                        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
                        <main>
                            <div class="form">
                                <h1>Recherche Avancée : </h1>

                                <form action="ListePilotes" method="GET">
                                    <label for="recherche">Nom du pilote : </label>
                                    <input type="text" name="recherche" id="recherche">

                                    <label for="race">Race</label>
                                    <select name="race" id="race">
                                        <option value="">Toutes</option>
                                        <c:forEach items="${Race.values()}" var="race">
                                            <option value="${race}">${race}</option>
                                        </c:forEach>
                                    </select>

                                    <div id="listRadio">
                                        <div>
                                            <label>Grade : </label>
                                            <div id="list">
                                                <span>
                                                    <input type="radio" name="grade" id="gradevide" value="" checked>
                                                    <label for="gradevide">Tous</label>
                                                </span>
                                                <c:forEach items="${Grade.values()}" var="grade">
                                                    <div>
                                                        <input type="radio" name="grade" id="grade${grade}"
                                                            value="${grade}">
                                                        <label for="grade${grade}">${grade.label}</label>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div>
                                            <label>Etat : </label>
                                            <div id="list">
                                                <span>
                                                    <input type="radio" name="etat" id="etatvide" value="" checked>
                                                    <label for="etatvide">Tous</label>
                                                </span>
                                                <c:forEach items="${EtatPilote.values()}" var="etat">
                                                    <div>
                                                        <input type="radio" name="etat" id="etat${etat}"
                                                            value="${etat}">
                                                        <label for="etat${etat}">${etat.label}</label>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <input type="submit" value="Rechercher">
                                        <input type="reset" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </main>
                        <!--FOOTER-->
                        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
                    </body>

                    </html>