/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 * Enumération des Grades possibles pour un Pilote
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
public enum Grade {
    OfficierDeVol("Officier de Vol"),
    Lieutenant("Lieutenant"),
    Capitaine("Capitaine"),
    Commandant("Commandant");
    
    
       
    private String label;

    /**
     * Constructeur de Grade
     * @param label 
     */
    private Grade(String label) {
        this.label = label;
    } 

    /**
     * 
     * @return Grade 
     */
    public String getLabel() {
        return label;
    }

    /**
     * Change le label
     * @param label 
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
