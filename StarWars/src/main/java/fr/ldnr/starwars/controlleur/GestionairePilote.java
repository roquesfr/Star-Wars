/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Pilote;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Effectue des requêtes courantes sur les pilotes.
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
public class GestionairePilote {

    /**
     * Requête le temps de vol total et le nombre de missions du pilote donné.
     * Puis calcule son grade en fonction de ces informations.
     * @param pilote le pilote
     */
    public static void majGrade(Pilote pilote) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Query queryHV = em.createNamedQuery("HeureDeVolPourPilote", Integer.class);
            Query queryNBM = em.createNamedQuery("NbMissionPourPilote", Integer.class);

            queryHV.setParameter("id_pilote", pilote.getId_pilote());
            queryNBM.setParameter("id_pilote", pilote.getId_pilote());
            int heuresVol;
            try {
                heuresVol = Integer.parseInt(queryHV.getSingleResult().toString());
            } catch (NullPointerException e) {
                heuresVol = 0;
            }
            int nbMissions = Integer.parseInt(queryNBM.getSingleResult().toString());

            pilote.setHeuresVol(heuresVol);
            pilote.setNbMissions(nbMissions);
            pilote.calculGrade();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (em != null) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();

                }
                em.close();
            }

        }
    }
}
