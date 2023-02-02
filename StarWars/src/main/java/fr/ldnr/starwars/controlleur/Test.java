/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.ldnr.starwars.controlleur;

import fr.ldnr.starwars.modele.Chasseur;
import fr.ldnr.starwars.modele.EtatChasseur;
import fr.ldnr.starwars.modele.EtatPilote;
import fr.ldnr.starwars.modele.Mission;
import fr.ldnr.starwars.modele.ModeleChasseur;
import fr.ldnr.starwars.modele.Pilote;
import fr.ldnr.starwars.modele.Race;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Génère un jeu de données de démonstration.
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
@WebServlet(name = "Test", urlPatterns = {"/Test"})
public class Test extends HttpServlet {

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
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Mission").executeUpdate();
            em.getTransaction().commit();
            
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Pilote").executeUpdate();
            em.getTransaction().commit();
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Chasseur").executeUpdate();
            em.getTransaction().commit();
            em.getTransaction().begin();
            
            Mission mission1 = new Mission();
            mission1.setIntitule("Attaque de l'étoile de la mort");
            ArrayList<Chasseur> chasseursm1 = new ArrayList<>();
            chasseursm1.add(new Chasseur());
            chasseursm1.add(new Chasseur(ModeleChasseur.YWing, EtatChasseur.Operationnel));
            chasseursm1.add(new Chasseur());
            ArrayList<Pilote> pilotesm1 = new ArrayList<>();
            pilotesm1.add(new Pilote("Han", "Solo", 30, Race.Humain, EtatPilote.EnMission));
            pilotesm1.add(new Pilote("Saall", "Gani", 23, Race.Chalacteen, EtatPilote.EnMission));
            pilotesm1.add(new Pilote("Jiph", "Dinnath", 13, Race.Neimoidien, EtatPilote.EnMission));
            mission1.setPilotes(pilotesm1);
            for(int i=0; i<pilotesm1.size(); i++) {
                Pilote p = pilotesm1.get(i);
                Chasseur c = chasseursm1.get(i);
                p.setChasseur(c);
            }
            em.persist(mission1);
            
            Mission mission2 = new Mission();
            mission2.setIntitule("Reconnaissance");
            Chasseur chasseurm2 = new Chasseur(ModeleChasseur.ZWing, EtatChasseur.Operationnel);
            Pilote pilotem2 = new Pilote("Chroll", "Diraso", 30, Race.Humain, EtatPilote.EnMission);
            pilotem2.setChasseur(chasseurm2);
            mission2.getPilotes().add(pilotem2);
            em.persist(mission2);
            em.persist(new Chasseur(ModeleChasseur.XWing, EtatChasseur.EnMaintenance));
            em.persist(new Chasseur(ModeleChasseur.YWing, EtatChasseur.EnConstruction));
            em.persist(new Pilote("Colle", "Billaggoc", 25, Race.Humain, EtatPilote.EnFormation));
            em.persist(new Pilote("Chor", "Stol", 45, Race.Humain, EtatPilote.EnFormation));
            em.persist(new Pilote("Yigrouartodrr", "", 10, Race.Wookie, EtatPilote.EnFormation));
            em.persist(new Pilote("Kluch", "Jenk", 18, Race.Nikto, EtatPilote.EnFormation));
            em.persist(new Pilote("Yidred", "Higedal", 27, Race.Chalacteen, EtatPilote.Blesse));
            em.persist(new Pilote("Pwud", "Nhawmoll", 150, Race.Ithorien, EtatPilote.Decede));
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("##############################");
            System.err.println("Problème survenu : " + e);
        } finally {
            if (em != null) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                em.close();
            }
        }
        
        
        getServletContext()
                .getRequestDispatcher("/index.jsp")
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
