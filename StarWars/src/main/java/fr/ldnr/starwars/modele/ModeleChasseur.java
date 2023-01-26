/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
=======
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
>>>>>>> 1dcfb48c4d50b0366d93186f17aeefd02741247f
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum ModeleChasseur {

    XWing("X-Wing"),YWing("Y-Wing");
       
    private String label;

    private ModeleChasseur(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
