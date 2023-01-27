/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum EtatPilote {
    EnFormation("En Formation"),
    Disponible("Disponible"),
    EnMission("En Mission"),
    Blesse("Blessé"),
    Decede("Décédé");
    
    private String label;

    private EtatPilote(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
