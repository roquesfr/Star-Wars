//Gestion évènementielle
//Récupération du champs nom
const nom = document.getElementById("nom");
//Récupération du champs nom
const prenom = document.getElementById("prenom");
//Récupération du bouton submitPilote
const submitPilote = document.getElementById("submitPilote");


//Vérification des formulaires
//Vérification de la création d'un pilote
nom.addEventListener("blur", checkNom);
prenom.addEventListener("blur", checkPrenom);
//Ajout d'un évènement lors du click sur le bouton envoyer du formulaire création pilote
submitPilote.addEventListener("click", checkFormCreationPilote);

const nomPrenomFormat = /^[A-Za-z\u00C0-\u00FF][A-Za-z\u00C0-\u00FF\s\-]{2,49}$/;

function checkNom() {
    let isNomOk = true;
    nom.value = nom.value.trim();
    nom.value = nom.value.charAt(0).toUpperCase()+nom.value.slice(1);
    if (!nom.value.match(nomPrenomFormat)) {;
        isNomOk = false;

        //Ajout d'une info-bulle lorsque la souris est sur l'input
        nom.setAttribute("title", "Veuillez saisir un nom valide ! (Au moins 3 caractères alphabétiques)");
        //Ajout de bordure rouge
        nom.classList.add("bordererror");
        //Ajout d'un message d'erreur
        nom.nextElementSibling.classList.add("show");
    }  else {
        nom.classList.remove("bordererror");
        nom.nextElementSibling.classList.remove("show");
        nom.removeAttribute("title");
    }
    return isNomOk;
}

function checkPrenom() {
    let isPrenomOk = true;
    prenom.value = prenom.value.trim();
    prenom.value = prenom.value.charAt(0).toUpperCase()+prenom.value.slice(1);
    
    if (!prenom.value.match(nomPrenomFormat)) {
        isPrenomOk = false;

        //Ajout d'une info-bulle lorsque la souris est sur l'input
        prenom.setAttribute("title", "Veuillez saisir un prénom valide ! (Au moins 3 caractères alphabétiques)");
        //Ajout de bordure rouge
        prenom.classList.add("bordererror");
        //Ajout d'un message d'erreur
        prenom.nextElementSibling.classList.add("show");
    }  else {
        prenom.classList.remove("bordererror");
        prenom.nextElementSibling.classList.remove("show");
        prenom.removeAttribute("title");
    }
    return isPrenomOk;
}

function checkFormCreationPilote(evt) {
    //Test du champ nom
    let nomChecked = checkNom();

    //Test du champ prenom
    let prenomChecked = checkPrenom();

    if(!nomChecked || !prenomChecked) {
        alert("Formulaire invalide !");
        evt.preventDefault();
    }
}