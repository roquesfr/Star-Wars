/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Grade;
import fr.ldnr.starwars.modele.Pilote;
import fr.ldnr.starwars.modele.StatPilote;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        if (grade != null && !grade.isEmpty()) {
            queryString += " AND p.grade LIKE CONCAT('%', :grade, '%')";
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
        if (grade != null && !grade.isEmpty()) {
            query.setParameter("grade", grade);
        }
        if (chasseur != null && !chasseur.isEmpty()) {
            query.setParameter("chasseur", chasseur);
        }
        List<Pilote> liste = query.getResultList();
        
        Map<Pilote,StatPilote> map = new HashMap<>();
        int heureVol = 0;
        int nbMission = 0;
        int id_pilote;

        Query queryHV = em.createNamedQuery("HeureDeVolPourPilote",Integer.class);
        Query queryNBM = em.createNamedQuery("NbMissionPourPilote",Integer.class);

        for (Pilote pilote : liste) {
            id_pilote = pilote.getId_pilote();
            queryHV.setParameter("id_pilote",id_pilote);
            queryNBM.setParameter("id_pilote", id_pilote);
            try{
                heureVol = Integer.parseInt(queryHV.getSingleResult().toString());
            }
            catch (NullPointerException e){
                heureVol = 0;
            }
            nbMission = Integer.parseInt(queryNBM.getSingleResult().toString());
            
            StatPilote stat = new StatPilote(heureVol, nbMission);
            
            map.put(pilote,stat);
            
            heureVol=0;
            nbMission=0;
        }
        request.setAttribute("mapGradePilote", map);
        

        //request.setAttribute("pilotes", liste);
        em.close();
        request.setAttribute("titre", "Liste des Pilotes");
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
