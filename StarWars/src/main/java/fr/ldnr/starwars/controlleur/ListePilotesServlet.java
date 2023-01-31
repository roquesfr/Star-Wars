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
 *
 * @author stag
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
        EntityManager em = emf.createEntityManager();
        String queryString = "SELECT p FROM Pilote p WHERE 1=1";
        TypedQuery<Pilote> query;
        String recherche = request.getParameter("recherche");
        String race = request.getParameter("race");
        String etat = request.getParameter("etat");
        String grade = request.getParameter("grade");
        String chasseur = request.getParameter("chasseur");

        if (recherche != null && !recherche.isEmpty()) {
            queryString += " AND CONCAT(p.prenom,' ', p.nom) LIKE CONCAT('%', :recherche, '%')";
        }
        if (etat != null && !etat.isEmpty()) {
            queryString += " AND p.etat LIKE CONCAT('%', :etat, '%')";
        }
        if (race != null && !race.isEmpty()) {
            queryString += " AND p.race LIKE CONCAT('%', :race, '%')";
        }
        if (chasseur != null && !chasseur.isEmpty()) {
            queryString += " AND p.chasseur.modele LIKE CONCAT('%', :chasseur, '%')";
        }

        query = em.createQuery(queryString, Pilote.class);
        if (recherche != null && !recherche.isEmpty()) {
            query.setParameter("recherche", recherche);
        }
        if (etat != null && !etat.isEmpty()) {
            query.setParameter("etat", etat);
        }
        if (race != null && !race.isEmpty()) {
            query.setParameter("race", race);
        }
        if (chasseur != null && !chasseur.isEmpty()) {
            query.setParameter("chasseur", chasseur);
        }
        List<Pilote> liste = query.getResultList();

        for (Pilote pilote : liste) {
            GestionairePilote.majGrade(pilote);
        }
        
        if(grade != null && !grade.isEmpty()) {
            ArrayList<Pilote> resultat = new ArrayList<>();
            for(Pilote pilote: liste) {
                if(pilote.getGrade() == Grade.valueOf(grade))
                    resultat.add(pilote);
            }
            request.setAttribute("pilotes", resultat);
        }
        else
            request.setAttribute("pilotes", liste);
        

        //request.setAttribute("pilotes", liste);
        em.close();
        request.setAttribute("titre", "Liste des Pilotes");
        getServletContext().getRequestDispatcher("/WEB-INF/listePilotes.jsp").forward(request, response);
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
