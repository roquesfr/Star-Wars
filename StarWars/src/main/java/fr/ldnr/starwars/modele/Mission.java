/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author stag
 */
@Entity
public class Mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mission;
    
    private String nom;
    private String objectif;

    private boolean completee;
    private int dureeHeures;
    
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private ArrayList<Pilote> pilotes;
    
//    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    private ArrayList<Chasseur> chasseurs;
    
    public Mission() {
        completee = false;
        dureeHeures = 0;
        pilotes = new ArrayList<>();
    }

    public int getId_mission() {
        return id_mission;
    }

    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }

    public boolean isCompletee() {
        return completee;
    }

    public void setCompletee(boolean completee) {
        this.completee = completee;
    }

    public int getDureeHeures() {
        return dureeHeures;
    }

    public void setDureeHeures(int dureeHeures) {
        this.dureeHeures = dureeHeures;
    }

    public ArrayList<Pilote> getPilotes() {
        return pilotes;
    }

    public void setPilotes(ArrayList<Pilote> pilotes) {
        this.pilotes = pilotes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

}
