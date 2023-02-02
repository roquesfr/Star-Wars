/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Entité JPA Pilote que l'on stocke en base. Certains attribut ne sont pas
 * stockés car calculables: nbHeureVol, nbMission, Grade
 *
 * @author Concepteurs: Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
@NamedQueries({
    @NamedQuery(
            name = "HeureDeVolPourPilote",
            query = "SELECT SUM(m.dureeHeures) FROM Mission m join m.pilotes p WHERE p.id_pilote=:id_pilote"
    ),
    @NamedQuery(
            name = "NbMissionPourPilote",
            query = "SELECT COUNT(m) FROM Mission m join m.pilotes p WHERE p.id_pilote=:id_pilote"
    )
})
@Entity
public class Pilote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pilote;

    @Enumerated(EnumType.STRING)
    private Race race;

    @Enumerated(EnumType.STRING)
    private EtatPilote etat;

    @Transient
    private Grade grade;

    @Transient
    private int heuresVol;

    @Transient
    private int nbMissions;

    private String nom;
    private String prenom;

    private int age;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Chasseur chasseur;

    /**
     * Crée un Pilote sans missions ni heure de vol Par défaut, il est officer
     * de vol mais en formation
     */
    public Pilote() {
        heuresVol = 0;
        nbMissions = 0;
        grade = Grade.OfficierDeVol;
        etat = EtatPilote.EnFormation;
    }

    /**
     * Construit un pilote, renvoie à Pilote(prenom,nom,age,race)
     *
     * @param prenom
     * @param nom
     * @param age
     * @param race Enumération
     * @param etat Enumération
     */
    public Pilote(String prenom, String nom, int age, Race race, EtatPilote etat) {
        this(prenom, nom, age, race);
        this.etat = etat;
    }
    /**
     * Construit un pilote,
     * renvoie à Pilote(prenom,nom,age,race,etat)
     * @param prenom
     * @param nom
     * @param age
     * @param race
     * @param etat
     * @param chasseur 
     */
    public Pilote(String prenom, String nom, int age, Race race, EtatPilote etat, Chasseur chasseur) {
        this(prenom, nom, age, race,etat);
        this.chasseur = chasseur;
        this.etat = etat;
    }

    /**
     * Construit un pilote renvoie à Pilote()
     *
     * @param prenom
     * @param nom
     * @param age
     * @param race
     */
    public Pilote(String prenom, String nom, int age, Race race) {
        this();
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.race = race;
    }

    /**
     * Met à jour l'attribut grade en fonction des valeurs des attributs
     * heuresVol et nbMissions. N'est pas stocké en base
     */
    public void calculGrade() {
        if (heuresVol >= 4000 && nbMissions >= 10) {
            grade = Grade.Commandant;
        } else if (heuresVol >= 1500 && nbMissions >= 3) {
            grade = Grade.Capitaine;
        } else if (heuresVol >= 500 && nbMissions >= 1) {
            grade = Grade.Lieutenant;
        } else {
            grade = Grade.OfficierDeVol;
        }
    }

    /**
     * Valide la formation d'un pilote en changeant son état Ne change pas le
     * grade
     */
    public void validerFormation() {
        if (this.etat == EtatPilote.EnFormation) {
            this.etat = EtatPilote.Disponible;
        }
    }

    /**
     *
     * @return true si le Pilote a un Chasseur, false sinon
     */
    public boolean possedeChasseur() {
        return chasseur != null;
    }

    /**
     * Vérifie que le Chasseur référencé dans l'attribut chasseur est toujours
     * affecté. Sinon, passe l'attribut à null.
     */
    public void verifierEtatChasseur() {
        if (possedeChasseur() && chasseur.getEtat() != EtatChasseur.Affecte) {
            setChasseur(null);
        }

    }

    /**
     *
     * @return id_pilote
     */
    public int getId_pilote() {
        return id_pilote;
    }

    /**
     * Change l'id_pilote
     *
     * @param id_pilote
     */
    public void setId_pilote(int id_pilote) {
        this.id_pilote = id_pilote;
    }

    /**
     *
     * @return la Race du Pilote
     */
    public Race getRace() {
        return race;
    }

    /**
     * Change la Race du Pilote
     *
     * @param race
     */
    public void setRace(Race race) {
        this.race = race;
    }

    /**
     *
     * @return l'Etat du Pilote
     */
    public EtatPilote getEtat() {
        return etat;
    }

    /**
     * Change l'Etat du Pilote
     *
     * @param etat
     */
    public void setEtat(EtatPilote etat) {
        this.etat = etat;
    }

    /**
     *
     * @return le Grade du Pilote
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Change le Grade du Pilote
     *
     * @param grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     *
     * @return le nombre d'heure de vol du Pilote
     */
    public int getHeuresVol() {
        return heuresVol;
    }

    /**
     * Change la valeur du nombre d'heure du pilote
     *
     * @param heuresVol throw NumberFormatException
     */
    public void setHeuresVol(int heuresVol) {
        if(heuresVol<0) throw new NumberFormatException("Des heures de vol ne peuvent pas être négatives");
        else{this.heuresVol = heuresVol;}
    }

    /**
     *
     * @return le nombre de Mission du Pilote
     */
    public int getNbMissions() {
        return nbMissions;
    }

    /**
     * Change le nombre de Missions du Pilote
     * 
     * @param nbMissions throw NumberFormatException
     */
    public void setNbMissions(int nbMissions) {
        if(nbMissions <0) throw new NumberFormatException("Un nombre de mission ne peut pas être négatif");
        else{this.nbMissions = nbMissions;}
    }

    /**
     *
     * @return le nom du Pilote
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom du Pilote
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return le prénom du Pilote
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Change le prenom du Pilote
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return le l'âge du Pilote
     */
    public int getAge() {
        return age;
    }

    /**
     * Change l'âge du Pilote
     *
     * @param age throw NumberFormatException
     */
    public void setAge(int age) {
        if(age<0) throw new NumberFormatException("Un âge ne peut pas être négatif");
        if(0<=age && age<10) throw new NumberFormatException("Trop p'tit");
        if(age>800) throw new NumberFormatException("Trop vieux");
        else{this.age = age;}
    }

    /**
     *
     * @return le Chasseur du Pilote
     */
    public Chasseur getChasseur() {
        return chasseur;
    }

    /**
     * Change le Chasseur du Pilote
     * Change l'état du Chasseur pour Affecté
     * @param chasseur
     */
    public void setChasseur(Chasseur chasseur) {
        this.chasseur = chasseur;
        if (chasseur != null) {
            chasseur.setEtat(EtatChasseur.Affecte);
        }
    }
}
