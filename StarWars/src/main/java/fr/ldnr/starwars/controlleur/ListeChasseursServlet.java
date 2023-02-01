/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Chasseur;
import fr.ldnr.starwars.modele.EtatChasseur;
import fr.ldnr.starwars.modele.ModeleChasseur;
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
@WebServlet(name = "ListeChasseursServlet", urlPatterns = {"/chasseurs"})
public class ListeChasseursServlet extends HttpServlet {

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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
        EntityManager em = emf.createEntityManager();
        StringBuilder queryString = new StringBuilder("SELECT c FROM Chasseur c WHERE 1=1 ");
        TypedQuery<Chasseur> query;
        String etat = "";
        String modele = "";
        ArrayList<EtatChasseur> etats = new ArrayList<>();
        ArrayList<ModeleChasseur> modeles = new ArrayList<>();

        queryString.append("AND ");
        queryString.append("c.etat IN :etats");
        for (EtatChasseur e : EtatChasseur.values()) {
            etat = request.getParameter(e.toString());

            if (etat != null && !etat.isEmpty()) {
                etats.add(EtatChasseur.valueOf(etat));
            }
        }

        queryString.append(" AND ");
        queryString.append("c.modele IN :modeles");

        for (ModeleChasseur m : ModeleChasseur.values()) {
            modele = request.getParameter(m.toString());

            if (modele != null && !modele.isEmpty()) {
                modeles.add(ModeleChasseur.valueOf(modele));
            }
        }

        query = em.createQuery(queryString.toString(), Chasseur.class);
        if(modeles.isEmpty()){
            modeles.addAll(ModeleChasseur.getAll());
        }
        if(etats.isEmpty()){
            etats.addAll(EtatChasseur.getAll());
        }
        query.setParameter("modeles", modeles);
        query.setParameter("etats", etats);

        List<Chasseur> liste = query.getResultList();
        request.setAttribute("chasseurs", liste);
        em.close();

        request.setAttribute("titre", "Liste des Chasseurs");
        getServletContext().getRequestDispatcher("/WEB-INF/listeChasseurs.jsp").forward(request, response);
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
