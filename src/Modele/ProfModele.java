package Modele;

import java.awt.*;

public class ProfModele extends PersonnageModele implements SpecialiteModele{
    private int exp;

    // Constructeur
    public ProfModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable, int  exp) {
        super(image, maCase, pv, pa, nom, jouable);
        this.exp=exp;
    }


    // Methodes

    public void fouiller(){

    }

    public void ouvriPorte(){

    }

    public void modifInventaire(){

    }

    public void activerObjectif(){

    }

    // Getters et Setters
    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
