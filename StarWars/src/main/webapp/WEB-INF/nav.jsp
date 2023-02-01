<nav>
    <ul>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>
        <li class="menu-deroulant"><a href="#">Création</a>
            <ul>
                <li><a href="creationPilote">Création de pilote</a></li>
                <li><a href="creationChasseur">Création de chasseur</a></li>
            </ul>
        </li>
        <li class="menu-deroulant"><a href="#">Listes</a>
            <ul>
                <li><a href="pilotes">Liste des pilotes</a></li>
                <li><a href="chasseurs">Liste des chasseurs</a></li>
            </ul>
        </li>
        <li class="menu-deroulant"><a href="#">Missions</a>
            <ul>
                <li><a href="missions">Liste des missions</a></li>
                <li><a href="creationMission">Création de mission</a></li>
            </ul>
        </li>
        <div class="recherche">
            <li>
                <form action="rechercheAvanceePilote" method="GET">
                    <input type="search" id="recherche" name="recherche" pattern="[a-zA-Z/\s-]+" placeholder="Recherche de pilote">
                    <input type="submit" value="Go">
                </form>
            </li>

            <li class="menu-deroulant" id="rechercheavancee"><a href="#">Recherche Avancée</a>
                <ul>
                    <li><a href="rechercheAvanceePilote">Pilotes</a></li>
                    <li><a href="rechercheAvanceeChasseur">Chasseurs</a></li>
                </ul>
            </li>
        </div>
        <li class="accueil"><a href="/StarWars/"><img src="assets/img/Alliance_Rebelle.png" alt="alt"/></a></li>

    </ul>
</nav>