package Modele;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;

public class TuileModele {
    private int id;
    private int nbCase;
    private TuileModele[] tuileAccessible;
    private ArrayList<PersonnageModele> persOnTuile;
    private CaseModele[][] compCase;


    // Contructeur
    public TuileModele(int id, int nbCase, TuileModele[] tuileAccessible,CaseModele[][] compCase) {
        this.id = id;
        this.nbCase = nbCase;
        this.tuileAccessible = tuileAccessible;
        this.compCase=compCase;
    }
    // Methode
    public void setPersOnTuile(){
        this.persOnTuile=new ArrayList<PersonnageModele>();
        for (CaseModele[] c:this.compCase) {
            for (CaseModele cp : c){
               if(cp!=null) {
                   for (ElemCaseModele e : cp.getCompElemCase()) {
                       if (e instanceof PersonnageModele) {
                           this.persOnTuile.add(((PersonnageModele) e));
                       }
                   }
               }
            }
        }
    }
    public boolean tuileContainProf(){
        for (PersonnageModele p: this.persOnTuile) {
            if(p instanceof ProfModele)
            {
                return true;
            }
        }
        return false;
    }
    public boolean tuileContainEtu(){
        for (PersonnageModele p: this.persOnTuile) {
            if(p instanceof EtudiantModele)
            {
                return true;
            }
        }
        return false;
    }
    public CaseModele getCase(int x,int y){
        return this.getCompCase()[x][y];
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

    public CaseModele[][] getCompCase() {
        return compCase;
    }

    public void setCompCase(CaseModele[][] compCase) {
        this.compCase = compCase;
    }


    @Override
    public String toString() {
        return "TuileModele{" +
                "id=" + id +
                ", nbCase=" + nbCase +
                ", tuileAccessible=" + Arrays.toString(tuileAccessible) +
                ", compCase=" + compCase +
                '}';
    }
}
