/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

/**
 *
 * @author stag
 */
public class PiloteTest {

    final int AGE_MIN = 10;
    final int AGE_MAX = 800;

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
        assert (chasseur.getEtat() == EtatChasseur.Affecte);

        pilote.setChasseur(null);
    }

    /**
     * Teste la méthode Pilote.possedeChasseur(). Doit retourner false si
     * l'attribut chasseur est null; true sinon.
     */
    @Test
    public void testPossedeChasseur() {
        Pilote pilote = new Pilote();
        pilote.setChasseur(null);
        assert (!pilote.possedeChasseur());

        pilote.setChasseur(new Chasseur());
        assert (pilote.possedeChasseur());
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
        assert (pilote.getChasseur() == chasseur);

        chasseur.setEtat(EtatChasseur.Detruit);
        pilote.verifierEtatChasseur();
        assert (pilote.getChasseur() == null);
    }

    /**
     * Test of validerFormation method, of class Pilote.
     */
    @Test
    public void testValiderFormation() {
    }

    /**
     * Test of getId_pilote method, of class Pilote.
     */
    @Test
    public void testGetId_pilote() {
    }

    /**
     * Test of setId_pilote method, of class Pilote.
     */
    @Test
    public void testSetId_pilote() {
    }

    /**
     * Test of getRace method, of class Pilote.
     */
    @Test
    public void testGetRace() {
    }

    /**
     * Test of setRace method, of class Pilote.
     */
    @Test
    public void testSetRace() {
    }

    /**
     * Test of getEtat method, of class Pilote.
     */
    @Test
    public void testGetEtat() {
    }

    /**
     * Test of setEtat method, of class Pilote.
     */
    @Test
    public void testSetEtat() {
    }

    /**
     * Test of getGrade method, of class Pilote.
     */
    @Test
    public void testGetGrade() {
    }

    /**
     * Test of setGrade method, of class Pilote.
     */
    @Test
    public void testSetGrade() {
    }

    /**
     * Test of getHeuresVol method, of class Pilote.
     */
    @Test
    public void testGetHeuresVol() {
        
    }

    /**
     * Test of setHeuresVol method, of class Pilote.
     */
    @Test
    public void testSetHeuresVol() {
        
        Pilote p1 = mock(Pilote.class);
        
        int heureNegative = -1;
        willThrow(new NumberFormatException("Des heures de vol ne peuvent pas être négatives"))
                .given(p1).setHeuresVol(heureNegative);
        
        int heureValide = 1;
        Pilote p2 = new Pilote();
        p2.setHeuresVol(heureValide);
        assertEquals("Un nombre d'heures de vol valide",heureValide, p2.getHeuresVol());
        
    }

    /**
     * Test of getNbMissions method, of class Pilote.
     */
    @Test
    public void testGetNbMissions() {
    }

    /**
     * Test of setNbMissions method, of class Pilote.
     */
    @Test
    public void testSetNbMissions() {
        
        Pilote p1 = mock(Pilote.class);
        
        int nbMissionNegatif = -1;
        willThrow(new NumberFormatException("Un nombre de mission ne peut pas être négatif"))
                .given(p1).setNbMissions(nbMissionNegatif);
        
        int nbMissionValide = 1;
        Pilote p2 = new Pilote();
        p2.setNbMissions(nbMissionValide);
        assertEquals("Un nombre de mission ne peut pas être négatif",nbMissionValide, p2.getNbMissions());
    }

    /**
     * Test of getNom method, of class Pilote.
     */
    @Test
    public void testGetNom() {
    }

    /**
     * Test of setNom method, of class Pilote.
     */
    @Test
    public void testSetNom() {
    }

    /**
     * Test of getPrenom method, of class Pilote.
     */
    @Test
    public void testGetPrenom() {
    }

    /**
     * Test of setPrenom method, of class Pilote.
     */
    @Test
    public void testSetPrenom() {
    }

    /**
     * Test of getAge method, of class Pilote.
     */
    @Test
    public void testGetAge() {
    }

    /**
     * Test of setAge method, of class Pilote.
     */
    @Test
    public void testSetAge() {
        int ageValide = AGE_MIN + new Random().nextInt(AGE_MAX - AGE_MIN);
        Pilote p1 = new Pilote();
        p1.setAge(ageValide);
        assertEquals("L'âge est bien set", p1.getAge(), ageValide);

        int ageJeune = AGE_MIN-1;

        Pilote p2 = mock(Pilote.class);
        //doThrow(new NumberFormatException("Trop jeune p'tit")).when(p2.setAge(ageJeune));
        willThrow(new NumberFormatException("Trop jeune p'tit")).given(p2).setAge(ageJeune);
        //when(p2.setAge(ageJeune)).thenThrow(new NumberFormatException("Trop jeune p'tit"));
//        assertThrows("Trop jeune",
//                new NumberFormatException("Trop jeune p'tit"),
//                new Pilote("Trop","Jeune",ageJeune,Race.Togruta));
        int ageNegatif = -1;
        willThrow(new NumberFormatException("Un âge ne peut pas être négatif")).given(p2).setAge(ageNegatif);
        
        int ageVieux = AGE_MAX+1;
        willThrow(new NumberFormatException("Un âge ne peut pas être négatif")).given(p2).setAge(ageVieux);

    }

    /**
     * Test of getChasseur method, of class Pilote.
     */
    @Test
    public void testGetChasseur() {
    }
}
