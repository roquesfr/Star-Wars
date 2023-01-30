<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur" %>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>

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

                    <label for="modele">Modele de chasseur</label>

                    <select name="modele" id="modele">
                        <c:forEach items="${ModeleChasseur.values()}" var="modele">
                            <option value="${modele}">${modele.label}</option>  
                        </c:forEach>
                    </select><br>

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
                <c:forEach items="${EtatChasseur.values()}" var="etat">
                    <c:if test="${etat.selectionable}">
                        <input type="radio" name="etat_chasseur" id="${etat}" value="${etat}"
                               <c:if test="${etat == EtatChasseur.Operationnel}">checked</c:if>>
                        <label for="${etat}">${etat.getLabel()}</label><br>
                    </c:if>
                </c:forEach>

                <button type="submit">Créer</button>

                </form>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>

