/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum ModeleChasseur {
    XWing, YWing;
    
    private String modele;
    
//    private ModeleChasseur(String modele) {
//        this.modele = modele;
//    }
    
    public String getLabel() {
        return modele;
    }

    public void setLabel(String modele) {
        this.modele = modele;
    }
}
