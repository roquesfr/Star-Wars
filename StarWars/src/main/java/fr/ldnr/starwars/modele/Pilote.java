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
 *
 * @author stag
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

//    @Temporal(TemporalType.DATE)
//    private DateNaissance dateNaissance;
    private int age;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Chasseur chasseur;

    public Pilote() {
        heuresVol = 0;
        nbMissions = 0;
        grade = Grade.OfficierDeVol;
        etat = EtatPilote.Disponible;
    }

    public Pilote(String prenom, String nom, int age, Race race, EtatPilote etat) {
        this();
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.race = race;
        this.etat = etat;
    }
    
    public Pilote(String prenom, String nom, int age, Race race) {
        this();
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.race = race;
    }

    /**
     * Met à jour l'attribut grade en fonction des valeurs des attributs
     * heuresVol et nbMissions.
     */
    public void calculGrade() {
        if(heuresVol >= 4000 && nbMissions >= 10) {
            grade = Grade.Commandant;
        } else if (heuresVol >= 1500 && nbMissions >= 3) {
            grade = Grade.Capitaine;
        } else if(heuresVol >= 500 && nbMissions >= 1) {
            grade = Grade.Lieutenant;
        } else {
            grade = Grade.OfficierDeVol;
        }
    }
    
    public void validerFormation() {
        if(this.etat == EtatPilote.EnFormation)
            this.etat = EtatPilote.Disponible;
    }

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

    public int getId_pilote() {
        return id_pilote;
    }

    public void setId_pilote(int id_pilote) {
        this.id_pilote = id_pilote;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public EtatPilote getEtat() {
        return etat;
    }

    public void setEtat(EtatPilote etat) {
        this.etat = etat;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getHeuresVol() {
        return heuresVol;
    }

    public void setHeuresVol(int heuresVol) {
        this.heuresVol = heuresVol;
    }

    public int getNbMissions() {
        return nbMissions;
    }

    public void setNbMissions(int nbMissions) {
        this.nbMissions = nbMissions;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Chasseur getChasseur() {
        return chasseur;
    }

    public void setChasseur(Chasseur chasseur) {
        this.chasseur = chasseur;
        if (chasseur != null) {
            chasseur.setEtat(EtatChasseur.Affecte);
        }
    }
}
