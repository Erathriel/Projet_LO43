package Modele;

import java.awt.*;
import java.util.ArrayList;

public class PartieModele {
    private int tourActuel;
    private ArrayList<PersonnageModele> listePerso;
    private ArrayList<ObjectifModele> listeObjectif;
    private PileCarteModele pileCarte;
    private PlateauModele plateau;

    // Contructeur
    public PartieModele() {
        this.tourActuel = 0;
        this.listePerso = new ArrayList<PersonnageModele>();
        this.listeObjectif= new ArrayList<ObjectifModele>();
        this.pileCarte = new PileCarteModele();
        this.plateau = new PlateauModele(4); // nb tuile de 16 normalement 4 pour les test
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

    public PlateauModele getPlateau() {
        return plateau;
    }

    public void setPlateau(PlateauModele plateau) {
        this.plateau = plateau;
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
