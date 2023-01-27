/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package fr.ldnr.starwars.modele;

/**
 *
 * @author stag
 */
public enum Race {
    Chalactéen("Chalactéen"),
    Chis("Chis"),
    Humain("Humain"),
    Ithorien("Ithorien"),
    Mirialan("Mirialan"),
    KelDor("Kel'Dor"),
    Kiffar("Kiffar"),
    Miraluka("Miraluka"),
    Mirialen("Miralien"),
    Nagai("Nagai"),
    Neimoidien("Neimoidien"),
    Nikto("Nikto"),
    Noghri("Noghri"),
    Ongree("Ongree"),
    PauAn("Pau'an"),
    Quermien("Quermien"),
    Rakata("Rakata"),
    Rodien("Rodien"),
    Thisspasien("Thisspasien"),
    Togruta("Togruta"),
    Wookie("Wookie"),
    Wronian("Wronian"),
    Zabrak("Zabrak");
    
    private String label;
    
    private Race(String label) {
        this.label = label;
    } 

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
