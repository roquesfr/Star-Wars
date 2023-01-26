/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author stag
 */
@Entity
public class Chasseur implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @Enumerated(EnumType.STRING)
    private ModeleChasseur modele;
    
    @Enumerated(EnumType.STRING)
    private EtatChasseur etat;
    
    
    public Chasseur(){
        this.modele = ModeleChasseur.XWing;
        this.etat = EtatChasseur.Operationnel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModeleChasseur getModele() {
        return modele;
    }

    public void setModele(ModeleChasseur modele) {
        this.modele = modele;
    }

    public EtatChasseur getEtat() {
        return etat;
    }

    public void setEtat(EtatChasseur etat) {
        this.etat = etat;
    }
}
