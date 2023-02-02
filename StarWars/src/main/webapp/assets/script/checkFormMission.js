//Récupération du champs intitule
const intitule = document.getElementById("intitule");
//Récupération du bouton submitMission
const submitMission = document.getElementById("submitMission");
//Vérification de la création d'une mission
intitule.addEventListener("blur", checkIntitule);
//Ajout d'un évènement lors du click sur le bouton envoyer du formulaire création mission
submitMission.addEventListener("click", checkFormCreationMission);

const intituleFormat = /^[A-Za-z0-9\u00C0-\u00FF][A-Za-z0-9\u00C0-\u00FF\s\-]{6,199}$/;

function checkIntitule() {
    let isIntituleOk = true;

    if (!intitule.value.trim().match(intituleFormat)) {
        isIntituleOk = false;

        //Ajout d'une info-bulle lorsque la souris est sur l'input
        intitule.setAttribute("title", "Veuillez saisir un intitulé valide ! (Au moins 7 caractères alpha-numérique)");
        //Ajout de bordure rouge
        intitule.classList.add("bordererror");
        //Ajout d'un message d'erreur
        intitule.nextElementSibling.classList.add("show");
    }  else {
        intitule.classList.remove("bordererror");
        intitule.nextElementSibling.classList.remove("show");
        intitule.removeAttribute("title");
    }
    return isIntituleOk;
}

function checkFormCreationMission(evt) {
    //Test du champ intitule
    let missionChecked = checkIntitule();

    if(!missionChecked) {
        alert("Formulaire invalide !");
        evt.preventDefault();
    }
}