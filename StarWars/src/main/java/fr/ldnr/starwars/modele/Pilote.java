/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author stag
 */
@Entity
public class Pilote implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pilote;
    
    @Enumerated(EnumType.STRING)
    private Race race;
    
    @Enumerated(EnumType.STRING)
    private EtatPilote etat;
    
    @Enumerated(EnumType.STRING)
    private Grade grade;
    
    private String nom;
    private String prenom;
    private int age;
    
    public Pilote() {
        
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
}
