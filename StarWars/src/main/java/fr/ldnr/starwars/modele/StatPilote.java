/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author stag
 */
public class StatPilote {

    private int nbHeureVol;
    private int nbMission;

    public StatPilote(int sumHeureVol, int countMission) {
        this.nbHeureVol = sumHeureVol;
        this.nbMission = countMission;
    }
    
    public StatPilote(Integer sumHeureVol,Integer countMission) {
        this.nbHeureVol = sumHeureVol;
        this.nbMission = countMission;
    }

    public Grade calculGrade() {

        if (nbHeureVol < 500) {
            return Grade.OfficierDeVol;
        }
        if (nbHeureVol < 1500 && nbMission >= 1) {
            return Grade.Lieutenant;
        }
        if (nbHeureVol < 4000 && nbMission >= 3) {
            return Grade.Capitaine;
        }
        if (nbHeureVol >= 4000 && nbMission >= 10) {
            return Grade.Commandant;
        }
        return Grade.EnFormation;
    }

    public Grade getGrade() {
        return calculGrade();
    }

    public int getNbHeureVol() {
        return nbHeureVol;
    }

    private void setNbHeureVol(int nbHeureVol) {
        this.nbHeureVol = nbHeureVol;
    }

    public int getNbMission() {
        return nbMission;
    }

    private void setNbMission(int nbMission) {
        this.nbMission = nbMission;
    }

}
