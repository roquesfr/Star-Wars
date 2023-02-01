/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.EtatChasseur;
import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Mission;
import fr.ldnr.starwars.modele.Pilote;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stag
 */
@WebServlet(name = "ClotureMissionServlet", urlPatterns = {"/clotureMission"})
public class ClotureMissionServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int missionId = Integer.valueOf(request.getParameter("id"));
        int nbHeures = Integer.valueOf(request.getParameter("nbHeures"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            Mission mission = em.find(Mission.class, missionId);
            em.getTransaction().begin();
            mission.setCompletee(true);
            mission.setDureeHeures(nbHeures);

            for (Pilote p : mission.getPilotes()) {
                EtatPilote etat = EtatPilote.valueOf(request.getParameter("etat_" + p.getId_pilote()));
                EtatChasseur etatChasseur = EtatChasseur.valueOf(request.getParameter("etatChasseur_" + p.getId_pilote()));
                p.setEtat(etat);
                if (p.possedeChasseur()) {
                    p.getChasseur().setEtat(etatChasseur);
                    p.verifierEtatChasseur();
                }
            }

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Problème survenu : " + e);
        } finally {
            if (em != null) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        request.setAttribute("titre", "Liste des Missions");
        getServletContext()
                .getRequestDispatcher("/ListeMissions")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
