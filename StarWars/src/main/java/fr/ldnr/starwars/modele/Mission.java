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
 * Entité JPA que l'on stocke en base
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
@Entity
public class Mission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mission;
    
    private String objectif;

    private String intitule;
    private boolean completee;
    private int dureeHeures;
    
    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private ArrayList<Pilote> pilotes;
    
    /**
     * Constructeur de Mission
     * Par défaut, elle n'est pas complétée,
     * N'a pas de durée,
     * et une liste vide de Pilotes
     */
    public Mission() {
        completee = false;
        dureeHeures = 0;
        pilotes = new ArrayList<>();
    }
    
    /**
     * Construteur de Mission
     * renvoie à Mission()
     * @param pilotes 
     */
    public Mission(ArrayList<Pilote> pilotes) {
        this();
        this.pilotes = pilotes;
    }
    
    /**
     * 
     * @return id_mission 
     */
    public int getId_mission() {
        return id_mission;
    }

    /**
     * Change la valeur de l'id_mission
     * @param id_mission 
     */
    public void setId_mission(int id_mission) {
        this.id_mission = id_mission;
    }
    
    /**
     * 
     * @return intitule de la Mission
     */
    public String getIntitule() {
        return intitule;
    }
    
    /**
     * Change l'intitulé de la Mission
     * @param intitule 
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    /**
     * 
     * @return true si la mission est terminée, false sinon
     */
    public boolean isCompletee() {
        return completee;
    }

    /**
     * Change la valeur de complétee,
     * True si la mission est complété, false sinon
     * @param completee 
     */
    public void setCompletee(boolean completee) {
        this.completee = completee;
    }
    
    /**
     * 
     * @return la durée de la Mission
     */
    public int getDureeHeures() {
        return dureeHeures;
    }

    /**
     * Change la durée de la Mission
     * @param dureeHeures 
     */
    public void setDureeHeures(int dureeHeures) {
        this.dureeHeures = dureeHeures;
    }

    /**
     * 
     * @return la liste des Pilotes de la Mission
     */
    public ArrayList<Pilote> getPilotes() {
        return pilotes;
    }

    /**
     * Change la liste des Pilotes de la Mission
     * @param pilotes 
     */
    public void setPilotes(ArrayList<Pilote> pilotes) {
        this.pilotes = pilotes;
    }

    /**
     * 
     * @return l'objectif de la mission
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * Change l'objectif de la Mission
     * @param objectif 
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

}
