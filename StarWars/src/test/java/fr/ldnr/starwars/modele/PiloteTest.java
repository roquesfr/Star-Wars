/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ldnr.starwars.modele;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stag
 */
public class PiloteTest {
    
    public PiloteTest() {
    }

    /**
     * Teste la méthode Pilote.calculGrade().
     */
    @Test
    public void testCalculGrade() {
        Pilote pilote = new Pilote();
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.OfficierDeVol);
        
        pilote.setHeuresVol(500);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.OfficierDeVol);
        
        pilote.setNbMissions(1);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Lieutenant);
        
        pilote.setHeuresVol(499);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.OfficierDeVol);
        
        pilote.setHeuresVol(499);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.OfficierDeVol);
        
        pilote.setHeuresVol(1500);
        pilote.setNbMissions(2);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Lieutenant);
        
        pilote.setNbMissions(3);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Capitaine);
        
        pilote.setHeuresVol(1499);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Lieutenant);
        
        pilote.setHeuresVol(5000);
        pilote.setNbMissions(9);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Capitaine);
        
        pilote.setNbMissions(10);
        pilote.calculGrade();
        assertTrue(pilote.getGrade() == Grade.Commandant);
    }
    
    
    /**
     * Teste la méthode Pilote.setChasseur(Chasseur chasseur).
     */
    @Test
    public void testSetChasseur() {
        Chasseur chasseur = new Chasseur(ModeleChasseur.XWing, EtatChasseur.Operationnel);
        Pilote pilote = new Pilote();
        pilote.setChasseur(chasseur);
        assert(chasseur.getEtat() == EtatChasseur.Affecte);
        
        pilote.setChasseur(null);
    }

    /**
     * Teste la méthode Pilote.possedeChasseur().
     * Doit retourner false si l'attribut chasseur est null;
     * true sinon.
     */
    @Test
    public void testPossedeChasseur() {
        Pilote pilote = new Pilote();
        pilote.setChasseur(null);
        assert(!pilote.possedeChasseur());
        
        pilote.setChasseur(new Chasseur());
        assert(pilote.possedeChasseur());
    }

    /**
     * Teste la méthode Pilote.verifierEtatChasseur().
     */
    @Test
    public void testVerifierEtatChasseur() {
        Pilote pilote = new Pilote();
        Chasseur chasseur = new Chasseur();
        pilote.setChasseur(chasseur);
        pilote.verifierEtatChasseur();
        assert(pilote.getChasseur() == chasseur);
        
        chasseur.setEtat(EtatChasseur.Detruit);
        pilote.verifierEtatChasseur();
        assert(pilote.getChasseur() == null);
    }
}
