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
 *
 * @author stag
 */
public class DateNaissance {
    
    private static LocalDate dateDuJour = new LocalDate();
    private LocalDate dateNaissance = new LocalDate(1997, 10, 05);
    
    public int getAge(){
        return Years.yearsBetween(dateDuJour, dateNaissance).getYears();
    }
}
