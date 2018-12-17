package Controleur;

import Vue.*;
import Modele.*;
import java.io.*;

public class PartieControlleur {
    private PartieModele mPartie;
    private PartieVue vPartie;

    // Constructeur
    public PartieControlleur(PartieModele mPartie, PartieVue vPartie) {
        this.mPartie = mPartie;
        this.vPartie = vPartie;
    }

    // Getters et Setters
    public PartieModele getmPartie() {
        return mPartie;
    }

    public void setmPartie(PartieModele mPartie) {
        this.mPartie = mPartie;
    }

    public PartieVue getvPartie() {
        return vPartie;
    }

    public void setvPartie(PartieVue vPartie) {
        this.vPartie = vPartie;
    }

}
