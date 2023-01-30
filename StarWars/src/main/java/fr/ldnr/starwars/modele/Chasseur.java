/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author stag
 */
@Entity
//@Access(AccessType.PROPERTY)
public class Chasseur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_chasseur;

    @Enumerated(EnumType.STRING)
    private ModeleChasseur modele;

    @Enumerated(EnumType.STRING)
    private EtatChasseur etat;
    
    @OneToOne(mappedBy = "chasseur")
    private Pilote pilote;

    public Chasseur(){
        this.modele = ModeleChasseur.XWing;
        this.etat = EtatChasseur.Operationnel;
    }

    public int getId_chasseur() {
        return id_chasseur;
    }

    public void setId_chasseur(int id_chasseur) {
        this.id_chasseur = id_chasseur;
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
