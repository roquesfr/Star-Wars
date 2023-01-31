/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author stag
 */
@NamedQueries({
    @NamedQuery(
        name="HeureDeVolPourPilote",
        query="SELECT SUM(m.dureeHeures) FROM Mission m join m.pilotes p WHERE p.id_pilote=:id_pilote"
    ),
    @NamedQuery(
        name="NbMissionPourPilote",
        query="SELECT COUNT(m) FROM Mission m join m.pilotes p WHERE p.id_pilote=:id_pilote"
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

//    @Enumerated(EnumType.STRING)
//    private Grade grade;

    private String nom;
    private String prenom;
    
//    @Temporal(TemporalType.DATE)
//    private DateNaissance dateNaissance;
    private int age;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Chasseur chasseur;

    public Pilote() {

    }
    
    public Pilote(String prenom, String nom, int age, Race race, EtatPilote etat) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.race = race;
        this.etat = etat;
    }

    public Grade calculGrade(int heuresVol, int nbMission){
        
        if(heuresVol<500){
            return Grade.OfficierDeVol;
        }
        if(heuresVol<1500 && nbMission>=1){
            return Grade.Lieutenant;
        }
        if(heuresVol<4000 && nbMission>=3){
            return Grade.Capitaine;
        }
        if(heuresVol>=4000 && nbMission>=10){
            return Grade.Commandant;
        }
        return Grade.EnFormation;
    }

    public boolean possedeChasseur() {
        return chasseur != null;
    }
    
    public void verifierEtatChasseur() {
        if(possedeChasseur() && chasseur.getEtat() != EtatChasseur.Affecte) {
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

//    public Grade getGrade() {
//        return grade;
//    }
//
//    public void setGrade(Grade grade) {
//        this.grade = grade;
//    }

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
        if(chasseur != null)
            chasseur.setEtat(EtatChasseur.Affecte);
    }
}
