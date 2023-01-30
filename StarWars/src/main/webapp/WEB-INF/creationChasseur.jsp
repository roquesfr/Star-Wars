<%-- Document : creationChasseur Created on : 27 janv. 2023, 10:10:26 Author : stag --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <%@page import="fr.ldnr.starwars.modele.EtatChasseur" %>
            <%@page import="fr.ldnr.starwars.modele.ModeleChasseur" %>
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                    <!DOCTYPE html>
                    <html lang="fr">

                    <head>
                        <meta charset="UTF-8">
                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <link rel="shortcut icon" href="assets/img/Alliance_Rebelle.png" type="image/x-icon">
                        <link rel="stylesheet" href="assets/style/style.css">
                        <title>Création Chasseur</title>
                    </head>

                    <body>
                        <!--HEADER-->
                        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>
                        <main>
                            <div class="form">
                                <h1>Création d'un nouveau chasseur</h1>

                                <form action="CreationChasseurServlet" method="post">

                                    <label for="modele">Modele de chasseur</label>

                                    <select name="modele" id="modele">
                                        <c:forEach items="${ModeleChasseur.values()}" var="modele">
                                            <option value="${modele}">${modele.label}</option>
                                        </c:forEach>
                                    </select>

                                    <%-- <input list="modele" id="modeles" name="modele">
                                        <datalist id="modele">
                                            <c:forEach items="${ModeleChasseur.values()}" var="modele">
                                                <option value="${modele}" label="${modele.label}"></option>
                                            </c:forEach>
                                        </datalist>
                                        --%>

                                        <div id="listRadio">
                                            <label>Etat du chasseur : </label>
                                            <div id="list">
                                                <c:forEach items="${EtatChasseur.values()}" var="etat">
                                                    <div>
                                                        <input type="radio" name="etat_chasseur" value="${etat}">
                                                        <label>${etat.getLabel()}</label>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <!--<button type="submit">BFB</button>-->
                                        <div>
                                            <input type="submit" value="Valider la création">
                                            <input type="reset" value="Reset">
                                        </div>

                                </form>
                            </div>
                        </main>
                        <!--FOOTER-->
                        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
                    </body>

                    </html>