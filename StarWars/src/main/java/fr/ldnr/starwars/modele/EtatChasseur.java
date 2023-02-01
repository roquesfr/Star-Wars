/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
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

    private EtatChasseur(String label, boolean selectionable) {
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
    
    public static ArrayList<EtatChasseur> getAll(){
        ArrayList<EtatChasseur> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(EtatChasseur.values()));
        return liste;
    }
}
