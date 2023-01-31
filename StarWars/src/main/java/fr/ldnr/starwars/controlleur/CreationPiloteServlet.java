/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Grade;
import fr.ldnr.starwars.modele.Pilote;
import fr.ldnr.starwars.modele.Race;
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
@WebServlet(name = "CreationPiloteServlet", urlPatterns = {"/creationPilote"})
public class CreationPiloteServlet extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
   
   
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("titre", "Création de Pilote");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/creationPilote.jsp")
                .forward(request, response);
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Race race = Race.valueOf(request.getParameter("race"));
        Integer age = Integer.valueOf(request.getParameter("age"));
        Pilote pilote = new Pilote(prenom,nom,age,race);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;

        try {
            em = emf.createEntityManager();

            // Etape 1 - On passe l'objet en état managed => sauvegarde en base
            em.getTransaction().begin();
            em.persist(pilote);
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
        request.setAttribute("titre", "Création de Pilote");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/creationPilote.jsp")
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
