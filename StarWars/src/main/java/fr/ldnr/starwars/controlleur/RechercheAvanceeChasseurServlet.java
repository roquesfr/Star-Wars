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
 * Sert le formulaire de recherche avancée si pas de paramètre.
 * Sinon, génère intelligemment la requête JPQL correspondant aux paramètres
 * et la relaie à ListeChasseursServlet.
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
@WebServlet(name = "RechercheAvanceeChasseurServlet", urlPatterns = {"/rechercheAvanceeChasseur"})
public class RechercheAvanceeChasseurServlet extends HttpServlet {

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
        if (request.getParameter("recherche") == null) {
            request.setAttribute("titre", "Recherche Chasseurs");
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/rechercheAvanceeChasseur.jsp")
                    .forward(request, response);
        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("StarWarsPU");
            EntityManager em = null;
            TypedQuery<Chasseur> query = null;
            try {
                em = emf.createEntityManager();
                
                //pour pouvoir ajouter des conditions
                StringBuilder queryString = new StringBuilder("SELECT c FROM Chasseur c WHERE 1=1 ");

                String etat = "";
                String modele = "";
                ArrayList<EtatChasseur> etats = new ArrayList<>();
                ArrayList<ModeleChasseur> modeles = new ArrayList<>();
                
                //si on sélection un/des EtatChasseur
                for (EtatChasseur e : EtatChasseur.values()) {
                    etat = request.getParameter(e.toString());

                    if (etat != null && !etat.isEmpty()) {
                        etats.add(EtatChasseur.valueOf(etat));
                    }
                }
                //on ajoute à la requete
                if (!etats.isEmpty()) {
                    queryString.append(" AND c.etat IN :etats");
                }

                //si on sélection un/des ModeleChasseur
                for (ModeleChasseur m : ModeleChasseur.values()) {
                    modele = request.getParameter(m.toString());

                    if (modele != null && !modele.isEmpty()) {
                        modeles.add(ModeleChasseur.valueOf(modele));
                    }
                }
                //on ajoute à la requete
                if (!modeles.isEmpty()) {
                    queryString.append(" AND c.modele IN :modeles");
                }
                
                query = em.createQuery(queryString.toString(), Chasseur.class);

                if (!modeles.isEmpty()) {
                    query.setParameter("modeles", modeles);
                }
                if (!etats.isEmpty()) {
                    query.setParameter("etats", etats);
                }
            } catch (Exception e) {
                System.err.println("zut" + e.getMessage());

            } finally {
                if (em != null) {
                    if (em.getTransaction().isActive()) {
                        em.getTransaction().rollback();
                    }
                    request.setAttribute("query", query);
                    getServletContext()
                            .getRequestDispatcher("/chasseurs")
                            .forward(request, response);
                    em.close();
                }
            }

        }
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
