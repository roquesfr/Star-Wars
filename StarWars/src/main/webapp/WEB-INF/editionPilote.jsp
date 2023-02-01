<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="fr.ldnr.starwars.modele.EtatPilote"%>
<%@page import="fr.ldnr.starwars.modele.Grade"%>
<%@page import="fr.ldnr.starwars.modele.ModeleChasseur"%>
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
                    <h1>Mise à jour de la fiche du pilote 
                    <c:out value="${pilote.nom}"/> 
                    <c:out value="${pilote.prenom}"/>
                </h1>
                <form action="majPilote" method="post">
                    <input type="hidden" name="paramsPrecedents" value="${param.paramsPrecedents}">
                    <div id="listRadio">
                        <div>

                            <div id="list" class="listeEtatPilote">
                                <c:if test="${pilote.etat == EtatPilote.EnMission}">
                                    <aside>
                                        <p>
                                            Le pilote est en mission.<br/>
                                            Veuillez clôturer la mission en cours avant de changer l'état du pilote.
                                        </p>
                                    </aside>    
                                </c:if>

                                <c:if test="${pilote.etat != EtatPilote.EnMission}">
                                    <label>Etat du pilote : </label>
                                    <div id="etatPilote">
                                        <c:forEach items="${EtatPilote.values()}" var="etat">
                                            <c:if test="${etat.selectionable}">
                                                <div id="radioPilote">
                                                    <input id="etat_${etat}" type="radio" name="etat_pilote" value="${etat}" 
                                                           <c:if test="${etat == pilote.etat}">checked </c:if>>
                                                    <label for="etat_${etat}">${etat.label}</label>
                                                </div>   
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <c:if test="${pilote.etat != EtatPilote.EnMission}">
                                <c:if test="${pilote.possedeChasseur()}">
                                    <aside>
                                        <p>
                                            Chasseur du pilote : ${pilote.chasseur.modele.label} n° ${pilote.chasseur.id_chasseur}
                                        </p>
                                    </aside>
                                </c:if>

                                <label for="modele">Chasseur</label>
                                <select name="modele" id="modele">
                                    <c:if test="${pilote.possedeChasseur()}">
                                        <option value="">Conserver</option>
                                    </c:if>
                                    <option value="-1">Aucun</option>
                                    <c:forEach items="${chasseurs}" var="chasseur">
                                        <option value="${chasseur.id_chasseur}">${chasseur.matricule} - ${chasseur.etat.label}</option>
                                    </c:forEach>
                                </select>
                            </c:if>

                        </div>
                    </div>

                    <input type="hidden" name="id_pilote" value="${pilote.id_pilote}">
                    <!--<button type="submit">Modifier</button>-->
                    <c:if test="${pilote.etat != EtatPilote.EnMission}">
                        <div>
                            <input type="submit" value="Valider la mise à jour">
                            <input type="reset" value="Reset">
                        </div>
                    </c:if>
                </form>
            </div>
        </main>
        <!--FOOTER-->
        <jsp:include page="/WEB-INF/footer.jsp"></jsp:include>
    </body>

</html>