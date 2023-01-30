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
        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/style/style.css">
    </head>
    <body>
        <!--        <h1>Hello Rebelles!</h1>-->

        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <main>
                <h1>Bienvenue dans l'alliance rebelle !</h1>
                <p>
                    Nous avons besoin de vous <br>
                    Engagez-vous contre l'empire
                </p>
            </main>
            <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
