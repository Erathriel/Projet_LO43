package Modele;

import java.util.ArrayList;

public class PileCarteModele {
    private int nbCarte;
    private ArrayList<CarteModele> listeCarte;

    // Constructeur
    public PileCarteModele() {
    }

    // Getters et Setters
    public int getNbCarte() {
        return nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public ArrayList<CarteModele> getListeCarte() {
        return listeCarte;
    }

    public void setListeCarte(ArrayList<CarteModele> listeCarte) {
        this.listeCarte = listeCarte;
    }
}
