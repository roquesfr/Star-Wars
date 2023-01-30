<nav>
<<<<<<< HEAD
    
    <a href="/StarWars/">Accueil</a><br>
    <a href="EtatPiloteServlet">Création de pilote</a><br>
    <a href="EtatChasseurServlet">Création de chasseur</a><br>
    <a href="EtatMission">Création de mission</a><br>
    <a href="Test">Générer votre armée</a><br/>
    <a href="ListePilotes">Liste des pilotes</a><br/>
    <a href="ListeChasseurs">Liste des chasseurs</a><br/>
    <a href="ListeMissions">Liste des missions</a>
=======
    <ul>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>
        <li class="menu-deroulant"><a href="#">Création</a>
            <ul>
                <li><a href="EtatPiloteServlet">Création de pilote</a></li>
                <li><a href="EtatChasseurServlet">Création de chasseur</a></li>
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
        <!--        <a href="Test">Générer votre armée</a><br/>-->
        <div class="recherche">
            <li>
                <form action="ListePilotes" method="GET">
<!--                    <label for="recherche">Recherche pilote : </label>-->
                    <input type="search" id="recherche" name="recherche" placeholder="Recherche de pilote">
                    <input type="submit" value="Go">
                </form>
            </li>
            <li><a href="RechercheAvancee" id="recherceavancee">Recherche avancée</a></li>
        </div>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>

    </ul>

>>>>>>> a217694b96ce2bb1e3b50a6d7b7c324dd56426c9
</nav>