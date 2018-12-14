package Modele;

import java.util.ArrayList;

public class TuileModele {
    private int id;
    private int nbCase;
    private TuileModele[] tuileAccessible;
    private ArrayList<CaseModele> compCase;

    // Contructeur
    public TuileModele(int id, int nbCase, TuileModele[] tuileAccessible) {
        this.id = id;
        this.nbCase = nbCase;
        this.tuileAccessible = tuileAccessible;
    }

    // Getters et Setters
    public int getNbCase() {
        return nbCase;
    }

    public void setNbCase(int nbCase) {
        this.nbCase = nbCase;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public TuileModele[] getTuileAccessible() {
        return tuileAccessible;
    }

    public void setTuileAccessible(TuileModele[] tuileAccessible) {
        this.tuileAccessible = tuileAccessible;
    }

    public ArrayList<CaseModele> getCompCase() {
        return compCase;
    }

    public void setCompCase(ArrayList<CaseModele> compCase) {
        this.compCase = compCase;
    }


}
