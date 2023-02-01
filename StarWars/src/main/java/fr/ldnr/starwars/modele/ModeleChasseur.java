/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author stag
 */
public enum ModeleChasseur {

    XWing("X-Wing"),
    YWing("Y-Wing"),
    ZWing("Z-Wing");
       
    private String label;

    private ModeleChasseur(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    public static ArrayList<ModeleChasseur> getAll(){
        ArrayList<ModeleChasseur> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(ModeleChasseur.values()));
        return liste;
    }
}
