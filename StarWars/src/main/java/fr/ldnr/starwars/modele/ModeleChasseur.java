/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enumération des Modèles de Chasseur disponible pour les Pilotes rebelles
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
public enum ModeleChasseur {

    XWing("X-Wing"),
    YWing("Y-Wing"),
    ZWing("Z-Wing");
       
    private String label;

    /**
     * Constructeur de ModeleChasseur
     * @param label 
     */
    private ModeleChasseur(String label) {
        this.label = label;
    } 

    /**
     * 
     * @return le label de l'énumération ModeleChasseur
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Change le label de l'énumération ModeleChasseur
     * @param label 
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * 
     * @return Collection de tous les ModeleChasseur
     */
    public static ArrayList<ModeleChasseur> getAll(){
        ArrayList<ModeleChasseur> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(ModeleChasseur.values()));
        return liste;
    }
}
