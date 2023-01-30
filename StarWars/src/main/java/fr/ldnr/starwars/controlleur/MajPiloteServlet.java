/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Chasseur;
import fr.ldnr.starwars.modele.EtatChasseur;
import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Grade;
import fr.ldnr.starwars.modele.ModeleChasseur;
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
@WebServlet(name = "MajPiloteServlet", urlPatterns = {"/MajPiloteServlet"})
public class MajPiloteServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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
        request.setCharacterEncoding("UTF-8");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = null;

        Grade grade = Grade.valueOf(request.getParameter("grade_pilote"));
        int id_chasseur = 0;
        boolean nvChasseur = !request.getParameter("modele").equals("");
        if (nvChasseur) {
            id_chasseur = Integer.parseInt(request.getParameter("modele"));
        }
        EtatPilote etat = null;
        if (request.getParameter("etat_pilote") != null) {
            etat = EtatPilote.valueOf(request.getParameter("etat_pilote"));
        }

        try {
            em = emf.createEntityManager();
            Pilote pilote = em.find(Pilote.class, Integer.parseInt(request.getParameter("id_pilote")));
            em.getTransaction().begin();
            pilote.setGrade(grade);
            if (nvChasseur) {
                if(pilote.possedeChasseur()) {
                    pilote.getChasseur().setEtat(EtatChasseur.Operationnel);
                    System.out.println("#######################");
                }
                if (id_chasseur == -1) {
                    pilote.setChasseur(null);
                } else {
                    Chasseur chasseur = em.find(Chasseur.class, id_chasseur);
                    pilote.setChasseur(chasseur);
                }
            }
            if (etat != null) {
                pilote.setEtat(etat);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("____________sout________________1");
        } finally {
            if (em != null) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }

        }
        getServletContext()
                .getRequestDispatcher("/ListePilotes")
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
