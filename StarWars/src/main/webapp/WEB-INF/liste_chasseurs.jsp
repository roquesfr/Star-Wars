<%-- 
    Document   : liste_chasseurs
    Created on : 27 janv. 2023, 08:58:02
    Author     : stag
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rebelles.ga</title>
    </head>
    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
        <h1>Chasseurs:</h1>
        <div>
            <ul>
                <c:forEach items="${chasseurs}" var="chasseur">
                    <li>
                        <form action="EditionChasseurServlet" method="get">
                            <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
                            <c:out value="${chasseur.id_chasseur}"/> -
                            <c:out value="${chasseur.modele.label}"/> -
                            <c:out value="${chasseur.etat.label}"/>
                            <button type="submit">Modifier</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
