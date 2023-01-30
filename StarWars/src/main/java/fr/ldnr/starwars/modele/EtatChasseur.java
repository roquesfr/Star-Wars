/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum EtatChasseur {
    Affecte("Affecté"),Operationnel("Opérationnel"),EnMaintenance("En Maintenance"), Detruit("Détruit"),EnConstruction("En construction");
    
    private String label;

    private EtatChasseur(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
