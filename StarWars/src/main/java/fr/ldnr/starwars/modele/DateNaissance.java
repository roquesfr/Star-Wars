/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.starwars.modele;




import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.Years;


/**
 * @deprecated 
 * Permet de gérer l'âge à partir de 
 * la date d'anniversaire d'un Pilote
 * et la date actuelle 
 * @author Pierre MORITZ, Thibault MASSÉ, Frédéric ROQUES
 */
public class DateNaissance {
    
    private static LocalDate dateDuJour = new LocalDate();
    private LocalDate dateNaissance = new LocalDate(1997, 10, 05);
    
    /**
     * Permet de calculer d'âge d'un Pilote
     * @return l'âge du Pilote 
     */
    public int getAge(){
        return Years.yearsBetween(dateDuJour, dateNaissance).getYears();
    }
}
