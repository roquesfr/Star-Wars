<nav>

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
</nav>