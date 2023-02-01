//Affichage de l'heure
function showHour() {
    //Récupération de l'heure
    const heure = new Date();
    //Mise en forme de l'heure avec 2 chiffres
    const optionsHeure = {
        hour: "2-digit",
        minute: "2-digit",
        second: "2-digit"
    }
    //Création de la chaine à afficher avec les options des 2 chiffres et au format Français
    const heureFormate = new Intl.DateTimeFormat("fr-FR", optionsHeure).format(heure);
    const affichageHeure = document.getElementById("heure");
    affichageHeure.textContent = heureFormate;
}

//Mise à jour de l'affichage de l'heure toutes les secondes
window.addEventListener("DOMContentLoaded", () => {
    showHour();
    setInterval(showHour, 1000);
})