package Modele;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;

public class TuileModele {
    private int id;
    private int nbCase;
    private PlateauModele plateau;
    private ArrayList<TuileModele> tuileAccessible;
    private ArrayList<PersonnageModele> persOnTuile;
    private ArrayList<CaseModele> porteFermer;
    private CaseModele[][] compCase;


    // Contructeur
    public TuileModele(int id, int nbCase, ArrayList<TuileModele>  tuileAccessible,CaseModele[][] compCase,PlateauModele plateau) {
        this.id = id;
        this.nbCase = nbCase;
        this.tuileAccessible = tuileAccessible;
        this.compCase=compCase;
        this.plateau=plateau;
    }
    // Methode
    public void porteSurTuile(){
        this.porteFermer=new ArrayList<CaseModele>();
        for (CaseModele[] c:this.compCase) {
            for (CaseModele cp : c) {
                if (cp.containDoorLocked()) {
                    this.porteFermer.add(cp);
                }
            }
        }
    }
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
    public ArrayList<PersonnageModele> getPersOnTuile(){
        return this.persOnTuile;
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

    public ArrayList<TuileModele>  getTuileAccessible() {
        return tuileAccessible;
    }


    public CaseModele[][] getCompCase() {
        return compCase;
    }
    public void setTuileAccessible(){
        this.tuileAccessible=new ArrayList<TuileModele>();
        if(compCase[2][0].getPassable())
        {
            this.tuileAccessible.add(plateau.getCompTuile().get(this.id-4));
        }
        if(compCase[0][2].getPassable())
        {

            this.tuileAccessible.add(plateau.getCompTuile().get(this.id-2));
        }
        if(compCase[2][4].getPassable())
        {

            this.tuileAccessible.add(plateau.getCompTuile().get(this.id+3));
        }
        if(compCase[4][2].getPassable())
        {
            this.tuileAccessible.add(plateau.getCompTuile().get(this.id));
        }
    }
    public void setCompCase(CaseModele[][] compCase) {
        this.compCase = compCase;
    }
    public ArrayList<CaseModele> getPorteFermer(){return this.porteFermer;}
    @Override
    public String toString() {
        return "TuileModele{" +
                "id=" + id +
                ", nbCase=" + nbCase +
                ", compCase=" + compCase +
                '}';
    }
}
