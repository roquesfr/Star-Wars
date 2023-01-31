<%-- 
    Document   : liste_pilotes
    Created on : 27 janv. 2023, 11:08:08
    Author     : stag
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.EtatChasseur"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <!-- HEAD -->
    <jsp:include page="head.jsp"></jsp:include>
        <body>
            <!--HEADER-->
        <jsp:include page="/WEB-INF/header.jsp"></jsp:include>

            <main>
                <div class="form">
                    <h1><c:out value="${mission.intitule}"/> </h1>
                <div>
                    <form action="clotureMission" method="POST">
                        <h2>Participants</h2>
                        <table>
                            <c:forEach items="${mission.pilotes}" var="pilote">
                                <tr>

                                    <td>
                                        <c:out value="${pilote.grade.label}"/>
                                    </td>
                                    <td>
                                        <c:if test="${!mission.completee}">
                                            <select name="etat_${pilote.id_pilote}" id="etat_${pilote.id_pilote}">
                                                <c:forEach items="${EtatPilote.values()}" var="etat">
                                                    <c:if test="${etat.selectionable}">
                                                        <option value="${etat}"
                                                                <c:if test="${etat == EtatPilote.Disponible}">selected</c:if>>
                                                            ${etat.label}
                                                        </option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:out value="${pilote.prenom}"/> 
                                        <c:out value="${pilote.nom}"/>
                                    </td>
                                    <td><c:out value="${pilote.race}"/></td>
                                    <td><c:out value="${pilote.age}"/> ans</td>
                                    <c:if test="${!mission.completee}">
                                        <td><c:out value="${pilote.chasseur.modele}"/></td>
                                        <td>
                                            <select name="etatChasseur_${pilote.id_pilote}" id="etatChasseur_${pilote.id_pilote}">
                                                <c:forEach items="${EtatChasseur.values()}" var="etat">
                                                    <option value="${etat}"
                                                            <c:if test="${etat == EtatChasseur.Affecte}">selected</c:if>>
                                                        ${etat.label}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                        </table>
                        <h2>Cloture</h2>
                        <c:if test="${mission.completee}">
                            Cette mission a déjà été cloturée.<br/>
                            Durée: <c:out value="${mission.dureeHeures}"/>h
                        </c:if>
                        <c:if test="${!mission.completee}">

                            <input type="hidden" name="id" value="${mission.id_mission}">
                            <label for="nbHeures">Durée en heures: </label>
                            <input type="number" name="nbHeures" id="nbHeures" min="1" required><br/>
                            <div>
                                <input type="submit" value="Cloturer">
                            </div>

                        </c:if>
                    </form>
                </div>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>
</html>
