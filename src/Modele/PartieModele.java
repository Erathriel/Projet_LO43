package Modele;

import java.awt.*;
import java.util.ArrayList;

public class PartieModele {
    private int tourActuel;
    private ArrayList<PersonnageModele> listePerso;
    private ArrayList<ObjectifModele> listeObjectif;
    private PileCarteModele pileCarte;

    // Contructeur
    public PartieModele() {
        this.tourActuel = 0;
        this.listeObjectif= null;
        this.listePerso=null;
        this.pileCarte=null;
    }

    // Getters et Setters
    public int getTourActuel() {
        return tourActuel;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public ArrayList<PersonnageModele> getListePerso() {
        return listePerso;
    }

    public void setListePerso(ArrayList<PersonnageModele> listePerso) {
        this.listePerso = listePerso;
    }

    public ArrayList<ObjectifModele> getListeObjectif() {
        return listeObjectif;
    }

    public void setListeObjectif(ArrayList<ObjectifModele> listeObjectif) {
        this.listeObjectif = listeObjectif;
    }

    public PileCarteModele getPileCarte() {
        return pileCarte;
    }

    public void setPileCarte(PileCarteModele pileCarte) {
        this.pileCarte = pileCarte;
    }

    @Override
    public String toString() {
        return "PartieModele{" +
                "tourActuel=" + tourActuel +
                ", listePerso=" + listePerso +
                ", listeObjectif=" + listeObjectif +
                '}';
    }
}
