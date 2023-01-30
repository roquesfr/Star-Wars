/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Mission;
import fr.ldnr.starwars.modele.Pilote;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stag
 */
@WebServlet(name = "CreationMissionServlet", urlPatterns = {"/CreationMission"})
public class CreationMissionServlet extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        Mission mission = new Mission();
        String[] idPilotesString = request.getParameterValues("pilotes");
        ArrayList<Integer> idPilotes = new ArrayList<>();
        for(String id: idPilotesString)
            idPilotes.add(Integer.valueOf(id));
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            
            mission.setIntitule(request.getParameter("intitule"));

            TypedQuery<Pilote> query = em.createQuery("SELECT p FROM Pilote p WHERE p.id_pilote IN :idPilotes", Pilote.class);
            query.setParameter("idPilotes", idPilotes);
            List<Pilote> pilotes = query.getResultList();
            mission.setPilotes(new ArrayList<>(pilotes));
            em.getTransaction().begin();
            for(Pilote p: pilotes)
                p.setEtat(EtatPilote.EnMission);
            em.persist(mission);
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
        request.setAttribute("titre", "Création de Mission");
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
