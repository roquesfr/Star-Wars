<%-- 
    Document   : creationChasseur
    Created on : 27 janv. 2023, 10:10:26
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>

    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <form action="CreationChasseurServlet" method="post">

            <label for="modele">Modele de chasseur</label>

            <select name="modele" id="modele">
                <c:forEach items="${ModeleChasseur.values()}" var="modele">
                <option value="${modele}">${modele.label}</option>  
                </c:forEach>
            </select><br>

<%--        <input list="modele" id="modeles" name="modele">
            <datalist id="modele">
                <c:forEach items="${ModeleChasseur.values()}" var="modele">
                    <option value="${modele}" label="${modele.label}"></option>  
                </c:forEach>
            </datalist><br>
--%>


            <label>Etat du chasseur</label><br>

            <c:forEach items="${EtatChasseur.values()}" var="etat">
                <input type="radio" name="etat_chasseur" id="${etat}" value="${etat}">
                <label for="${etat}">${etat.getLabel()}</label><br>
            </c:forEach>

            <button type="submit">BFB</button>

        </form>
<!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>
