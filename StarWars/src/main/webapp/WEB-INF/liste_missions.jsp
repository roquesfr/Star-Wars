<%-- Document : liste_pilotes Created on : 27 janv. 2023, 11:08:08 Author : stag --%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
                <link rel="stylesheet" href="assets/style/style.css">
                <title>Liste des missions</title>
            </head>

            <body>
                <!--HEADER-->
                <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
                <main>
                    <div class="form">
                        <h1>Missions: </h1>
                        <div>
                            <table>
                                <c:forEach items="${missions}" var="mission">
                                    <tr>
                                        <td>
                                            <c:out value="${mission.id_mission}" />
                                        </td>
                                        <td>
                                            <c:if test="${!mission.completee}">Non </c:if>Complétée
                                        </td>
                                        <td>
                                            <c:out value="${mission.dureeHeures}" />h
                                        </td>
                                        <td>
                                            <form action="DetailMission" method="POST">
                                                <input type="hidden" name="id" value="${mission.id_mission}">
                                                <input type="submit" value="Détail">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </main>
                <!--FOOTER-->
                <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
            </body>

            </html>