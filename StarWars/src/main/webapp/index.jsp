<%-- 
    Document   : index.jsp
    Created on : 27 janv. 2023, 16:08:46
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
    <!-- HEAD -->
    <title>Engagez-vous</title>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <body>
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
