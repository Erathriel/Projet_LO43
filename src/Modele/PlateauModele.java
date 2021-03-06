package Modele;

import java.util.ArrayList;

public class PlateauModele {
    private int nbTuile;
    private ArrayList<TuileModele> compTuile;

    // Contructeur
    public PlateauModele(int nbTuile) {
        this.nbTuile = nbTuile;
        this.compTuile = new ArrayList<TuileModele>();
    }

    // Getters et Setters
    public int getNbTuile() {
        return nbTuile;
    }

    public void setNbTuile(int nbTuile) {
        this.nbTuile = nbTuile;
    }

    public ArrayList<TuileModele> getCompTuile() {
        return compTuile;
    }

    public void setCompTuile(ArrayList<TuileModele> compTuile) {
        this.compTuile = compTuile;
    }

    @Override
    public String toString() {
        return "PlateauModele{" +
                "nbTuile=" + nbTuile +
                ", compTuile=" + compTuile +
                '}';
    }
}
