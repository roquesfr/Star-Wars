<nav>
<<<<<<< HEAD
    
    <a href="/StarWars/">Accueil</a><br>
    <a href="EtatPiloteServlet">Cr�ation de pilote</a><br>
    <a href="EtatChasseurServlet">Cr�ation de chasseur</a><br>
    <a href="EtatMission">Cr�ation de mission</a><br>
    <a href="Test">G�n�rer votre arm�e</a><br/>
    <a href="ListePilotes">Liste des pilotes</a><br/>
    <a href="ListeChasseurs">Liste des chasseurs</a><br/>
    <a href="ListeMissions">Liste des missions</a>
=======
    <ul>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>
        <li class="menu-deroulant"><a href="#">Cr�ation</a>
            <ul>
                <li><a href="EtatPiloteServlet">Cr�ation de pilote</a></li>
                <li><a href="EtatChasseurServlet">Cr�ation de chasseur</a></li>
            </ul>
        </li>
        <li class="menu-deroulant"><a href="#">Listes</a>
            <ul>
                <li><a href="ListePilotes">Liste des pilotes</a></li>
                <li><a href="ListeChasseurs">Liste des chasseurs</a></li>
            </ul>
        </li>
        <li class="menu-deroulant"><a href="#">Missions</a>
            <ul>
                <li><a href="ListeMissions">Liste des missions</a></li>
            </ul>
        </li>
        <!--        <a href="Test">G�n�rer votre arm�e</a><br/>-->
        <div class="recherche">
            <li>
                <form action="ListePilotes" method="GET">
<!--                    <label for="recherche">Recherche pilote : </label>-->
                    <input type="search" id="recherche" name="recherche" placeholder="Recherche de pilote">
                    <input type="submit" value="Go">
                </form>
            </li>
            <li><a href="RechercheAvancee" id="recherceavancee">Recherche avanc�e</a></li>
        </div>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>

    </ul>

>>>>>>> a217694b96ce2bb1e3b50a6d7b7c324dd56426c9
</nav>