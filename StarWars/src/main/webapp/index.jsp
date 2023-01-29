<%-- 
    Document   : index.jsp
    Created on : 27 janv. 2023, 16:08:46
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <title>Rebelles.ga</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="logo.png" />
    </head>
    <body>
        <h1>Hello Rebelles!</h1>
        <form action="ListePilotes" method="GET">
            <label for="recherche">Recherche pilote</label>
            <input type="text" id="recherche" name="recherche">
            <input type="submit" value="Go">
        </form>
        <a href="RechercheAvancee">Recherche avancée</a>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
