/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Grade;
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
 * Si une requête JPQL est donnée en paramètre, charge la liste de Pilote résultant
 * de cette requête. Sinon, requête la liste de tous les pilotes.
 * Ajoute cette liste en attribut de la requête puis sert listePilotes.jsp
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
@WebServlet(name = "ListePilotesServlet", urlPatterns = {"/pilotes"})
public class ListePilotesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;
        try {
            em = emf.createEntityManager();

            String queryString = "SELECT p FROM Pilote p WHERE 1=1";
            TypedQuery<Pilote> query=null;

            ArrayList<Grade> grades = new ArrayList<>();
            
            //on vient de recherche avancée
            if (request.getParameter("recherche") != null) {
                query= TypedQuery.class.cast(request.getAttribute("query"));
                grades = ArrayList.class.cast(request.getAttribute("grades"));
            } else {
                query = em.createQuery(queryString, Pilote.class);
            }
            List<Pilote> liste = query.getResultList();

            for (Pilote pilote : liste) {
                GestionairePilote.majGrade(pilote);
            }
            if (!grades.isEmpty()) {
                ArrayList<Pilote> resultat = new ArrayList<>();
                for (Pilote pilote : liste) {
                    if (grades.contains(pilote.getGrade())) {
                        resultat.add(pilote);
                    }

                }
                request.setAttribute("pilotes", resultat);
            } else {
                request.setAttribute("pilotes", liste);
            }
        } catch (Exception e) {
            System.err.println("error"+e.getMessage());
        } finally {
            if (em != null) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        request.setAttribute("titre", "Liste des Pilotes");
        getServletContext()
                .getRequestDispatcher("/WEB-INF/listePilotes.jsp")
                .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
