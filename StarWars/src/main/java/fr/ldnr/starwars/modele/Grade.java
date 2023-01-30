/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum Grade {
    EnFormation("En Formation"),
    OfficierDeVol("Officier de Vol"),
    Lieutenant("Lieutenant"),
    Capitaine("Capitaine"),
    Commandant("Commandant");
    
    
       
    private String label;

    private Grade(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
