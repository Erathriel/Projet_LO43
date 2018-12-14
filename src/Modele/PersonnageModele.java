package Modele;

import java.awt.*;

public abstract class PersonnageModele extends ElemCaseModele {
    private int pv;
    private int pa;
    private String nom;
    private boolean jouable;

    // Contructeur
    public PersonnageModele(Image image, CaseModele maCase, int pv, int pa, String nom, boolean jouable) {
        super(image, maCase);
        this.pv = pv;
        this.pa = pa;
        this.nom = nom;
        this.jouable = jouable;
    }

    // Methodes

    public void valider(){

    }

    public void deplacement(){

    }

    public void reinitPa(){

    }

    public void passer(){

    }

    // Getters et Setters
    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isJouable() {
        return jouable;
    }

    public void setJouable(boolean jouable) {
        this.jouable = jouable;
    }
}
