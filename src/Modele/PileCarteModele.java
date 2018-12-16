package Modele;

import java.util.ArrayList;

public class PileCarteModele {
    private int nbCarte;
    private ArrayList<CarteModele> listeCarte;

    // Constructeur
    public PileCarteModele() {
        this.listeCarte=new ArrayList<CarteModele>();
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

    @Override
    public String toString() {
        return "PileCarteModele{" +
                "nbCarte=" + nbCarte +
                ", listeCarte=" + listeCarte +
                '}';
    }
}
