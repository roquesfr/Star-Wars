/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Grade;
import fr.ldnr.starwars.modele.ModeleChasseur;
import fr.ldnr.starwars.modele.Pilote;
import fr.ldnr.starwars.modele.Race;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "RechercheAvanceeServlet", urlPatterns = {"/rechercheAvanceePilote"})
public class RechercheAvanceePiloteServlet extends HttpServlet {

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
        if (request.getParameter("recherche") == null) {
            System.out.println("je redirige");
            request.setAttribute("titre", "Recherche Pilotes");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/rechercheAvanceePilote.jsp")
                    .forward(request, response);
        } else {
            System.out.println("je traite le formulaire");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
            EntityManager em = null;
            TypedQuery<Pilote> query = null;
            ArrayList<Grade> grades = new ArrayList<>();
            try {
                em = emf.createEntityManager();

                StringBuilder queryString = new StringBuilder("SELECT p FROM Pilote p WHERE 1=1");
                
                ArrayList<EtatPilote> etats = new ArrayList<>();
                
                ArrayList<ModeleChasseur> chasseurs = new ArrayList<>();
                String recherche = request.getParameter("recherche");
                String race = request.getParameter("race");
                String etat = "";
                String grade = "";
                String chasseur = "";

                if (recherche != null && !recherche.isEmpty()) {
                    queryString.append(" AND CONCAT(p.prenom,' ', p.nom) LIKE CONCAT('%', :recherche, '%')");
                }

                if (race != null && !race.isEmpty()) {
                    queryString.append(" AND p.race = :race");
                }

                for (EtatPilote e : EtatPilote.values()) {
                    etat = request.getParameter(e.toString());

                    if (etat != null && !etat.isEmpty()) {
                        etats.add(EtatPilote.valueOf(etat));
                    }
                }
                if (!etats.isEmpty()) {
                    queryString.append(" AND ");
                    queryString.append("p.etat IN :etats ");
                }

                for (ModeleChasseur c : ModeleChasseur.values()) {
                    chasseur = request.getParameter(c.toString());

                    if (chasseur != null && !chasseur.isEmpty()) {
                        chasseurs.add(ModeleChasseur.valueOf(chasseur));
                    }
                }

                if (!chasseurs.isEmpty()) {
                    queryString.append(" AND ");
                    queryString.append(" p.chasseur.modele IN :chasseurs ");
                }

                for (Grade g : Grade.values()) {
                    grade = request.getParameter(g.toString());

                    if (grade != null && !grade.isEmpty()) {
                        grades.add(Grade.valueOf(grade));
                    }
                }

                query = em.createQuery(queryString.toString(), Pilote.class);

                if (recherche != null && !recherche.isEmpty()) {
                    query.setParameter("recherche", recherche);
                }

                if (race != null && !race.isEmpty()) {
                    query.setParameter("race", Race.valueOf(race));
                }
                if (!etats.isEmpty()) {
                    query.setParameter("etats", etats);
                }

                if (!chasseurs.isEmpty()) {
                    query.setParameter("chasseurs", chasseurs);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                if (em != null) {
                    if (em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                    }
                    System.out.println(grades);
                    System.out.println(query.toString());
                    request.setAttribute("grades",grades);
                    request.setAttribute("query", query);
                    getServletContext()
                            .getRequestDispatcher("/pilotes")
                            .forward(request, response);
                    em.close();
                }
            }

        }
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
