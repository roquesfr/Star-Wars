<%-- Document : editionChasseur Created on : 27 janv. 2023, 12:12:04 Author : stag --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="fr.ldnr.starwars.modele.EtatChasseur" %>
            <%@page import="fr.ldnr.starwars.modele.ModeleChasseur" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                    <!DOCTYPE html>
                    <html>

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
                        <link rel="stylesheet" href="assets/style/style.css">
                        <title>Edition chasseur</title>
                    </head>

                    <body>
                        <!--HEADER-->
                        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
                        <main>
                            <div class="form">
                                <h1>Mise à jour de la fiche du chasseur : </h1>
                                <form action="MajChasseurServlet" method="post">
                                    <div>
                                        <label for="race">Modèle du chasseur : </label>
                                        <select name="modele">
                                            <c:forEach items="${ModeleChasseur.values()}" var="modele">
                                                <option value="${modele}">${modele.label}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div id="listRadio">
                                        <div>
                                            <label>Etat du chasseur : </label>
                                            <div id="list">
                                                <c:forEach items="${EtatChasseur.values()}" var="etat">
                                                    <div>
                                                        <input type="radio" name="etat_chasseur" value="${etat}">
                                                        <label>${etat.label}</label>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                    <aside>
                                        <p>Modèle du chasseur : ${chasseur.modele.label}</p>
                                        <p>État du chasseur : ${chasseur.etat.label}</p>
                                    </aside>

                                    <input type="hidden" name="id_chasseur" value="${chasseur.id_chasseur}">
                                    <!--<button type="submit">Modifier</button>-->
                                    <div>
                                        <input type="submit" value="Valider la mise à jour">
                                        <input type="reset" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </main>
                        <!--FOOTER-->
                        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
                    </body>

                    </html>