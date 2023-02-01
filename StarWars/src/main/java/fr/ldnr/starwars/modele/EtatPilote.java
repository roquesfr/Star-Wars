/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Enumération des Etat possibles pour un Pilote
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
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
     * @return true si le Pilote n'est pas en Mission, false sinon 
     */
    public boolean isSelectionable() {
        return selectionable;
    }

    /**
     * Change selectionnable
     * @param selectionable 
     */
    public void setSelectionable(boolean selectionable) {
        this.selectionable = selectionable;
    }
    
    /**
     * 
     * @return Collection de tous les Etat d'un Pilote 
     */
    public static ArrayList<EtatPilote> getAll(){
        ArrayList<EtatPilote> liste = new ArrayList<>();
        liste.addAll(Arrays.asList(EtatPilote.values()));
        return liste;
    }
    
}
