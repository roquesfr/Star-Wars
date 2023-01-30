<%-- Document : liste_pilotes Created on : 27 janv. 2023, 11:08:08 Author : stag --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
        <link rel="stylesheet" href="assets/style/style.css">
        <title>Liste des pilotes</title>
    </head>

    <body>
        <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
            <<<<<<< HEAD
            <main>
                <div class="form">
                    <h1>Pilotes : </h1>
                    <div>
                        <ul>
                        <c:forEach items="${pilotes}" var="pilote">
                            <li>
                                <form action="EditionPiloteServlet" method="post">
                                    <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
                                    <c:out value="${pilote.id_pilote}"/> -
                                    <c:out value="${pilote.grade.label}"/> -
                                    <c:out value="${pilote.prenom}"/> -
                                    <c:out value="${pilote.nom}"/> -
                                    <c:out value="${pilote.race.label}"/> -
                                    <c:out value="${pilote.age}"/> ans -
                                    <c:out value="${pilote.etat.label}"/>
                                    <c:if test="${pilote.possedeChasseur()}">|
                                        <c:out value="${pilote.chasseur.modele.label}"/> n°
                                        <c:out value="${pilote.chasseur.id_chasseur}"/>
                                    </c:if>
                                    <button type="submit">Modifier</button>
                                </form>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>