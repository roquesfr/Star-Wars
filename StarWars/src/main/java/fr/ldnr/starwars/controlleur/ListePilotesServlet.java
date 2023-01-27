/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Pilote;
import java.io.IOException;
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
@WebServlet(name = "ListePilotesServlet", urlPatterns = {"/ListePilotes"})
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
        EntityManager em = emf.createEntityManager();
        String queryString = "SELECT p FROM Pilote p WHERE 1=1";
        TypedQuery<Pilote> query;
        String recherche = request.getParameter("recherche");
        String race = request.getParameter("race");
        String etat = request.getParameter("etat");
        String grade = request.getParameter("grade");
        if (recherche != null)
            queryString += " AND CONCAT(p.prenom,' ', p.nom) LIKE CONCAT('%', :recherche, '%')";
        if(etat != null)
            queryString += " AND p.etat LIKE CONCAT('%', :etat, '%')";
        if(race != null)
            queryString += " AND p.race LIKE CONCAT('%', :race, '%')";
        if(grade != null)
            queryString += " AND p.grade LIKE CONCAT('%', :grade, '%')";
            
        query = em.createQuery(queryString, Pilote.class);
        if(recherche != null)
            query.setParameter("recherche", recherche);
        if(etat != null)
            query.setParameter("etat", etat);
        if(race != null)
            query.setParameter("race", race);
        if(grade != null)
            query.setParameter("grade", grade);
        List<Pilote> liste = query.getResultList();
        request.setAttribute("pilotes", liste);
        em.close();

        getServletContext().getRequestDispatcher("/WEB-INF/liste_pilotes.jsp").forward(request, response);
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
