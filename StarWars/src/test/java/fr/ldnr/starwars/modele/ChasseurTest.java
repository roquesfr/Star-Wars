/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package fr.ldnr.starwars.modele;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stag
 */
public class ChasseurTest {
    
    public ChasseurTest() {
    }

    /**
     * Test of getId_chasseur method, of class Chasseur.
     */
    @Test
    public void testGetId_chasseur() {
        
    }

    /**
     * Test of setId_chasseur method, of class Chasseur.
     */
    @Test
    public void testSetId_chasseur() {
    }

    /**
     * Test of getModele method, of class Chasseur.
     */
    @Test
    public void testGetModele() {
        Chasseur c1 = new Chasseur();
        assertEquals("Le modèle par défaut est le X-Wing",ModeleChasseur.XWing,c1.getModele());
        
        c1.setModele(ModeleChasseur.YWing);
        assertEquals("Y-Wing avec le setModele après Chasseur()",ModeleChasseur.YWing,c1.getModele());
        
        Chasseur c2 = new Chasseur(ModeleChasseur.YWing,EtatChasseur.Operationnel);
        assertEquals("Y-Wing avec Chasseur(YWing,...)",ModeleChasseur.YWing,c2.getModele());
        
        
        ModeleChasseur modeleAleatoire = 
                ModeleChasseur.getAll()
                .get(new Random().nextInt(ModeleChasseur.getAll().size()-1));
        Chasseur c3 = new Chasseur(modeleAleatoire,EtatChasseur.Operationnel);
        assertEquals("On récupère le même que l'aléatoire",modeleAleatoire,c3.getModele());
        
    }

    /**
     * Test of setModele method, of class Chasseur.
     */
    @Test
    public void testSetModele() {
    }

    /**
     * Test of getEtat method, of class Chasseur.
     */
    @Test
    public void testGetEtat() {
        Chasseur c1 = new Chasseur();
        assertEquals("L'état par défaut est Opérationnel",EtatChasseur.Operationnel,c1.getEtat());
        
        c1.setEtat(EtatChasseur.Detruit);
        assertEquals("Détruit avec le setEtat après Chasseur()",EtatChasseur.Detruit,c1.getEtat());
        
        Chasseur c2 = new Chasseur(ModeleChasseur.YWing,EtatChasseur.EnMaintenance);
        assertEquals("EnMaintenance avec Chasseur(...,EnMaintenance)",EtatChasseur.EnMaintenance,c2.getEtat());
        
        EtatChasseur etatAleatoire = 
                EtatChasseur.getAll()
                .get(new Random().nextInt(EtatChasseur.getAll().size()-1));
        Chasseur c3 = new Chasseur(ModeleChasseur.XWing,etatAleatoire);
        assertEquals("On récupère le même que l'aléatoire",etatAleatoire,c3.getEtat());
    }

    /**
     * Test of setEtat method, of class Chasseur.
     */
    @Test
    public void testSetEtat() {
    }

    /**
     * Test of getMatricule method, of class Chasseur.
     */
    @Test
    public void testGetMatricule() {
    }
    
}
