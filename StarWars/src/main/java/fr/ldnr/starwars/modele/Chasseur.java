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
 *Entité JPA stockée en base
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
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

    /**
     * Constructeur de Chasseur
     */
    public Chasseur() {
        this.modele = ModeleChasseur.XWing;
        this.etat = EtatChasseur.Operationnel;
    }
    
    /**
     * Constructeur de Chasseur
     * @param modele
     * @param etat 
     */
    public Chasseur(ModeleChasseur modele, EtatChasseur etat) {
        this.modele = modele;
        this.etat = etat;
    }

    /**
     * 
     * @return id_chasseur 
     */
    public int getId_chasseur() {
        return id_chasseur;
    }

    /**
     * Change l'id du chasseur
     * @param id_chasseur 
     */
    public void setId_chasseur(int id_chasseur) {
        this.id_chasseur = id_chasseur;
    }

    /**
     * 
     * @return le Modele du Chasseur 
     */
    public ModeleChasseur getModele() {
        return modele;
    }

    /**
     * Change le Modele du Chasseur
     * @param modele 
     */
    public void setModele(ModeleChasseur modele) {
        this.modele = modele;
    }

    /**
     * 
     * @return l'Etat du Chasseur 
     */
    public EtatChasseur getEtat() {
        return etat;
    }

    /**
     * Change l'Etat du Chasseur
     * @param etat 
     */
    public void setEtat(EtatChasseur etat) {
        this.etat = etat;
    }
    
    /**
     * Matricule obtenu en concatenant
     * le label du Chasseur
     * et son id
     * @return le Matricule du Chasseur 
     */
    public String getMatricule() {
        return modele.getLabel() + " n° " + id_chasseur;
    }

}
