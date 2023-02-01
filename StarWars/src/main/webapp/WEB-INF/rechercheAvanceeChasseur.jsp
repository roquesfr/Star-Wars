<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
        <body>
            <!--HEADER-->
            <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
                <main>
                    <div class="form">
                        <h1>Recherche Avancée Chasseur : </h1>

                        <form action="rechercheAvanceeChasseur" method="GET">

                            <input type="hidden" name="recherche" value="avancee">
                            
                                
                            <c:forEach items="${ModeleChasseur.values()}" var="modele">
                                <input type="checkbox" name="${modele}" id="${modele}" value="${modele}">
                                <label for="${modele}">${modele.label}</label>
                            </c:forEach>
                        
                        <div id="listRadio">
                            <div>
                                <label>Etat : </label>
                                <div id="list">
                                    <span>
                                        
                                    </span>
                                    <c:forEach items="${EtatChasseur.values()}" var="etat">
                                        <div>
                                            <input type="checkbox" name="${etat}" id="etat_${etat}"
                                                   value="${etat}"
                                                   <c:if test="${etat == EtatChasseur.Operationnel}">checked</c:if>>
                                            <label for="etat_${etat}">${etat.label}</label>
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
