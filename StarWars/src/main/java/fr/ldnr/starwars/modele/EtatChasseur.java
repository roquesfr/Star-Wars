/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enumération sur l'Etat du Chasseur
 * @author stag
 */
public enum EtatChasseur {
    Affecte("Affecté", false),
    Operationnel("Opérationnel", true),
    EnMaintenance("En Maintenance", true),
    Detruit("Détruit", true),
    EnConstruction("En construction", true);
    
    private String label;
    private boolean selectionable;

    /**
     * Construteur d'EtatChasseur
     * @param label
     * @param selectionable 
     */
    private EtatChasseur(String label, boolean selectionable) {
        this.label = label;
        this.selectionable = selectionable;
    } 

    /**
     * 
     * @return le label 
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

    /**
     * 
     * @return true si le Chasseur est selectionnable 
     */
    public boolean isSelectionable() {
        return selectionable;
    }
    
    /**
     * True si le Chasseur est selectionnable, false sinon
     * @param selectionable 
     */
    public void setSelectionable(boolean selectionable) {
        this.selectionable = selectionable;
    }
    
    /**
     * 
     * @return Collection contenant tous les chasseurs 
     */
    public static ArrayList<EtatChasseur> getAll(){
        ArrayList<EtatChasseur> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(EtatChasseur.values()));
        return liste;
    }
}
