package Modele;

import java.awt.*;
import java.util.ArrayList;

public class PartieModele {
    private int tourActuel;
    private ArrayList<PersonnageModele> listePerso;
    private ArrayList<ObjectifModele> listeObjectif;

    // Contructeur
    public PartieModele() {
        this.tourActuel = 0;
        this.listeObjectif= null;
        this.listePerso=null;
    }

    // init

    public void init(){
        //test init
        Image img = null;
        this.tourActuel = 0;
        this.listeObjectif.add(new ObjectifModele( img, new CaseModele(1, 0, 0, false), false, 3));
        System.out.println(this.listeObjectif.get(0));
        this.listeObjectif.add(new ObjectifModele(img, new CaseModele(1,1,1,false),true, 2 ));
        this.listePerso.add(new EtudiantModele(null,null,10,3,"Geoffrey", false, 4, null, 6));
        this.listePerso.add(new ProfModele(null, null,10,3,"Clement",true,10));
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

    @Override
    public String toString() {
        return "PartieModele{" +
                "tourActuel=" + tourActuel +
                ", listePerso=" + listePerso +
                ", listeObjectif=" + listeObjectif +
                '}';
    }
}
