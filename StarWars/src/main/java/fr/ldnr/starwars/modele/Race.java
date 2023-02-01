/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enumération des Races possible pour les Pilotes rebelles
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
public enum Race {

    Chalacteen("Chalactéen"),
    Chis("Chis"),
    Humain("Humain"),
    Ithorien("Ithorien"),
    Mirialan("Mirialan"),
    KelDor("Kel'Dor"),
    Kiffar("Kiffar"),
    Miraluka("Miraluka"),
    Mirialen("Miralien"),
    Nagai("Nagai"),
    Neimoidien("Neimoidien"),
    Nikto("Nikto"),
    Noghri("Noghri"),
    Ongree("Ongree"),
    PauAn("Pau'an"),
    Quermien("Quermien"),
    Rakata("Rakata"),
    Rodien("Rodien"),
    Thisspasien("Thisspasien"),
    Togruta("Togruta"),
    Wookie("Wookie"),
    Wronian("Wronian"),
    Zabrak("Zabrak");
    
    private String label;
    
    /**
     * Constructeur de Race
     * @param label 
     */
    private Race(String label) {
        this.label = label;
    } 
    
    /**
     * 
     * @return le label de l'énumération
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Change la valeur du label
     * @param label 
     */
    public void setLabel(String label) {
        this.label = label;
    }
    
    /**
     * 
     * @return une collection contenant toutes les Races
     */
    public static ArrayList<Race> getAll(){
        ArrayList<Race> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(Race.values()));
        return liste;
    }
}
