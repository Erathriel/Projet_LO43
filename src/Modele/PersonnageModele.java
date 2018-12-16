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
    public boolean isValider(){
        if(this.getPv()<=0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public void deplacement(){

    }

    public void reinitPa(){
        this.setPa(3);
    }

    public void passer(){
        this.setPa(0);
    } // A modifier plus tard avec un bouton je pense

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

    @Override
    public String toString() {
        return "PersonnageModele{" +
                "pv=" + pv +
                ", pa=" + pa +
                ", nom='" + nom + '\'' +
                ", jouable=" + jouable +
                '}';
    }
}
