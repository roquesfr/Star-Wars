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
    EnFormation("En Formation", true),
    Disponible("Disponible", true),
    EnMission("En Mission", false),
    Blesse("Blessé", true),
    Decede("Décédé", true);
    
    private String label;
    private boolean selectionable;

    private EtatPilote(String label, boolean selectionable) {
        this.label = label;
        this.selectionable = selectionable;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isSelectionable() {
        return selectionable;
    }

    public void setSelectionable(boolean selectionable) {
        this.selectionable = selectionable;
    }
    
    
}
